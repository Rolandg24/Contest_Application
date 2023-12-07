<template>
  <h1>Add Score</h1>
  <form v-on:submit.prevent="submitScore">
  <div class="form-group" >
        <label for="salary">Participant:</label>
        <select v-model="newScore.participantId">
            <option v-for="participant in participants" v-bind:value="participant.participantId" v-bind:key="participant.participantId">
                {{participant.participantId}} : {{ participant.participantName }}
            </option>
        </select>
        <div class="input-group input-group-sm mb-3">
            <span class="input-group-text" id="inputGroup-sizing-sm">Score</span>
            <input type="text" v-model="newScore.overallScore" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
        </div>
        <a href="#" v-on:click="submitScore">Submit</a>
    </div>
</form>

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

</style>