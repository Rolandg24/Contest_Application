<template>
    <!-- <div class="schedule-header">
        <h1>{{ this.contest.contestName }}</h1>
        <h4>{{ this.contest.dateAndTime }}</h4>
        <router-link :to="{ name: 'EditSchedule', params: { contestId: contest.contestId } }" class="btn btn-primary"  v-if="$store.state.token !== ''">Edit</router-link>
    </div> -->
    <div class="schedule-container">
        <h1>Schedule</h1>
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
                    <td>{{ formatTime(schedule.timeSlot) }}</td>
                </tr>
            </tbody>
        </table>
        <button class="btn btn-outline-primary mt-2" v-on:click=" $router.push({ name: 'AddSchedule', params: { contestId: contest.contestId }})" v-if="$store.state.token !== ''">Add Schedule</button>
    </div>
</template>

<script>
import ContestsService from "../services/ContestsService";
export default {
    data() {
        return {
            contestId: this.$route.params.contestId,
            schedule: [],
            contest: {},
        }
    },
    methods: {
        /**
         * This function takes in a time string and formats to 12-hour format with AM/PM.
         * It assumes that the input time string is in a 24-hour format (HH:mm) and converts it to a format like "10:30 AM" or "2:45 PM".
         * The function creates a new Date object with a fixed date and the provided time, then uses toLocaleTimeString to format it according to the specified options.
         * Note: This function does not handle time zones and assumes the time is in the local time zone.
         * @param {string} timeString - A string representing time in 24-hour format (e.g., "15:30" for 3:30 PM).
         * @returns {string} A string representing the formatted time in 12-hour format with AM/PM.
         */
        formatTime(timeString) {
            const options = { hour: 'numeric', minute: 'numeric', hour12: true };
            const time = new Date('1970-01-01T' + timeString);
            return time.toLocaleTimeString('en-US', options);
        }
    },
    created() {
        ContestsService.fetchScheduleById(this.contestId).then((response) => {
            this.schedule = response.data;

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
    font-family: 'Lato', sans-serif;
}

.schedule-container {
    text-align: center;
    /* margin: auto; */
    width: 20%;
    font-family: 'Lato', sans-serif;
    margin-top: 11%;
    margin-right: 4%;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20%;
}

th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
    font-family: 'Lato', sans-serif;
}

th {
    background-color: #009ee2;
    color: white;
    font-weight: bold;
    font-family: 'Lato', sans-serif;
}

tr:nth-child(even) {
    background-color: #69cbf536;
    font-family: 'Lato', sans-serif;
}

tr:nth-child(odd) {
    background-color: #ffffff;
}

tr:hover {
    background-color: #4fbeee71;
    /* Color change on hover */
    transform: scale(1.02);
    /* Slightly enlarges the row */
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    font-family: 'Lato', sans-serif;
    /* Adds a subtle shadow for depth */
}

@media screen and (max-width: 768px) {
    .schedule-container {
    
    margin-left: auto;
    margin-right: auto;
    width: 80%; /* Adjust the width as needed */
  }

  table {
    margin-top: 1%;
    margin-bottom: 15%;
  }
}
</style>