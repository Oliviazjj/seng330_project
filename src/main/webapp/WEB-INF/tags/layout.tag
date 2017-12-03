<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<%@ attribute name="pageName" required="true" %>
<%@ attribute name="customScript" required="false" fragment="true"%>

<!doctype html>
<html>
<mealOnWheel:htmlHeader/>

<body>
<mealOnWheel:bodyHeader menuName="${pageName}"/>

<div class="container-fluid">
    <div class="container xd-container">

        <jsp:doBody/>

        <mealOnWheel:pivotal/>
    </div>
</div>
<mealOnWheel:footer/>
<jsp:invoke fragment="customScript" />

</body>

</html>
