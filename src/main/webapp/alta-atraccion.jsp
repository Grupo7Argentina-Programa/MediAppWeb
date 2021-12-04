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
				atracción</h2>
		</div>

		<form class="needs-validation" novalidate method="POST" action="#">
			<div class="row sm-2">
				<div class="col-md">
					<div class="input-group mb-3">
						<input type="text" class="form-control"
							id="floatingAtraccionInput" placeholder="Nombre de atracción"
							required />
						<div class="invalid-feedback">Por favor ingrese un nombre</div>
						<label for="Nombre de atracción"></label>
					</div>
					<div class="input-group mb-3">
						<select class="form-select" id="floatingTipo"
							aria-label="Tipo de atracción" required>
							<option selected disabled>Tipo de atracción</option>
							<option value="1">Aventura</option>
							<option value="2">Degustación</option>
							<option value="3">Paisajes</option>
						</select>
						<div class="invalid-feedback">Por favor seleccione un tipo</div>
					</div>
					<div class="input-group mb-3">
						<textarea class="form-control" placeholder="Añada una descripcion"
							id="floatingDescripcion" style="height: 100px"></textarea>
						<label for="Descripción"></label>
					</div>
				</div>
				<div class="col-md">
					<div class="input-group mb-3">
						<span class="input-group-text">$</span> <input type="number"
							class="form-control" id="floatingCosto" placeholder="Costo"
							required>
						<div class="invalid-feedback">Por favor ingresá un costo
							válido</div>
					</div>

					<div class="input-group mb-3">
						<input type="number" class="form-control" id="floatingDuracion"
							placeholder="Duracion" required>
						<div class="invalid-feedback">Por favor ingresá una duración
							válida</div>
						<span class="input-group-text">horas</span>
					</div>

					<div class="input-group mb-3">
						<input type="number" class="form-control" id="floatingCupos"
							placeholder="Cupos" required>
						<div class="invalid-feedback">Por favor ingresá un cupo
							válido</div>
						<label for="Cupos"></label>
					</div>
				</div>
			</div>

			<div class="mb-3">
				<label for="subidaImagenes" class="form-label" style="color: white">Añada
					una imagen bonita</label> <input class="form-control" type="file"
					id="subidaImagenes" multiple>
			</div>
			<div class="form-button mt-3">
				<button type="submit" class="btn btn-primary">Listo</button>
			</div>
		</form>
	</main>
</body>

</html>