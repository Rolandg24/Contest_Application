<template>
   <div>
 <h1 class="new-contest-title">Edit Participant</h1>
  <form class="new-contest-form" v-on:submit.prevent="addParticipant">
    <!-- Name Field -->
    <div class="mb-3">
      <label for="inputName" class="form-label">Name</label>
      <input type="text" class="form-control" id="inputName" placeholder="Enter name" v-model="newParticipant.participantName" />
    </div>

    <!-- Description Field -->
    <div class="mb-3">
      <label for="inputDescription" class="form-label">Description</label>
      <textarea class="form-control" id="inputDescription" rows="3" placeholder="Enter description"
        v-model="newParticipant.participantDescription"></textarea>
    </div>

    <!-- Member Count -->
    <div class="mb-3">
      <label for="inputMemberCount" class="form-label">Member Count</label>
      <input type="number" class="form-control" id="inputLocation" placeholder="Enter member count"
        v-model="newParticipant.memberCount" />
    </div>

    <!-- Score -->
    <div class="mb-3">
      <label for="inputScore" class="form-label">Score</label>
      <input type="number" class="form-control" id="inputLocation" placeholder="Enter score"
        v-model="newParticipant.score"/>
    </div>

    <!-- Submit Button -->
    <div class="btn-container">
      <button type="submit" class="btn btn-primary">Submit</button>
      <button type="reset" class="btn btn-primary">Reset</button>
    </div>
  </form>
</div>
</template>

<script>
import ParticipantsService from '../services/ParticipantsService';
import ErrorService from '../services/ErrorService';

export default {

    data(){
        return {
            newParticipant: {contestId:this.$route.params.contestId },
            contestId: this.$route.params.contestId,
            participantId: this.$route.params.participantId
        }
    },
    methods: {
        addParticipant(){
            ParticipantsService.addParticipant(this.newParticipant, this.contestId)
            .then((response) => {
                    if (response.status == 201) {
                        this.$router.push({ name: "participants" });
                    }
                })
                .catch((error) => {
                    ErrorService.handleErrorResponse(error, "creating");
                });
        }
    },
    created() {
        ParticipantsService.fetchParticipantById(this.participantId).then((response) => {
            this.newParticipant = response.data;
        })
    }

}
</script>

<style>

</style>