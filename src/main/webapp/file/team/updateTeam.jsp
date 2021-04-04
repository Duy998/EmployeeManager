<div  id="add" tabindex="-1" role="dialog" aria-labelledby="add-modal-label">
   
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form class="form-horizontal" id="add-form">
                <div class="modal-header">
                    <h4 class="modal-title" id="add-modal-label">Add new Team</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="add-firstname" class="col-sm-2 control-label">Firstname</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" value="{{item.name}}">
                        </div>
                    </div> 
                    <div class="form-group">
                     <select name="repeatSelect" id="repeatSelect" ng-model="loadteams.getidUsers">
      					<option ng-repeat="option in item" value="{{option.id}}" >{{option.posiTion}}</option>
    				 </select>
                    </div>
                    
                    
                    <div class="form-group">
                  		<input type="checkbox" ng-model="selectAll" ng-click="checkAll"> Check all<br><br>
                  		<div ng-repeat="option in item">
	                  		<input type="checkbox" ng-model="checked">
							<label for="vehicle1"> {{option.name}}</label><br>
                  		</div>
                    </div>
            </md-select>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" ng-click="Add()">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>