<template>
  <h1>Add Score</h1>
  <div class="form-group" v-on:submit.prevent="submitScore">
        <label for="salary">Participant:</label>
        <select v-model="newScore.selectedParticipant">
            <option v-for="participant in participants" v-bind:value="participant.participantName" v-bind:key="participant.participantId">{{participant.participantName}}</option>
            <input type="number" v-model="newScore.score" />
        </select>
        <div class="input-group input-group-sm mb-3">
            <span class="input-group-text" id="inputGroup-sizing-sm">Score</span>
            <input type="text" v-model="newScore.score" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>

</template>

<script>
import ContestsService from '../services/ContestsService';
import ScoresService from '../services/ScoresService';
export default {
    data(){
        return {
            newScore: {
                selectedParticipant: '',
                score: ''
            },
            
            contestId: this.$route.params.contestId,
            participants: []
        }
    },
    methods: {
        submitScore(){
            ScoresService.
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