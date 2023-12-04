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
            <div>
                <a href="#">Preview Schedule</a> <!--TO DO DECIDE NEW WINDOW OR POPULATE INSIDE CONTAINER-->
            </div>
            <div>
                <a href="#">Update Contest</a>
            </div>
            <div>
                <a href="#" v-on:click="deleteContest(contest.contestId)">Delete</a>
            </div>


        </div>

    </div>
</template>

<script>
import ContestsService from '../services/ContestsService';
export default {
    data() {
        return {
            contests: [],
        }
    },

    created() {
        ContestsService.fetchContests().then((response) => {
            this.contests = response.data;

            console.log(response.data)
        })
    },
    methods: {
        deleteContest(contestId) {
            console.log(contestId)
            if (confirm("Are you sure you want to delete this message? This action cannot be undone.")) {
                ContestsService.deleteContest(contestId)
                    .then(response => {
                        if (response.status === 200) {
                            this.$router.push({ name: 'contests' });
                        }
                    })
                    .catch(error => this.handleErrorResponse(error, "deleting"));
            }
        },
        handleErrorResponse(error, verb) {
            if (error.response) {
                if (error.response.status == 404) {
                    this.$router.push({ name: 'NotFoundView' });
                } else {
                    this.$store.commit('SET_NOTIFICATION',
                        `Error ${verb} contest response received was "${error.response.statusText}".`);
                }
            } else if (error.request) {
                this.$store.commit('SET_NOTIFICATION', `Error ${verb} contest. Server could not be reached.`);
            } else {
                this.$store.commit('SET_NOTIFICATION', `Error ${verb} contest. Request could not be created.`);
            }
        },
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