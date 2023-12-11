import axios from 'axios';

export default{
    /**
     * This function takes in a participant and returns a participant.
     * @param {object} participant 
     * @param {number} contestId 
     * @returns the participant that was added
     */
    addParticipant(participant, contestId){
        return axios.post(`/contests/${contestId}/participants/add`, participant);
    },

    /**
     * This function takes in a participant id and a contest id and then
     * returns the participant with the specified id from the specified contest.
     * @param {number} participantId 
     * @param {number} contestId 
     * @returns participant
     */
    fetchParticipantById(participantId, contestId) {
        return axios.post(`/contests/${contestId}/participants/${participantId}`);
    },

    /**
     * This function takes in a participant id and a contest id and then
     * deletes the participant with the specified id from the specified contest.
     * @param {number} participantId 
     * @param {number} contestId 
     * @returns nothing
     */
    deleteParticipantById(participantId) {
        return axios.delete(`/participants/${participantId}`);
    }

}