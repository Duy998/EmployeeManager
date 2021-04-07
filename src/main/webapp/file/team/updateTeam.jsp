<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <link rel="stylesheet" type="text/css"
	href='<c:url value = "/file/team/css/editteam.css"/>'> --%>
</head>
<body>
	<div id="add" tabindex="-1" role="dialog"
		aria-labelledby="add-modal-label">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form class="form-horizontal" id="add-form">
					<div class="modal-header">
						<h4 class="modal-title" id="add-modal-label">Update new Team
							{{loadbyid.nameTeamoooooo}}</h4>

					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="add-firstname" class="col-sm-2 control-label">Firstname</label>
							<div class="col-sm-10">
								<div>

									<input type="text" ng-model="idTeam"
										ng-value="loadupdateteam.idTeam" /> <input type="text"
										ng-model="nameTeam" ng-value="loadupdateteam.nameTeam" />
								</div>

							</div>
						</div>
						<div class="form-group">
							<select ng-model="managername">
								<option ng-repeat="option in loadupdateteam.listmanager"
									value="{{option.name}}">{{option.name}}</option>
							</select>

						</div>


						<div class="form-group">
							<div ng-repeat="option in loadupdateteam.listallUser">
								<input type="checkbox" ng-checked="{{option.checked}}"
									ng-model="option.Selected"> <label for="vehicle1">
									{{option.name}}</label><br>
							</div>
						</div>
						</md-select>
						{{result}}
					</div>
					<div class="modal-footer">
						<button type="button" value="Get" class="btn btn-primary"
							ng-click="GetValue()">Update changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>