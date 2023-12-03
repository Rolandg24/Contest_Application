<template>
    <form v-on:submit.prevent="submitForm">
        <!-- Name Field -->
        <div class="mb-3">
            <label for="inputName" class="form-label">Name</label>
            <input type="text" class="form-control" id="inputName" placeholder="Enter name" v-model="newContest.name">
        </div>

        <!-- Description Field -->
        <div class="mb-3">
            <label for="inputDescription" class="form-label">Description</label>
            <textarea class="form-control" id="inputDescription" rows="3" placeholder="Enter description"
                v-model="newContest.description"></textarea>
        </div>

        <!-- Date and Time Field -->
        <div class="mb-3">
            <label for="inputLocation" class="form-label">Date and Time</label>
            <input type="text" class="form-control" id="inputLocation" placeholder="Enter date and time"
                v-model="newContest.dateAndTime">
        </div>

        <!-- Location Field -->
        <div class="mb-3">
            <label for="inputLocation" class="form-label">Location</label>
            <input type="text" class="form-control" id="inputLocation" placeholder="Enter location"
                v-model="newContest.location">
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</template>

<script>

import ContestsService from '../services/ContestsService';

export default {
    data() {
        return {

            newContest: {
                name: '',
                description: '',
                dateAndTime: '',
                location: '',
            }






        }
    },
    methods: {
        submitForm() {
            console.log(this.newContest);
            ContestsService.createNewContest(this.newContest)
                .then(response => {
                    if (response.status === 201) {
                                               
                        this.$router.push({ name: 'contests' })
                    }
                }).catch(error => {
                    this.handleErrorResponse(error);

                });

        },
        handleErrorResponse(error) {
            console.log(error);
            if (error.response) {
                this.errorMsg = 'Error adding new contest. Error: ' + error.response.status;
            }
            else if (error.request) {
                this.errorMsg = 'Error adding new contest. Error: server unavailable';
            }
            else {
                this.errorMsg = 'shits broke';
            }
        }
    }
}
</script>

<style></style>