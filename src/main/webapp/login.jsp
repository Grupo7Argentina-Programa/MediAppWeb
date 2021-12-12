<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="es">

<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<jsp:include page="partials/nav.jsp"></jsp:include>
</head>



<body class="texto"
	style="background-color: #000000; padding-top: 140px;">

	<main class="container font-roboto"
		style="text-align: -webkit-center; width: max-content; padding-top: 30px">

		<form action="login.dol" method="post">
			<c:if test="${flash != null}">
				<div class="alert alert-warning alert-dismissible fade show"
					role="alert">
					<p>
						<c:out value="${flash}" />
					</p>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</c:if>

			<div>
				<h2 style="color: white;">Te damos la bienvenida.</h2>
				<h2 style="color: white;">Ingresá tu usuario.</h2>
			</div>

			<div class="form-floating mb-3">
				<input type="text" class="form-control" name="username"
					placeholder="Usuario" autofocus required> <label
					for="usuario">Usuario</label>
			</div>
			<!--  
			<div class="form-floating mb-3">
				<input type="password" class="form-control" name="password"
					placeholder="Password"> <label for="password">Contraseña</label>
			</div>
			<div class="checkbox mb-3">
				<label style="color: white;"> <input type="checkbox"
					value="remember-me"> Recordar usuario
				</label>
			</div>
			-->
			<div class="navbar-nav ms-auto">
				<button type="submit" class="btn btn-primary btn-lg"
					id="submit-login">Iniciar sesión</button>
			</div>
		</form>
	</main>
</body>

</html>