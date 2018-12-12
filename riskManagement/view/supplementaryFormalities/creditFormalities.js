// 激活二级导航
$(document).ready(function() {
	$($('#supplementaryFormalities dd')[2]).addClass('layui-this');
	$($('.layui-side .layui-nav-item')[3]).addClass('layui-nav-itemed');
});

function creditFormalities() {
	layui.use([ 'table' ], function() {
		var table = layui.table;

		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/ReplenishProcedureImage/findAllFiduciary.action',
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
			id : 'testReload',
			response : {
				statusCode : 1
			// 规定成功的状态码，默认：0
			},
			cols : [ [ // 表头
			{
				field : 'name',
				title : '抵押人姓名'
			}, {
				field : 'entry_number',
				title : '报单编号'
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
				title : '审批额度'
			}, {
				field : 'apply_for_deadline',
				title : '审批期限'
			}, {
				field : 'creater',
				title : '创建人'
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
					url : '/ReplenishProcedureImage/findFiduciaryByPhone.action',
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
				window.location.href = "creditFormalitiesInfo.jsp?id=" + data.id;
			}
		});

	});

}

function creditFormalitiesInfo() {
	onLoadPage('id');
	layui.use([ 'upload', 'form', 'laydate' ], function() {
		var form = layui.form, upload = layui.upload, laydate = layui.laydate;

		// 表单初始赋值

		form.val('example', {
			'id' : formData.data.id,
			'name' : formData.data.name,
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
			'account_opening_time' : formData.data.account_opening_time
		})
		form.val('subForm', {
			'id' : formData.data.id,
			'entry_number' : formData.data.entry_number,
			'occupational' : formDataSub.data.occupational,
			'company_name' : formDataSub.data.company_name,
			'industry_of_the_company' : formDataSub.data.industry_of_the_company,
			'company_address' : formDataSub.data.company_address,
			'company_mail' : formDataSub.data.company_mail,
			'starting_work' : formDataSub.data.starting_work,
			'duty' : formDataSub.data.duty,
			'professional_title' : formDataSub.data.professional_title,
			'annual_income' : formDataSub.data.annual_income,
			'service_rate' : formDataSub.data.service_rate,
			'residential_condition' : formDataSub.data.residential_condition,
			'period_of_resident' : formDataSub.data.period_of_resident,
			'facetime' : timeStamp2String(formDataSub.data.facetime),
			'talk_place' : formDataSub.data.talk_place,
			'purpose_of_loan' : formDataSub.data.purpose_of_loan,
			'approval_limit' : formDataSub.data.approval_limit,
			'approval_deadline' : formDataSub.data.approval_deadline,
			'business_type' : formData.data.business_type,
			'borrowing_species' : formDataSub.data.borrowing_species,
			'reward' : formDataSub.data.reward,
			'money_collecting_time' : formDataSub.data.money_collecting_time,
			'ource_of_revenue' : formDataSub.data.ource_of_revenue,
			'repayment' : formDataSub.data.repayment,
			'throw_industry' : formDataSub.data.throw_industry,
			'bor_type' : formDataSub.data.bor_type,
			'site' : formDataSub.data.site,
			'housing_situation' : formDataSub.data.housing_situation,
			'car_situation' : formDataSub.data.car_situation,
			'other_assets' : formDataSub.data.other_assets,
			'guaranty_style' : formDataSub.data.guaranty_style,
			'credit' : formDataSub.data.credit,
			'name_of_sponsor' : formDataSub.data.name_of_sponsor,
			'margin_trade' : formDataSub.data.margin_trade,
			'pledge_type' : formDataSub.data.pledge_type,
			'belong_to_oneself_for_webpage' : formDataSub.data.belong_to_oneself_for_webpage,
			'assess_price' : formDataSub.data.assess_price,
			'life_of_loan' : formDataSub.data.life_of_loan,
			'annual_interest_rate' : formDataSub.data.annual_interest_rate,
			'whether_the_loan_for_webpage' : formDataSub.data.whether_the_loan_for_webpage,
			'observant_party' : formDataSub.data.observant_party,
			'branch_office' : formDataSub.data.branch_office,
			'reception_personnel' : formDataSub.data.reception_personnel,
			'nowaddress' : formDataSub.data.nowaddress,
			'line_of_credit' : formDataSub.data.line_of_credit,
			'liabilities_of_bank' : formDataSub.data.liabilities_of_bank,
			'liabilities_of_folk' : formDataSub.data.liabilities_of_folk,
			'loan_documentation' : formDataSub.data.loan_documentation,
			'home_address' : formDataSub.data.home_address,
			'monthly_profit' : formDataSub.data.monthly_profit,
			'spouse_monthly_profit' : formDataSub.data.spouse_monthly_profit,
			'borrowing_that' : formDataSub.data.borrowing_that,
			'survey_and_opinion' : formDataSub.data.survey_and_opinion,
			'risk_control_opinion' : formDataSub.data.risk_control_opinion,
			'home_annual_income' : formDataSub.data.home_annual_income,
			'payment_type' : formDataSub.data.payment_type
		})

		// 执行一个laydate实例
		laydate.render({
			elem : '#date' // 指定元素
		});
		// 监听submit提交
		form.on('submit(formDemo)', function(data) {
			console.log(data.elem) // 被执行事件的元素DOM对象，一般为button对象
			console.log(data.form) // 被执行提交的form对象，一般在存在form标签时才会返回
			console.log(data.field) // 当前容器的全部表单字段，名值对形式：{name: value}
			delete data.field['file'];
			var formJson = JSON.stringify(data.field);
			$.ajax({
				url : '/ReplenishProcedureImage/addAndUpdateReplenishProcedure.action',
				type : 'post',
				dataType : 'json',
				data : formJson,
				contentType : 'application/json',
				success : function(result) {
					console.log(result);
					// 墨绿深蓝风

					layer.alert('修改成功', {
						skin : 'layui-layer-molv' // 样式类名
						,
						closeBtn : 0
					}, function() {
						window.location.href = "creditFormalities.jsp"
					});
				}
			});
			return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
		// 表单验证
		form.verify({
			wordlimit : [ /^.{20,2000}$/, '请输入20到2000位汉字' ],
			address : [ /^[0-9][0-9]{5}$/, '请输入正确的邮编' ],
			rate : [ /^([1-9]|1[0-9]|20)([.]([0-9]){1,2})?$/, '1%~20%' ]
		});
		// 多文件列表示例
		var demoListView = $('#demoList'), uploadListIns = upload.render({
			elem : '#testList',
			url : '/ReplenishProcedureImage/filesUpload.action',
			accept : 'file',
			multiple : true,
			auto : false,
			bindAction : '',
			data : {
				id : function() {
					return $("[name='entry_number']").val();
				}
			},
			choose : function(obj) {
				var files = this.files = obj.pushFile(); // 将每次选择的文件追加到文件队列
				// 读取本地文件
				obj.preview(function(index, file, result) {
					var tr = $([ '<tr id="upload-' + index + '">', '<td>' + '<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img">' + '</td>',
							'<td>' + (file.size / 1014).toFixed(1) + 'kb</td>', '<td>等待上传</td>', '<td>',
							'<button type="button" class="layui-btn layui-btn-xs demo-reload btn">上传</button>',
							'<button type="button" class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>', '</td>', '</tr>' ].join(''));

					// 单个重传
					tr.find('.btn').on('click', function() {
						obj.upload(index, file);
						return false;
					});

					// 删除
					tr.find('.demo-delete').on('click', function() {
						delete files[index]; // 删除对应的文件
						tr.remove();
						uploadListIns.config.elem.next()[0].value = ''; // 清空
						// input
						// file
						// 值，以免删除后出现同名文件不可选
					});

					demoListView.append(tr);
				});
			},
			done : function(res, index, upload) {
				console.log(res);
				if (res.code == 1) { // 上传成功
					var tr = demoListView.find('tr#upload-' + index), tds = tr.children();
					tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
					tds.eq(3).html(''); // 清空操作
					return delete this.files[index]; // 删除文件队列已经上传成功的文件
				}
				this.error(index, upload);
			},
			error : function(index, upload) {
				var tr = demoListView.find('tr#upload-' + index), tds = tr.children();
				tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
				//tds.eq(3).find('.demo-reload').removeClass('layui-hide'); // 显示重传
			}
		});
	});
}

// 页面加载执行
var formData = null;
var formDataSub = null;
function onLoadPage(name) {
	console.log('aaa');
	var id = getHrefParam(name);
	$.ajax({
		url : '/ReplenishProcedure/showInfoByFiduciaryId.action',
		type : 'post',
		dataType : 'json',
		data : {
			id : id
		},
		async : false,
		success : function(result) {
			console.log(result);
			formData = result;
			var entry_number = formData.data.entry_number;
			console.log(entry_number);
			$.ajax({
				url : '/ReplenishProcedureImage/findReplenishProcedureByEntry_number.action',
				type : 'post',
				dataType : 'json',
				data : {
					id : entry_number
				},
				async : false,
				success : function(result) {
					console.log(result);
					formDataSub = result;
					console.log(formDataSub)
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
