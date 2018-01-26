<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/meta1.jsp" />
<title>最新资讯 - <smt:dict code="company.name" /></title>
</head> 

<body class="open">
<div id="main-container">
	<div class="inner-wrap">
		<ul class="news-list clearfix">
			<c:forEach var="info" items="${page.content}">
			<li class="clearfix">
				<div class="news-img">
					<a title="${info.title}" href="info/${info.id}.html" class="img">
						<img src="${info.image}" alt="${info.title }" />
					</a>
					<div class="bl"></div>
				</div> 
				<h2><a href="info/${info.id}.html">${info.title}</a></h2>
				<p class="info">时间：<fmt:formatDate value="${info.timeCreated}" pattern="yyyy-MM-dd hh:mm:ss"/><u>•</u> 点击：${info.viewCount} 次</p>
				<p class="desc">${info.abstraction}</p>
				<a href="info/${info.id}.html" class="more">查看详情>></a>
				<p class="date"><fmt:formatDate value="${info.timeCreated}" pattern="dd"/><span><fmt:formatDate value="${info.timeCreated}" pattern="MM"/></span></p>				
			</li>
			</c:forEach>
		</ul>

		<div class="pages" page="${page.pageNumber}" totalPages="${page.totalPages}">&nbsp;&nbsp;
			<a class="first" isFirst="${page.first}" href="javascript:;" title="第一页">&lt;&lt;</a>
			<a class="prev" href="javascript:;" title="上一页">&lt;</a>
			<c:forEach varStatus="status" begin="${page.beginPage}" end="${page.endPage}" step="1">
			<a href="javascript:;" page="${status.current}" class="num">${status.current}</a>
			</c:forEach>
			<a class="next" href="javascript:;" title="下一页">&gt;</a>
			<a class="last" href="javascript:;" title="最后一页">&gt;&gt;</a>
		</div>
	</div>
	<%-- <ul class="btns">
		<li><a class="up"></a></li>
		<li><a class="tel" href="<smt:dict code="company.phone" />"></a>
			<div class="info"><p>咨询热线<br /><smt:dict code="company.phone" /></p></div>
		</li> 
		<li><a class="qq" href="<smt:dict code="company.onlineqq.url" />" target="_blank"></a>
			<div class="info"><p class="qq">点击我，在线咨询</p></div>
		</li>
	</ul> --%>
</div>
<div class="sub-nav">
	<div class="news-cate"> 
		<a class="<c:if test="${cond.typeId eq null}">cur</c:if>" href="info/list">全部</a>
		<c:forEach var="type" items="${infoTypes}">
			<c:if test="${type.code!='info.type.market' && type.code!='info.type.company'}">
        	<a class="<c:if test="${cond.typeId eq type.id}">cur</c:if>" href="info/list?typeId=${type.id}">${type.name}</a>
        	</c:if>
        </c:forEach>
	</div>
			
	<div class="news-cate-dropdown">
		<button>最新资讯</button>
		<ul>
			<li><a href="info/list">全部</a></li>
 			<c:forEach var="type" items="${infoTypes}">
 				<li><a class="" href="info/list?typeId=${type.id}">${type.name}</a></li>
 			</c:forEach>
		</ul>
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
		<!-- <li><a href="software/listJinRong.jsp">互联网金融</a></li>
		<li><a href="software/listBaoshi.jsp">珠宝</a></li>
		<li><a href="software/listQiquan.jsp">外汇</a></li> -->
		<li><a class="cur" href="info/list">最新资讯</a></li>
		<li><a href="product/list">产品列表</a></li>
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