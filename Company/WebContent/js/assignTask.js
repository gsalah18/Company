$(document).ready(function () {
	$(document).on("submit", "#assignTaskForm", function(event) {
		var $form = $(this);
		$.post($form.attr("action"), $form.serialize(), function(response) {
			window.location.href="index";
		});
		
		event.preventDefault();
	});
})