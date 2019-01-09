<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>权限管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">
	<div style="position: relative;">
		<input type="text" id="demoReload" name=phone " placeholder="输入电话号码查询" autocomplete="off" class="search-input" data-type="reload"> <i class="layui-icon layui-icon-search"></i> <a href="accessMangementAdd.jsp" class="layui-btn layui-btn-normal layui-btn-sm" style="float: right;">添加</a>
	</div>

	<div style="text-align: center;" class="margin-top-15">
		<table id="realEstateMortgage" lay-filter="realEstateMortgage"></table>
	</div>
</div>
<script src="accessMangement.js"></script>

<script>
	$(document).ready(function() {
		accessMangement();
	})
</script>
<script type="text/html" id="operation">
	<a class="layui-btn layui-btn-xs layui-bg-green" lay-event="modify">权限</a>
    <a class="layui-btn layui-btn-xs layui-bg-green" lay-event="lock">锁定/解锁</a>
	<a class="layui-btn layui-btn-xs layui-bg-green" lay-event="revamp">修改</a>
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>
