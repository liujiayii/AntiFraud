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
			url : '/HousePropertyMortgage/findAll.action',
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
				field : 'type',
				title : '状态',
				templet : function(d) {
					if (d.type == '0') {
						return "<span class='failed'>已保存</span>"
					} else if (d.type == '1') {
						return "<span class='pass'>已提交</span>"
					} else if (d.type == '2') {
						return "<span class='unpass'>未查看</span>"
					}
				}
			},{
				field : '',
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
				window.location.href = "carTrialList.jsp?id=" + data.id;
			}
		});

	});

}

function carTrialList() {
	onLoadPage('id');
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/HousePropertyMortgage/findAll.action',
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
				title : '轨迹ID'
			}, {
				field : 'phone',
				title : '实地时间'
			},{
				field : 'phone',
				title : '实地地址'
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
				window.location.href = "carTrialInfo.jsp?id=" + data.id;
			}
		});

	});
}
var formData = null;
// 页面加载执行
function onLoadPage(name) {
	console.log('aaa');
	var id = getHrefParam(name);
	$.ajax({
		url : '/HousePropertyMortgage/selectById.action',
		type : 'post',
		dataType : 'json',
		data : {
			id : id
		},
		async : false,
		success : function(result) {
			console.log(result);
			formData = result.data;
		}
	});
	console.log(formData);
}
function carTrialInfo() {
	
}