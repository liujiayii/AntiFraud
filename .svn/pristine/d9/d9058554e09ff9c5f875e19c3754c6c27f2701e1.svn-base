<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>资产评估</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>

<div style="padding: 15px;">

	<div class="breadcrumb">
		<img src="/riskManagement/images/assetEvaluationInfo.png">
		<div class="word">
			<span class="primary">资产评估</span> <span class="triangle"></span> <span class="secondary">房屋评估</span>
		</div>
	</div>
	<form class="layui-form form-main" action="" style="margin-top: 25px;" lay-filter="example">
		<input type="hidden" name="id"> <input type="hidden" name="status">
		<div class="layui-form-item remark-item">
			<label class="layui-form-label">备注</label>
			<div class="layui-input-inline">
				<textarea name="remark" autocomplete="off" class="layui-input" lay-verify="wordlimit"></textarea>
			</div>
		</div>
		<div class="layui-form-item btn-item margin-top-50">
			<div class="layui-input-block page-but margin-left-150">
				<button type="button" class="layui-btn confirm-but layui-btn-normal" lay-submit lay-filter="Failform">确认</button>
				<button type="button" class="layui-btn layui-btn-primary cancel-but" onclick="back()">取消</button>
			</div>
		</div>

	</form>
</div>



<script src="housingEvaluation.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		housingEvaluationFail();
	})
</script>

<%@ include file="/riskManagement/templates/footer.jsp"%>