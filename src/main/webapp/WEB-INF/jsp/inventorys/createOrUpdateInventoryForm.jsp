<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<mealOnWheel:layout pageName="inventorys">
	<jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#purchaseDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
    <h2>
        <c:if test="${food['inventory']}">New </c:if> Inventory
    </h2>
    <form:form modelAttribute="inventory" class="form-horizontal" id="add-inventory-form">
        <div class="form-group has-feedback">
            <mealOnWheel:inputField label="Name" name="name"/>
            <mealOnWheel:inputField label="Type" name="type"/>
            <mealOnWheel:inputField label="Amount" name="amount"/>
            <mealOnWheel:inputField label="Date" name="purchaseDate"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${inventory['new']}">
                        <button class="btn btn-default" type="submit">Add Inventory</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Inventory</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    </jsp:body>
</mealOnWheel:layout>