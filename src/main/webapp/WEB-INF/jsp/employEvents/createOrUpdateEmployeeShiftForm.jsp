<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="employees">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#date").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2><c:if test="${employeeShift['new']}">New </c:if>EmployeeShift</h2>

        <b>EmployEvent</b>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Event</th>
                <th>Employee</th>
            </tr>
            </thead>
            <tr>
                <td><c:out value="${employeeShift.employEvent.name}"/></td>
                <td><fmt:formatDate value="${employeeShift.employEvent.event.getEventData}" pattern="yyyy/MM/dd"/></td>
                <td><c:out value="${employeeShift.employEvent.event.name}"/></td>
                <td><c:out value="${employeeShift.employEvent.employee.firstName} ${employeeShift.employEvent.employee.lastName}"/></td>
            </tr>
        </table>

        <form:form modelAttribute="employeeShift" class="form-horizontal">
            <div class="form-group has-feedback">
                <petclinic:inputField label="Date" name="date"/>
                <petclinic:inputField label="Description" name="description"/>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="hidden" name="employEventId" value="${employeeShift.employEvent.id}"/>
                    <button class="btn btn-default" type="submit">Add EmployeeShift</button>
                </div>
            </div>
        </form:form>

        <br/>
        <b>Previous EmployeeShifts</b>
        <table class="table table-striped">
            <tr>
                <th>Date</th>
                <th>Description</th>
            </tr>
            <c:forEach var="employeeShift" items="${employeeShift.employEvent.employeeShifts}">
                <c:if test="${!employeeShift['new']}">
                    <tr>
                        <td><fmt:formatDate value="${employeeShift.date}" pattern="yyyy/MM/dd"/></td>
                        <td><c:out value="${employeeShift.description}"/></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </jsp:body>

</petclinic:layout>
