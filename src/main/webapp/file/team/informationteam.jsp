
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<h1>duy</h1>
			</div>
			<div class="col-sm-9">
				<table class="table table-bordered table-hover">
					<thead class="bg-primary text-white text-center">
						<tr>
							<th>Name</th>
							<th>Position</th>
							<th>experience</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>{{infornames.name}}</td>
							<td>{{infornames.nameManager}}</td>
							<td>{{infornames.name}}</td>
						</tr>
						<tr ng-repeat="item in infornames.users">
							<td>{{item.name}}</td>
							<td>{{item.posiTion}}</td>
							<td>{{item.name}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	
		
	</div>
