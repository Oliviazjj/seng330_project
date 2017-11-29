<%@ page session="true" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<<<<<<< HEAD
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
    <a href="http://localhost:9966/petclinic/" class="w3-bar-item w3-button">MealsOnWheels - Welcome</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
    <a href="http://localhost:9966/petclinic/login" class="w3-bar-item w3-button">Login</a>
      <a href="http://localhost:9966/petclinic/userInfo" class="w3-bar-item w3-button">Create Event</a>
      <a href="http://localhost:9966/petclinic/employees/find.html" class="w3-bar-item w3-button">Employee</a>
      <a href="http://localhost:9966/petclinic/oups.html" class="w3-bar-item w3-button">Admin</a>
    </div>
  </div>
</div>


<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section need to finish this -->
  <!--
</br>
</br>
</br>
</br>
<div class="w3-content w3-section" style="max-width:500px">
  <img class="mySlides" src="Desktop/seng330/src/main/webapp/WEB-INF/jsp/auth/catering.jpg" style="width:100%">
  <img class="mySlides" src="Desktop/seng330/src/main/webapp/WEB-INF/jsp/auth/catering2.jpg" style="width:100%">
  <img class="mySlides" src="Desktop/seng330/src/main/webapp/WEB-INF/jsp/auth/catering3.jpg" style="width:100%">
  <img class="mySlides" src="Desktop/seng330/src/main/webapp/WEB-INF/jsp/auth/catering4.jpg" style="width:100%">
</div>

<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // The image will change every 2 seconds
}
</script>
-->
    <div class="w3-col m6 w3-padding-large">
   	</br>
   	</br>
      <h1><p aligh = "center">Welcome!</h1></p>
      <p align = "center"> Welcome to MealsOnWheels, a catering company that cares for its clients for everthing from small social parties to weddings, office lunches, or large corporate events and everthing in between.
      Our team sets the highest standard of excellence in everything we do can ensure our clients a stress free experience when hosting or attending an event. Our staff are friendly, professional, and highly experienced with all levels of catering and event management. At MealsOnWheels we also offer an array of additional event coordination services such as venue rentals & bookings, equipment, cats, staff rental and everything needed to make your next catered event a success.</p>
 

=======
<petclinic:layout pageName="home">
    <h2><fmt:message key="welcome"/> - ${sessionScope.currentUser.username}</h2>
    <div class="row">
        <div class="col-md-12">
            <spring:url value="/resources/images/pets.png" htmlEscape="true" var="petsImage"/>
            <img class="img-responsive" src="${petsImage}"/>
        </div>
    </div>
</petclinic:layout>
>>>>>>> 6f2630722bd98f5a5ea02a83ded195ade669139c
