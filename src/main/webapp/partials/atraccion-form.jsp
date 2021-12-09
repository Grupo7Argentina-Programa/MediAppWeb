<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row sm-2">
	<div class="col-md">
		<div class="input-group mb-3">
			<input type="text" class="form-control" name="nombre"
				placeholder="Nombre de atracción" required
				value="${atraccion.nombre }" />
			<div class="invalid-feedback">Por favor ingrese un nombre</div>
			<label for="Nombre de atracción"></label>
		</div>
		<div class="input-group mb-3">
			<label class="input-group-text" for="inputGroupSelect01">Tipo
				de atracción</label> <select class="form-select" name="tipo" id="tipo"
				aria-label="Tipo de atracción" required>
				<option selected disabled>Seleccione</option>
				<c:forEach items="${tiposDeAtraccion}" var="tipoDeAtraccion">
					<option value="${tipoDeAtraccion }"><c:out value="${tipoDeAtraccion}"></c:out></option>
				</c:forEach>
			</select>
			<div class="invalid-feedback">Por favor seleccione un tipo</div>
		</div>
		<div class="input-group mb-3">
			<textarea class="form-control textarea" name="descripcion"
				placeholder="Añada una descripcion" id="floatingDescripcion"
				style="height: 100px">${atraccion.descripcion }</textarea>
			<label for="Descripción"></label>
		</div>
	</div>
	<div class="col-md">
		<div class="input-group mb-3">
			<span class="input-group-text">$</span> <input type="number"
				class="form-control" name="costo" placeholder="Costo" required
				value="${atraccion.costo }">
			<div class="invalid-feedback">Por favor ingresá un costo válido</div>
		</div>

		<div class="input-group mb-3">
			<input type="number" class="form-control" name="tiempoRequerido"
				placeholder="Duracion" required
				value="${atraccion.tiempoNecesario }">
			<div class="invalid-feedback">Por favor ingresá una duración
				válida</div>
			<span class="input-group-text">horas</span>
		</div>

		<div class="input-group mb-3">
			<input type="number" class="form-control" name="cupo"
				placeholder="Cupos" required value="${atraccion.cupo }">
			<div class="invalid-feedback">Por favor ingresá un cupo válido</div>
			<label for="Cupos"></label> <span class="input-group-text">cupos</span>
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