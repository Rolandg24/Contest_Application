<template>
    <div class="contest-description-container" >
        
            <participants class="participants" />
            <ContestDetails class="contest-details"/>
            <schedule class="schedule"/>
        
    </div>


     <!-- Pop-up confirmation message -->
 <div v-if="showConfirmation">
      <div class="popup">
        <p>Are you sure you want to leave? Reloading the page may cause unwanted errors.</p>
        <button @click="cancelLeave">Stay</button>
        <button @click="confirmLeave">Leave</button>
      </div>
    </div>
</template>

<script>
import ContestDetails from '../components/ContestDetails.vue';
import Participants from '../components/Participants.vue';
import Schedule from '../components/Schedule.vue';
export default {
  data(){
    return {
      showConfirmation: false
    }
  },
    components: {
        ContestDetails,
        Participants,
        Schedule
    },
    methods: {
      confirmLeave() {
      // Handle leaving the page (e.g., navigate to another route or perform cleanup)
      // ...
      this.showConfirmation = false;
    },
    cancelLeave() {
      this.showConfirmation = false;
    },
    showConfirmationMessage(event) {
      event.returnValue = "Are you sure you want to leave?";
    },
  },
  mounted() {
    window.addEventListener("beforeunload", this.showConfirmationMessage);
  },
  beforeUnmount() {
    window.removeEventListener("beforeunload", this.showConfirmationMessage);
  }
}
</script>

<style scoped>
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