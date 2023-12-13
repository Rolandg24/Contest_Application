<template>
  <div class="login-container">
    <div class="login-box">
      <form v-on:submit.prevent="login">
        <h1>Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <label for="username">Username:</label>
          <input type="text" id="username" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="password">Password:</label>
          <input type="password" id="password" v-model="user.password" required />
        </div>
        <button type="submit">Sign in</button>
        <p>
          <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link>
        </p>
      </form>
    </div>
  </div>
</template>


<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.login-container {
  font-family: Lato, sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #ddecf0;
}

.login-box {
  font-family: Lato, sans-serif;
  border: 1px solid #b2b0b0; /* Border around the form */
  padding: 65px;
  border-radius: 25px; /* optional: for rounded corners */
  background-color: rgb(212, 221, 245); /* optional: change as needed */
  box-shadow: 15px 10px 10px rgba(0, 0, 0, 0.1); /* optional: for shadow */
}

.form-input-group {
  font-family: Lato, sans-serif;
  margin-bottom: 1rem;
}

label {
  font-family: Lato, sans-serif;
  display: block; /* makes label take its own line */
  margin-bottom: 0.5rem;
}

input[type="text"], input[type="password"] {
  font-family: Lato, sans-serif;
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px; /* optional: for rounded input fields */
  box-sizing: border-box; /* for proper padding and width calculation */
}

button[type="submit"] {
  font-family: Lato, sans-serif;
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 5px;
  background-color: #007bff;
  color: white;
  cursor: pointer;
}

button[type="submit"]:hover {
  background-color: #0056b3;
}

p {
  font-family: Lato, sans-serif;
  text-align: center; /* centers the sign-up link */
}
</style>
