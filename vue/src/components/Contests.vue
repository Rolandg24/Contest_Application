<template>
<div class="contests-container">
  <h1 class="title">Contests</h1>  
    <!--SEARCH BAR-->
  <div class="filter-container">
  <form class="d-flex" role="search">
    <div class="form-group">
            <select class="form-select" v-model="selectedValue">
              <option value="" disabled selected>Filter</option>
              <option class="option" v-for="option in options" v-bind:value="option.value" v-bind:key="option.value">{{option.value}}</option>
            </select>
          </div>
          <input class="form-control me-2" type="search" placeholder="Filter" aria-label="Search" v-model="contestFilter">
  </form>
  </div>
  <div class="btn btn-outline-primary" id="add-contest"  v-if="$store.state.token !== ''">
    <router-link :to="{ name: 'NewContest' }" >Add Contest</router-link>

  </div>

    <!-- <div class="ContestInfo">
      
      <div class="card" style="width: 25rem" v-for="contest in filteredContests"
        v-bind:key="contest.contestId">
        <img :src="contest.contestImageUrl" class="card-img-top" alt="placeholder" />

        <div class="card-body">
          <h3 class="card-title text-center" >{{ contest.contestName }}</h3>
          <h5 class="card-text text-center">Category: {{ contest.contestCategoryName }}</h5>
          <p class="card-text">Location: {{ contest.contestLocation }} <br>Date: {{ contest.dateAndTime }}</p>
          <div class="btn-container">
              <a href="#" v-on:click="sendToDetailsView(contest.contestId)" class="btn btn-outline-primary">Details</a>
          </div>
              <div class="link-container">
                  <a href="#" v-on:click=" $router.push({ name: 'AddSchedule', params: { contestId: contest.contestId }})" class="btn btn-outline-success" v-if="$store.state.token !== ''">Add Schedule</a>
                  <router-link :to="{ name: 'UpdateContest', params: { contestId: contest.contestId } }" class="btn btn-outline-warning" v-if="$store.state.token !== ''">Edit Contest</router-link>
                  <a href="#" v-on:click="deleteContest(contest.contestId)" class="btn btn-outline-danger" v-if="$store.state.token !== ''">Delete</a>
              </div>
        </div>
      </div>  
    </div> -->

    <div class="row">
      <div v-for="contest in filteredContests" :key="contest.contestId" class="col-md-4 mb-4">
        <div class="card h-100">
          <img :src="contest.contestImageUrl" class="card-img-top custom-image" alt="placeholder">
          <div class="card-body">
            <h3 class="card-title text-center">{{ contest.contestName }}</h3>
            <h5 class="card-text text-center">Category: {{ contest.contestCategoryName }}</h5>
            <p class="card-text">Location: {{ contest.contestLocation }} <br>Date: {{ contest.dateAndTime }}</p>
            <div class="btn-container">
              <a href="#" @click="sendToDetailsView(contest.contestId)" class="btn btn-outline-primary">Details</a>
            </div>
            <div class="link-container">
              <!-- Add other buttons as needed -->
              <a href="#" v-on:click=" $router.push({ name: 'AddSchedule', params: { contestId: contest.contestId }})" class="btn btn-outline-success" v-if="$store.state.token !== ''">Add Schedule</a>
                  <router-link :to="{ name: 'UpdateContest', params: { contestId: contest.contestId } }" class="btn btn-outline-warning" v-if="$store.state.token !== ''">Edit Contest</router-link>
                  <a href="#" v-on:click="deleteContest(contest.contestId)" class="btn btn-outline-danger" v-if="$store.state.token !== ''">Delete</a>
            </div>
          </div>
        </div>
      </div>
    </div>
</div>


 <!-- Pop-up confirmation message -->
 <div v-if="showConfirmation">
      <div class="popup">
        <p>Are you sure you want to leave? Reloading the page may cause unwanted errors.</p>
        <button @click="cancelLeave">Stay</button>
        <button @click="confirmLeave">Leave</button>
      </div>
    </div>
</template>

<script>
import ContestsService from "../services/ContestsService";
import ErrorService from "../services/ErrorService";
export default {
  data(){
        return {
            contests: [],
            contestFilter: '',
            selectedValue: '',
            options: [
                { value: "Name", text: "Name" },
                { value: "Date", text: "Date" },
                { value: "Location", text: "Location" },
                { value: "Category", text: "Category" },
              ],
        showConfirmation: false,
        }
    },
    computed: {
  filteredContests() {
    const contests = this.contests;
    const filterText = this.contestFilter.toLowerCase();

    return contests.filter((contest) => {
      if (this.selectedValue == 'Name') {
        return filterText == "" ? true : contest.contestName.toLowerCase().includes(filterText);
      } else if (this.selectedValue == 'Date') {
        return filterText == "" ? true : contest.dateAndTime.toLowerCase().includes(filterText);
      } else if (this.selectedValue == 'Location') {
        return filterText == "" ? true : contest.contestLocation.toLowerCase().includes(filterText);
      } else if (this.selectedValue == 'Category') {
        return filterText == "" ? true : contest.contestCategoryName.toLowerCase().includes(filterText);
      } else {
        return true;
      }
    });
  },
},

  created() {
    this.fetchContests();
  },
  methods: {
    /**
     * This function accepts an id of a contest and then
     * calls the ContestService to delete the contest
     * @param {number} contestId the id of the contest
     */
    deleteContest(contestId) {
      console.log(contestId);
      if (
        confirm(
          "Are you sure you want to delete this message? This action cannot be undone."
        )
      ) {
        ContestsService.deleteContest(contestId)
          .then((response) => {
            if (response.status === 200) {
              this.fetchContests();
              this.$router.push({ name: "contests" });
            }
          })
          .catch((error) =>
            ErrorService.handleErrorResponse(error, "deleting")
          );
      }
    },
    fetchContests() {
      ContestsService.fetchContests().then((response) => {
        this.$store.commit("SET_CONTESTS", response.data);
        this.contests = response.data;
      });
    },
    sendToDetailsView(contestId) {
      this.$router.push({name: 'ContestDetails', params: {contestId}})
    },
    confirmLeave() {
      // Handle leaving the page (e.g., navigate to another route or perform cleanup)
      // ...
      this.showConfirmation = false;
    },
    cancelLeave() {
      this.showConfirmation = false;
    },
    showConfirmationMessage(event) {
      event.returnValue = "Are you sure you want to leave?";
    },
  },
  mounted() {
    window.addEventListener("beforeunload", this.showConfirmationMessage);
  },
  beforeUnmount() {
    window.removeEventListener("beforeunload", this.showConfirmationMessage);
  },
};
</script>

<style>
.title{
  text-align: center;
  font-family: Lato, sans-serif;
}
.contests-container {
  margin-top: 100px;
  margin-right: 5%;
  margin-left: 5%;
}
.ContestInfo {
  font-family: Lato, sans-serif;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 30px;
  justify-content: center;
  align-items: center;
  margin-left: 20%;
  margin-right: 20%;
}

.card:hover{
  box-shadow: 10px 20px 30px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
  transform: scale(1.03);
}

.ContestContainer {
  margin: 4px;
  border-radius: 5px;
  padding: 10px;
  background-color: #009ee2;
}

.btn-container {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
}

.link-container {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
}

.filter-container {
  padding-top: 1%;
  margin-left: 10%;
  margin-right: 10%;
  margin-bottom: 1%;
  
}

#add-contest {
  display: block;
  width: 250px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 10px;
  margin-bottom: 10px;
}

body {
  background-color: white;
}

.filter-label {
  font-family: Lato, sans-serif;
}

.options {
  font-family: Lato, sans-serif;
}

.custom-image {
  height: 200px; /* Set your desired height */
  object-fit: cover; /* Ensure the image covers the specified height */
}

.popup {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: white;
  padding: 20px;
  border: 1px solid #ccc;
}
@media screen and (max-width: 768px) {
  .filter-container {
  padding-top: 1%;
  margin-bottom: 1%;
}

.contests-container {
  margin-top: 50px;
  margin-right: 5%;
  margin-left: 5%;
}

}
</style>