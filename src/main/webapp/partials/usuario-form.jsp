<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row sm-2">
	<div class="col-md">
		<div class="input-group mb-3">
			<input type="text" class="form-control" name="nombre"
				placeholder="Nombre de usuario" required
				value="${usuario.nombre }" />
			<div class="invalid-feedback">Por favor ingrese un nombre</div>
			<label for="Nombre de usuario"></label>
		</div>
		<div class="input-group mb-3">
			<label class="input-group-text" for="inputGroupSelect01">Tipo
				de atracción favorita</label> <select class="form-select" name="tipo" id="tipo"
				aria-label="Tipo de atracción favorita" required>
				<option selected disabled>Seleccione</option>
				<c:forEach items="${tiposDeAtraccion}" var="tipoDeAtraccion">
					<option value="${usuario.atraccionFavorita }"><c:out value="${tipoDeAtraccion }"></c:out></option>
				</c:forEach>
			</select>
			<div class="invalid-feedback">Por favor seleccione un tipo</div>
		</div>
	</div>
		<div class="col-md">
			<div class="input-group mb-3">
				<span class="input-group-text">$</span> <input type="number"
					class="form-control" name="presupuesto" placeholder="Presupuesto"
					required value="${usuario.presupuesto }">
				<div class="invalid-feedback">Por favor ingrese un presupuesto
					válido</div>
			</div>

			<div class="input-group mb-3">
				<input type="number" class="form-control" name="tiempoDisponible"
					placeholder="Tiempo disponible" required
					value="${usuario.tiempoDisponible }">
				<div class="invalid-feedback">Por favor ingresá un tiempo
					válida</div>
				<span class="input-group-text">horas</span>
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