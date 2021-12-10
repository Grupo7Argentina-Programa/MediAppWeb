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
		<input type="hidden" name="id" value="${promocion.id}">
		<div class="container">
			<div class="row">
				<div class="col">
					<h1 style="color: white">
						<c:out value="${promocion.nombre }"></c:out>
					</h1>
					<h4 style="text-decoration: line-through; color: white">
						$
						<c:out
							value="${promocion.atraccion1.costo + promocion.atraccion2.costo + promocion.atraccion3.costo + promocion.atraccion4.costo}"></c:out>
					</h4>
					<h2 style="color: white">
						$
						<c:out value="${promocion.costo }"></c:out>
					</h2>
					<div class="btn-group">
						<c:choose>
							<c:when
								test="${usuario.puedeComprar(promocion) &&
														usuario.puedeAsistir(promocion) &&
														!usuario.enItinerario(promocion)}">
								<a href="comprar-promocion.do?id=${promocion.id}"
									style="padding-right: 5px"><button type="button"
										class="btn btn-success rounded">Comprar</button></a>
								<a href="#"><button type="button"
										class="btn btn-outline-success rounded">Añadir al
										carrito</button></a>
							</c:when>
							<c:otherwise>
								<a href="#" class="btn btn-secondary rounded disabled"
									role="button">Comprar</a>
							</c:otherwise>
						</c:choose>
					</div>
					<h4 style="color: white; padding-top: 5px">Características</h4>
					<table class="table table-dark table-hover table-responsive"
						style="width: auto;">
						<tr>
							<th style="color: white">Tipo de atracciones</th>
							<td style="color: white"><c:out value="${promocion.tipo }"></c:out></td>
						</tr>
						<tr>
							<th style="color: white">Tiempo requerido</th>
							<td style="color: white"><c:out
									value="${promocion.tiempoNecesario}"></c:out> horas</td>

						</tr>
					</table>
				</div>

				
				<div class="col-8">
				<h3 style="color:white">Esta promoción incluye las siguientes atracciones</h3>
					<div class=row style="padding: 5px; justify-content: space-evenly;">
						<div class="card" style="width: 18rem;">
							<a href="atraccion.do?id=${promocion.atraccion1.id}"> <img
								src="resources/${promocion.atraccion1.nombre.toLowerCase()}.png"
								class="card-img-top" alt="${promocion.atraccion1.nombre }">
							</a>
							<div class="card-body">
								<a href="atraccion.do?id=${promocion.atraccion1.id}"> <span
									class="card-text"> <c:out
											value="${promocion.atraccion1.nombre }"></c:out>
								</span></a>
							</div>
						</div>
						<div class="card" style="width: 18rem;">
							<a href="atraccion.do?id=${promocion.atraccion2.id}"> <img
								src="resources/${promocion.atraccion2.nombre.toLowerCase()}.png"
								class="card-img-top" alt="${promocion.atraccion2.nombre }"></a>
							<div class="card-body">
								<a href="atraccion.do?id=${promocion.atraccion2.id}"> <span
									class="card-text"> <c:out
											value="${promocion.atraccion2.nombre }"></c:out>
								</span></a>
							</div>
						</div>
					</div>
					<div class=row style="padding: 5px; justify-content: space-evenly;">
						<c:if test="${promocion.atraccion3 != null }">
							<div class="card" style="width: 18rem;">
								<a href="atraccion.do?id=${promocion.atraccion3.id}"> <img
									src="resources/${promocion.atraccion3.nombre.toLowerCase()}.png"
									class="card-img-top" alt="${promocion.atraccion3.nombre }"></a>
								<div class="card-body">
									<a href="atraccion.do?id=${promocion.atraccion3.id}"> <span
										class="card-text"> <c:out
												value="${promocion.atraccion3.nombre }"></c:out>
									</span></a>
								</div>
							</div>
						</c:if>
						<c:if test="${promocion.atraccion4 != null }">
							<div class="card" style="width: 18rem;">
								<a href="atraccion.do?id=${promocion.atraccion4.id}"> <img
									src="resources/${promocion.atraccion4.nombre.toLowerCase()}.png"
									class="card-img-top" alt="${promocion.atraccion4.nombre }"></a>
								<div class="card-body">
									<a href="atraccion.do?id=${promocion.atraccion4.id}"> <span
										class="card-text"> <c:out
												value="${promocion.atraccion4.nombre }"></c:out>
									</span></a>
								</div>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>

</html>