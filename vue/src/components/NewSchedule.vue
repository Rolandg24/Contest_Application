<template>
    <form v-on:submit.prevent="submitSchedule">
        <div class="ParticipantInfo">
            <div class="ParticipantContainer" v-for="participant in participants" v-bind:key="participant.participantId">
                <p>{{ participant.participantName }}</p>
                <input type="text" class="form-control" id="inputLocation" placeholder="Enter time slot" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</template>

<script>
import ContestsService from '../services/ContestsService';
import ErrorService from '../services/ErrorService';

export default {
    data() {
        return {
            contestId: this.$route.params.contestId,
            participants: []
        }
    },

    created() {
        ContestsService.fetchParticipantsById(this.contestId).then((response) => {
            this.participants = response.data;

            console.log(response.data)
        })

    },
    submitForm() {
      if (this.newContest.contestId == 0) {
        ContestsService.createNewContest(this.newContest)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({ name: "contests" });
            }
          })
          .catch((error) => {
            this.handleErrorResponse(error, "creating");
          });
      } else {
        ContestsService.updateContest(this.newContest.contestId, this.newContest)
          .then((response) => {
            if (response.status == 200) {
              this.$router.push({ name: "contests" });
            }
          })
          .catch((error) => ErrorService.handleErrorResponse(error, "updating"));
      }
    },

}
</script>



<style scoped>
.participant-container {
    display: flex;
}
</style>