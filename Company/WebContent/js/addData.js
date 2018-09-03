

$(document).ready(function(){
	$(document).on("submit", "#addTeamLeaderFrom", function(event) {
	    var $form = $(this);
	    $.post($form.attr("action"), $form.serialize(), function(response) {
	    	location.reload();
	    	$( "#teamLeaderModalClose" ).trigger( "click" );
	    });

	    event.preventDefault(); // Important! Prevents submitting the form.
	});
});

$(document).ready(function(){
	$(document).on("submit", "#addDeveloperFrom", function(event) {
	    var $form = $(this);
	    $.post($form.attr("action"), $form.serialize(), function(response) {
	    	location.reload();
	    	$( "#developerModalClose" ).trigger( "click" );
	    	alert("Developer is Added");
	    });

	    event.preventDefault(); // Important! Prevents submitting the form.
	});
});