<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="employEventclinic" tagdir="/WEB-INF/tags" %>

<employEventclinic:layout pageName="events">


	<spring:url value="new" var="addUrl">
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New Event</a>
    
    <h2>Event Information</h2>
    
    <table class="table table-striped">
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
            <tr>
            	<td>
               <spring:url value="{eventId}.html" var="eventUrl">
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
                		<spring:url value="{eventId}/edit.html" var="editUrl">
        				<spring:param name="eventId" value="${event.id}"/>
    					</spring:url>
   					<a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit</a>
				</td>      
            </tr>
        </tbody>
    </table>

    <h2>Client Information</h2>
    
    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${event.user.firstName} ${event.user.lastName}"/></b></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><b><c:out value="${event.user.email}"/></b></td>
        </tr>
        </tbody>
    </table>
    
    
    <h2>Employee Shift Information</h2>
    
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Employee Name</th>
            <th>Phone Number</th>
            <th>Shift Date</th>
            <th>Shift Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employeeEvents}" var="employeeEvent">
        		<c:forEach items="${employeeEvent.employeShifts}" var="employeeShift">
            <tr>
                <td>
                    <c:out value="${employeeEvent.employee.firstName} ${employeeEvent.employee.lastName}"/>
                </td>
                <td>
                    <c:out value="${employeeEvent.employee.telephone} "/>
                </td>
              	<td><fmt:formatDate value="${employeeShift.date}" pattern="yyyy/MM/dd"/></td> 
              	<td>
                    <c:out value="${employeeShift.description} "/>
                </td>
              	
            </tr>
            </c:forEach>>
        </c:forEach>
        </tbody>
    </table>


</employEventclinic:layout>
