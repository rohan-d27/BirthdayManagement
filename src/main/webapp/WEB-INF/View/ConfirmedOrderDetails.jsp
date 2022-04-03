<!doctype html>
<%@page import="project.entities.ServiceProviderInfoTable"%>
<%@page import="project.entities.AdminInfoTable"%>
<%@page import="project.entities.PackagesInfoTable"%>
<%@page import="project.entities.OrdersInfoTable"%>
<%@page import="project.entities.CustomerInfoTable"%>
<html>

<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Confirmed Order</title>

<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/animate.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
<link rel="stylesheet" href="css/jquery.countdown.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/animsition.min.css" type="text/css">

<!-- custom background -->
<link rel="stylesheet" href="css/bg.css" type="text/css">

<!-- color scheme -->
<link rel="stylesheet" href="css/color.css" type="text/css" id="colors">
<link
	href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css'
	rel='stylesheet'>
<link href='' rel='stylesheet'>
<script type='text/javascript'
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<style>
body {
	background: #ccad00
}

.form-control:focus {
	box-shadow: none;
	border-color: #BA68C8
}

.profile-button {
	background: rgb(99, 39, 120);
	box-shadow: none;
	border: none
}

.profile-button:hover {
	background: #682773
}

.profile-button:focus {
	background: #682773;
	box-shadow: none
}

.profile-button:active {
	background: #682773;
	box-shadow: none
}

.back:hover {
	color: #682773;
	cursor: pointer
}

.labels {
	font-size: 11px
}

.add-experience:hover {
	background: #BA68C8;
	color: #fff;
	cursor: pointer;
	border: solid 1px #BA68C8
}
</style>
</head>
<div id="wrapper">
	<!-- header begin -->
	<header>


		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- logo begin -->
					<div id="logo">
						<a href="index.html">
                            <img class="logo" src="images_02/logo-2.png" alt="">
                            <img class="logo-2" src="images_02/logo.png" alt="">
                        </a>
					</div>
					<!-- logo close -->

					<!-- small button begin -->
					<span id="menu-btn"></span>
					<!-- small button close -->

					<a href="/Contact" class="btn-rsvp">Contact</a>

    <!-- mainmenu begin -->
                        <nav>
                            <ul id="mainmenu">
                                <li><a href="/">Home</a></li>
								<li><a href="/about">About</a></li>
                                <li><a href="/services">Services</a></li>
                                <li><a href="/packages" >Packages</a></li>
                                <%
                                   AdminInfoTable admin=(AdminInfoTable)session.getAttribute("Admin"); 
                                  CustomerInfoTable customer=(CustomerInfoTable)session.getAttribute("Customer");
                                  ServiceProviderInfoTable serviceprovider=(ServiceProviderInfoTable)session.getAttribute("Serviceprovider");
                                  if(admin==null && customer==null && serviceprovider==null)
                                  {
                                  
                                %>
                                
                                 <li><a href="login-form/Login.html">Login</a>
                                    <ul>
                                    <li><a href="/CustomerLogin">Customer</a></li>
                                    <li><a href="/AdminLogin">Admin</a></li>
                                    <li><a href="/ServiceProviderLogin">Service Provider</a></li>
                                  </ul>
                                </li>
                                <%}
                                  else if(customer!=null)
                                  {%>
                                <li>
                                     <a href="#"><%=customer.getCustomerFname()+" "+customer.getCustomerLname()%></a>
                                    <ul>
                                    <li><a href="/ordercustomerorderlist">OrdersInfo</a></li>
                                    <li><a href="/logout">Logout</a></li>
                                   
                                     </ul>
                                </li>
                                <%}
                                  else if(serviceprovider!=null)
                                  {
                                  %>
                                   <li>
                                     <a href="#"><%=serviceprovider.getServiceProviderFname()+" "+serviceprovider.getServiceProviderLname() %></a>
                                    <ul>
                                    <li><a href="/logout">Logout</a></li>
                                   
                                  </ul>
                                </li>
                              
                                <% }
                                  else if(admin!=null)
                                  {
                                	 %> 
                                  <li>
                                     <a href="/AdminDashboardPackageDetails"><%=admin.getAdminFname()+" "+admin.getAdminLname() %></a>
                                    <ul>
                                    <li><a href="login.html">View Order Details</a></li>
                                    <li><a href="/logout">Logout</a></li>
                                  </ul>
                                </li>
                                	 
                               <% 	  
                                  }
                                %>  
                             
                            </ul>
                        </nav>
						<!-- mainmenu close -->


				

				</div>

			</div>
		</div>
	</header>
	<!-- header close -->





	<br> <br> <br> <br> <br> <br> <br>
	<body oncontextmenu='false' class='snippet-body'>

		<% 

   OrdersInfoTable order=(OrdersInfoTable)request.getAttribute("order");
   PackagesInfoTable package1=(PackagesInfoTable)request.getAttribute("package");
%>


		<div class="container rounded bg-white mt-5 mb-5">

			<div class="row">

				<div class="col-md-3 border-right">
					<!--  <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span> </span></div> -->
					<div
						class="d-flex flex-column align-items-center text-center p-3 py-5">
						<span class="font-weight-bold">Welcome <%=customer.getCustomerFname() %></span><span
							class="text-black-50"><%=customer.getCustomerEmail() %></span><span>
						</span>
					</div>
				
					
				</div>
				<div class="col-md-5 border-right">
					<form action="/cancelorder" method="post">
                       
						<div class="p-3 py-5">
							<div
								class="d-flex justify-content-between align-items-center mb-3">
								<h4 class="text-right">Order details</h4>
							</div>
							<div class="row mt-3">
								<div class="col-md-12">
								<input type="hidden" name="orderId" value="<%=order.getOrderId() %>>">

									<label class="labels">Event Date</label> <input type="date" name="eventDate"	class="form-control" placeholder="Date"
										value="<%=order.getEventDate() %>">
								</div>
								<div class="col-md-12">
									<label class="labels">Event Time</label> <input type="time"	class="form-control" value="<%=order.getEventTime() %>" placeholder="Time" name="">
								</div>
								<div class="col-md-12">
									<label class="labels">Event Venue</label> <input type="text" class="form-control" value="<%=order.getEventVenue() %>"
										placeholder="Venue">
								</div>

								<div class="col-md-12">
							     <label class="labels">Number of Guests </label> <input type="text" class="form-control" placeholder="NoofGuest" value="<%=order.getNumberOfGuests() %>">
								</div>
								<div class="col-md-12">
									<label class="labels">Order Amount</label> <input type="text" class="form-control" placeholder="Amount"
										value="<%=order.getOrderAmount() %>">
								</div>
                                <div class="col-md-12">
									<label class="labels">Order Status</label> <input type="text" class="form-control" placeholder="Amount"
										value="<%=order.getOrderStatus() %>">
								</div>

							</div>
                            <input type="text" name="customerId" value="<%=customer.getCustomerId() %>" style="visibility: hidden;">

							<div class="mt-5 text-center">
								<button class="btn btn-primary profile-button" type="submit">Cancel Order</button>
							</div>
						</div>
					</form>
                

				</div>
				<div class="col-md-4">
					<div class="p-3 py-5">
						<div
							class="d-flex justify-content-between align-items-center experience">
							<span>
								<h4>Package Information</h4>
							
						</div>
						<br>
						<div class="col-md-12">
							<label class="labels">Name</label> <input type="text" value="<%=package1.getPackageName() %>" class="form-control" placeholder="Name" readonly>
						</div>
						<br>
						<div class="col-md-12">
							<label class="labels">Details</label><input type="text" readonly class="form-control" placeholder="Details" value="<%=package1.getPackageDesc()%>">
						</div>
						<br>
						<div class="col-md-12">
							<label class="labels">Price</label> <input type="text" readonly class="form-control" placeholder="Price" value="<%=package1.getPackagePrice() %>">
						</div>
						<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                        <div class="mt-5 text-center">
                            <a href="/customerlogout"> <button class="btn btn-primary profile-button" type="submit">Logout</button></a>
                           
                        </div>
					</div>
				</div>

			</div>

		</div>
</div>
</div>
<script type="text/javascript">
    
    </script>

<script type='text/javascript'
	src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
<script type='text/javascript' src=''></script>
<script type='text/javascript' src=''></script>
<script type='text/Javascript'></script>

<!-- footer begin -->
<footer>
	<div class="container text-center text-light">
		<div class="row">
			<div class="col-md-12">
				<h2 class="hs1 wow fadeInUp">
					<span>Birthday Party Organizer</span>
				</h2>
			</div>
		</div>
	</div>

	<div class="subfooter">
		<div class="container text-center">
			<div class="row">
				<div class="col-md-12">&copy; Copyright 2022 -Group 13</div>
			</div>
		</div>
	</div>
</footer>
<!-- footer close -->
</body>

<!-- Javascript Files
================================================== -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.isotope.min.js"></script>
<script src="js/easing.js"></script>
<script src="js/owl.carousel.js"></script>
<script src="js/jquery.countTo.js"></script>
<script src="js/validation.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/enquire.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/jquery.plugin.js"></script>
<script src="js/jquery.countdown.js"></script>
<script src="js/countdown-custom.js"></script>
<script src="js/animsition.min.js"></script>
<script src="js/designesia.js"></script>




</html>