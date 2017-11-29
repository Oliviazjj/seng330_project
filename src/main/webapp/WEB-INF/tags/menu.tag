<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of the active menu: home, employees, contacts, events, foods and inventorys" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <%-- <a class="navbar-brand" href="<spring:url value="/" htmlEscape="true" />"><span></span></a> --%>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-navbar">
                <span class="sr-only"><os-p>Toggle navigation</os-p></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="main-navbar">
            <ul class="nav navbar-nav navbar-right">

                <petclinic:menuItem active="${name eq 'home'}" url="/" title="home page">
                    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    <span>Home</span>
                </petclinic:menuItem>

                <petclinic:menuItem active="${name eq 'employees'}" url="/employees/find.html" title="find employees">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    <span>Find employees</span>
                </petclinic:menuItem>

                <petclinic:menuItem active="${name eq 'contacts'}" url="/contacts.html" title="contacts">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Contacts</span>
                </petclinic:menuItem>

                <petclinic:menuItem active="${name eq 'events'}" url="/events"
                            title="events">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Events</span>
                </petclinic:menuItem>
                
                <petclinic:menuItem active="${name eq 'foods'}" url="/foods"
                            title="foods">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Food</span>
                </petclinic:menuItem>
                
                <petclinic:menuItem active="${name eq 'inventorys'}" url="/inventorys"
                            title="Inventorys">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Inventory</span>
                </petclinic:menuItem>

            </ul>
        </div>
    </div>
</nav>
