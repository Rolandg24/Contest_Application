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

}