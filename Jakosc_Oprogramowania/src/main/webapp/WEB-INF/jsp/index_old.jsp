   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="../css/addReservationStyle.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="btn-group">
  <button class="buttonAdd" onclick="add()">Create new reservation</button>
  <button class="buttonCheck" onclick="check()">Check the reservation list</button>
    
    </div>




<div id="Add">
		<form id="creator" action="" method="">
			<div class="header">
				<h3>Add new reservation</h3>
				<p>Fill all the fields to create new reservation</p>
			</div>
			<div class="inputs">
				
				Type of reservation: <input type="text" name="object"/><br/>
				First name: <input type="text" name="firstName"/><br/>
				Last name: <input type="text" name="lastName"/><br/>   
				Date: <input type="datetime-local" id="reservationDate"
       				name="date" value="2018-06-04T19:30"
       				min="2018-06-04T00:00" max="2019-06-04T00:00">
			</div>
			<input type="submit" value="Add Reservation">
	</form>
</div>
	
<div id="Check">
    <div class="header">
	<h3>All Reservations</h3>
    </div>
			<c:forEach var="listValue" items="${lists}">
				<ul>
				${listValue.getId()}, 
				${listValue.getResObject()}
				${listValue.getFirstName()}
				${listValue.getLastName()}
				${listValue.getResDate()}
				
				</ul>
			</c:forEach>
</div>		
	
	
<script>
    var x = document.getElementById("Add");
    var y = document.getElementById("Check");

    function add() {
       
    if (x.style.display == "block") {
        x.style.display = "none";
		
    } else {
       x.style.display = "block";
        y.style.display = "none";
        
            }
        
}
        
    function check() {
        
             		
     if (y.style.display == "block") {
        y.style.display = "none";
    } else {
       x.style.display = "none";
        y.style.display = "block";
    }
        
}
        
    
    </script>	
</body>
</html>