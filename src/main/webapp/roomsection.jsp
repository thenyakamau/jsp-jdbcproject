<%-- 
    Document   : roomsection
    Created on : May 2, 2020, 6:30:13 AM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rooms</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
            <link href="./style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
         <nav>
        <div class="nav_header">
            <a href="./">Student accomodation</a>
        </div>

        <div class="authentication_layout">



        </div>
    </nav>

        
        <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Rooms</h3>
			<hr>
			
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th>Name</th>
						<th>type</th>
						<th>location</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="room" items="${rooms}">

						<tr>
							<td><c:out value="${room.id}" /></td>
							<td><c:out value="${room.room_name}" /></td>
							<td><c:out value="${room.room_type}" /></td>
							<td><c:out value="${room.room_location}" /></td>
                                                        <td><a href="create_room?reg_no=<c:out value='${user.reg_no}' />&id=<c:out value='${room.id}'/>">Book</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
        
    </body>
</html>
