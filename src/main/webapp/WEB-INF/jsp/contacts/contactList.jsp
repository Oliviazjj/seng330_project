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
    <a href="http://localhost:9966/petclinic/" class="w3-bar-item w3-button">MealsOnWheels - Register as a New User!</a>
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
<title>Register</title>
</head>
<body>
	<br />
	<br />
	<center><h1>Register as a new user!</h1><p> 
	<p> Please enter in the following information to register as a new user!</p></center>
    <form action="/register-new-user" method="POST">
        Username : <input name="newUsername" type="text" /> <p>
        Password : <input name="newPassword" type="text" /><p>
        Email Address : <input name="newEmail" type="text" /><p>
        <input type="submit" value="Submit" /></center>
        
    </form>
</body>
</html>

</body>
</html>

=======
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="contacts">
    <h2>Veterinarians</h2>

    <table id="contactsTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Specialties</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts.contactList}" var="contact">
            <tr>
                <td>
                    <c:out value="${contact.firstName} ${contact.lastName}"/>
                </td>
                <td>
                    <c:forEach var="specialty" items="${contact.specialties}">
                        <c:out value="${specialty.name} "/>
                    </c:forEach>
                    <c:if test="${contact.nrOfSpecialties == 0}">none</c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
    <spring:url value="contacts/new" var="addUrl">
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New Contact</a>
    
    

   <%--  <table class="table-buttons">
        <tr>
            <td>
                <a href="<spring:url value="/contacts.xml" htmlEscape="true" />">View as XML</a>
            </td>
            <td>
                <a href="<spring:url value="/contacts.json" htmlEscape="true" />">View as JSON</a>
            </td>
        </tr>
    </table> --%>
</petclinic:layout>
>>>>>>> 6f2630722bd98f5a5ea02a83ded195ade669139c
