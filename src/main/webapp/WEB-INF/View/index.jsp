<!DOCTYPE html>
<%@page import="project.entities.ServiceProviderInfoTable"%>
<%@page import="project.entities.CustomerInfoTable"%>
<%@page import="project.entities.AdminInfoTable"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Birthday Party Organizer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Lovus is responsive wedding html website template">
    <meta name="keywords" content="wedding,couple,ceremony,reception,rsvp,gallery,event,countdown">
    <meta name="author" content="">

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

<body id="homepage">

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
                                     <a href="/CustomerProfile"><%=customer.getCustomerFname()+" "+customer.getCustomerLname()%></a>
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
                                     <a href="/ServiceProviderDashboard"><%=serviceprovider.getServiceProviderFname()+" "+serviceprovider.getServiceProviderLname() %></a>
                                    <ul>
                                    <li><a href="/ordersporderlist">OrdersInfo</a></li>
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

        <!-- content begin -->
        <div id="content" class="no-bottom no-top">

            <!-- section begin -->
            <section id="section-hero" class="full-height relative text-light z1 owl-slide-wrapper" data-stellar-background-ratio=".2">
                <div class="owl-slider-nav">
                    <div class="next"></div>
                    <div class="prev"></div>
                </div>

                <div class="center-y fadeScroll text-center relative" data-scroll-speed="4">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2">
                                  
								   <div class="spacer-double"></div>
								   <h1 class='s2'><span>Birthday Party Organizer</span></h1>
								   <h4 class='s3'>Birthday Planner</h4>
								   <div class="spacer-double"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="custom-owl-slider" class="owl-slide" data-scroll-speed="2">
                    <div class="item">
                        <img src="images_02/slider/1.jpg" alt="">
                    </div>
                    <div class="item">
                        <img src="images_02/slider/2.jpg" alt="">
                    </div>
                </div>
            </section>
            <!-- section close -->


            <!-- section begin -->
            <section id="section-about">
                <div class="container">
                    <div class="row text-center">

                        <div class="col-md-8 col-md-offset-2">
							<h2 class="s1">Welcome</h2>
							<div class="small-border"></div>
							<p class="lead">
                                Birthday Organizers has always been an exclusive, one of a kind platform enjoying a specialist's reputation for event organising. Irrespective of the reason behind your celebration, or your event type, We are ready to help you at every step of your birthday planning. Are you looking for a Birthday Planner near me? We can provide you the Best Birthday Planner , along with other small cities of north India. The best part is that, we can provide you the service irrespective of the time in hand and give you full control over things.
                            </p>
						</div>
						
						<div class="spacer-single"></div>
						
						<div class="col-md-4">
							<i class="icon-chat id-color mb20 size40"></i>
							<h4>Initial Consultation Contact Us</h4>
                            <p> B-30, near Shivajinagar Railway Status, Shubhas Nagar, Pune,110058
                                +91 - 7048983892
                                +91 - 9871023893
                                birthdaypartyoragnizer@outlook.com</p>
                        </div>
						
						<div class="col-md-4">
							<i class="icon-map id-color mb20 size40"></i>
							<h4>Bithday Venues</h4>
							<p>
                                Who said finding the right venue was easy? Whether you are looking for a picnic-themed party or an outdoor venue, a party planner can help you find it at the most affordable prices. They can also book a fabulous venue at great discounts.

                            </p>
						</div>
						
						<div class="col-md-4">
							<i class="icon-calendar id-color mb20 size40"></i>
							<h4>Full Bithday Management</h4>
                            <p>
                                The primary advantage of hiring a Birthday Planner is saving time. It's undeniable that there are a lot of things that need to be taken care of, and this is where a professional can help you.

                            </p>
							</div>

                        <div class="spacer-double"></div>
                    </div>
                </div>
            </section>
            
			<!-- section begin -->
            <section id="section-latest-wedding">
                <div class="container">
                    <div class="row">
						<div class="col-md-12 text-center">
                            <h2 class="s1">Latest Birthday</h2>
                            <div class="small-border"></div>
                        </div>
						
						<div id="testimonial-carousel-3" class="de_carousel" data-wow-delay=".3s">

                            <div class="col-md-6 item">
                                <div class="de_testi opt-3">
									<figure class="pic-hover img-rounded hover-scale mb30">
											<img src="images_02/misc/w1.jpg" class="img-responsive" alt="">
									</figure>
                                    <blockquote>
                                        <p>Everything ran really smoothly and we all had a wonderful day. We couldn't have done it without you! I'd be happy to put up some photos on the website and recommend you to everybody. </p>
                                        <div class="de_testi_by">
                                            Sarah, Friend 
                                        </div>
                                    </blockquote>

                                </div>
                            </div>

                            <div class="col-md-6 item">
                                <div class="de_testi opt-3">
									<figure class="pic-hover img-rounded hover-scale mb30">
											<img src="images_02/misc/w2.jpg" class="img-responsive" alt="">
									</figure>
                                    <blockquote>
                                        <p>Everything ran really smoothly and we all had a wonderful day. We couldn't have done it without you! I'd be happy to put up some photos on the website and recommend you to everybody. </p>
                                        <div class="de_testi_by">
                                            John, Friend
                                        </div>
                                    </blockquote>
                                </div>
                            </div>

                            <div class="col-md-6 item">
                                <div class="de_testi opt-3">
									<figure class="pic-hover img-rounded hover-scale mb30">
											<img src="images_02/misc/w3.jpg" class="img-responsive" alt="">
									</figure>
                                    <blockquote>
                                        <p>Everything ran really smoothly and we all had a wonderful day. We couldn't have done it without you! I'd be happy to put up some photos on the website and recommend you to everybody. </p>
                                        <div class="de_testi_by">
                                            Jenny, Friend 
                                        </div>
                                    </blockquote>
                                </div>
                            </div>

                            <div class="col-md-6 item">
                                <div class="de_testi opt-3">
									<figure class="pic-hover img-rounded hover-scale mb30">
											<img src="images_02/misc/w4.jpg" class="img-responsive" alt="">
									</figure>
                                    <blockquote>
                                        <p>Everything ran really smoothly and we all had a wonderful day. We couldn't have done it without you! I'd be happy to put up some photos on the website and recommend you to everybody. </p>
                                        <div class="de_testi_by">
                                             Michael, Friend
                                        </div>
                                    </blockquote>
                                </div>
                            </div>
                        </div>
						
                        <div class="clearfix"></div>
                    </div>
                </div>
            </section>
            <!-- section close -->
			
			 
			
			<!-- section begin -->
            <section class="call-to-action bg-color text-light pt40 pb30 bg-color">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8">
                            <h4 class="mt10">Looking for best planner for your Birthday day?</h4>
                        </div>

                        <div class="col-md-4 text-right">
                            <a href="/Contact" class="btn btn-border">Contact Us</a>
                        </div>
                    </div>
                </div>
            </section>
            <!-- section close -->

        </div>
        <!-- content close -->

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
