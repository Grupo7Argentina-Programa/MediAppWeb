<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<div class="row">
				<div class="col">
					<h1 style="color: white">Mordor</h1>
					<h2 style="color: white">
						<b>$12</b>
					</h2>
					<p class=small style="color: white">Mordor es un país situado
						al sureste de la Tierra Media, que tuvo gran importancia durante
						la Guerra del Anillo por ser el lugar donde Sauron, el Señor
						Oscuro, decidió edificar su fortaleza de Barad-dûr para intentar
						atacar y dominar a todos los pueblos de la Tierra Media. Se trata
						de una región desolada, rodeada de montañas con un interior
						desértico sin vegetación.</p>
					<div class="btn-group">
						<button type="button" class="btn btn-primary" style="margin: 5px">Comprar</button>
						<button type="button" class="btn btn-light" style="margin: 5px">Añadir
							al carrito</button>
					</div>
				</div>

				<div class="col-8">
					<div class="card">
						<img alt="" src="resources/mordor.jpg">
					</div>
				</div>
			</div>

			<div class="row">
				<h3 style="color: white">Características</h3>
				<table class="table table-dark table-hover table-responsive"
					style="width: auto;">
					<tr>
						<th style="color: white">Tipo de atracción</th>
						<td style="color: white">Aventura</td>
					</tr>
					<tr>
						<th style="color: white">Cupos disponibles</th>
						<td style="color: white">10</td>
					</tr>
					<tr>
						<th style="color: white">Tiempo requerido</th>
						<td style="color: white">3 horas</td>
					</tr>
				</table>

			</div>
		</div>
	</main>
</body>

</html>