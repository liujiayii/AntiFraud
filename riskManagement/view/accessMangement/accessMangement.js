// 激活垂直导航栏
$(document).ready(function() {
	$($('.layui-side .layui-nav-item')[9]).addClass('layui-nav-itemed');
	$($('#accessMangement dd')[0]).addClass('layui-this');

});
function accessMangement() {
	layui.use([ 'table' ], function() {

		var table = layui.table;

		// 第一个实例
		table.render({
			elem : '#realEstateMortgage',
			url : '/user/findAllUser.action',
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
				field : 'name',
				title : '姓名'
			}, {
				field : 'phone',
				title : '电话'
			}, {
				field : 'post',
				title : '职位'
			}, {
				field : 'status',
				title : '状态',
				templet : function(d) {
					if (d.status == '1') {
						return "<span class='pass'>正常</span>"
					} else if (d.status == '2') {
						return "<span class='failed'>锁定</span>"
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
					url : '/user/findUserByPhone.action',
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
		function changeStatus(id, status) {
			console.log('a')
			console.log(id, status)
			$.ajax({
				url : '/user/updateUserStatus.action',
				type : 'post',
				dataType : 'text',
				data : {
					id : id,
					status : status
				},
				success : function() {
					console.log('b')
				}
			})

		}

		table.on('tool(realEstateMortgage)', function(obj) {
			var data = obj.data;
			var url = '';

			if (obj.event == 'lock') {
				console.log(data.status);
				if (data.status === 1) {
					changeStatus(data.id, data.status);
					obj.update({
						status : 2
					});

				} else if (data.status === 2) {
					console.log(data.status);
					changeStatus(data.id, data.status);
					obj.update({
						status : 1
					});
				}
			}

			if (obj.event == 'modify') {
				window.location.href = 'accessControl.jsp?id=' + data.id;
			}

		});

	});
}

function accessControl() {
	onLoadPage("id");
	layui.use([ 'form', 'layer' ], function() {
		var form = layui.form, layer = layui.layer;

		// 监听提交

		function changeAccess(id, accessArr) {
			console.log('a')
			$.ajax({
				url : '/popedom/updatePopedom.action',
				type : 'post',
				data : {
					id : id,
					'popedoms' : accessArr
				},
				traditional : true, // 如果要传数组，这行一定要加！用传统的方式来序列化数据
				success : function() {
					console.log(accessArr)
				}
			})

		}

		form.on('submit(control)', function(data) {
			console.log(data.field) // 当前容器的全部表单字段，名值对形式：{name: value}

			// 将Object的属性输出成Array
			function objOfPropertyToArr(object) {
				var arr = [];
				var i = 0;
				for ( var item in object) {
					arr[i] = item;
					i++;
				}
				return arr;
			}

			// 获取地址栏参数，name:参数名称
			function getUrlParms(name) {
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
				var r = window.location.search.substr(1).match(reg);
				if (r != null)
					return unescape(r[2]);
				return null;
			}

			var id = getUrlParms("id");
			console.log(id);
			var arr = objOfPropertyToArr(data.field); // 输出["", ""]
			var accessArr = [];

			for (var i = 0; i < arr.length; i++) {
				accessArr.push(arr[i].substring(3, 7));
			}

			changeAccess(id, accessArr);
			console.log(arr);
			console.log(accessArr);
			// 墨绿深蓝风

			layer.alert('修改成功', {
				skin : 'layui-layer-molv' // 样式类名
				,
				closeBtn : 0
			}, function() {
				window.location.href = 'accessMangement.jsp'
			});
			return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});

	})
}
var formData = {}
//延迟赋值
function formVal() {
	layui.use([ 'form'], function() {
		var form = layui.form;
		// 表单初始赋值
		console.log('赋值');
		form.val("formTest", formData)
		console.log('延迟赋值');
	})
}
// 页面加载执行
function onLoadPage(name) {
	var id = getHrefParam(name);
	$.post('/popedom/popedomList.action', {
		id : id
	}, function(result) {
		console.log(result);
		console.log('复现');
		for (var n = 0; n < result.data.length; n++) {
			formData['pid' + result.data[n].pid] = true
		}
		console.log(formData)
		formVal();
	})
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

function accessMangementAdd() {
	layui.use([ 'form' ], function() {
		var form = layui.form;

		// 监听提交

		form.on('submit(accessAdd)', function(data) {

			console.log(data.field) // 当前容器的全部表单字段，名值对形式：{name: value}

			console.log('a')
			$.ajax({
				url : '/user/insertUser.action',
				type : 'post',
				dataType : 'json',
				data : data.field,
				success : function() {
					console.log('成功')
					// 墨绿深蓝风

					layer.alert('添加成功', {
						skin : 'layui-layer-molv' // 样式类名
						,
						closeBtn : 0
					}, function() {
						window.location.href = "accessMangement.jsp"
					});

				}
			})

			return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
		})
		// 表单验证
		form.verify({
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
	})
}