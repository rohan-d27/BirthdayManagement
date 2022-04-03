<!doctype html>
<%@page import="project.entities.ServiceProviderInfoTable"%>
<%@page import="project.entities.CustomerInfoTable"%>
<%@page import="project.entities.AdminInfoTable"%>
<%@page import="project.dao.AdminDAO"%>
<html>

<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Admin Profile</title>
    
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
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css' rel='stylesheet'>
    <link href='' rel='stylesheet'>
    <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
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
                    
                    <a href="02_contact.html" class="btn-rsvp">Contact</a>

                        <!-- mainmenu begin -->
                        <nav>
                            <ul id="mainmenu">
                                <li><a href="/">Home</a>
									<ul>
                                        <li><a href="/service">Service</a></li>
                                        <li><a href="/packages">Packages</a></li>
                                        
                                    </ul>
								</li>
								<li><a href="/about">About</a></li>
                                <li><a href="/services">Services</a></li>
                                <li><a href="/packages" >Packages</a></li>
                                <%
                                   AdminInfoTable admin=(AdminInfoTable)session.getAttribute("Admin"); 
                                  CustomerInfoTable customer=(CustomerInfoTable)session.getAttribute("Customer");
                                  ServiceProviderInfoTable serviceprovider=(ServiceProviderInfoTable)session.getAttribute("Serviceprovider");
                                  if(admin!=null && customer!=null && serviceprovider!=null)
                                  {
                                  
                                %>
                                
                               <li><a href="#">Login</a>
                                    <ul>
                                    <li><a href="/CustomerLogin">User</a></li>
                                    <li><a href="/AdminLogin">Admin</a></li>
                                    <li><a href="/ServiceLogin">Service Provider</a></li>
                                  </ul>
                                </li>
                                <%}
                                  else if(customer!=null)
                                  {%>
                                <li>
                                     <a href="#"><%=customer.getCustomerFname()+" "+customer.getCustomerLname()%></a>
                                    <ul>
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
                                     <a href="#"><%=admin.getAdminFname()+" "+admin.getAdminLname() %></a>
                                    <ul>
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
 
    <br><br><br><br><br><br><br>
  <body oncontextmenu='false' class='snippet-body'>
    <div class="container rounded bg-white mt-5 mb-5">
        <form action="">
            <div class="row">

<%
  AdminInfoTable obj=(AdminInfoTable)request.getAttribute("Admin");

%>
                <div class="col-md-3 border-right">
                    <!--  <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span> </span></div> -->
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><span
                            class="font-weight-bold">Welcome <%=obj.getAdminFname()+" "+ obj.getAdminLname()%> </span><span
                            class="text-black-50"><%=obj.getAdminUsername()%></span><span> </span></div>
                </div>
                <div class="col-md-6 border-right">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Profile Settings</h4>
                        </div>
                        <div class="row mt-2">
                            <div class="col-md-6">
                            <label class="labels">First Name</label>
                            <input type="text" class="form-control" placeholder="First name" value="<%=obj.getAdminFname()%>">
                            </div>
                            <div class="col-md-6"><label class="labels">Last Name</label>
                            <input type="text" class="form-control"  placeholder="Last name" value="<%=obj.getAdminLname()%>" placeholder="surname">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-12"><label class="labels">Mobile Number</label>
                            <input type="text" class="form-control" placeholder="Mobile number" value="<%=obj.getAdminMobno() %>">
                            </div>
                            <div class="col-md-12"><label class="labels">Address </label>
                            <input type="text" class="form-control" placeholder="Address" value="">
                            </div>
                            <div class="col-md-12">
                            <label class="labels">City</label>
                            <input type="text" class="form-control" placeholder="City" value="">
                            </div>
                             <div class="col-md-12">
                             <label class="labels">Zipcode</label>
                             <input type="text" class="form-control" placeholder="Zipcode" value="">
                             </div>
                            <!--Readonly email -->
                            <div class="col-md-12"><label class="labels">Email ID</label>
                            <input type="text" class="form-control" placeholder="Email" value="<%=obj.getAdminEmail()%>" readonly></div>

                        </div>
                      <div class="mt-5 text-center">
                        <button class="btn btn-primary profile-button" type="submit">Update Profile</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center experience"><span>Edit
                                Experience</span><span class="border px-3 p-1 add-experience"><i
                                    class="fa fa-plus"></i>&nbsp;Experience</span></div><br>
                        <div class="col-md-12"><label class="labels">Experience </label><input type="text"
                                class="form-control" placeholder="experience" value=""></div> <br>
                        <div class="col-md-12"><label class="labels">Service Details</label><input type="text"
                                class="form-control" placeholder="Service details" value=""></div>
                    </div>
                </div>
               
            </div>
        </form>
    </div>
    </div>
    </div>
    <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
    <script type='text/javascript' src=''></script>
    <script type='text/javascript' src=''></script>
    <script type='text/Javascript'></script>
              
    <!-- footer begin -->
    <footer>
        <div class="container text-center text-light">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="hs1 wow fadeInUp"><span>Birthday Party Organizer</span></h2>
                </div>
            </div>
        </div>

        <div class="subfooter">
            <div class="container text-center">
                <div class="row">
                    <div class="col-md-12">
                        &copy; Copyright 2022 -Group 13                     
                    </div>
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