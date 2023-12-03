<template>
    <div>
    <router-link v-bind:to="{name: 'NewContest'}">Add Contest</router-link>
    <contests-vue />
</div>
</template>

<script>

import ContestsVue from '../components/Contests.vue'

export default {
    components: {
        ContestsVue
    }
}
</script>

<style>

</style>