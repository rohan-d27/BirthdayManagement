<!doctype html>
<html>

<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Customer Registration</title>
    
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
            color: whitesmoke;
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
                        <span id=""></span>
                        <!-- small button close -->
                        
                        <a href="/Contact" class="btn-rsvp">Contact</a>

                        <!-- mainmenu begin -->
                        <nav>
                            <ul id="mainmenu">
                                <li><a href="/">Home</a> </li>

                                <li><a href="/services">Services</a></li>
                                <li><a href="/packages">Packages</a></li>
                            
                            </ul>
                        </nav>
                        <!-- mainmenu close -->

                    </div>

                </div>
            </div>
        </header>
        <!-- header close -->>

  
                         

    
    <br><br><br><br><br><br><br>
<body oncontextmenu=' false' class='snippet-body'>
    <div class="container rounded bg-#ccad00 mt-5 mb-5">
        <div class="col-md-3">
           
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"></div>
        </div>
        <div class="col-md-4">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3 text-center" >
                    <h3 class="text-right">Register</h3>
                </div>

                <div class="row mt-3" >
                    <form action="/CustomerInsert" method="post">
                    
                        <div class="form-outline mb-4">
                            <label for="customerFname" class="form-label">First Name</label>
                            <input type="text" name="customerFname" id="customerFname" class="form-control" placeholder="First Name"  required>
                        
                        </div>
                        <div class="form-outline mb-4">
                            <label for="customerLname" class="form-label">Last Name</label>
                            <input type="text" name="customerLname" id="customerLname"  class="form-control" placeholder="Last Name"    required>  
                        </div>
                        <div class="form-outline mb-4">
                            <label for="customerUsername" class="form-label">User Name</label> 
                            <input type="text" name="customerUsername" id="customerUsername"  class="form-control" placeholder="User Name" required>
                        </div>  
                         <div class="form-outline mb-4">
                            <label for="customerMobno" class="form-label">Mobile Number</label> 
                            <input type="text "name="customerMobno" id="customerMobno"  pattern="[0-9]+" class="form-control" placeholder="Mobile Number" required>
                         </div>  
                         <div class="form-outline mb-4">
                           
                        </div>
                        <!-- Email input -->
                        <div class="form-outline mb-4">
                            <label class="form-label" for="customerEmail">Email address</label>
                          <input type="email" id="customerEmail" class="form-control" name="customerEmail" placeholder="Email address" />
                        
                        </div>
                    
                        <!-- Password input -->
                        <div class="form-outline mb-4">
                        <label class="form-label" for="customerPassword" >Password</label>
                        <input type="password" id="customerPassword" class="form-control" name="customerPassword" placeholder="Password" />
                        
                        </div>
                    
                        <!-- 2 column grid layout for inline styling -->
                        <div class="row mb-4">
                        <div class="col d-flex justify-content-center">
                            <!-- Checkbox -->
                            <div class="form-check">
                            <input
                                class="form-check-input"
                                type="checkbox"
                                value=""
                                id="form2Example31"
                                checked
                            />
                            <label class="form-check-label" for="form2Example31"> Remember me </label>
                            </div>
                        </div>
                    
                        <div class="col">
                            <!-- Simple link -->
                            <a href="/CustomerForget" style="font-size: medium; color: #448dc2;">Forgot password?</a>
                        </div>
                        </div>
                    
                        <!-- Submit button -->
                        <button class="btn btn-primary profile-button  btn-block mb-4" type="submit">Register</button>
                        <!-- <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button> -->
                    
                        <!-- Login buttons -->
                        <div class="text-center">
                        <p>Already a member? <a href="/CustomerLogin" style="font-size: medium; color: #448dc2;">Login</a></p>
                        
                        </div>
                    </form>
                   

                </div>

            </div>
        </div>
        <div class="col-md-4">
            <div class="p-3 py-5">
               
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