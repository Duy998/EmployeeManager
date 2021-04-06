<%@include file="/common/taglib.jsp"%>
<div class="row">
	<div class="col-sm-3 d-flex align-items-center justify-content-center ">
		<div class="listteam__khung text-center">
			<img
				src='<c:url value = "template/static/images/default/manager.png"/>'
				alt="" class="listteam__khung-img">
			<h5 class="listteam__khung-name pt-3">name</h5>
			<h6 class="listteam__khung-name">Manager</h6>
			<h6 class="listteam__khung-name">12</h6>
		</div>
	</div>
	<div class="col-sm-9">
		<table class="table">
			<thead>
				<tr>
					<td><input type="checkbox" id="check_all"
						ng-click="checkAll()" value="" /></td>
					<td>
						<p href="#"
							ng-click="sortType = 'name'; sortReverse = !sortReverse">
							Students <span ng-show="sortType == 'name' && !sortReverse"
								class="fa fa-caret-down"></span> <span
								ng-show="sortType == 'name' && sortReverse"
								class="fa fa-caret-up"></span>
						</p>
					</td>
					<td>
						<p href="#" ng-click="sortType = 'ex'; sortReverse = !sortReverse">
							Age <span ng-show="sortType == 'ex' && !sortReverse"
								class="fa fa-caret-down"></span> <span
								ng-show="sortType == 'ex' && sortReverse" class="fa fa-caret-up"></span>
						</p>
					</td>
					<td>
						<p href="#"
							ng-click="sortType = 'position'; sortReverse = !sortReverse">
							NickName <span ng-show="sortType == 'position' && !sortReverse"
								class="fa fa-caret-down"></span> <span
								ng-show="sortType == 'position' && sortReverse"
								class="fa fa-caret-up"></span>
						</p>
					</td>
				</tr>
			</thead>

			<tbody>

				<tr
					ng-repeat="x in students | orderBy:sortType:sortReverse | filter:search">
					<td><input type="checkbox" name="name[]" id="check_all"
						value="" /></td>
					<td>{{ x.name }}</td>
					<td>{{ x.ex }}</td>
					<td>{{ x.position}}</td>


				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="listteam__pagination"></div>