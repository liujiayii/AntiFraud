<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>权限管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>

<div style="padding: 15px;">
	<div class="breadcrumb">
		<img src="/riskManagement/images/accessControl.png">
		<div class="word">
			<span class="primary">权限管理</span> <span class="triangle"></span> <span class="secondary">添加</span>
		</div>
	</div>

	<form class="layui-form form-main form-main-4" action="" style="margin-top: 20px;">
		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-inline">
				<input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">职位</label>
			<div class="layui-input-inline">
				<select name="p_id" lay-verify="required">
					<option value="">请选择</option>
					<option value="2001">业务员</option>
					<option value="2002">风控主管</option>
					<option value="2003">房屋评估师</option>
					<option value="2004">车辆评估师</option>
					<option value="2005">信用评估师</option>
					<option value="2006">档案人员</option>
					<option value="2007">风控内勤人员</option>
					<option value="2008">风控外勤人员</option>
					<option value="2000">超级管理员</option>
					<option value="2009">业务主管</option>
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
				<input type="text" name="user_name" lay-verify="required|username" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="password" name="user_pwd" lay-verify="required" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">确认密码</label>
			<div class="layui-input-inline">
				<input type="password" name="user_pwd_verify" lay-verify="required" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item btn-item margin-top-50">
			<div class="layui-input-block page-but margin-left-150">
				<button type="button" class="layui-btn confirm-but layui-btn-normal" lay-submit lay-filter="accessAdd">确认</button>
				<button type="button" class="layui-btn layui-btn-primary cancel-but" onclick="back()">取消</button>
			</div>
		</div>
	</form>
</div>

<script src="accessMangement.js"></script>

<script>
	$(document).ready(function() {
		accessMangementAdd();
	})
</script>

<%@ include file="/riskManagement/templates/footer.jsp"%>