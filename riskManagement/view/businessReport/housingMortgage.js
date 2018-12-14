//激活二级导航
$(document).ready(function() {
	navActive(0);
	secondNavActive('#businessReport dd', 0)
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
				// 执行重载
				table.reload('testReload', {
					url : '/HousePropertyMortgage/listAllAndPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : $('#demoReload').val(),
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
	layui.use([ 'form'], function() {
		var form = layui.form;

		// 表单初始赋值
		form.val('example', getFormData())
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
			formData = result.data;
			$.ajax({
				url : '/photo/queryImage.action',
				dataType : 'json',
				data : {
					report_id : formData.entry_number
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