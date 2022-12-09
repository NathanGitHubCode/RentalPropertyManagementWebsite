<template>
  <div id="app">
    <div class="header">
      <router-link class="home-nav" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="properties-nav" v-bind:to="{ name:'property-list' } || { name: 'login'} ">Properties</router-link>
      <router-link class="rent-nav" v-bind:to="{ name: 'rent-list', params: { id: userID} }">Rent</router-link>
      <div class="dropdown-maintenance">
        <h1 class="drop" @mouseover="myFunction()">Maintenance</h1>
         <div class="dropdown-content" id="myDropdown">
            <router-link v-bind:to="{ name: 'maintenance-list', params: { id: userID } }">View Maintenance</router-link>
            <router-link v-bind:to="{ name: 'request-maintenance', params: { id: userID } }">Request Maintenance</router-link>
            <p>Assign Maintenance</p>
         </div>
      </div>
      <account-drop-down class="dropdown"/>
     </div>
    <router-view />
  </div>
</template>

<script>
import AccountDropDown from '../src/views/AccountDropDown';

export default {
  name: 'main-app',
  components: { AccountDropDown },
  methods: {
  /* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

  }
// Close the dropdown menu if the user clicks outside of it
// window.onclick = function(event) {
//   if (!event.target.matches('.dropbtn')) {
//     var dropdowns = document.getElementsByClassName("dropdown-content");
//     var i;
//     for (i = 0; i < dropdowns.length; i++) {
//       var openDropdown = dropdowns[i];
//       if (openDropdown.classList.contains('show')) {
//         openDropdown.classList.remove('show');
//       }
//     }
  
//   }
// }
}
</script>

<style>

.dropdown {
  background-color: transparent;
  color: black;
  display: block;
  font-weight: bold;
  }

  .header :hover {
    color: white;    
  }

  .header {
        color: #000;
        cursor: pointer;
        text-decoration: none;

  }

  .header {
      grid-area: header;
      background-color: cyan;
      color: #fff;
      padding: 20px;
      display: flex;
      flex-wrap: wrap;
      justify-content:space-between;

  }

  .header > * {
    text-decoration: none;
    color: black;
    font-weight: bold;
    display: flex;
    justify-content: space-evenly;
  }



    /* Dropdown Button */
.drop {
  background-color: #3498DB;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* Dropdown button on hover & focus */
.drop:hover, .dropbtn:focus {
  background-color: #2980B9;
}

/* The container <div> - needed to position the dropdown content */
.dropdown-maintenance {
  position: relative;
  display: inline-block;
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
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd;}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {display:block;}


</style>