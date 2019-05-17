<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="../css/addReservationStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
		<form id="creator" action="" method="">
			<div class="header">
				<h3>Add new reservation</h3>
				<p>Fill all the fields to create new reservation</p>
			</div>
			<div class="inputs">
				
				Type of reservation: <input type="text" name="name"/><br/>
				First name: <input type="text" name="firstName"/><br/>
				Last name: <input type="text" name="lastName"/><br/>   
				Date: <input type="datetime-local" id="reservationDate"
       				name="date" value="2018-06-04T19:30"
       				min="2018-06-04T00:00" max="2019-06-04T00:00">
			</div>
			<input type="submit" value="Add Reservation">
	</form>
	</div>
</body>
</html>