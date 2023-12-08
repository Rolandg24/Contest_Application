<template>
    <div class="contest-details">
        <div class="header">
            <h1>{{ contest.contestName }}</h1>
            <div class="date-time">Date & Time</div>
        </div>
        <div class="contest-image">
            <img src="../assets/1st_Draft_Logo.png" alt="Event Image">
        </div>
        <div class="description">
            <p>Event description goes here...</p>
        </div>
        <div class="location">
            <h2>{{contest.contestLocation}}</h2>
            <p>Event location details...</p>
            <!-- Optionally include a map here -->
        </div>
        <!-- Add more sections as needed -->
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
        }
    },
    created(){
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
</style>