<template>

<!-- IMAGE ON TOP TEMPLATE -->    
<!-- <div class="ParticipantContainer" >
    <div id="participant-card" class="card mb-3" v-for="participant in participants" v-bind:key="participant.participantId">
    <img src="../assets/1st_Draft_Logo.png" class="card-img-top" alt="placeholder">
    <div class="card-body">
        <h5 class="card-title">{{ participant.participantName }}</h5>
        <p class="card-text">Description: {{ participant.participantDescription }}</p>
        <p class="card-text"><small class="text-body-secondary">Member Count: {{ participant.memberCount }}</small></p>
    </div>
    </div>
</div> -->

<!-- IMAGE ON SIDE TEMPLATE --> 
<div id="participant-card" class="card mb-3" style="max-width: 540px;"  v-for="participant in participants" v-bind:key="participant.participantId">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="../assets/1st_Draft_Logo.png" class="img-fluid rounded-start" alt="placeholder">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">{{ participant.participantName }}</h5>
        <p class="card-text">Description: {{ participant.participantDescription }}</p>
        <p class="card-text"><small class="text-body-secondary">Member Count: {{ participant.memberCount }}</small></p>
      </div>
    </div>
  </div>
</div>

<!-- ORIGINAL -->
<!-- <div class="ParticipantInfo">
  <div class="ParticipantContainer" v-for="participant in participants" v-bind:key="participant.participantId">
    <h1>{{ participant.participantName }}</h1>
    <p>Description: {{ participant.participantDescription }}</p>
    <p>Member Count: {{ participant.memberCount }}</p>
  </div>
</div> -->

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
    grid-template-columns: 1fr 1fr 1fr;
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

#participant-card {
    margin-left: 10%;
}

</style>