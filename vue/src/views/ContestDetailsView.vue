<template>
    <div class="contest-description-container">
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
</style>