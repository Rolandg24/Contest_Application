<template>
  <HeaderView/>
  <div id="capstone-app">
    <router-view />
  </div>
</template>
<script>
import HeaderView from './views/HeaderView.vue';
export default {
  components: {
    HeaderView
  }
}
</script>
<style scoped>
#nav {
  display: flex;
  justify-content: center;
  align-items: center;
}

#capstone-app {
  background-image: url(../assets/1st_Draft_Logo.png);
  min-height: 100vh;
}

body {
background-color: whitesmoke;

}



</style>
