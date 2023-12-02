<template>
<div>
  <div v-for="contest in contests" v-bind:key="contest.contestId">
    <h1>{{ contest.contestName }}</h1>
    <p>{{ contest.contestLocation }}</p>
    <p>{{ contest.dateAndTime }}</p>
  </div>
</div>
</template>

<script>
import ContestsService from '../services/ContestsService';
export default {
    data(){
        return {
            contests: []
        }
    },

    created(){
        ContestsService.fetchContests().then((response) => {
            this.contests=response.data;

            console.log(response.data)
        })
    }
}
</script>

<style>

</style>