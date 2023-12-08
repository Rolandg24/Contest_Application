<template>
<div class="add-score-container">
  <h1>Add Score</h1>
  <form v-on:submit.prevent="submitScore">
  <div class="form-group" >
        <div class="score-input-container">
            <select v-model="newScore.participantId">
                <option value="" disabled selected>Pick Participant</option>
                <option v-for="participant in participants" v-bind:value="participant.participantId" v-bind:key="participant.participantId">
                    {{participant.participantId}} : {{ participant.participantName }}
                </option>
            </select>
            <div class="input-group input-group-sm mb-3">
                <span class="input-group-text" id="inputGroup-sizing-sm">Score</span>
                <input type="text" v-model="newScore.overallScore" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
            </div>
        </div>
            <a href="#" class="btn btn-primary" v-on:click="submitScore">Submit</a>
        
    </div>
</form>
</div>
</template>

<script>
import ContestsService from '../services/ContestsService';
import ScoresService from '../services/ScoresService';
import ErrorService from '../services/ErrorService';
export default {
    data(){
        return {
            contestId: this.$route.params.contestId,
            participants: [],
            newScore: {
                contestId: this.$route.params.contestId,
                participantId:'',
                overallScore: ''
            },
        }
    },
    methods: {
        submitScore(){
            console.log('click')
            ScoresService.createNewScore(this.contestId, this.newScore)
                .then((response) => {
                    if (response.status == 201) {
                        this.$router.push({ name: "OverallScores" });
                    }
                })
                .catch((error) => {
                    ErrorService.handleErrorResponse(error, "creating");
                });
        }
    },

    created(){
        ContestsService.fetchParticipantsById(this.contestId).then((response) => {
            this.participants=response.data;

            console.log(response.data)
        })
        
    }
}
</script>

<style>
.add-score-container {
    font-family: Lato, sans-serif; 
    text-align: center;
}

.score-input-container {
    display: flex;
    align-items: baseline;
    margin-left: 30%;
    margin-right: 30%;
}
</style>