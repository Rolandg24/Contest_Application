<template>
    <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li v-for="(crumb, index) in crumbs" :key="index" class="breadcrumb-item">
        <router-link :to="crumb.link" v-if="index < crumbs.length - 1">{{ crumb.text }}</router-link>
        <span v-else>{{ crumb.text }}</span>
      </li>
    </ol>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      crumbs: [],
    };
  },
  watch: {
    $route() {
      this.updateCrumbs();
    },
  },
  created() {
    this.updateCrumbs();
  },
  methods: {
    updateCrumbs() {
      const matchedRoutes = this.$route.matched;
      this.crumbs = matchedRoutes.map((route) => ({
        text: route.meta && route.meta.breadcrumb ? route.meta.breadcrumb : route.name,
        link: route.path,
      }));
    },
  },
};
</script>

<style>

</style>