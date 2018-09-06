<%@ attribute name="backgroundColor" required="true" rtexprvalue="true"%>
<%@ tag body-content="tagdependent"%>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
	integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
	crossorigin="anonymous"></script>

<script type="text/javascript" src="js/addData.js"></script>
<script type="text/javascript" src="js/tableUtils.js"></script>

<style type="text/css">
 .row{
 	padding: 20px;
 }
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: ${backgroundColor}">
		<a class="navbar-brand" href="#">Metropolis Company</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					id="goBackBtn">Go Back</a></li>
				<li class="nav-item"><a class="nav-link" href="#" id="logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<script type="text/javascript">
		$("#goBackBtn").click(function() {
			window.history.back();
		});
		$("#logout")
				.click(
						function() {
							
							window.location.href = "logout";
							
						})
	</script>

</body>