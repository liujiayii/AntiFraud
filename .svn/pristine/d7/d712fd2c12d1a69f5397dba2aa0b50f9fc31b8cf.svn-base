//激活垂直导航栏
$(document).ready(function() {
	navActive(1);
	secondNavActive('#assetEvaluation dd', 1)
});

function carEvaluation() {
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			id : 'testReload',
			page : {theme : '#405467'},
			even : true,
			skin : 'line', // 行边框风格
			response : { statusCode : 1 },// 规定成功的状态码，默认：0
			elem : '#realEstateMortgage',
			url : '/VehicleMortgage/findAllVehicleMortgage.action',
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
				field : 'status',
				title : '状态',
				templet : function(d) {
					if (d.status == '1') {
						return "<span class='failed'>未通过</span>"
					} else if (d.status == '0') {
						return "<span class='pass'>已作废</span>"
					} else if (d.status == null) {
						return "<span class='unpass'>未审核</span>"
					} else {
						return "<span class='pass'>已通过</span>"
					}
				}
			}, {
				field : 'operation',
				title : '操作',
				toolbar : '#operation'
			} ] ],
		})

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
						temp : "assetEvaluation"
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
			console.log(data.status);
			if (data.status == 1) {
				window.location.href = "carEvaluationFail.jsp?id=" + data.id;
			} else {
				window.location.href = "carEvaluationInfo.jsp?id=" + data.id;
			}
		});

	});

}

var formData = null;
var formImgUrl = null;
// 页面加载执行
function onLoadPage(name) {
	console.log('aaa');
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
			console.log(result);
			formData = result.data;
			$.ajax({
				url : '/photo/queryImage.action',
				dataType : 'json',
				data : {
					report_id : formData.entry_number
				},
				async : false,
				success : function(result) {
					console.log(result);
					formImgUrl = result;
				}
			});
		}
	});
	console.log(formData);
}

function carEvaluationInfo() {
	// 页面加载执行

	onLoadPage("id");
	console.log(formData);
	layui.use([ 'form' ], function() {
		var form = layui.form;

		// 表单初始赋值
		form.val('example', getFormData())

		// 监听提交
		form.on('submit(suc)', function(data) {
			console.log('通过');
			$.ajax({
				url : '/VehicleMortgage/ResultVehicleMortgage.action',
				type : 'post',
				dataType : 'json',
				data : {
					id : formData.id,
					entry_number : formData.entry_number,
					status : 2
				},
				success : function(result) {
					layerMsgPath('已通过', 'carEvaluation.jsp', '');
				}
			});
			return false;
		});

		form.on('submit(fail)', function(data) {
			layerMsgPath('请填写备注', 'carEvaluationFail.jsp?id=', formData.id)
		});
		// 监听通过
		if (formData.status > 1) {
			layerNOPath();
		}
	})
}

function carEvaluationFail() {
	// 页面加载执行
	onLoadPage("id");
	layui.use([ 'form' ], function() {
		var form = layui.form;
		// 表单初始赋值
		form.val('example', {// "name": "value"
			'id' : formData.id,
			'remark' : formData.remark,
			'status' : formData.status
		})
		// 监听通过
		if (formData.status === 1) {
			layerNOPath();
		}
		// 监听提交
		form.on('submit(Failform)', function(data) {
			console.log(data.field);
			data.field['status'] = 1;
			$.ajax({
				url : '/VehicleMortgage/ResultVehicleMortgage.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function(result) {
					console.log(result);
					// 墨绿深蓝风
					layerMsgPath('已拒绝', 'carEvaluation.jsp', '');

				}
			});

			return false;
		});

	})

}
