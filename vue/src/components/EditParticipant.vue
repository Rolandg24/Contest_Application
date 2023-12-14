<template>
  <div class="edit-participant-container">
    <h1 class="new-contest-title">Edit Participant</h1>
    <form class="new-contest-form" v-on:submit.prevent="updateParticipant">
      <!-- Name Field -->
      <div class="mb-3">
        <label for="inputName" class="form-label">Name</label>
        <input
          type="text"
          class="form-control"
          id="inputName"
          placeholder="Enter name"
          v-model="newParticipant.participantName"
          required
        />
      </div>

      <div class="mb-3">
        <!-- Display the uploaded image -->
        <img
          id="uploadedimage"
          v-if="newParticipant.participantImageUrl"
          :src="newParticipant.participantImageUrl"
          alt="Uploaded Image"
          class="uploaded-image"
          required
        />
        
      </div>
      <button class="btn btn-outline-secondary" @click="defineWidget($event)">Upload Image</button>

      <!-- Description Field -->
      <div class="mb-3">
        <label for="inputDescription" class="form-label">Description</label>
        <textarea
          class="form-control"
          id="inputDescription"
          rows="3"
          placeholder="Enter description"
          v-model="newParticipant.participantDescription"
          required
        ></textarea>
      </div>

      <!-- Member Count -->
      <div class="mb-3">
        <label for="inputMemberCount" class="form-label">Member Count</label>
        <input
          type="number"
          class="form-control"
          id="inputLocation"
          placeholder="Enter member count"
          v-model="newParticipant.memberCount"
          required
        />
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
import ParticipantsService from "../services/ParticipantsService";
import ErrorService from "../services/ErrorService";

export default {
  data() {
    return {
      newParticipant: {
        participantId: "",
        participantName: "",
        participantDescription: "",
        memberCount: "",
        score: "",
        contestId: "",
      },
      contestId: this.$route.params.contestId,
      participantId: this.$route.params.participantId,
      myWidget: {},
    };
  },
  methods: {
    updateParticipant() {
      ParticipantsService.updateParticipantById(this.newParticipant)
        .then((response) => {
          if (response.status == 200) {
            console.log("git to router");
            this.$router.push({ name: "participants" });
          }
        })
        .catch((error) => {
          ErrorService.handleErrorResponse(error, "updating");
        });
    },
    defineWidget(event) {
      event.preventDefault();
      const cloudName = "dmptbrbof";
      const uploadPreset = "bo89ohnn";
      this.myWidget = window.cloudinary
        .createUploadWidget(
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
        )
        .open();
    },
  },
  created() {
    ParticipantsService.fetchParticipantById(
      this.$route.params.participantId
    ).then((response) => {
      this.newParticipant = response.data;
    });
  },
};
</script>

<style>

.uploaded-image {
  max-width: 100%;
  height: auto;
  margin-top: 10px;
}

h1 {
  text-align: center;
  font-family: Lato, sans-serif;
}
.edit-participant-container {
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