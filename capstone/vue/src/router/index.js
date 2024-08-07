import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import Rent from '../views/Rent.vue'
import BrowseProperties from '../views/BrowseProperties.vue'
import MaintenanceList from '../components/MaintenanceList.vue'
import MaintenanceForm from '../components/MaintenanceForm.vue'
import AssignMaintenance from '../components/AssignMaintenance.vue'
import store from '../store/index'
import AddNewProperty from "../views/AddNewProperty.vue"
import Home from "../views/Home.vue"
import AboutUs from "../components/AboutUs.vue"

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path:"/viewMyRent",
      name: "rent",
      component: Rent,
      meta: {
        requiresAuth: true
      }
    },
    {
      path:"/browseProperties",
      name:"browse-properties",
      component: BrowseProperties,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/maintenance",
      name: "maintenance-list",
      component: MaintenanceList,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/addProperty",
      name: "add-property",
      component: AddNewProperty,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/requestMaintenance",
      name: "request-maintenance",
      component: MaintenanceForm,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/assignMaintenance",
      name: "assign-maintenance",
      component: AssignMaintenance,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/aboutUs",
      name: "about-us",
      component: AboutUs,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
