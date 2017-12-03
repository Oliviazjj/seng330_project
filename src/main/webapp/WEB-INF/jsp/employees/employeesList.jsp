<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="employees">

	<!-- <div class="col-sm-offset-2 col-sm-10"> -->
    <h2>Employees</h2>
    <br />
    <a class="btn btn-default" href='<spring:url value="/employees/new" htmlEscape="true"/>'>Add Employee</a>
    <h3 style="color: red;"> Please click employee name to see the employee details</h3>
    <br />
    <!--  </div> -->

    <table id="employeesTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>
            <th style="width: 200px;">Address</th>
            <th>City</th>
            <th style="width: 120px">Telephone</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="employee">
            <tr>
                <td>
                    <spring:url value="/employees/{employeeId}.html" var="employeeUrl">
                        <spring:param name="employeeId" value="${employee.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(employeeUrl)}"><c:out value="${employee.firstName} ${employee.lastName}"/></a>
                </td>
                <td>
                    <c:out value="${employee.address}"/>
                </td>
                <td>
                    <c:out value="${employee.city}"/>
                </td>
                <td>
                    <c:out value="${employee.telephone}"/>
                </td>
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
