<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>U盾管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">
	<div style="position: relative;">
		<input type="text" id="demoReload" name="phone" placeholder="输入电话号码查询" autocomplete="off" class="search-input" data-type="reload"> <i class="layui-icon layui-icon-search"></i>
		<a href="ushieldAdministrationAdd.jsp" id="addBtn" class="addBtns layui-btn layui-btn-normal layui-btn-sm" style="float: right;">添加</a>
	</div>
	<div style="text-align: center;" class="margin-top-15">
		<table id="realEstateMortgage" lay-filter="realEstateMortgage"></table>
	</div>
</div>
<script type="text/html" id="operation">
    <a class="layui-btn layui-btn-xs" id="edit" lay-event="edit">锁定 / 解锁</a>
	<a class="layui-btn layui-btn-xs" lay-event="modify">修改</a>
</script>



<script src="ushieldAdministration.js"></script>
<script>
	$(document).ready(function() {
		creditEvaluation();
	})
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>