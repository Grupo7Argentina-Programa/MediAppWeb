<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<div class="row sm-2">
	<div class="col-md">
		<div class="input-group mb-3">
			<input type="text" class="form-control" name="nombre"
				placeholder="Nombre del tipo atracción" required
				value="${tipoDeAtraccion.nombre }" />
			<div class="invalid-feedback">Por favor ingrese un nombre</div>
			<label for="Nombre del tipo de atracción"></label>
		</div>
	</div>
</div>
<div class="form-button mt-3">
	<button type="submit" class="btn btn-primary">Listo</button>
</div>