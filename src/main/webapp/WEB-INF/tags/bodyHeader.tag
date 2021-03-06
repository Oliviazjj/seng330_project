<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<%@ attribute name="menuName" required="true" rtexprvalue="true"
              description="Name of the active menu: home, employees, contacts, foods or inventorys" %>

<mealOnWheel:menu name="${menuName}"/>
