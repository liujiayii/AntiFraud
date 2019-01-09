//激活垂直导航栏
$(document).ready(function() {
	navActive(4);
	
	//打印合同的二级导航激活
    var printingContractHistory = document.referrer;
    if (printingContractHistory.match('car')) {
    	secondNavActive('#printingContract dd', 1)
    } else if (printingContractHistory.match('credit')) {
    	secondNavActive('#printingContract dd', 2)
    } else if (printingContractHistory.match('housing')) {
    	secondNavActive('#printingContract dd', 0)
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