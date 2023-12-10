import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import ContestsView from '../views/ContestsView.vue';
import ParticipantsView from '../views/ParticipantsView.vue';
import NewContestView from '../views/NewContestView.vue';
import UpdateContestView from '../views/UpdateContestView.vue';
import ScheduleView from '../views/ScheduleView.vue';
import NewScheduleView from '../views/NewScheduleView.vue';
import OverallScoresView from '../views/OverallScoresView.vue';
import AddScoreView from '../views/AddScoreView.vue';
import ContestDetailsView from '../views/ContestDetailsView.vue';
import EditScheduleView from '../views/EditScheduleView.vue';

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: false // turn this back on
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests',
    name: 'contests',
    component: ContestsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests/:contestId',
    name: 'participants',
    component: ParticipantsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests/newContest',
    name: 'NewContest',
    component: NewContestView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests/:contestId/update',
    name: 'UpdateContest',
    component: UpdateContestView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests/:contestId/schedule',
    name: 'Schedule',
    component: ScheduleView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests/:contestId/addSchedule',
    name: 'AddSchedule',
    component: NewScheduleView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests/:contestId/overallScores',
    name: 'OverallScores',
    component: OverallScoresView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests/:contestId/addScore',
    name: 'AddScore',
    component: AddScoreView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests/:contestId/contestDetails',
    name: 'ContestDetails',
    component: ContestDetailsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/contests/:contestId/editSchedule',
    name: 'EditSchedule',
    component: EditScheduleView,
    meta: {
      requiresAuth: false
    }
  },

];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
