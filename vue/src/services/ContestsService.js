import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default{

    fetchContests(){
        return axios.get('/contests');
    },

    fetchParticipantsById(contestId) {
        return http.get(`/contests/${contestId}/participants`);
    },

    createNewContest(contest){
        return http.post('/contests', contest);
    },

    deleteContest(contestId){
        return http.delete(`/contests/${contestId}`);
    },

    fetchContestById(contestId){
        return http.get(`/contests/${contestId}`);
    }

    
}