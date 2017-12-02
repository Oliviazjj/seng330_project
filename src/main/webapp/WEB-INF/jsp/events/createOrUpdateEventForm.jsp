<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="events">
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
        <div class="form-group has-feedback">
            <petclinic:inputField label="Name" name="name"/>
            <petclinic:inputField label="AmountOfPeople" name="amountOfPeople"/>
            <petclinic:inputField label="eventDate" name="eventDate"/>
            <petclinic:inputField label="Location" name="location"/>
            <petclinic:inputField label="Appetizer" name="appetizer"/>
            <petclinic:inputField label="Entree" name="entree"/>
            <petclinic:inputField label="Dessert" name="dessert"/>
            <petclinic:inputField label="Description" name="description"/>
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
</petclinic:layout>
