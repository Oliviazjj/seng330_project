<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout2 pageName="welcome">


    <!-- Page content -->
    <div class="w3-content" style="max-width:1100px">

      <!-- About Section need to finish this -->
      <!--
    </br>
    </br>
    </br>
    </br>
    <div class="w3-content w3-section" style="max-width:500px">
      <img class="mySlides" src="Desktop/seng330/src/main/webapp/WEB-INF/jsp/auth/catering.jpg" style="width:100%">
      <img class="mySlides" src="Desktop/seng330/src/main/webapp/WEB-INF/jsp/auth/catering2.jpg" style="width:100%">
      <img class="mySlides" src="Desktop/seng330/src/main/webapp/WEB-INF/jsp/auth/catering3.jpg" style="width:100%">
      <img class="mySlides" src="Desktop/seng330/src/main/webapp/WEB-INF/jsp/auth/catering4.jpg" style="width:100%">
    </div>

    <script>
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
           x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {myIndex = 1}
        x[myIndex-1].style.display = "block";
        setTimeout(carousel, 2000); // The image will change every 2 seconds
    }
    </script>
    -->
        <div class="w3-col m6 w3-padding-large">
        </br>
        </br>
          <h1><p align = "center">Welcome!</h1></p>
          <p align = "center"> Welcome to MealsOnWheels, a catering company that cares for its clients for everything from small social parties to weddings, office lunches, or large corporate events and evertyhing in between.
          Our team sets the highest standard of excellence in everything we do can ensure our clients a stress free experience when hosting or attending an event. Our staff are friendly, professional, and highly experienced with all levels of catering and event management. At MealsOnWheels we also offer an array of additional event coordination services such as venue rentals & bookings, equipment, cats, staff rental and everything needed to make your next catered event a success.</p>



</petclinic:layout2>
