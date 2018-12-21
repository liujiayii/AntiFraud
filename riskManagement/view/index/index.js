$(document).ready(function() {
	setInterval(function() {
		var mytime = new Date();
		$("#date").html(timeStamp2String(mytime));
	}, 1000)
	var countArr = [];
	var moneyArr = [];
	$.ajax({
		url : '/HousePropertyMortgage/fiduciaryCount.action',
		type : 'post',
		dataType : 'json',
		async : false,
		success : function(result) {
			$('.housing').text(result.count);
			countArr.push(result.count)
		}
	});
	$.ajax({
		url : '/VehicleMortgage/fiduciaryCount.action',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(result) {
			$('.car').text(result.count);
			countArr.push(result.count)
		}
	});
	$.ajax({
		url : '/FiduciaryLoan/fiduciaryCount.action',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(result) {
			$('.credit').text(result.count);
			countArr.push(result.count)
		}
	});
	$.ajax({
		url : '/HousePropertyMortgage/ordersTotal.action',
		type : 'get',
		dataType : 'json',
		success : function(result) {
			$('.all').text(result.count);
		}
	});
	$.ajax({
		url : '/HousePropertyMortgage/houseMoney.action',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(result) {
			$('.housing_money').text(result.data);
			moneyArr.push(result.data);
		}
	});
	$.ajax({
		url : '/VehicleMortgage/vehicleMoney.action',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(result) {
			$('.car_money').text(result.data);
			moneyArr.push(result.data);
		}
	});
	$.ajax({
		url : '/FiduciaryLoan/fiduciaryMoney.action',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(result) {
			$('.credit_money').text(result.data);
			moneyArr.push(result.data);
		}
	});
	
	$.ajax({
		url : '/HousePropertyMortgage/totalMoney.action',
		type : 'get',
		dataType : 'json',
		success : function(result) {
			$('.all_money').text(result.data);
		}
	});
	// 基于准备好的dom，初始化echarts实例
	var myCount = echarts.init(document.getElementById('count'));
	var myMoney = echarts.init(document.getElementById('money'));

	// 指定图表的配置项和数据
	var myCountOption = {
		title : {
			text : '统计贷款总数',
			subtext : '截至目前',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			left : 'left',
			data : [ '统计房贷总数', '统计车贷总数', '统计信贷总数' ]
		},
		series : [ {
			name : '数量',
			type : 'pie',
			radius : '55%',
			center : [ '50%', '60%' ],
			data : [ {
				value : countArr[0],
				name : '统计房贷总数'
			}, {
				value : countArr[1],
				name : '统计车贷总数'
			}, {
				value : countArr[2],
				name : '统计信贷总数'
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};
	var myMoneyOption = {
		title : {
			text : '统计贷款金额',
			subtext : '截至目前',
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			left : 'left',
			data : [ '统计房贷金额', '统计车贷金额', '统计信贷金额' ]
		},
		series : [ {
			name : '金额',
			type : 'pie',
			radius : '55%',
			center : [ '50%', '60%' ],
			data : [ {
				value : moneyArr[0],
				name : '统计房贷金额'
			}, {
				value : moneyArr[1],
				name : '统计车贷金额'
			}, {
				value : moneyArr[2],
				name : '统计信贷金额'
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	}

	// 使用刚指定的配置项和数据显示图表。
	myCount.setOption(myCountOption);
	myMoney.setOption(myMoneyOption);

});

layui.use([ 'table' ], function() {
	var table = layui.table;
	// 第一个实例
	table.render({
		elem : '#realEstateMortgage',
		url : '/Log/showLog.action',
		page : true,
		id : 'testReload',
		even : true,
		skin : 'line', // 行边框风格
		response : {
			statusCode : 1
		// 规定成功的状态码，默认：0
		},
		cols : [ [ // 表头
		{
			field : 'admin',
			title : '操作人'
		}, {
			field : 'operation',
			title : '操作'
		}, {
			field : 'createDate',
			title : '操作时间',
			templet : function(d) {
				return timeStamp2String(d.createDate)
			}
		}] ]
	});	
})