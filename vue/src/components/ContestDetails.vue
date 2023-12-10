<template>
    <div class="contest-details">
        <!-- Header Section -->
        <div class="header">
            <h1>{{ contest.contestName }}</h1>
            <h3>
                <div class="date-time">{{ formatDate(contest.dateAndTime) }}</div>
            </h3>
        </div>

        <!-- Contest Image Section -->
        <div class="contest-image">
            <img src="../assets/1st_Draft_Logo.png" alt="Event Image">
        </div>

        <!-- Location Section -->
        <div class="location">
            <h2>{{ contest.contestLocation }}</h2>
            <p>Event location details...</p>
            <!-- Map would go here -->
        </div>

        <!-- Description Edit Section -->
        <div class="description">
            <textarea v-model="contest.description"></textarea>
            <button @click="saveDescription">Save</button>
        </div>
        <br>
        <br>
        <!-- Navigation Links Section -->
        <div class="link-container">
            <div class="container text-center">
                <div class="row row-cols-4">
                    <div class="col"><router-link
                            :to="{ name: 'OverallScores', params: { contestId: contest.contestId } }">Scores</router-link>
                    </div>
                    <div class="col"><router-link
                            :to="{ name: 'participants', params: { contestId: contest.contestId } }">Participants</router-link>
                    </div>
                    <div class="col"><router-link
                            :to="{ name: 'Schedule', params: { contestId: contest.contestId } }">Schedule</router-link>
                    </div>
                    <div class="col"><router-link
                            :to="{ name: 'AddSchedule', params: { contestId: contest.contestId } }">Add
                            Schedule</router-link></div>
                </div>
            </div>
        </div>
        <!-- Optionally, other sections as needed -->
    </div>
</template>
  
<script>
import ContestsService from '../services/ContestsService';

export default {
    data() {
        return {
            contestId: this.$route.params.contestId,
            contest: {},
        };
    },
    methods: {
        getContest() {
            ContestsService.fetchContestById(this.contestId)
                .then(response => {
                    this.contest = response.data;
                })
        },
        formatDate(dateTimeStr) {
            const date = new Date(dateTimeStr);
            const options = { year: 'numeric', month: 'numeric', day: 'numeric', hour: '2-digit', minute: '2-digit' };
            return date.toLocaleString('en-US', options);
        },
        saveDescription() {
            // Here you would typically make an API call to save the updated description
            ContestsService.saveContestDescription(this.contestId, this.contest.description)
                .then(response => {
                    // Handle the successful save
                    alert('Description saved successfully!');
                })
                .catch(error => {
                    // Handle errors
                    console.error('An error occurred while saving the description', error);
                });
        }

    },
    created() {
        this.getContest();

    }
}
</script>
  
<style>
.contest-details {
    font-family: Arial, sans-serif;
    max-width: 800px;
    margin: auto;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.header {
    text-align: center;
}

.contest-image img {
    width: 100%;
    height: auto;
    margin-top: 20px;
}

.description,
.location {
    margin-top: 20px;
}

h1,
h2 {
    color: #333;
}

.date-time {
    font-size: 18px;
    color: #666;
}

.description textarea {
    width: 100%;
    /* Full-width */
    height: 100px;
    /* Adjust the height as needed */
    padding: 10px;
    margin-top: 10px;
    box-sizing: border-box;
    /* To include padding in width */
    border: 1px solid #ccc;
    border-radius: 4px;
    resize: vertical;
    /* Allow vertical resizing, none to disable */
}

button {
    /* Styling for the save button */
    background-color: #009ee2;
    border: none;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    font-family: Lato, sans-serif;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 4px;
}
</style>