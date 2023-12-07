<template>
    <div id="nav">
        <div class="left-links">
            <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
            <router-link v-bind:to="{ name: 'contests' }">Contests</router-link>
        </div>
        <div class="right-links">
            <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token === ''">Login</router-link>
            <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>
        </div>
    </div>
</template>
<script></script>
<style scoped>
#nav {
    background-color: #009EE2;
    display: flex;
    align-items: center;
    padding: 10px;
}

.left-links {
    font-family: 'Lato', sans-serif;
    font-size: 1.5em;
    font-weight: bold; 
    flex: 0 1 auto; 
    margin-right: auto; /* pushes it towards the left */
}

.right-links {
    flex: 0 1 auto;
    text-align: right;
     font-size: 1.5em;
    font-weight: bold; 
}
</style>