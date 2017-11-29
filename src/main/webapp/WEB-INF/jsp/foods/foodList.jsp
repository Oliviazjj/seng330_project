<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="foods">
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
</petclinic:layout>
