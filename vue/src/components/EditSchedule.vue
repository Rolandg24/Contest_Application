<template>
  <h1>EDIT SCHEDULE</h1>
  <form class="participant-info" v-on:submit.prevent="updateSchedule">
            <div class="participant-container" v-for="(participant, index) in schedule"
                v-bind:key="index">
                <p>{{ participant.participantName }}</p>
                <input type="time" class="form-control" id="inputLocation" v-model="participant.timeSlot" />
            </div>
            <div class="d-flex justify-content-center pt-2 pb-2">
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
            schedule: [],
            participants: [],
        }
    },
    methods: {
        updateSchedule(){
            let schedules = this.schedule.map(timeSlot => {
                return {
                    contestId: timeSlot.contestId,
                    participantId: timeSlot.participantId,
                    timeSlot: timeSlot.timeSlot,
                    timeSlotId: timeSlot.timeSlotId
                };
            });
            schedules.forEach(schedule => {
                ContestsService.updateSchedule(schedule, this.contestId)
                    .then(response => {
                        this.$router.push({ name: "Schedule" });
                    })
                    .catch(error => {
                        ErrorService.handleErrorResponse(error, "updating");
                    });
            });
        }
    },
    created() {
        ContestsService.fetchScheduleById(this.contestId).then((response) => {
            this.schedule = response.data;
        });
        ContestsService.fetchParticipantsById(this.contestId).then((response) => {
            this.participants = response.data;

            console.log(response.data)
        })
    }
}
</script>

<style>

</style>