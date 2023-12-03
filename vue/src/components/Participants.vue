<template>
    <div class="ParticipantInfo">
  <div class="ParticipantContainer" v-for="participant in participants" v-bind:key="participant.participantId">
    <h1>{{ participant.participantName }}</h1>
    <p>Description: {{ participant.participantDescription }}</p>
    <p>Member Count: {{ participant.memberCount }}</p>
  </div>
</div>
</template>

<script>
import ContestsService from '../services/ContestsService';
export default {
    data(){
        return {
            contestId: this.$route.params.contestId,
            participants: []
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

<style scoped>
.ParticipantInfo {
    display: grid;
    justify-content: center;
    align-items: center;
    background-color: #FFF7D4;
}

.ParticipantContainer {

    margin: 4px;
    border-radius: 5px;
    padding: 10px;
    background-color: #FFD95A;
}
</style>