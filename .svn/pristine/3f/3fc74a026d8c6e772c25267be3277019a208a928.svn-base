//激活二级导航
$(document).ready(function() {
	$($('#businessReport dd')[0]).addClass('layui-this');
	$($('.layui-side .layui-nav-item')[0]).addClass('layui-nav-itemed');
});

function housingMortgage() {
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/HousePropertyMortgage/findAll.action',
			page : {
				theme : '#405467'
			},
			id : 'testReload',
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
			even : true,
			skin : 'line', // 行边框风格

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
				field : 'type',
				title : '状态',
				templet : function(d) {
					if (d.type == '0') {
						return "<span class='failed'>已保存</span>"
					} else if (d.type == '1') {
						return "<span class='pass'>已提交</span>"
					} else if (d.type == '2') {
						return "<span class='unpass'>未查看</span>"
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
					url : '/HousePropertyMortgage/listAllAndPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : demoReload.val(),
						temp : "businessReport"
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
				window.location.href = "housingMortgageInfo.jsp?id=" + data.id;
			}
		});

	});

}

function housingMortgageInfo() {
	onLoadPage('id');
	layui.use([ 'form', 'upload', 'layer' ], function() {
		var form = layui.form, upload = layui.upload, layer = layui.layer;

		// 表单初始赋值

		form.val('example', {
			'id' : formData.data.id,
			'name' : formData.data.name,
			'home_number' : formData.data.home_number,
			'age' : formData.data.age,
			'entry_number' : formData.data.entry_number,
			'id_number' : formData.data.id_number,
			'gender' : formData.data.gender,
			'marital_status' : formData.data.marital_status,
			'education' : formData.data.education,
			'diploma' : formData.data.diploma,
			'phone' : formData.data.phone,
			'home_phone' : formData.data.home_phone,
			'business_phone_number' : formData.data.business_phone_number,
			'home_address' : formData.data.home_address,
			'mailing_address' : formData.data.mailing_address,
			'permanent_residence_address' : formData.data.permanent_residence_address,
			'email' : formData.data.email,
			'spouse_identification_name' : formData.data.spouse_identification_name,
			'spouse_identification_number' : formData.data.spouse_identification_number,
			'spousal_work_unit' : formData.data.spousal_work_unit,
			'spouse_telephone' : formData.data.spouse_telephone,
			'relative_contact_name' : formData.data.relative_contact_name,
			'domestic_relation' : formData.data.domestic_relation,
			'relative_contact_number' : formData.data.relative_contact_number,
			'emergency_name' : formData.data.emergency_name,
			'emergency_relation' : formData.data.emergency_relation,
			'emergency_phone' : formData.data.emergency_phone,
			'apply_for_limit' : formData.data.apply_for_limit,
			'apply_for_deadline' : formData.data.apply_for_deadline,
			'account_opening_time' : formData.data.account_opening_time,
			'purpose_of_loan' : formData.data.purpose_of_loan
		})
		// 监听提交
		form.on('submit(sub)', function(data) {
			console.log(JSON.stringify(data.field));
			$.ajax({
				url : '/HousePropertyMortgage/saveAll.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function(result) {
					console.log(result);
				},
				error : function(result) {
					console.log('失败');
				}
			});

			return false;
		});

		form.on('submit(save)', function(data) {
			console.log(JSON.stringify(data.field));
			$.ajax({
				url : '/HousePropertyMortgage/updateById.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function(result) {
					console.log(result);
				},
				error : function(result) {
					console.log('失败');
				}
			});
		});
	})

}
var formData = null;
var formImgUrl = null;
// 页面加载执行
function onLoadPage(name) {
	console.log('aaa');
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
			console.log(result);
			formData = result;
			$.ajax({
				url : '/photo/queryImage.action',
				dataType : 'json',
				data : {
					report_id : formData.data.entry_number
				},
				async : false,
				success : function(result) {
					console.log(result);
					formImgUrl = result;
				}
			});
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
