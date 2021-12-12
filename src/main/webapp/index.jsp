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

	<main class="container-fluid" style="padding-bottom: 30px;">

		<c:if test="${usuario != null}">
			<h1 style="color: white; text-align: center">
				Te damos la bienvenida,
				<c:out value="${usuario.nombre}" />
			</h1>


			<div id="carouselExampleInterval" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner"
					style="padding-left: 50px; padding-right: 50px; height: 450px">
					<div class="carousel-item active" data-bs-interval="10000">
						<a href="promociones.do"><img
							src="resources/promocion-carrousel.jpg" class="d-block w-100"
							alt="promociones"></a>
						<div class="carousel-caption d-none d-md-block display">
							<h2>Echale un vistazo a las promociones que tenemos para vos</h2>
						</div>
					</div>
					<c:forEach items="${promociones }" var="promocion">
						<div class="carousel-item" data-bs-interval="5000">
							<a href="promocion.do?id=${promocion.id }"><img
								src="resources/promocion-carrousel.jpg" class="d-block w-100"
								alt="${promocion.nombre }"></a>
							<div class="carousel-caption d-none d-md-block display">
								<h2>
									<c:out value="${promocion.nombre }"></c:out>
								</h2>
								<h6>
									Atracciones incluidas:
									<c:out value="${promocion.atraccion1.nombre },"></c:out>
									<c:out value="${promocion.atraccion2.nombre }"></c:out>
									<c:if test="${promocion.atraccion3 != null }">
										<c:out value=", ${promocion.atraccion3.nombre }"></c:out>
									</c:if>
									<c:if test="${promocion.atraccion4 != null}">
										<c:out value=", ${promocion.atraccion4.nombre }"></c:out>
									</c:if>
								</h6>
								<a href="promocion.do?id=${promocion.id }"
									class="btn btn-primary">Ver promo</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleInterval" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
			</div>

			<div class=container>
				<h2 style="color: white">¿No te convencen?</h2>
				<h4 style="color: white">Entonces te ofrecemos estas
					atracciones</h4>
				<div class="row row-cols-1 row-cols-md-2 row-cols-lg-3">

					<c:forEach items="${atracciones }" var="atraccion">

						<div class="col">
							<div class="card h-100">
								<img class="card h-50"
									src="resources/${atraccion.nombre.toLowerCase()}.png">
								<h1
									style="padding-top: 5px; padding-left: 15px; font-size: 30px;">
									<c:out value="${atraccion.nombre}"></c:out>
								</h1>
								<h2 id="precio" style="padding-top: 5px; padding-left: 15px">
									$
									<c:out value="${atraccion.costo}"></c:out>
								</h2>
								<div class="card-body">
									<!--  <p class="card-atraccion"> -->
									<h3
										style="padding-top: 0px; padding-left: 5px; font-size: 15px;">
										<c:out value="${atraccion.tiempoNecesario} horas requeridas"></c:out>
									</h3>
									<!--  </p> -->

									<c:if test="${usuario != null }">

										<div class="d-flex justify-content-between align-items-center">
											<div class="btn-group">
												<a href="atraccion.do?id=${atraccion.id}"
													class="btn btn-success rounded" role="button">Ver</a>
												<button type="button"
													class="btn btn-sm btn-outline-secondary">Añadir al
													carrito</button>
											</div>
										</div>
									</c:if>
								</div>
							</div>
						</div>

					</c:forEach>
				</div>
			</div>
		</c:if>
	</main>
</body>

</html>