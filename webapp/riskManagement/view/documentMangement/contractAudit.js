// 激活二级导航
$(document).ready(function() {
	$($('#documentMangement dd')[0]).addClass('layui-this');
	$($('.layui-side .layui-nav-item')[5]).addClass('layui-nav-itemed');
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
			parseData : function(res) { // res 即为原始返回的数据
				return {
					"code" : res.code, // 解析接口状态
					"msg" : res.msg, // 解析提示文本
					"count" : res.count, // 解析数据长度
					"data" : res.data
				// 解析数据列表
				};
			},
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
			console.log(obj);
			reportId = data.report_id;
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
			formData = result;
		}
	});
	console.log(formData);
}
// 获取地址栏参数，name:参数名称
function getHrefParam(key) {
	var s = window.location.href;
	var reg = new RegExp(key + "=\\w+");
	var rs = reg.exec(s);
	if (rs === null || rs === undefined) {
		return "";
	} else {
		return rs[0].split("=")[1];
	}
}
function contractAuditInfo() {
	onLoadPage("entry_number");
	console.log(formData);
	layui.use([ 'form' ], function() {
		var form = layui.form;
		var lastIndex = formData.data.length;
		console.log(lastIndex);
		// 表单初始赋值
		form.val('example', {
			"report_id" : formData.data[0].report_id, // "name": "value"
			'id' : formData.data[0].id,
			'user_id' : formData.data[0].user_id,
			'contract_id' : formData.data[0].contract_id,
			'create_time' : timeStamp2String(formData.data[0].create_time),
			'update_time' : timeStamp2String(formData.data[lastIndex-1].update_time),
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
					reportId : formData.data[0].report_id,
					status : 8,
					remark : null
				},
				async : false,
				success : function(result) {
					console.log(result);
					// 墨绿深蓝风
					if(result.code === 1){
						layer.alert(result.msg, {
							skin : 'layui-layer-molv' // 样式类名
							,
							closeBtn : 0
						}, function() {
							window.location.href = 'contractAudit.jsp';
						});
					}else if(result.code === -1){
						// 墨绿深蓝风
							layer.alert(result.msg, {
								skin : 'layui-layer-molv' // 样式类名
								,
								closeBtn : 0
							}, function() {
								layer.closeAll(); 
							});
					}else if(result.code === -2){

						layer.alert(result.msg, {
							skin : 'layui-layer-molv' // 样式类名
							,
							closeBtn : 0
						}, function() {
							layer.closeAll(); 
						});
					}
					
					
					
				}
			});
		})
		form.on('submit(fail)', function(data) {
			var remark = $('[name="remark"]').val();
			console.log('不通过');
			$.ajax({
				url : '/SpotRecord/judgementResult.action',
				type : 'post',
				dataType : 'json',
				data : {
					reportId : formData.data[0].report_id,
					status : 1,
					remark : remark
				},
				async : false,
				success : function(result) {
					console.log(result);
					// 墨绿深蓝风

					layer.alert('已拒绝', {
						skin : 'layui-layer-molv' // 样式类名
						,
						closeBtn : 0
					}, function() {
						window.location.href = 'contractAudit.jsp';
					});
				}
			});
		})

	});

}
//格式化Date日期时间数据(yyyy-MM-dd hh:mm:ss)
function timeStamp2String(time) {
	var datetime = new Date();
	datetime.setTime(time);
	var year = datetime.getFullYear();
	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
	var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
	var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
	return year + "-" + month + "-" + date;
}
