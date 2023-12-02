import axios from 'axios';

export default{

    fetchContests(){
        return axios.get('/contests');
    }


}