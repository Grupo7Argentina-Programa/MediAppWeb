<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="navbar"
	class="navbar fixed-top navbar-expand-lg navbar-dark font-roboto"
	style="background-color: #00000070; font-size: x-large; padding: 30px 10px;">
	<div class="container-fluid">
		<a href="index.jsp" id="logo" class="navbar-brand"
			style="display: contents"> <img src="resources/logo.png"
			alt="MediApp" id="imagen-logo" style="height: 70px">
		</a>
		<button type="button" class="navbar-toggler" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse"
			style="text-align-last: end">
			<div class="navbar-nav">
				<a href="index.jsp" class="nav-item nav-link">Inicio</a> <a
					href="atracciones.do" class="nav-item nav-link">Atracciones</a> <a
					href="promociones.do" class="nav-item nav-link">Promociones</a>
				<c:if test="${usuario.admin}">
					<div class="dropdown">
						<button class="dropbtn">Administrador</button>
						<div class="dropdown-content">
							<a style="text-align: end" href="listado-atracciones.do">Atracciones</a>
							<a href="listado-promociones.do">Promociones</a>
							<!--  <a
								href="listado-tipos.do">Tipos de atracción</a>-->
							<a href="listado-usuarios.do">Usuarios</a> <a
								href="alta-atraccion.do">Alta de atracción</a><a
								href="alta-promocion.do">Alta de promoción</a>
						</div>
					</div>
				</c:if>

				<c:choose>
					<c:when test="${usuario != null}">

						<!-- Example split danger button -->
						<div class="btn-group lg">
							<a href="user.jsp">
								<button type="button" class="btn btn-primary"
									style="min-width: 100px; text-align-last: center">
									<c:out value="${usuario.nombre}"></c:out>
								</button>
							</a>
							<button type="button"
								class="btn btn-primary dropdown-toggle dropdown-toggle-split"
								data-bs-toggle="dropdown" aria-expanded="false">
								<span class="visually-hidden">Toggle Dropdown</span>
							</button>
							<ul class="dropdown-menu" style="left: -39px">
								<li><a class="dropdown-item" href="#"><c:out
											value="${usuario.presupuesto}"></c:out> monedas</a></li>
								<li><a class="dropdown-item" href="#"><c:out
											value="${usuario.tiempoDisponible}"></c:out> horas</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="logout">Cerrar
										sesión</a></li>
							</ul>
						</div>

					</c:when>
					<c:otherwise>
						<div class="navbar-nav ms-auto">
							<a type="button" class="btn btn-primary btn-lg" href="login.jsp"
								id="botonLogin">Login</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</nav>