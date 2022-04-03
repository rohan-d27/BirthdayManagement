<!DOCTYPE html>
<%@page import="project.entities.PackagesInfoTable"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@page import="project.entities.ServiceProviderInfoTable"%>
<%@page import="project.entities.ServicesInfoTable"%>
<%@page import="project.entities.CustomerInfoTable"%>
<%@page import="project.entities.AdminInfoTable"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Packages</title>
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


        <!-- subheader -->
        <section id="subheader" class="subheader_02 dark no-top no-bottom" data-stellar-background-ratio=".2">
            <div class="wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center fadeScroll relative" data-scroll-speed="2">
                            <h2 data-scroll-speed="8">Packages</h2>
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
						
					   <div class="col-md-12">
							<div class="item pricing">
								<div class="container">
								<% List<PackagesInfoTable> list= (List<PackagesInfoTable>)request.getAttribute("packages");%>
									<div class="row">
									
                                 <%for(int i=0;i<list.size()-1;i++) 
								 {%>  <form action="/ViewOrderDetails" method="post">  
									<div class="col-sm-4">
											<div class="pricing-s1 mb30">
												
													
													
												<div class="top">
												<h2 class="s1"><%=list.get(i).getPackageName() %></h2>
												<input type="hidden" name="packageId" value="<%=list.get(i).getPackageId() %>">
													<p class="price"><span class="currency"> &#8377;</span> <b><%=list.get(i).getPackagePrice()%></b>
												</div>
												<div class="bottom">
													
													<ul> 
													<%for(int j=0;j<list.get(i).getServicesInfoTables().size();j++) 
													
													{%>
													
                                                     <li> <i class="icon_check"></i><%=list.get(i).getServicesInfoTables().get(j).getServiceName() %> </li>
                                                    	
                                             
													<%} %>	
													</ul>
													
													  <button type="submit" class="btn btn-custom">Buy</button>
												</div>
											</div>
											
										</div>
										</form>
									<%} %>
									
									<form action="/CustomPackage"">
                                        <div class="col-sm-4">
											<div class="pricing-s1 mb30">
												<div class="top">
													<h2 class="s1">Custom Package</h2>
														<input type="hidden" name="packageId" value="1111">
													<p class="price"><span class="currency"> &#8377;</span> <b>?????</b>
												</div>
												<div class="bottom">
													<ul>
                                                        <li><i class="icon_check"></i>Birthday Cake</li>
														<li><i class="icon_check"></i>Decoration Layout</li>
                                                        <li><i class="icon_check"></i>Food And Drinks</li>
														<li><i class="icon_check"></i>Album + Video</li>
														<li><i class="icon_check"></i>Music Entertaiment</li>
													</ul>
													 <button type="submit" class="btn btn-custom">Buy</button>
													<!-- <a href=" class="btn btn-custom">Make</a> -->
												</div>
											</div>
										</div>
									</form>
									</div>	
								</div>
							</div>


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
                            &copy; Copyright 2022 - Desingned by Group13                    
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
