<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="employees">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#birthDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>
            <c:if test="${employEvent['new']}">New </c:if> EmployEvent
        </h2>
        <form:form modelAttribute="employEvent"
                   class="form-horizontal">
            <input type="hidden" name="id" value="${employEvent.id}"/>
            <div class="form-group has-feedback">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Employee</label>
                    <div class="col-sm-10">
                        <c:out value="${employEvent.employee.firstName} ${employEvent.employee.lastName}"/>
                    </div>
                </div>
                <petclinic:inputField label="Name" name="name"/>
                <petclinic:inputField label="Birth Date" name="birthDate"/>
                <div class="control-group">
                    <petclinic:selectField name="type" label="Type " names="${types}" size="5"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${employEvent['new']}">
                            <button class="btn btn-default" type="submit">Add EmployEvent</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit">Update EmployEvent</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
        <c:if test="${!employEvent['new']}">
        </c:if>
    </jsp:body>
</petclinic:layout>
