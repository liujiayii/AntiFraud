<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>贷后管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">
	<div style="position: relative; display: flex; justify-content: space-between;">
		<input type="text" id="demoReload" name="phone" placeholder="输入电话号码查询" autocomplete="off" class="search-input" data-type="reload"> <i class="layui-icon layui-icon-search"></i>
		<form class="layui-form uploadContract" lay-filter="example">
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<select name="" lay-filter="upload">
						<option value="">请选择</option>
						<option value="0">未逾期</option>
						<option value="1">已逾期</option>
						<option value="2">查看全部</option>
					</select>
				</div>
			</div>
		</form>
	</div>
	<div style="text-align: center;" class="margin-top-15">
		<table id="realEstateMortgage" lay-filter="realEstateMortgage"></table>
	</div>
</div>

<script src="managementAfterLoan.js"></script>
<script>
	$(document).ready(function() {
		managementAfterLoan();
	})
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>


