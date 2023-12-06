<template>
    <!-- <h1>HELLO</h1> -->
    <form v-on:submit.prevent="submitForm">
      
        <div class="mb-3">
            <label for="inputName" class="form-label">Name</label>
            <input type="text" class="form-control" id="inputName" placeholder="Enter name" v-model="newContest.contestName">
        </div>

        <div class="mb-3">
            <label for="inputDescription" class="form-label">Description</label>
            <textarea class="form-control" id="inputDescription" rows="3" placeholder="Enter description"
                v-model="newContest.contestDescription"></textarea>
        </div>

        <div class="mb-3">
            <label for="inputLocation" class="form-label">Date and Time</label>
            <input type="text" class="form-control" id="inputLocation" placeholder="Enter date and time"
                v-model="newContest.dateAndTime">
        </div>

     
        <div class="mb-3">
            <label for="inputLocation" class="form-label">Location</label>
            <input type="text" class="form-control" id="inputLocation" placeholder="Enter location"
                v-model="newContest.contestLocation">
        </div>

  
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</template>

<script>

import ContestsService from '../services/ContestsService';
import ErrorService from '../services/ErrorService';

export default {
    data() {
        return {
            newContest: {
                contestName: '',
                contestDescription: '',
                dateAndTime: '',
                contestLocation: '',
            }
        //    contestId: this.$route.params.contestId,
        //    contestToUpdate: this.$store.methods.grabContestFromStoreById(this.contestId)
       }     
    },
    methods: {
        submitForm() {
            console.log("button works");
            ContestsService.createNewContest(this.newContest)
                .then(response => {
                    console.log('hello?')
                    if (response.status == 201) {
                        console.log('got response');                    
                        this.$router.push({ name: 'contests' })
                    }
                }).catch(error => {
                    ErrorService.handleErrorResponse(error, 'created');

                });
        },
    }
}
</script>

<style></style>