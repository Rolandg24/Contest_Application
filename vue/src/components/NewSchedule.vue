<template>
<div class="add-schedule-container">
    <h1 class="add-schedule-title">Add Schedule</h1>
    <form class="participant-info" v-on:submit.prevent="submitSchedule">
            <div class="participant-container" v-for="(participant) in participants"
                v-bind:key="participant.participantId">
                <p>{{ participant.participantName }}</p>
                <input type="time" class="form-control" id="inputLocation" v-model="participant.timeSlot" />
            </div>
            <div class="d-flex justify-content-center pt-2 pb-2">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
    </form>
</div>
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
            },
            //to check if schedule exists
            schedule: []
        }
    },

    created() {
        ContestsService.fetchParticipantsById(this.contestId).then((response) => {
            this.participants = response.data;

            console.log(response.data)
        });
        ContestsService.fetchScheduleById(this.contestId).then((response) => {
            this.schedule = response.data;
        })

    },
    methods: {
        submitSchedule() {
            //check if schedule already exists
            if (this.schedule.length === 0) {
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
        } else {
            let schedules = this.participants.map(participant => {
                return {
                    contestId: this.contestId,
                    participantId: participant.participantId,
                    timeSlot: participant.timeSlot
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
            // Optionally, redirect or update UI after all schedules are submitted
        },
    },
}
</script>



<style scoped>
.participant-info{
    margin-left: 20%;
    margin-right: 20%;
}

.participant-container{
    display: grid;
    grid-template-columns: 1fr 1fr;
    justify-content: center;
}

.participant-container > P {
    text-align: right;
    padding-right: 10px;
}

.add-schedule-title {
    text-align: center;
}

.form-control {
    max-width: 125px;
}

.add-schedule-container{
    font-family: Lato, sans-serif;
}
</style>