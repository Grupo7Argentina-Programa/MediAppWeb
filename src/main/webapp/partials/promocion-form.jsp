<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row sm-2">
	<div class="col-md">
		<!-- Nombre -->
		<div class="input-group mb-3">
			<input type="text" class="form-control" name="nombre"
				id="floatingPromocionInput" placeholder="Nombre de promoción"
				required value="${promocion.nombre }" />
			<div class="invalid-feedback">Por favor ingrese un nombre</div>
			<label for="Nombre de promoción"></label>
		</div>
		<!-- Tipo de promo -->
		<div class="input-group mb-3">
			<select name="tipoDePromocion" class="form-select"
				id="tipoDePromocion" aria-label="Tipo de atracción" required>
				<option value="sinElegir" selected disabled>Tipo de
					promoción</option>
				<option value="AxB">AxB</option>
				<option value="Absoluta">Absoluta</option>
				<option value="Porcentual">Porcentual</option>
			</select>
		</div>
		<div class="invalid-feedback">Por favor seleccione un tipo de
			promo</div>
		<p style="color: white">Atraccion 1</p>
		<div class="input-group mb-3">

			<select name="atraccion1" class="form-select" id="promoInput"
				aria-label="Atracción 1" required>
				<option selected>Sin elegir</option>
				<c:forEach items="${atracciones}" var="atraccion">
					<option value="${atraccion.nombre}"><c:out
							value="${atraccion.nombre}"></c:out></option>
				</c:forEach>
			</select>
		</div>
		<p style="color: white">Atraccion 2</p>
		<div class="input-group mb-3">

			<select name="atraccion2" class="form-select" id="promoInput"
				aria-label="Atracción 2" required>
				<option selected>Sin elegir</option>
				<c:forEach items="${atracciones}" var="atraccion">
					<option value="${atraccion.nombre}"><c:out
							value="${atraccion.nombre}"></c:out></option>
				</c:forEach>
			</select>
		</div>
		<p style="color: white">Atraccion 3</p>
		<div class="input-group mb-3">

			<select name="atraccion3" class="form-select" id="promoInput"
				aria-label="Atracción 3" required>
				<option selected>Sin elegir</option>
				<c:forEach items="${atracciones}" var="atraccion">
					<option value="${atraccion.nombre}"><c:out
							value="${atraccion.nombre}"></c:out></option>
				</c:forEach>
			</select>
		</div>
		<p style="color: white">Atraccion 4</p>
		<div class="input-group mb-3">

			<select name="atraccion4" class="form-select" id="promoInput"
				aria-label="Atracción 4" required>
				<option selected>Sin elegir</option>
				<c:forEach items="${atracciones}" var="atraccion">
					<option value="${atraccion.nombre}"><c:out
							value="${atraccion.nombre}"></c:out></option>
				</c:forEach>
			</select>
		</div>

	</div>
	<div class="col-md">
		<!-- Costo -->
		<div class="input-group mb-3">
			<span class="input-group-text">$</span> <input type="number"
				class="form-control" id="floatingCosto" name="costo"
				placeholder="Costo" value="${promocion.costo }">
		</div>
		<!-- Descuento -->
		<div class="input-group mb-3">
			<span class="input-group-text">%</span> <input type="number"
				class="form-control" id="floatingDescuento" name="descuento"
				placeholder="Descuento" value="${promocion.descuento }">
		</div>
	</div>
</div>
<div class="form-button mt-3">
	<button type="submit" class="btn btn-primary">Listo</button>
</div>