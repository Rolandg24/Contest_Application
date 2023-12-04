<template>
    <div class="ContestInfo">

        <div class="ContestContainer" v-for="contest in $store.state.contests" v-bind:key="contest.contestId">
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
                <a href="#" v-on:click="$router.push({ name: 'UpdateContest', params: {contestId: contest.contestId} })">Update</a>
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
        // return {
        //     contests: [],
        // }
    },

    created() {
        this.fetchContests();
    },
    methods: {
        deleteContest(contestId) {
            console.log(contestId)
            if (confirm("Are you sure you want to delete this message? This action cannot be undone.")) {
                ContestsService.deleteContest(contestId)
                    .then(response => {
                        if (response.status === 200) {
                            this.fetchContests();
                            this.$router.push({ name: 'contests' });
                        }
                    })
                    .catch(error => this.handleErrorResponse(error, "deleting"));
            }
        },
        fetchContests(){
            ContestsService.fetchContests()
            .then(response=>{
                this.$store.commit('SET_CONTESTS', response.data);
            });
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