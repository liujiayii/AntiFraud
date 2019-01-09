<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</div>
</div>
<div class="layui-footer">
	<!-- 底部固定区域 -->
	©2018 讴业普惠 All rights resered <span style="padding-left: 20px;">石家庄云阙网络科技有限公司</span>
</div>
</div>

<script>
	//JavaScript代码区域
	layui.use([ 'element', 'layer' ], function() {
		var element = layui.element, layer = layui.layer;

		//业务报单、资产评估、业务反馈图片
		var loc = window.location.href
		console.log(loc)
		if (loc.match('EvaluationInfo') || loc.match('MortgageInfo')) {
			if (formImgUrl.data.length === 0) {
				$('.imgList').append($($('.imgBox')[0]).clone());
				$($('.imgBox img')[0]).attr('src', '../../images/nodata.png');
			} else {
				for (var i = 0; i < formImgUrl.data.length; i++) {
					console.log(i)
					$('.imgList').append($($('.imgBox')[0]).clone());
					$($('.imgBox img')[i]).attr('src', formImgUrl.data[i].img_url);
				}
			}

		}

		// 业务报单、资产评估、业务反馈图片layer
		layer.photos({
			photos : '#layer-photos-demo',
			anim : 0,//0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
			area : 'auto',
			maxWidth : 800,
			tab : function(pic, layero) {
				console.log(layero) //当前图片的一些信息
				//layero['0'].style.top = '';
				$('#layui-layer-photos').css('height','auto');
				$('.layui-layer-photos').css('top','');
			}
		});
		//抖动layer
		var name = $($('.layui-layout-right a')[0]).text();
		$($('.layui-layout-right .layui-nav-item')[0]).click(function() {
			layer.msg('欢迎您！ ' + name, function() {
			})
		})
		//表单验证
		$(document).ready(function() {
			$('input').attr('lay-vertype', 'alert');
			$('select').attr('lay-vertype', 'alert');
			$('textarea').attr('lay-vertype', 'alert');
		})

	});
</script>
</body>
</html>
<div class="imgBox">
	<img alt="" src="">
</div>