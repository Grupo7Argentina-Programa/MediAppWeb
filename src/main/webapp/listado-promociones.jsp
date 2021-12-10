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

		<div class="container">
			<c:if test="${usuario.isAdmin()}">
				<table class="table table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nombre</th>
							<th scope="col">Costo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${promociones}" var="promocion">
							<tr>
								<td><c:out value="${promocion.id }"></c:out></td>
								<td><strong><c:out value="${promocion.nombre}"></c:out></strong>
									<p>
										Atracciones incluidas:
										<c:out value="${promocion.atraccion1.nombre}"></c:out>
										<c:out value=", ${promocion.atraccion2.nombre}"></c:out>
										<c:if test="${promocion.atraccion3 != null}">
											<c:out value=", ${promocion.atraccion3.nombre}"></c:out>
										</c:if>
										<c:if test="${promocion.atraccion4 != null}">
											<c:out value=", ${promocion.atraccion4.nombre}"></c:out>
										</c:if>
									</p></td>
								<td>$ <c:out value="${promocion.costo}"></c:out></td>

								<td style="text-align: center;"><a
									href="promocion.do?id=${promocion.id}"
									class="btn btn-light rounded" role="button">Ver más<i
										class="bi bi-pencil-fill"></i></a>
										<c:if
										test="${usuario.isAdmin()}" /> <c:choose>

										<c:when test="${usuario.puedeComprar(promocion) &&
														usuario.puedeAsistir(promocion) &&
														!usuario.enItinerario(promocion)}">
											<a href="comprar-promocion.do?id=${promocion.id}"
												class="btn btn-success rounded" role="button">Comprar</a>
										</c:when>
										<c:otherwise>
											<a href="#" class="btn btn-secondary rounded disabled"
												role="button">No se puede comprar</a>
										</c:otherwise>
									</c:choose> <c:if test="${usuario.isAdmin()}">
										<a href="edit-promocion.do?id=${promocion.id}"
											class="btn btn-light rounded-0" role="button">Editar<i
											class="bi bi-pencil-fill"></i></a>
										<a href="delete-promocion.do?id=${promocion.id}"
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