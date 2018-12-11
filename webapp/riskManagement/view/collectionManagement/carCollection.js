//激活垂直导航栏
$(document).ready(function() {
	$($('#collectionManagement dd')[1]).addClass('layui-this');
	$($('.layui-side .layui-nav-item')[8]).addClass('layui-nav-itemed');
});


function carCollection() {
	layui.use([ 'table'], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url: '/LiquidateManage/findAllVehicle.action',
			page : {
				theme : '#405467'
			},
			id: 'testReload',
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
				title : '姓名'
			}, {
				field : 'phone',
				title : '电话'
			}, {
				field : 'approval_limit',
				title : '贷款金额'
			}, {
				field : 'affirm_time',
				title : '贷款时间',
				templet : function(d) {
					return timeStamp2String(d.affirm_time)
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
					url : '/LiquidateManage/findVehicleByPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : demoReload.val()
					},
					done : function() {
						console.log('完成')
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
			console.log(obj);
			if (obj.event == 'see') {
				window.location.href = "carCollectionInfo.jsp?entry_number="+data.entry_number;
			}
		});

	});
}

function carCollectionInfo() {
	onLoadPage('entry_number');
	console.log(formData);
	layui.use(['form'], function() {
		var form = layui.form;
		// 表单初始赋值

		form.val('example', {
			'entry_number' : formData.data.entry_number,
			'name' : formData.data.name,
			'phone' : formData.data.phone,
			'approval_limit' : formData.data.approval_limit,
			'affirm_time' : timeStamp2String(formData.data.affirm_time),
			'life_of_loan' : timeStamp2String(formData.data.life_of_loan),
			'emergency_phone' : formData.data.emergency_phone,
			'home_address' : formData.data.home_address,
			'remark' : formData.data.remark,
			'relative_contact_number' : formData.data.relative_contact_number
		})	
	});
}

var formData = null;
//页面加载执行
function onLoadPage(name) {
	console.log('aaa');
	var entry_number = getHrefParam(name);
	$.ajax({
		url : '/LiquidateManage/findVehicleByEntry_number.action',
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
//获取地址栏参数，name:参数名称
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

