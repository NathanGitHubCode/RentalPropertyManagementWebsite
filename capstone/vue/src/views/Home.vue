<template>
  <div class="home">
   <body>
    <div class="container">
      <div class="header">
        <h3>Welcome to Dreamville Rentals</h3>
      </div>
      <div class="main">
        <p></p>
        <h2></h2>
        <ul>
       </ul>
      </div>
    <div class="sidebar-left">
        
    </div>
    <div class="sidebar-right">
        [Insert content for right sidebar]
    </div>
    <div class="footer">
      [Insert footer content]
    </div>
   </div>
  </body>
 </div>
</template>

<script>
export default {
  name: 'home',
}
</script>

<style>

 body {
      font-family: Arial, sans-serif;
      margin: 0px;
      background-image: 
      linear-gradient(rgba(100, 167, 184, 0.5), rgba(255, 255, 0, 0.363)),
      url("../../public/backgroundimage.png");
      background-size: cover;
      background-attachment: fixed;
      background-blend-mode:luminosity;

    }
    .container {
      display: grid;
      grid-template-columns: auto 1fr auto;
      grid-template-rows: 200px 100vh 200px;
      grid-template-areas:
        "header header header"
        "main main main"
        "footer footer footer";  
      
    }

    .header {
      grid-area: header;

    }

    .main {
      grid-area: main;
      padding: 20px;
     
    }
    .sidebar-left {
      background-color: #fff;
      padding: 20px;
      border: 1px solid #ccc;
    }
    .sidebar-right {
      background-color: #fff;
      padding: 20px;
      border: 1px solid #ccc;
    }
    .footer {
      grid-area: footer;
      background-color: #333;
      color: #fff;
      padding: 20px;
      text-align: center;
    }
    h1, h2 {
      margin: 0;
    }
    h1 {
      font-size: 24px;
    }
    h2 {
      font-size: 18px;
    }
    h3 {
      text-align: center;
      padding: 20px;
      
    }
    ul {
      list-style-type: none;
      padding: 0;
    }
    li {
      margin-bottom: 10px;
    }
    button {
      background-color: #333;
      color: #fff;
      padding: 10px 20px;
      border: none;
      cursor: pointer;
    }
    

</style>
