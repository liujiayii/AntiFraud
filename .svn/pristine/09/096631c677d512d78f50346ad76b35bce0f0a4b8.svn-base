//激活二级导航
$(document).ready(function() {
	navActive(6);
	secondNavActive('#documentMangement dd', 2)
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
				// 执行重载
				table.reload('testReload', {
					url : '/RecordManageSave/findRecordByRecordId.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						report_id : $('#demoReload').val()
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
		url : '/RecordManageSave/findRecordByRecordId.action',
		type : 'post',
		dataType : 'json',
		data : {
			report_id : report_id
		},
		async : false,
		success : function(result) {
			console.log(result);
			formData = result.data;
		}
	});
	console.log(formData);
}


function documentBorrowingInfo() {
	onLoadPage("report_id");
	//console.log(formData);
	layui.use([ 'form', 'table' ], function() {
		var form = layui.form, table = layui.table;

		// 表单初始赋值

		form.val('example', {
			"report_id" : formData[0].report_id, // "name": "value"
			'status' : formData[0].status,
			'read_time' : formData.read_time,
			'read_name' : formData[0].read_name,
			'return_time' : formData[0].return_time,
			'archivet_location' : formData[0].archivet_location,
			'create_name' : formData[0].create_name
		})
		// 监听提交
		form.on('submit(borrowInfoBtn)', function(data) {
			if (data.field.status == 2) {
				//layerNOPath();
				layerClose("消档请移步档案归档");
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
						layerMsgPath('修改成功', 'documentBorrowing.jsp', '')
					} else if (data.code == 0) {
						layerClose(data.msg)
					} else {
						layerClose(data.msg)
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
