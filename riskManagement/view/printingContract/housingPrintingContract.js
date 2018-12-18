// 激活导航
$(document).ready(function() {
	navActive(5);
	secondNavActive('#printingContract dd', 0)
});
layui.use([  'table' ], function() {
	var table = layui.table;

	// 第一个实例
	table.render({
		elem : '#realEstateMortgage',
		url : '/Compact/findAllHousePropertyMortgageForCompact.action',
		page : {
			theme : '#405467'
		},
		id : 'testReload',
		even : true,
		skin : 'line', // 行边框风格
		response : {
			statusCode : 1
		// 规定成功的状态码，默认：0
		},
		cols : [ [ // 表头
		{
			field : 'name',
			title : '姓名'
		},
		{
			field : 'entry_number',
			title : '报单编号'
		}, {
			field : 'phone',
			title : '电话'
		}, {
			field : 'post',
			title : '职位'
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
					console.log('完成')
				}
			});
		}
	};

	$('#demoReload').on('input', function() {
		var type = $(this).data('type');
		console.log(type);
		active[type] ? active[type].call(this) : '';
	});

	// 监听行工具事件
	table.on('tool(realEstateMortgage)', function(obj) {
		var data = obj.data;
		console.log(obj);
		if (obj.event == 'see') {
			window.location.href = "/Compact/creatCompact.action?entry_number=" + data.entry_number;

		}
	});

});