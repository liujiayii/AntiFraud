<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="icon" href="<%=basePath%>/riskManagement/login/images/login.jpg" type="image/x-icon" />
<link rel="stylesheet" href="<%=basePath%>/riskManagement/lib/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>/riskManagement/style/page.css">
<script src="<%=basePath%>/riskManagement/lib/jquery.min.js"></script>
<script src="<%=basePath%>/riskManagement/lib/layui/layui.js"></script>
<script src="<%=basePath%>/riskManagement/templates/utils.js"></script>
<script type="text/javascript">
	if (navigator.appName == 'Microsoft Internet Explorer') {
		if (navigator.userAgent.indexOf("MSIE 5.0") > 0 || navigator.userAgent.indexOf("MSIE 6.0") > 0 || navigator.userAgent.indexOf("MSIE 7.0") > 0) {
			alert('您使用的 IE 浏览器版本过低, 推荐使用 Chrome 浏览器或 IE8 及以上版本浏览器.');
		}
	}
</script>

</head>

<body class="layui-layout-body">
	<script type="text/javascript">
		
	</script>
	<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
	<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header layui-bg-gray">
			<div class="layui-logo layui-bg-theme">
				<a href="/riskManagement/view/index/index.jsp" style="color: rgba(255, 255, 255, .7);"> <img src="<%=basePath%>/riskManagement/images/logo.png" style="margin-right: 10px;" />风控反欺诈系统
				</a>
			</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item" lay-unselect><a href="javascript:;" style="color: black;"> <img src="/riskManagement/images/head.jpg" class="layui-nav-img">${user.name}
				</a></li>
				<li class="layui-nav-item" lay-unselect><a href="<%=basePath%>/logout.action"> <img src="<%=basePath%>/riskManagement/images/close.png"></a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-theme">
			<div class="layui-side-scroll">
				<div class="layui-nav-itemed user">
					<img src="/riskManagement/images/head.jpg" class="layui-nav-img"> <span class="userName">欢迎，${user.name}</span>
				</div>
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree layui-bg-theme" lay-filter="test" lay-shrink="all">
					<li class="layui-nav-item" id="businessReport"><a class="" href="javascript:;"><img src="<%=basePath%>/riskManagement/images/businessReport.png" class="menu-ioc">业务报单</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/businessReport/housingMortgage.jsp"> <img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">房屋抵押
								</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/businessReport/carMortgage.jsp"> <img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">车辆抵押
								</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/businessReport/creditMortgage.jsp"> <img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">信用贷款
								</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="assetEvaluation"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/assetEvaluation.png" class="menu-ioc">资产评估</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/assetEvaluation/housingEvaluation.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">房屋评估</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/assetEvaluation/carEvaluation.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">车辆评估</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/assetEvaluation/creditEvaluation.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">信用评估</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="businessFeedback"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/businessFeedback.png" class="menu-ioc">业务反馈</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/businessFeedback/housingEvaluation.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">房屋抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/businessFeedback/carEvaluation.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">车辆抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/businessFeedback/creditEvaluation.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">信用贷款</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="supplementaryFormalities"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/supplementaryFormalities.png" class="menu-ioc">补充手续</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/supplementaryFormalities/housingFormalities.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">房屋抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/supplementaryFormalities/carFormalities.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">车辆抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/supplementaryFormalities/creditFormalities.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">信用贷款</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="faceTrial"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/faceTrial.png" class="menu-ioc"></i>面审实地</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/faceTrial/housingTrial.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">房屋抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/faceTrial/carTrial.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">车辆抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/faceTrial/creditTrial.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">信用贷款</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="printingContract"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/printingContract.png" class="menu-ioc">打印合同</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/printingContract/housingPrintingContract.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">房屋抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/printingContract/carPrintingContract.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">车辆抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/printingContract/creditPrintingContract.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">信用贷款</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/printingContract/uploadContract.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">上传合同</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="documentMangement"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/documentMangement.png" class="menu-ioc">档案管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/documentMangement/contractAudit.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">合同审核</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/documentMangement/documentFiling.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">档案归档</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/documentMangement/documentBorrowing.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">档案借阅</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="superscriptManagement"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/superscriptManagement.png" class="menu-ioc">上标管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/superscriptManagement/superscriptManagement.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">上标管理</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="managementAfterLoan"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/managementAfterLoan.png" class="menu-ioc">贷后管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/managementAfterLoan/managementAfterLoan.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">贷后管理</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="collectionManagement"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/collectionManagement.png" class="menu-ioc">清收管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/collectionManagement/housingCollection.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">房屋抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/collectionManagement/carCollection.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">车辆抵押</a>
							</dd>
							<dd>
								<a href="/riskManagement/view/collectionManagement/creditCollection.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">信用贷款</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item" id="accessMangement"><a href="javascript:;"><img src="<%=basePath%>/riskManagement/images/accessMangement.png" class="menu-ioc">权限管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/riskManagement/view/accessMangement/accessMangement.jsp"><img src="<%=basePath%>/riskManagement/images/circular.png" class="circular">权限管理</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 40px;">