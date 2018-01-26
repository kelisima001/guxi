<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/meta1.jsp" />
<title>软件下载 - <smt:dict code="company.name" /></title>
</head> 
<body class="case-page open">
<div id="main-container">
	<div class="inner-wrap">
		<ul class="cases">
			<c:forEach var="software" items="${softwares}">
	  		<li>
				<div class="case-img">
					<div class="img-box"> 
					<img src="${software.image}" alt="${software.name}">	
					</div>
					<a class="cover" href="software/${software.id}.html"></a>
					<div class="ck"></div>
				</div>
				<div class="intro">
					<h2><a href="software/${software.id}.html">${software.name}</a></h2> 
					<p>${software.name}</p>
					<a class="cover"></a>
				</div>
			</li>
			</c:forEach>
		</ul>
		<%-- <ul class="btns">
			<li><a class="up"></a></li>
			<li><a class="tel" href="tel:021-31208888"></a>
				<div class="info"><p>咨询热线<br><smt:dict code="company.phone" /></p></div>
			</li> 
			<li><a class="qq" href="<smt:dict code="company.onlineqq.url" />" target="_blank"></a>
				<div class="info"><p class="qq">点击我，在线咨询</p></div>
			</li>
		</ul> --%>
	</div>
<div class="sub-nav">
	<div class="news-cate"> 
		<a class="cur" href="javascript:;">公司介绍</a>
 		<!--a href="#">高新科技</a>
		<a href="#">汽车贸易</a-->
	</div>
	<div class="news-cate-dropdown">
		<button>公司介绍</button>
		<!--ul>
			<li><a href="#">全部</a></li>
 			<li><a href="#">高新科技</a></li>
			<li><a href="#">汽车贸易</a></li>
		</ul-->
	</div>
</div>

<aside class="main" style="background: rgba(24, 37, 72, .99); color: #fff;">
<h1><a href="#"><img alt="logo图片" src="upload/images/logo.png" width="100%"></a></h1>
<div class="qrcode aside-container"><!-- <img src="upload/images/qrcode.jpg"><p>扫一扫微信二维码<i></i></p> -->
</div>
<nav class="aside-container">
	<ul>
		<li><a href="index.html">网站首页</a></li>
		<li><a class="cur" href="javascript:;">公司介绍</a></li>
		<li><a href="info/list">最新资讯</a></li>
		<li><a href="product/list">产品列表</a></li>
	</ul>
</nav>
<footer>
<br>
<smt:dict code="site.copyright" /></footer>
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
	})
</script>

 </body>
 </html>