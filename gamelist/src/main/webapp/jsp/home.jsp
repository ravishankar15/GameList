<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="homeApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Game List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css" />
<link rel="stylesheet" href="resources/css/datatables/dataTables.fixedColumns.css">
<link rel="stylesheet" href="resources/css/datatables/fixedHeader.dataTables.css">
<link rel="stylesheet" href="resources/css/datatables/select.dataTables.css">
<link rel="stylesheet" href="resources/css/datatables/datatables.bootstrap.css">
<link rel="stylesheet" href="resources/css/datatables/angular-datatables.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<style>
body {
	padding: 30px;
}
.float_right{
	float: right;
}
.margin_20px{
	margin: 20px;
}

#resultTable_info {
	padding-top: 4px !important;
}

#columnFilter > th,
#resultTable_wrapper,
.noPadding {
	padding: 0 !important;
}

table.dataTable {
	margin-top: 0 !important;
}  
</style>
</head>
<body ng-controller="homeController as hmeCtrl">
	<div class="panel-headline">
		<div class="spanel panel panel-headline">
			<div class="panel-body">
				<h2>Game List</h2>
				<div class="row" ng-if="isInitLoaded">
					<div class="col-xs-12 margin_20px">
						<div class="col-xs-4">
							<div custom-select="x for x in titleList | filter: $searchTerm track by $index" ng-model="game.title" custom-select-options="hmeCtrl.titleOptions" title="Title"
								name="title">
							</div>
						</div>
						<div class="col-xs-4">
							<button type="button" class="btn btn btn-primary" ng-click="getGameList()">GetList</button>
							<button type="button" class="btn btn btn-default" ng-click="reset()">Reset</button>
						</div>
					</div>
				</div>
			</div>
			<div class="spanel panel panel-headline" ng-if="isTableDisplay">
				<table datatable="" id="resultTable" dt-options="hmeCtrl.dtOptions" 
					dt-columns="hmeCtrl.dtColumns"class="table table-bordered">
					<thead>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>				
					</tbody>
				</table>
			</div>
		</div>
	</div>


<!-- Required Js files -->
<script src="resources/js/requiredjs/jquery-2.1.0.min.js"></script>
<script src="resources/js/requiredjs/bootstrap.min.js"></script>
<script src="resources/js/requiredjs/angular.min.js"></script>
<script src="resources/js/requiredjs/ui-bootstrap-tpls.min.js"></script>

<script src="resources/js/requiredjs/customSelect.js"></script>

<script src="resources/js/requiredjs/datatables/jquery.dataTables.js"></script>
<script src="resources/js/requiredjs/datatables/dataTables.select.js"></script>
<script src="resources/js/requiredjs/datatables/dataTables.columnFilter.js"></script>
<script src="resources/js/requiredjs/datatables/dataTables.scroller.js"></script>

<script src="resources/js/requiredjs/datatables/angular-datatables.js"></script>
<script src="resources/js/requiredjs/datatables/angular-datatables.util.js"></script>
<script src="resources/js/requiredjs/datatables/angular-datatables.options.js"></script>
<script src="resources/js/requiredjs/datatables/angular-datatables.instances.js"></script>
<script src="resources/js/requiredjs/datatables/angular-datatables.factory.js"></script>
<script src="resources/js/requiredjs/datatables/angular-datatables.renderer.js"></script>
<script src="resources/js/requiredjs/datatables/angular-datatables.directive.js"></script>
<script src="resources/js/requiredjs/datatables/angular-datatables.columnfilter.js"></script>
<script src="resources/js/requiredjs/datatables/angular-resource.min.js"></script>
<script src="resources/js/requiredjs/datatables/angular-datatables.select.js"></script>
<script src="resources/js/requiredjs/datatables/angular-datatables.scroller.js"></script>

<!-- App JS -->
<script src="resources/js/homeController.js"></script>

</body>
</html>
