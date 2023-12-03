import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default{

    fetchContests(){
        return axios.get('/contests');
    },

    fetchParticipantsById() {
        return http.get(`/contests/${contestId}`);
    }
}