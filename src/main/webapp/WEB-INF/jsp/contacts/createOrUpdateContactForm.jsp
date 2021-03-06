<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<mealOnWheel:layout pageName="contacts">
    <h2>
        <c:if test="${contact['new']}">New </c:if> Contact
    </h2>
    <form:form modelAttribute="contact" class="form-horizontal" id="add-food-form">
        <div class="form-group has-feedback">
            <mealOnWheel:inputField label="First Name" name="firstName"/>
            <mealOnWheel:inputField label="Last Name" name="lastName"/>
            <mealOnWheel:inputField label="Email" name="email"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${contact['new']}">
                        <button class="btn btn-default" type="submit">Add Contact</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Contact</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</mealOnWheel:layout>