<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://kit.fontawesome.com/cc533dcf02.css" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" 
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" 
    integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
    crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="../css/estilos.css">

<title>Login</title>

</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Departamento de Control de Alimentos y Biotecnología</span>
		</div>
	</nav>

 <form class="login">
        <div class="contenedorimagenes">
            <img class="imagen" src="../img/epn.png" alt ="">
            <img class="imagen" src="../img/decab.png" alt ="">
        </div>
        <br>
        <h1>Log in</h1>
        <div class="contenedor">
            <div class="contenedor_icono">
                <i class="fa-solid fa-key"></i>
                <input class="controls" type="password" name="password" placeholder="Contraseña" /> <br>
            </div>
        </div>
        <input class="boton" type="submit" value="Ingresar" />
    </form>

<!-- <div class="wrapper">
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
	</div> -->
	
</body>
</html>