<template>
  <div id="app">
    <div class="nav-bar">
      <router-link v-bind:to="{ name: 'home' }">
        <img 
        class="home-nav"
        src="image.png" />
      </router-link>
      <div class="dropdown-all">
        <h1 
        class="drop"
        @mouseenter="toggleProperties()"
        @mouseleave="toggleProperties()"
        >Properties </h1>
        <div 
        class="dropdown-content" 
        id="properties-drop" 
        @mouseenter="toggleProperties()" 
        @mouseleave="toggleProperties()">
          <router-link v-bind:to="{ name: 'browse-properties', params: { id: userID } }">Browse Properties</router-link>
          <router-link v-bind:to="{ name: 'add-property', params: { id: userID } }">Add a Property</router-link>
        </div>
      </div>
      <div class="dropdown-all">
        <h1 
        class="drop"
        @mouseenter="toggleRent()"
        @mouseleave="toggleRent()"
        >Rent</h1>
        <div 
        class="dropdown-content" 
        id="rent-drop"
        @mouseenter="toggleRent()"
        @mouseleave="toggleRent()">
            <router-link v-bind:to="{ name: 'rent', params: { id: userID } }">View Rent</router-link>
            
        </div>
      </div>
      <div class="dropdown-all">
        <h1 
        class="drop" 
        @mouseenter="toggleMaintenance()"
        @mouseleave="toggleMaintenance()"
        >Maintenance</h1>
         <div 
         class="dropdown-content" 
         id="maintenance-drop"
         @mouseenter="toggleMaintenance()"
         @mouseleave="toggleMaintenance()">
            <router-link v-bind:to="{ name: 'maintenance-list' }">View Maintenance</router-link>
            <router-link v-bind:to="{ name: 'request-maintenance', params: { id: userID } }">Request Maintenance</router-link>
            <router-link v-bind:to="{ name: 'assign-maintenance', params: { id: userID } }">Assign Maintenance</router-link>
         </div>
      </div>
      <account-drop-down/>
     </div>
      <router-view />
  </div>
</template>

<script>
import AccountDropDown from '../src/views/AccountDropDown.vue';

export default {
  name: 'main-app',
  components: { AccountDropDown },
  data() {
    return {
    }
  },
  methods: {
    toggleMaintenance() {
      document.getElementById("maintenance-drop").classList.toggle("show");
    },
    toggleRent() {
      document.getElementById("rent-drop").classList.toggle("show");
    },
    toggleProperties() {
      document.getElementById("properties-drop").classList.toggle("show");
    }


  }
}
</script>

<style>

.nav-bar > .home-nav {
  justify-content: flex-start;
}

  .nav-bar:hover {
    color: white;    
  }


  .nav-bar {
      background-color: rgba(104, 0, 0);
      padding: auto;
      display:flex;
      flex-wrap: wrap;
      justify-content:space-around;
      width: 100%;      
  }

  .nav-bar > * {
    text-decoration: none;
    color: black;
    font-weight: bold;
    display: flex;

  }

  .home-nav {
    block-size: 3.6rem;
    margin-left: 10px;
  }



    /* Dropdown Button */
.drop {
  color: black;
  padding: 20px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* Dropdown button on hover & focus */
.drop:hover, .drop:focus {
  color: white;
  background-color: rgb(129, 0, 0) ;

}

/* The container <div> - needed to position the dropdown content */
.dropdown-all {
  position: relative;
  display: block;
  align-items: center;  
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content > * {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: flex;
}

/* Change color of dropdown links on hover */
.dropdown-content > *:hover {
  background-color: #ddd;
  }

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {
  display:block;
  }

  .dropdown-all > * {
    color: white;
  }


</style>