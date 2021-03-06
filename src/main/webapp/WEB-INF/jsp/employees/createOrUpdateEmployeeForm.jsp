<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<mealOnWheel:layout pageName="employees">
    <h2>
        <c:if test="${employee['new']}">New </c:if> Employee
    </h2>
    <form:form modelAttribute="employee" class="form-horizontal" id="add-employee-form">
        <div class="form-group has-feedback">
            <mealOnWheel:inputField label="First Name" name="firstName"/>
            <mealOnWheel:inputField label="Last Name" name="lastName"/>
            <mealOnWheel:inputField label="Address" name="address"/>
            <mealOnWheel:inputField label="City" name="city"/>
            <mealOnWheel:inputField label="Telephone" name="telephone"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${employee['new']}">
                        <button class="btn btn-default" type="submit">Add Employee</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Employee</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</mealOnWheel:layout>
