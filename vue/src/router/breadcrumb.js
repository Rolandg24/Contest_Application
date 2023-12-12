// import { createRouter as createRouter, createWebHistory } from 'vue-router'
// import { useStore } from 'vuex'

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
import AddParticipantView from '../views/AddParticipantView.vue';
import EditParticipantView from '../views/EditParticipantView.vue';

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
        requiresAuth: false, // turn this back on
        breadcrumb: 'Home'
    },

      children: [ //children of HOME
        {
            path: "/login",
            name: "login",
            component: LoginView,
            meta: {
            requiresAuth: false,
            breadcrumb: 'Login'
            },
            
            children: [ //children of LOGIN
                {
                    path: "/register",
                    name: "register",
                    component: RegisterView,
                    meta: {
                      requiresAuth: false,
                      breadcrumb: 'Register'
                    }
                  }
            ]
        },
        {   //children of HOME
            path: "/logout",
            name: "logout",
            component: LogoutView,
            meta: {
            requiresAuth: false,
            breadcrumb: 'Logout'
            }
        },
        {
            path: '/contests',
            name: 'contests',
            component: ContestsView,
            meta: {
              requiresAuth: false,
              breadcrumb: 'Contests'
            },
            children: [ //children of CONTESTS
                {
                    path: '/contests/newContest',
                    name: 'NewContest',
                    component: NewContestView,
                    meta: {
                      requiresAuth: false,
                      breadcrumb: 'New Contest'
                    }
                  },
                  {
                    path: '/contests/:contestId/update',
                    name: 'UpdateContest',
                    component: UpdateContestView,
                    meta: {
                      requiresAuth: false,
                      breadcrumb: 'Update Contest'
                    }
                  },
                  {
                    path: '/contests/:contestId/addSchedule',
                    name: 'AddSchedule',
                    component: NewScheduleView,
                    meta: {
                      requiresAuth: false,
                      breadcrumb: 'Add Schedule'
                    }
                  },
                  {
                    path: '/contests/:contestId/contestDetails',
                    name: 'ContestDetails',
                    component: ContestDetailsView,
                    meta: {
                      requiresAuth: false,
                      breadcrumb: 'Contest Details'
                    },
                    children: [ //children of CONTESTS DETAILS
                    {
                        path: '/contests/:contestId/overallScores',
                        name: 'OverallScores',
                        component: OverallScoresView,
                        meta: {
                          requiresAuth: false,
                          breadcrumb: 'Scores'
                        },
                        children: [ //children of OVERALL SCORES
                            {
                                path: '/contests/:contestId/addScore',
                                name: 'AddScore',
                                component: AddScoreView,
                                meta: {
                                  requiresAuth: false,
                                  breadcrumb: 'Add Score'
                                }
                              }
                        ]
                      },
                      {
                        path: '/contests/:contestId',
                        name: 'participants',
                        component: ParticipantsView,
                        meta: {
                          requiresAuth: false,
                          breadcrumb: 'Participants'
                        },
                        children: [ //children of PARTICIPANTS
                            {
                                path: '/contests/:contestId/participants/add',
                                name: 'AddParticipant',
                                component: AddParticipantView,
                                meta: {
                                  requiresAuth: false,
                                  breadcrumb: 'Add Participant'
                                }
                              },
                            {
                                path: '/contests/:contestId/participants/:participantId/edit',
                                name: 'EditParticipant',
                                component: EditParticipantView,
                                meta: {
                                  requiresAuth: false,
                                  breadcrumb: 'Edit Participant'
                                }
                              }
                        ]
                      },
                      {
                        path: '/contests/:contestId/schedule',
                        name: 'Schedule',
                        component: ScheduleView,
                        meta: {
                          requiresAuth: false,
                          breadcrumb: 'Schedule'
                        },
                        children: [ //children of SCHEDULE
                            {
                                path: '/contests/:contestId/editSchedule',
                                name: 'EditSchedule',
                                component: EditScheduleView,
                                meta: {
                                  requiresAuth: false,
                                  breadcrumb: 'Edit Schedule'
                                }
                              }
                        ]
                      },
                      { //******NOT SURE IF THIS IS NEEDED******
                        path: '/contests/:contestId/addSchedule',
                        name: 'AddSchedule',
                        component: NewScheduleView,
                        meta: {
                          requiresAuth: false,
                          breadcrumb: 'Add Schedule'
                        }
                      },
                    ]
                  },
            ]
          }
      ]
    }
]