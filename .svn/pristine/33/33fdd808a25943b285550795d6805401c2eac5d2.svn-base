//激活垂直导航栏
$(document).ready(function() {
	$($('.layui-side .layui-nav-item')[4]).addClass('layui-nav-itemed');
	//打印合同的二级导航激活
    var printingContractHistory = document.referrer;
    console.log(printingContractHistory);

    if (printingContractHistory.match('car')) {
        $($('#printingContract dd')[1]).addClass('layui-this');
    } else if (printingContractHistory.match('credit')) {
        $($('#printingContract dd')[2]).addClass('layui-this');
    } else if (printingContractHistory.match('housing')) {
        $($('#printingContract dd')[0]).addClass('layui-this');
    }
});

// JQuery打印
(function($) {
	var printAreaCount = 0;
	$.fn.printArea = function() {
		var ele = $(this);
		var idPrefix = "printArea_";
		removePrintArea(idPrefix + printAreaCount);
		printAreaCount++;
		var iframeId = idPrefix + printAreaCount;
		var iframeStyle = 'position:absolute;width:0px;height:0px;left:-500px;top:-500px;';
		iframe = document.createElement('IFRAME');
		$(iframe).attr({
			style : iframeStyle,
			id : iframeId
		});
		document.body.appendChild(iframe);
		var doc = iframe.contentWindow.document;
		doc.open();
		$(document).find("link").filter(function() {
			return $(this).attr("rel").toLowerCase() == "stylesheet";
		}).each(function() {
			doc.write('<link type="text/css" rel="stylesheet" href="' + $(this).attr("href") + '" >');
		});
		doc.write('<div class="' + $(ele).attr("class") + '">' + $(ele).html() + '</div>');
		doc.close();
		var frameWindow = iframe.contentWindow;
		frameWindow.close();
		frameWindow.focus();
		// frameWindow.print();
		setTimeout(function() {
			frameWindow.print();
		}, 500);
	}
	var removePrintArea = function(id) {
		$("iframe#" + id).remove();
	};
})(jQuery);