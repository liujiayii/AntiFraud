$(document).ready(function() {
	// 激活二级导航
	$($('#businessFeedback dd')[0]).addClass('layui-this');
	$($('.layui-side .layui-nav-item')[2]).addClass('layui-nav-itemed');
});

function housingEvaluation() {
	layui.use([ 'table' ], function() {
		var table = layui.table;
		// 第一个实例
		table.render({
			id : 'testReload',
			elem : '#realEstateMortgage',
			url : '/HousePropertyMortgage/findHousePropertyMortgage.action',
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
				title : '抵押人姓名'
			}, {
				field : 'phone',
				title : '电话'
			}, {
				field : 'id_number',
				title : '身份证号码'
			},
			/* { field: 'city', title: '房产编号' }, */
			{
				field : 'approval_limit',
				title : '审批额度'
			}, {
				field : 'approval_deadline',
				title : '审批期限'
			}, {
				field : 'purpose_of_loan',
				title : '借款用途'
			}, {
				field : 'status',
				title : '状态',
				templet : function(d) {
					if (d.status == '0') {
						return "<span class='unpass'>已过期</span>"
					} else if (d.status == '1') {
						return "<span class='failed'>未通过</span>"
					} else if (d.status == '2') {
						return "<span class='unpass'>未审核</span>"
					} else if (d.status > 2) {
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
					url : '/HousePropertyMortgage/listAllAndPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : demoReload.val(),
						temp : 'businessFeedback'
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

				window.location.href = "housingEvaluationInfo.jsp?id=" + data.id;

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
		url : '/HousePropertyMortgage/getDetailsById.action',
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

function housingEvaluationInfo() {
	onLoadPage('id');
	
	//console.log(formData);
	layui.use([ 'form' ], function() {
		var form = layui.form;

		// 表单初始赋值
		form.val('example', {
			"entry_number" : formData.data.entry_number, // "name": "value"
			'id': formData.data.id,
			'name': formData.data.name,
			'home_number' : formData.data.home_number,
			'phone': formData.data.phone,
			'id_number': formData.data.id_number,
			'home_number': formData.data.home_number,
			'emergency_name': formData.data.emergency_name,
			'emergency_phone': formData.data.emergency_phone,
			'emergency_id_number': formData.data.emergency_id_number,
			'apply_for_limit': formData.data.apply_for_limit,
			'apply_for_deadline': formData.data.apply_for_deadline,
			'purpose_of_loan': formData.data.purpose_of_loan,
			'approval_limit': formData.data.approval_limit,
			'approval_deadline': formData.data.approval_deadline,
			'payment_type': formData.data.payment_type,
			'gender': formData.data.gender,
			'age': formData.data.age,
			'education': formData.data.education,
			'diploma': formData.data.diploma,
			'home_phone': formData.data.home_phone,
			'business_phone_number': formData.data.business_phone_number,
			'home_address': formData.data.home_address,
			'mailing_address': formData.data.mailing_address,
			'permanent_residence_address': formData.data.permanent_residence_address,
			'email': formData.data.email,
			'spouse_identification_name': formData.data.spouse_identification_name,
			'spousal_work_unit': formData.data.spousal_work_unit,
			'spouse_telephone': formData.data.spouse_telephone,
			'emergency_name': formData.data.emergency_name,
			'emergency_relation': formData.data.emergency_relation,
			'emergency_phone': formData.data.emergency_phone,
			'account_opening_time': formData.data.account_opening_time,
			'marital_status': formData.data.marital_status,
			'spouse_identification_number': formData.data.spouse_identification_number,
			'relative_contact_name': formData.data.relative_contact_name,
			'relative_contact_number': formData.data.relative_contact_number,
			'domestic_relation': formData.data.domestic_relation
			
		})
		// 监听提交
		form.on('submit(formDemo)', function(data) {
			console.log('提交')
			$.post('/HousePropertyMortgage/housePropertyMortgageBusFeedback.action',
					data.field, 
					function(data) {
				console.log(data);
				if (data.code == 1) {
					layer.alert('修改成功', {
						skin : 'layui-layer-molv' // 样式类名
						,
						closeBtn : 0
					}, function() {
						window.location.href = "housingEvaluation.jsp";
					});
				} else {
					console.log('修改失败！');
				}
			});
			console.log(data.field);
			return false;
		});
		// 监听通过
		if (formData.data.status > 2) {
			$(".page-but button").attr('lay-filter', '');
			$($(".page-but button")[0]).click(function() {
				//墨绿深蓝风
				layer.alert('禁止点击', {
				  skin: 'layui-layer-molv' //样式类名
				  ,closeBtn: 0
				}, function(){
					layer.closeAll(); //疯狂模式，关闭所有层
				});
			})	
		}
	});
}
