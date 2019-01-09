<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>档案管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">
	<div class="breadcrumb">
		<img src="/riskManagement/images/documentMangementInfo.png">
		<div class="word">
			<span class="primary">档案管理</span> <span class="triangle"></span> <span class="secondary">档案借阅</span>
		</div>
	</div>
	<form class="layui-form form-main form-main-4" action="" style="margin-top: 15px;" lay-filter="example">
		<input type="hidden" name="archivet_location">
		<div class="layui-form-item">
			<label class="layui-form-label">报单编号</label>
			<div class="layui-input-inline">
				<input type="text" name="report_id" required lay-verify="required" readonly="readonly" autocomplete="off" class="layui-input">
			</div>
		</div>
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
			<label class="layui-form-label">借阅人员</label>
			<div class="layui-input-inline">
				<input type="text" name="read_name" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
			</div>
		</div>
		<!-- <div class="layui-form-item">
            <label class="layui-form-label">借出时间</label>
            <div class="layui-input-block">
                <input type="text" name="read_time" class="layui-input" id="document-mangement-date">
            </div>
        </div> -->
		<!-- <div class="layui-form-item">
			<label class="layui-form-label">借出人员</label>
			<div class="layui-input-inline">
				<input type="text" name="create_name" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
			</div>
		</div> -->

		<div class="layui-form-item btn-item margin-top-50">
			<div class="layui-input-block page-but margin-left-150">
				<button type="button" class="layui-btn confirm-but layui-btn-normal" lay-submit lay-filter="borrowInfoBtn">确认</button>
				<button type="button" class="layui-btn layui-btn-primary cancel-but" onclick="back()">取消</button>
			</div>
		</div>

	</form>

	<div class="breadcrumb margin-top-50">
		<img src="/riskManagement/images/documentMangementInfo.png">
		<div class="word">
			<span class="primary">档案管理</span> <span class="triangle"></span> <span class="secondary">档案日志</span>
		</div>
	</div>

	<div style="text-align: center; margin-top: 20px;">
		<table id="realEstateMortgageInfo" lay-filter="realEstateMortgage"></table>
	</div>
</div>

<script src="documentBorrowing.js"></script>
<script>
	$(document).ready(function() {
		documentBorrowingInfo();
	})
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>