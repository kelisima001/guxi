<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/meta1.jsp" />
<link rel="stylesheet" href="resources/css/reachContentFix.css" />
<title>${obj.name} - <smt:dict code="company.name" /></title>
<style>
article{
	padding-right: 10px;
}
</style>
</head> 
<body class="details-page open">
	<div id="main-container">
		<div class="inner-wrap">
			<article>
				<h1>${obj.name}</h1>
				<p class="info">
					发布时间：<fmt:formatDate value="${obj.timeCreated}" pattern="yyyy-MM-dd hh:mm:ss"/>
				</p>
				<div class="content" style="margin-bottom: 50px;">
					${obj.descriptionUnEscaped}
				</div>
				
				<div>
				<div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone"></a><a href="#" class="bds_tsina" data-cmd="tsina"></a><a href="#" class="bds_tqq" data-cmd="tqq"></a><a href="#" class="bds_renren" data-cmd="renren"></a><a href="#" class="bds_weixin" data-cmd="weixin"></a></div>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
				</div>
			</article>
		</div>
		<%-- <ul class="btns">
			<li><a class="up"></a></li>
			<li><a class="tel" href="tel:<smt:dict code="company.phone" />"></a>
				<div class="info">
					<p>
						咨询热线<br><smt:dict code="company.phone" />
					</p>
				</div>
			</li>
			<li>
				<a class="qq" href="<smt:dict code="company.onlineqq.url" />" target="_blank"></a>
				<div class="info">
					<p class="qq">点击我，在线咨询</p>
				</div>
			</li>
		</ul> --%>
	</div>
	<div class="sub-nav">
		<ul class="btn">
			<li>
				<a href="product/list">
					<img src="resources/images/home.png"><span style="margin-left: 5px" class="yc">${obj.type.name}</span>
				</a>
			</li>
		</ul>
	</div>
	<aside class="main" style="background: rgba(24, 37, 72, .99); color: #fff;">
		<h1>
			<a href="index.html"><img alt="logo图片" src="upload/images/logo.png" width="100%"></a>
		</h1>
		<br />
		<div class="qrcode aside-container">
			<!-- <img src="upload/images/qrcode.jpg">
			<p>
				扫一扫微信二维码<i></i>
			</p> -->
		</div>
		<nav class="aside-container">
			<ul>
				<li><a href="index.html">网站首页</a></li>
				<!-- <li><a href="software/list.html">软件下载</a></li> -->
				<li><a href="#">公司介绍</a></li>
				<li><a href="info/list">最新资讯</a></li>
				<li><a class="cur" href="product/list">产品列表</a></li>
			</ul>
		</nav>

		<footer>
			<br> <smt:dict code="site.copyright" />
		</footer>
	</aside>
<script src="resources/js/jquery-1.9.1.js"></script>
<script src="resources/js/jquery.qrcode.min.js"></script>
<script>
	$(".sub-nav .switch").click(function(){ 
		if($('body').hasClass('open')){
			$(this).attr('data-icon',9);		
			$('body').removeClass('open').addClass('close');
		}else{
			$(this).attr('data-icon',8);
			$('body').removeClass('close').addClass('open');
		}
		
	});
	$(".btns .up").click(function(){ 
		$("html,body").animate({scrollTop:0},600);
	});
	$(".news-cate-dropdown button").click(function(){
		var box=$(".news-cate-dropdown");
		if(box.hasClass("active")){
			box.removeClass("active");
		}else{
			box.addClass('active');
		}
	});
</script>

 </body>
 
 </html>