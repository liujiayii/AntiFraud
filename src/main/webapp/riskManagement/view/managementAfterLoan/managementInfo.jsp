<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>贷后管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">

<div style="text-align: center;" class="margin-top-15">
	<table id="realEstateMortgage" lay-filter="realEstateMortgage"></table>
</div>
</div>
<script src="managementAfterLoan.js"></script>
<script>
	$(document).ready(function() {
		managementInfo();
	})
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>