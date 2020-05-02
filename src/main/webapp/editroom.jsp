<%-- 
    Document   : editroom
    Created on : May 2, 2020, 10:40:43 AM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="./style.css" rel="stylesheet" type="text/css">
    <link href="./rooms.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <nav>
        <div class="nav_header">
            <a href="./">Student accomodation</a>
        </div>

        <div class="authentication_layout">



        </div>
    </nav>
        
         <div class="container">
        <form method="POST" action ="edit_room"  id="contact">
              <div class="card-header">
        
        <p>Add Room</p>
        
    </div>

            <fieldset>
                <label>Room Name</label>
                <input placeholder="Enter room name" value= "<c:out value='${rooms.room_name}' />" name="room_name" type="text" tabindex="1" required autofocus />
            </fieldset>
            <fieldset>

                <fieldset>

                    <label>Room Location</label>
                    <input placeholder="Enter room location" value= "<c:out value='${rooms.room_location}' />" name="room_location" type="text" tabindex="1" required autofocus />
                </fieldset>
                <fieldset>
                    <fieldset>

                        <label>Room Type</label>
                        <input placeholder="Enter room type" value= "<c:out value='${rooms.room_type}' />"  name="room_type" type="text" tabindex="1" required autofocus />
                    </fieldset>
                    
                      <fieldset>
                          
                            <fieldset>

                        <label>Room Status</label>
                        <input placeholder="Enter room status" value= "<c:out value='${rooms.room_status}' />"  name="room_status" type="text" tabindex="1" required autofocus />
                    </fieldset>
                    
                      <fieldset>

                        <label>Student No.</label>
                        <input value= "<c:out value='${rooms.reg_no}' />" name="reg_no" type="text" tabindex="1" required autofocus />
                    </fieldset>

                    <fieldset>
                        <label>Monthly Charge</label>
                        <input placeholder="Enter monthly charge" value= "<c:out value='${rooms.monthly_charge}' />" name="monthly_charge" type="text" tabindex="2" required />
                    </fieldset>
                    
                     <fieldset>
                        <label>Payment Status</label>
                        <input placeholder="Enter payment status" value= "<c:out value='${rooms.payment_status}' />" name="payment_status" type="text" tabindex="2" required />
                    </fieldset>

                    <fieldset>
                        <center>
                            <button class="authentication_button" name="submit" type="submit" id="contact-submit" data-submit="...Sending">Create Room</button>
                        </center>
                    </fieldset>
        </form>
    </div>
    </body>
</html>
