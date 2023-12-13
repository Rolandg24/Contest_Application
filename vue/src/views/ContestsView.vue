<template>
    <div>
        <participants />
        <contests-vue />
    </div>
</template>

<script>

import ContestsVue from '../components/Contests.vue';

import ContestsService from '../services/ContestsService';
import ParticipantsViewVue from './ParticipantsView.vue';
export default {
    components: {
        ContestsVue
    },
    methods: {
        getContest(id) {
            ContestsService.fetchContestById(id)
                .then(response => {
                    this.contest = response.data;
                })
        }

    },
}
</script>

<style>

</style>