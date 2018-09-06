<%@ attribute name="userId" required="true" rtexprvalue="true"%>
<body>
	<div class="modal" id="addTaskModal">
		<div class="modal-dialog">
			<div class="modal-content">


				<div class="modal-header">
					<h4 class="modal-title">Add Task</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<form name="addTaskForm" id="addTaskForm" action="addtask"
					method="POST">

					<div class="modal-body">

						<div class="form-group">
							<label for="name">Description</label> <input name="name" id="name"
								class="form-control" type="text" placeholder="Enter Name">
						</div>

						<div class="form-group">
							<label for="desc">Description</label> <input name="desc" id="desc"
								class="form-control" type="text" placeholder="Enter Description">
						</div>
						
						<div class="form-group">
							<label for="deadline">Deadline</label> <input name="deadline"
								id="deadline" class="form-control" type="date"
								placeholder="Enter The Deadline Date">
						</div>
						<input type="text" value="${ userId }" name="userId" hidden="true">
					</div>


					<div class="modal-footer">
						<button type="submit" class="btn btn-primary"
							id="addTeamLeaderBtn">Add</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal"
							id="taskModalClose">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
