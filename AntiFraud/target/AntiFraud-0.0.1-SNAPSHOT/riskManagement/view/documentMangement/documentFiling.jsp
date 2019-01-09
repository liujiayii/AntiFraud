<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>档案管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">
	<div style="position: relative;">
		<input type="text" id="demoReload" name=report_id " placeholder="输入报单编号查询" autocomplete="off" class="search-input" data-type="reload"> <i class="layui-icon layui-icon-search"></i> <a href="documentFilingAdd.jsp" class="layui-btn layui-btn-normal layui-btn-sm" style="float: right;">添加</a>
	</div>

	<div style="text-align: center;" class="margin-top-15">
		<table id="realEstateMortgage" lay-filter="realEstateMortgage"></table>
	</div>
</div>

<script src="documentFiling.js"></script>
<script>
	$(document).ready(function() {
		documentFiling();
	})
</script>
<script type="text/html" id="operation">
    <a class="layui-btn layui-btn-xs" lay-event="see">查看</a>
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>