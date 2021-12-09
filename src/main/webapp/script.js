(function() {
	'use strict'

	var forms = document.querySelectorAll('.needs-validation')

	Array.prototype.slice.call(forms)
		.forEach(function(form) {
			form.addEventListener('submit', function(event) {
				if (!form.checkValidity()) {
					event.preventDefault()
					event.stopPropagation()
				}

				form.classList.add('was-validated')
			}, false)
		})
})

//Navbar shrink
window.onscroll = function() {
	if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
		document.getElementById("navbar").style.padding = "30px 10px";
		document.getElementById("navbar").style.fontSize = "large";
		document.getElementById("imagen-logo").style.height = "45px";
		document.getElementById("imagen-logo").style.transition = "0.4s";
		document.getElementById("botonLogin").classList.remove("btn-lg");
		document.getElementById("botonLogin").style.transition = "0.4s";
	} else {
		document.getElementById("navbar").style.fontSize = "x-large";
		document.getElementById("imagen-logo").style.height = "70px";
		document.getElementById("imagen-logo").style.transition = "0.4s";
		document.getElementById("botonLogin").classList.add("btn-lg");
		document.getElementById("botonLogin").style.transition = "0.4s";
	}
}

$(function() {
	$("#tipoDePromocion").change(function() {
		if ($(option).val() === "sinElegir") {
			$("#promoInput").hide;
		} else {
			$("#promoInput").show;
		}
	});
});
