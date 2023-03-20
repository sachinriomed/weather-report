<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	
	
	<style type="text/css">
		.height75px {
			height: 75px;
		}
		
		.marginTop20px {
			margin-top: 20px;
		}
		
		.fontboldstyle {
		    font-weight:600;
		}
	</style>
	<title>Weather Report</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm fixed-top bg-body">
		<div class="container-fluid shadow-sm">
			<a class="navbar-brand" href="#"></a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-collapse collapse justify-content-end" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="config">Settings</a></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="col-md-12 height75px"></div>
		<div class="row marginTop20px justify-content-center">
			<div class="col-md-3"></div>
				<div class="col-md-6">
					<table class="table table-striped table-hover table-bordered">
						<thead class="table-light">
							<tr>
								<th scope="col">City</th>
								<th scope="col">Temperature</th>
								<th scope="col">Weather</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="DisplayTemperatureBean" items="${dashboardNotification}" varStatus="status">
								<tr>
									<td>${status.current.city}</td>
									<td>${status.current.temprature}</td>
									<td>${status.current.weather}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-3" align="left">&nbsp;</div>
		</div>
	</div>
</body>
</html>