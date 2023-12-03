<template>
    <div class="ContestInfo">

        <div class="ContestContainer" v-for="contest in contests" v-bind:key="contest.contestId">
            <h1>{{ contest.contestName }}</h1>
            <p>{{ contest.contestLocation }}</p>
            <p>{{ contest.dateAndTime }}</p>
            <div>
                <router-link
                    v-bind:to="{ name: 'participants', params: { contestId: contest.contestId } }">Participants</router-link>
            </div>
        </div>

    </div>
</template>

<script>
import ContestsService from '../services/ContestsService';
export default {
    data() {
        return {
            contests: []
        }
    },

    created() {
        ContestsService.fetchContests().then((response) => {
            this.contests = response.data;

            console.log(response.data)
        })
    }
}
</script>

<style>
.ContestInfo {
    display: grid;
    justify-content: center;
    align-items: center;
    background-color: #FFF7D4;
}

.ContestContainer {

    margin: 4px;
    border-radius: 5px;
    padding: 10px;
    background-color: #FFD95A;
}


</style>