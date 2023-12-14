<template>
    <div class="contest-description-container" >
        
            <participants class="participants" />
            <ContestDetails class="contest-details"/>
            <schedule class="schedule"/>
        
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
    justify-content: space-between;
    align-content: flex-start;
  }

  .participants {
    order: 2;
  }

  .contest-details {
    order: 1;
  }

  .schedule {
    order: 3;
  }
}
</style>