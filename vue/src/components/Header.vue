<template>
    <div id="nav">
        <div class="left-links">
            <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
            <router-link class="nav-link" v-bind:to="{ name: 'contests' }">Contests</router-link>
        </div>
        <div class="right-links">
            <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
            <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>
        </div>
    </div>
</template>
<script></script>
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
    /* flex: 0 1 auto;  */
    margin-right: auto; 
    /* pushes it towards the left */
}

.right-links { 
    font-family: 'Lato', sans-serif;
    /* flex: 0 1 auto;
    text-align: right; */
     font-size: 1.5em;
    font-weight: bold; 
}
</style>