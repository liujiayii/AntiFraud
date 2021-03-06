<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>权限管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>

<div style="padding: 15px;">
	<div class="breadcrumb">
		<img src="/riskManagement/images/accessControl.png">
		<div class="word">
			<span class="primary">权限管理</span> <span class="triangle"></span> <span class="secondary">修改</span>
		</div>
	</div>

	<form class="layui-form form-main form-main-4" action="" style="margin-top: 20px;" lay-filter="example">
		<input type="hidden" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-inline">
				<input type="text" name="name" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">职位</label>
			<div class="layui-input-inline">
				<select name="post" lay-verify="required">
					<option value="">请选择</option>
					<option value="业务员">业务员</option>
					<option value="风控主管">风控主管</option>
					<option value="房屋评估师">房屋评估师</option>
					<option value="车辆评估师">车辆评估师</option>
					<option value="信用评估师">信用评估师</option>
					<option value="档案人员">档案人员</option>
					<option value="风控内勤人员">风控内勤人员</option>
					<option value="风控外勤人员">风控外勤人员</option>
					<option value="超级管理员">超级管理员</option>
					<option value="业务主管">业务主管</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-inline">
				<input type="text" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地区</label>
			<div class="layui-input-inline">
				<select name="address" lay-verify="required">
					<option value="">请选择</option>
					<option value="石家庄">石家庄</option>
					<option value="保定分公司">保定分公司</option>
					<option value="衡水分公司">衡水分公司</option>
					<option value="陕西省宝鸡市分公司">陕西省宝鸡市分公司</option>
					<option value="陕西省西安分公司">陕西省西安分公司</option>
					<option value="宁夏银川分公司">宁夏银川分公司</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">账号</label>
			<div class="layui-input-inline">
				<input type="text" name="user_name" class="layui-input" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="password" name="user_pwd" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-inline">
				<input type="password" name="user_pwd_verify" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item btn-item margin-top-50">
			<div class="layui-input-block page-but margin-left-150">
				<button type="button" class="layui-btn confirm-but layui-btn-normal" lay-submit lay-filter="accessRevamp">确认</button>
				<button type="button" class="layui-btn layui-btn-primary cancel-but" onclick="back()">取消</button>
			</div>
		</div>
	</form>
</div>

<script src="accessMangement.js"></script>

<script>
	$(document).ready(function() {
		accessMangementRevamp();
	})
</script>

<%@ include file="/riskManagement/templates/footer.jsp"%>