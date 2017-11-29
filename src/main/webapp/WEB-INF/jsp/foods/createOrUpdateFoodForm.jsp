<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="foods">
	<jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#expireDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <h2>
        <c:if test="${food['new']}">New </c:if> Food
    </h2>
    <form:form modelAttribute="food" class="form-horizontal" id="add-food-form">
        <div class="form-group has-feedback">
            <petclinic:inputField label="Name" name="name"/>
            <petclinic:inputField label="Type" name="type"/>
            <petclinic:inputField label="Amount" name="amount"/>
            <petclinic:inputField label="Date" name="expireDate"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${food['new']}">
                        <button class="btn btn-default" type="submit">Add Food</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Food</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</petclinic:layout>