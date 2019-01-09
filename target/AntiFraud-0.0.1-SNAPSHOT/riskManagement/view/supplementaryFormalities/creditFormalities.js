// 激活二级导航
$(document).ready(function() {
	navActive(3);
	secondNavActive('#supplementaryFormalities dd', 2)
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
				// 执行重载
				table.reload('testReload', {
					url : '/ReplenishProcedureImage/findFiduciaryByPhone.action',
					page : {
						curr : 1
					// 重新从第 1 页开始
					},
					where : {
						phone : $('#demoReload').val()
					},
					done : function() {
					}
				});
			}
		};

		$('#demoReload').on('input', function() {
			var type = $(this).data('type');
			active[type] ? active[type].call(this) : '';
		});
		// 监听行工具事件
		table.on('tool(realEstateMortgage)', function(obj) {
			var data = obj.data;
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
		form.val('example', getFormData())
		form.val('subForm', getSubFormData())
		// 执行一个laydate实例
		laydate.render({
			elem : '#date' // 指定元素
		});
		// 监听submit提交
		form.on('submit(formDemo)', function(data) {
			delete data.field['file'];
			var formJson = JSON.stringify(data.field);
			$.ajax({
				url : '/ReplenishProcedureImage/addAndUpdateReplenishProcedure.action',
				type : 'post',
				dataType : 'json',
				data : formJson,
				contentType : 'application/json',
				success : function(result) {
					// 墨绿深蓝风
					layerMsgPath('修改成功', 'creditFormalities.jsp', '');
				}
			});
			return false; // 阻止表单跳转。如果需要表单跳转，去掉这段即可。
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
			formData = result.data;
			$.ajax({
				url : '/ReplenishProcedureImage/findReplenishProcedureByEntry_number.action',
				type : 'post',
				dataType : 'json',
				data : {
					id : formData.entry_number
				},
				async : false,
				success : function(result) {
					formDataSub = result.data;
				}
			});
		}
	});
}
