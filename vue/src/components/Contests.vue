<template>

  <!--SEARCH BAR-->
<div class="filter-container">
<form class="d-flex" role="search">
  <div class="form-group">
          <select v-model="selectedValue">
            <option value="" disabled selected>Filter</option>
            <option class="option" v-for="option in options" v-bind:value="option.value" v-bind:key="option.value">{{option.value}}</option>
          </select>
        </div>
        <input class="form-control me-2" type="search" placeholder="Filter" aria-label="Search" v-model="contestFilter">
</form>
</div>
<div class="btn btn-primary" id="add-contest"  v-if="$store.state.token !== ''">
  <router-link :to="{ name: 'NewContest' }" class="btn btn-primary">Add Contest</router-link>

</div>

  <div class="ContestInfo">
    
    <div class="card" style="width: 25rem" v-for="contest in filteredContests"
      v-bind:key="contest.contestId">
      <img src="../assets/1st_Draft_Logo.png" class="card-img-top" alt="placeholder" />
      <div class="card-body">
        <h3 class="card-title text-center" >{{ contest.contestName }}</h3>
        <h5 class="card-text text-center">Category: {{ contest.contestCategoryName }}</h5>
        <p class="card-text">Location: {{ contest.contestLocation }} <br>Date: {{ contest.dateAndTime }}</p>
        <div class="btn-container">
            <a href="#" v-on:click="sendToDetailsView(contest.contestId)" class="btn btn-primary">Details</a>
        </div>
            <div class="link-container">
                <a href="#" v-on:click=" $router.push({ name: 'AddSchedule', params: { contestId: contest.contestId }})" class="btn btn-primary" v-if="$store.state.token !== ''">Add Schedule</a>
                <router-link :to="{ name: 'UpdateContest', params: { contestId: contest.contestId } }" class="btn btn-primary" v-if="$store.state.token !== ''">Edit Contest</router-link>
                <a href="#" v-on:click="deleteContest(contest.contestId)" class="btn btn-primary" v-if="$store.state.token !== ''">Delete</a>
            </div>
      </div>
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
        }
    },
    computed: {
      filteredContests() {
        const contests = this.contests;
        return contests.filter((contest) => {
          if (this.selectedValue == 'Name') {
          return this.contestFilter == ""
            ? true
            : contest.contestName.includes(this.contestFilter);
          }  else if(this.selectedValue == 'Date') {
          return this.contestFilter == ""
            ? true
            : contest.dateAndTime.includes(this.contestFilter);
          } else if (this.selectedValue == 'Location') {
          return this.contestFilter == ""
            ? true
            : contest.contestLocation.includes(this.contestFilter);
          } else if (this.selectedValue == 'Category') {
          return this.contestFilter == ""
            ? true
            : contest.contestCategoryName.includes(this.contestFilter);
          }else { return true}
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
    }
  },
};
</script>

<style>
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
}

.link-container {
    display: flex;
    flex-direction: column;
}

.filter-container {
  padding-top: 1%;
  margin-left: 20%;
  margin-right: 20%;
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
</style>