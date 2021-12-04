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
							<td>id</td>
							<td><strong><c:out
										value="${usuario.nombre}"></c:out></strong>
								<p>Descripción genérica</p></td>
							<td><c:out value="${usuario.dinero}"></c:out></td>
							<td><c:out value="${usuario.tiempoDisponible}"></c:out></td>
							<td><c:out value="${usuario.atraccionFavorita}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container">
			<div class="collapse" id="collapseExample">
				<div class="card card-body">

					<ul>
						<li>Atracción 1</li>
						<li>Atracción 2</li>
						<li>Atracción 3</li>
						<li>Atracción 4</li>
					</ul>
				</div>
			</div>
		</div>
	</main>
</body>
</html>