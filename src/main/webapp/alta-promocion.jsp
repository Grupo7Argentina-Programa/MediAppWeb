<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="es">

<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<jsp:include page="partials/nav.jsp"></jsp:include>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>



<body class="texto"
	style="background-color: #000000; padding-top: 140px;">

	<main class="container"
		style="text-align: -webkit-center; width: max-content; padding-top: 30px">

		<c:if test="${promocion != null && !promocion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear la promoción.</p>
			</div>
		</c:if>

		<div>
			<h2 style="color: white;">Ingrese los datos de la nueva
				promoción</h2>
		</div>

		<form class="needs-validation" method="POST"
			action="alta-promocion.do">
			<jsp:include page="partials/promocion-form.jsp"></jsp:include>
		</form>
	</main>
</body>

</html>