<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<mealOnWheel:layout pageName="events">
	<jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#eventDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
    <h2>
        <c:if test="${event['new']}">New </c:if> Event
    </h2>
    
    <form:form modelAttribute="event" class="form-horizontal" id="add-event-form">
    		<input type="hidden" name="id" value="${event.id}"/>
        <div class="form-group has-feedback">
            <mealOnWheel:inputField label="Name" name="name"/>
            <mealOnWheel:inputField label="AmountOfPeople" name="amountOfPeople"/>
            <mealOnWheel:inputField label="eventDate" name="eventDate"/>
            <mealOnWheel:inputField label="Location" name="location"/>
            <mealOnWheel:inputField label="Appetizer" name="appetizer"/>
            <mealOnWheel:inputField label="Entree" name="entree"/>
            <mealOnWheel:inputField label="Dessert" name="dessert"/>
            <mealOnWheel:inputField label="Description" name="description"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${event['new']}">
                        <button class="btn btn-default" type="submit">Add Event</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Event</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    </jsp:body>
</mealOnWheel:layout>
