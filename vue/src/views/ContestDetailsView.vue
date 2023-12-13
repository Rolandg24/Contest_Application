<template>
    <div class="contest-description-container" >
        <div class="participants-container">
            <participants />
        </div>
        <div class="contest-details-container">
            <ContestDetails/>
        </div>
        <div class="schedule-container">
            <schedule />
        </div>
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
/* .contest-description-container{
    display: flex;
    align-items: flex-start;
    justify-content: space-around;
}

.participants-container {
    display: flex;
    flex-direction: column;
} */

.contest-description-container {
  display: flex;
  justify-content: space-between; 
}

.contest-details-container{
  margin: 0%;
}



@media screen and (max-width: 768px) {
  .contest-description-container {
    display: flex;
    flex-direction: column;
    margin: auto;
  }

  .participants-container {
    order: 2; /* Move it below ContestDetails */
  }

  .contest-details-container {
    order: 1; /* Move it above Participants */
    grid-column: span; /* Reset grid-column to span full width */
  }

  .schedule-container {
    order: 3; /* Maintain the order for the schedule container */
  }
}
</style>