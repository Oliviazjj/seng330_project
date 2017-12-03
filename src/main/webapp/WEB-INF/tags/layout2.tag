<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<%@ attribute name="pageName" required="true" %>
<%@ attribute name="customScript" required="false" fragment="true"%>

<!doctype html>
<html>

<head>
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
</head>
<body>
<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="http://localhost:9966/mealOnWheel/#home#home" class="w3-bar-item w3-button">MealsOnWheels</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
      <a href="http://localhost:9966/mealOnWheel/login" class="w3-bar-item w3-button">Login</a>
      <a href="http://localhost:9966/mealOnWheel/userInfo" class="w3-bar-item w3-button">Create Event</a>
      <a href="http://localhost:9966/mealOnWheel/userInfo" class="w3-bar-item w3-button">My Event</a>
      <a href="http://localhost:9966/mealOnWheel/admin" class="w3-bar-item w3-button">Admin</a>
    </div>
  </div>
</div>
<div class="w3-content" style="max-width:1100px">
        <jsp:doBody/>
</div>
<mealOnWheel:footer/>
<jsp:invoke fragment="customScript" />
</body>
</html>
