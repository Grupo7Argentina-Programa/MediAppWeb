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
		<div>
			<h2 style="color: white;">Ingrese los datos del nuevo tipo de
				atracción</h2>
		</div>

		<form class="needs-validation" method="POST"
			action="alta-tipoatraccion.do">
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
			<div class="row sm-2">
				<div class="col-md">
					<div class="input-group mb-3">
						<input type="text" class="form-control" name="nombre"
							placeholder="Nombre de atracción" required />
						<div class="invalid-feedback">Por favor ingrese un nombre</div>
						<label for="Nombre de atracción"></label>
					</div>
				</div>
			</div>
		</form>
	</main>
</body>

</html>