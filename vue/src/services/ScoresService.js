import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
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
    }

}