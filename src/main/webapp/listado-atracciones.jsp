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

		<input type="hidden" name="usuario" value="${usuario}">
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

				<a href="alta-atraccion.do" class="button" type="button"
					style="padding-bottom: 3px">
					<button class="btn btn-primary" type="button">Crear
						atracción</button>
				</a>
				<a href="alta-tipo-atraccion.do" class="button" type="button"
					style="padding-bottom: 3px">
					<button class="btn btn-primary" type="button">Crear
						tipo de atracción</button>
				</a>
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
								<c:if test="${usuario.atraccionFavorita.equals(atraccion.tipo)}">
									<td><c:out value="${atraccion.id}"></c:out></td>
									<td><strong><c:out value="${atraccion.nombre}"></c:out></strong>
										<br> <a role="button" class="collapsed"
										data-bs-toggle="collapse"
										href="#descripcionAtraccion${atraccion.id }"
										aria-expanded="false"
										aria-controls="descripcionAtraccion${atraccion.id }">Ver
											descripción</a> <c:choose>
											<c:when test="${atraccion.descripcion != null }">
												<p class="collapse"
													id="descripcionAtraccion${atraccion.id }"
													aria-expanded="false">
													<c:out value="${atraccion.descripcion}"></c:out>
												</p>
											</c:when>
											<c:otherwise>
												<p class="collapse"
													id="descripcionAtraccion${atraccion.id }"
													aria-expanded="false">Le avisan al programador que
													escriba una descripción, gracias.</p>
											</c:otherwise>
										</c:choose></td>
									<td>$ <c:out value="${atraccion.costo}"></c:out></td>
									<td><c:out value="${atraccion.tiempoNecesario}"></c:out>
										horas</td>
									<td><c:out value="${atraccion.cupo}"></c:out></td>
									<td><c:out value="${atraccion.tipo}"></c:out></td>

									<td style="text-align: center;"><a
										href="atraccion.do?id=${atraccion.id}"
										class="btn btn-light rounded" role="button">Ver más<i
											class="bi bi-pencil-fill"></i></a> <c:choose>
											<c:when
												test="${usuario.puedeComprar(atraccion) &&
														usuario.puedeAsistir(atraccion) &&
														!usuario.enItinerario(atraccion)}">
												<a href="comprar-atraccion.do?id=${atraccion.id }"
													class="btn btn-success rounded" role="button"><i class="bi bi-cart4"></i>Comprar</a>
											</c:when>
											<c:otherwise>
												<a href="#" class="btn btn-secondary rounded disabled"
													role="button">Comprar</a>
											</c:otherwise>
										</c:choose> <c:if test="${usuario.isAdmin()}">
											<a href="edit-atraccion.do?id=${atraccion.id}"
												class="btn btn-light rounded" role="button">Editar<i
												class="bi bi-pencil-fill"></i></a>
											<a href="delete-atraccion.do?id=${atraccion.id}"
												class="btn btn-danger rounded" role="button">Borrar<i
												class="bi bi-x-circle-fill"></i></a>
										</c:if></td>
								</c:if>
							</tr>
						</c:forEach>
						<c:forEach items="${atracciones}" var="atraccion">
							<tr>
								<c:if test="${!usuario.atraccionFavorita.equals(atraccion.tipo)}">
									<td><c:out value="${atraccion.id}"></c:out></td>
									<td><strong><c:out value="${atraccion.nombre}"></c:out></strong>
										<br> <a role="button" class="collapsed"
										data-bs-toggle="collapse"
										href="#descripcionAtraccion${atraccion.id }"
										aria-expanded="false"
										aria-controls="descripcionAtraccion${atraccion.id }">Ver
											descripción</a> <c:choose>
											<c:when test="${atraccion.descripcion != null }">
												<p class="collapse"
													id="descripcionAtraccion${atraccion.id }"
													aria-expanded="false">
													<c:out value="${atraccion.descripcion}"></c:out>
												</p>
											</c:when>
											<c:otherwise>
												<p class="collapse"
													id="descripcionAtraccion${atraccion.id }"
													aria-expanded="false">Le avisan al programador que
													escriba una descripción, gracias.</p>
											</c:otherwise>
										</c:choose></td>
									<td>$ <c:out value="${atraccion.costo}"></c:out></td>
									<td><c:out value="${atraccion.tiempoNecesario}"></c:out>
										horas</td>
									<td><c:out value="${atraccion.cupo}"></c:out></td>
									<td><c:out value="${atraccion.tipo}"></c:out></td>

									<td style="text-align: center;"><a
										href="atraccion.do?id=${atraccion.id}"
										class="btn btn-light rounded" role="button">Ver más<i
											class="bi bi-pencil-fill"></i></a> <c:choose>
											<c:when
												test="${usuario.puedeComprar(atraccion) &&
														usuario.puedeAsistir(atraccion) &&
														!usuario.enItinerario(atraccion)}">
												<a href="comprar-atraccion.do?id=${atraccion.id}"
													class="btn btn-success rounded" role="button">Comprar</a>
											</c:when>
											<c:otherwise>
												<a href="#" class="btn btn-secondary rounded disabled"
													role="button">Comprar</a>
											</c:otherwise>
										</c:choose> <c:if test="${usuario.isAdmin()}">
											<a href="edit-atraccion.do?id=${atraccion.id}"
												class="btn btn-light rounded" role="button">Editar<i
												class="bi bi-pencil-fill"></i></a>
											<a href="delete-atraccion.do?id=${atraccion.id}"
												class="btn btn-danger rounded" role="button">Borrar<i
												class="bi bi-x-circle-fill"></i></a>
										</c:if></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</main>
</body>

</html>