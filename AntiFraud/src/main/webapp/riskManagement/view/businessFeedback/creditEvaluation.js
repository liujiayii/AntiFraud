$(document).ready(function() {
	// 激活二级导航
	secondNavActive('#businessFeedback dd', 2)
	navActive(2);
});

function creditEvaluation() {
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			id : 'testReload',
			elem : '#realEstateMortgage',
			url : '/FiduciaryLoan/findFiduciaryLoan.action',
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
				field : 'entry_number',
				title : '报单编号'
			}, {
				field : 'name',
				title : '抵押人姓名'
			}, {
				field : 'phone',
				title : '电话'
			}, {
				field : 'id_number',
				title : '身份证号码'
			},
			{
				field : 'approval_limit',
				title : '审批额度'
			}, {
				field : 'approval_deadline',
				title : '审批期限'
			}, {
				field : 'purpose_of_loan',
				title : '借款用途'
			}, {
				field : 'status',
				title : '状态',
				templet : function(d) {
					if (d.status == '0') {
						return "<span class='unpass'>已过期</span>"
					} else if (d.status == '1') {
						return "<span class='failed'>未通过</span>"
					} else if (d.status == '2') {
						return "<span class='unpass'>未审核</span>"
					} else if (d.status > 2) {
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
					url : '/FiduciaryLoan/listAllAndPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : $('#demoReload').val(),
						temp : 'businessFeedback'
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

				window.location.href = "creditEvaluationInfo.jsp?id=" + data.id;

			}
		});
	});
}

// 页面加载执行
function onLoadPage(name) {
	var id = getHrefParam(name);
	$.ajax({
		url : '/FiduciaryLoan/getDetailsById.action',
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
			//监听审核
			if (formData.status > 2) {
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


function creditEvaluationInfo() {
	onLoadPage('id');
	layui.use([ 'form' ], function() {
		var form = layui.form;		
		// 监听提交
		form.on('submit(formDemo)', function(data) {
			$.post('/FiduciaryLoan/fiduciaryLoanBusFeedback.action',
					data.field, 
					function(data) {
				if (data.code == 1) {
					layerMsgPath('修改成功', 'creditEvaluation.jsp', '');
				}
			});
			return false;
		});
	});
}
