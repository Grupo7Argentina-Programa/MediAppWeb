<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">

<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<jsp:include page="partials/nav.jsp"></jsp:include>
</head>



<body class="texto"
	style="background-color: #000000; padding-top: 140px;">

	<main class="container"
		style="text-align: -webkit-center; width: max-content; padding-top: 30px">

		<div>
			<h2 style="color: white;">Ingrese los datos de la nueva
				promoción</h2>
		</div>

		<form class="needs-validation" novalidate method="POST" action="#">
			<div class="row sm-2">
				<div class="col-md">
					<div class="input-group mb-3">
						<input type="text" class="form-control"
							id="floatingPromocionInput" placeholder="Nombre de promoción"
							required />
						<div class="invalid-feedback">Por favor ingrese un nombre</div>
						<label for="Nombre de promoción"></label>
					</div>
					<div class="input-group mb-3">
						<select class="form-select" id="floatingTipo"
							aria-label="Tipo de atracción" required>
							<option selected disabled>Tipo de promoción</option>
							<option value="1">AxB</option>
							<option value="2">Absoluta</option>
							<option value="3">Porcentual</option>
						</select>
						<div class="invalid-feedback">Por favor seleccione un tipo</div>
					</div>
				</div>
				<div class="col-md">
					<div class="input-group mb-3">
						<span class="input-group-text">$</span> <input type="number"
							class="form-control" id="floatingCosto" placeholder="Costo">
					</div>

					<div class="input-group mb-3">
						<span class="input-group-text">%</span> <input type="number"
							class="form-control" id="floatingDescuento"
							placeholder="Descuento">
						<div class="invalid-feedback">Por favor ingresá una duración
							válida</div>
					</div>
				</div>
			</div>

			<div class="col-sm" style="text-align: initial">
				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox" role="switch"
						id="flexSwitchCheckDefault"> <label
						class="form-check-label" for="flexSwitchCheckDefault"
						style="color: white">Atracción 1</label>
				</div>

				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox" role="switch"
						id="flexSwitchCheckDefault"> <label
						class="form-check-label" for="flexSwitchCheckDefault"
						style="color: white">Atracción 2</label>
				</div>
				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox" role="switch"
						id="flexSwitchCheckDefault"> <label
						class="form-check-label" for="flexSwitchCheckDefault"
						style="color: white">Atracción 3</label>
				</div>
				<div class="form-check form-switch">
					<input class="form-check-input" type="checkbox" role="switch"
						id="flexSwitchCheckDefault"> <label
						class="form-check-label" for="flexSwitchCheckDefault"
						style="color: white">Atracción 4</label>
				</div>
			</div>


			<div class="form-button mt-3">
				<button type="submit" class="btn btn-primary">Listo</button>
			</div>
		</form>
	</main>
</body>

</html>