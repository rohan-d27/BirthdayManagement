<!DOCTYPE html>
<%@page import="project.entities.ServiceProviderInfoTable"%>
<%@page import="project.entities.CustomerInfoTable"%>
<%@page import="project.entities.AdminInfoTable"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Services</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Lovus is responsive wedding html website template">
    <meta name="keywords" content="wedding,couple,ceremony,reception,rsvp,gallery,event,countdown">
    <meta name="author" content="">


    <!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<![endif]-->


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
</head>

<body>

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
                                  if(admin==null && customer==null && serviceprovider==null)
                                  {
                                  
                                %>
                                
                                 <li><a href="#">Login</a>
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
                                     <li><a href="/orderlist">OrdersInfo</a></li>
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

        <!-- subheader -->
        <section id="subheader" class="subheader_02 dark no-top no-bottom" data-stellar-background-ratio=".2">
            <div class="wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center fadeScroll relative" data-scroll-speed="2">
                            <h2 data-scroll-speed="8">Services</h2>
                            <div class="small-border"></div>
                            <div class="spacer-double"></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- subheader close -->

        <!-- content begin -->
        <div id="content">
            <div class="container">
                <div class="row">
                    <div class="col-md-2 text-center">
                        <img src="images_02/services/1.png" alt="" class="img-circle mb30" />
                        <h4>Cakes</h4>
                        Looking for some eye-catching and mouth-watering birthday cakes for your birthday which is must in a birthday party

                        <a href="/cakes" class="btn btn-custom">Cake</a>
                    </div>

                   
                    <div class="col-md-2 text-center">
                        <img src="images_02/services/2.png" alt="" class="img-circle mb30" />
                        <h4>Catering</h4>
                        A catering service is a perfect combination of fun and food. Birthday parties 
                        are a celebration anniversary of once birthday.
                        <a href="/catering" class="btn btn-custom">Catering</a>
                    </div>

                    <div class="col-md-2 text-center">
                        <img src="images_02/services/3.png" alt="" class="img-circle mb30" />
                        <h4>Bithday Decoration</h4>
                        The best way to lighten up a  birthday party is by Decoration which enough to fill the atmosphere with brilliant laughs! 
                        <a href="/decoration" class="btn btn-custom">Decoration</a>
                    </div>
                    <div class="col-md-2 text-center">
                        <img src="images_02/services/camera.png" alt="" class="img-circle mb30" />
                        <h4>Photo/Videography</h4>
                        Our specialty is candid pictures. Apart from most obvious shots of person with a cake.We also shoot Videography.
                        <a href="/photovideo" class="btn btn-custom">Photo/Videography</a>
                    </div>
                    <div class="col-md-2 text-center">
                        <img src="images_02/services/music.png" alt="" class="img-circle mb30" />
                        <h4>Music System</h4>
                        We have various sizes and types of sound systems depending on your requirement, location, and the size of the party.
                        <a href="/musicsystem" class="btn btn-custom">Music</a>
                    </div>
                    <div class="col-md-2 text-center">
                        <img src="images_02/services/singing.png" alt="" class="img-circle mb30" />
                        <h4>Entertainment Art</h4>
                        Entertainment &amp; Art for birthday party, it is that wonderful day when you or a loved one was born which calls for a celebration.
                        <a href="/artist" class="btn btn-custom">Entertainment Art</a>
                    </div>

                </div>
            </div>
        </div>

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
                            &copy; Copyright 2022 - Designed by Group13
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- footer close -->

        <a href="#" id="back-to-top"></a>
        <div id="preloader">
            <div class="preloader1"></div>
        </div>
    </div>


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

</body>

</html>