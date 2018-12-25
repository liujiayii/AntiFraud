// 激活二级导航
$(document).ready(function() {
	navActive(6 );
	secondNavActive('#documentMangement dd', 0)
});

function contractAudit() {
	layui.use([ 'form', 'table' ], function() {
		var form = layui.form, table = layui.table;
		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/Compact/fiandHousePropertyMortgageByStatus.action',
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
			}, {
				field : 'phone',
				title : '电话'
			}, {
				field : 'entry_number',
				title : '报单编号'
			}, {
				field : 'status',
				title : '状态',
				templet : function(d) {
					return "<span class='unpass'>未审核</span>"

				}
			}, {
				field : 'operation',
				title : '操作',
				toolbar : '#operation'
			}, ] ]
		});

		// 搜索

		form.on('select(upload)', function(data) {

			if (data.value == 'house') {
				// 执行重载
				table.reload('testReload', {
					url : '/Compact/fiandHousePropertyMortgageByStatus.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					done : function() {
					}
				});
			} else if (data.value == 'car') {
				// 执行重载
				table.reload('testReload', {
					url : '/Compact/fiandVehicleMortgageByStatus.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					done : function() {
					}
				});
			} else if (data.value == 'credit') {
				// 执行重载
				table.reload('testReload', {
					url : '/Compact/fiandFiduciaryLoanByStatus.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					done : function() {
					}
				});
			}

		});
		// 监听行工具事件
		table.on('tool(realEstateMortgage)', function(obj) {
			var data = obj.data;
			if (obj.event == 'see') {
				window.location.href = "contractAuditInfo.jsp?entry_number=" + data.entry_number;

			}
		});

	})
}


function onLoadPage(name) {
	var report_id = getHrefParam(name);
	$.ajax({
		url : '/Compact/findCompactByEntry_number.action',
		type : 'post',
		dataType : 'json',
		data : {
			entry_number : report_id
		},
		success : function(result) {
			var formData = result.data[result.data.length-1];
			layui.use([ 'form' ], function() {
				var form = layui.form;
				// 表单初始赋值
				form.val('example', {
					"report_id" : formData.report_id, // "name": "value"
					'id' : formData.id,
					'user_id' : formData.user_id,
					'contract_id' : formData.contract_id,
					'create_time' : timeStamp2String(formData.create_time),
					'update_time' : timeStamp2String(formData.update_time),
					'remark' : formData.remark
				})
			})
		}
	});
}

function contractAuditInfo() {
	onLoadPage("entry_number");
	layui.use([ 'form' ], function() {
		var form = layui.form;
		// 监听提交
		form.on('submit(suc)', function(data) {
			$.ajax({
				url : '/SpotRecord/judgementResult.action',
				type : 'post',
				dataType : 'json',
				data : {
					reportId : $("[name='report_id']").val(),
					status : 8,
					remark : null
				},
				success : function(result) {
					// 墨绿深蓝风
					if(result.code === 1){
						layerMsgPath(result.msg, 'contractAudit.jsp', '');
					}else{
						// 墨绿深蓝风
						layerClose(result.msg)
					}					
				}
			});
		})
		form.on('submit(fail)', function(data) {
			$.ajax({
				url : '/SpotRecord/judgementResult.action',
				type : 'post',
				dataType : 'json',
				data : {
					reportId : $("[name='report_id']").val(),
					status : 1,
					remark : $('[name="remark"]').val()
				},
				success : function(result) {
					// 墨绿深蓝风
					layerMsgPath('已拒绝', 'contractAudit.jsp', '');
				}
			});
		})

	});

}