<template>
  <h1 class="new-contest-title">Add New Contest</h1>
  <form class="new-contest-form" v-on:submit.prevent="submitForm">

    <!-- Name Field -->
    <div class="mb-3">
      <label for="inputName" class="form-label">Name</label>
      <input type="text" class="form-control" id="inputName" placeholder="Enter name" v-model="newContest.contestName" />
    </div>

    <!-- <div class="mb-3">
      
      <button @click="openUploadWidget">Upload Image</button>
      
      <label class="form-label" for="customFile">Contest Photo</label>
      <input type="file" class="form-control" id="customFile" />
    </div> -->
    
    <div class="mb-3">
    <button @click="openUploadWidget($event)">Upload Image</button>
    <!-- Display the uploaded image -->
    <img v-if="newContest.contestImageUrl" :src="newContest.contestImageUrl" alt="Uploaded Image" />
  </div>
    
    <!-- Description Field -->
    <div class="mb-3">
      <label for="inputDescription" class="form-label">Description</label>
      <textarea class="form-control" id="inputDescription" rows="3" placeholder="Enter description"
        v-model="newContest.contestDescription"></textarea>
    </div>

    <!-- Date and Time Field -->
    <div class="mb-3">
      <label for="inputLocation" class="form-label">Date</label>
      <input type="date" class="form-control" id="inputLocation" placeholder="Enter date"
        v-model="newContest.dateAndTime" />
    </div>

    <!-- Location Field -->
    <div class="mb-3">
      <label for="inputLocation" class="form-label">Location</label>
      <input type="text" class="form-control" id="inputLocation" placeholder="Enter location"
        v-model="newContest.contestLocation" />
    </div>

    <!-- Category Field -->
    <div class="mb-3">
      <label for="inputLocation" class="form-label">Category</label>
      <input type="text" class="form-control" id="inputLocation" placeholder="Enter Category"
        v-model="newContest.contestCategoryName" />
    </div>

    <!-- Submit Button -->
    <div class="btn-container">
      <button type="submit" class="btn btn-primary">Submit</button>
      <button type="reset" class="btn btn-primary">Reset</button>
    </div>
  </form>
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
      }
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
    openUploadWidget() {
      event.preventDefault();
      const widget = window.cloudinary.createUploadWidget(
        {
          cloud_name: "dmptbrbof", 
          upload_preset: "bo89ohnn"
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log("Done uploading ....". result.info);
              //  document
              // .getElementById("uploadedimage")
              // .setAttribute("src", result.info.secure_url);
          }
        }
      ).open();
    },
    // openUploadWidget(event) {
    //   event.preventDefault();
    //   const myWidget = cloudinary.createUploadWidget({
    //     cloudName: 'dmptbrbof', // Replace with your cloud name
    //     uploadPreset: 'bo89ohnn' // Replace with your upload preset
    //   }, (error, result) => {
    //     if (!error && result && result.event === "success") {
    //       console.log('Done! Here is the image info: ', result.info);
    //       this.newContest.contestImageUrl = result.info.url; // Store the image URL
    //     }
    //   });

    //   myWidget.open();
    // },
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
}
</style>