<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<petclinic:layout pageName="contacts">
    <h2>Veterinarians</h2>

    <table id="contactsTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts.contactList}" var="contact">
            <tr>
                <td>
                    <c:out value="${contact.firstName} ${contact.lastName}"/>
                </td>
                <td>
                    <c:forEach var="specialty" items="${contact.specialties}">
                        <c:out value="${specialty.name} "/>
                    </c:forEach>
                    <c:if test="${contact.nrOfSpecialties == 0}">none</c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
    <spring:url value="contacts/new" var="addUrl">
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New Contact</a>
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


