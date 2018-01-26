<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/meta1.jsp" />
<link rel="stylesheet" href="resources/css/reachContentFix.css" />
<title>${obj.name} - <smt:dict code="company.name" /></title>
</head> 
<body class="details-page open">
	<div id="main-container">
		<div class="inner-wrap">
			<article>
				<h1>${obj.name}</h1>
				
				<p class="info">
					${obj.shortDescription}
				</p>
				<div class="content">
					${obj.descriptionUnEscaped}
				</div>
				<div>
					<br />
					<a href="${software.url}" target="blank" style="color: #2ED0B7; font-weight: bold;">点击立即下载</a>
				</div>
				<div class="recommend-news" style="visibility:hidden;">
					<div class="caption">
						<h3></h3>
					</div>
					<ul class="items">
						
					</ul>
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
				<a href="software/list.html">
					<img src="resources/images/home.png"><span style="margin-left: 5px" class="yc">软件下载</span>
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
				<li><a class="cur" href="software/list.html">公司介绍</a></li>
				<li><a  href="info/list">最新资讯</a></li>
				<li><a href="product/list">产品列表</a></li>
			</ul>
		</nav>

		<footer>
			<br> <smt:dict code="site.copyright" />
		</footer>
	</aside>
<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
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