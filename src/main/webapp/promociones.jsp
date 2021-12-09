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
		<div class="album py-5 bg-dark">
			<div class="container">

				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
					<c:forEach items="${promociones}" var="promocion">
						<div class="col">
							<div class="card shadow-sm">
								<div id="carouselExampleControls" class="carousel slide"
									data-bs-ride="carousel">
									<div class="carousel-inner">
										<div class="carousel-item active">
											<img src="resources/erebor.png" class="d-block w-100"
												alt="...">
										</div>
										<div class="carousel-item">
											<img src="resources/lacomarca.png" class="d-block w-100"
												alt="...">
										</div>
										<div class="carousel-item">
											<img src="resources/bosquenegro.png" class="d-block w-100"
												alt="..."></img>
										</div>
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
											<button type="button"
												class="btn btn-sm btn-outline-secondary">Ver</button>
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
		</div>
	</main>
</body>

</html>