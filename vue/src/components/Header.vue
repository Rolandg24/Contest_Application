<template>
    <div id="nav">
        
        <div class="left-links">
            <router-link  v-bind:to="{ name: 'home' }">
                <img class="logo" src="../assets/Gatherly_Logo.png" alt="Logo">
            </router-link>
            <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
            <router-link class="nav-link" v-bind:to="{ name: 'contests' }">Contests</router-link>
        </div>
        <div class="right-links">
            <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
            <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>
        </div>
    </div>
    <breadcrumb-view/>
    <!-- <div class="breadcrumb">
        <nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%236c757d'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Contests</li>
            </ol>
</nav>
    </div> -->
</template>

<script>
import BreadcrumbView from '../views/BreadcrumbView.vue';
export default {
    components: {
        BreadcrumbView
    }
}
</script>

<style scoped>
#nav {
    color: white;
    text-decoration: none; 
    background-color: #009EE2;
    display: flex;
    align-items: center;
    padding: 10px;
}

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
    margin-right: .5%;
}
</style>