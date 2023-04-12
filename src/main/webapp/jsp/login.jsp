<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- CSS only -->
	<link rel="stylesheet" href="../css/estilos.css">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Departamento de Control de Alimentos y Biotecnología</span>
		</div>

	</nav>

	<div class="wrapper">
		<div class="formContent">
			<form method="post" action="../LoginController">
				<fieldset>
					<legend>Inicio de Sesión</legend>
					<p>Clave</p>
					<input type="password" name="password" /> <br> <br> <br>
					<input type="submit" value="Ingresr" />
				</fieldset>
			</form>
		</div>

	</div>
</body>
</html>