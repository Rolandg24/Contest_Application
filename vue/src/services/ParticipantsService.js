import axios from 'axios';

const http = axios.create({
    baseURL: "https://contests-25a30e592cfc.herokuapp.com"
})

export default{
    /**
     * This function takes in a participant and returns a participant.
     * @param {object} participant 
     * @param {number} contestId 
     * @returns the participant that was added
     */
    addParticipant(participant, contestId){
        return http.post(`/contests/${contestId}/participants/add`, participant);
    },

    /**
     * This function takes in a participant id and a contest id and then
     * returns the participant with the specified id from the specified contest.
     * @param {number} participantId 
     * @param {number} contestId 
     * @returns participant
     */
    fetchParticipantById(participantId, contestId) {
        return http.get(`/participants/${participantId}`);
    },

    /**
     * This function takes in a participant id and a contest id and then
     * deletes the participant with the specified id from the specified contest.
     * @param {number} participantId 
     * @param {number} contestId 
     * @returns nothing
     */
    deleteParticipantById(participantId) {
        return http.delete(`/participants/${participantId}`);
    },

    updateParticipantById(participant) {
        return http.put(`/participants/${participant.participantId}`, participant);
    }

}