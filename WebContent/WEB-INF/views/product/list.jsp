<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/meta1.jsp" />
<title>产品列表 - <smt:dict code="company.name" /></title>
<style>
.news-list li{
	padding-left: 10px;
}
.productImg{
	margin-left: 4%;
    float:left;
}
.productP{
	
    font-size: 16px;
}
.productH3{
    font-size: 21px;
    
}
.productDiv2{
	margin-top: -13%;
    margin-left: 28%;
    width: 30%;
}
</style>
</head> 

<body class="open">
<div id="main-container">
	<%-- <div class="inner-wrap">
		<ul class="news-list clearfix">
			<c:forEach var="obj" items="${page.content}">
			<li class="clearfix">
				<div class="news-img">
					<a title="${obj.name}" href="product/${obj.id}.html" class="img">
						<img src="${obj.image}" alt="${obj.name}" />
					</a>
					<div class="bl"></div>
				</div> 
				<h2><a href="product/${obj.id}.html">${obj.name}</a></h2>
				<p class="desc">${obj.shortDescription}</p>
				<a href="product/${obj.id}.html" class="more">查看详情>></a>
			</li>
			</c:forEach>
		</ul>
	</div> --%>
	<%-- <ul class="btns">
		<li><a class="up"></a></li>
		<li><a class="tel" href="<smt:dict code="company.phone" />"></a>
			<div class="info"><p>咨询热线<br /><smt:dict code="company.phone" /></p></div>
		</li> 
		<li><a class="qq" href="<smt:dict code="company.onlineqq.url" />" target="_blank"></a>
			<div class="info"><p class="qq">点击我，在线咨询</p></div>
		</li>
	</ul> --%>
	<div class="productDiv">
		
		<p class="productP">
		<span class="productImg"><img alt="" src="upload/images/pc/download/GuxiNo1.jpg"></span>
		
		<span class="productH3">&nbsp;&nbsp;&nbsp;&nbsp;古玺1号</span><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月度盈利3.5％、季度盈利14.8％、年度盈利39.2 %，最大回撤7.5％
		</p>
	
	</div>
</div>

<div class="sub-nav">
	<div class="news-cate"> 
		<a class="cur" href="javascript:;">产品列表</a>
	</div>
	<div class="news-cate-dropdown">
		<button>产品列表</button>
	</div>
</div>

<aside class="main" style="background: rgba(24, 37, 72, .99); color: #fff;">
<h1><a href="index.html"><img alt="logo图片" src="upload/images/logo.png" width="100%" /></a></h1><br>
<div class="qrcode aside-container"><!-- <img src="upload/images/qrcode.jpg" /><p>扫一扫微信二维码<i></i></p> -->
</div>
<nav class="aside-container">
	<ul>
		<li><a href="index.html">网站首页</a></li>
		<li><a href="software/list.html">公司介绍</a></li>
		<!-- <li><a href="yewu/list.html">业务</a></li> -->
		<li><a href="info/list">最新资讯</a></li>
		<li><a class="cur" href="product/list">产品列表</a></li>
	</ul>
	</nav>
<footer>
<br />
<smt:dict code="site.copyright" />
</footer>
</aside>
<script src="resources/js/jquery-1.9.1.js"></script>
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
})

function initSimplePagination(selector, url){
	var pageNumber = parseInt($(selector).attr('page'));
	var totalPages = parseInt($(selector).attr('totalPages'));
	var prevPageNumber;
	var nextPageNumber;
	if (pageNumber>2){
		prevPageNumber = pageNumber - 1;
	} else{
		prevPageNumber = 1;
	}
	if (pageNumber<totalPages){
		nextPageNumber = pageNumber + 1;
	} else{
		nextPageNumber = totalPages;
	}
	
	$(selector +' a[page=' + pageNumber + ']').addClass('active');
	
	if(url.indexOf('?')==-1){
		url = url + '?';
	}
	else{
		url = url + '&';
	}
	$(selector + ' .first').click(function(){
		toLocation(url + "pageNumber=1");
	});
	$(selector + ' .prev').click(function(){
		toLocation(url + "pageNumber=" + prevPageNumber);
	});
	$(selector + ' .next').click(function(){
		toLocation(url + "pageNumber=" + nextPageNumber);
	});
	$(selector + ' .last').click(function(){
		toLocation(url + "pageNumber=" + totalPages);
	});

	$(selector +' a[page]').click(function(){
		var pageNumber = $(this).attr('page');
		toLocation(url + "pageNumber=" + pageNumber);
	});
}

function toLocation(location) {
	var base = $('base').attr('href');
	document.location.href = (base + location);
};

var url = 'info/list?a=a<c:if test="${cond.typeId ne null}">&typeId=${cond.typeId}</c:if>';
initSimplePagination('.pages', url);
</script>
</body>
</html>