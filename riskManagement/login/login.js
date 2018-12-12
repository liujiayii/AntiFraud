layui.use([ 'form', 'jquery', 'layer' ], function() { // 如果只加载一个模块，可以不填数组。如：layui.use('form')
	var form = layui.form, // 获取form模块
	$ = layui.jquery, // 获取jQuery模块
	layer = layui.layer;

	// 提交按钮
	form.on('submit(sub)', function(data) {
		console.log(data.elem) // 被执行事件的元素DOM对象，一般为button对象
		console.log(data.form) // 被执行提交的form对象，一般在存在form标签时才会返回
		console.log(data.field) // 当前容器的全部表单字段，名值对形式：{name: value}

		$.ajax({
			url : 'loginUser.action',
			type : 'post',
			dataType : 'json',
			data : data.field,
			success : function(result) {
				console.log(result);
				if (result.code == 1 && result.status == 1) {
					window.location.href = "riskManagement/view/index/index.jsp";
				} else if (result.status == 2) {
					layer.msg('账号已经锁定');
				} else {
					layer.msg('用户名或密码错误');
				}
			}
		})
		return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。

	})

})

// 回车键绑定 function keyLogin() {

function keyboardEvent(event) {
	var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;// 解决浏览器之间的差异问题
	if (keyCode == 13) {
		document.getElementById('login').click();
	}
}