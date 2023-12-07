<template>
    <div>
        
        <contests-vue />
    </div>
</template>

<script>

import ContestsVue from '../components/Contests.vue';
import ContestsService from '../services/ContestsService';
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

<style></style>