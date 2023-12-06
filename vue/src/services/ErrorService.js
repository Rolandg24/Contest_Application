export default {
    /**
     * This function takes in an error object and a string string verb
     * of the action taking place and handles the response.
     * @param {Object} error 
     * @param {string} verb 
     */
    handleErrorResponse(error, verb) {
        if (error.response) {
            if (error.response.status == 404) {
                this.$router.push({ name: 'NotFoundView' });
            } else {
                this.$store.commit('SET_NOTIFICATION',
                    `Error ${verb} contest response received was "${error.response.statusText}".`);
            }
        } else if (error.request) {
            this.$store.commit('SET_NOTIFICATION', `Error ${verb} contest. Server could not be reached.`);
        } else {
            this.$store.commit('SET_NOTIFICATION', `Error ${verb} contest. Request could not be created.`);
        }
    },
}