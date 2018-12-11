<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>贷后管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>

<div style="padding: 15px;" class="">
	<div class="breadcrumb">
		<img src="/riskManagement/images/managementAfterLoan.png">
		<div class="word">
			<span class="primary">贷后管理</span> <span class="triangle"></span> <span class="secondary">详情</span>
		</div>

	</div>
	<form class="layui-form form-main" action="" lay-filter="example">
		<input type="hidden" name="id" /> <input type="hidden" name="report_id" />
		<div class="layui-form-item">
			<label class="layui-form-label">回访时间</label>
			<div class="layui-input-inline">
				<input type="text" class="layui-input" autocomplete="off" name="visit_time" id='date'>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">回访人</label>
			<div class="layui-input-inline">
				<div class="layui-input-inline">
					<select name="visit_name" lay-verify="">
						<option value="">请选择</option>
						<option value="1">风控人员</option>
						<option value="0">风控人员</option>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">回访内容</label>
			<div class="layui-input-inline">
				<textarea name="visit_content" autocomplete="off" class="layui-input"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">还款意向</label>
			<div class="layui-input-inline">
				<textarea name="visit_content" autocomplete="off" class="layui-input"></textarea>
			</div>
		</div>
		<div class="layui-form-item btn-item margin-top-50">
			<div class="layui-input-block page-but margin-left-150">
				<button type="button" class="layui-btn confirm-but layui-btn-normal" lay-submit lay-filter="formDemo">确定</button>
				<button type="button" class="layui-btn layui-btn-primary cancel-but" onclick="back()">取消</button>
			</div>
		</div>

	</form>
</div>

<script src="creditAfterLoan.js"></script>
<script>
	$(document).ready(function() {
		creditAfterLoanInfo();
	})
</script>

<%@ include file="/riskManagement/templates/footer.jsp"%>