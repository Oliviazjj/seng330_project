<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<mealOnWheel:layout pageName="inventorys">
    <h2>Food</h2>

    <table id="inventorysTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Amount</th>
            <th>Purchase_date</th>
            <th>update</th>
            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${inventorys}" var="inventory">
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
                <td>
                		<spring:url value="inventorys/{inventoryId}/edit.html" var="editUrl">
        				<spring:param name="inventoryId" value="${inventory.id}"/>
    					</spring:url>
   					<a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit Inventory</a>
				</td> 
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
    <spring:url value="inventorys/new" var="addUrl">
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New Inventory</a>
    
</mealOnWheel:layout>
