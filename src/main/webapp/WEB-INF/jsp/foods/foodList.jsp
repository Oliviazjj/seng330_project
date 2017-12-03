<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<mealOnWheel:layout pageName="foods">
    <h2>Food</h2>

    <table id="foodsTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Amount</th>
            <th>Expire_date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${foods}" var="food">
            <tr>
                <td>
                    <c:out value="${food.name} "/>
                </td>
                <td>
                    <c:out value="${food.type} "/>
                </td>
                <td>
                    <c:out value="${food.amount} "/>
                </td>
              	<td><fmt:formatDate value="${food.expireDate}" pattern="yyyy/MM/dd"/></td> 
              	<td>
                		<spring:url value="foods/{foodId}/edit.html" var="editUrl">
        				<spring:param name="foodId" value="${food.id}"/>
    					</spring:url>
   					<a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit Food</a>
				</td> 
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
    <spring:url value="foods/new" var="addUrl">
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New Food</a>
    
    

   <%--  <table class="table-buttons">
        <tr>
            <td>
                <a href="<spring:url value="/contacts.xml" htmlEscape="true" />">View as XML</a>
            </td>
            <td>
                <a href="<spring:url value="/contacts.json" htmlEscape="true" />">View as JSON</a>
            </td>
        </tr>
    </table> --%>
</mealOnWheel:layout>
