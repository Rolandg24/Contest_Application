<template>
  <!-- <div class="header">
  </div> -->
  <div class="main-body">
    
    <router-link :to="{ name: 'contests' }">
      <figure id="logo-container" class="figure">
        <img id="logo" src="../assets/Gatherly_Logo.png" class="rounded mx-auto d-block" alt="...">
      </figure>
    </router-link>
    
  </div>


  <!-- <section class="bsb-cta-1 px-2 bsb-overlay" style="background-image: url('../assets/1st_Draft_HomePic.png');">
  <div class="container">
    <div class="row">
      <div class="col-12 col-md-9 col-lg-8 col-xl-7 col-xxl-6">
        <h2 class="fs-5 mb-3 text-white text-uppercase">Our Services & Expertise</h2>
        <h3 class="display-5 text-white mb-4">We are a design agency studio delivering custom creative & unique websites.</h3>
        <a href="#!" class="btn bsb-btn-2xl btn-light rounded mb-0 text-nowrap">Join Us</a>
      </div>
    </div>
  </div>
</section> -->


  <!-- <router-view/> -->
  <!-- <div class="footer"><p>You must be authenticated to see this</p></div> -->
  <!-- <div class="home">  
  </div> -->
</template>

<script>
export default {
};
</script>

<style scoped>
body {
  margin: 0;
  padding: 0;
  overflow: hidden; /* Add this line to hide overflow and prevent scrolling */
}

#logo {
  width: 50%
}

.home {
  text-align: center;
}

.header{
  background-color: #0064AC;
  font-family: Lato, sans-serif;
  font-weight: bold;
}

.main-body {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;

  background-image: url('../assets/1st_Draft_HomePic.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  background-size: cover;
  font-family: Lato, sans-serif;
  font-weight: bold;
}

.figure {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.figure-caption{
  color: white;
  font-family: Lato, sans-serif;
  font-weight: bold;
}

.home-page-banner {
  justify-content: center;
  max-width: 100%;
  height: 100vh;
  
}
/* .footer {
  background-color: #009EE2;
  font-family: Lato, sans-serif;
} */
</style>


