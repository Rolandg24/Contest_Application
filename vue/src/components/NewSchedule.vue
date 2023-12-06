<template>
    <div class="mb-3v" v-for="participant in participants" v-bind:key="participant.participantId">
      <label for="inputName" class="form-label">{{ participant.participantName }}</label>
      <input type="text" class="form-control" id="inputName" placeholder="Enter Time Slot" v-model="timeSlot" />
    </div>
</template>

<script>
import ContestsService from '../services/ContestsService';
import ErrorService from '../services/ErrorService';

export default {
    data(){
        return {
            contestsId: this.$route.params.contestsId,
            participants: [],
            timeSlot: '',

        }
    },
    created(){
        ContestsService.fetchParticipantsById(this.contestId).then((response) => {
            this.participants=response.data;

            console.log(response.data)
        })
        
    },
}






</script>



<style scoped></style>