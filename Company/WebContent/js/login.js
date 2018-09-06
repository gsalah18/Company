$(document).ready(
		function() {
			$(document).on(
					"submit",
					"#loginForm",
					function(event) {
						var $form = $(this);
						$.post($form.attr("action"), $form.serialize(),
								function(response) {
									if (response == "managerhome"
											|| response == "teamleaderhome"
											|| response == "developerhome") {
										window.location.href = response
									} else {
										$("#errorText").html(response);		
									}
								});

						event.preventDefault();
					});

					
		});