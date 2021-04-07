<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css"
	href='<c:url value = "/file/team/css/editteam.css"/>'>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<h1>duy</h1>
			</div>
			<div class="col-sm-9">
				<table class="infor__table">
					<thead class="infer__thead">
						<tr class="infer__tr">
							<th class="infer__th">Name</th>
							<th class="infer__th">Position</th>
							<th class="infer__th">experience</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in infornames.users" class="infor__tr">
							<td class="infor__td">{{item.name}}</td>
							<td class="infor__td">{{item.posiTion}}</td>
							<td class="infor__td">{{item.exPe}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>


	</div>
</body>
</html>