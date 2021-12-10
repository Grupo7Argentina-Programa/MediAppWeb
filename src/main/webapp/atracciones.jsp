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
					<div class="card h-100">					
						<img  class="card h-50"  src="resources/${atraccion.nombre.toLowerCase()}.png">
						<h1 style="padding-top: 5px; padding-left: 15px; font-size:30px;"> 
							<c:out value="${atraccion.nombre}"></c:out>
						</h1>
						<h2 id="precio" style="padding-top: 5px; padding-left: 15px">
							$
							<c:out value="${atraccion.costo}"></c:out>
						</h2>
						<div class="card-body">
							<!--  <p class="card-atraccion"> -->
							<h3 style="padding-top: 0px; padding-left: 5px; font-size:15px;"> 
								<c:out value="${atraccion.tiempoNecesario} horas requeridas"></c:out> </h3>
							<!--  </p> -->
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<a href="atraccion.do?id=${atraccion.id}"
										class="btn btn-success rounded" role="button">Ver</a>
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