layui.use([ 'table', 'form', 'layer' ], function() {
	var table = layui.table, form = layui.form, layer = layui.layer;
	// 设定全局默认参数。options即各项基础参数（此配置目前有bug，是layui的bug）
	table.set({
		id : 'testReload',
		page : {
			theme : '#405467'
		},
		even : true,
		skin : 'line', // 行边框风格
		response : {
			statusCode : 1
		}
	// 规定成功的状态码，默认：0
	})
	// 设定表单验证正则表达式
	form.verify({
		wordlimit : [ /^.{20,2000}$/, '请输入20到2000位汉字' ],
		address : [ /^[0-9][0-9]{5}$/, '请输入正确的邮编' ],
		rate : [ /^([1-9]|1[0-9]|20)([.]([0-9]){1,2})?$/, '1%~20%' ],
		username : function(value, item) { // value：表单的值、item：表单的DOM对象
			if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
				return '用户名不能有特殊字符';
			}
			if (/(^\_)|(\__)|(\_+$)/.test(value)) {
				return '用户名首尾不能出现下划线\'_\'';
			}
			if (/^\d+\d+\d$/.test(value)) {
				return '用户名不能全为数字';
			}
		}

		// 我们既支持上述函数式的方式，也支持下述数组的形式
		// 数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
		,
		password : [ /^[\S]{8,12}$/, '密码必须8到12位，且不能出现空格' ]
	});

	// 业务报单、资产评估、业务反馈图片layer
	layer.photos({
		photos : '#layer-photos-demo',
		anim : 0,// 0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
		area : 'auto',
		maxWidth : 800,
		tab : function(pic, layero) {
			$('#layui-layer-photos').css('height', 'auto');
			$('.layui-layer-photos').css('top', '');
		}
	});
});
//业务报单、资产评估、业务反馈图片
function businessImgLayer(formImgUrl) {
	var loc = window.location.href;
	if(loc.match('EvaluationInfo') || loc.match('MortgageInfo')){
		if (formImgUrl.data.length === 0) {
			$('.imgList').append($($('.imgBox')[0]).clone());
			$($('.imgBox img')[0]).attr('src', '../../images/nodata.png');
		} else {
			for (var i = 0; i < formImgUrl.data.length; i++) {
				$('.imgList').append($($('.imgBox')[0]).clone());
				$($('.imgBox img')[i]).attr('src', formImgUrl.data[i].img_url);
			}
		}
	}
	
}
// 垂直导航激活
function navActive(index) {
	$($('.layui-side .layui-nav-item')[index]).addClass('layui-nav-itemed');
}
// 二级导航激活
function secondNavActive(path, index) {
	$($(path)[index]).addClass('layui-this');
}
// 返回
function back() {
	window.history.back();
	return false;
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
// 格式化Date日期时间数据(yyyy-MM-dd hh:mm:ss)
function timeStamp2String(time) {
	var datetime = new Date(time);
	var year = datetime.getFullYear();
	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	return year + "-" + month + "-" + date;
}
// 表单验证提示方式
$(document).ready(function() {
	$('input').attr('lay-vertype', 'alert');
	$('select').attr('lay-vertype', 'alert');
	$('textarea').attr('lay-vertype', 'alert');
})
// 表单赋值对象
function getFormData(formData) {// 业务信息表
	var obj = {
		id : formData.id,
		home_number : formData.home_number,
		name : formData.name,
		age : formData.age,
		licence_plate : formData.licence_plate,
		status : formData.status,
		entry_number : formData.entry_number,
		id_number : formData.id_number,
		gender : formData.gender,
		marital_status : formData.marital_status,
		education : formData.education,
		diploma : formData.diploma,
		phone : formData.phone,
		home_phone : formData.home_phone,
		business_phone_number : formData.business_phone_number,
		home_address : formData.home_address,
		mailing_address : formData.mailing_address,
		permanent_residence_address : formData.permanent_residence_address,
		email : formData.email,
		spouse_identification_name : formData.spouse_identification_name,
		spouse_identification_number : formData.spouse_identification_number,
		spousal_work_unit : formData.spousal_work_unit,
		spouse_telephone : formData.spouse_telephone,
		relative_contact_name : formData.relative_contact_name,
		domestic_relation : formData.domestic_relation,
		relative_contact_number : formData.relative_contact_number,
		emergency_name : formData.emergency_name,
		emergency_relation : formData.emergency_relation,
		emergency_phone : formData.emergency_phone,
		apply_for_limit : formData.apply_for_limit,
		apply_for_deadline : formData.apply_for_deadline,
		account_opening_time : formData.account_opening_time,
		purpose_of_loan : formData.purpose_of_loan,
		remark: formData.remark,
		status : formData.status,
		approval_amount : formData.approval_amount,
	}
	return obj;
}
function getSubFormData(formDataSub) {// 补充手续表
	var obj = {
		id : formDataSub.id,
		entry_number : formDataSub.entry_number,
		occupational : formDataSub.occupational,
		company_name : formDataSub.company_name,
		industry_of_the_company : formDataSub.industry_of_the_company,
		company_address : formDataSub.company_address,
		company_mail : formDataSub.company_mail,
		starting_work : formDataSub.starting_work,
		duty : formDataSub.duty,
		professional_title : formDataSub.professional_title,
		annual_income : formDataSub.annual_income,
		service_rate : formDataSub.service_rate,
		residential_condition : formDataSub.residential_condition,
		period_of_resident : formDataSub.period_of_resident,
		facetime : timeStamp2String(formDataSub.facetime),
		talk_place : formDataSub.talk_place,
		purpose_of_loan : formDataSub.purpose_of_loan,
		approval_limit : formDataSub.approval_limit,
		approval_deadline : formDataSub.approval_deadline,
		business_type : formDataSub.business_type,
		borrowing_species : formDataSub.borrowing_species,
		reward : formDataSub.reward,
		money_collecting_time : formDataSub.money_collecting_time,
		ource_of_revenue : formDataSub.ource_of_revenue,
		repayment : formDataSub.repayment,
		housing_situation : formDataSub.housing_situation,
		car_situation : formDataSub.car_situation,
		other_assets : formDataSub.other_assets,
		guaranty_style : formDataSub.guaranty_style,
		credit : formDataSub.credit,
		name_of_sponsor : formDataSub.name_of_sponsor,
		margin_trade : formDataSub.margin_trade,
		pledge_type : formDataSub.pledge_type,
		belong_to_oneself_for_webpage : formDataSub.belong_to_oneself_for_webpage,
		assess_price : formDataSub.assess_price,
		life_of_loan : formDataSub.life_of_loan,
		throw_industry : formDataSub.throw_industry,
		bor_type : formDataSub.bor_type,
		site : formDataSub.site,
		annual_interest_rate : formDataSub.annual_interest_rate,
		whether_the_loan_for_webpage : formDataSub.whether_the_loan_for_webpage,
		observant_party : formDataSub.observant_party,
		branch_office : formDataSub.branch_office,
		reception_personnel : formDataSub.reception_personnel,
		nowaddress : formDataSub.nowaddress,
		line_of_credit : formDataSub.line_of_credit,
		liabilities_of_bank : formDataSub.liabilities_of_bank,
		liabilities_of_folk : formDataSub.liabilities_of_folk,
		loan_documentation : formDataSub.loan_documentation,
		home_address : formDataSub.home_address,
		monthly_profit : formDataSub.monthly_profit,
		spouse_monthly_profit : formDataSub.spouse_monthly_profit,
		borrowing_that : formDataSub.borrowing_that,
		survey_and_opinion : formDataSub.survey_and_opinion,
		risk_control_opinion : formDataSub.risk_control_opinion,
		home_annual_income : formDataSub.home_annual_income,
		payment_type : formDataSub.payment_type
	}
	return obj;
}
function getDocumentFormData(formData) {//档案管理表
	var obj = {
			report_id : formData.report_id,
			entry_number : formData.entry_number,
			status : formData.status,
			read_name : formData.read_name,
			return_time : formData.return_time,
			archivet_location : formData.archivet_location,
			create_name: formData.create_name,
			id : formData.id,
			name : formData.name,
			phone : formData.phone,
			archivet_time : timeStamp2String(formData.archivet_time),
			cencal_time : isNaN(formData.cencal_time)?'无':timeStamp2String(formData.cencal_time)
	}
	return obj;
}
function getCollectionFormData(formData) {// 请收管理表
	var obj = {
		entry_number : formData.entry_number,
		name : formData.name,
		phone : formData.phone,
		approval_limit : formData.approval_limit,
		affirm_time : timeStamp2String(formData.affirm_time),
		life_of_loan : timeStamp2String(formData.life_of_loan),
		emergency_phone : formData.emergency_phone,
		home_address : formData.home_address,
		remark : formData.remark,
		relative_contact_number : formData.relative_contact_number
	}
	return obj
}
// 弹窗加跳页面
function layerMsgPath(msg, path, id) {
	layer.alert(msg, {
		skin : 'layui-layer-molv' // 样式类名
		,
		closeBtn : 0
	}, function() {
		window.location.href = path + id
	});
}
// 弹窗不跳页面
function layerClose(msg) {
	layer.alert(msg, {
		skin : 'layui-layer-molv' // 样式类名
		,
		closeBtn : 0
	}, function() {
		layer.closeAll();
	});
}
// 禁止点击
function layerNOPath() {
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
// 高德地图轨迹图API
function autoNaviUtil(autoNaviUtilPath) {
	// 创建地图
	var map = new AMap.Map('container', {
		zoom : 4
	});

	AMapUI.load([ 'ui/misc/PathSimplifier', 'lib/$' ], function(PathSimplifier, $) {

		if (!PathSimplifier.supportCanvas) {
			alert('当前环境不支持 Canvas！');
			return;
		}

		// just some colors
		var colors = [ "#3366cc", "#dc3912", "#ff9900", "#109618", "#990099", "#0099c6", "#dd4477", "#66aa00", "#b82e2e", "#316395", "#994499", "#22aa99", "#aaaa11", "#6633cc",
				"#e67300", "#8b0707", "#651067", "#329262", "#5574a6", "#3b3eac" ];

		var pathSimplifierIns = new PathSimplifier({
			zIndex : 100,
			// autoSetFitView:false,
			map : map, // 所属的地图实例

			getPath : function(pathData, pathIndex) {

				return pathData.path;
			},
			getHoverTitle : function(pathData, pathIndex, pointIndex) {

				if (pointIndex >= 0) {
					// point
					return pathData.name + '，点：' + pointIndex + '/' + pathData.path.length;
				}

				return pathData.name + '，点数量' + pathData.path.length;
			},
			renderOptions : {
				pathLineStyle : {
					dirArrowStyle : true
				},
				getPathStyle : function(pathItem, zoom) {

					var color = colors[pathItem.pathIndex % colors.length], lineWidth = Math.round(4 * Math.pow(1.1, zoom - 3));

					return {
						pathLineStyle : {
							strokeStyle : color,
							lineWidth : lineWidth
						},
						pathLineSelectedStyle : {
							lineWidth : lineWidth + 2
						},
						pathNavigatorStyle : {
							fillStyle : color
						}
					};
				}
			}
		});

		window.pathSimplifierIns = pathSimplifierIns;

		$('<div id="loadingTip">加载数据，请稍候...</div>').appendTo(document.body);

		$.getJSON(autoNaviUtilPath, function(d) {
			$('#loadingTip').remove();
			var position = [];
			for (var i = 0; i < d.location.length; i++) {
				var a = d.location[i].substring(1, (d.location[i].length - 1));
				position[i] = a.split(',');
			}
			pathSimplifierIns.setData([ {
				name : '轨迹',
				path : position
			} ]);

			// initRoutesContainer(d);

			function onload() {
				pathSimplifierIns.renderLater();
			}

			function onerror(e) {
				alert('图片加载失败！');
			}

			// 创建一个巡航器
			var navg1 = pathSimplifierIns.createPathNavigator(0, {
				loop : true,
				speed : 3000,
				pathNavigatorStyle : {
					width : 16,
					height : 32,
					content : PathSimplifier.Render.Canvas.getImageContent('../../images/car.png', onload, onerror),
					strokeStyle : null,
					fillStyle : null
				}
			});

			navg1.start();
		});
	});
}
