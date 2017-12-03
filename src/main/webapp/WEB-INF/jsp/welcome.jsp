<%@ page session="true" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mealOnWheel" tagdir="/WEB-INF/tags" %>

<mealOnWheel:layout pageName="home">
    <h1>welcome to our Admin System</h1>
    <div class="row">
	<h2>Instructions</h2>
	<h2>Find Employee</h2>
		-find a employee by last name
		-display all the employees by entering "" in search bar or clicking "Show all employees" button. 
	<h2>Add Event to Employee</h2>
		Assign a event to a employee, then add employee shift for this event which employee participates.
    <h2>Contact</h2>
    		-Add contact
    		-edit contact
    	<h2>Event</h2>
    		-Click "edit" button to edit event details
    		-Looking into event details(employee shift, client information and event details) by clicking event name.
    	<h2>Food</h2>
    		-Add food item
    		-edit food item
    	<h2>Inventory</h2>
    		-Add inventory
    		-edit inventory
    </div>
</mealOnWheel:layout>


