

$(document).ready(function() {
	$(document).on("submit", "#addTeamLeaderForm", function(event) {
		var $form = $(this);
		$.post($form.attr("action"), $form.serialize(), function(response) {
			location.reload();
			$("#teamLeaderModalClose").trigger("click");
		});

		event.preventDefault();
	});
	
	$(document).on("submit", "#addDeveloperForm", function(event) {
		var $form = $(this);
		$.post($form.attr("action"), $form.serialize(), function(response) {
			location.reload();
			$("#developerModalClose").trigger("click");
			alert("Developer is Added");
		});

		event.preventDefault(); // Important! Prevents submitting the form.
	});
	
	$(document).on("submit", "#addTaskForm", function(event) {
		var $form = $(this);
		$.post($form.attr("action"), $form.serialize(), function(response) {
			location.reload();
			$("#taskModalClose").trigger("click");
		});

		event.preventDefault();
	});
});
