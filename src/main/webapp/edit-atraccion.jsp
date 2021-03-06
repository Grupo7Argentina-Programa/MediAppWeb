<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="es">

<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<jsp:include page="partials/nav.jsp"></jsp:include>
</head>
<body class="texto"
	style="background-color: #000000; padding-top: 140px;">

	<main class="container"
		style="text-align: -webkit-center; width: max-content; padding-top: 30px">

		<c:if test="${atraccion != null && !atraccion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al modificar la atracción.</p>
			</div>
		</c:if>
		
		<div>
			<h2 style="color: white;">Ingrese los datos de la atracción</h2>
		</div>
		<form class="needs-validation" method="POST"
			action="edit-atraccion.do">
			<input type="hidden" name="id" value="${atraccion.id}">
			<jsp:include page="partials/atraccion-form.jsp"></jsp:include>
		</form>
	</main>
</body>

</html>