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
	
	<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
	
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
		
		.width130padding5 {
			 width: 130px;
		     padding: 5px;
		}
		
		.width160padding5 {
			 width: 160px;
		     padding: 5px;
		}
		
		.marginTop5px {
			margin-top: 5px;
		}
		
		.marginTop25px {
			margin-top: 25px;
		}
	</style>
	
	<script type="text/javascript">
	
		function copySetting(cfgId) {
			var isChecked = $("#copySetting_" + cfgId).is(":checked");
			if(isChecked) {
				var cfgCity = $("#cfgCity_"+cfgId).text();
				var cfgTemperature = $("#cfgTemperature_"+cfgId).text();
				var cfgNotificationType = $("#cfgNotificationType_"+cfgId).text();
				
				$("#cfgCity").val(cfgCity).change();
				$("#cfgTemperature").val(cfgTemperature);
				$("#cfgNotificationType").val(cfgNotificationType).change();
			}
		}
		
		function saveConfig() {
			
			var cfgTemperature = $("#cfgTemperature").val();
			if(cfgTemperature == null || cfgTemperature == '') {
				alert('Please enter temperature')
			}
			
			document.configForm.submit();
		}
		
		function allowOnlyDigit(ev) {
			var key = ev.keyCode || ev.which || ev.charCode;
			return (key >= 48 && key <= 57) || (key == 8);
		}
	</script>
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
					<li class="nav-item"><a class="nav-link" href="dashboard">Dashboard</a></li>
				</ul>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="col-md-12 height75px"></div>
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger alert-dismissible fade show text-center" role="alert">
			  	${errorMessage}
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		<c:if test="${not empty responseMessage}">
			<div class="alert alert-primary alert-dismissible fade show text-center" role="alert">
			  	${responseMessage}
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</c:if>
		<div class="row justify-content-center">
			<div class="col-md-3"></div>
			<div class="col-md-9">
				<div class="col-md-12 p-3 justify-content-center" align="left">
					<br>
					<form class="row g-4" id="configForm" name="configForm" action="saveConfig" method="post">
						<div class="col-auto">
							<label class="fontboldstyle">City</label> 
								<select id="cfgCity" name="cfgCity" class="form-select form-select-sm input-group-sm form-control width160padding5">
								<c:forEach var="City" items="${foundCities}" varStatus="status">
									<option value="${status.current.ctiCity}">${status.current.ctiCity}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-auto">
							<label class="fontboldstyle">Temperature</label>
							<input id="cfgTemperature" name="cfgTemperature" class="input-group-sm form-control width160padding5" type="text" onkeypress="return allowOnlyDigit(event);" maxlength="2"/>
						</div>
						<div class="col-auto">
							<label class="fontboldstyle">Notification Type</label>
							<select id="cfgNotificationType" name="cfgNotificationType" class="form-select form-select-sm input-group-sm form-control width160padding5">
								<option value="dashboard">Dashboard</option>
								<option value="text">Text</option>
							</select>
						</div>
						<div class="col-auto">
							<label class="marginTop25px"> &nbsp;</label>
							<button type="button" id="btnSave" name="btnSave" class="btn-primary align-bottom marginTop25px" onClick="saveConfig()">Save</button>
						</div>
					</form>
				</div>
			</div>
			<div class="row marginTop20px justify-content-center">
				<div class="col-md-3"></div>
					<div class="col-md-6">
						<table class="table table-striped table-hover table-bordered">
							<thead class="table-light">
								<tr>
									<th scope="col">City</th>
									<th scope="col">Temperature</th>
									<th scope="col">Weather</th>
									<th scope="col">Copy Setting</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="Config" items="${foundConfig}" varStatus="status">
									<tr>
										<td id="cfgCity_${status.current.cfgId}">${status.current.cfgCity}</td>
										<td id="cfgTemperature_${status.current.cfgId}">${status.current.cfgTemperature}</td>
										<td class="text-capitalize" id="cfgNotificationType_${status.current.cfgId}">${status.current.cfgNotificationType}</td>
										<td>
											<input type="checkbox" id="copySetting_${status.current.cfgId}" name="copySetting_${status.current.cfgId}" onClick="copySetting('${status.current.cfgId}')" />
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-md-3" align="left">&nbsp;</div>
			</div>
		</div>
	</div>
</body>
</html>
