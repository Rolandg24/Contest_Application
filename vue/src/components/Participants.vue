<template>
    <div>
  <div class="participants" v-for="participant in participants" v-bind:key="participant.participantId">
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

<style>

</style>