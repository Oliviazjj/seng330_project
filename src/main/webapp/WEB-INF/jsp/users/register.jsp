<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout2 pageName="register">

<div class="container">

    <form method="POST" action="${pageContext.request.contextPath}/register" class="form-signin">
        <h2 class="form-heading">Create an account</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <input name="email" type="email" class="form-control" placeholder="Email"/>
            <input name="firstName" type="text" class="form-control" placeholder="FirstName"/>
            <input name="lastName" type="text" class="form-control" placeholder="LastName"/>
            <span>${error}</span>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </div>

    </form>

</div>

</petclinic:layout2>
