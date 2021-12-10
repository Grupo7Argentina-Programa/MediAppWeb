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

	<main class="container-fluid" style="padding-bottom: 30px;">
		<input type="hidden" name="id" value="${atraccion.id}">
		<div class="container">
			<div class="row">
				<div class="col">
					<h1 style="color: white">
						<c:out value="${atraccion.nombre}"></c:out>
					</h1>
					<h2 style="color: white"> $
						<c:out value="${atraccion.costo}"></c:out>
					</h2>
					<p class=small style="color: white">
						<c:choose>
							<c:when test="${atraccion.descripcion != null}">
								<c:out value="${atraccion.descripcion}"></c:out>
							</c:when>
							<c:otherwise>
								<p class="small fst-italic" style="color: white">Bueno, parece que el programador se
									olvidó de poner una descripción...</p>
								<img alt="programador de siesta"
									src="resources/programador_dormido.jpg"
									style="width: 18rem; align-self: center;">
							</c:otherwise>
						</c:choose>
					</p>
					<div class="btn-group">
						<button type="button" class="btn btn-primary" style="margin: 5px">Comprar</button>
						<button type="button" class="btn btn-light" style="margin: 5px">Añadir
							al carrito</button>
					</div>
				</div>

				<div class="col-8">
					<div class="card">
						<img src="resources/${atraccion.nombre.toLowerCase()}.png"
							class="card-img-top img-fluid w-50" alt="${atraccion.nombre }" style="align-self: center">
					</div>
				</div>
			</div>

			<div class="row">
				<h3 style="color: white">Características</h3>
				<table class="table table-dark table-hover table-responsive"
					style="width: auto;">
					<tr>
						<th style="color: white">Tipo de atracción</th>
						<td style="color: white"><c:out value="${atraccion.tipo }"></c:out></td>
					</tr>
					<tr>
						<th style="color: white">Cupos disponibles</th>
						<td style="color: white"><c:out value="${atraccion.cupo}"></c:out></td>
					</tr>
					<tr>
						<th style="color: white">Tiempo requerido</th>
						<td style="color: white"><c:out
								value="${atraccion.tiempoNecesario}"></c:out></td>

					</tr>
				</table>

			</div>
		</div>
	</main>
</body>

</html>