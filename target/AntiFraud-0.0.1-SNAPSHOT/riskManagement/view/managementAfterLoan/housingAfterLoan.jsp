<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>贷后管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">
	<div style="position: relative;">
		<input type="text" id="demoReload" name=phone " placeholder="输入电话号码查询" autocomplete="off" class="search-input" data-type="reload"> <i class="layui-icon layui-icon-search"></i>
	</div>
	<div style="text-align: center;" class="margin-top-15">
		<table id="realEstateMortgage" lay-filter="realEstateMortgage"></table>
	</div>
</div>

<script src="housingAfterLoan.js"></script>
<script>
	$(document).ready(function() {
		housingAfterLoan();
	})
</script>
<script type="text/html" id="operation">
    <a class="layui-btn layui-btn-xs" lay-event="see">查看</a>
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>


