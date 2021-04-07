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
				<input type="text" placeholder="search team" ng-model="search.$">
				<a class="icon__search" href="#"><i class="fas fa-search"></i></a>
			</div>
			<div class="listteam__header__icon">

				<button type="submit" ng-click="Delete()">
					<i class="fas fa-trash-alt"></i>
				</button>
				<a href="#!AddTeam"> <i class="fas fa-plus-circle"></i>
				</a>

			</div>
		</div>
		<div></div>
		<table class="table">
			<thead>
				<tr class="tr_td_frirst">
					<td style="width: 5%;"><input type="checkbox"
						ng-change="checkAll(checkedAll)" ng-model="checkedAll" /></td>
					<td ng-click="sortType = 'name'; sortReverse = !sortReverse">
						NAME TEAM<span ng-show="sortType == 'name' && !sortReverse"></span>
						<span ng-show="sortType == 'name' && sortReverse"></span>
					</td>
					<td ng-click="sortType = 'ex'; sortReverse = !sortReverse">
						NAME<span ng-show="sortType == 'ex' && !sortReverse"></span>
					</td>
					<td ng-click="sortType = 'position'; sortReverse = !sortReverse">
						NUMBER <span ng-show="sortType == 'position' && !sortReverse"></span>
						<span ng-show="sortType == 'position' && sortReverse"></span>
					</td>
					<td>EDIT</td>
				</tr>
			</thead>


			<tbody>
				<tr class="childTeam" ng-click="choseTeamEvent(x.name)"
					ng-repeat="x in teams.listresult | orderBy:sortType:sortReverse | filter:search">
					<td><input ng-change="checkItem(x.id, x.selected)"
						type="checkbox" ng-model="x.selected" /></td>
					<td ng-click="Information(x.id)">{{ x.name }}</td>
					<td>{{ x.nameManager }}</td>
					<td>{{ x.number}}</td>
					<td><button ng-click="loadbyid(x.id)" class="btn-edit">
							<i class="fas fa-edit"></i>
						</button></td>
				</tr>
			</tbody>

		</table>
	</form>
	<div class="container">
		<nav aria-label="Page navigation">
			<ul class="pagination" id="pagination"></ul>
		</nav>
	</div>
	

	
	
</body>
</html>