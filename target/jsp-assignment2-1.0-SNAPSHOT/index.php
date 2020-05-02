<?php
//register session
session_start();
include('includes/config.php');
if(isset($_POST['submit']))
{
$regno=$_POST['regno'];
$fname=$_POST['fname'];
$mname=$_POST['mname'];
$lname=$_POST['lname'];
$gender=$_POST['gender'];
$contactno=$_POST['contact'];
$emailid=$_POST['email'];
$password=$_POST['password'];
$query="insert into  userRegistration(regNo,firstName,middleName,lastName,gender,contactNo,email,password) values(?,?,?,?,?,?,?,?)";
$stmt = $mysqli->prepare($query);
$rc=$stmt->bind_param('sssssiss',$regno,$fname,$mname,$lname,$gender,$contactno,$emailid,$password);
$stmt->execute();
echo"<script>alert('Student Succssfully register');</script>";
}
?>

<!doctype html>
<html>
    <head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, maximum-scale=1">

<link href="./loginstyle.css" rel="stylesheet" type="text/css">

<script>
//register session
function valid()
{
if(document.registration.password.value!= document.registration.cpassword.value)
{
alert("Password and Re-Type Password Field do not match  !!");
document.registration.cpassword.focus();
return false;
}
return true;
}
</script>
 </head>



<body>
    
    
 <div class="nav_header">
            <h1 class="heading">STUDENTS ACCOMODATION SYSTEM</h1>
        </div>
<div class="container" id="container">
	<div class="form-container sign-up-container">
        <form method="post" action="" name="registration" onSubmit="return valid();">
            
            <h1>Create an Account</h1>

            <input id="regno" type="text" placeholder="Registration Number" name="regno"   class="form-control" required="required" >
            <span class="invalid-feedback" role="alert"></span>

            <input type="text" name="fname" id="fname" placeholder="First Name" class="form-control" required="required" >
            <span class="invalid-feedback" role="alert"></span>
            <input type="text" name="mname" id="mname" placeholder="Middle Name" class="form-control">
            <input type="text" name="lname" id="lname" placeholder="Last Name" class="form-control" required="required">
            <span class="invalid-feedback" role="alert"></span>
            <select name="gender" class="form-control" required="required">
                <option value="">Select Gender</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="others">Others</option>
            </select>
            <input type="text" name="contact" id="contact" placeholder="Contact No" class="form-control" required="required">
            <span class="invalid-feedback" role="alert"></span>
            <input id="email" type="email" placeholder="Email" class="form-control" name="email" onBlur="checkAvailability()" required="required">
            <span class="invalid-feedback" role="alert"></span>
            <input id="password" type="password" placeholder="Password" type="password" class="form-control" name="password" required="required">
            <span class="invalid-feedback" role="alert"></span>
            <input id="password-confirm" type="password" placeholder="Confirm Password" class="form-control" name="cpassword" class="form-control" required="required">

            <button type="submit" name="submit">Register</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
        <form method="POST" action="">
            
			<h1>Login to Account</h1>

            <input id="email" type="email" placeholder="Email" class="form-control @error('email') is-invalid @enderror" name="email" value="" required autocomplete="email" autofocus>
           
            <span class="invalid-feedback" role="alert">
                <strong></strong>
            </span>
    
            </input>
            <input id="password" input type="password" placeholder="Password" class="" name="password" required autocomplete="current-password">
            
            <span class="invalid-feedback" role="alert">
        
            </span>
    
            <button>Login</button>

            
            <a href="">Forgot Password</a>
            <a href="">Login as Admin</a>
          
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome Back!</h1>
				<p>Have an account? Come, Login and start managing your booked hostels.</p>
				<button class="ghost" id="signIn">Login</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Hello, Student!</h1>
				<p>Need an Account? Come, Register with us and book your own hostels.</p>
				<button class="ghost" id="signUp">Register</button>
			</div>
		</div>
	</div>
</div>

<script>
//Registering
function checkAvailability() {

$("#loaderIcon").show();
jQuery.ajax({
url: "check_availability.php",
data:'emailid='+$("#email").val(),
type: "POST",
success:function(data){
$("#user-availability-status").html(data);
$("#loaderIcon").hide();
},
error:function ()
{
event.preventDefault();
alert('error');
}
});
}
</script>

</body>
</html>
