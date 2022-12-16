<template>
  <div class="home">
    <div class="container">
      <div class="header">
        <h3>Welcome to Dreamville Rentals</h3>
      </div>
  <div class="main">
    <div class="amenities" >
    <h2>Rental Property Amenities</h2>
    <p>Our rental property offers the following amenities for our tenants to enjoy:</p>
    </div>
    <ul>
      <h1 id="list-item-label">Fitness Center</h1>
      <li>Our state-of-the-art fitness center is fully equipped with a wide range of cardiovascular and weight-training equipment, including treadmills, stationary bikes, ellipticals, and free weights. The fitness center is open 24 hours a day, so tenants can work out at a time that is convenient for them.</li>
      <h1 id="list-item-label">Outdoor Swimming Pool</h1>
      <li>Our outdoor pool is the perfect place to cool off and relax on hot summer days. The pool area also includes lounge chairs and umbrellas for added comfort. The pool is open from 9am to 9pm every day, and is staffed by a certified lifeguard during these hours.</li>
      <h1 id="list-item-label">On-Site Laundry Facilities</h1>
      <li>Our property features convenient on-site laundry facilities, including both washers and dryers. The laundry room is open 24 hours a day, and each tenant is provided with a key card that allows access to the room.</li>
      <h1 id="list-item-label">Outdoor Grill and Picnic Area</h1>
      <li>Our outdoor grill and picnic area is a great place to enjoy a cookout with friends and family. The area is equipped with grills, picnic tables, and other amenities. The grill and picnic area is open from 9am to 9pm every day, and is available on a first-come, first-served basis.</li>
      <h1 id="list-item-label">Basketball Court</h1>
      <li>Our property features a full-sized basketball court, allowing tenants to play a game of pickup basketball or shoot some hoops on their own. The court is well-lit for night-time use, and is open from 9am to 9pm every day.</li>
      <h1 id="list-item-label">Dog Park</h1>
      <li>We know that many of our tenants have pets, so we've added a fenced-in dog park to our property. This area is a great place for dogs to run and play off-leash. The dog park is open from 9am to 9pm every day, and is accessible to tenants with a key card.</li>
      <h1 id="list-item-label">Community Garden</h1>
      <li>We've also added a community garden to our property, allowing tenants to grow their own fruits, vegetables, and herbs. The garden is maintained by a professional gardening service, and is available for use by all tenants.</li>
      <h1 id="list-item-label">Storage Units</h1>
      <li>For tenants who need extra storage space, we offer secure storage units that can be rented on a monthly basis. The storage units are available in a variety of sizes, and are accessible to tenants with a key card.</li>
      <h1 id="list-item-label">Women's Lounge</h1>
      <li>We've added a women's lounge to our property, providing a comfortable and relaxing space for women to gather and socialize. The lounge includes comfortable seating, a coffee bar, and a television. The lounge is open from 9am to 9pm every day, and is accessible to tenants with a key card.</li>
      <h1 id="list-item-label">Women's Self-Defense Classes</h1>
      <li>We offer regular self-defense classes for women, taught by certified instructors. The classes are designed to empower women and teach them practical skills for defending themselves in dangerous situations. Classes are held in the fitness center on Tuesday and Thursday evenings.</li>
    </ul>
  </div>
  <div class="footer">
    <a href="/aboutUs" class="about-us-link">About Us</a>&nbsp;|&nbsp;
    <a>Contact Us : 214-380-3291 </a>
  </div>
</div>
 </div>
</template>

<script>
export default {
  name: 'home',
}
</script>

<style>
p{
  text-align: center;
}

h2 {
  text-align: center;
}

 .home {
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
      grid-template-rows: 100px 1fr 50px;
      grid-template-areas:
        "header header header"
        "main main main"
        "footer footer footer";  
    }

    .header {
      grid-area: header;
      font-size: 30px;
      color: white;
      text-align: center;
      font-style:oblique;
      text-decoration: underline;
    
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
      padding: 10px;
      text-align: center;
    }
    .footer > a {
      text-decoration: none;
      color: white;
      cursor: pointer;
    }
    h1, h2 {
      margin: 0;
    }
    #list-item-label {
      font-size: 24px;
      text-align: center;
      text-decoration: none;
      font-style: italic;
    }
    h2 {
      font-size: 18px;
    }
    /* h3 {
      text-align: left; 
      padding: 20px;
      
    } */
    ul {
      list-style-type: none;
      padding: 0;
    }
    li {
      margin-top: 15px;
      margin-bottom: 15px;
    }
    button {
      background-color: #333;
      color: #fff;
      padding: 10px 20px;
      border: none;
      cursor: pointer;
    }

    li {
      font-weight: bold;
    }

    ul > li {
      background-color: rgb(8, 134, 61);
      color: white;

    }

    ul > h1 {
      background-color: #ec9d36;
      color: white;
      margin-left: 40%;
      margin-right: 40%;
    }
  .main > div {
    font-weight: bolder;
    text-decoration: underline;
  }


</style>
