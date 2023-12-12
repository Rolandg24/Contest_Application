<template>
   


  <div class="breadcrumbs">
    <router-link v-for="(breadcrumb, index) in breadcrumbs" :key="index" :to="breadcrumb.to">
      {{ breadcrumb.label }}
    </router-link>
  </div>
</template>

<script>
 export default {
  props: {
    routes: Array,
  },
  computed: {
    breadcrumbs() {
      const matchedRoutes = this.$route.matched;
      const breadcrumbs = [];

      for (const route of matchedRoutes) {
        if (route.meta && route.meta.breadcrumb) {
          breadcrumbs.push({
            to: route.path,
            label: route.meta.breadcrumb,
          });
        }
      }

      return breadcrumbs;
    },
  },
};
</script>

<style>

</style>



