<<<<<<< HEAD
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
    <a href="http://localhost:9966/petclinic/" class="w3-bar-item w3-button">MealsOnWheels - Login</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
    <a href="http://localhost:9966/petclinic/login" class="w3-bar-item w3-button">Login</a>
      <a href="http://localhost:9966/petclinic/userInfo" class="w3-bar-item w3-button">Create Event</a>
      <a href="http://localhost:9966/petclinic/employees" class="w3-bar-item w3-button">Employee</a>
      <a href="http://localhost:9966/petclinic/admin" class="w3-bar-item w3-button">Admin</a>
    </div>
  </div>
</div>


<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section -->

	
    <div class="w3-col m6 w3-padding-large">
   </br>
   </br>
      <center><h1 class="w3-center">Login</h1><br></center>
     <!-- System.out.println(request.getParameter("name")); 
		Date date = new Date();-->

<p> testing Hello and Welcome! Please enter your username and password to login to your account. </p>
<form action="/login" method="post">
<p><font color="red">${errorMessage}</font></p>
<tr>
    Username: <td><input type='text' name='username' value=''></td>
 </tr>
 <tr>
    <td>Password:</td>
    <td><input type='password' name='password' /></td>
 </tr>
 <tr>
    <td><input name="submit" type="submit" value="submit" /></td>
</tr>
      </table>
      </br>
      </br>
      <a href = "http://localhost:9966/petclinic/contacts.html">New User?</a>
</form>
</body>
</html>
=======
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout2 pageName="login">

<!-- <div class="container"> -->
<div class="w3-col m6 w3-padding-large">
    <br><br>

    <form method="POST" action="${pageContext.request.contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${pageContext.request.contextPath}/register">Create an account</a></h4>
        </div>

    </form>

</div>

</petclinic:layout2>
>>>>>>> 6f2630722bd98f5a5ea02a83ded195ade669139c
