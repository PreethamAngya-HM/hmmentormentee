<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1" />
	    <meta name="viewport" content="width=device-width, initial-scale=1" />
	    <title>Mentor Mentee</title>
	
	    <!-- Bootstrap Core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		
	    <!-- Custom Fonts -->
	    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	    
	    <!-- Theme CSS -->
	    <!-- <link href="/css/mentorMentee.css" rel="stylesheet" /> -->
	    
		<!-- Custom CSS -->
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	
	</head>
	
	<body>
		<div ng-app="myApp" style="background:#fffafa">
			<nav class="navbar">
				<div class="container-fluid">
			    	<div class="navbar-header">
			      		<img src="images/hm-logo.png" class="img-resposive"></a>
			    	</div>
			    <div>
			        <ul class="nav navbar-nav">
				        <li class="active"><a href="#">Mentor - Mentee</a></li>
				        <li><a href="#">Skills</a></li>
					    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Welcome Admin!<span class="caret"></span></a>
					        <ul class="dropdown-menu">
					            <li><a href="#">Page 1-1</a></li>
					            <li><a href="#">Page 1-2</a></li>
					            <li><a href="#">Page 1-3</a></li>
				        	</ul>
			        	</li>
			        	<li><a href="#/">Logout</a></li>
			      	</ul>
			    </div>
			    </div>
			</nav>
			
			<div  ng-view="ng-view">
	        
	        </div>
	        
        </div>
		<!-- jQuery -->
	    <script src="vendor/jquery/jquery.min.js"></script>
	    <script src="vendor/jquery/jquery-ui.min.js"></script>
	    
	    <!-- Bootstrap Core JavaScript -->
	    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
		
	    <!-- Plugin JavaScript -->
	    
		<!-- Angular JavaScript -->
	    <script src="vendor/AngularJs/angular.js"></script>
		<script src="vendor/AngularJs/angular-route.min.js"></script>
		<script src="vendor/AngularJs/angular-messages.min.js"></script>
		
		
	    <!-- APP & Controllers -->
		<script src="scripts/app.js"></script>
		<script src="scripts/controllers/logInModule.controller.js"></script>
		<script src="scripts/controllers/mentorScreenModule.controller.js"></script>
		<script src="scripts/controllers/objectivesModule.controller.js"></script>
		<script src="scripts/controllers/menteeScreenModule.controller.js"></script>
		
	    <!-- Custom JavaScript -->
		
	</body>
</html>    