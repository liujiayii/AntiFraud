<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>档案管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>

<div style="padding: 15px;">
	<div class="breadcrumb">
		<img src="/riskManagement/images/documentMangementInfo.png">
		<div class="word">
			<span class="primary">档案管理</span> <span class="triangle"></span> <span class="secondary">档案查看</span>
		</div>
	</div>
	<form class="layui-form form-main form-main-4" action="" style="margin-top: 35px;" lay-verify="example" lay-filter="example">
		<input type="hidden" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">档案状态</label>
			<div class="layui-input-inline">
				<select name="status" lay-verify="required">
					<option value=""></option>
					<option value="0">正常</option>
					<option value="1">借出</option>
					<option value="2">消档</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-inline">
				<input type="text" name="name" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">报单编号</label>
			<div class="layui-input-inline">
				<input type="text" name="report_id" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-inline">
				<input type="text" name="phone" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">存档时间</label>
			<div class="layui-input-inline">
				<input type="text" name="archivet_time" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">消档时间</label>
			<div class="layui-input-inline">
				<input type="text" name="cencal_time" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">位置</label>
			<div class="layui-input-inline">
				<input type="text" name="archivet_location" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item btn-item margin-top-50">
			<div class="layui-input-block page-but margin-left-150">
				<button type="button" class="layui-btn confirm-but layui-btn-normal" lay-submit lay-filter="update1">确认</button>
				<button type="button" class="layui-btn layui-btn-primary cancel-but" onclick="back()">取消</button>
			</div>
		</div>
	</form>
</div>

<script src="documentFiling.js"></script>

<script>
	$(document).ready(function() {
		documentFilingInfo();
	})
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>