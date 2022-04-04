<!DOCTYPE html>
<%@page import="project.entities.ServiceProviderInfoTable"%>
<%@page import="project.entities.CustomerInfoTable"%>
<%@page import="project.entities.AdminInfoTable"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Cakes</title>
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


        <!-- subheader -->
        <section id="subheader" class="subheader_02 dark no-top no-bottom" data-stellar-background-ratio=".2">
            <div class="wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center fadeScroll relative" data-scroll-speed="2">
                            <h2 data-scroll-speed="8">Cake</h2>
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
                    <div class="blog-list">
                        <div class="col-md-6">
                            <div class="post-content">
                                <div class="post-image">
                                    <figure class="picframe img-rounded mb20">
                                        <a class="image-popup" href="images_02/Cakes/Fruit-cake.jpg">
                                            <span class="overlay-v">
                                                <i></i>
                                            </span>
                                        </a>
                                        <img src="images_02/Cakes/Fruit-cake.jpg"
                                            alt="Designer Cakes for Birthday" class="img-responsive img-rounded">
                                    </figure>
                                </div>

                                <div class="post-wrapper">


                                    <div class="post-text">
                                        <h3>Juicy Fruit Cake</h3>
                                        <p>Fruit cake is so healthy and tasty packed with rich minerals, vitamins, and fibers, which are quite essential to keep your body fresh and strong. This is why people show great interest in buying such a luscious cake at the celebration of every special occasion especially on the events of kids’ birthday parties. </p>
                                    </div>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="post-content">
                                <div class="post-image">
                                    <figure class="picframe img-rounded mb20">
                                        <a class="image-popup" href="images_02/Cakes/Red-velvet.jpg">
                                            <span class="overlay-v">
                                                <i></i>
                                            </span>
                                        </a>
                                        <img src="images_02/Cakes/Red-velvet.jpg"
                                            alt="Cup Cakes for Birthday Party" class="img-responsive img-rounded">
                                    </figure>
                                </div>


                                <div class="post-wrapper">

                                    <div class="post-text">
                                        <h3> Flavorful Red Velvet Cake</h3>
                                        <p>This is the cake, which brings unconditional love and happiness to the celebration especially on the birthday of your loved ones. It symbolizes your love in a graceful way and makes your partner tempt with its heavenly taste and themes. The red velvet cake is something special and unique cake flavours that convey your passion, love, and feel for them in the best possible ways.</p>
                                    </div>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                        
                        <div class="col-md-6">
                            <div class="post-content">
                                <div class="post-image">
                                    <figure class="picframe img-rounded mb20">
                                        <a class="image-popup" href="images_02/Cakes/butter.jpg">
                                            <span class="overlay-v">
                                                <i></i>
                                            </span>
                                        </a>
                                        <img src="images_02/Cakes/butter.jpg"
                                            alt="Chocolates for Birthday party" class="img-responsive img-rounded">
                                    </figure>
                                </div>


                                <div class="post-wrapper">

                                    <div class="post-text">
                                        <h3>Mouth-Melting Butterscotch Cake</h3>
                                        <p>Want to freeze your loved ones at the first bite of the cake? Then the butterscotch flavored cake is the right choice to stun your girl made with high-quality secret ingredients to achieve the utmost taste and perfection. From a range of cake flavour lists, the butterscotch holds the top-notch positions while it is still in high demand.</p>
                                    </div>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="post-content">
                                <div class="post-image">
                                    <figure class="picframe img-rounded mb20">
                                        <a class="image-popup"
                                            href="images_02/Cakes/Black-forest-cake.jpg">
                                            <span class="overlay-v">
                                                <i></i>
                                            </span>
                                        </a>
                                        <img src="images_02/Cakes/Black-forest-cake.jpg"
                                            alt="Plan Birthday Cakes" class="img-responsive img-rounded">
                                    </figure>
                                </div>


                                <div class="post-wrapper">


                                    <div class="post-text">
                                        <h3>Delicious Black-Forest Cake</h3>
                                        <p>You don’t have words to explain the taste and beauty of the black forest cake, which has the nature of melting your mouth at every bite. The layer of the cake is whipped with heavenly tasted white cream that satiates your taste buds and lets you have it again and again.</p>
                                    </div>

                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix"></div>


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
                            &copy; Copyright 2019 - Lovus by Designesia
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