<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="es">

<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<jsp:include page="/partials/nav.jsp"></jsp:include>
</head>



<body class="texto"
	style="background-color: #000000; padding-top: 140px;">

	<main class="container-fluid" style="padding-bottom: 30px;">

		<div class="container">
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
			<c:if test="${usuario.isAdmin()}">
				<table class="table table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nombre</th>
							<th scope="col">Costo</th>
							<th scope="col">Duración</th>
							<th scope="col">Cupo</th>
							<th scope="col">Tipo de atracción</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${atracciones}" var="atraccion">
							<tr>
								<td><c:out value="${atraccion.id}"></c:out></td>
								<td>
								<strong><c:out value="${atraccion.nombre}"></c:out></strong>
									<br>
									<a role="button" class="collapsed" data-bs-toggle="collapse"
										href="#descripcionAtraccion${atraccion.id }" aria-expanded="false"
										aria-controls="descripcionAtraccion${atraccion.id }">Ver descripción</a>
								

										<p class="collapse" id="descripcionAtraccion${atraccion.id }" aria-expanded="false">
											<c:out value="${atraccion.descripcion}">Ver descripción</c:out>
										</p>

									
									</td>
								<td>$ <c:out value="${atraccion.costo}"></c:out></td>
								<td><c:out value="${atraccion.tiempoNecesario}"></c:out>
									horas</td>
								<td><c:out value="${atraccion.cupo}"></c:out></td>
								<td><c:out value="${atraccion.tipo}"></c:out></td>

								<td style="text-align: center;"><a
									href="atraccion.do?id=${atraccion.id}"
									class="btn btn-light rounded-0" role="button">Ver más<i
										class="bi bi-pencil-fill"></i></a> <c:choose>
										<c:when test="${usuario.puedeComprar(atraccion)}">
											<a href="#" class="btn btn-success rounded" role="button">Comprar</a>
										</c:when>
										<c:otherwise>
											<a href="#" class="btn btn-secondary rounded disabled"
												role="button">No se puede comprar</a>
										</c:otherwise>
									</c:choose> <c:if test="${usuario.isAdmin()}">
										<a href="edit-atraccion.do?id=${atraccion.id}"
											class="btn btn-light rounded-0" role="button">Editar<i
											class="bi bi-pencil-fill"></i></a>
										<a href="delete-atraccion.do?id=${atraccion.id}"
											class="btn btn-danger rounded" role="button">Borrar<i
											class="bi bi-x-circle-fill"></i></a>
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</main>
</body>

</html>