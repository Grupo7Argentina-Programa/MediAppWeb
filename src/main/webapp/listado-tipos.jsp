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
							<th scope="col">Tipo de atracción</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${tiposDeAtraccion}" var="tipoDeAtraccion">
							<tr>
								<td><c:out value="${tipoDeAtraccion.id}"></c:out></td>
								<td><c:out value="${tipoDeAtraccion}"></c:out></td>

								<td style="text-align: center;"><c:if
										test="${usuario.isAdmin()}">
										<a href="#" class="btn btn-light rounded-0" role="button">Editar<i
											class="bi bi-pencil-fill"></i></a>
										<a href="#" class="btn btn-danger rounded" role="button">Borrar<i
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