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

	<main class="container" style="padding-bottom: 30px;">
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
			<c:forEach items="${atracciones}" var="atraccion">
				<div class="col">
					<div class="card shadow-sm">
						<img src="resources/erebor.png">
						<rect width="25%" height="25%" fill="#55595c"></rect>
						<h1 style="padding-top: 15px; padding-left: 15px">
							<c:out value="${atraccion.nombre}"></c:out>
						</h1>
						<h2 id="precio" style="padding-top: 15px; padding-left: 15px">
							$
							<c:out value="${atraccion.costo}"></c:out>
						</h2>
						<div class="card-body">
							<p class="card-atraccion">
								<c:out value="${atraccion.tiempoNecesario} horas requeridas"></c:out>
							</p>
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<button type="button" class="btn btn-sm btn-outline-secondary">Ver</button>
									<button type="button" class="btn btn-sm btn-outline-secondary">Añadir
										al carrito</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</main>
</body>

</html>