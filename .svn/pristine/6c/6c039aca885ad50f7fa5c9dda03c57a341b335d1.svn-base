<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>档案管理</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>

<div style="padding: 15px;">
	<div class="breadcrumb">
		<img src="/riskManagement/images/documentMangementInfo.png">
		<div class="word">
			<span class="primary">档案管理</span> <span class="triangle"></span> <span class="secondary">档案添加</span>
		</div>
	</div>
	<form class="layui-form form-main form-main-4" action="" style="margin-top: 15px;">
		<!-- <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" required lay-verify="required"
                       placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div> -->
		<div class="layui-form-item">
			<label class="layui-form-label">报单编号</label>
			<div class="layui-input-inline">
				<input type="text" name="report_id" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
			</div>
		</div>
		<!-- <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-block">
                <input type="text" name="phone" required lay-verify="required"
                       placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
       <div class="layui-form-item">
            <label class="layui-form-label">身份证号</label>
            <div class="layui-input-block">
                <input type="text" name="id_number" required lay-verify="required"
                       placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div> -->
		<!-- <div class="layui-form-item">
            <label class="layui-form-label">存档时间</label>
            <div class="layui-input-block">
                <input type="text" name="cencal_time" required lay-verify="required"
                       placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div> -->
		<div class="layui-form-item">
			<label class="layui-form-label">位置</label>
			<div class="layui-input-inline">
				<input type="text" name="archivet_location" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item btn-item margin-top-50">
			<div class="layui-input-block page-but margin-left-150">
				<button type="button" class="layui-btn confirm-but layui-btn-normal" lay-submit lay-filter="formDemo">确认</button>
				<button type="button" class="layui-btn layui-btn-primary cancel-but" onclick="back()">取消</button>
			</div>
		</div>
	</form>
</div>


<script src="documentFiling.js"></script>

<script>
	$(document).ready(function() {
		documentFilingAdd();
	})
</script>
<%@ include file="/riskManagement/templates/footer.jsp"%>