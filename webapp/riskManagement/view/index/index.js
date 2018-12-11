$(document).ready(function() {
	setInterval(function() {
		var mytime = new Date();
		var y = mytime.getFullYear();
		var m = mytime.getMonth();
		m = m < 10 ? '0' + m : m;
		var d = mytime.getDate();
		d = d < 10 ? '0' + d : d;
		var h = mytime.getHours();
		h = h < 10 ? '0' + h : h;
		var mm = mytime.getMinutes();
		mm = mm < 10 ? '0' + mm : mm;
		var s = mytime.getSeconds();
		s = s < 10 ? '0' + s : s;
		var time = y + "-" + m + "-" + d + "  " + h + ":" + mm + ":" + s;
		$("#date").html(time);
	}, 1000)
	var countArr = [];
	var moneyArr = [];
	$.ajax({
		url : '/HousePropertyMortgage/fiduciaryCount.action',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(result) {
			console.log(result);
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
			console.log(result);
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
			console.log(result);
			$('.credit').text(result.count);
			countArr.push(result.count)
		}
	});
	$.ajax({
		url : '/HousePropertyMortgage/ordersTotal.action',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(result) {
			console.log(result);
			$('.all').text(result.count);
		}
	});
	$.ajax({
		url : '/HousePropertyMortgage/houseMoney.action',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(result) {
			console.log(result);
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
			console.log(result);
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
			console.log(result);
			$('.credit_money').text(result.data);
			moneyArr.push(result.data);
		}
	});
	
	$.ajax({
		url : '/HousePropertyMortgage/totalMoney.action',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(result) {
			console.log(result);
			$('.all_money').text(result.data);
		}
	});
	console.log(countArr);
	console.log(moneyArr);
	// 基于准备好的dom，初始化echarts实例
	var myCount = echarts.init(document.getElementById('count'));
	var myMoney = echarts.init(document.getElementById('money'));

	// 指定图表的配置项和数据
	var myCountOption = {
		title : {
			text : '统计贷款总数',
			subtext : '纯属虚构',
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
			subtext : '纯属虚构',
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