<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<title>打印合同</title>

<%@ include file="/riskManagement/templates/headerMenu.jsp"%>
<div style="padding: 15 px;" class="printing-contract">
	<div class="breadcrumb">
		<img src="/riskManagement/images/blueBag.png">
		<div class="word">
			<span class="primary">打印合同 </span><span class="triangle"> </span> <span class="secondary">详情</span>
		</div>
	</div>
	<div class="print-box">
		<div>
			<p style="margin: 0pt; orphans: 0; text-align: justify;">
				<span style="font-family: 宋体; font-size: 14pt">合同编号：${pact_no}</span>
			</p>
			<p style="margin: 0pt; orphans: 0; height: 123pt;"></p>
			<p style="margin: 0pt; orphans: 0; text-align: center;">
				<span style="font-family: 楷体; font-size: 36pt;">讴业普惠</span>
			</p>
			<p style="margin: 0pt; orphans: 0; height: 18pt;"></p>
			<p style="margin: 0pt; orphans: 0; text-align: center">
				<span style="font-family: 楷体; font-size: 36pt">贷款申请审批表</span>
			</p>
			<p style="margin: 0pt; orphans: 0; height: 260pt;"></p>
			<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 180pt; font-family: 楷体; font-size: 18pt">
				<span style="">借款申请人：</span><span style="text-decoration: underline">  ${obj.name}  </span>
			</p>
			<p style="margin: 0pt; orphans: 0; height: 172pt;"></p>

			<p style="margin: 0pt; orphans: 0; text-align: right; font-family: 楷体; font-size: 15pt;">
				<span>申请日期：</span><span style="text-decoration: underline">    　</span><span>年</span><span style="text-decoration: underline">   </span><span>月</span><span style="text-decoration: underline">   </span><span>日</span>
			</p>
			<p style="margin: 0pt; orphans: 0; height: 90pt;"></p>
			<p style="margin: 0pt; orphans: 0; text-align: center;">
				<span style="font-family: 宋体; font-size: 18pt">借款客户受理信息登记表</span>
			</p>
			<p style="margin: 0pt; orphans: 0; height: 18pt;"></p>
			<table cellspacing="0" cellpadding="0" style="border-collapse: collapse; float: left; margin: 0pt 9pt">
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="39" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; widows: 0">
							<span style="font-family: 新宋体; font-size: 12pt; font-weight: bold">申请人基本情况</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">姓名</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; widows: 0;">
							<span style="font-family: 'Times New Roman'; font-size: 9pt;">${obj.name}</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">年龄</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">${obj.age}</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">性别</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; widows: 0">
							<c:if test="${obj.gender==1}">
								<span style="font-family: 'Times New Roman'; font-size: 9pt">男</span>
							</c:if>
							<c:if test="${obj.gender==2}">
								<span style="font-family: 'Times New Roman'; font-size: 9pt">女</span>
							</c:if>
						</p>
					</td>
					<td colspan="7" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">身份证</span>
						</p>
					</td>
					<td colspan="12" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">${obj.id_number}</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">申请金额</span>
						</p>
					</td>
					<td colspan="9" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; widows: 0; text-align: right;">
							<span style="font-family: 宋体; font-size: 9pt">${obj.apply_for_limit} 万元</span>
						</p>
					</td>
					<td colspan="8" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 10.5pt">申请期限</span>
						</p>
					</td>
					<td colspan="7" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; widows: 0; text-align: right">
							<span style="font-family: 宋体; font-size: 9pt;">${obj.apply_for_deadline} 月</span>
						</p>
					</td>
					<td colspan="5" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top"></td>
					<td colspan="7" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top"></td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 新宋体; font-size: 9pt">户籍所在地</span>
						</p>
					</td>
					<td colspan="27" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt; text-decoration: underline">　${permanentResidenceAddress.province}　</span><span style="font-family: 宋体; font-size: 9pt">省</span><span style="font-family: 宋体; font-size: 9pt; text-decoration: underline">　${permanentResidenceAddress.city}　</span><span style="font-family: 宋体; font-size: 9pt">市</span><span style="font-family: 宋体; font-size: 9pt">/</span><span style="font-family: 宋体; font-size: 9pt">县</span><span style="font-family: 宋体; font-size: 9pt; text-decoration: underline"> ${permanentResidenceAddress.county}　　　</span>
						</p>
					</td>
					<td colspan="5" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">居住年限</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 10.5pt"></span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 新宋体; font-size: 9pt">婚姻生育状况</span>
						</p>
					</td>
					<td colspan="26" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 新宋体; font-size: 9pt">已婚有子女<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>已婚无子女<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>未婚<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>离婚
							</span>
						</p>
					</td>
					<td colspan="5" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 新宋体; font-size: 9pt">供养人数</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 新宋体; font-size: 9pt"></span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">学历</span>
						</p>
					</td>
					<td colspan="35" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">初中或以下<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>高中
							</span><span style="font-family: 'Times New Roman'; font-size: 9pt">/</span><span style="font-family: 宋体; font-size: 9pt">中专<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>大学本科<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>硕士研究生或以上<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">工作单位</span>
						</p>
					</td>
					<td colspan="14" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 12pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="8" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">单位地址</span>
						</p>
					</td>
					<td colspan="13" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 12pt">&#xa0;</span>
						</p>
					</td>
				</tr>
				<tr style="height: 30pt; line-height: 18pt">
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">单位性质</span>
						</p>
					</td>
					<td colspan="35" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">个体经营户<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>私营企业<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>股份制企业<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>国有企业<span
								style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>集体企业<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">事业单位<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>国家机关<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>外资企业<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">现居住地址</span>
						</p>
					</td>
					<td colspan="35" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 12pt">&#xa0;</span>
						</p>
					</td>
				</tr>
				<tr style="height: 30pt; line-height: 18pt">
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">工作职位</span>
						</p>
					</td>
					<td colspan="35" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">员工<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>管理人员<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>股东或合伙人<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>法人代表、实际控制人<span
								style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>自任雇主<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">其他<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">移动电话</span>
						</p>
					</td>
					<td colspan="13" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; text-indent: 0pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">${obj.phone}</span>
						</p>
					</td>
					<td colspan="8" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">单位电话</span>
						</p>
					</td>
					<td colspan="7" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; text-indent: 0pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">${obj.business_phone_number}</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">固定电话</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; text-indent: 0pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">${obj.home_phone}</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="39" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; widows: 0">
							<span style="font-family: 宋体; font-size: 12pt; font-weight: bold">联系人情况</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">直系亲属联系人姓名</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">关系</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="8" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">现住址</span>
						</p>
					</td>
					<td colspan="12" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">电话</span>
						</p>
					</td>
					<td style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">亲属联系人姓名</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; text-indent: 0pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">${obj.relative_contact_name}</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">关系</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; text-indent: 0pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt"> <c:choose>
									<c:when test="${obj.domestic_relation == 0}">父子(女)</c:when>
									<c:when test="${obj.domestic_relation == 1}">母子(女)</c:when>
									<c:when test="${obj.domestic_relation == 2}">配偶</c:when>
									<c:when test="${obj.domestic_relation == 3}">子女</c:when>
									<c:when test="${obj.domestic_relation == 4}">亲属</c:when>
									<c:when test="${obj.domestic_relation == 5}">同事</c:when>
									<c:when test="${obj.domestic_relation == 6}">朋友</c:when>
									<c:when test="${obj.domestic_relation == 7}">兄弟姐妹</c:when>
									<c:otherwise>其他</c:otherwise>
								</c:choose>
							</span>
						</p>
					</td>
					<td colspan="8" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">现住址</span>
						</p>
					</td>
					<td colspan="12" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">电话</span>
						</p>
					</td>
					<td style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 1pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 1pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; text-indent: 0pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">${obj.relative_contact_number}</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">其他联系人姓名</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">关系</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="8" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">现住址</span>
						</p>
					</td>
					<td colspan="12" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">电话</span>
						</p>
					</td>
					<td style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="39" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: center; widows: 0">
							<span style="font-family: 宋体; font-size: 12pt; font-weight: bold">抵押物概括</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 12pt; font-weight: bold">车辆概括</span>
						</p>
					</td>
					<td colspan="37" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top"></td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">车名</span>
						</p>
					</td>
					<td colspan="6" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="9" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">登记日期</span>
						</p>
					</td>
					<td colspan="6" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="6" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">车辆里程</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">号牌</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">登记证原件</span>
						</p>
					</td>
					<td colspan="6" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">有<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>无<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
					</td>
					<td colspan="9" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">发动机号</span>
						</p>
					</td>
					<td colspan="12" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="7" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">车架号</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 18pt; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">行驶证原件</span>
						</p>
					</td>
					<td colspan="6" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">有<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>无<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
					</td>
					<td colspan="5" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">发票价格</span>
						</p>
					</td>
					<td colspan="6" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="4" rowspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">有无大修</span>
						</p>
					</td>
					<td colspan="6" rowspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">有<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">无<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
					</td>
					<td colspan="7" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">汽车钥匙</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">有<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>无<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">身份证复印件</span>
						</p>
					</td>
					<td colspan="6" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">有<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>无<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
					</td>
					<td colspan="5" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">评估价格</span>
						</p>
					</td>
					<td colspan="6" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt 0pt 0pt 37.8pt; orphans: 0; text-align: justify; widows: 0"></p>
					</td>
					<td colspan="7" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">保险</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">有<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span>无<span style="position: relative; top: 2.25pt; display: inline-block; height: 9.75pt; width: 10.5pt; margin: 0 3pt; overflow: hidden;"><img src="/riskManagement/images/box.png" /></span></span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 12pt; font-weight: bold">房产概括</span>
						</p>
					</td>
					<td colspan="37" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 1pt; border-right-color: #000000; border-right-style: solid; border-right-width: 1pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 4.9pt; padding-right: 4.9pt; vertical-align: top"></td>
				</tr>
				<tr style="height: 30pt; line-height: 18pt">
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">房屋所有权</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 14pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">共有</span>
						</p>
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">情况</span>
						</p>
					</td>
					<td colspan="5" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 14pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="6" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">登记</span>
						</p>
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">时间</span>
						</p>
					</td>
					<td colspan="7" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 14pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="3" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">总层数</span>
						</p>
					</td>
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 14pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">建筑</span>
						</p>
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">面积</span>
						</p>
					</td>
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 14pt">&#xa0;</span>
						</p>
					</td>
				</tr>
				<tr style="height: 18pt; line-height: 18pt">
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">房屋座落</span>
						</p>
					</td>
					<td colspan="19" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="7" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">一抵情况</span>
						</p>
					</td>
					<td colspan="5" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
					<td colspan="4" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 9pt">地下室</span>
						</p>
					</td>
					<td colspan="2" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="margin: 0pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">&#xa0;</span>
						</p>
					</td>
				</tr>
				<tr style="height: 107.75pt; line-height: 18pt">
					<td colspan="39" style="border-bottom-color: #000000; border-bottom-style: solid; border-bottom-width: 0.75pt; border-left-color: #000000; border-left-style: solid; border-left-width: 0.75pt; border-right-color: #000000; border-right-style: solid; border-right-width: 0.75pt; border-top-color: #000000; border-top-style: solid; border-top-width: 0.75pt; padding-left: 5.03pt; padding-right: 5.03pt; vertical-align: top">
						<p style="orphans: 0; text-align: justify;">
							<span style="font-family: 宋体; font-size: 9pt">申请人声明：</span>
						</p>
						<p style="orphans: 0; text-align: justify;">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">1</span><span style="font-family: 宋体; font-size: 9pt">、</span><span style="font: 7.0pt 'Times New Roman'">&#xa0;&#xa0;&#xa0; </span><span style="font-family: 宋体; font-size: 9pt">申请表中填写内容、资料均属真实、如有隐瞒或虚构，本人将承担一切法律和经济后果。</span>
						</p>
						<p style="orphans: 0; text-align: justify;">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">2</span><span style="font-family: 宋体; font-size: 9pt">、</span><span style="font: 7.0pt 'Times New Roman'">&#xa0;&#xa0;&#xa0; </span><span style="font-family: 宋体; font-size: 9pt">本人同时授权贵公司向有关方面（包括但不限于个人信用征信机构）查询、核实相关情况。</span>
						</p>
						<p style="orphans: 0; text-align: justify;">
							<span style="font-family: 'Times New Roman'; font-size: 9pt">3</span><span style="font-family: 宋体; font-size: 9pt">、</span><span style="font: 7.0pt 'Times New Roman'">&#xa0;&#xa0;&#xa0; </span><span style="font-family: 宋体; font-size: 9pt">本人愿意提供有关本人或他人名下的不动产作为抵押担保措施，申请借款，保证按期还本付息</span>
						</p>
						<p style="margin: 10pt 0pt 18pt 18pt; orphans: 0; text-align: justify; widows: 0">
							<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">申请人签字：</span><span style="font-family: 宋体; font-size: 10.5pt">                         </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">  年    月    日</span>
						</p>
					</td>
				</tr>
				<tr style="height: 0pt">
					<td style="width: 47.95pt; border: none"></td>
					<td style="width: 28.25pt; border: none"></td>
					<td style="width: 21.25pt; border: none"></td>
					<td style="width: 27.2pt; border: none"></td>
					<td style="width: 0.4pt; border: none"></td>
					<td style="width: 2.55pt; border: none"></td>
					<td style="width: 19.45pt; border: none"></td>
					<td style="width: 11.95pt; border: none"></td>
					<td style="width: 1.25pt; border: none"></td>
					<td style="width: 6.75pt; border: none"></td>
					<td style="width: 15.5pt; border: none"></td>
					<td style="width: 6.65pt; border: none"></td>
					<td style="width: 21.3pt; border: none"></td>
					<td style="width: 7.5pt; border: none"></td>
					<td style="width: 0.4pt; border: none"></td>
					<td style="width: 6.25pt; border: none"></td>
					<td style="width: 6.85pt; border: none"></td>
					<td style="width: 12.45pt; border: none"></td>
					<td style="width: 3.6pt; border: none"></td>
					<td style="width: 5.45pt; border: none"></td>
					<td style="width: 5.3pt; border: none"></td>
					<td style="width: 9.3pt; border: none"></td>
					<td style="width: 10.8pt; border: none"></td>
					<td style="width: 4.2pt; border: none"></td>
					<td style="width: 11.1pt; border: none"></td>
					<td style="width: 7.4pt; border: none"></td>
					<td style="width: 1.7pt; border: none"></td>
					<td style="width: 5.35pt; border: none"></td>
					<td style="width: 23.15pt; border: none"></td>
					<td style="width: 8.2pt; border: none"></td>
					<td style="width: 4.2pt; border: none"></td>
					<td style="width: 16.15pt; border: none"></td>
					<td style="width: 14.05pt; border: none"></td>
					<td style="width: 14.2pt; border: none"></td>
					<td style="width: 20.2pt; border: none"></td>
					<td style="width: 1.15pt; border: none"></td>
					<td style="width: 7pt; border: none"></td>
					<td style="width: 7.1pt; border: none"></td>
					<td style="width: 58.5pt; border: none"></td>
				</tr>
			</table>
		</div>

		<br style="clear: both; mso-break-type: section-break; page-break-before: always" />
		<p style="margin: 0pt; orphans: 0; height: 90pt;"></p>
		<div>
			<p style="margin: 0pt; orphans: 0; height: 20pt;"></p>
			<p style="line-height: 23pt; margin: 0pt; orphans: 0; text-align: center; text-indent: 10pt; widows: 0">
				<span style="font-family: 宋体; font-size: 16pt; font-weight: bold">借款咨询服务协议</span>
			</p>
			<p style="margin: 0pt; orphans: 0; height: 20pt;"></p>
			<p style="line-height: 23pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 315pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">编号：</span><span style="color: #ff0000; font-family: 宋体; font-size: 10.5pt"> </span>
			</p>
			<table cellspacing="0" cellpadding="0" style="border-collapse: collapse; float: left; margin: 0pt 9pt">
				<tr style="height: 79.9pt">
					<td style="padding-left: 5.4pt; padding-right: 5.4pt; vertical-align: top; width: 50%; word-wrap: break-word; overflow: hidden;">
						<p style="line-height: 23pt; margin: 0pt; orphans: 0; text-indent: 10pt; widows: 0">
							<span style="font-family: 宋体; font-size: 11pt; font-weight: bold">甲方（借款人）：${obj.name}</span><span style="font-family: 宋体; font-size: 11pt; font-weight: bold; text-decoration: underline"> </span>
						</p>
						<p style="line-height: 23pt; margin: 0pt; orphans: 0; text-indent: 10pt; widows: 0">
							<span style="font-family: 宋体; font-size: 11pt; font-weight: bold">身份证号码：${obj.id_number}</span><span style="font-family: 宋体; font-size: 11pt; font-weight: bold; text-decoration: underline"> </span>
						</p>
						<p style="line-height: 23pt; margin: 0pt; orphans: 0; text-indent: 10pt; widows: 0">
							<span style="font-family: 宋体; font-size: 11pt; font-weight: bold">住址：${obj.home_address}</span><span style="font-family: 宋体; font-size: 11pt; font-weight: bold; text-decoration: underline"> </span>
						</p>
						<p style="line-height: 23pt; margin: 0pt; orphans: 0; text-indent: 10pt; widows: 0">
							<span style="font-family: 宋体; font-size: 11pt; font-weight: bold">联系电话：${obj.phone}</span><span style="font-family: 宋体; font-size: 11pt; font-weight: bold; text-decoration: underline"> </span>
						</p>
					</td>
					<td style="padding-left: 5.4pt; padding-right: 5.4pt; vertical-align: top">
						<p style="line-height: 23pt; margin: 0pt; orphans: 0; text-indent: 10pt; widows: 0">
							<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">乙方（咨询服务人）：石家庄菲尔德投资咨询有限公司</span>
						</p>
						<p style="line-height: 23pt; margin: 0pt; orphans: 0; text-indent: 10pt; widows: 0">
							<span style="font-family: 宋体; font-size: 10.5pt">地址:石家庄市新华区民族路77号华强广场A座1605室</span>
						</p>
						<p style="line-height: 23pt; margin: 0pt; orphans: 0; text-indent: 10pt; widows: 0">
							<span style="font-family: 宋体; font-size: 10.5pt">联系电话：400-901-8889</span>
						</p>
					</td>
				</tr>
			</table>
			<p style="margin: 0pt; orphans: 0; text-align: center; widows: 0">
				<span style="font-family: 楷体; font-size: 26pt">&#xa0;</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">甲、乙双方经平等协商，双方达成如下协议</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">：</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第一条 咨询服务范围</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1）</span><span style="font-family: 宋体; font-size: 10.5pt">甲方委托乙方为甲方提供办理借款的信息咨询服务，并在甲方申请借款</span><span style="font-family: 宋体; font-size: 10.5pt">过程中协助其办理各种手续；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）</span><span style="font-family: 宋体; font-size: 10.5pt">乙方为甲方实现成功借款出具审核意见，提供出借人推荐，并促成交易，为甲方提供还款管理等相关服务。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3</span><span style="font-family: 宋体; font-size: 10.5pt">）本咨询服务协议自签订日起两年内有效。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第二条</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold"> </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">双方权利与义务</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">A 甲方</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1）有权向乙方了解其信用评估进度和结果；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）在申请及实现借款的全过程中，必须如实向乙方提供所要求的个人信息；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3）在乙方建立个人信用账户，</span><span style="font-family: 宋体; font-size: 10.5pt">授权乙方基于甲方提供的信息及乙方独立获取的信息来管理甲方的信用信息；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">4）经乙方推荐，向出借人借款人民币（大写）</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> ${bid_camount}  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">      </span><span style="font-family: 宋体; font-size: 10.5pt">元整，（小写）￥</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">${lower_camount} </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"></span><span
					style="font-family: 宋体; font-size: 10.5pt">元，并与其另行签署《借款合同》（编号：</span><span style="font-family: 宋体; font-size: 10.5pt">OY-</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline"> ${pact_no} </span><span style="font-family: 宋体; font-size: 10.5pt">）；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">5）按照本协议的规定向乙方支付咨询费、审核费、服务费等综合服务费；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">6）甲方同意，甲方成功借款后，乙方依据出借人的委托协调甲方按照约定期限及金额进行还款，甲方有义务无条件及时配合乙方工作；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">7）对于甲方与特定的出借人约定的及本协议中所规定的任何应从甲方账户划扣的款项，甲方应通过其在第三方支付平台中的账户将款项准确划扣相应数额至出借人指定的账户</span><span style="font-family: 宋体; font-size: 10.5pt">。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">8) 甲方同意与其有借款协议关系的出借人可随时在条件不变前提下将债权转让给第三方，该第三方（受让方）仅限于在本平台已注册的用户。甲方应配合乙方办理收到有关债权转让通知的书面文件。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">9）甲方指定乙方为其代理人，同意乙方接收处理甲方的债务变更信息。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">B 乙方</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1）</span><span style="font-family: 宋体; font-size: 10.5pt">为甲方提供借款相关的全程信息咨询服务，并在甲方申请借款过程中协助其办理各项手续；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）</span><span style="font-family: 宋体; font-size: 10.5pt">有权向甲方收取本协议约定的综合服务费；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3）</span><span style="font-family: 宋体; font-size: 10.5pt">除甲方允许乙方将其信息提供给出借人供出借参考外，对于甲方提供给乙方的个人证件及其他各类信息，乙方有义务在本协议约定下为甲方保密。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">4）</span><span style="font-family: 宋体; font-size: 10.5pt">有权对甲方提供的个人信用信息及行为记录进行审核，为甲方提供还款方案建议，包括借款额度、还款期限等建议；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">5）</span><span style="font-family: 宋体; font-size: 10.5pt">有权以信用审核的目的使用甲方个人信用信息及其他个人信息；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">6）</span><span style="font-family: 宋体; font-size: 10.5pt">有权依据乙方对甲方的审评结果，决定是否将甲方的借款需求向出借人进行推荐，以协助甲方取得资金来源，促成交易；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第三条 收费及支付方式</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1</span><span style="font-family: 宋体; font-size: 10.5pt">）本协议中，“咨询费”是指乙方为甲方提供办理借款的信息咨询，并在甲方申请借款过程中协助其办理各项手续并成功获得借款而由甲方支付给乙方的报酬；“审核费”是指因乙方为甲方实现成功借款出具审核意见而由甲方支付给乙方的报酬；“服务费”是指因乙方为甲方提供出借人推荐服务、促成甲方与出借人达成借款协议的斡旋服务、以及在借款期间提供的包括但不限于由甲方委托乙方办理的与合作机构</span><span style="font-family: 宋体; font-size: 10.5pt">自动扣款服务、还款提醒服务等服务中甲方应付给乙方的报酬。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）甲方确认在签订本协议时乙方已为甲方完成本协议所约定的咨询、审核及本协议所约定的其他服务等工作和义务，甲方应向乙方支付咨询费和审核费</span><span style="font-family: 宋体; font-size: 10.5pt">，服务费等各项费用</span><span style="font-family: 宋体; font-size: 10.5pt">共计</span><span style="font-family: 宋体; font-size: 10.5pt">人民币（大写）</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">元整（RMB______________</span><span style="font-family: 宋体; font-size: 10.5pt">），</span><span style="font-family: 宋体; font-size: 10.5pt">该项费用</span><span style="font-family: 宋体; font-size: 10.5pt">根据约定的不同的</span><span
					style="font-family: 宋体; font-size: 10.5pt">支付</span><span style="font-family: 宋体; font-size: 10.5pt">方式，可分为一次性支付和分期支付，从甲方获得出借人提供的借款之日起按照不同的还款方式，应该一次性支付的，应该在借款日一次性支付；应该分期支付的， 由甲方每月向乙方支付</span><span style="font-family: 宋体; font-size: 10.5pt">人民币</span><span style="font-family: 宋体; font-size: 10.5pt">（大写）</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">          </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">     </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">   </span><span
					style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">元整（</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">RMB</span><span style="font-family: 'Times New Roman'; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 'Times New Roman'; font-size: 10.5pt; text-decoration: underline">     　　　　　</span><span style="font-family: 'Times New Roman'; font-size: 10.5pt; text-decoration: underline">   </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">）</span><span style="font-family: 宋体; font-size: 10.5pt">。以上费用由甲方授权的合作机构从甲方指定的账户存款中直接划扣给乙方，如因甲方或合作机构的原因无法完成划扣的，甲方应通过现金或经乙方同意的其他方式支付给乙方。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3</span><span style="font-family: 宋体; font-size: 10.5pt">）若甲方提前还款给《借款合同》下的特定出借人，需提前三个工作日与乙方联系，提出书面申请，经特定的出借人同意后，甲方与出借人约定提前还款时间（还款日当日及节假日期间不受理），由乙方通知合作机构进行划扣应还款金额，甲方需在约定的时间前将相应款项存入指定帐户。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">4）</span><span style="font-family: 宋体; font-size: 10.5pt">因借款人未按合同约定及时还款而产生的催收费用全部由借款人及共同借款人承担。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第四条 还款约定</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1）因甲方未按合同约定及时还款而产生的各类费用全部由甲方承担。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）</span><span style="font-family: 宋体; font-size: 10.5pt">甲方必须在履行《借款合同》期限满合同总期限二分之一时才能向乙方提出提前还款事项；</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第五条 款项扣划专用账户</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1）</span><span style="font-family: 宋体; font-size: 10.5pt">甲方</span><span style="font-family: 宋体; font-size: 10.5pt">共同</span><span style="font-family: 宋体; font-size: 10.5pt">指定如下账户作为收款、还款划扣等本协议项下资金往来的专用账户：（该账户须与甲方将签署的《借款合同》中甲方指定专用账户保持一致。）</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">账户名称：</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">       </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">       </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">                     </span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">开 户 行：</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">       </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">       </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">                     </span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">收款账号：</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">       </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">         </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">                </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold; text-decoration: underline">  </span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）甲方须确保该账户为甲方名下合法有效的银行账户，如甲方需要变更此指定账户，须在还款日前至少5个工作日向乙方提出申请，并签署《借款人客户信息变更书》。否则因此导致甲方未能实现及时还款，并因此导致的逾期罚息由甲方承担。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3）在收款、还款划扣过程中，甲方有义务配合为前述目的而进行的包括但不限于账户验证、账户变更、身份验证等事项，否则因甲方不配合而造成的未能正常还款的罚息、违约金等损失由甲方负责。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第六条 保密条款</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1）</span><span style="font-family: 宋体; font-size: 10.5pt">双方共同确认：本协议所涉及的各项合同交易信息均属于保密信息，范围涵盖甲方提供给乙方的甲方个人信息以及甲方所知悉和了解的乙方非公开的、保密的或独占的有关本合同交易的任何信息。各方均有责任对前述所指的保密信息实行保密。 </span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）</span><span style="font-family: 宋体; font-size: 10.5pt">未经对方事先书面同意，不得向任何其他第三方披露保密信息，除非是披露给出借人或乙方的董事、</span><span style="-aw-bookmark-end: OLE_LINK4"></span><span style="-aw-bookmark-end: OLE_LINK2"></span><span style="-aw-bookmark-end: OLE_LINK5"></span><span style="font-family: 宋体; font-size: 10.5pt">职员、顾问、控股公司、分支机构或其他关联公司，如果他们需要知道保密信息，而且该种披露对于他们对本协议交易进行评估是必须的。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3）保密内容：客户档案、财务资料、客户以口头或书面形式要求本公司保密的内容，双方在合作过程中得到的双方的任何信息等。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">4）</span><span style="font-family: 宋体; font-size: 10.5pt">任何一方违反本协议保密规定，则应对给对方造成的实际损失承担赔偿责任。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">5）除外事例：客户信息已经或正在变成普通大众可以获取的资料；本公司在收到客户资料前已经熟知该资料；由第三方合法提供给公司的该客户资料。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第七条 违约责任</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1）任何一方违反本协议的约定，导致本协议的全部或部分不能履行，均应承担违约责任，违约方需赔偿守约方因此遭受的损失（包括但不限于由此产生的诉讼费、律师费等其他实现债权的费用）；如双方均违约，根据实际情况各自承担相应的责任。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）乙方保留将甲方违约失信的相关信息在媒体披露的权利。因甲方逃避还款而带来的调查及诉讼等其他相关费用（包括但不限于调查费、鉴定费、律师费等）均由甲方承担。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第八条 变更通知</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1）本协议签订之日起至借款全部清偿之日止，甲方有义务在下列信息变更三日内提供更新后的信息给乙方和出借人（包含但不限于）：甲方本人、甲方的家庭联系人及紧急联系人工作单位、居住地址、住所电话、手机号码、电子邮箱的变更。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）若因甲方不及时提供上述变更信息给乙方造成的调查及诉讼等其他相关费用（包括但不限于调查费、鉴定费、律师费等）将由甲方承担。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第九条 征信数据采集确认</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">为使出借人、第三方征信机构、石家庄菲尔德投资咨询有限公司平台</span><span style="font-family: 'Times New Roman'; font-size: 10.5pt">--</span><span style="font-family: 宋体; font-size: 10.5pt">讴业普惠平台，能够更全面的掌握借款人征信信息，使借款人能够顺利获得贷款，以及对借款人获得贷款后的资金使用情况及履约情况进行监督、制约和信息的收集，借款人自愿作出如下承诺：</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 'Times New Roman'; font-size: 10.5pt; font-weight: normal">1</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">）</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">数据采集授权</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">同意第三方征信机构（包括但不限于上海资信有限公司）将本人在</span><span style="font-family: 宋体; font-size: 10.5pt">石家庄菲尔德投资咨询有限公司设立的讴业普惠网贷平台上的借款</span><span style="font-family: 宋体; font-size: 10.5pt">业务中产生的信用信息纳入由其建设的征信系统（包括但不限于网络金融征信系统）；同意</span><span style="font-family: 宋体; font-size: 10.5pt">石家庄菲尔德投资咨询有限公司</span><span style="font-family: 宋体; font-size: 10.5pt">在获批接入征信中心运营的金融信用信息基础数据库后，将本人在</span><span style="font-family: 宋体; font-size: 10.5pt">石家庄菲尔德投资咨询有限公司</span><span style="font-family: 宋体; font-size: 10.5pt">上述业务中产生的信用信息通过上海资信有限公司网络金融征信系统纳入金融信用信息基础数据库。上述信用信息可由第三方征信机构（包括但不限于上海资信有限公司）或中国人民银行征信中心进行采集、存储、匹配、检索、分析、处理加工、信用评估、提供和使用，用于形成本人个人信用报告、信用评估及其他相关法律、法规、规章和规范性文件规定的用途。</span><span
					style="font-family: 宋体; font-size: 10.5pt">石家庄菲尔德投资咨询有限</span><span style="font-family: 宋体; font-size: 10.5pt">公司采集本人不良信用信息的，应当事先通知本人。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 'Times New Roman'; font-size: 10.5pt; font-weight: normal">2</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">）</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">信息查询授权</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">同意</span><span style="font-family: 宋体; font-size: 10.5pt">石家庄菲尔德投资咨询有限公司</span><span style="font-family: 宋体; font-size: 10.5pt">在</span><span style="font-family: 宋体; font-size: 10.5pt">本人借贷</span><span style="font-family: 宋体; font-size: 10.5pt">业务中向第三方征信机构（包括但不限于上海资信有限公司）查询本人在其建设的第三方征信系统（包括但不限于网络金融征信系统）的个人信用信息；同意</span><span style="font-family: 宋体; font-size: 10.5pt">石家庄菲尔德投资咨询有限公司</span><span style="font-family: 宋体; font-size: 10.5pt">在获准接入金融信用信息基础数据库后，在上述业务中通过上海资信有限公司向征信中心查询本人的个人信用信息。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">第</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">十</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">条 其他</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1）</span><span style="font-family: 宋体; font-size: 10.5pt">甲乙双方签署本协议后，本协议于文首所载日期成立。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt 0pt 0pt 21pt; orphans: 0; text-align: justify; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2）</span><span style="font-family: 宋体; font-size: 10.5pt">本协议的任何修改、补充均须以书面形式作出。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3）</span><span style="font-family: 宋体; font-size: 10.5pt">甲乙双方保证，本协议的签署、生效和履行以不违反中国现行的法律法规为前提。如果本协议中的任何一条或多条违反现行的法律法规，则该条将被视为无效，但该无效条款并不影响本协议其他条款的效力。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">4）</span><span style="font-family: 宋体; font-size: 10.5pt">如果甲乙双方在本协议履行过程中发生任何争议，应友好协商解决；如果协商不成，则任何一方有权提交乙方住所地有管辖权的人民法院诉讼解决。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">5）</span><span style="font-family: 宋体; font-size: 10.5pt">本协议作为双方独立合同关系成立之证明，并不自动构成甲方与出借人之间《借款合同》的附件。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">6）本协议自签订之日起则表示乙方已完全履行了全部居间服务事项的义务，甲方已与</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">出借人签订了《借款合同》并获得了</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">全部</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">出借资金。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">7）</span><span style="font-family: 宋体; font-size: 10.5pt">本协议一式两份，甲乙双方各保留壹份，具有同等法律效力。</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">（以下无正文）</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">协议各方签字盖章</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">甲方（签</span><span style="font-family: 宋体; font-size: 10.5pt">章</span><span style="font-family: 宋体; font-size: 10.5pt">、指模）：                   乙方：石家庄菲尔德投资咨询有限公司</span>
			</p>
			<p style="line-height: 19pt; margin: 0pt; orphans: 0; height: 44pt; widows: 0"></p>

			<p style="line-height: 19pt; margin: 0pt; orphans: 0; text-indent: 260pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">签约日期：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">      </span><span style="font-family: 宋体; font-size: 10.5pt">年</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">    </span><span style="font-family: 宋体; font-size: 10.5pt">月</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">    </span><span style="font-family: 宋体; font-size: 10.5pt">日 </span><span style="-aw-bookmark-end: OLE_LINK1"></span><span style="-aw-bookmark-end: OLE_LINK3"></span><span style="-aw-bookmark-end: OLE_LINK6"></span>
			</p>
			<p style="orphans: 0; height: 580pt;"></p>
		</div>
		<br style="clear: both; mso-break-type: section-break; page-break-before: always" />
		<div>
			<p style="line-height: 16pt; margin: 0pt; orphans: 0; text-align: center; widows: 0">
				<span style="font-family: 宋体; font-size: 16pt; font-weight: bold">抵押借款合同</span>
			</p>
			<p style="orphans: 0; height: 40pt;"></p>
			<p style="line-height: 25pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">甲方（出借人、抵押权人）：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">   </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">        </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt">身份证号码：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                   </span>
			</p>
			<p style="line-height: 25pt; margin: 0pt; orphans: 0; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">联系方式：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                   </span>
			</p>
			<p style="line-height: 25pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">乙方（借款人）：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"></span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> ${obj.name}     </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt">身份证号码：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> ${obj.id_number} 　</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"></span>
			</p>
			<p style="line-height: 25pt; margin: 0pt; orphans: 0; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">地址：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> ${obj.home_address}       　　　　　　　 </span><span style="font-family: 宋体; font-size: 10.5pt">联系方式：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"></span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> ${obj.phone}     </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span>
			</p>
			<p style="line-height: 25pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">丙方（抵押人）</span><span style="font-family: 宋体; font-size: 10.5pt">：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">　　　　　　　　 </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"></span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"></span><span style="font-family: 宋体; font-size: 10.5pt">身份证号码：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> 　　　　　　　　　　　　　　　　　　　　　　　　</span>
			</p>
			<p style="line-height: 25pt; margin: 0pt; orphans: 0; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">地址：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                     　　</span><span style="font-family: 宋体; font-size: 10.5pt">联系方式：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"></span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">　　　　　　　　　　</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"></span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">本合同各方根据有关法律、法规，在平等、自愿的基础上，为明确责任、恪守信用，经充分协商一致签订本合同，并保证共同遵守执行。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">一、</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">借款条款</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第一条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">借款金额：据乙方申请，甲方同意借款给乙方人民币（大写）<span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> ${bid_camount} </span> <span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span>。
				</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第二条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">借款用途：本借款只能用于<span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> ${obj.purpose_of_loan} </span> ，乙方不得以任何理由将借款挪作他用。
				</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第三条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">借款利率：年利率按</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">       </span><span style="font-family: 宋体; font-size: 10.5pt">%计算。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第四条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">借款期限：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> ${obj.apply_for_deadline} </span><span style="font-family: 宋体; font-size: 10.5pt">个月，自</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline;"> <%=Calendar.getInstance().get(Calendar.YEAR)%>
				</span><span style="font-family: 宋体; font-size: 10.5pt">年</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline;"> <%=Calendar.getInstance().get(Calendar.MONTH) + 1%>
				</span><span style="font-family: 宋体; font-size: 10.5pt">月</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline;"> <%=Calendar.getInstance().get(Calendar.DAY_OF_MONTH)%>
				</span><span style="font-family: 宋体; font-size: 10.5pt">日起至</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underLine;"> ${last_repay_time.year} </span><span style="font-family: 宋体; font-size: 10.5pt">年</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underLine;"> ${last_repay_time.month} </span><span style="font-family: 宋体; font-size: 10.5pt">月</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> ${last_repay_time.day} </span><span style="font-family: 宋体; font-size: 10.5pt;">日止。如实际放款日与该日期不符，以实际放款日期为准，借款期限随之顺延。乙方收到借款后应当出具借据</span><span style="font-family: 宋体; font-size: 10.5pt">（见本合同附表</span><span
					style="font-family: 宋体; font-size: 10.5pt">1</span><span style="font-family: 宋体; font-size: 10.5pt">）</span><span style="font-family: 宋体; font-size: 10.5pt">，乙方所出具的借据为本合同的附件，与本合同具有同等法律效力。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第五条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">借款的偿还：利息每月结息。本金在借款到期日结清，同时甲方应当交还乙方先前所出具的借据。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第六条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">本合同有效期内，发生下列事项的，甲方有权在以下任何一项或多项事件发生时，宣布本合同项下的借款提前到期，要求借款人在《提前还款函》规定的期限内清偿部分或全部借款利息，并无须为正当行使上述权利所引起的任何损失负责。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">（一）</span><span style="font: 7.0pt 'Times New Roman'">&#xa0;&#xa0;&#xa0;&#xa0;&#xa0;&#xa0; </span><span style="font-family: 宋体; font-size: 10.5pt">乙方违反本借款合同中的任何条款；</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">（二）</span><span style="font: 7.0pt 'Times New Roman'">&#xa0;&#xa0;&#xa0;&#xa0;&#xa0;&#xa0; </span><span style="font-family: 宋体; font-size: 10.5pt">根据担保条款的约定，因抵押人、抵押物发生变故或抵押人违反担保条款的约定，致使抵押人需提前履行义务或甲方提前处分抵押物的；乙方发生其他可能影响归还甲方借款本息的行为。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第七条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">履行本合同所支付的相关费用（包括但不限于抵押登记费、公证费等）均由乙方负责。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">二、</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">抵押</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">担保</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">条款</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第八条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">抵押</span><span style="font-family: 宋体; font-size: 10.5pt">人自愿将其合法享有所有权和处分权的</span><span style="font-family: 宋体; font-size: 10.5pt">房屋所有权证</span><span style="font-family: 宋体; font-size: 10.5pt">：</span><span style="font-family: 宋体; font-size: 10.5pt">_________________________</span><span style="font-family: 宋体; font-size: 10.5pt">，</span><span style="font-family: 宋体; font-size: 10.5pt">坐落于</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                                             </span><span
					style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">的房屋抵押给甲方，以担保借款人按期偿还本合同项下的贷款本息和其他应付款项。</span><span style="font-family: 宋体; font-size: 10.5pt">抵押人上述房屋已于</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt">年</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span
					style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">   </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt">月</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt">日至</span><span
					style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">    </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt">年</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt">月</span><span
					style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt">日抵押给  </span><span style="font-family: 宋体; font-size: 10.5pt">______________________________</span><span style="font-family: 宋体; font-size: 10.5pt">银</span><span style="font-family: 宋体; font-size: 10.5pt">行</span><span style="font-family: 宋体; font-size: 10.5pt">,</span><span style="font-family: 宋体; font-size: 10.5pt">并取得贷款总计</span><span
					style="font-family: 宋体; font-size: 10.5pt">______________</span><span style="font-family: 宋体; font-size: 10.5pt">元</span><span style="font-family: 宋体; font-size: 10.5pt">，现抵押人同意以该房屋的剩余价值作为抵押，为本《借款合同》下的借款做担保。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第九条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">抵押担保范围为本《借款合同》项下的借款主债权本金、利息、违约金、 损害赔偿金以及其他实现债权的费用（包括但不限于诉讼费（或仲裁费）、律师费、差旅费、保全费、公告费、保险费、评估费、拍卖费、保管费、鉴定费等其他合理费用）。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第十条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">抵押人保证并未就该房屋与任何第三方存在租赁关系。上述房屋的第一顺序抵押权人为</span><span style="font-family: 宋体; font-size: 10.5pt">______________________________</span><span style="font-family: 宋体; font-size: 10.5pt">行，本《借款合同》中的抵押权人为第二顺序抵押权人。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第十一条</span><span style="font-family: 宋体; font-size: 10.5pt"> 本合同中的抵押人，如抵押物为抵押人与第三人共有，则在本合同项下提及“抵押人”应同时包含抵押物共有人（见本合同附表二：同意抵押声明）。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">十二条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">抵押期限自抵押登记之日起至约定债务履行完毕之日止。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">十三</span><span style="font-family: 宋体; font-size: 10.5pt">条 抵押期间，未经抵押权人书面同意，抵押人不得出租、变卖、赠与抵押物，或以其他任何方式处分抵押物。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">十四</span><span style="font-family: 宋体; font-size: 10.5pt">条 甲、乙、丙三方共同到抵押登记部门办理二次抵押登记手续并领取《他项权利证书》，甲、乙、丙三方应相互配合。抵押物的《他项权力证书》或抵押登记证明交由抵押权人保管。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">十五</span><span style="font-family: 宋体; font-size: 10.5pt">条 本合同中“借款条款”如因某种原因导致其部分或全部无效，不影响“抵押</span><span style="font-family: 宋体; font-size: 10.5pt">担保</span><span style="font-family: 宋体; font-size: 10.5pt">条款”的效力，抵押人仍应按照约定承担责任。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第十六条</span><span style="font-family: 宋体; font-size: 10.5pt"> 抵押人应配合贷款人对抵押物的检查。抵押人应及时将可能影响抵押物或其价值的任何事件（包括但不限于涉及抵押物的任何查封、扣押、拆迁、诉讼、仲裁或其他争议事件）通知抵押权人。由于抵押人的过错或其他任何原因造成抵押物价值减少的，抵押人应立即采取措施防止损失扩大，并应在十日内向抵押权人提供抵押权人认可的与减少的价值相当的担保。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第十七条 抵押人已仔细阅读并完全了解和接受本合同的内容，抵押人签署和履行本合同是自愿的，全部是真实意思表示。如抵押人为法人，其法定代表人或授权签字人的签字已经过合法的授权。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">三、</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: bold">其他条款</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第十八条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">本合同自甲方、乙方、丙方签章之后生效，本合同中的抵押条款在办清抵押登记之后生效</span><span style="font-family: 宋体; font-size: 10.5pt">，因政策原因未能办理抵押登记的，律师见证书或公证书等文书与抵押登记证书具有同等效力。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第十九条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">其他约定事项：合同各方在履行本合同过程中发生争议的，首先由各方协商解决；协商不成的，向甲方所在地人民法院通过诉讼方式解决。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">二十</span><span style="font-family: 宋体; font-size: 10.5pt">条 经甲乙丙三方确认，此房产价值为</span><span style="font-family: 宋体; font-size: 10.5pt">_________________,</span><span style="font-family: 宋体; font-size: 10.5pt">剩余价值为</span><span style="font-family: 宋体; font-size: 10.5pt">______________</span><span style="font-family: 宋体; font-size: 10.5pt">。抵押期限：自</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">       </span><span style="font-family: 宋体; font-size: 10.5pt">年</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">   </span><span
					style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt">月</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt">日至</span><span style="font-family: 宋体; font-size: 10.5pt">借款结清之日止</span><span style="font-family: 宋体; font-size: 10.5pt">，抵押金额为</span><span
					style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">     </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">     </span><span style="font-family: 宋体; font-size: 10.5pt">元。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; text-align: justify; text-indent: 21pt">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">二十一</span><span style="font-family: 宋体; font-size: 10.5pt">条</span><span style="font-family: 宋体; font-size: 10.5pt"> </span><span style="font-family: 宋体; font-size: 10.5pt">本协议各方在</span><span style="font-family: 宋体; font-size: 10.5pt">协议中填写</span><span style="font-family: 宋体; font-size: 10.5pt">的地址及联系方式，为各方履行合同、解决合同争议时向接收其他方商业文件信函或司法机关(法院、仲裁机构)诉讼、仲裁文书的地址和联系方式。如</span><span style="font-family: 宋体; font-size: 10.5pt">更改联系人、联系地址、联系电话的，应在相关信息变更之日起三日内变更其在讴业普惠网贷平台的注册信息</span><span style="font-family: 宋体; font-size: 10.5pt">，并书面通知至讴业普惠平台及出借人，没有书面通知至平台和出借人的，均以本协议填写的信息为准</span><span
					style="font-family: 宋体; font-size: 10.5pt">。否则变更方应当承担由此造成的送达不能产生的法律风险及责任。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">二十二</span><span style="font-family: 宋体; font-size: 10.5pt">条</span><span style="font-family: 宋体; font-size: 10.5pt"> 本合同一式3份，具有同等法律效力，抵押权人执1份；借款人、抵押人各执</span><span style="font-family: 宋体; font-size: 10.5pt">1</span><span style="font-family: 宋体; font-size: 10.5pt">份。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第二十三条</span><span style="font-family: 宋体; font-size: 10.5pt"> 双方均了解前次抵押的担保金额及担保范围，如前次担保债权超过担保物价值导致抵押权不能实现的，由抵押双方自行处理。抵押双方同时声明已将本次抵押告知第一顺序抵押权人，因前述事项产生的一切纠纷及法律责任由抵押双方承担，与抵押登记部门无关。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">合同各方签章、指模：</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">甲方（抵押权人、出借人）：  </span><span style="font-family: 宋体; font-size: 10.5pt">      </span><span style="font-family: 宋体; font-size: 10.5pt">乙方（借款人）</span><span style="font-family: 宋体; font-size: 10.5pt">：</span><span style="font-family: 宋体; font-size: 10.5pt">        </span><span style="font-family: 宋体; font-size: 10.5pt">丙方（抵押人）： </span>
			</p>
			<p style="orphans: 0; height: 50pt;"></p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: right; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">年</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">    </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal"> 月 </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">  </span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">日</span><span style="font-family: 宋体; font-size: 10.5pt; font-weight: normal">             </span>
			</p>
			<p style="orphans: 0; height: 110pt;"></p>
			<p style="margin: 0pt; orphans: 0; text-align: justify; text-indent: 10.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 16pt">附表一：</span>
			</p>
			<p style="orphans: 0; height: 30pt;"></p>
			<p style="margin: 0pt; orphans: 0; text-align: center; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 14pt">借据</span>
			</p>
			<p style="orphans: 0; height: 20pt;"></p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">借款人：</span><span style="font-family: 宋体; font-size: 10pt; text-decoration: underline">    ${obj.name}    </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">，</span><span style="font-family: 宋体; font-size: 10.5pt">性别：<span style="font-family: 宋体; font-size: 10pt; text-decoration: underline">  <c:if test="${obj.gender == 1}">男</c:if> <c:if test="${obj.gender == 2}">女</c:if>  
				</span>，出生年月日：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">             </span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: ; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">民族</span><span style="font-family: 宋体; font-size: 10.5pt">：</span><span style="font-family: 宋体; font-size: 10pt; text-decoration: underline">     </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">，</span><span style="font-family: 宋体; font-size: 10.5pt">家庭住址：<span style="font-family: 宋体; font-size: 10pt; text-decoration: underline">${obj.home_address}          </span>身份证号码：</span>
				<span style="font-family: 宋体; font-size: 10pt; text-decoration: underline"> ${obj.id_number}         </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">出借人</span><span style="font-family: 宋体; font-size: 10.5pt">：________</span><span style="font-family: 宋体; font-size: 10.5pt">，</span><span style="font-family: 宋体; font-size: 10.5pt">身份证号码：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                           </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">借款人</span><span style="font-family: 宋体; font-size: 10.5pt">今</span><span style="font-family: 宋体; font-size: 10.5pt">借到</span><span style="font-family: 宋体; font-size: 10.5pt">人民币大写：</span><span style="font-family: 宋体; font-size: 10pt; text-decoration: underline;"> ${bid_camount} </span><span style="font-family: 宋体; font-size: 10.5pt">元整</span><span style="font-family: 宋体; font-size: 10.5pt">，小写：<span style="font-family: 宋体; font-size: 10pt; text-decoration: underline;"> ${lower_camount} </span>元整
				</span><span style="font-family: 宋体; font-size: 10.5pt">，</span><span style="font-family: 宋体; font-size: 10.5pt">期限为</span><span style="font-family: 宋体; font-size: 10pt; text-decoration: underline">   ${obj.apply_for_deadline}   </span><span style="font-family: 宋体; font-size: 10.5pt">月。借款人已收到上述借款合同的全部款项。出借人已经完全履行了《借款合同》中约定的支付出借款项的义务。借款人自愿按所签合同履行义务、承担责任。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">立此为</span><span style="font-family: 宋体; font-size: 10.5pt">据！</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 304.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 304.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">借款人：</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 304.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">担保人：</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 241.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">借款日期：     年    月   日 </span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; widows: 0">
				<span style="font-family: 宋体; font-size: 16pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 10.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 16pt; font-weight: normal">附表二：</span>
			</p>
			<p style="orphans: 0; height: 30pt;"></p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: center; text-indent: 21pt; widows: 0">
				<span style="font-family: 新宋体; font-size: 14pt; font-weight: normal">同意抵押声明</span>
			</p>
			<p style="orphans: 0; height: 20pt;"></p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">声明人：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">             </span><span style="font-family: 宋体; font-size: 10.5pt">身份证号：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">         </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">         </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">      </span><span style="font-family: 宋体; font-size: 10.5pt"> </span>
			</p>

			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 63pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">            </span><span style="font-family: 宋体; font-size: 10.5pt">身份证号：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">        </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">         </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">      </span><span style="font-family: 宋体; font-size: 10.5pt">     </span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">声明事项：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">同意抵押担保</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1、</span><span style="font-family: 宋体; font-size: 10.5pt">声明人与借款人系【</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">             </span><span style="font-family: 宋体; font-size: 10.5pt">】关系。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2、</span><span style="font-family: 宋体; font-size: 10.5pt">抵押担保金额及贷款用途：</span><span style="font-family: 宋体; font-size: 10.5pt">借款人</span><span style="font-family: 宋体; font-size: 10.5pt">于</span><span style="font-family: 宋体; font-size: 10.5pt">【</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">      </span><span style="font-family: 宋体; font-size: 10.5pt">】年【</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span
					style="font-family: 宋体; font-size: 10.5pt">】月【</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline"> </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt">】日向出借人申请的【</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">   </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">    </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">    </span><span style="font-family: 宋体; font-size: 10.5pt">】万元借款，该借款用于【</span><span
					style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">           </span><span style="font-family: 宋体; font-size: 10.5pt">】经营活动。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3、</span><span style="font-family: 宋体; font-size: 10.5pt">声明人同意将</span><span style="font-family: 宋体; font-size: 10.5pt">其拥有所有权和处分权的房屋</span><span style="font-family: 宋体; font-size: 10.5pt">抵押</span><span style="font-family: 宋体; font-size: 10.5pt">，为借款人所借款项做抵押担保。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">4、</span><span style="font-family: 宋体; font-size: 10.5pt">抵押人承诺该抵押房产并非本人及本人抚养家属的生活必需品，并保证不以此为由，抗辩抵押权人对该抵押房产的执行。若在该笔借款到期时本人人无力偿还借款，将自愿搬离该住所。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">5、</span><span style="font-family: 宋体; font-size: 10.5pt">以上声明事实真实、有效。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">特此声明</span><span style="font-family: 宋体; font-size: 10.5pt">！</span><span style="font-family: 宋体; font-size: 10.5pt">               </span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 283.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 283.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">声明人（签名）</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 283.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 283.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">签字日期：   年   月   日</span>
			</p>
		</div>
		<br style="clear: both; mso-break-type: section-break; page-break-before: always" />
		<div>
			<p style="line-height: 24pt; margin: 0pt; orphans: 0; text-align: center; widows: 0">
				<span style="font-family: 宋体; font-size: 16pt; font-weight: bold">担保合同</span>
			</p>
			<p style="orphans: 0; height: 40pt;"></p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">甲方（债权人）：</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">乙方（债务人）：</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">丙方（担保人）：</span><span style="font-family: 宋体; font-size: 10.5pt">       </span><span style="font-family: 宋体; font-size: 10.5pt">身份证号：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                               </span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第一条 保证担保的范围：主债权及利息、债务人应支付的违约金（包括罚息）和损害赔偿金以及实现债权的费用（包括诉讼费、</span><a style="color: #000000" href="http://www.chinalawedu.com/falvzixun/" target="http://www.chinalawedu.com/web/208/_blank"><span style="font-family: 宋体; font-size: 10.5pt">律师</span></a><span style="font-family: 宋体; font-size: 10.5pt">费</span><span style="font-family: 宋体; font-size: 10.5pt">等）</span><span style="font-family: 宋体; font-size: 10.5pt">。</span><span style="font-family: 宋体; font-size: 10.5pt">被保证的主债权</span><span style="font-family: 宋体; font-size: 10.5pt">金</span><span style="font-family: 宋体; font-size: 10.5pt">额：_________.</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第二条 保证担保方式</span><span style="font-family: 宋体; font-size: 10.5pt">：</span><span style="font-family: 宋体; font-size: 10.5pt">连带责任保证，如债务人没有按主合同约定履行或者没有全部履行其债务，债权人有权直接要求保证人承担保证责任。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">连带共同保证的债务人在主合同规定的债务履行期届满没有履行债务的，债权人可以要求债务人履行债务，也可以要求任何一个保证人承担全部保证责任。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第三条 保证责任</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1.保证期间</span><span style="font-family: 宋体; font-size: 10.5pt">：</span><span style="font-family: 宋体; font-size: 10.5pt">自本合同生效之日起至</span><span style="font-family: 宋体; font-size: 10.5pt">借款</span><span style="font-family: 宋体; font-size: 10.5pt">合同</span><span style="font-family: 宋体; font-size: 10.5pt">中的借款金额全部结清</span><span style="font-family: 宋体; font-size: 10.5pt">之日止。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2.保证期间，债权人依法将主债权转让给第三人的，</span><span style="font-family: 宋体; font-size: 10.5pt">经债权人告知债务人及</span><span style="font-family: 宋体; font-size: 10.5pt">保证人</span><span style="font-family: 宋体; font-size: 10.5pt">后，债务人及保证人同意</span><span style="font-family: 宋体; font-size: 10.5pt">在原保证担保的范围内继续承担保证责任。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3</span><span style="font-family: 宋体; font-size: 10.5pt">.债权人与债务人协议变动主合同内容，但并未实际履行的，保证人仍应当承担保证责任。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">4</span><span style="font-family: 宋体; font-size: 10.5pt">.同一债权既有保证又有第三人提供物的担保的，债权人可以请求保证人或者物的担保人承担担保责任</span><span style="font-family: 宋体; font-size: 10.5pt">；</span><span style="font-family: 宋体; font-size: 10.5pt">物的担保合同被确认无效或者被撤销，或者担保物因不可抗力的原因灭失而没有代位物的，保证人仍应当按合同的约定或者法律的规定承担保证责任。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第四条 保证人权利义务</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1.保证期间，保证人发生机构变更、撤销或其他足以影响其保证能力的变故，保证人应提前</span><span style="font-family: 宋体; font-size: 10.5pt">十</span><span style="font-family: 宋体; font-size: 10.5pt">天书面通知债权人，本合同项下的全部义务由变更后的机构承担或由保证人在</span><span style="font-family: 宋体; font-size: 10.5pt">十</span><span style="font-family: 宋体; font-size: 10.5pt">日之内为</span><span style="font-family: 宋体; font-size: 10.5pt">本保证合同落实债权人</span><span style="font-family: 宋体; font-size: 10.5pt">所接受的新的保证人。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2.保证期间，保证人不得向第三方提供超出其自身负担能力的担保。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3.本合同的主合同既有保证又有物的担保的，保证人</span><span style="font-family: 宋体; font-size: 10.5pt">同意对主合同的所有主债权及利息，违约金以及实现债权的费用承担保证责任，自愿放弃“</span><span style="font-family: 宋体; font-size: 10.5pt">对物的担保以外的债权承担保证责任</span><span style="font-family: 宋体; font-size: 10.5pt">”的抗辩权。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">4</span><span style="font-family: 宋体; font-size: 10.5pt">.本合同保证期间内，保证人如再向他人提供担保，不得损害债权人的利益，并须征得债权人的同意。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第五条 债权人权利义务</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1.保证期间，债权人有权对保证人的资金和财产状况进行监督，有权要求保证人提供其财务报表等资料，保证人应如实提供。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2.发生下列情况之一，债权人有权要求保证人提前承担保证责任，保证人同意提前承担保证责任：</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">（1）保证人违反本合同的约定或者发生其他严重违约行为；</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">（2）主合同履行期间，债务人死亡、宣告失踪或丧失民事行为能力致使债权人债权落空，或者债务人有违约情形等。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3.在订立保证合同之前，债权人有权以债务人提供的保证人不具备清偿能力为由拒绝与其签订保证合同；但保证合同一经订立，保证人是否具有清偿能力并不影响保证合同的有效性。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第六条 保证人违约责任</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1.保证人不承担保证责任或者违反本合同约定的其他义务，因此给债权人造成经济损失且违约金数额不足以弥补所受损失的，应赔偿债权人的实际经济损失。对上述违约金、赔偿金以及保证人未承担保证责任的金额、利息和其他费用，债权人有权直接用保证人存款账户中的资金予以抵销。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2.债务人与保证人共同欺骗债权人，订立主合同和保证合同的，债权人可以请求人民法院予以撤销。因此给债权人造成损失的，由保证人与债务人承担连带赔偿责任。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3.本保证书在主合同生效时同时生效，即对保证人构成合法、有效和具约束力的义务</span><span style="font-family: 宋体; font-size: 10.5pt">。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">4</span><span style="font-family: 宋体; font-size: 10.5pt">.保证人没有拖欠任何应付之其他债务，亦未在保证人已签下的任何契约、信托契约、协议或其他文件中发生或因任何事情的发生和存在而构成任何文件中所定下的违约事件；</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">七</span><span style="font-family: 宋体; font-size: 10.5pt">条 争议的处理</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1.本合同受中华人民共和国法律管辖并按其进行解释。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2.本合同在履行过程中发生的争议，由双方当事人协商解决，协商或调解不成的，依法向</span><span style="font-family: 宋体; font-size: 10.5pt">合同签订地的</span><span style="font-family: 宋体; font-size: 10.5pt">人民法院起诉。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">八</span><span style="font-family: 宋体; font-size: 10.5pt">条 合同变更解除</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">本合同有效期内，合同任何一方不得擅自变更或解除合同。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">九</span><span style="font-family: 宋体; font-size: 10.5pt">条 合同的解释</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">本合同未尽事宜或条款内容不明确，合同双方当事人可以根据本合同的原则、合同的目的、交易习惯及关联条款的内容，按照通常理解对本合同作出合理解释。该解释具有约束力，除非解释与法律或本合同相抵触。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第十条 补充与附件</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">本合同未尽事宜，依照有关法律、</span><a style="color: #000000" href="http://www.chinalawedu.com/falvfagui/" target="http://www.chinalawedu.com/web/208/_blank"><span style="font-family: 宋体; font-size: 10.5pt">法规</span></a><span style="font-family: 宋体; font-size: 10.5pt">执行，法律、法规未作规定的，双方可以达成书面补充合同。本合同的附件和补充合同均为本合同不可分割的组成部分，与本合同具有同等的法律效力。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第十</span><span style="font-family: 宋体; font-size: 10.5pt">一</span><span style="font-family: 宋体; font-size: 10.5pt">条 保证合同效力</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1.本合同的效力独立于被保证的主合同，主合同无效并不影响本合同的效力。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2</span><span style="font-family: 宋体; font-size: 10.5pt">.本合同自双方或双方法定代表人或其授权代表人签字并加盖单位公章或合同专用章之日起生效</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3</span><span style="font-family: 宋体; font-size: 10.5pt">.本合同正本一式</span><span style="font-family: 宋体; font-size: 10.5pt">3</span><span style="font-family: 宋体; font-size: 10.5pt">份，</span><span style="font-family: 宋体; font-size: 10.5pt">三</span><span style="font-family: 宋体; font-size: 10.5pt">方各执</span><span style="font-family: 宋体; font-size: 10.5pt">1</span><span style="font-family: 宋体; font-size: 10.5pt">份，具有同等法律效力。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">债权人（签章）</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline;">      </span><span style="font-family: 宋体; font-size: 10.5pt; margin-left: 30pt">债务人（签章）</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline;">     　</span><span style="font-family: 宋体; font-size: 10.5pt; margin-left: 30pt">担保人（签章）</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">      </span>
			</p>
			<p style="orphans: 0; height: 24pt"></p>

			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 336pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">签订地点：__________</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-align: justify; text-indent: 336pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt"> ______年____月____日</span>
			</p>
			<p style="orphans: 0; height: 240pt"></p>
		</div>
		<br style="clear: both; mso-break-type: section-break; page-break-before: always" />
		<div>
			<p style="margin: 0pt; orphans: 0; text-align: center; text-indent: 10pt; widows: 0">
				<span style="font-family: 宋体; font-size: 16pt">债权转让协议</span>
			</p>
			<p style="orphans: 0; height: 40pt"></p>
			<p style="line-height: 20pt; margin: 0pt 0pt 0pt 11.95pt; orphans: 0; text-indent: 10.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">甲方（债权出让方）：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">          　　</span><span style="font-family: 宋体; font-size: 10.5pt">身份证号：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                      </span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; padding-left: 21pt; text-indent: -21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">地址：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">             　　　　　　　　</span><span style="font-family: 宋体; font-size: 10.5pt">联系方式：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                      </span><br /> <span style="font-family: 宋体; font-size: 10.5pt">乙方（债权受让方）：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">          　　</span><span style="font-family: 宋体; font-size: 10.5pt">身份证号：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                      </span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; padding-left: 10.5pt; text-indent: -10.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">地址：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">               　　　　　　</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">联系方式：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                      </span>
			</p>
			<p style="line-height: 20pt; margin: 0pt 0pt 0pt 11.95pt; orphans: 0; text-indent: 10.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">丙方（债务人）</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">　　　　　　　　　　　 　　</span><span style="font-family: 宋体; font-size: 10.5pt">身份证号：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                  　　　　</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; padding-left: 10.5pt; text-indent: -10.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">地址：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">              　　　　　　　</span><span style="font-family: 宋体; font-size: 10.5pt">联系方式：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">                     　</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">甲乙双方按照诚实信用原则，依据中华人民共和国</span><span style="font-family: 宋体; font-size: 10.5pt">《</span><a style="color: #000000" href="http://www.66law.cn/tiaoli/4.aspx" target="http://www.66law.cn/topic2010/zqzr/_blank"><span style="font-family: 宋体; font-size: 10.5pt">合同法</span></a><span style="font-family: 宋体; font-size: 10.5pt">》、《</span><a style="color: #000000" href="http://www.66law.cn/tiaoli/20.aspx" target="http://www.66law.cn/topic2010/zqzr/_blank"><span style="font-family: 宋体; font-size: 10.5pt">民法通则</span></a><span style="font-family: 宋体; font-size: 10.5pt">》、《</span><a style="color: #000000" href="http://www.66law.cn/tiaoli/12.aspx"
					target="http://www.66law.cn/topic2010/zqzr/_blank"><span style="font-family: 宋体; font-size: 10.5pt">民事诉讼法</span></a><span style="font-family: 宋体; font-size: 10.5pt">》</span><span style="font-family: 宋体; font-size: 10.5pt">等有关法律规定，经双方协商一致，就甲方向乙方转让其拥有的债权事宜达成如下协议：</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第一条 债权转让内容</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1.</span><span style="font-family: 宋体; font-size: 10.5pt">1</span><span style="font-family: 宋体; font-size: 10.5pt"> 甲方保证本合同转让给乙方的债权为甲方合法拥有，甲方拥有完全、有效的处分权。转让债权为：甲方同丙方于</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">   </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt">年</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">     </span><span style="font-family: 宋体; font-size: 10.5pt">月</span><span
					style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">    </span><span style="font-family: 宋体; font-size: 10.5pt">日签订的《</span><span style="font-family: 宋体; font-size: 10.5pt">抵押借款合同</span><span style="font-family: 宋体; font-size: 10.5pt">》中约定的所有甲方对丙方的债权（包括但不限于借款本金</span><span style="font-family: 宋体; font-size: 10.5pt">【</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">     </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">   </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">】</span><span
					style="font-family: 宋体; font-size: 10.5pt">元、利息</span><span style="font-family: 宋体; font-size: 10.5pt">【</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">   </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">  </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">    </span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">】</span><span style="font-family: 宋体; font-size: 10.5pt">元、罚息、违约金、诉讼费（或仲裁费）、律师费、差旅费、保全费、公告费、保险费、评估费、拍卖费、保管费、鉴定费等其他合理费用）</span><span style="font-family: 宋体; font-size: 10.5pt">共计【</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">             
				</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">】</span><span style="font-family: 宋体; font-size: 10.5pt">元。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">1.2</span><span style="font-family: 宋体; font-size: 10.5pt"> 乙方同意按本协议的条款和条件从甲方受让该债权。</span><span style="font-family: 宋体; font-size: 10.5pt">（</span><span style="font-family: 宋体; font-size: 10.5pt">因债权转让价款及支付方式涉及商业秘密，甲乙双方另行书面约定</span><span style="font-family: 宋体; font-size: 10.5pt">）</span><span style="font-family: 宋体; font-size: 10.5pt">。</span><br /><span style="font-family: 宋体; font-size: 10.5pt"> 　</span><span style="font-family: 宋体; font-size: 10.5pt">1.3 甲方在签订本协议之日起3日内，将其合法拥有上述债权的相关依据向乙方交割完毕。</span><br /><span style="font-family: 宋体; font-size: 10.5pt">  第</span><span style="font-family: 宋体; font-size: 10.5pt">二</span><span
					style="font-family: 宋体; font-size: 10.5pt">条 债务履行</span><br /><span style="font-family: 宋体; font-size: 10.5pt"> 　</span><span style="font-family: 宋体; font-size: 10.5pt">2.</span><span style="font-family: 宋体; font-size: 10.5pt">1 丙方</span><span style="font-family: 宋体; font-size: 10.5pt">知情并</span><span style="font-family: 宋体; font-size: 10.5pt">同意在债权转让完成后向乙方偿还债务，该债务包括上述</span><span style="font-family: 宋体; font-size: 10.5pt">第一条规定中的所有费用。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">2</span><span style="font-family: 宋体; font-size: 10.5pt">.2  丙方向乙方偿债的期限如下</span><span style="font-family: 宋体; font-size: 10.5pt">：</span><span style="font-family: 宋体; font-size: 10.5pt">自本协议签订之日起至</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">      </span><span style="font-family: 宋体; font-size: 10.5pt">年____月____日止</span><span style="font-family: 宋体; font-size: 10.5pt">，如约履行本合同项下所有债务</span><span style="font-family: 宋体; font-size: 10.5pt">。</span><br /><span style="font-family: 宋体; font-size: 10.5pt">  第</span><span style="font-family: 宋体; font-size: 10.5pt">三</span><span style="font-family: 宋体; font-size: 10.5pt">条 陈述、保证和承诺</span>
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span><br /><span style="font-family: 宋体; font-size: 10.5pt">　　3</span><span style="font-family: 宋体; font-size: 10.5pt">.1 甲方承诺并保证其依法设立并有效存续，有权实施本协议项下的债权转让并能够独立承担民事责任。其转让的债权系合法、有效的债权。</span><br /><span style="font-family: 宋体; font-size: 10.5pt">　　</span><span style="font-family: 宋体; font-size: 10.5pt">3</span><span style="font-family: 宋体; font-size: 10.5pt">.2 乙方承诺并保证：</span><span style="font-family: 宋体; font-size: 10.5pt">乙方</span><span style="font-family: 宋体; font-size: 10.5pt">依法设立并有效存续，有权受让本协议项下的债权并能独立承担民事责任；其受让本协议项下的债权已经获得其内部相关权力机构的授权或批准。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">3</span><span style="font-family: 宋体; font-size: 10.5pt">.3 丙方承诺并保证：</span><span style="font-family: 宋体; font-size: 10.5pt">丙方具有完全民事行为能力（或是</span><span style="font-family: 宋体; font-size: 10.5pt">依法设立并有效存续</span><span style="font-family: 宋体; font-size: 10.5pt">的法人）</span><span style="font-family: 宋体; font-size: 10.5pt">其自愿并有能力按照本协议约定向乙方清偿上述债务。</span><br /><span style="font-family: 宋体; font-size: 10.5pt">  第</span><span style="font-family: 宋体; font-size: 10.5pt">四</span><span style="font-family: 宋体; font-size: 10.5pt">条 合同的解除</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">甲乙双方经协商同意，可以变更或者解除本合同。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第</span><span style="font-family: 宋体; font-size: 10.5pt">五</span><span style="font-family: 宋体; font-size: 10.5pt">条 违约责任</span><span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span><br /> <span style="font-family: 宋体; font-size: 10.5pt">  各方同意，如果一方违反其在本协议中所作的陈述、保证、承诺或任何其他义务，致使其他方遭受或发生损害、损失、索赔、处罚、诉讼仲裁、费用、义务和/或责任，违约方须向另一方作出全面赔偿并使之免受其害。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">第六条 其他规定</span><br /><span style="font-family: 宋体; font-size: 10.5pt">　　</span><span style="font-family: 宋体; font-size: 10.5pt">6</span><span style="font-family: 宋体; font-size: 10.5pt">.1 对本协议所作的任何修改及补充必须采用书面形式并由各方合法授权代表签署。</span><br /><span style="font-family: 宋体; font-size: 10.5pt">　　</span><span style="font-family: 宋体; font-size: 10.5pt">6</span><span style="font-family: 宋体; font-size: 10.5pt">.2 在本协议履行过程中发生的纠纷，双方应友好协商解决；协商不成的，任何一方均有权向甲方所在地人民法院提起诉讼。</span><br /><span style="font-family: 宋体; font-size: 10.5pt">　　6.3 本协议一式三份，甲乙丙各方各执一份，具有同等效力。</span><br /><span style="font-family: 宋体; font-size: 10.5pt">　　6.4 本协议于各方授权代表签署后生效。</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">甲方(</span><span style="font-family: 宋体; font-size: 10.5pt">签</span><span style="font-family: 宋体; font-size: 10.5pt">章)：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">        </span><span style="font-family: 宋体; font-size: 10.5pt">    </span><span style="font-family: 宋体; font-size: 10.5pt">乙方(</span><span style="font-family: 宋体; font-size: 10.5pt">签</span><span style="font-family: 宋体; font-size: 10.5pt">章)：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">        </span><span style="font-family: 宋体; font-size: 10.5pt">    丙方（签章）</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">        </span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 21pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 178.5pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">&#xa0;</span>
			</p>
			<p style="line-height: 20pt; margin: 0pt; orphans: 0; text-indent: 210pt; widows: 0">
				<span style="font-family: 宋体; font-size: 10.5pt">签订时间</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: none">：</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">        </span><span style="font-family: 宋体; font-size: 10.5pt">年</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">      </span><span style="font-family: 宋体; font-size: 10.5pt">月</span><span style="font-family: 宋体; font-size: 10.5pt; text-decoration: underline">      </span><span style="font-family: 宋体; font-size: 10.5pt">日</span>
			</p>
			<p style="line-height: 23pt; margin: 0pt; orphans: 0; widows: 0">
				<span style="font-family: 'Times New Roman'; font-size: 14pt">&#xa0;</span>
			</p>
		</div>
	</div>
	<div class="layui-form-item btn-item margin-top-50">
		<div class="layui-input-block page-but margin-left-150">
			<button type="button" id="print" class="layui-btn confirm-but layui-btn-normal">打印</button>
			<button type="button" class="layui-btn layui-btn-primary cancel-but" onclick="back()">取消</button>
		</div>
	</div>

</div>

<script src="/riskManagement/view/printingContract/printingContract.js"></script>

<script>
	$(document).ready(function() {
		//打印
		$("#print").click(function() {
			$(".print-box").printArea();
		});
	});
</script>

<%@ include file="/riskManagement/templates/footer.jsp"%>