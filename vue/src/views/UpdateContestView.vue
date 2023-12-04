<template>
  <update-contest-form v-bind:contest="contest" />
</template>

<script>
import UpdateContestForm from '../components/UpdateContestForm.vue';
import ContestsService from '../services/ContestsService';
export default {
  components: {
    UpdateContestForm
  },
  data() {
    return {
      contest: [],
    }
  },
  methods: {
    fetchContestById(id) {
      ContestsService.fetchContestById(id)
        .then(response => {
          this.contest = response.data;
        })
        .catch(error => {
          if (error.response) {
            if (error.response.status == 404) {
              //TODO make NotFoundView.vue for items like this below.
              this.$router.push({ name: 'NotFoundView' });
            } else {
              this.$store.commit('SET_NOTIFICATION',
                `Error getting contest information. Response received was "${error.response.statusText}".`);
            }
          } else if (error.request) {
            this.$store.commit('SET_NOTIFICATION', `Error getting contest information. Server could not be reached.`);
          } else {
            this.$store.commit('SET_NOTIFICATION', `Error getting contest information. Request could not be created.`);
          }
        })
    }
  },
  created(){
    this.fetchContestById(this.$route.params.contestId);
  }
}
</script>

<style scoped></style>
