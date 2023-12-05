<template>
  <form v-on:submit.prevent="submitForm">
    <!-- Name Field -->
    <div class="mb-3">
      <label for="inputName" class="form-label">Name</label>
      <input
        type="text"
        class="form-control"
        id="inputName"
        placeholder="Enter name"
        v-model="newContest.contestName"
      />
    </div>

    <!-- Description Field -->
    <div class="mb-3">
      <label for="inputDescription" class="form-label">Description</label>
      <textarea
        class="form-control"
        id="inputDescription"
        rows="3"
        placeholder="Enter description"
        v-model="newContest.contestDescription"
      ></textarea>
    </div>

    <!-- Date and Time Field -->
    <div class="mb-3">
      <label for="inputLocation" class="form-label">Date and Time</label>
      <input
        type="text"
        class="form-control"
        id="inputLocation"
        placeholder="Enter date and time"
        v-model="newContest.dateAndTime"
      />
    </div>

    <!-- Location Field -->
    <div class="mb-3">
      <label for="inputLocation" class="form-label">Location</label>
      <input
        type="text"
        class="form-control"
        id="inputLocation"
        placeholder="Enter location"
        v-model="newContest.contestLocation"
      />
    </div>

    <!-- Submit Button -->
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</template>

<script>
import ContestsService from "../services/ContestsService";

export default {
    props: {
        contest: {
            type: Object, 
            required: true
        }
    },
  data() {
    return {
      newContest: {
        contestId: this.contest.contestId,
        contestName: this.contest.contestName,
        contestDescription: this.contest.contestDescription,
        dateAndTime: this.contest.dateAndTime,
        contestLocation: this.contest.contestLocation,
      },
    };
  },
  methods: {
    submitForm() {
      if (this.newContest.contestId === 0) {
        ContestsService.createNewContest(this.newContest)
          .then((response) => {
            console.log("hello?");
            if (response.status == 201) {
              this.$router.push({ name: "contests" });
            }
          })
          .catch((error) => {
            this.handleErrorResponse(error);
          });
      } else {
        ContestsService.updateContest(this.newContest)
          .then((response) => {
            if (response.status === 200) {
              this.$router.push({ name: "contests" });
            }
          })
          .catch((error) => this.handleErrorResponse(error, "updating"));
      }
    },
    handleErrorResponse(error, verb) {
      if (error.response) {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFoundView" });
        } else {
          this.$store.commit(
            "SET_NOTIFICATION",
            `Error ${verb} contest. Response received was "${error.response.statusText}".`
          );
        }
      } else if (error.request) {
        this.$store.commit(
          "SET_NOTIFICATION",
          `Error ${verb} contest. Server could not be reached.`
        );
      } else {
        this.$store.commit(
          "SET_NOTIFICATION",
          `Error ${verb} contest. Request could not be created.`
        );
      }
    },
  }
};
</script>

<style></style>