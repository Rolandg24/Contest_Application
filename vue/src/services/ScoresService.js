import axios from 'axios';

const http = axios.create({
    baseURL: "https://contests-25a30e592cfc.herokuapp.com"
})

export default{
    /**
     * This function takes in a contest id and returns the 
     * overall scores for that contest in descending order
     * @param {number} contestId 
     * @returns a list of scores
     */
    fetchOverallScoresByContestId(contestId){
        return http.get(`/contests/${contestId}/overallScores`);
    },

    /**
     * This function takes in a contest id and a new score object and creates
     * a new score for the contest of the given contest id.
     * @param {number} contestId 
     * @param {Object} newScore 
     * @returns the new score
     */
    createNewScore(contestId, newScore){
        return http.post(`/contests/${contestId}/addOverallScores`, newScore);
    }

}
