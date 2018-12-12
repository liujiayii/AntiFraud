<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>清收管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">
	<div class="breadcrumb">
		<img src="/riskManagement/images/blueBag.png">
		<div class="word">
			<span class="primary">清收管理</span> <span class="triangle"></span> <span class="secondary">车辆抵押</span>
		</div>
	</div>
	<form class="layui-form form-main form-main-4" lay-filter="example">
		<div class="layui-form-item">
			<label class="layui-form-label">报单编号</label>
			<div class="layui-input-inline">
				<input type="text" name="entry_number" autocomplete="off" class="layui-input" disabled value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">抵押人姓名</label>
			<div class="layui-input-inline">
				<input type="text" name="name" autocomplete="off" class="layui-input" disabled value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-inline">
				<input type="text" name="phone" autocomplete="off" class="layui-input" disabled value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">贷款金额</label>
			<div class="layui-input-inline">
				<input type="text" name="approval_limit" autocomplete="off" class="layui-input" disabled value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">贷款日期</label>
			<div class="layui-input-inline">
				<input type="text" name="affirm_time" autocomplete="off" class="layui-input" disabled value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">还款期限</label>
			<div class="layui-input-inline">
				<input type="text" name="life_of_loan" autocomplete="off" class="layui-input" disabled value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">亲属电话</label>
			<div class="layui-input-inline">
				<input type="text" name="relative_contact_number" autocomplete="off" class="layui-input" disabled value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">紧急联系人电话</label>
			<div class="layui-input-inline">
				<input type="text" name="emergency_phone" autocomplete="off" class="layui-input" disabled value="">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">常住地址</label>
			<div class="layui-input-inline">
				<input type="text" name="home_address" autocomplete="off" class="layui-input" disabled required lay-verify="required" value="">
			</div>
		</div>

		<div class="layui-form-item remark-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-inline">
				<textarea name="remark" autocomplete="off" class="layui-input" disabled></textarea>
			</div>
		</div>

		<div class="layui-form-item btn-item margin-top-50">
			<div class="layui-input-block page-but margin-left-150">
				<button type="button" class="layui-btn layui-btn-primary confirm-but" onclick="back()">返回</button>
			</div>
		</div>


	</form>
</div>
<script src="carCollection.js"></script>
<script>
	$(document).ready(function() {
		carCollectionInfo();
	})
</script>

<%@ include file="/riskManagement/templates/footer.jsp"%>