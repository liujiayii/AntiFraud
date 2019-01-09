//激活二级导航
$(document).ready(function() {
	navActive(0);
	secondNavActive('#businessReport dd', 1)
});

function carMortgage() {
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/VehicleMortgage/findAllVehicleMortgage.action',
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
				field : 'name',
				title : '抵押人姓名'
			}, {
				field : 'phone',
				title : '电话'
			}, {
				field : 'id_number',
				title : '身份证号码'
			}, {
				field : 'emergency_name',
				title : '紧急联系人'
			}, {
				field : 'emergency_phone',
				title : '紧急联系人电话'
			}, {
				field : 'apply_for_limit',
				title : '申请额度'
			}, {
				field : 'apply_for_deadline',
				title : '申请期限'
			}, {
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
					url : '/VehicleMortgage/findAllAndPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : $('#demoReload').val(),
						temp : "businessReport"
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
				window.location.href = "carMortgageInfo.jsp?id=" + data.id;
			}
		});

	});

}

function carMortgageInfo() {
	onLoadPage('id');
	layui.use([ 'form'], function() {
		var form = layui.form;

		// 表单初始赋值
		form.val('example', getFormData())
	})
}

var formData = null;
var formImgUrl = null;
// 页面加载执行
function onLoadPage(name) {
	var id = getHrefParam(name);
	$.ajax({
		url : '/VehicleMortgage/selectIdVehicleMortgage.action',
		type : 'post',
		dataType : 'json',
		data : {
			id : id
		},
		async : false,
		success : function(result) {
			formData = result.data;
			$.ajax({
				url : '/photo/queryImage.action',
				dataType : 'json',
				data : {
					report_id : formData.entry_number
				},
				async : false,
				success : function(result) {
					formImgUrl = result;
				}
			});
		}
	});
}
