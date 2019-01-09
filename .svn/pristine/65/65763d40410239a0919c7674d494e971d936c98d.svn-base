//激活二级导航
$(document).ready(function() {
	$($('#documentMangement dd')[2]).addClass('layui-this');
	$($('.layui-side .layui-nav-item')[5]).addClass('layui-nav-itemed');
});


function documentBorrowing() {
	layui.use([ 'table' ], function() {
		var table = layui.table;

		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/RecordManageBorrow/findRecordBorrowList.action',
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
			parseData : function(res) { // res 即为原始返回的数据
				return {
					"code" : res.code, // 解析接口状态
					"msg" : res.msg, // 解析提示文本
					"count" : res.count, // 解析数据长度
					"data" : res.data
				// 解析数据列表
				};
			},
			cols : [ [ // 表头
			{
				field : 'report_id',
				title : '报单编号'
			}, {
				field : 'archivet_location',
				title : '位置'
			}, {
				field : 'archivet_time',
				title : '存档时间',
				templet : function(d) {
					return timeStamp2String(d.archivet_time);
				}
			}, {
				field : 'cencal_time',
				title : '消档时间',
				templet : function(d) {
					if (isNaN(d.cencal_time)) {
						return d.cencal_time = "无";
					}
					return timeStamp2String(d.cencal_time);
				}
			}, {
				field : 'business_type',
				title : '业务类型',
				templet : function(d) {
					if (d.business_type == 0) {
						return "<span class='wait'>房产抵押</span>";
					} else if (d.business_type == 1) {
						return "<span class='failed'>车辆抵押</span>";
					} else if (d.business_type == 2) {
						return "<span class='pass'>信用借贷</span>";
					}
				}
			}, {
				field : 'status',
				title : '状态',
				templet : function(d) {
					if (d.status == '0') {
						return "<span class='pass'>正常</span>"
					} else if (d.status == '1') {
						return "<span class='failed'>借出</span>"
					} else if (d.status == '2') {
						return "<span class='unpass'>消档</span>"
					}
				}
			}, {
				field : 'operation',
				title : '操作',
				toolbar : '#operation'
			}, ] ]
		});

		// 通过报单编号搜索
		var active = {
			reload : function() {
				var demoReload = $('#demoReload');
				// 执行重载
				table.reload('testReload', {
					url : '/RecordManageSave/findRecordByRecordId.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						report_id : demoReload.val()
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
				window.location.href = "documentBorrowingInfo.jsp?id=" + data.id + "&report_id=" + data.report_id;
			}
		});

	});
}

// 详情页面加载执行
var formData = null;

function onLoadPage(name) {
	console.log('aaa');
	var report_id = getHrefParam(name);
	$.ajax({    
		//url : '/RecordManageBorrow/getRecordLastByReportId.action',
		url : '/RecordManageSave/findRecordByRecordId.action',
		type : 'post',
		dataType : 'json',
		data : {
			report_id : report_id
		},
		async : false,
		success : function(result) {
			console.log(result);
			formData = result;
		}
	});
	//console.log(formData);
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

function documentBorrowingInfo() {
	onLoadPage("report_id");
	//console.log(formData);
	layui.use([ 'form', 'table' ], function() {
		var form = layui.form, table = layui.table;

		// 表单初始赋值

		form.val('example', {
			"report_id" : formData.data[0].report_id, // "name": "value"
			'status' : formData.data[0].status,
			'read_time' : formData.data.read_time,
			'read_name' : formData.data[0].read_name,
			'return_time' : formData.data.return_time,
			'archivet_location' : formData.data.archivet_location,
			'create_name' : formData.data.create_name
		})
		// 监听提交
		form.on('submit(borrowInfoBtn)', function(data) {
			// layer.msg(JSON.stringify(data.field));
			/*if (data.field.status == 0) {
				layer.msg('如需返回，请点取消');
				return;
			}
			if (data.field.status == 1) {
				layer.msg('当前档案处于消档状态，不能执行修改操作！');
				return;
			}*/
			if (data.field.status == 2) {
				layer.msg('当前档案处于消档状态，不能执行修改操作！');
				return;
			}
			
			$.ajax({
				url : '/RecordManageBorrow/addRecordBorrow.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function(data) {
					console.log(data);
					if (data.code == 1) {
						// 墨绿深蓝风

						layer.alert('修改成功', {
							skin : 'layui-layer-molv' // 样式类名
							,
							closeBtn : 0
						}, function() {
							window.location.href = "documentBorrowing.jsp"
						});

					} else if (data.code == 0) {
						layer.msg('无效的操作');
					} else {
						layer.msg(data.msg);
					}

				}
			});
			return false;
		});

		// 第一个实例
		table.render({
			elem : '#realEstateMortgageInfo',
			url : '/RecordManageBorrow/findRecordBorrow.action',
			page : {
				theme : '#405467'
			},
			where : {
				report_id : getHrefParam("report_id")
			},
			even : true,
			skin : 'line', // 行边框风格
			response : {
				statusCode : 1
			// 规定成功的状态码，默认：0
			},
			cols : [ [ // 表头
			{
				field : 'create_name',
				title : '操作人'
			}, {
				field : 'status',
				title : '操作类型',
				templet : function(d) {
					if (d.status == 0) {
						return "<span class='pass'>归还</span>";
					} else if (d.status == 1) {
						return "<span class='failed'>借出</span>";
					} else if (d.status == 2) {
						return "<span class='unpass'>消档</span>";
					}
				}
			}, {
				field : 'read_name',
				title : '借阅人'
			}, {
				field : 'read_time',
				title : '借阅时间',
				templet : function(d) {
					if (isNaN(d.read_time)) {
						return d.read_time = "无";
					}
					return timeStamp2String(d.read_time);
				}
			}, {
				field : 'return_time',
				title : '归还时间',
				templet : function(d) {
					if (isNaN(d.return_time)) {
						return d.return_time = "无";
					}
					return timeStamp2String(d.return_time);
				}
			}, ] ]
		});

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
	return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
}
