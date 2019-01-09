//激活垂直导航栏
$(document).ready(function() {
	navActive(1);
	secondNavActive('#assetEvaluation dd', 1)
});

function carEvaluation() {
	layui.use([ 'table' ], function() {
		var table = layui.table;

		// 第一个实例
		table.render({
			id : 'testReload',
			elem : '#realEstateMortgage',
			url : '/VehicleMortgage/findAllVehicleMortgage.action',
			page : {
				theme : '#405467'
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
				field : 'status',
				title : '状态',
				templet : function(d) {
					if (d.status == '1') {
						return "<span class='failed'>未通过</span>"
					} else if (d.status == '0') {
						return "<span class='pass'>已作废</span>"
					} else if (d.status == null) {
						return "<span class='unpass'>未审核</span>"
					} else {
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
				var demoReload = $('#demoReload');
				console.log('重载');
				console.log(demoReload.val())
				// 执行重载
				table.reload('testReload', {
					url : '/VehicleMortgage/findAllAndPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : demoReload.val(),
						temp : "assetEvaluation"
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
			console.log(data.status);
			if (data.status == 1) {
				window.location.href = "carEvaluationFail.jsp?id=" + data.id;
			} else {
				window.location.href = "carEvaluationInfo.jsp?id=" + data.id;
			}
		});

	});

}

var formData = null;
var formImgUrl = null;
// 页面加载执行
function onLoadPage(name) {
	console.log('aaa');
	var id = getHrefParam(name);
	$.ajax({
		url : '/VehicleMortgage/selectIdVehicleMortgage.action',
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
function carEvaluationInfo() {
	// 页面加载执行

	onLoadPage("id");
	console.log(formData);
	layui.use([ 'form' ], function() {
		var form = layui.form;

		// 表单初始赋值
		form.val('example', {
			'id' : formData.data.id,
			'name' : formData.data.name,
			'licence_plate' : formData.data.licence_plate,
			'status' : formData.data.status,
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
		// 表单初始赋值
		form.val('sub', {
			'id' : formData.data.id,
			'entry_number' : formData.data.entry_number
		})

		// 监听提交
		form.on('submit(suc)', function(data) {
			data.field['status'] = 2;
			console.log(data.field);
			console.log('通过');

			$.ajax({
				url : '/VehicleMortgage/ResultVehicleMortgage.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function(result) {
					// 墨绿深蓝风

					layer.alert('已通过', {
						skin : 'layui-layer-molv' // 样式类名
						,
						closeBtn : 0
					}, function() {
						window.location.href = "carEvaluation.jsp"
					});
				}
			});
			return false;
		});

		form.on('submit(fail)', function(data) {
			// 墨绿深蓝风
			layer.alert('请填写备注', {
				skin : 'layui-layer-molv' // 样式类名
				,
				closeBtn : 0
			}, function() {
				window.location.href = "carEvaluationFail.jsp?id=" + formData.data.id;
			});
			return false;

		});
		// 监听通过
		if (formData.data.status > 1) {
			$(".page-but button").attr('lay-filter', '');
			$(".page-but button").click(function() {
				// 墨绿深蓝风
				layer.alert('禁止点击', {
					skin : 'layui-layer-molv' // 样式类名
					,
					closeBtn : 0
				}, function() {
					layer.closeAll(); // 疯狂模式，关闭所有层
				});
			})
		}
	})
}

function carEvaluationFail() {
	// 页面加载执行
	onLoadPage("id");
	layui.use([ 'form' ], function() {
		var form = layui.form;
		// 表单初始赋值
		form.val('example', {// "name": "value"
			'id' : formData.data.id,
			'remark' : formData.data.remark,
			'status' : formData.data.status
		})
		// 监听通过
		if (formData.data.status === 1) {
			$(".page-but button").attr('lay-filter', '');
			$(".page-but button").click(function() {
				// 墨绿深蓝风
				layer.alert('禁止点击', {
					skin : 'layui-layer-molv' // 样式类名
					,
					closeBtn : 0
				}, function() {
					layer.closeAll(); // 疯狂模式，关闭所有层
				});
			})
		}
		// 表单验证
		form.verify({
			wordlimit : [ /^.{20,2000}$/, '请输入20到2000位汉字' ]
		});
		// 监听提交
		form.on('submit(Failform)', function(data) {
			console.log(data.field);
			data.field['status'] = 1;
			$.ajax({
				url : '/VehicleMortgage/ResultVehicleMortgage.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function(result) {
					console.log(result);
					// 墨绿深蓝风

					layer.alert('已拒绝', {
						skin : 'layui-layer-molv' // 样式类名
						,
						closeBtn : 0
					}, function() {
						window.location.href = "carEvaluation.jsp"
					});
				}
			});

			return false;
		});

	})

}
