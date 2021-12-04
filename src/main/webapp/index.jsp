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

		<h1 style="color: white">
			Te damos la bienvenida,
			<c:out value="${username}"/>
			!
		</h1>

		<div id="carouselExampleInterval" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner"
				style="padding-left: 50px; padding-right: 50px; height: 450px">
				<div class="carousel-item active" data-bs-interval="10000">
					<a href="mordor.jsp"><img src="resources/mordor.jpg"
						class="d-block w-100" alt="mordor"></a>
					<div class="carousel-caption d-none d-md-block display">
						<h2>Mordor</h2>
						<h6>Mordor es un país situado al sureste de la Tierra Media,
							que tuvo gran importancia durante la Guerra del Anillo por ser el
							lugar donde Sauron, el Señor Oscuro, decidió edificar su
							fortaleza de Barad-dûr para intentar atacar y dominar a todos los
							pueblos de la Tierra Media.</h6>
					</div>
				</div>
				<div class="carousel-item" data-bs-interval="2000">
					<img src="resources/lothloiren.jpg" class="d-block w-100"
						alt="lothloiren">
					<div class="carousel-caption d-none d-md-block display">
						<h2>Lothlórien</h2>
						<h6>Lothlórien es un bosque localizado en la Tierra Media
							cerca de las bajas Montañas Nubladas.</h6>
					</div>
				</div>
				<div class="carousel-item">
					<img src="resources/erebor.jpg" class="d-block w-100" alt="erebor">
					<div class="carousel-caption d-none d-md-block display">
						<h2>Erebor</h2>
						<h6>La Montaña Solitaria o Erebor es una montaña al noreste
							de Rhovanion, al sur de las Montañas Grises, entre elBosque Negro
							y las Colinas de Hierro.</h6>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleInterval" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>

	</main>
	<div class=container>
		<div class="row row-cols-1 row-cols-md-2 row-cols-lg-3">
			<div class="col">
				<div class="card" style="width: 300px">
					<img src="resources/abismo.png" class="card-img-top"
						alt="abismo de helm">
					<div class="card-body">
						<h5 class="card-title">Abismo de Helm</h5>
						<p class="card-text">This is a longer card with supporting
							text below as a natural lead-in to additional content. This
							content is a little bit longer.</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 300px">
					<img src="resources/bosquenegro.png" class="card-img-top"
						alt="bosque negro">
					<div class="card-body">
						<h5 class="card-title">Bosque Negro</h5>
						<p class="card-text">This is a longer card with supporting
							text below as a natural lead-in to additional content. This
							content is a little bit longer.</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 300px">
					<img src="resources/erebor.png" class="card-img-top" alt="erebor">
					<div class="card-body">
						<h5 class="card-title">Erebor</h5>
						<p class="card-text">This is a longer card with supporting
							text below as a natural lead-in to additional content.</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 300px">
					<img src="resources/ettenmoors.png" class="card-img-top"
						alt="ettenmoors">
					<div class="card-body">
						<h5 class="card-title">Ettenmoors</h5>
						<p class="card-text">This is a longer card with supporting
							text below as a natural lead-in to additional content. This
							content is a little bit longer.</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 300px">
					<img src="resources/lacomarca.png" class="card-img-top"
						alt="la comarca">
					<div class="card-body">
						<h5 class="card-title">La Comarca</h5>
						<p class="card-text">This is a longer card with supporting
							text below as a natural lead-in to additional content. This
							content is a little bit longer.</p>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card" style="width: 300px">
					<img src="resources/moria.png" class="card-img-top" alt="moria">
					<div class="card-body">
						<h5 class="card-title">Moria</h5>
						<p class="card-text">This is a longer card with supporting
							text below as a natural lead-in to additional content. This
							content is a little bit longer.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>