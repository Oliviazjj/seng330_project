<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>


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
    <a href="http://localhost:9966/mealOnWheel/#home#home" class="w3-bar-item w3-button">MealsOnWheels - Create an Event</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
      <a href="http://localhost:9966/mealOnWheel/login" class="w3-bar-item w3-button">Login</a>
      <a href="http://localhost:9966/mealOnWheel/userInfo" class="w3-bar-item w3-button">Create Event</a>
      <a href="http://localhost:9966/mealOnWheel/userInfo" class="w3-bar-item w3-button">My Event</a>
      <a href="http://localhost:9966/mealOnWheel/admin" class="w3-bar-item w3-button">Admin</a>

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

<c:if test="${not empty eventList}">
    <table id="employeesTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 100px;">Name</th>
            <th style="width: 100px;">Amount of people</th>
            <th style="width: 100px">Event Date</th>
            <th style="width: 100px">Appetizer</th>
            <th style="width: 100px">Entree</th>
            <th style="width: 100px">Dessert</th>
            <th style="width: 100px">Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${eventList}" var="event">
            <tr>
                <td>
                    <c:out value="${event.name} "/>
                </td>
                <td>
                    <c:out value="${event.amountOfPeople}"/>
                </td>
                <td>
                    <c:out value="${event.eventDate}"/>
                </td>
                <td>
                    <c:out value="${event.appetizer}"/>
                </td>
                <td>
                    <c:out value="${event.entree}"/>
                </td>
                <td>
                    <c:out value="${event.dessert}"/>
                </td>
                <td>
                    <c:out value="${event.description}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


  <!-- Contact Section -->
  <div class="w3-container w3-padding-64" id="contact">
    <h1>Book an Event</h1><br>
    <p>To book an event please fill out the following information. </p>
    <p class="w3-text-blue-grey w3-large"><b>MealsOnWheels, 1234 Fort Street, Victoria, BC</b></p>
    <p>You can also contact us by phone 123-456-7899 or email blah@hotmail.com</p>

	<form:form action="${pageContext.request.contextPath}/3/events/new" modelAttribute="event" class="form-horizontal" id="add-employee-form">
    <%-- <form:form action="${pageContext.request.contextPath}/${user_Id}/events/new" modelAttribute="event" modelAttribute="user_Id" class="form-horizontal" id="add-employee-form"> --%>
      <p><form:input class="w3-input w3-padding-16" type="text" placeholder="Name" required="required" name="Name" path="name" /></p>
      <p><form:input class="w3-input w3-padding-16" type="number" placeholder="How many people" required="required" name="People" path="amountOfPeople"/></p>

      <!--
        <p><form:input class="w3-input w3-padding-16" type="datetime-local" placeholder="Date and time" required="required" name="date" value="2017-11-16T20:00" path="eventDate"/></p>
      -->
      <mealOnWheel:inputField label="Date" name="eventDate"/>

      <p><form:input class="w3-input w3-padding-16" type="Appetizer" placeholder="Choose an Appetizer" required="required" name="Appetizer" path="appetizer"/></p>
      <p><form:input class="w3-input w3-padding-16" type="Entree" placeholder="Choose an Entree" required="required" name="Entree" path="entree"/></p>
      <p><form:input class="w3-input w3-padding-16" type="Dessert" placeholder="Choose a Dessert" required="required" name="Dessert" path="dessert" /></p>
      <p><form:input class="w3-input w3-padding-16" type="text" placeholder="Message \ Special requirements" required="required" name="Message" path="description" /></p>

      <p><button class="w3-button w3-light-grey w3-section" type="submit">Book Event!</button></p>
    </form:form>
  </div>

</body>
</html>

