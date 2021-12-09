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

		<input type="hidden" name="id" value="${atraccion.id}">
		<div class="row row-cols-md-1 row-cols-lg-2">
			<div class="col-4">
				<!-- Caja de atraccion y sus datos -->
				<div class="card"
					style="width: 18rem; align-items: center; margin: 10px;">
					<img src="resources/producto.png"
						class="card-img-top img-fluid w-50 rounded-circle" alt="...">
					<div class="card-body">
						<h5 class="card-title">
							<c:out value="${atraccion.nombre}"></c:out>
						</h5>

					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><c:out value="${atraccion.costo}"></c:out>
							monedas</li>
						<li class="list-group-item"><c:out
								value="${atraccion.tiempoNecesario}"></c:out> horas requeridas</li>
						<li class="list-group-item"><c:out
								value="Tipo de atracción: ${atraccion.tipo}"></c:out></li>
					</ul>
					<div class="card-body">
						<a href="#" class="card-link">Card link</a> <a href="#"
							class="card-link">Another link</a>
					</div>
				</div>

			</div>
			<div class="col-4">
				<div class="card mb-4"
					style="max-width: 100%; height: 100%; place-content: center; padding-left: 20px; padding-right: 20px">
					<p class="text-center">
						<c:out value="${atraccion.descripcion}"></c:out>
					</p>
				</div>
			</div>
		</div>
	</main>
</body>

</html>