// 激活垂直导航栏
$(document).ready(function() {
	navActive(1);
	secondNavActive('#assetEvaluation dd', 0)
});

function housingEvaluation() {
	layui.use([ 'table' ], function() {
		var table = layui.table;

		// 第一个实例
		table.render({
			id : 'testReload',
			elem : '#realEstateMortgage',
			url : '/HousePropertyMortgage/findAll.action',
			page : {
				theme : '#405467'
			},
			even : true,
			skin : 'line', // 行边框风格
			response : {
				statusCode : 1
			// 规定成功的状态码，默认：0
			},
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
				window.location.href = "housingEvaluationFail.jsp?id=" + data.id;
			} else {
				window.location.href = "housingEvaluationInfo.jsp?id=" + data.id;
			}
		});

	});

}

var formData = null;
var formImgUrl = null;
// 页面加载执行
function onLoadPage(name) {
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

function housingEvaluationInfo() {
	onLoadPage("id");
	layui.use([ 'form' ], function() {
		var form = layui.form;

		// 表单初始赋值
		form.val('example', getFormData())

		// 监听提交
		form.on('submit(suc)', function(data) {

			$.ajax({
				url : '/HousePropertyMortgage/ResultHousePropertyMortgage.action',
				type : 'post',
				dataType : 'json',
				data : {
					id: formData.id,
					entry_number : formData.entry_number,
					status : 2
				},
				success : function(result) {
					// 墨绿深蓝风
					layerMsgPath('已通过', 'housingEvaluation.jsp', '');
				}
			});
			return false;
		});

		form.on('submit(fail)', function(data) {
			// 墨绿深蓝风
			layerMsgPath('请填写备注', 'housingEvaluationFail.jsp?id=', formData.id)		
			return false;

		});
		// 监听通过
		if (formData.status > 1) {
			$(".page-but button").attr('lay-filter', '');
			$(".page-but button").click(function() {
				// 墨绿深蓝风
				layerNOPath();
			})
		}
	})
}

function housingEvaluationFail() {

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
			data.field['status'] = 1;
			$.ajax({
				url : '/HousePropertyMortgage/ResultHousePropertyMortgage.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function(result) {
					// 墨绿深蓝风
					layerMsgPath('已拒绝', 'housingEvaluation.jsp', '');
				}
			});
			return false;
		});

	})

}
