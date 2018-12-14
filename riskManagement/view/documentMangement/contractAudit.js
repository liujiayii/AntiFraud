// 激活二级导航
$(document).ready(function() {
	navActive(5);
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
			// console.log(data.elem); //得到select原始DOM对象
			console.log(data.value); // 得到被选中的值
			// console.log(data.othis); //得到美化后的DOM对象

			if (data.value == 'house') {
				// 执行重载
				table.reload('testReload', {
					url : '/Compact/fiandHousePropertyMortgageByStatus.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					done : function() {
						console.log('1完成')
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
						console.log('2完成')
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
						console.log('3完成')
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

var formData = null;

function onLoadPage(name) {
	console.log('aaa');
	var report_id = getHrefParam(name);
	$.ajax({
		url : '/Compact/findCompactByEntry_number.action',
		type : 'post',
		dataType : 'json',
		data : {
			entry_number : report_id
		},
		async : false,
		success : function(result) {
			console.log(result);
			formData = result.data;
		}
	});
	console.log(formData);
}

function contractAuditInfo() {
	onLoadPage("entry_number");
	console.log(formData);
	layui.use([ 'form' ], function() {
		var form = layui.form;
		// 表单初始赋值
		form.val('example', {
			"report_id" : formData[0].report_id, // "name": "value"
			'id' : formData[0].id,
			'user_id' : formData[0].user_id,
			'contract_id' : formData[0].contract_id,
			'create_time' : timeStamp2String(formData[0].create_time),
			'update_time' : timeStamp2String(formData[formData.length-1].update_time),
			'remark' : formData.data[0].remark
		})
		// 监听提交
		form.on('submit(suc)', function(data) {
			console.log('通过');
			$.ajax({
				url : '/SpotRecord/judgementResult.action',
				type : 'post',
				dataType : 'json',
				data : {
					reportId : formData[0].report_id,
					status : 8,
					remark : null
				},
				async : false,
				success : function(result) {
					console.log(result);
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
			console.log('不通过');
			$.ajax({
				url : '/SpotRecord/judgementResult.action',
				type : 'post',
				dataType : 'json',
				data : {
					reportId : formData[0].report_id,
					status : 1,
					remark : $('[name="remark"]').val()
				},
				async : false,
				success : function(result) {
					console.log(result);
					// 墨绿深蓝风
					layerMsgPath('已拒绝', 'contractAudit.jsp', '');
				}
			});
		})

	});

}