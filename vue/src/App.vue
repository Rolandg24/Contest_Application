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
  background-color: whitesmoke;
  
}

body {
background-color: whitesmoke;

}



</style>
