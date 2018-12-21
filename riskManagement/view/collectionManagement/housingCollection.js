//激活垂直导航栏
$(document).ready(function() {
	navActive(9);
	secondNavActive('#collectionManagement dd', 0)
});

function housingCollection() {
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/LiquidateManage/findAllHouseProperty.action',
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
				field : 'entry_number',
				title : '报单编号'
			}, {
				field : 'name',
				title : '姓名'
			}, {
				field : 'phone',
				title : '电话'
			}, {
				field : 'approval_limit',
				title : '贷款金额'
			}, {
				field : 'affirm_time',
				title : '贷款时间',
				templet : function(d) {
					return timeStamp2String(d.affirm_time)
				}
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
					url : '/LiquidateManage/findHousePropertyByPhone.action',
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
				window.location.href = "housingCollectionInfo.jsp?entry_number=" + data.entry_number;
			}
		});

	});
}

function housingCollectionInfo() {
	onLoadPage('entry_number');
	layui.use([ 'form' ], function() {
		var form = layui.form;

		// 表单初始赋值

		form.val('example', getCollectionFormData())

	});
}

var formData = null;
// 页面加载执行
function onLoadPage(name) {
	var entry_number = getHrefParam(name);
	$.ajax({
		url : '/LiquidateManage/findHousePropertyByEntry_number.action',
		type : 'post',
		dataType : 'json',
		data : {
			id : entry_number
		},
		async : false,
		success : function(result) {
			formData = result.data;
		}
	});
}

