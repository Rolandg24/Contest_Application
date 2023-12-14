<template>
<div class="participants-container container">
<!--SEARCH BAR-->
<h1>Participants</h1>
<form class="d-flex" role="search">
  <div class="form-group">
          <select class="form-select" v-model="selectedValue">
            <option value="" disabled selected>Filter</option>
            <option v-for="option in options" v-bind:value="option.value" v-bind:key="option.value">{{option.value}}</option>
          </select>
        </div>
        <input class="form-control me-2" type="search" placeholder="Filter" aria-label="Search" v-model="participantFilter">
</form>
<div class="btn btn-outline-primary" id="add-participant"  v-if="$store.state.token !== ''">
  <router-link :to="{ name: 'AddParticipant' }">Add Participant</router-link>

</div>
<!-- IMAGE ON SIDE TEMPLATE --> 
  <div class="ParticipantContainer">
    <div id="participant-card" class="card mb-3" style="max-width: 540px;"  v-for="participant in filteredParticipants" v-bind:key="participant.participantId">
      <div class="row g-0">
        <div class="col-md-4">
          <img :src="participant.participantImageUrl" class="participant-img card-img-top" alt="placeholder" />
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h4 class="card-title">{{ participant.participantName }}</h4>
            <p class="card-text">Description: {{ participant.participantDescription }}</p>
            <p class="card-text"><small class="text-body-secondary">Member Count: {{ participant.memberCount }}</small></p>
          </div>
          <div class="edit-delete-btns">
            <div class="container1">
            <router-link class="btn btn-outline-warning" :to= "{ name: 'EditParticipant', params: {participantId: participant.participantId }}" v-if="$store.state.token !== ''">Edit</router-link>
            <button class="btn btn-outline-danger"  @click="deleteParticipant(participant.participantId)" v-if="$store.state.token !== ''">Delete</button>
          </div>
            <div class="container2">
            <img class="thumbs-up-blue" src="../assets/thumbs-up-blue.png" alt="thumbs-up-blue" @click="vote(participant.participantId)" v-if="!isImageClicked"/>
            <img class="thumbs-up-gray" src="../assets/thumbs-up-gray.png" alt="thumbs-up-blue" v-if="isImageClicked"/>
            <p class="votes">{{ participant.votes }}</p>
          </div>
          </div>
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
            isImageClicked: false,
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
    vote(id) {
      console.log('click');
      this.isImageClicked = true;
      console.log(this.isImageClicked);
      ParticipantsService.addVote(id).then(response => {
        console.log("got response" + response)
        this.fetchParticipants();
      })
      .catch((error) =>
            ErrorService.handleErrorResponse(error, "voting")
          );
      
    }
    },
    computed: {
  filteredParticipants() {
    const participants = this.participants;
    const filterText = this.participantFilter.toLowerCase(); // Convert input to lowercase

    return participants.filter((participant) => {
      if (this.selectedValue == 'Name') {
        return filterText == ""
          ? true
          : participant.participantName.toLowerCase().includes(filterText);
      } else if (this.selectedValue == 'Member Count') {
        return filterText == "" 
          ? true
          : participant.memberCount === parseInt(filterText, 10);
      } else if (this.selectedValue == 'Description') {
        return filterText == ""
          ? true
          : participant.participantDescription.toLowerCase().includes(filterText);
      } else {
        return true;
      }
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
.participants-container {
  margin-top: 6%;
  width: 30%;
}
.ParticipantInfo {
    justify-content: center;
    align-items: center;
    background-color: white;
}

.ParticipantContainer {
    display: grid;
    grid-template-columns: 1fr;
    border-radius: 5px;
    padding: 10px;
    background-color:white;
}

#participant-card {
    margin-left: 0%;
    margin-right: 0%;
}
.d-flex{
  padding-top: 15px;
  background: white;

}

.form-group {
  padding-left: 15px;
}
/* .card{

  box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
} */

/* .card:hover {
    background-color: #a9e2fa;
    transform: scale(1.03); 
    box-shadow: 0px 0px 10px rgba(0,0,0,0.1); 
} */

#add-participant {
    display: block;
    justify-content: center; /* Centers the button horizontally */
    align-items: center; /* Centers the button vertically (if needed) */
    width: 50%; /* Ensures the container takes the full width of its parent */
    margin-top: 10px;
    margin-bottom: 10px;
    margin-left: 110px;
    margin-right: 30px;
}
#add-participant:hover a {
    color: white;
}

.edit-delete-btns{
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 5px;
  margin-left: 10px;
}

.participant-img{
  height: 100%;
  object-fit: cover;
}
.container1 {
  display: flex;
  gap: 10px;
  margin-right: 10px;
  align-items: center;
  font-family: Lato, sans-serif;
}
.container2 {
  display: flex;
  gap: 10px;
  margin-right: 10px;
  align-items: center;
  font-family: Lato, sans-serif;
}

.votes {
  margin: 0px;
  
}

@media screen and (max-width: 768px) {
  .participants-container{
    /* margin-left: 10%;
    margin-right: auto; */
    width: 100%; /* Adjust the width as needed */
  }
}

</style>

