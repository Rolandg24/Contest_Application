<template>
<!--SEARCH BAR-->
<form class="d-flex" role="search">
  <div class="form-group">
          <label for="salary">Filter by:</label>
          <select v-model="selectedValue">
            <option v-for="option in options" v-bind:value="option.value" v-bind:key="option.value">{{option.value}}</option>
          </select>
        </div>
        <input class="form-control me-2" type="search" placeholder="Filter" aria-label="Search" v-model="participantFilter">
</form>

<!-- IMAGE ON SIDE TEMPLATE --> 
<div class="ParticipantContainer">
<div id="participant-card" class="card mb-3" style="max-width: 540px;"  v-for="participant in filteredParticipants" v-bind:key="participant.participantId">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="../assets/1st_Draft_Logo.png" class="img-fluid rounded-start" alt="placeholder">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h4 class="card-title">{{ participant.participantName }}</h4>
        <p class="card-text">Description: {{ participant.participantDescription }}</p>
        <p class="card-text"><small class="text-body-secondary">Member Count: {{ participant.memberCount }}</small></p>
      </div>
    </div>
  </div>
</div>
</div>

</template>

<script>
import ContestsService from '../services/ContestsService';
export default {
    data(){
        return {
            contestId: this.$route.params.contestId,
            participants: [],
            participantFilter: '',
            selectedValue: '',
            options: [
                { value: "", text: "" },
                { value: "Name", text: "Name" },
                { value: "Description", text: "Description" },
                { value: "Member Count", text: "Member Count" },
              ],
        }
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
        ContestsService.fetchParticipantsById(this.contestId).then((response) => {
            this.participants=response.data;

            console.log(response.data)
        })
        
    }
}
</script>

<style scoped>
.ParticipantInfo {
    justify-content: center;
    align-items: center;
    background-color: whitesmoke;
}

.ParticipantContainer {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    margin: 4px;
    border-radius: 5px;
    padding: 10px;
    background-color:whitesmoke;
}

#participant-card {
    margin-left: 5%;
    margin-right: 5%;
}

.ParticipantContainer {
  background: whitesmoke;
}

.d-flex{
  padding-top: 15px;
  background: whitesmoke;

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


</style>

