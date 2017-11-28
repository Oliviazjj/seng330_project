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
    <a href="http://localhost:9966/petclinic/#home#home" class="w3-bar-item w3-button">MealsOnWheels - Login</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
      <a href="http://localhost:9966/petclinic/login" class="w3-bar-item w3-button">Login</a>
      <a href="http://localhost:9966/petclinic/userInfo" class="w3-bar-item w3-button">Create Event</a>
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

<p> Hello and Welcome! Please enter your username and password to login to your account. </p>
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
      <a href = "/register">New User?</a>
</form>
</body>
</html>

     
    
