<template>
<!--SEARCH BAR-->
<h1>Participants</h1>
<form class="d-flex" role="search">
  <div class="form-group">
          <select v-model="selectedValue">
            <option value="" disabled selected>Filter</option>
            <option v-for="option in options" v-bind:value="option.value" v-bind:key="option.value">{{option.value}}</option>
          </select>
        </div>
        <input class="form-control me-2" type="search" placeholder="Filter" aria-label="Search" v-model="participantFilter">
</form>
<div class="btn btn-primary" id="add-participant"  v-if="$store.state.token !== ''">
  <router-link :to="{ name: 'AddParticipant' }" class="btn btn-primary" >Add Participant</router-link>

</div>
<!-- IMAGE ON SIDE TEMPLATE --> 
<div class="ParticipantContainer">
<div id="participant-card" class="card mb-3" style="max-width: 540px;"  v-for="participant in filteredParticipants" v-bind:key="participant.participantId">
  <div class="row g-0">
    <div class="col-md-4">
      <img :src="participant.participantImageUrl" class="card-img-top" alt="placeholder" />
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h4 class="card-title">{{ participant.participantName }}</h4>
        <p class="card-text">Description: {{ participant.participantDescription }}</p>
        <p class="card-text"><small class="text-body-secondary">Member Count: {{ participant.memberCount }}</small></p>
      </div>
      <div class="edit-delete-btns">
        <router-link class="btn btn-primary" :to= "{ name: 'EditParticipant', params: {participantId: participant.participantId }}" v-if="$store.state.token !== ''">Edit</router-link>
        <button class="btn btn-primary" @click="deleteParticipant(participant.participantId)" v-if="$store.state.token !== ''">Delete</button>
      </div>
    </div>
  </div>
</div>
</div>

</template>

<script>
import ContestsService from '../services/ContestsService';
import ParticipantsService from '../services/ParticipantsService';
import ErrorService from '../services/ErrorService';

export default {
    data(){
        return {
            contestId: this.$route.params.contestId,
            participants: [],
            participantFilter: '',
            selectedValue: '',
            options: [
                { value: "Name", text: "Name" },
                { value: "Description", text: "Description" },
                { value: "Member Count", text: "Member Count" },
              ],
            selectedParticipantId: '',
        }
    },
    methods: {
      deleteParticipant(id) {
        ParticipantsService.deleteParticipantById(id)
        .then((response) => {
            if (response.status === 200) {
              this.fetchParticipants();
              this.$router.push({ name: "participants" });
            }
          })
          .catch((error) =>
            ErrorService.handleErrorResponse(error, "deleting")
          );

      },
      fetchParticipants() {
      ContestsService.fetchParticipantsById(this.$route.params.contestId).then((response) => {
        this.$store.commit("SET_PARTICIPANTS", response.data);
        this.participants = response.data;
      });
    },
    },
    computed: {
      filteredParticipants() {
      const participants = this.participants;
      return participants.filter((participant) => {
        if (this.selectedValue == 'Name') {
        return this.participantFilter == ""
          ? true
          : participant.participantName.includes(this.participantFilter);
        }  else if(this.selectedValue == 'Member Count') {
        return this.participantFilter == ""
          ? true
          : participant.memberCount === parseInt(this.participantFilter, 10);
        } else if (this.selectedValue == 'Description') {
        return this.participantFilter == ""
          ? true
          : participant.participantDescription.includes(this.participantFilter);
        } else { return true}
      });
    },
    },
    created(){
        // ContestsService.fetchParticipantsById(this.contestId).then((response) => {
        //     this.participants=response.data;

        //     console.log(response.data)
        // })
        this.fetchParticipants();
        
    }
}
</script>

<style scoped>
.ParticipantInfo {
    justify-content: center;
    align-items: center;
    background-color: white;
}

.ParticipantContainer {
    display: grid;
    grid-template-columns: 1fr;
    margin: 4px;
    border-radius: 5px;
    padding: 10px;
    background-color:white;
}

#participant-card {
    margin-left: 5%;
    margin-right: 5%;
}
.d-flex{
  padding-top: 15px;
  background: white;

}

.form-group {
  padding-left: 15px;
}
.card{

  box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
}

.card:hover {
    background-color: #a9e2fa; /* Color change on hover */
    transform: scale(1.03); /* Slightly enlarges the row */
    box-shadow: 0px 0px 10px rgba(0,0,0,0.1); /* Adds a subtle shadow for depth */
}

#add-participant {
  display: block;
  width: 250px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 10px;
  margin-bottom: 10px;
}

.edit-delete-btns{
  display: flex;
  gap: 5px;
  margin-bottom: 5px;;
}

</style>

