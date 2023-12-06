<template>
    <form v-on:submit.prevent="submitSchedule">
        <div class="ParticipantInfo">
            <div class="ParticipantContainer" v-for="(participant) in participants"
                v-bind:key="participant.participantId">
                <p>{{ participant.participantName }}</p>
                <!-- <p v-bind="scheduleTimeSlotObject.participantId">{{ participant.participantId }}</p> -->
                <input type="text" class="form-control" id="inputLocation" placeholder="Enter time slot"
                    v-model="participant.timeSlot" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</template>

<script>
import ContestsService from '../services/ContestsService';
import ErrorService from '../services/ErrorService';

export default {
    data() {
        return {
            contestId: this.$route.params.contestId,
            participants: [],
            scheduleList: [],
            scheduleTimeSlotObject: {
                contestId: this.contestId,
                participantId: '',
                timeSlot: '',
            }
        }
    },

    created() {
        ContestsService.fetchParticipantsById(this.contestId).then((response) => {
            this.participants = response.data;

            console.log(response.data)
        })

    },
    methods: {
        submitSchedule() {
            // create an array of schedules using data from each participant
            let schedules = this.participants.map(participant => {
                return {
                    contestId: this.contestId,
                    participantId: participant.participantId,
                    timeSlot: participant.timeSlot
                };
            });
            schedules.forEach(schedule => {
                ContestsService.createSchedule(schedule, this.contestId)
                    .then(response => {
                        this.$router.push({ name: "Schedule" });
                    })
                    .catch(error => {
                        ErrorService.handleErrorResponse(error, "creating");
                    });
            });

            // Optionally, redirect or update UI after all schedules are submitted
        },
    },
}
</script>



<style scoped>
.participant-container {
    display: flex;
}
</style>