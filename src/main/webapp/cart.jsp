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

	<main class="container-lg">
		<div>
			<div class="row cart-item" style="align-items: center">
				<div class="col">
					<div class="card cart-item-element">
						<div class="card-body">
							<h4 class="card-title">Producto</h4>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="card-link">Comprar ahora</a> <a href="#"
								class="card-link">Eliminar</a>
						</div>
					</div>
				</div>

				<div class="col" style="text-align: end">
					<div class="card cart-item-element">
						<div class="card-body lg">
							<h3 class="card-subtitle mb-2 text-muted">$50</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="row cart-item" style="align-items: center">
				<div class="col">
					<div class="card cart-item-element">
						<div class="card-body">
							<h4 class="card-title">Producto</h4>
							<p class="card-text">Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
							<a href="#" class="card-link">Comprar ahora</a> <a href="#"
								class="card-link">Eliminar</a>
						</div>
					</div>
				</div>

				<div class="col" style="text-align: end">
					<div class="card cart-item-element">
						<div class="card-body lg">
							<h3 class="card-subtitle mb-2 text-muted">$50</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button type="button" class="btn btn-primary btn-lg">Comprar</button>
			</div>

		</div>
	</main>
</body>

</html>