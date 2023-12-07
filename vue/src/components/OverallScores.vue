<template>
  <div class="OverallScores">
    <div class="OverallScores-container">
      <h1>CONTEST NAME</h1>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Name</th>
            <th scope="col">Score</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Team Alpha</td>
            <td>98</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>


<script>
import ContestsService from "../services/ContestsService";

export default {
  data() {
    return {};
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