import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default{
    /**
     * This function returns a list of all contests.
     * @returns a list of contests
     */
    fetchContests(){
        return axios.get('/contests');
    },

    /**
     * This function takes in a contest id and returns a list of 
     * participants from the specified contest.
     * @param {number} contestId the id of the contest 
     * @returns a list of participants
     */
    fetchParticipantsById(contestId) {
        return http.get(`/contests/${contestId}/participants`);
    },

    /**
     * This function creates a new contest and returns the created
     * contest.
     * @param {Object} contest 
     * @returns the created object
     */
    createNewContest(contest){
        return http.post('/contests', contest);
    },

    /**
     * This function takes in a contest id and deletes the contest
     * with that id.
     * @param {number} contestId 
     * @returns the number of rows deleted
     */
    deleteContest(contestId){
        return http.delete(`/contests/${contestId}`);
    },

    /**
     * This function takes in a contest id and returns the contest
     * with that id.
     * @param {number} contestId 
     * @returns the contest with the given contest id
     */
    fetchContestById(contestId){
        return http.get(`/contests/${contestId}`);
    },

    /**
     * This function takes in a contest id and a contest object
     * then updates the contest with the specified id.
     * @param {number} id 
     * @param {Object} contest 
     * @returns the updated contest
     */
    updateContest(id, contest){
        return http.put(`/contests/${id}/update`, contest);
    },

    /**
     * This function takes in a contest id then returns the schedule of
     * the contest with the specified id
     * @param {number} contestId 
     * @returns a contest schedule
     */
    fetchScheduleById(contestId){
        return http.get(`/contests/${contestId}/schedule`);
    },
    
    /**
     * This function takes in a schedule object and a contest id and creates a 
     * schedule for the contest with the specified id.
     * @param {object} schedule 
     * @param {number} contestId 
     * @returns the created schedule
     */
    createSchedule(schedule, contestId){
        return http.post(`/contests/${contestId}/schedule`, schedule);
    },

    /**
     * This function take in a schedule object and a contest id and updates
     * the schedule for the contest with the specified id.
     * @param {object} schedule 
     * @param {number} contestId 
     * @returns the updated schedule
     */
    updateSchedule (schedule, contestId){
        return http.put(`/contests/${contestId}/schedule/update`, schedule);
    },

}