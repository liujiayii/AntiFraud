// 激活二级导航
$(document).ready(function() {
	navActive(7);
	secondNavActive('#managementAfterLoan dd', 0)
});

function managementAfterLoan() {
	layui.use([ 'table' ], function() {
		var table = layui.table;

		// 第一个实例
		table.render({
			id : 'testReload',
			elem : '#realEstateMortgage',
			url : '/AcceptController/Accept.action',
			page : {
				theme : '#405467'
			},
			even : true,
			skin : 'line', // 行边框风格
			response : {
				statusCode : 1
			// 规定成功的状态码，默认：0
			},
			cols : [ [ // 表头

			{
				field : 'bidId',
				title : '标号 bisiid'
			}, {
				field : 'entry_number',
				title : '报单编号'
			}, {
				field : 'realName',
				title : '姓名'
			}, {
				field : 'mobile',
				title : '电话'
			}, {
				field : 'period',
				title : '当前期数'
			}, {
				field : 'total_period',
				title : '总期数'
			}, {
				field : 'amount',
				title : '还款金额'
			}, {
				field : 'status',
				title : '是否逾期',
				templet : function(d) {
					if (d.is_overdue == '0') {
						return "<span class='pass'>未逾期</span>"
					} else if (d.is_overdue == '1') {
						return "<span class='failed'>已逾期</span>"
					}
				}
			}, {
				field : 'repayment_time',
				title : '还款时间',
				templet : function(d) {
					return timeStamp2String(d.repayment_time);
				}
			} ] ]
		});

		/*// 电话搜索

		var active = {
			reload : function() {
				var demoReload = $('#demoReload');
				console.log('重载');
				console.log(demoReload.val())
				// 执行重载
				table.reload('testReload', {
					url : '',
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
		});*/
	})

}
