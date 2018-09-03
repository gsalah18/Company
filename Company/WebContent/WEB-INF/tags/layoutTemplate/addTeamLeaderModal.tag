

<body>
	<div class="modal" id="addTeamLeaderModal">
		<div class="modal-dialog">
			<div class="modal-content">


				<div class="modal-header">
					<h4 class="modal-title">Add Team Leader</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				
				<form name="addTeamLeaderFrom" id="addTeamLeaderFrom"
					action="addteamleader" method="POST">

					<div class="modal-body">

						<div class="form-group">
							<label for="for">Name</label> <input name="name" id="name"
								class="form-control" type="text" placeholder="Enter The Name">
						</div>

						<div class="form-group">
							<label for="password">Password</label> <input name="password"
								id="password" class="form-control" type="password"
								placeholder="Enter The Password">
						</div>
					</div>


					<div class="modal-footer">
						<button type="submit" class="btn btn-primary"
							id="addTeamLeaderBtn">Add</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal" 
						id="teamLeaderModalClose">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
