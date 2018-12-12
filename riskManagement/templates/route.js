//垂直导航切换
function nav(index, url) {
	$($('.layui-side .layui-nav-item>a')[index]).click(function() {
		window.location.href = '/riskManagement/view/' + url;
	});
}
// 垂直导航激活
function navActive(index) {
	$($('.layui-side .layui-nav-item')[index]).addClass('layui-nav-itemed');
}
// 二级导航切换
function secondNav(path, index, url) {
	$($(path)[index]).click(function() {
		window.location.href = '/riskManagement/view/' + url;
	});
}
// 二级导航激活

function secondNavActive(path, index) {
	$($(path)[index]).addClass('layui-this');
}
// 返回
function back() {
	window.history.back();
	return false;
}
$(document).ready(function() {



	// assetEvaluation

	secondNav('#assetEvaluation dd', 0, 'assetEvaluation/housingEvaluation.jsp');
	secondNav('#assetEvaluation dd', 1, 'assetEvaluation/carEvaluation.jsp');
	secondNav('#assetEvaluation dd', 2, 'assetEvaluation/creditEvaluation.jsp');
	// businessFeedback

	secondNav('#businessFeedback dd', 0, 'businessFeedback/housingEvaluation.jsp');
	secondNav('#businessFeedback dd', 1, 'businessFeedback/carEvaluation.jsp');
	secondNav('#businessFeedback dd', 2, 'businessFeedback/creditEvaluation.jsp');

	// businessReport

	secondNav('#businessReport dd', 0, 'businessReport/housingMortgage.jsp');
	secondNav('#businessReport dd', 1, 'businessReport/carMortgage.jsp');
	secondNav('#businessReport dd', 2, 'businessReport/creditMortgage.jsp');

	// documentNav
	secondNav('#documentMangement dd', 0, 'documentMangement/contractAudit.jsp');
	secondNav('#documentMangement dd', 1, 'documentMangement/documentFiling.jsp');
	secondNav('#documentMangement dd', 2, 'documentMangement/documentBorrowing.jsp');

	// PrintingContract

	secondNav('#printingContract dd', 0, 'printingContract/housingPrintingContract.jsp');
	secondNav('#printingContract dd', 1, 'printingContract/carPrintingContract.jsp');
	secondNav('#printingContract dd', 2, 'printingContract/creditPrintingContract.jsp');
	secondNav('#printingContract dd', 3, 'printingContract/uploadContract.jsp');

	// managementAfterLoan

	secondNav('#managementAfterLoan dd', 0, 'managementAfterLoan/managementAfterLoan.jsp');
	// supplementaryFormalities

	secondNav('#supplementaryFormalities dd', 0, 'supplementaryFormalities/housingFormalities.jsp');
	secondNav('#supplementaryFormalities dd', 1, 'supplementaryFormalities/carFormalities.jsp');
	secondNav('#supplementaryFormalities dd', 2, 'supplementaryFormalities/creditFormalities.jsp');

	// collectionManagement
	secondNav('#collectionManagement dd', 0, 'collectionManagement/housingCollection.jsp');
	secondNav('#collectionManagement dd', 1, 'collectionManagement/carCollection.jsp');
	secondNav('#collectionManagement dd', 2, 'collectionManagement/creditCollection.jsp');
	// accessMangement
	secondNav('#accessMangement dd', 0, 'accessMangement/accessMangement.jsp');
	// superscriptManagement
	secondNav('#superscriptManagement dd', 0, 'superscriptManagement/superscriptManagement.jsp');
});