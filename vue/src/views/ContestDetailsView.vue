<template>
    <div class="contest-description-container container my-6 mx-4" >
        <div class="participants-container">
            <participants />
        </div>
        <ContestDetails/>
        <schedule />
    </div>
</template>

<script>
import ContestDetails from '../components/ContestDetails.vue';
import Participants from '../components/Participants.vue';
import Schedule from '../components/Schedule.vue';
export default {
    components: {
        ContestDetails,
        Participants,
        Schedule
    },
}
</script>

<style scoped>
.contest-description-container{
    display: flex;
    align-items: flex-start;
    justify-content: space-around;
}

.participants-container {
    display: flex;
    flex-direction: column;
}

@media screen and (max-width: 768px) {
  .contest-description-container {
    display: flex;
    flex-direction: column;
  }

  .participants-container {
    order: 2; /* Change the order to 2 to move it below ContestDetails */
  }

  .contest-details-container {
    order: 1; /* Change the order to 1 to move it above Participants */
  }
}
</style>