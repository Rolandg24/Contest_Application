<template>
  <div class="OverallScores">
    <div class="OverallScores-container">
      <h1 class="title">{{ contest.contestName }} Overall Scores</h1>
      <a href="#" class="btn btn-outline-primary mt-2" v-on:click="$router.push({ name: 'AddScore',params: { contestId: contest.contestId }})" v-if="$store.state.token !== ''">Add Score</a>
      <!-- <table>
        <thead>
          <tr class="table-headers">
            <th>Name</th>
            <th>Score</th>
          </tr>
        </thead>
        <tbody >
          <tr v-for="score in scores" v-bind:key="score.id">
            <td>{{ score.participantName }}</td>
            <td>{{ score.overallScore }}</td>
          </tr>
        </tbody>
      </table> -->

      <div class="schedule-container">
        <table>
            <thead>
                <tr class="table-headers">
                    <th>Name</th>
                    <th>Score</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="score in scores" v-bind:key="score.id">
                    <td>{{ score.participantName }}</td>
                    <td>{{ score.overallScore }}</td>
                </tr>
            </tbody>
        </table>
    </div>

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
  font-family: Lato, sans-serif;
  text-align: center;
  margin-top: 5%;
}
.OverallScores-container {
  text-align: center;
  margin-left: 30%;
  margin-right: 30%;
  padding-top: 1%;
}

.table-headers {
  text-align: left;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    border: 1px solid #ddd;
    
}

th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
    font-family: 'Lato', sans-serif;
}

th {
    background-color: #009ee2;
    color: white;
    font-weight: bold;
    font-family: 'Lato', sans-serif;
}

tr:nth-child(even) {
    background-color: #69cbf536;
    font-family: 'Lato', sans-serif;
}

tr:nth-child(odd) {
    background-color: #ffffff;
}

tr:hover {
    background-color: #4fbeee71;
    /* Color change on hover */
    transform: scale(1.02);
    /* Slightly enlarges the row */
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    font-family: 'Lato', sans-serif;
    /* Adds a subtle shadow for depth */
}

@media screen and (max-width: 768px) {
  .OverallScores {
    font-family: Lato, sans-serif;
    text-align: center;
    margin-top: 15%;
    margin-left: 0%;
    margin-right: 0%;
  }

  .title {
    font-size: 14px; /* Specify the unit (e.g., pixels) */
  }
}
</style>