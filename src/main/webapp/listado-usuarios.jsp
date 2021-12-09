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
							<th scope="col">Dinero</th>
							<th scope="col">Tiempo disponible</th>
							<th scope="col">Tipo de atracción favorita</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuarios}" var="usuario">
							<tr>
								<td><c:out value="${usuario.id}"></c:out></td>
								<td><strong><c:out value="${usuario.nombre}"></c:out></strong></td>
								<td><c:out value="${usuario.presupuesto}"></c:out></td>
								<td><c:out value="${usuario.tiempoDisponible}"></c:out></td>
								<td><c:out value="${usuario.atraccionFavorita}"></c:out></td>
								<td><a href="edit-usuario.do?id=${usuario.id}"
									class="btn btn-light rounded-0" role="button">Editar<i
										class="bi bi-pencil-fill"></i></a>
										<a href="delete-usuario.do?id=${usuario.id }"
									class="btn btn-danger rounded" role="button">Borrar<i
										class="bi bi-x-circle-fill"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</main>
</body>
</html>