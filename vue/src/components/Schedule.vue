<template>
    <div class="schedule-header">
    <h1>{{ this.contest.contestName }}</h1> 
    <h4>{{ this.contest.dateAndTime }}</h4>
    </div>
  <div class = "schedule-container">
    <div v-for="schedule in schedule" v-bind:key="schedule.id">
      <p>{{ schedule.participantName }} : {{ schedule.timeSlot }}</p>

    </div>
  </div>
</template>

<script>
import ContestsService from "../services/ContestsService";
export default {
    data(){
        return {
            contestId: this.$route.params.contestId,
            schedule: [],
            contest: {},
        }
    },

    created(){
        ContestsService.fetchScheduleById(this.contestId).then((response) => {
            this.schedule=response.data;

            console.log(response.data)
        }),
        ContestsService.fetchContestById(this.contestId).then((response) => {
            this.contest = response.data;
        })
        
    }
}
</script>

<style scoped>
.schedule-header {
    text-align: center; 
}
.schedule-container{
    text-align: center;
}
</style>