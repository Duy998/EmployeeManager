<div id="add" tabindex="-1" role="dialog"
	aria-labelledby="add-modal-label">

	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form class="form-horizontal" id="add-form">
				<div class="modal-header">
					<h4 class="modal-title" id="add-modal-label">Add new Team</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">					
					<div class="alert alert-success" ng-show="showMe">{{success}}</div>
						<label for="add-firstname" class="col-sm-2 control-label">NameTeam</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" ng-model="loadteams.name"
								required>
						</div>
					</div>
					
					

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" ng-click="Add()">Save
						changes</button>
				</div>
			</form>
		</div>
	</div>
</div>