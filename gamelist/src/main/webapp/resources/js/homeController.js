var home_app = angular.module("homeApp",['AxelSoft','datatables', 'datatables.columnfilter', 'datatables.select']);
home_app.controller('homeController',function($compile, $scope, $http, $q, DTOptionsBuilder, DTColumnBuilder){
	
	var vm = this;
	
	$scope.game = {};
	$scope.isTableDisplay = false;
	$scope.isInitLoaded = false;
	
	$scope.titleList = {};
	
	$scope.reset = function(){
		$scope.isTableDisplay = false;
		$scope.game = {};
	}
	
	vm.titleOptions = {
    	displayText: 'Title'
    };
	
	$http.get('gamelist-module/getTitleList').success(function(response){
		$scope.isInitLoaded = true;
		$scope.titleList = response;
	});

	$scope.getGameList = function() {
		$scope.isTableDisplay = false;
		var getTableData = function(){
			var defer = $q.defer();
			var game = $scope.game;
			$http.post('gamelist-module/getGameList',game).success(function(response){
				$scope.gameList = response;
				$scope.isTableDisplay = true;
				var data = angular.copy(response);
				defer.resolve(data);
			});
			return defer.promise;
		};
		vm.message = '';
		vm.rowClickHandler = rowClickHandler;
		vm.dtOptions = DTOptionsBuilder.fromFnPromise(getTableData())
		.withLanguage(
			{
				"info": "Total Recodrs Fetched: <strong> _MAX_ </strong>",
				"infoEmpty": "Total Recodrs Fetched: <strong> _MAX_ </strong>",
				"infoFiltered": ""
			})
			.withDOM('itr')
			.withOption('paging', false)
			.withOption('order', [0, 'asc'])
			.withOption('scrollY', '250px')
			.withOption('scrollX', '100%')
			.withOption('scrollCollapse', true)
			.withOption('rowCallback', rowCallback)
			.withOption('createdRow', createdRow)
			.withSelect({
				style: 'os',
				selector: 'td',
				info: false
			}).withColumnFilter({
					sPlaceHolder: "head:after",
					aoColumns: [{
						type: 'text',
						bRegex: true,
						bSmart: true
					}, {
						type: 'text',
						bRegex: true,
						bSmart: true
					}, {
						type: 'text',
						bRegex: true,
						bSmart: true
					},{
						type: 'text',
						bRegex: true,
						bSmart: true
					}, {
						type: 'text',
						bRegex: true,
						bSmart: true
					}]
				});
		
		vm.dtColumns = [
			DTColumnBuilder.newColumn('title')
				.withTitle('Title').withOption(
				'defaultContent', ''),
			DTColumnBuilder.newColumn('platform')
				.withTitle('Platform')
				.withOption('defaultContent', ''),
			DTColumnBuilder.newColumn('score')
				.withTitle('Score').withOption(
				'defaultContent', ''),
			DTColumnBuilder.newColumn('genre')
				.withTitle('Genre').withOption(
				'defaultContent', ''),
			DTColumnBuilder.newColumn('editorchoice')
				.withTitle('Editor Choice').withOption(
				'defaultContent', ''),
		];
	};
	function createdRow(row, data, dataIndex) {
		// Recompiling so we can bind Angular directive to the
		// DT
		$compile(angular.element(row).contents())($scope);
	}
	function rowClickHandler(info) {
		//console.log(info);
	}
	function rowCallback(nRow, aData, iDisplayIndex,
		iDisplayIndexFull) {

		$('td', nRow).unbind('click');
		$('td', nRow).bind('click', function () {
			$scope.$apply(function () {
				vm.rowClickHandler(aData);
			});
		});
		return nRow;
	}
});