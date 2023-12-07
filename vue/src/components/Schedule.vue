<template>
    <div class="schedule-header">
        <h1>{{ this.contest.contestName }}</h1>
        <h4>{{ this.contest.dateAndTime }}</h4>
    </div>
    <div class="schedule-container">
        <table>
            <thead>
                <tr>
                    <th>Participant</th>
                    <th>Time Slot</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="schedule in schedule" v-bind:key="schedule.id">
                    <td>{{ schedule.participantName }}</td>
                    <td>{{ schedule.timeSlot }}</td>
                </tr>
            </tbody>
        </table>
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
    margin: auto;
    width: 20%; /* Adjust width as needed */
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

th {
    background-color: #009ee2; 
    color: whitesmoke;
    font-weight: bold;
}

tr:nth-child(even) {
    background-color:#69cbf536;
}

tr:nth-child(odd) {
    background-color: #ffffff; 
}

tr:hover {
    background-color: #4fbeee71; /* Color change on hover */
    transform: scale(1.03); /* Slightly enlarges the row */
    box-shadow: 0px 0px 10px rgba(0,0,0,0.1); /* Adds a subtle shadow for depth */
}
</style>