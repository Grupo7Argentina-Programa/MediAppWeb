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
	<c:if test="${flash != null}">
		<div class="alert alert-danger">
			<p>
				<c:out value="${flash}" />
				<c:if test="${errors != null}">
					<ul>
						<c:forEach items="${errors}" var="entry">
							<li><c:out value="${entry.getValue()}"></c:out></li>
						</c:forEach>
					</ul>
				</c:if>
			</p>
		</div>
	</c:if>
	<main class="container" style="padding-bottom: 30px;">
		<h1 style="color: white">
			<c:out value="Bonito día, ${usuario.nombre }"></c:out>
		</h1>
		<h2 style="color: white">Tenés estas promociones disponibles</h2>

			<div class="container">

				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
					<c:forEach items="${promociones}" var="promocion">
						<div class="col">
							<div class="card shadow-sm h-100">
								<div id="carouselExampleControls" class="carousel slide"
									data-bs-ride="carousel">
									<div class="carousel-inner">

										<div class="carousel-item active">
											<img
												src="resources/${promocion.atraccion1.nombre.toLowerCase()}.png"
												class="d-block w-100"
												alt="${promocion.atraccion1.nombre.toLowerCase()}">
										</div>

										<div class="carousel-item">
											<img
												src="resources/${promocion.atraccion2.nombre.toLowerCase()}.png"
												class="d-block w-100"
												alt="${promocion.atraccion2.nombre.toLowerCase()}">
										</div>

										<c:if test="${promocion.atraccion3 != null}">
											<div class="carousel-item">
												<img
													src="resources/${promocion.atraccion3.nombre.toLowerCase()}.png"
													class="d-block w-100"
													alt="${promocion.atraccion3.nombre.toLowerCase()}"></img>
											</div>
										</c:if>

										<c:if test="${promocion.atraccion4 != null}">
											<div class="carousel-item">
												<img
													src="resources/${promocion.atraccion4.nombre.toLowerCase()}.png"
													class="d-block w-100"
													alt="${promocion.atraccion4.nombre.toLowerCase()}"></img>
											</div>
										</c:if>

									</div>
									<h2 id="precio" style="padding-top: 15px; padding-left: 15px">
										<c:out value="$ ${promocion.costo}"></c:out>
									</h2>


								</div>

								<div class="card-body">
									<h5 class="card-atraccion">
										<c:out value="${promocion.nombre}"></c:out>
									</h5>
									<p>
										Atracciones incluidas:
										<c:out value="${promocion.atraccion1.nombre},"></c:out>
										<c:out value="${promocion.atraccion2.nombre}"></c:out>
										<c:if test="${promocion.atraccion3 != null}">
											<c:out value=", ${promocion.atraccion3.nombre}"></c:out>
										</c:if>
										<c:if test="${promocion.atraccion4 != null}">
											<c:out value=", ${promocion.atraccion4.nombre}"></c:out>
										</c:if>
									</p>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<a href="promocion.do?id=${promocion.id	}"
												class="btn btn-success rounded" role="button">Ver<i
												class="bi bi-pencil-fill"></i></a>
											<button type="button"
												class="btn btn-sm btn-outline-secondary">Añadir al
												carrito</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

	</main>
</body>

</html>