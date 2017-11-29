<<<<<<< HEAD
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {font-family: "Times New Roman", Georgia, Serif;}
h1,h2,h3,h4,h5,h6 {
    font-family: "Playfair Display";
    letter-spacing: 5px;
}
</style>
<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="http://localhost:9966/petclinic/" class="w3-bar-item w3-button">MealsOnWheels - Employee</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
    <a href="http://localhost:9966/petclinic/login" class="w3-bar-item w3-button">Login</a>
      <a href="http://localhost:9966/petclinic/userInfo" class="w3-bar-item w3-button">Create Event</a>
      <a href="http://localhost:9966/petclinic/employees/find.html" class="w3-bar-item w3-button">Employee</a>
      <a href="http://localhost:9966/petclinic/oups.html" class="w3-bar-item w3-button">Admin</a>
      
    </div>
  </div>
</div>

<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- Employee schedule -->

	
    <div class="w3-col m6 w3-padding-large">
   
      <center><h1 class="w3-center">Schedule</h1><br></center>
      <p class="w3-large">Here is your following schedule.</p>
    <center>
<script language="javascript" type="text/javascript">
var day_of_week = new Array('Sun','Mon','Tue','Wed','Thu','Fri','Sat');
var month_of_year = new Array('January','February','March','April','May','June','July','August','September','October','November','December');

//  DECLARE AND INITIALIZE VARIABLES
var Calendar = new Date();

var year = Calendar.getFullYear();     // Returns year
var month = Calendar.getMonth();    // Returns month (0-11)
var today = Calendar.getDate();    // Returns day (1-31)
var weekday = Calendar.getDay();    // Returns day (1-31)

var DAYS_OF_WEEK = 7;    // "constant" for number of days in a week
var DAYS_OF_MONTH = 31;    // "constant" for number of days in a month
var cal;    // Used for printing

Calendar.setDate(1);    // Start the calendar day at '1'
Calendar.setMonth(month);    // Start the calendar month at now


/* VARIABLES FOR FORMATTING
NOTE: You can format the 'BORDER', 'BGCOLOR', 'CELLPADDING', 'BORDERCOLOR'
      tags to customize your caledanr's look. */

var TR_start = '<TR>';
var TR_end = '</TR>';
var highlight_start = '<TD WIDTH="30"><TABLE CELLSPACING=0 BORDER=1 BGCOLOR=DEDEFF BORDERCOLOR=CCCCCC><TR><TD WIDTH=20><B><CENTER>';
var highlight_end   = '</CENTER></TD></TR></TABLE></B>';
var TD_start = '<TD WIDTH="30"><CENTER>';
var TD_end = '</CENTER></TD>';

/* BEGIN CODE FOR CALENDAR
NOTE: You can format the 'BORDER', 'BGCOLOR', 'CELLPADDING', 'BORDERCOLOR'
tags to customize your calendar's look.*/

cal =  '<TABLE BORDER=1 CELLSPACING=0 CELLPADDING=0 BORDERCOLOR=BBBBBB><TR><TD>';
cal += '<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=2>' + TR_start;
cal += '<TD COLSPAN="' + DAYS_OF_WEEK + '" BGCOLOR="#EFEFEF"><CENTER><B>';
cal += month_of_year[month]  + '   ' + year + '</B>' + TD_end + TR_end;
cal += TR_start;

//   DO NOT EDIT BELOW THIS POINT  //

// LOOPS FOR EACH DAY OF WEEK
for(index=0; index < DAYS_OF_WEEK; index++)
{

// BOLD TODAY'S DAY OF WEEK
if(weekday == index)
cal += TD_start + '<B>' + day_of_week[index] + '</B>' + TD_end;

// PRINTS DAY
else
cal += TD_start + day_of_week[index] + TD_end;
}

cal += TD_end + TR_end;
cal += TR_start;

// FILL IN BLANK GAPS UNTIL TODAY'S DAY
for(index=0; index < Calendar.getDay(); index++)
cal += TD_start + '  ' + TD_end;

// LOOPS FOR EACH DAY IN CALENDAR
for(index=0; index < DAYS_OF_MONTH; index++)
{
if( Calendar.getDate() > index )
{
  // RETURNS THE NEXT DAY TO PRINT
  week_day =Calendar.getDay();

  // START NEW ROW FOR FIRST DAY OF WEEK
  if(week_day == 0)
  cal += TR_start;

  if(week_day != DAYS_OF_WEEK)
  {

  // SET VARIABLE INSIDE LOOP FOR INCREMENTING PURPOSES
  var day  = Calendar.getDate();

  // HIGHLIGHT TODAY'S DATE
  if( today==Calendar.getDate() )
  cal += highlight_start + day + highlight_end + TD_end;

  // PRINTS DAY
  else
  cal += TD_start + day + TD_end;
  }

  // END ROW FOR LAST DAY OF WEEK
  if(week_day == DAYS_OF_WEEK)
  cal += TR_end;
  }

  // INCREMENTS UNTIL END OF THE MONTH
  Calendar.setDate(Calendar.getDate()+1);

}// end for loop

cal += '</TD></TR></TABLE></TABLE>';

//  PRINT CALENDAR
document.write(cal);

//  End -->
</script>
</center>

  </div>
  
<div class="w3-content" style="max-width:1100px">

  <!-- Employee contact  -->

	
    <div class="w3-col m6 w3-padding-large">
   
      <center><h1 class="w3-center">Employee Contact</h1><br></center>
      <p class="w3-large">Here is a list of employees and their contact information</p>
      <head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>

<table>
  <tr>
    <th>Name</th>
    <th>Phone Number</th>
    <th>Email</th>
  </tr>
  <tr>
    <td>Gabby Peterson</td>
    <td>403-691-0769</td>
    <td>g_m_peterson@gmail.com</td>
  </tr>
  <tr>
    <td>Meaghan Coatcheck</td>
    <td>604-333-1290</td>
    <td>meeghans_jackets_intheriver@hotmail.com</td>
  </tr>
  <tr>
    <td>Jake smith</td>
    <td>250-901-2213</td>
    <td>j_smith@gmail.com</td>
  </tr>

</table>
    
    </div>
  </div>
  
  <div class="w3-content" style="max-width:1100px">

  <!-- About Section -->

	
    <div class="w3-col m6 w3-padding-large">
   
      <center><h1 class="w3-center">View Upcoming Events</h1><br></center>
      <p class="w3-large">Here is a list of upcoming events</p>
          <head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>

<table>
  <tr>
    <th>Type of Event</th>
    <th>Date</th>
    <th>Information</th>
  </tr>
  <tr>
    <td>Halloween</td>
    <td>October 31st 2017</td>
    <td><p><a href="file:///Users/hayleymclennan/Desktop/eventInformation.html">Click Here</a></p></td>
  </tr>
  <tr>
    <td>Wedding</td>
    <td>December 10th 2017</td>
    <td><p><a href="file:///Users/hayleymclennan/Desktop/eventInformation.html">Click Here</a></p></td>
  </tr>
  <tr>
    <td>Anniversary </td>
    <td>January 5th 2017</td>
    <td><p><a href="file:///Users/hayleymclennan/Desktop/eventInformation.html">Click Here</a></p></td>
  </tr>

</table>
    
    </div>
  </div>
    </div>
  </div>
  <hr>

  <!-- Contact Section -->
  <div class="w3-container w3-padding-64" id="contact">
    <h1>Request Days Off </h1><br>
    <form action="/action_page.php" target="_blank">
      <p><input class="w3-input w3-padding-16" type="text" placeholder="Name" required name="Name"></p>
      <p><input class="w3-input w3-padding-16" type="number" placeholder="Enter The Requested Dates" required name="People"></p>
      <p><input class="w3-input w3-padding-16" type="text" placeholder="Reason" required name="Message"></p>
      <p><button class="w3-button w3-light-grey w3-section" type="submit">Request Days Off</button></p>
    </form>
  </div>
</body>
</html>


=======
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="employees">

    <h2>Find Employees</h2>

    <spring:url value="/employees.html" var="formUrl"/>
    <form:form modelAttribute="employee" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-employee-form">
        <div class="form-group">
            <div class="control-group" id="lastName">
                <label class="col-sm-2 control-label">Last name </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="lastName" size="30" maxlength="80"/>
                    <span class="help-inline"><form:errors path="*"/></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find Employee</button>
            </div>
        </div>

    </form:form>

    <br/>
    <a class="btn btn-default" href='<spring:url value="/employees/new" htmlEscape="true"/>'>Add Employee</a>
</petclinic:layout>
>>>>>>> 6f2630722bd98f5a5ea02a83ded195ade669139c
