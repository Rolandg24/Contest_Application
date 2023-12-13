<template>
  <div id="capstone-app">
    <HeaderView class="header-view"/>
  <!-- <breadcrumb-view /> -->
    <router-view />
  </div>
</template>
<script>
import HeaderView from './views/HeaderView.vue';
import BreadcrumbView from './views/BreadcrumbView.vue';
export default {
  components: {
    HeaderView,
    // BreadcrumbView
  }
}
</script>
<style scoped>
/* #nav {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  width: 100vw;
} */
html {
  background-image: url("./assets/Draft_HomePic.png");
}

/* html, body, #capstone-app {
  height: 100vh;
  width: 100vw;
  margin: 0;
  padding: 0;
} */

#capstone-app {
  display: flex;
  flex-direction: column;

}

/* body {
  background-color: whitesmoke;
  margin: 0;
  font-family: 'Lato', sans-serif;
} */

.header-view {
  position: fixed;
  top: 0;
  z-index: 1000; /* Adjust the z-index as needed */
}



</style>
