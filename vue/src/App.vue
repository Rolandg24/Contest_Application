<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'contests' }">Contests</router-link>&nbsp;|&nbsp;
    </div>
    <router-view />
  </div>
</template>
<style scoped>
#nav {
  display: flex;
  justify-content: center;
  align-items: center;
}

#capstone-app {
  background-color: whitesmoke;
}

body {
background-color: whitesmoke;
}



</style>
