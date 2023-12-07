<template>
  <div class="OverallScores">
    <div class="OverallScores-container">
      <h1>{{ contest.contestName }}</h1>
      <a href="#" v-on:click="$router.push({ name: 'AddScore',params: { contestId: contest.contestId }})">Add Score</a>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Name</th>
            <th scope="col">Score</th>
          </tr>
        </thead>
        <tbody v-for="score in scores" v-bind:key="score.id">
          <tr >
            <td>{{ score.participantName }}</td>
            <td>{{ score.overallScore }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>


<script>
import ContestsService from "../services/ContestsService";
import ScoresService from "../services/ScoresService";

export default {
  data() {
    return {
      contestId: this.$route.params.contestId,
      scores: [],
      contest: {},
    };
  },
  created() {
    ContestsService.fetchContestById(this.contestId).then((response) => {
      this.contest = response.data;
    });
    ScoresService.fetchOverallScoresByContestId(this.contestId).then((response) => {
      this.scores = response.data;
    });
  },
};
</script>


<style>
.OverallScores {
  text-align: center;
}
.OverallScores-container {
  background-color: whitesmoke;
  text-align: center;
  margin-left: 10%;
  margin-right: 10%;
  margin-top: 1%;
  border-radius: 5px;
}
</style>