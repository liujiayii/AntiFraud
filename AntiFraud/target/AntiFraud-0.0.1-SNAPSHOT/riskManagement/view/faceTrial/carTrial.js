//激活二级导航
$(document).ready(function() {
	navActive(4);
	secondNavActive('#faceTrial dd', 1)
});

function carTrial() {
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/ReplenishProcedureImage/findVehiclesd.action',
			page : {
				theme : '#405467'
			},
			id : 'testReload',
			response : {
				statusCode : 1
			// 规定成功的状态码，默认：0
			},
			even : true,
			skin : 'line', // 行边框风格

			cols : [ [ // 表头
			           {
							field : 'entry_number',
							title : '报单编号'
						}, {
							field : 'name',
							title : '姓名'
						}, {
							field : 'phone',
							title : '电话'
						},{
							field : 'create_time',
							title : '时间'
						}, {
							field : 'operation',
							title : '操作',
							toolbar : '#operation'
						}, ] ]
					});

		// 搜索

		var active = {
			reload : function() {
				// 执行重载
				table.reload('testReload', {
					url : '/HousePropertyMortgage/listAllAndPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : $('#demoReload').val()
					},
					done : function() {
					}
				});
			}
		};

		$('#demoReload').on('input', function() {
			var type = $(this).data('type');
			active[type] ? active[type].call(this) : '';
		});

		// 监听行工具事件
		table.on('tool(realEstateMortgage)', function(obj) {
			var data = obj.data;
			if (obj.event == 'see') {
				window.location.href = "carTrialList.jsp?entry_number=" + data.entry_number;
			}
		});

	});

}

function carTrialList() {
	var entry_number = getHrefParam('entry_number');
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/SpotRecord/findAllSpotRecordfd.action?cs='+entry_number,
			page : {
				theme : '#405467'
			},
			id : 'testReload',
			response : {
				statusCode : 1
			// 规定成功的状态码，默认：0
			},
			even : true,
			skin : 'line', // 行边框风格

			cols : [ [ // 表头
			           {
							field : 'report_id',
							title : '报单编号'
						}, {
							field : 'trid',
							title : '轨迹ID'
						}, {
							field : 'create_time',
							title : '实地时间'
						},{
							field : 'address',
							title : '实地地址'
						}, {
							field : 'operation',
							title : '操作',
							toolbar : '#operation'
						}, ] ]
					});

		// 监听行工具事件
		table.on('tool(realEstateMortgage)', function(obj) {
			var data = obj.data;
			if (obj.event == 'see') {
				window.location.href = "carTrialInfo.jsp?trid=" + data.trid;
			}
		});

	});
}