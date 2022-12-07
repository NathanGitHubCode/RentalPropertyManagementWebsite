<template>
  <div class="home">
      <head>
  <title>Welcome to [Your Website]</title>
</head>
<body>
  <div class="container">
    <div class="main">
      <p>Here at [Your Website], we offer [insert services or products offered].</p>
      <h2>Our Services/Products</h2>
      <ul>
        [Insert list of services or products offered]
      </ul>
    </div>
    <div class="sidebar-left">
      <h2>Contact Us</h2>
      <p>For more information or to inquire about our services/products, please contact us.</p>
      <button onclick="window.location.href='contact.html'">Contact Us</button>
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
      background-color: #f2f2f2;
      margin: 0px;
    }
    .container {
      display: grid;
      grid-template-columns: 200px 1fr 200px;
      grid-template-rows: auto 100vh auto;
      grid-template-areas:
        "header header header"
        "sidebar-left main sidebar-right"
        "footer footer footer";  
    }

    .main {
      grid-area: main;
      padding: 20px;
    }
    .sidebar-left {
      grid-area: sidebar-left;
      background-color: #fff;
      padding: 20px;
      border: 1px solid #ccc;
    }
    .sidebar-right {
      grid-area: sidebar-right;
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
