<template>
<div class="new-contest-container">
  <h1 class="new-contest-title">Contest Information</h1>
  <form class="new-contest-form" v-on:submit.prevent="submitForm">

    <!-- Name Field -->
    <div class="mb-3">
      <label for="inputName" class="form-label">Name</label>
      <input type="text" class="form-control" id="inputName" placeholder="Enter name" v-model="newContest.contestName" required/>
    </div>

    <!-- <div class="mb-3">
      
      <button @click="openUploadWidget">Upload Image</button>
      
      <label class="form-label" for="customFile">Contest Photo</label>
      <input type="file" class="form-control" id="customFile" />
    </div> -->
  
    <div class="mb-3">
    <!-- Display the uploaded image -->
    <img id="uploadedimage" v-if="newContest.contestImageUrl" :src="newContest.contestImageUrl" alt="Uploaded Image" required/>
    
  </div>
  <button class="btn btn-outline-secondary mt-2" @click="defineWidget($event)">Upload Image</button>

    
    <!-- Description Field -->
    <div class="mb-3">
      <label for="inputDescription" class="form-label">Description</label>
      <textarea class="form-control" id="inputDescription" rows="3" placeholder="Enter description"
        v-model="newContest.contestDescription" required></textarea>
    </div>

    <!-- Date and Time Field -->
    <div class="mb-3">
      <label for="inputLocation" class="form-label">Date</label>
      <input type="date" class="form-control" id="inputLocation" placeholder="Enter date"
        v-model="newContest.dateAndTime" required/>
    </div>

    <!-- Location Field -->
    <div class="mb-3">
      <label for="inputLocation" class="form-label">Location</label>
      <input type="text" class="form-control" id="inputLocation" placeholder="Enter location"
        v-model="newContest.contestLocation" required/>
    </div>

    <!-- Category Field -->
    <select class="form-select" v-model="newContest.contestCategoryName">
        <option value="" disabled selected>Category</option>
        <option v-for="option in options" v-bind:value="option.value" v-bind:key="option.value" required>{{option.value}}</option>
      </select>

    <!-- Submit Button -->
    <div class="btn-container">
      <button type="submit" class="btn btn-outline-primary">Submit</button>
      <button type="reset" class="btn btn-outline-danger">Reset</button>
    </div>
  </form>
</div>
</template>

<script>
import ContestsService from "../services/ContestsService";
import ErrorService from "../services/ErrorService";

export default {
  data() {
    return {
      contest: {},
      newContest: {
        contestId: '',
        contestName: '',
        contestDescription: '',
        dateAndTime: '',
        contestLocation: '',
        contestCategoryName: '',
        contestImageUrl: ''
      },
      myWidget: {},
      selectedValue: '',
      options: [
          { value: "Band", text: "Band" },
          { value: "Sports", text: "Sports" },
          { value: "Academic", text: "Academic" },
          { value: "Coding", text: "Coding" },
          { value: "Startup Pitches", text: "Startup Pitches" },
        ],
};
  },
  methods: {
    getContest(id) {
      ContestsService.fetchContestById(id)
        .then(response => {
          this.contest = response.data;
          this.newContest.contestName = this.contest.contestName;
          this.newContest.contestDescription = this.contest.contestDescription;
          this.newContest.dateAndTime = this.contest.dateAndTime;
          this.newContest.contestLocation = this.contest.contestLocation;
          this.newContest.contestId = this.contest.contestId;
          this.newContest.contestCategoryName = this.contest.contestCategoryName;
          this.newContest.contestImageUrl = this.contest.contestImageUrl;

        })
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
            this.newContest.contestImageUrl = result.info.secure_url;
          }
        }
      ).open();
    },

    submitForm() {
      if (this.newContest.contestId == 0) {
        ContestsService.createNewContest(this.newContest)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({ name: "contests" });
            }
          })
          .catch((error) => {
            ErrorService.handleErrorResponse(error, "creating");
          });
      } else {
        ContestsService.updateContest(this.newContest.contestId, this.newContest)
          .then((response) => {
            if (response.status == 200) {
              this.$router.push({ name: "contests" });
            }
          })
          .catch((error) => ErrorService.handleErrorResponse(error, "updating"));
      }
    },

  },
  created() {
    console.log('created');
    this.getContest(this.$route.params.contestId);
  }
};
</script>

<style scoped>
/* .new-contest-container {
  margin-top: 6%;
  margin-left: 20%;
  margin-right: 20%;
}
.new-contest-form {
  font-family: Lato, sans-serif;
  margin-left: 15%;
  margin-right: 15%;
}

.new-contest-title {
  font-family: Lato, sans-serif;
  text-align: center;
}

.btn-container {
  display: flex;
  justify-content: flex-start;
  margin-top: 10px;
}

.btn-container button {
  margin-right: 8px;
} */

.new-contest-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 5%;
  margin-left: 20%;
  margin-right: 20%;
}

.new-contest-form {
  font-family: Lato, sans-serif;
  margin: 0 15%;
  width: 70%; /* Adjust width as needed */
}

.new-contest-title {
  font-family: Lato, sans-serif;
  text-align: center;
}

.btn-container {
  display: flex;
  justify-content: flex-start;
  margin-top: 10px;
}

.btn-container button {
  margin-right: 8px;
}

/* Adjust image size as needed */
#uploadedimage {
  width: 100%; /* Make the image fill its container */
  max-width: 400px; /* Set a maximum width to avoid excessive scaling on larger screens */
  height: auto; /* Maintain aspect ratio */
  margin-top: 20px;
}


</style>