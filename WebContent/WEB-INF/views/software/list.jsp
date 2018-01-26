<!DOCTYPE html>
<html>
<head>
<jsp:include page="../include/meta1.jsp" />
<title>公司介绍 - <smt:dict code="company.name" /></title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
$("#boss2").click(function() {
$("html, body").animate({
scrollTop: $("#boss").offset().top }, {duration: 500,easing: "swing"});
return false;
});
$("#jieshao2").click(function() {
$("html, body").animate({
scrollTop: $("#jieshao").offset().top }, {duration: 500,easing: "swing"});
return false;
});
$("#zhubao2").click(function() {
$("html, body").animate({
scrollTop: $("#zhubao").offset().top }, {duration: 500,easing: "swing"});
return false;
});
$("#waihui2").click(function() {
	$("html, body").animate({
	scrollTop: $("#waihui").offset().top }, {duration: 500,easing: "swing"});
	return false;
	});
$("#renyuan2").click(function() {
	$("html, body").animate({
	scrollTop: $("#renyuan").offset().top }, {duration: 500,easing: "swing"});
	return false;
	});
$("#jinrong2").click(function() {
	$("html, body").animate({
	scrollTop: $("#jinrong").offset().top }, {duration: 500,easing: "swing"});
	return false;
	});
var trigger=window.location.search.substring(1);
if(trigger=='waihui2')
	$("#waihui2").click();
if(trigger=='zhubao2')
	$("#zhubao2").click();
if(trigger=='jinrong2')
	$("#jinrong2").click();
});

</script>


<style>
	.softwareDiv{
	width:90%;
    margin-left: 5%;
}

 .softwareH1  {
	font-size:32px;
	font-weight:bold;
	text-align:left;
}

 .softwareH3 {
	font-size:32px;
	font-weight:bold;
	text-align:left;
}

  .softwareP{
	font-size:24px;
	line-height: 40px;
	text-align:left;
	
}

 .softwareP2{
	font-size:24px;
	color:blue;
	line-height: 40px;
	text-align:left;
	
}

.softwareButton{
	display: inline-block;
	color: #777;
	border: 1px solid #ccc;
	height: 26px;
	line-height: 26px;
	background: #fff;
	border-right: none;
	padding: 0 20px;
}

.softwareButton:hover{
	background: #666666;
	color: #fff;
}

.softwareButton:first-child {
	border-top-left-radius: 4px;
	border-bottom-left-radius: 4px;
}

.softwareButton:last-child {
	border-top-right-radius: 4px;
	border-bottom-right-radius: 4px;
	border-right: 1px solid #ccc;
}

.pSpan{
	color:blue;
}
.softwareImg{
	width: 26%;
    float: right;
}


</style>
</head> 

<body class="case-page open">
<div id="main-container">
	<%-- <div class="inner-wrap">
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
		<ul class="btns">
			<li><a class="up"></a></li>
			<li><a class="tel" href="tel:021-31208888"></a>
				<div class="info"><p>咨询热线<br><smt:dict code="company.phone" /></p></div>
			</li> 
			<li><a class="qq" href="<smt:dict code="company.onlineqq.url" />" target="_blank"></a>
				<div class="info"><p class="qq">点击我，在线咨询</p></div>
			</li>
		</ul>
	</div> --%>
	
	
	<div class="softwareDiv" id="jieshao">
		 <!-- <a class="cur" href="#jieshao">公司介绍</a>
		<a class="cur" href="#jinrong">互联网金融</a>
		<a class="cur" href="#zhubao">珠宝</a>
		<a class="cur" href="#waihui">外汇</a>
		<a class="cur" href="#renyuan">人员介绍</a>
		<a class="cur" href="#boss">董事长寄语</a><br>  -->
		<br><br><br><br>
<p class="softwareP" >&nbsp;&nbsp;&nbsp;&nbsp;上海古玺资产管理有限公司成立于2015年，注册资金3000万元，<span><img class="softwareImg" src="upload/images/pc/download/gixiJiTuan.jpg" /></span>是一家综合性大型金融集团，拥有员工上千人。公司业务覆盖全国一线城市及主要二三线市场，主营业务有股票场外期权(金融机构委托从事金融信息技术外包)、外汇交易（金融机构技术服务商）、互金平台（金融信息服务），财务顾问，上市IPO辅导，投行等。</p>

<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;互金平台核心管理团队是由来自全球金融行业有着数十年从业经验的职业投资经理、基金经理、风控团队组成的专业交易团队人员。主要业务包括：供应链金融（围绕核心企业，管理上下游中小企业的资金流和物流，并把单个企业的不可控风险转变为供应链企业整体的可控风险，通过立体获取各类信息，将风险控制在最低的金融服务。）、不良资产（针对会计科目里的坏账科目来讲，主要但不限于包括银行的不良资产，政府的不良资产，证券、保险、资金的不良资产，企业的不良资产）等不良资产处理。</p>

<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;上海古玺资产管理有限公司通过旗下外汇交易平台，通过常年大数据累积和风控经验，并引用先进的智能化交易系统（EA）、市场撮合交易系统（matchmaking tradeoff）、风控等外汇金融市场工具，成功开发“古玺一号”金融产品。在成功投放市场之后，获得了良好的社会反响。</p>

<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;场外期权（Over the Counter Options）,是上海古玺资产管理有限公司在今后的公司战略发展中至关重要的一环。国内自2015年以来，场外期权市场的发展更加具体化、多样化，公司通过金融机构买入期权锁定原材料采购价格和销售利润。将采购、生产、储存等各个环节的价格风险转移给金融市场。通过越来越多的场外期权交易、杠杆式交易等帮助实体企业规避市场风险，增加公司利润，主动管理风险，使场外期权市场服务实体经济，帮助企业获得更高利润。</p><br><br>


<h3 class="softwareH3">公司介绍</h3><br>
<p class="softwareP" id="jinrong">&nbsp;&nbsp;&nbsp;&nbsp;古玺资产旗下拥有多项业务：股票场外期权，外汇，珠宝，互联网金融。并且于2017年12月26日成功与亚洲证券交易集团有限公司签约，成为亚交所正式会员，并上市挂牌，股票代码为：255888。亚交所主席王翔宇主席、李秘书出席本次签约仪式。</p><br><br>
</div>
<div class="softwareDiv">
<h3 class="softwareH3">互联网金融</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;互联网金融（ITFIN）是指传统金融机构与互联网企业利用互联网技术和信息通信技术实现资金融通、支付、投资和信息中介服务的新型金融业务模式。</p>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;互联网金融不是互联网和金融业的简单结合，而是在实现安全、移动等网络技术水平上，被用户熟悉接受后（尤其是对电子商务的接受），自然而然为适应新的需求而产生的新模式及新业务。是传统金融行业与互联网技术相结合的新兴领域。</p><br><br>
<h3 class="softwareH3">供应链金融</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;最早，银行围绕核心企业，管理上下游中小企业的资金流和物流，并把单个企业的不可控风险转变为供应链企业整体的可控风险，通过立体获取各类信息，将风险控制在最低的金融服务现已成为各种金融机构服务主体。</p><br><br>

<h3 class="softwareH3">Pre-IPO</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;Pre-IPO基金是指投资于企业上市之前，或预期企业可近期上市时，其退出方式一般为：企业上市后，从公开资本市场出售股票退出。同投资于种子期、初创期的风险投资不同，该基金的投资时点在企业规模与盈收已达可上市水平时，甚至企业已经站在股市门口。因此，该基金的投资具有风险小，回收快的优点，并且在企业股票受到投资者追崇情况下，可以获得较高的投资回报。在近几年，在美国、欧洲、香港等资本市场上，已经有基金管理公司专注投资于上市前期企业。规模较大的投资基金，如高盛、摩根士丹利等，在其投资组合中，Pre-IPO投资也是重要的组成部分。</p><br><br>

<h3 class="softwareH3">不良资产</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;古玺资产跟随国家政策，积极响应国家号召，处理不良资产。</p>
<p class="softwareP" id="zhubao">&nbsp;&nbsp;&nbsp;&nbsp;不良资产是针对会计科目里的坏账科目来讲的，主要但不限于包括银行的不良资产，政府的不良资产，证券、保险、资金的不良资产，企业的不良资产。</p><br><br>
</div>

<div class="softwareDiv">

<h3 class="softwareH3">珠宝</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;古玺资产旗下拥有多家珠宝公司，其中玺铂丽珠宝与凡奢公司达成合作，为其珠宝供应商。</p>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;珠宝有广义与狭义之分，狭义的珠宝单指玉石制品，广义的珠宝应包括金、银以及天然材料（矿物、岩石、生物等）制成的，具有一定价值的首饰、工艺品或其他珍藏统称为珠宝，故古代有“金银珠宝”的说法，把金银和珠宝区分出来。</p>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;随着社会和经济的发展，除了天然宝石和人工宝石外，珠宝的概念应该扩大包含到金、银、首饰等。经营这些物品的行业统称为“珠宝行业”。“珠宝”的范围要比广义的“宝石”的概念大很多。广义的宝石泛指那些适宜进行琢磨或雕刻加工为首饰或工艺品的原料。</p><br><br>
<img alt="" src="upload/images/pc/download/zhubao.jpg"><br>
<h3 class="softwareH3">碧玺</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;碧玺是一种中档宝石，但因桃红色和鲜蓝色碧玺较贵重，故也有冒仿品出现。常见的冒仿品有两类，一类以无色碧玺人工加色；一类以红色玻璃加工而成。识别的方法是，真碧玺往往具有明显的二色性，可见双影；体内可见管状包裹物或棉絮状物，晶体的横断面呈弧面三角形。这些特点是冒仿品所不具有的，工人染色的碧玺，由于颜色吊滞，缺乏天然碧玺的“宝光”，故不难识别。</p><br><br>

<h3 class="softwareH3">钻石</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;钻石是天然物质中最坚硬的物质，钻石可刻划任何其他宝石，但其他任何宝石却都刻划不动钻石。也可以用“标准硬度计”刻划，凡硬度小于9度，均是假钻石。钻石还具有亲油性，如以钢笔在钻石表面划一条线，则成一条连续不断的直线，而其他宝石则呈断断续续的间断线。上述方法在鉴定钻石中都有一定参考价值。还可以通过10倍放大镜观察，在10倍放大镜下，多数钻石可见瑕疵，有三角形的生长纹，钻石的表面有“红、橙、蓝”等色的“火”光。光芒四射。最准确可靠的方法是用“热导仪”，测出导热数据来区分真假钻石，但“热导仪”价格比较昂贵。</p><br><br>

<h3 class="softwareH3">红宝石</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;天然宝石“十红九裂”，没有一点瑕疵及裂纹的天然红宝石极为罕见。而人造红宝石颜色一致，内部缺陷或结晶质包裹体少、洁净，块体较大。作为珍贵宝石，市场上超过3克拉以上的天然红宝石十分少见，如碰到较大块体的红宝石，就要引起注意，因为天然红宝石比人造红宝石价值高出千百倍，稍一疏忽，就会“吃药”。</p>
<p class="softwareP" id="waihui">&nbsp;&nbsp;&nbsp;&nbsp;天然红宝石有较强的“二色性”，所谓二色性，即从不同方向看有红色和橙红色二种色调，如只有一种颜色，则可能是红色尖晶石、石榴石或红色玻璃等。</p><br><br>
</div>

<div class="softwareDiv" >
<h3 class="softwareH3">外汇</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;外汇市场是全球最大的金融市场，参与者包括银行、公司、金融机构以及零售投资者。外汇市场也是世界上流通量最大的金融市场。全球外汇市场平均每日交易量约为5.3万亿美元（根据2013年4月国际清算银行提供数据），远超股票与期货市场的总和，并按年迅速增长。在如此庞大的交易量下，没有个别机构可以完全左右市场走势，是全世界最公平最透明的交易市场。投资者可根据快速的市场变化即时进行货币买卖，因此吸引大批投资者在外汇市场进行交易投资。

<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;公司于年初成立专业的量化交易团队，并邀请由原华尔街瑞士银行国际金融集团（ UBS ）首席对冲基金交易员 Abraham Cofnas 担任首席风控官（ CRO ) ，组建了全部由毕业于全球排名TOP300 大学金融或数学硕士组成的10人海归技术分析团队。</p>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;公司组建智能量化对冲交易基金，进军华尔街市场，并且引入华尔街顶级基金对冲模型，经过团队定向与深入研究开发后，推出“古玺 1 号”智能量化对冲交易策略产品，并以月度盈利 3 . 5 ％、季度盈利 1 4 . 8 ％、年度盈利 39 . 2 % ，最大回撤 7 . 5 ％的优异成绩，通过了全部实盘交易测试。</p><br><br>



<h3 class="softwareH3">股票场外期权</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;个股期权是一种在沪深证券交易所之外交易的期权。它是买方与卖方之间订立的合约，期权买方有权利，但无义务在合约有效期限内，以合约约定的价格，购买或出售合约约定数量的标的股票。期权买方需要为这个权利支付权利金，而期权卖方向买方收取权利金并在买方行权时承担履行合约条款的义务。目前，国内场外股票期权的买方一般为个人投资者和机构投资者，股票期权卖方为合格证券公司，如中金公司、中信证券等资金雄厚的大型证券公司，这种交易对手结构可以确保股票期权的有限履约，因为股票期权的卖方在收取期权费用后，需要承担期权期限内股票上涨的无限亏损。股票期权的结算方式可以是股票实物交割或差价现金交割。</p><br><br>


<h3 class="softwareH3">股票场外期权的功能</h3><br>

<h3 class="softwareH3">风险对冲</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;为客户提供多样化、个性化的风险对冲工具，降低风险管理难度；对冲市场下跌风险，但保留了市场上涨的收益</p><br><br>

<h3 class="softwareH3">资产配置</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;为客户提供高杠杆、非线性资产；丰富客户的投资策略</p><br><br>

<h3 class="softwareH3">财富管理</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;丰富财富管理产品的风险收益结构，提供灵活、丰富的产品组合；提高产品的收益杠杆</p><br><br>

<h3 class="softwareH3">流动性管理</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;盘活现货资产，提高资产流动性，提高存量资产的现有收益</p><br><br>

<h3 class="softwareH3">挂牌上市</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;2017年12月26日，上海古玺资产管理有限公司(以下简称：古玺资产)与亚洲证券交易集团有限公司正式签署挂牌AEEx服务平台协议，挂牌签约仪式在亚美资讯（深圳）有限公司隆重举行。签约启动仪式标志着古玺资产正式开启了迈向资本市场的征程，立下了古玺资产快速发展新的里程碑。</p>
<p class="softwareP" id="renyuan">>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出席本次签约仪式的有：上海古玺资产管理有限公司董事长林小贤，量资资产总经理翟敬涛，互联网金融总经理荀斐，股票场外期权总经理王守琪，顾问董玉泉，亚洲股权交易集团董事局主席王翔宇等重要嘉宾出席签约仪式，共同见证启功挂牌AEEx的重要时刻。</p><br><br>
</div>

<div class="softwareDiv" >
<img alt="" src="upload/images/pc/download/renyuan.jpg">
</div>
<p id="boss"></p>
<div class="softwareDiv" >
<h3 class="softwareH3">董事长寄语</h3><br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;古玺自成立以来，始终坚持以创新为企业发展的根本动力，已发展成为互联网金融、股票场外期权、外汇、珠宝，四大板块协同发展，业务跨区域的多元化企业集团。</p>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;古玺的今天，承载了上千名员工的创业激情，承载了以公司众多专家顾问为代表的社会各界的关心和厚爱。</p>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;昨天的成功已被“从不回头欣赏自己的脚印”覆盖，“变中求胜”是古玺永恒的主题，新的征程中古玺又迈进了“太阳每天都是新的”境界。我们将利用超前的理念、完善的制度、精细的管理推动企业可持续发展，形成独立运行的新体系，深耕细作古玺资产四大产业板块，以“创著名品牌 建百年企业”为愿景，打造拥有国际一流先进管理水平的中国企业。</p>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;我们也诚心邀请更多具有雄厚实力、拥有优质资源的国内外同仁成为合作伙伴，致力于企业长期稳定发展，创造多方共赢的新局面。</p>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;我们愿用全部的心智和力量，为客户提供更高品质的综合服务，为我们的合作伙伴创造良好的投资回报，为每一个伟东人搭建实现自身价值的理想平台，为中国梦的实现持续贡献我们的力量。</p><br><br>


<h3 class="softwareH3">董事长</h3><br>
<h3 class="softwareH3">林小贤</h3> <br>
<p class="softwareP">&nbsp;&nbsp;&nbsp;&nbsp;1973年2月17日，2015年成功创立上海古玺资产管理有限公司，温州商会副会长，现任上海古玺资产管理有限公司董事长</p><br><br><br><br><br>
	</div>
<div class="sub-nav">
	<div class="news-cate"> 
		<!-- <a class="cur" href="javascript:;">公司介绍</a> -->
		<button class="softwareButton" id="jieshao2">公司介绍</button>
		<button class="softwareButton" id="jinrong2">互联网金融</button>
		<button class="softwareButton" id="zhubao2">珠宝</button>
		<button class="softwareButton" id="waihui2">外汇</button>
		<button class="softwareButton" id="renyuan2">人员介绍</button>
		<button class="softwareButton" id="boss2">董事长寄语</button>
		
 		<!--a href="#">高新科技</a>
		<a href="#">汽车贸易</a-->
	</div>
	<div class="news-cate-dropdown">
		<button>公司介绍</button>
		<!-- <ul>
			<li><a href="listJinRong.jsp">互联网金融</a></li>
 			<li><a href="listBaoshi.jsp">珠宝</a></li>
			<li><a href="listQiquan.jsp">外汇</a></li>
		</ul> -->
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