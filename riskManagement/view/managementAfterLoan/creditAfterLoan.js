$(document).ready(function() {
	// 激活二级导航
	$($('#managementAfterLoan dd')[2]).addClass('layui-this');
	$($('.layui-side .layui-nav-item')[7]).addClass('layui-nav-itemed');

});
	

function creditAfterLoan() {
	layui.use([ 'table' ], function() {
		var table = layui.table;

		// 第一个实例
		table.render({
			id : 'testReload',
			elem : '#realEstateMortgage',
			url : '/PostLoanManage/findAllFiduciary.action',
			page : {
				theme : '#405467'
			},

			request : {
				pageName : 'page',
				limitName : 'limit'
			},
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
				field : 'entry_number',
				title : '报单编号'
			}, {
				field : 'name',
				title : '姓名'
			}, {
				field : 'phone',
				title : '电话'
			}, {
				field : 'approval_limit',
				title : '贷款金额'
			}, {
				field : 'approval_deadline',
				title : '贷款时间'
			}, {
				field : 'status',
				title : '是否逾期',
				templet : function(d) {
					if (d.is_overdue == '1') {
						return "<span class='pass'>未逾期</span>"
					} else if (d.is_overdue == '0') {
						return "<span class='failed'>已逾期</span>"
					}
				}
			},{
				field : 'status',
				title : '状态',
				templet : function(d) {
					if (d.status < '10') {
						return "<span class='unpass'>未上标</span>"
					} else if (d.status == '10') {
						return "<span class='unpass'>未回访</span>"
					} else if (d.status == '11') {
						return "<span class='pass'>已回访</span>"
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
				var demoReload = $('#demoReload');
				console.log('重载');
				console.log(demoReload.val())
				// 执行重载
				table.reload('testReload', {
					url : '/PostLoanManage/findFiduciaryByPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : demoReload.val()
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
			// console.log(data);
			if (obj.event == 'see') {
				window.location.href = "creditAfterLoanInfo.jsp?entry_number=" + data.entry_number;
			}
		});
	})

}

function creditAfterLoanInfo() {
	onLoadPage("entry_number");
	console.log(formData);
	layui.use([ 'form', 'laydate' ], function() {
		var form = layui.form, laydate = layui.laydate;
		// 执行一个laydate实例
		laydate.render({
			elem : '#date' // 指定元素
		});

		// 表单初始赋值

		form.val('example', {
			"entry_number" : formData.data.entry_number, // "name": "value"
			'id' : formData.data.id,
			'visit_time' : formData.data.visit_time,
			'visit_content' : formData.data.visit_content,
			'visit_name' : formData.data.visit_name,
			'intention_analysis': formData.data.intention_analysis,
			'is_overdue': formData.data.is_overdue
		})
		// 监听提交
		form.on('submit(formDemo)', function(data) {
			$.ajax({
				url : '/PostLoanManage/addAndUpdatePostLoanManage.action',
				type : 'post',
				dataType : 'json',
				data : {
					postLoanManage : data.field
				},
				success : function(result) {
					console.log(result);
					// 墨绿深蓝风

					layer.alert('提交成功', {
						skin : 'layui-layer-molv' // 样式类名
						,
						closeBtn : 0
					}, function() {
						window.location.href = 'creditAfterLoan.jsp'
					});
				}
			})
			console.log(data.field);
			return false;
		});

	});
}

var formData = null;
//页面加载执行
function onLoadPage(name) {
	console.log('aaa');
	var entry_number = getHrefParam(name);
	$.ajax({
		url : '/PostLoanManage/findPostLoanManageByRecordId.action',
		type : 'post',
		dataType : 'json',
		data : {
			id : entry_number
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
