<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="events">
    <h2>Events</h2>

    <table id="eventsTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Guest#</th>
            <th>Event Date</th>
            <th>Appetizer</th>
            <th>Entree</th>
            <th>Dessert</th>
            <th>description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${events.eventList}" var="event">
            <tr>
                <td><fmt:formatDate value="${event.eventDate}" pattern="yyyy-MM-dd"/></td>
                <td><c:out value="${event.amountOfPeople}"/></td>
                <td><c:out value="${event.appetizer}"/></td>
                <td><c:out value="${event.entree}"/></td>
                <td><c:out value="${event.dessert}"/></td>
                <td><c:out value="${event.description}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>


