
<%@page import="project.entities.ServiceProviderInfoTable"%>
<%@page import="java.util.List"%>
<%@page import="project.entities.ServicesInfoTable"%>
<html>

           <head>
               <title>ServiceProviderDashBoard</title>
               <meta charset="utf-8">
               <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
                       font-size: 20px;
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
                   label{
                       color: rgb(51, 116, 128);
                       font-size: medium;
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
               <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
                   
                   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
                   <link rel="stylesheet" href="css/dashstyle.css">
           
           
           
                   <!-- Table Links -->
                   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
                   <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
                   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
                   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
           
           
                   <link rel="stylesheet" href="css/table.css">
                   <script src="js/table.js"></script>
           
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
                                  
                                  ServiceProviderInfoTable serviceprovider=(ServiceProviderInfoTable)session.getAttribute("Serviceprovider");
                                  if(serviceprovider==null)
                                  {
                                  
                                %>
                                
                                 <li><a href="#">Login</a>
                                    <ul>
                                    <li><a href="/userLogin">User</a></li>
                                    <li><a href="/adminLogin">Admin</a></li>
                                    <li><a href="/serviceLogin">Service Provider</a></li>
                                  </ul>
                                </li>
                                <%
                                }
                               
                                
                                  else if(serviceprovider!=null)
                                  {
                                  %>
                                   <li>
                                     <a href="/SeviceDashboardServiceDetails"><%=serviceprovider.getServiceProviderFname()+" "+serviceprovider.getServiceProviderLname() %></a>
                                    <ul>
                                      <li><a href="/ordercustomerorderlist">OrdersInfo</a></li>
                                    <li><a href="/logout">Logout</a></li>
                                   
                                  </ul>
                                </li>
                              
                             <%} %>
                             
                            </ul>
                        </nav>
						<!-- mainmenu close -->


                           </div>

                       </div>
                   </div>
               </header>
               <!-- header close -->

           
                             

               
               <br><br><br><br><br><br><br>
           <body oncontextmenu='false' class='snippet-body' style="background-color: #ccad00;">
               <div class="container rounded bg-white mt-5 mb-5"  style="background-color: #ccad00;">
               
                       <div class="row">
           
                           <div class="col-md-3 border-right">
                               <!--  <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">Edogaru</span><span class="text-black-50">edogaru@mail.com.my</span><span> </span></div> -->
                               <div class="d-flex flex-column align-items-center text-center p-3 py-5"><span
                                       class="font-weight-bold">Welcome <%=serviceprovider.getServiceProviderFname()+" "+serviceprovider.getServiceProviderLname() %></span><span
                                       class="text-black-50"><%=serviceprovider.getServiceProviderEmail() %></span><span> </span></div>
                                   <div class="row mt-2">
                           <div class="col-md-6">
                           <label class="labels">First Name</label>
                           <input type="text" class="form-control" placeholder="First name" value="<%=serviceprovider.getServiceProviderFname()%>" readonly>
                           </div>
                           <div class="col-md-6"><label class="labels">Last Name</label>
                           <input type="text" class="form-control"  placeholder="Last name" value="<%=serviceprovider.getServiceProviderLname()%>" placeholder="Last Name" readonly>
                           </div>
                       </div>
                       <div class="row mt-3">
                           <div class="col-md-12"><label class="labels">Mobile Number</label>
                           <input type="text" class="form-control" placeholder="Mobile number" value="<%=serviceprovider.getServiceProviderMobno() %>">
                           </div>
                          
                           <!--Readonly email -->
                           <div class="col-md-12"><label class="labels">Email ID</label>
                           <input type="text" class="form-control" placeholder="Email" value="<%=serviceprovider.getServiceProviderEmail()%>" readonly></div>

                       </div>   
                                       <div class="mt-5 text-center">
                                   <button class="btn btn-primary profile-button" type="button">
                                   <a href="CustomerProfile.html" style="text-decoration: none;color: #fff;">Change Profile</a>  </button>
                                   <br>
                                   <br>
                                   <br>
                                   </div>
                           </div>
                            
                          
                           <div class="col-md-4">
                             

                                       <div class="table-wrapper">
                                           <div class="table-title">
                                               <div class="row">
                                                   <div class="col-sm-8"><h2><b>Service Details</b></h2></div>
                                                   <div class="col-sm-4">
                                                   <form action="/addNewPackage">
                                                       <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add New</button>
                                                      </form>
                                                   </div>
                                               </div>
                                           </div>
                                           <table class="table table-bordered">
                                               <thead>
                                                   <tr>
                                                       
                                                       <th>Service Id</th>
                                                       <th>Service Name</th>
                                                       <th>Service Description</th>
                                                       <th>Service Cost</th>
                                                        <th>Edit</th>
                                                         <th>Delete</th>
                                                   </tr>
                                               </thead>
                                               <tbody>
                                               <%List<ServicesInfoTable> services=(List<ServicesInfoTable>)request.getAttribute("Services");
                                               for(ServicesInfoTable obj :services)
                                               {
                                                   int id=obj.getServiceId();
                                                   String name=obj.getServiceName();
                                                   String desc=obj.getServiceDesc();
                                                   double cost=obj.getServicePrice();
                                                   %>
                                                   
                                                    <tr>
                                                   
                                                    
                                                      <td><%=id%>  </td>
                                                     
                                                          <td><%=name%></td>
                                                       
                                                        <td> <%=desc%></td>
                                                        
                                                         <td> <%=cost%></td>
                                                   
                                                    <td>
                                                    <form action="/serviceedit" method="post">
                                                    <input type="hidden" name="id" value="<%=id%>">
                                                     <button type="submit" class="btn btn-success btn-block">Edit</button>
                                                    </form> 
                                                      </td>
                                                
                                               
                                                    
                                                     <td>
                                                     <form action="/servicedelete" method="post" >  
                                                     <input type="hidden" name="id" value="<%=id%>"> 
                                                     <button type="submit" class="btn btn-danger btn-block">Delete</button>
                                                     </form> 
                                                    </td>

                                                </tr>
                                              
                                                <% 
                                               }
                                               %>
                                                     
                                               </tbody>
                                           </table>
                                       </div>
                                   
                               
                               
                           </div>
                       
                       </div>
               
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
           <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
       <script type='text/javascript' src=''></script>
       <script type='text/javascript' src=''></script>
       <script type='text/Javascript'></script>
       <script src="js/dashjquery.min.js"></script>
       <script src="js/dashpopper.js"></script>
       <script src="js/dashbootstrap.min.js"></script>
       <script src="js/dashmain.js"></script>
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