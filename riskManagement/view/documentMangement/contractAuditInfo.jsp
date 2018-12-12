<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>打印合同</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">
	<div class="breadcrumb">
		<img src="/riskManagement/images/blueBag.png">
		<div class="word">
			<span class="primary">合同审核</span> <span class="triangle"></span> <span class="secondary">详情</span>
		</div>
	</div>
	<form class="layui-form form-main form-main-4" action="" lay-filter="example">
		<fieldset class="layui-elem-field layui-field-title">
			<legend>借款人身份信息</legend>
		</fieldset>
		<div class="layui-form-item">
			<label class="layui-form-label">报单编号</label>
			<div class="layui-input-inline">
				<input type="text" name="report_id" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">合同编号</label>
			<div class="layui-input-inline">
				<input type="text" name="contract_id" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">业务员id</label>
			<div class="layui-input-inline">
				<input type="text" name="user_id" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">创建时间</label>
			<div class="layui-input-inline">
				<input type="text" name="create_time" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">修改时间</label>
			<div class="layui-input-inline">
				<input type="text" name="update_time" autocomplete="off" class="layui-input" disabled>

			</div>
		</div>

		<div class="layui-form-item remark-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-inline">
				<textarea name="remark" autocomplete="off" class="layui-input"></textarea>
			</div>
		</div>
		<fieldset class="layui-elem-field layui-field-title">
			<legend>合同</legend>
		</fieldset>

		<div class="imgList layui-clear layer-photos-demo" id="layer-photos-demo"></div>
	</form>
	<form class="layui-form form-main form-main-4" action="" lay-filter="sub">
		<div class="layui-form-item btn-item margin-top-50">
			<div class="layui-input-block page-but margin-left-150">
				<button type="button" class="layui-btn confirm-but layui-btn-normal" lay-submit lay-filter="suc">通过</button>
				<button type="button" class="layui-btn layui-btn-primary cancel-but" lay-submit lay-filter="fail">拒绝</button>
			</div>
		</div>


	</form>
</div>
<script src="contractAudit.js"></script>

<script>
	$(document).ready(function() {
		contractAuditInfo();
		for (var i = 0; i < formData.data.length; i++) {
			console.log(i)
			$('.imgList').append($($('.imgBox')[0]).clone());
			$($('.imgBox img')[i]).attr('src', formData.data[i].img_url);			
		}		
	})
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>