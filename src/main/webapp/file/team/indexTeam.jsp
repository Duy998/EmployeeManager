<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomeTeam</title>
</head>
<body>
<form class="form-horizontal" id="add-form">
	<div class="listteam__header">
		<div class="listteam__header__name">
			<h4 class="font-weight-bolder">{{nameDefault}}</h4>
		</div>
		<div class="listteam__header__search">
			<p>{{namee}}</p>
			<input type="text" placeholder="search team" ng-model="search.$">
			<a class="icon__search" href="#"><i class="fas fa-search"></i></a>
		</div>
		<div class="listteam__header__icon">
	 
			<button type="submit" class="btn btn-primary" ng-click="Delete()"><i class="fas fa-trash-alt"></i></button>
			<a href="#!AddTeam">
				<i class="fas fa-plus-circle"></i>
			</a>
			
		</div>
	</div>
	<div>
		<table class="table">
			<thead>
				<tr>
					<td style="width: 5%;"><input type="checkbox" id="check_all"
						value="" ng-model="all" ng-click="selectAll()"/></td>
					<td ng-click="sortType = 'name'; sortReverse = !sortReverse">
						Name Team<span ng-show="sortType == 'name' && !sortReverse"
						></span> <span
						ng-show="sortType == 'name' && sortReverse"></span>
					</td>
					<td ng-click="sortType = 'ex'; sortReverse = !sortReverse">
						Name Manager <span ng-show="sortType == 'ex' && !sortReverse"
						></span> <span
						ng-show="sortType == 'ex' && sortReverse" ></span>
						</p>
					</td>
					<td ng-click="sortType = 'position'; sortReverse = !sortReverse">
						Number <span ng-show="sortType == 'position' && !sortReverse"
						></span> <span
						ng-show="sortType == 'position' && sortReverse"
						></span>
					</td>
					<td>edit</td>
				</tr>
			</thead>

			<tbody>
				<tr class="childTeam" ng-click="choseTeamEvent(x.name)"
					ng-repeat="x in teams | orderBy:sortType:sortReverse | filter:search">
					
					<td><input type="checkbox" ng-checked="all"></td>
					<td>{{ x.name }}</td>
					<td>{{ x.nameManager }}</td>
					<td>{{ x.getidUsers}}</td>
					<td><a href="" ng-click="loadbyid(x.id)"> <i
							class="fas fa-edit"></i></a></td>
				</tr>
			</tbody>
		</table>
		<ul class="pagination" id="pagination"></ul>

	</div>
</form>
	<script type="text/javascript">
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : 35,
				visiblePages : 5,
				onPageClick : function(event, page) {
					console.info(page + ' (from options)');
				}
			}).on('page', function(event, page) {
				console.info(page + ' (from event listening)');
			});
		});
	</script>
</body>
</html>