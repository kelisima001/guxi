<!DOCTYPE html>
<html>
<head>
<jsp:include page="include/meta.jsp" />
<!-- company.name -->
<title><smt:dict code="company.name" /></title>
<style type="text/css">
h1, h2 , h3, h4, p, li{font-family:microsoft yahei;}
.brand{background-image:url(upload/images/pc/prod/1.png);}
.weixin{background-image:url(upload/images/pc/prod/2.png);}
.shop{background-image:url(upload/images/pc/prod/3.png);}
.app{background-image:url(upload/images/pc/prod/4.png);}

#intro{padding:0;margin:0;height:0 !important;width:0;overflow:hidden !important;}
#intro .logo{float:left;margin:0 10px 10px 0;}

@media screen and (min-width:600px){
	.slide1{background-image:url(upload/images/pc/banner/b1.jpg);}
	.slide2{background-image:url(upload/images/pc/banner/b2.jpg);}
	.slide3{background-image:url(upload/images/pc/banner/b3.jpg);}
	.slide4{background-image:url(upload/images/pc/banner/b4.jpg);}
}
		
@media screen and (max-width:600px){
	.slide1{background-image:url(upload/images/mobile/banner/b1.jpg);}
	.slide2{background-image:url(upload/images/mobile/banner/b2.jpg);}
	.slide3{background-image:url(upload/images/mobile/banner/b3.jpg);}
	.slide4{background-image:url(upload/images/mobile/banner/b4.jpg);}
}
		
@media screen and (min-width:600px){
	.page2{background-image:url(upload/images/pc/about/aboutbg.jpg);}
	.page3{background-image:url(upload/images/pc/prod/prodbg.jpg);}
	.page4{background-image:url(upload/images/pc/download/downloadbg.jpg);}
	.page5{background-image:url(upload/images/pc/activity/activitybg.jpg);}
	.page7{background-image:url(upload/images/pc/contact/contactbg.jpg);}
}
@media screen and (max-width:600px){
	.page2{background-image:url(upload/images/mobile/about/aboutbg1.jpg);}
	.page3{background-image:url(upload/images/mobile/prod/prodbg1.jpg);}
	.page4{background-image:url(upload/images/mobile/download/downloadbg1.jpg);}
	.page5{background-image:url(upload/images/mobile/activity/activitybg1.jpg);}
	.page7{background-image:url(upload/images/mobile/contact/contactbg1.jpg);}
}

@media screen and (min-width:1050px){
	#index_x{ display:none}
}
</style>
</head> 
<script src="resources/js/jquery-1.11.1.min.js"></script>
<script>
$(document).ready(function(){
  $("#index_x").click(function(){
    $("#menu").hide();
  });
  $("#index_xs").click(function(){
    $("#menu").show();
  });
});
</script>
<body> 
<header id="header">
	<div class="container clearfix">
		<h1 id="logo"> <a href="index.html"><img alt="logo图片" src="upload/images/logo.png" /></a></h1>
		<nav>
			<a class="icon_menu" id="index_xs"><img src="resources/images/caidan.png"></a>
			<ul id="menu">
				<li data-menuanchor="page1" class="active"><a data-name="home" href="#page1"><span>首页</span></a></li>
				<li data-menuanchor="page2"><a href="#page2"><span>简介</span></a></li>
				<li data-menuanchor="page3"><a href="#page3"><span>产品</span></a></li>
				<li data-menuanchor="page4"><a href="#page4"><span>下载</span></a></li>
				<li data-menuanchor="page5"><a href="#page5"><span>汇评</span></a></li>
				<li><a target="blank" href="info/list"><span>资讯</span></a></li>
				<li data-menuanchor="page6"><a href="#page6"><span>活动</span></a></li>
				<li data-menuanchor="page7"><a href="#page7"><span>我们</span></a></li>
				<li style=" width:100%;float:right" id="index_x">
					<img src="resources/images/close.png" style="padding-right:15px; float:right; margin-top:10px">
				</li>
			</ul> 
		</nav>
	</div>
</header>
<div class="page-container">
	<section class="section page1">
		<div class="rbslider-container">
			<div class="home-news">
				<span>NEWS:</span>
				<ul>
					<c:forEach var="info" items="${infos}">
					<li><a href="info/${info.id}.html">${info.title}</a></li>
					</c:forEach>
				</ul>
				<a target="blank" href="info/list" class="more">more</a>
			</div>
			<div class="rbslider-wrapper">
				<div class="rbslider-slide slide1">
					<div class="slide-content slide-content-1">
						<h2><a href="javascript:;"><b><smt:dict code="homepage.slide1.slogan1" def="国企控股" />
							<br><smt:dict code="homepage.slide1.slogan2" def="专业风控保障" /></b></a></h2> 
						<p class="intro"><smt:dict code="homepage.slide1.slogan3" def="上海古玺资产管理有限公司" /></p>
						<p class="img"><img alt="" src="" /></p>
					</div>
				</div>
				<div class="rbslider-slide slide2">
					<div class="slide-content slide-content-2">
						<h2><smt:dict code="homepage.slide2.slogan1" def="数据 + 金融 + IT" /></h2> 
						<h3><a href=""><smt:dict code="homepage.slide2.slogan2" def="我们是未来金融的服务商" /></a></h3>
						<p class="intro"><smt:dict code="homepage.slide2.slogan3" def="专业致力于金融套期保值, 智能量化交易, 金融投资模型建立等非银非政府类金融服务商" /></p>
					</div>
				</div> 
				<div class="rbslider-slide slide3">
					<div class="slide-content slide-content-3">
						<div class="content-box">
							<h2><smt:dict code="homepage.slide3.slogan1" def="诚信 优质服务" /><b>
							<a href="javascript:;"><smt:dict code="homepage.slide3.slogan2" def="PURPOSE" /></a></b></h2> 
							<p class="intro"><smt:dict code="homepage.slide3.slogan3" def="做有良知的金融企业" />
							<br /><smt:dict code="homepage.slide3.slogan4" def="做有良知的金融人" /></p>
	 					</div> 
					</div>
					<div class="background-box"></div> 
				</div>
				<div class="rbslider-slide slide4">
					<div class="slide-content slide-content-4">
						<h2><smt:dict code="homepage.slide4.slogan1" def="不断为广大用户提供优质服务" /></h2> 
						<h3><a href="javascript:;"><smt:dict code="homepage.slide4.slogan2" def="创造更大的收益" /></a></h3>
						<p class="intro"><smt:dict code="homepage.slide4.slogan3" def="最终实现合作共赢, 携手同行!" /></p> 
					</div> 
				</div>					
			</div> 
			<a class="move-down"></a> 
			<div class="rbslider-pagination"></div> 
		</div>
	</section>
	<section class="section page2">
		<div class="section-content-container">
			<div class="companyIntro">
				<h2><smt:dict code="company.name" /></h2><br />
				<p>
					<smt:doc code="company.intro" />
				</p>
				<h3><smt:dict code="company.intro.slogan1" def="我们的口号：让科技颠覆交易，让智能负责收益。" />
				<br /><smt:dict code="company.intro.slogan2" def="我们的追求：数据+金融+IT，我们是未来金融的服务商。" /></h3>
			</div>
			
		</div> 
	</section>

	<section class="section page3">
		<div class="section-content-container">
			<hgroup>
				<h2>量资1号EA智能量化对冲交易</h2>
				<h3>最高14%年化收益回报于江浙沪投资客户</h3>			
			</hgroup>
			<ul class="section-content service-list">
				<li>
					<div class="top brand">
						<h3><a href="#">确保收益</a></h3>
						<p><a href="#">PLEDGEABLE INCOME</a></p>
					</div>
					<div class="intro">
					<p><a href="#">14%年化收益打入客户交易账户</a></p>
					</div>
				</li>
		
				<li>
					<div class="top weixin">
						<h3><a href="#">收益可观</a></h3>
						<p><a href="#">A LOT OF BENEFITS</a></p>
					</div>
					<div class="intro">
					<p><a href="#">超过14%部分属于公司收益</a></p>
					</div>
				</li>
				
				<li>
					<div class="top shop">
						<h3><a href="#">本金安全</a></h3>
						<p><a href="#">THE PRINCIPAL SECURITY</a></p>
					</div>
					<div class="intro">
					<p><a href="#">3个工作日内将差额部分补齐</a></p>
					</div>
				</li>
				
				<li>
					<div class="top app">
						<h3><a href="#">对冲风险</a></h3>
						<p><a href="#">HEDGE RISK</a></p>
					</div>
					<div class="intro">
					<p><a href="#">买入一份美元看空期权</a></p>
					</div>
				</li>
			</ul><br />
			<div style="clear:both; text-align: center;">
			<br />
			<a class="btn_more" href="product/list">MORE</a>
			</div>
		</div> 
	</section>
	<section class="section page4" style="background-position:center bottom;">
		<div class="section-content-container rbslider-item-list-container">
			<hgroup>
				<h2>软件下载</h2>
				<h3>让科技颠覆交易, 让智能负责收益</h3>
			</hgroup>
			<div class="section-content rbslider-item-list-wrapper case-list">
			<ul class="rbslider-item-list clearfix">
				<c:forEach var="software" items="${softwares}">
			 	<li><a href="software/${software.id}.html">
					<div class="img-box">
						<div class="img"><img src="${software.image}" alt="${software.name}" /></div> 
						<div class="ck"></div>
						<div class="cover"></div>  
					</div>
					<div class="intro">
						<div class="intro-content">
							<h3>${software.shortDescription}</h3>
							<p></p>
						</div>
						<div class="cover"></div>
					</div></a>
				</li>
				</c:forEach>
				<a onclick="location='softwares.html'" class="wider-more" href="software/list.html">MORE</a>				
			</ul>
			 <div class="rbslider-pagination"></div>
			</div>
			<div class="navigation case">
				<a class="prev"></a>
				<a class="next"></a>
			</div>
			<div onclick="location='software/list.html'" class="rbslider-item-list-more">MORE</div>
		</div>
	</section>
	<section class="section page5" style="background-position:center bottom;">
		<div class="section-content-container rbslider-item-list-container">
			<hgroup>
				<h2>财经汇评</h2>
				<h3>数据+金融+IT，我们是未来金融的服务商</h3>
			</hgroup>
			<div class="section-content rbslider-item-list-wrapper case-list">
			<ul class="rbslider-item-list clearfix">
			 	<c:forEach var="info" items="${activities}">
			 	<li><a href="info/${info.id}.html">
					<div class="img-box">
						<div class="img"><img src="${info.image}" alt="${info.title}" /></div> 
						<div class="ck"></div>
						<div class="cover"></div>  
					</div>
					<div class="intro">
						<div class="intro-content">
							<h3>${info.title}</h3>
							<p></p>
						</div>
						<div class="cover"></div>
					</div></a>
				</li>
				</c:forEach>
				
				<a onclick="location='info/list?typeId=${marketActivityInfoType.id}'" class="wider-more" href="info/list?typeId=${marketActivityInfoType.id}">MORE</a>				
			</ul>
			 <div class="rbslider-pagination"></div>
			</div>
			<div class="navigation case">
				<a class="prev"></a>
				<a class="next"></a>
			</div>
			<div onclick="location='info/list?typeId=${marketActivityInfoType.id}'" class="rbslider-item-list-more">MORE</div>
		</div> 
	</section>
	<section class="section page6" style="background-position:center bottom;">
		<div class="section-content-container rbslider-item-list-container">
			<hgroup>
				<h2><smt:dict code="activity.headline1" def="企业活动" /></h2>
				<h3><smt:dict code="activity.headline2" def="企业活动子标题" /></h3>
			</hgroup>
			<div class="section-content rbslider-item-list-wrapper case-list">
			<ul class="rbslider-item-list clearfix">
			 	<c:forEach var="info" items="${activities1}">
			 	<li><a href="info/${info.id}.html">
					<div class="img-box">
						<div class="img"><img src="${info.image}" alt="${info.title}" /></div> 
						<div class="ck"></div>
						<div class="cover"></div>  
					</div>
					<div class="intro">
						<div class="intro-content">
							<h3>${info.title}</h3>
							<p></p>
						</div>
						<div class="cover"></div>
					</div></a>
				</li>
				</c:forEach>
				
				<a onclick="location='info/list?typeId=${companyActivityInfoType.id}'" class="wider-more" href="info/list?typeId=${companyActivityInfoType.id}">MORE</a>				
			</ul>
			 <div class="rbslider-pagination"></div>
			</div>
			<div class="navigation case">
				<a class="prev"></a>
				<a class="next"></a>
			</div>
			<div onclick="location='info/list?typeId=${marketActivityInfoType.id}'" class="rbslider-item-list-more">MORE</div>
		</div> 
	</section>
	
	<section class="section page7">
		<div class="home-contact">
			<ul class="clearfix">
				<li class="img"><img src="upload/images/qrcode.jpg" align="微信" /></li>
				<li class="center">
					<h2><a href="<smt:dict code="company.phone" def="021-61107607" />" class="联系电话"><smt:dict code="company.phone" /></a></h2>
					<p>
					<smt:dict code="company.name" />
					<br /><smt:dict code="company.name.english" def="ShangHai Guxxi assetmanagement co., LTD" /><br>
					地址一：<smt:dict code="company.address" def="上海市浦东新区川沙路2060号2幢2层224室" /><br/>
					地址二：<smt:dict code="company.address1" def="上海市浦东新区东塘路675弄50号4幢180室" /><br/>
					</p>
				</li>
				<li class="line"></li>
			</ul>
			<div class="clear"></div> 
			<div style="position: absolute; bottom: 10px; width: 100%;">
				<div class="kh">
					<p style="color: #666; font-size:14px"><a href="http://www.miitbeian.gov.cn/" target="_blank">
						<smt:dict code="site.copyright" def="CopyRight 旌逸集团有限公司 版权所有 © 2016 All Rights Reserved" /><br />
						<smt:dict code="site.beian" def="沪ICP备16001272号-2" /></a>
					</p>
				</div>
			</div>
		</div>
	</section>
</div>
<div id="panel">
	<ul class="icons">
		<li class="up" title="上一页"></li>
		<li class="qq"></li>
		<li class="tel"></li>
		<li class="wx"></li>
		<li class="down" title="下一页"></li>
	</ul> 
	<ul class="info"> 
		<li class="qq">
		<p>在线沟通，请点我<a href="<smt:dict code="company.onlineqq.url" def="http://wpa.qq.com/msgrd?v=3&uin=3188706080&site=qq&menu=yes"/>" target="_blank">在线咨询</a></p>
		</li>
		<li class="tel">
		<p>咨询热线：<br><smt:dict code="company.phone" /><br>客服qq：<br><smt:dict code="company.qq" def="3188706080" /></p>
		</li>
		<li class="wx"> <div class="img"><img src="upload/images/qrcode.jpg" /></div> </li>
	</ul>
</div>
<div class="index_cy"></div>
<script type="text/javascript"> 
	$("header nav .icon_menu").click(function(){
		$(this).siblings("ul").toggleClass("show");
	});
	$("#panel .icons li").not(".up,.down").mouseenter(function(){
		$("#panel .info").addClass('hover');
		$("#panel .info li").hide();
		$("#panel .info li."+$(this).attr('class')).show();
	});
	$("#panel").mouseleave(function(){
		$("#panel .info").removeClass('hover');
	})
	$(".icons .up").click(function(){
		$.fn.ronbongpage.moveSectionUp(); 
	});
	$(".icons .down").click(function(){
		$.fn.ronbongpage.moveSectionDown(); 
	});
	 $(".index_cy").click(function(){
	    $("#panel").toggle();
		$(".index_cy").addClass('index_cy2');
		$(".index_cy2").removeClass('index_cy');
	});
</script>
<script type="text/javascript" src="resources/js/home.js?v=1"></script>
<smt:dict code="site.baidu.code" />
</body>
</html> 