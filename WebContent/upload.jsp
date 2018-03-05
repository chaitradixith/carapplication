<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Form</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<form action="CarForm.do" enctype="multipart/form-data" method="post">
		<div class="form-group">
			<label for="name">Enter Name </label> <input type="text" name="name"
				class="form-control" id="name">
		</div>

		<div class="form-group">
			<label for="contact">Contact:</label> <input type="text"
				class="form-control" name="contact" id="contact">
		</div>

		<div class="form-group">
			<label for="vehno">Vehicle Number:</label> <input type="text"
				name="vehno" class="form-control" id="vehno">
		</div>

		<div class="form-group">
			<label for="images">Select Images:</label> <input type="file"
				name="images">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</body>
</html>