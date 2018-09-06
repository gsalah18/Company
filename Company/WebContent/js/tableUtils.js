$(document).ready(function() {
	
	$('tbody').sortable();
	
	$("#taskSeachText").on("keyup", function() {

		var value = $(this).val().toLowerCase();
		$("#taskTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
	
	$("#developerSeachText").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		
		$("#developerTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
	
	$("#teamLeaderSeachText").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		
		$("#teamLeaderTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
});