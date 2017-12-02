<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="employEventclinic" tagdir="/WEB-INF/tags" %>

<employEventclinic:layout pageName="employees">

    <h2>Employee Information</h2>


    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${employee.firstName} ${employee.lastName}"/></b></td>
        </tr>
        <tr>
            <th>Address</th>
            <td><c:out value="${employee.address}"/></td>
        </tr>
        <tr>
            <th>City</th>
            <td><c:out value="${employee.city}"/></td>
        </tr>
        <tr>
            <th>Telephone</th>
            <td><c:out value="${employee.telephone}"/></td>
        </tr>
    </table>

    <spring:url value="{employeeId}/edit.html" var="editUrl">
        <spring:param name="employeeId" value="${employee.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit Employee</a>

    <spring:url value="{employeeId}/employEvents/new.html" var="addUrl">
        <spring:param name="employeeId" value="${employee.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New EmployEvent</a>
    
     <spring:url value="new" var="addUrl">
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New Employee</a>

    <br/>
    <br/>
    <br/>
    <h2>EmployEvents and EmployeeShifts</h2>

    <table class="table table-striped">
        <c:forEach var="employEvent" items="${employee.employEvents}">

            <tr>
                <td valign="top">
                    <dl class="dl-horizontal">
                        <dt>Name</dt>
                        <dd><c:out value="${employEvent.event.name}"/></dd>
                        <dt>Event Date</dt>
                        <dd><fmt:formatDate value="${employEvent.event.eventDate}" pattern="yyyy-MM-dd"/></dd>
                        <dt>Type</dt>
                        <dd><c:out value="${employEvent.event.name}"/></dd>
                    </dl>
                </td>
                <td valign="top">
                    <table class="table-condensed">
                        <thead>
                        <tr>
                            <th>EmployeeShift Date</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <c:forEach var="employeeShift" items="${employEvent.employeeShifts}">
                            <tr>
                                <td><fmt:formatDate value="${employeeShift.date}" pattern="yyyy-MM-dd"/></td>
                                <td><c:out value="${employeeShift.description}"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>
                                <spring:url value="/employees/{employeeId}/employEvents/{employEventId}/edit" var="employEventUrl">
                                    <spring:param name="employeeId" value="${employee.id}"/>
                                    <spring:param name="employEventId" value="${employEvent.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(employEventUrl)}">Edit EmployEvent</a>
                            </td>
                            <td>
                                <spring:url value="/employees/{employeeId}/employEvents/{employEventId}/employeeShifts/new" var="employeeShiftUrl">
                                    <spring:param name="employeeId" value="${employee.id}"/>
                                    <spring:param name="employEventId" value="${employEvent.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(employeeShiftUrl)}">Add EmployeeShift</a>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

        </c:forEach>
    </table>

</employEventclinic:layout>
