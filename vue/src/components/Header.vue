<template>
    <!-- <div id="nav">
        
        <div class="left-links">
            <router-link  v-bind:to="{ name: 'home' }">
                <img class="logo" src="../assets/Gatherly_Logo2_HomeBtn.png" alt="Logo">
            </router-link>
            <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
            <router-link class="nav-link" v-bind:to="{ name: 'contests'}">Contests</router-link>
        </div>
        <div class="right-links">
            <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
            <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>
        </div>
    </div> -->

    <!-- <breadcrumbs-vue :routes="breadcrumbs"  /> -->
    <div id="nav">
    <div class="left-links">
      <!-- Logo and Home/Contest links -->
      <!-- <router-link v-bind:to="{ name: 'home' }"> -->
        <img class="logo" src="../assets/Gatherly_Logo.png" alt="Logo">
      <!-- </router-link> -->
      <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'contests' }">Contests</router-link>
    </div>
    <div class="right-links">
      <!-- Login/Logout link -->
      <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
      <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>
    </div>
  </div>
</template>

<script>
import BreadcrumbsVue from './Breadcrumbs.vue';


export default {
  components: {
    // BreadcrumbsVue,
  },
//   computed: {
//   breadcrumbs() {
//     const matchedRoutes = this.$route.matched;
//     const breadcrumbs = [];

//     for (let i = 0; i < matchedRoutes.length; i++) {
//       const route = matchedRoutes[i];

//       if (route.meta && route.meta.breadcrumb) {
//         breadcrumbs.push({
//           to: route.path,
//           label: route.meta.breadcrumb,
//         });
//       }

//       // Check if there are parents and add a separator
//       if (route.meta && route.meta.parent && i > 0) {
//         const parentRoute = matchedRoutes.find(
//           (r, index) => index < i && r.name === route.meta.parent
//         );

//         if (parentRoute) {
//           breadcrumbs.push({
//             separator: true,
//           });

//           breadcrumbs.push({
//             to: parentRoute.path,
//             label: parentRoute.meta.breadcrumb,
//           });
//         }
//       }
//     }

//     return breadcrumbs;
//   },
//     }
}
</script>

<style scoped>
#nav {
    color: white;
    text-decoration: none; 
    background-color: #009EE2;
    display: flex;
    position: fixed;
    width: 100vw;
    align-items: center;
    padding: 10px;
    padding-left: 20px;
    padding-right: 40px;
    
}
/* #nav {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  width: 100vw;
} */
.nav-link:hover {
    color: gold;
    text-decoration: none;
    transform: scale(1.05); 
}

.left-links {
    display: flex;
    font-family: 'Lato', sans-serif;
    font-size: 1.5em;
    font-weight: bold; 
    align-items: center;
    /* flex: 0 1 auto;  */
    margin-right: auto; 
    /* pushes it towards the left */
}

.right-links { 
    font-family: 'Lato', sans-serif;
    align-items: center;
    /* flex: 0 1 auto;
    text-align: right; */
     font-size: 1.5em;
    font-weight: bold; 
}

.logo {
    max-width: 20%;
    border-radius: 7px;
    margin-right: 4%;
}

@media screen and (max-width: 768px) {
    .left-links {
    font-size: .75em;
    }

    .right-links { 
     font-size: .75em; 
}
}
</style>