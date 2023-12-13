<template>
 <div class="add-participant-container">
 <h1 class="new-contest-title">Add New Participant</h1>
  <form class="new-contest-form" v-on:submit.prevent="addParticipant">
    <!-- Name Field -->
    <div class="mb-3">
      <label for="inputName" class="form-label">Name</label>
      <input type="text" class="form-control" id="inputName" placeholder="Enter name" v-model="newParticipant.participantName" />
    </div>

    <div class="mb-3">
    
    <!-- Display the uploaded image -->
    <img id = "uploadedimage" v-if="newParticipant.participantImageUrl" :src="newParticipant.participantImageUrl" alt="Uploaded Image" />
  </div>
  <button class="btn btn-outline-secondary" @click="defineWidget($event)">Upload Image</button>

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
      <button type="submit" class="btn btn-outline-primary">Submit</button>
      <button type="reset" class="btn btn-outline-danger">Reset</button>
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
            newParticipant: {
            contestId:this.$route.params.contestId,
            participantImageUrl: '',
            },
            contestId: this.$route.params.contestId
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
        },
        defineWidget(event) {
      event.preventDefault();
      const cloudName = "dmptbrbof";
      const uploadPreset = "bo89ohnn";
      this.myWidget = window.cloudinary.createUploadWidget(
        {
          cloudName: cloudName,
          uploadPreset: uploadPreset,
          // ... other options
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log("Done! Here is the image info: ", result.info);
            this.newParticipant.participantImageUrl = result.info.secure_url;
          }
        }
      ).open();
    },

    },

}
</script>

<style>
h1 {
  text-align: center;
  font-family: Lato, sans-serif;
}
.add-participant-container {
  margin-top: 5%;
  margin-left: 30%;
  margin-right: 30%;
}

.btn-container {
  display: flex;
  justify-content: flex-start;
  gap: 1%;
}
</style>