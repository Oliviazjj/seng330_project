<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {font-family: "Times New Roman", Georgia, Serif;}
h1,h2,h3,h4,h5,h6 {
    font-family: "Playfair Display";
    letter-spacing: 5px;
}
</style>
<body>

 <!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="http://localhost:9966/petclinic/#home#home" class="w3-bar-item w3-button">MealsOnWheels - Create an Event</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
      <a href="http://localhost:9966/petclinic/login" class="w3-bar-item w3-button">Login</a>
      <a href="http://localhost:9966/petclinic/userInfo" class="w3-bar-item w3-button">Create Event</a>
      <a href="http://localhost:9966/petclinic/userInfo" class="w3-bar-item w3-button">My Event</a>
      <a href="http://localhost:9966/petclinic/admin" class="w3-bar-item w3-button">Admin</a>

    </div>
  </div>
</div>

<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section -->

	
    <div class="w3-col m6 w3-padding-large">
   
      <center><h1 class="w3-center">How Does It Work?</h1><br></center>
      <p class="w3-large"> Welcome to MealsOnWheels! To book an event using our catering services you as the customer will have the option to select a date, time, theme, and customize your menu!</p>
    
    </div>
  </div>
  
  <hr>
  <!-- Menu Section -->
  <div class="w3-row w3-padding-64" id="menu">
    <div class="w3-col l6 w3-padding-large">
      <h1 class="w3-center">Our Menu</h1><br>
      <p><font size="5">Appetizers</font></p>
      <h4>Garlic Prawns </h4>
      <p class="w3-text-grey">Garlic prawns server with a honey dipping sauce</p><br>
    
      <h4>Honey Bruschetta</h4>
      <p class="w3-text-grey">A toasted crustini topped with fresh tomatos, red onion and basic</p><br>
    
      <h4>Calamari</h4>
      <p class="w3-text-grey">Deep fried squid with a lemon basil sauce</p><br>
    
      <h4>Caesar Salad</h4>
      <p class="w3-text-grey">Romaine lettuce, sliced bacon, croutons, topped with parmesan cheese and a ceasar dressing</p><br>
    
      <h4>Mixed Greens </h4>
      <p class="w3-text-grey">Mixed greens, tomatoes, red onion, cucumber, shredded carrot, dressed with a balsamic vinagrette</p>    
      <p><font size="5">Entrees</font></p>
       <h4>Chicken Parmesan </h4>
      <p class="w3-text-grey">Chicken breast topped with a basil tomato sauce with mixed vegtables and a baked potato</p><br>
    
      <h4>Steak with Vegtables </h4>
      <p class="w3-text-grey">Top serloin with mixed vegtables, a baked potato, and garlic bread.</p><br>
    
      <h4>Ravioli</h4>
      <p class="w3-text-grey">Mushroom stuffed ravioli served in a white wine sauc. (Vegetarian)</p><br>
    
      <h4>Chickpea Curry </h4>
      <p class="w3-text-grey">Chickpeas, zuccini, mushrooms, yams, and caluiflower served over a yellow curry sauce. (Vegan)</p><br>
    
   	  <p><font size="5">Desserts</font></p>
      <h4>Ice Cream </h4>
      <p class="w3-text-grey">Chocolate, vanilla, strawberry, caramel.</p><br>
    
      <h4>Pumpkin Pie </h4>
      <p class="w3-text-grey">Served with whip cream and vanilla ice cream</p><br>
    
      <h4>Chocolate Cake</h4>
      <p class="w3-text-grey">Seven layered chocolate cake.</p><br>
    
      <h4>Strawberry Cheesecake </h4>
      <p class="w3-text-grey">New York cheese cake topped with strawberries.</p><br>
    
      
    </div>
  </div>

  <hr>

  <!-- Contact Section -->
  <div class="w3-container w3-padding-64" id="contact">
    <h1>Book an Event</h1><br>
    <p>To book an event please fill out the following information. </p>
    <p class="w3-text-blue-grey w3-large"><b>MealsOnWheels, 1234 Fort Street, Victoria, BC</b></p>
    <p>You can also contact us by phone 123-456-7899 or email blah@hotmail.com</p>
    <form action="/action_page.php" target="_blank">
      <p><input class="w3-input w3-padding-16" type="text" placeholder="Name" required name="Name"></p>
      <p><input class="w3-input w3-padding-16" type="number" placeholder="How many people" required name="People"></p>
      <p><input class="w3-input w3-padding-16" type="datetime-local" placeholder="Date and time" required name="date" value="2017-11-16T20:00"></p>
      <p><input class="w3-input w3-padding-16" type="Appetizer" placeholder="Choose an Appetizer" required name="Appetizer"></p>
      <p><input class="w3-input w3-padding-16" type="Entree" placeholder="Choose an Entree" required name="Entree"></p>
      <p><input class="w3-input w3-padding-16" type="Dessert" placeholder="Choose a Dessert" required name="Dessert"></p>
      <p><input class="w3-input w3-padding-16" type="text" placeholder="Message \ Special requirements" required name="Message"></p>
      <form action="/add-event" method="POST"> Please confirm your event: <inputname="eventName" type ="text"/></form>
      <p><button class="w3-button w3-light-grey w3-section" type="submit">Book Event!</button></p>
    </form>
  </div>
</body>
</html>

