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
			page : {
				theme : '#405467'
			},
			even : true,
			skin : 'line', // 行边框风格
			response : {
				statusCode : 1
			},// 规定成功的状态码，默认：0
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
			if (data.status == 1) {
				window.location.href = "carEvaluationFail.jsp?id=" + data.id;
			} else {
				window.location.href = "carEvaluationInfo.jsp?id=" + data.id;
			}
		});

	});

}

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
		success : function(result) {
			var formData = result.data;
			layui.use([ 'form' ], function() {
				var form = layui.form;
				// 表单初始赋值
				form.val('example', getFormData(formData))
			})
			// 监听审核
			if (formData.status != null) {
				layerNOPath();
			}
			$.ajax({
				url : '/photo/queryImage.action',
				dataType : 'json',
				data : {
					report_id : formData.entry_number
				},
				success : function(result) {
					businessImgLayer(result);
				}
			});
		}
	});
}

function carEvaluationInfo() {
	// 页面加载执行
	onLoadPage("id");
	layui.use([ 'form' ], function() {
		var form = layui.form;

		// 监听提交
		form.on('submit(suc)', function(data) {
			// prompt层
			layer.prompt({
				title : '输入审批额度，并确认'
			}, function(pass, index) {
				$.ajax({
					url : '/VehicleMortgage/ResultVehicleMortgage.action',
					type : 'post',
					dataType : 'json',
					data : {
						id : data.field.id,
						entry_number : data.field.entry_number,
						status : 2,
						approval_amount: pass
					},
					success : function(result) {
						layerMsgPath('已通过', 'carEvaluation.jsp', '');
					}
				})
				layer.close(index);
			});
			return false;
		});

		form.on('submit(fail)', function(data) {
			layerMsgPath('请填写备注', 'carEvaluationFail.jsp?id=', $("[name='id']").val().val())
		});
	})
}

function carEvaluationFail() {
	// 页面加载执行
	onLoadPage("id");
	layui.use([ 'form' ], function() {
		var form = layui.form;
		// 监听提交
		form.on('submit(Failform)', function(data) {
			data.field['status'] = 1;
			$.ajax({
				url : '/VehicleMortgage/ResultVehicleMortgage.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function(result) {
					// 墨绿深蓝风
					layerMsgPath('已拒绝', 'carEvaluation.jsp', '');

				}
			});

			return false;
		});

	})

}
