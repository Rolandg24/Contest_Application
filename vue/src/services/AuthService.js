import axios from 'axios';

const http = axios.create({
  baseURL: "https://contests-25a30e592cfc.herokuapp.com"
})

export default {

  login(user) {
    return http.post('/login', user)
  },

  register(user) {
    return http.post('/register', user)
  }

}
