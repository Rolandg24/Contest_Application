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
html {
  background-image: url("./assets/Draft_HomePic.png");

}

#capstone-app {

}

body {
background-color: whitesmoke;

}



</style>
