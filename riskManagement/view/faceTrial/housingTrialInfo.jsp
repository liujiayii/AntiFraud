<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>实地面审</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15px;">
	<div id="container" style="width:100%; height:80%" ></div>
</div>
<script type="text/javascript" src='//webapi.amap.com/maps?v=1.4.11&key=cd8248e9c427f2b9ec765e83941acdbe'></script>
<!-- UI组件库 1.0 -->
<script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
<script src="housingTrial.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		autoNaviUtil('big-routes.json');
	})
</script>

<%@ include file="/riskManagement/templates/footer.jsp"%>