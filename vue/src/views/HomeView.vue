<template>
  <div class="header">
    <p>breadcrumb placeholder</p>
  </div>
  <div class="main-body">
    
    <figure id="logo-container" class="figure">
      <img id="logo" src="../assets/Gatherly_Logo.png" class="rounded mx-auto d-block" alt="...">
      <figcaption class="figure-caption text-center">Awesome catchphrase!</figcaption>
    </figure>

  </div>
  <div class="footer"><p>You must be authenticated to see this</p></div>
  <div class="home">  
  </div>
</template>

<script>
export default {
};
</script>

<style scoped>

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


