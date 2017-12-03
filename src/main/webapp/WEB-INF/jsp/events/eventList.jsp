<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>


<mealOnWheel:layout pageName="events">
    <h2>Events</h2>
    
    <spring:url value="events/new" var="addUrl">
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New Event</a>
	<h3 style="color: red;"> Please click event name to see the event details and employee shifts for that event</h3>
    <br />
    <table id="eventsTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Event Date</th>
            <th>Location</th>
            <th>Guest#</th>
            <th>Appetizer</th>
            <th>Entree</th>
            <th>Dessert</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${events}" var="event">
            <tr>
            	<td>
               <spring:url value="/events/{eventId}.html" var="eventUrl">
                  <spring:param name="eventId" value="${event.id}"/>
                  </spring:url>
                  <a href="${fn:escapeXml(eventUrl)}"><c:out value="${event.name}"/></a>
                </td>
                <td><fmt:formatDate value="${event.eventDate}" pattern="yyyy/MM/dd"/></td> 
                <td><c:out value="${event.location}"/></td>
                <td><c:out value="${event.amountOfPeople}"/></td>
                <td><c:out value="${event.appetizer}"/></td>
                <td><c:out value="${event.entree}"/></td>
                <td><c:out value="${event.dessert}"/></td>
                <td><c:out value="${event.description}"/></td>
                <td>
                		<spring:url value="events/{eventId}/edit.html" var="editUrl">
        				<spring:param name="eventId" value="${event.id}"/>
    					</spring:url>
   					<a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit</a>
				</td>
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
</mealOnWheel:layout>


