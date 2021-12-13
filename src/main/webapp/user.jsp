<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<c:if test="${flash != null}">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<p>
					<c:out value="${flash}" />
				</p>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>

		<div class="row row-cols-md-1 row-cols-lg-2">
			<div class="col-8">
				<!-- Caja de usuario y sus datos -->
				<div class="card"
					style="width: 18rem; align-items: center; margin: 10px;">
					<img src="resources/usuarios/${usuario.id}.png"
						class="card-img-top img-fluid w-50 rounded-circle" alt="${usuario.nombre }">
					<div class="card-body">
						<h5 class="card-title">
							<c:out value="${usuario.nombre}"></c:out>
						</h5>
						<!-- 
						 <p class="card-text">Hola, soy una descripción</p>
						 -->
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><c:out
								value="${usuario.presupuesto}"></c:out> moneda(s) restante(s)</li>
						<li class="list-group-item"><c:out
								value="${usuario.tiempoDisponible}"></c:out> hora(s)
							disponible(s)</li>
						<li class="list-group-item"><c:out
								value="Tipo de atracción favorita: ${usuario.atraccionFavorita}"></c:out></li>
					</ul>
				</div>

			</div>
			<div class="col-6">
				<div class="card sm-2" style="max-width: 550px;">
					<c:choose>
						<c:when test="${usuario.itinerario.atraccionesAceptadas.isEmpty() }">
							<div class="row g-0">
								<h5>Vaya, parece que todavía no hay nada.</h5>
								<h6>Cuando compres una atracción la podrás encontrar aquí.</h6>
							</div>
						</c:when>
						<c:otherwise>
						<div class="row g-0">
								<h3 style="padding-bottom: 10px; padding-top:10px">Este es tu itinerario</h3>
							</div>
						</c:otherwise>
					</c:choose>
					<c:forEach items="${usuario.itinerario.atraccionesAceptadas}"
						var="atraccion">
						<div class="row g-0">
							<div class="col-md-2">
								<a href ="atraccion.do?id=${atraccion.id}"> <img
									src="resources/${atraccion.nombre.toLowerCase()}.png"
									class="img-fluid rounded-start" alt="${atraccion.nombre}">
								</a>
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">
										<c:out value="${atraccion.nombre}"></c:out>
									</h5>
									<p class="card-text">
										<c:out value="${atraccion.tiempoNecesario} horas"></c:out>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		
	</main>
</body>

</html>