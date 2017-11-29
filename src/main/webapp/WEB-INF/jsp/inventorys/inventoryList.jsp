<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="inventorys">
    <h2>Food</h2>

    <table id="inventorysTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Amount</th>
            <th>Purchase_date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${inventorys.inventoryList}" var="inventory">
            <tr>
                <td>
                    <c:out value="${inventory.name} "/>
                </td>
                <td>
                    <c:out value="${inventory.type} "/>
                </td>
                <td>
                    <c:out value="${inventory.amount} "/>
                </td>
                <td><fmt:formatDate value="${inventory.purchaseDate}" pattern="yyyy/MM/dd"/></td> 
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
    <spring:url value="inventorys/new" var="addUrl">
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New Inventory</a>
    
</petclinic:layout>
