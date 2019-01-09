// 激活二级导航
$(document).ready(function() {
	navActive(6);
	secondNavActive('#documentMangement dd', 1)
});


function documentFiling() {
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/RecordManageSave/findRecordSaveList.action',
			page : {
				theme : '#405467'
			},
			id : 'testReload',
			even : true,
			response : {
				statusCode : 1
			// 规定成功的状态码，默认：0
			},
			skin : 'line', // 行边框风格
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
			console.log(obj);
			if (obj.event == 'see') {
				window.location.href = "documentFilingInfo.jsp?report_id=" + data.report_id;
			}
		});

	});
}
// 详情页面加载执行

var formData = null;

function onLoadPage(name) {
	
	var report_id = getHrefParam(name);
	console.log(report_id);
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
}


function documentFilingAdd() {
	onLoadPage("report_id");
	layui.use([ 'form' ], function() {
		var form = layui.form;

		// 表单初始赋值

		form.val('example', {
			"entry_number" : formData.entry_number, // "name": "value"
			'archivet_location' : formData.archivet_location,
		})
		// 监听提交
		form.on('submit(formDemo)', function(data) {
			console.log(data.field);
			$.ajax({
				url : '/RecordManageSave/addRecord.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function(data) {
					console.log(data);
					if (data.code == 1) {
						layerMsgPath('修改成功', 'documentFiling.jsp', '')
					} else {
						console.log('修改失败！');
					}
				}
			})
			return false;
		});

	});
}

function documentFilingInfo() {
	onLoadPage("report_id");
	layui.use([ 'form' ], function() {
		var form = layui.form;
		// 表单初始赋值
		form.val('example', {
			'id' : formData[0].id,
			'name' : formData[0].name,		// "name": "value"
			'status' : formData[0].status,		
			'report_id' : formData[0].report_id,
			'phone' : formData[0].phone,
			'archivet_time' : timeStamp2String(formData[0].archivet_time),
			'cencal_time' : isNaN(formData[0].cencal_time)?'无':timeStamp2String(formData[0].cencal_time),
			'archivet_location' : formData[0].archivet_location
		});

		// 修改档案提交事件监听
		form.on('submit(update1)', function(data) {
			console.log(data);
			$.ajax({
				url : '/RecordManageSave/updateRecordById.action',
				type : 'post',
				dataType : 'json',
				data : {
					id : data.field.id,
					report_id : data.field.report_id,
					status : data.field.status,
					archivet_location : data.field.archivet_location
				},
				success : function(data) {
					console.log(data);
					if (data.code == 1) {
						// 墨绿深蓝风
						layerMsgPath('修改成功', 'documentFiling.jsp', '')

					} else if (data.code == 0) {
						layer.msg('请选择要修改的内容！');
					} else {
						console.log('修改失败！');
					}

				}
			});
			return false;

		});

	})
}
