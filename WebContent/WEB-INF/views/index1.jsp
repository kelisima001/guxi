
<!DOCTYPE html>
<html>
<head>
<title>维高星寓装饰集团</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="description" content="维高星寓装饰集团" />
<link rel="shortcut icon" href="resources/images/logo32.ico" type="image/x-icon" />
<link rel="stylesheet" href="resources/css/weui.min.css">
<link rel="stylesheet" href="resources/css/jquery-weui.css">
<style>
.swiper-container, .swiper-container1 {
  width: 100%;
} 

.swiper-container img, .swiper-container1 img {
  display: block;
  width: 100%;
}

#nav {
	margin: 10px 0 0 0;
}


#nav .weui-flex__item{
	margin: 0 20px;
	white-space:nowrap;
}
#nav img {
	width: 100%; 
	height: auto;
}

#navText {
	font-size: 12px;
	text-align: center;
}

#bottombar {
	height: 55px;
	line-height: 55px;
	width: 100%;
    background: #fff;
    margin-bottom: .1rem;
    padding: 0.08rem 0;
    position: fixed;
    bottom: -10px;
    text-align: center;
    z-index: 99999;
}

#infoHeader{
	padding: 20px 0;
	color: #66a935;
	font-size: 24px;
	text-align: center;
}

hr{
	border-top:none;
	botton-left:none;
	border-right: none;
	border-bottom: solid #ddd 1px;
}

.title{
    text-align: center;
    font-size: 24px;
    color: #66a935;
    margin: 10px 0;
}

.weui-btn_primary{
	background-color: #66a935;
}
</style>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?bbba71b400520f993697232abcd1d993";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

</head>

<body ontouchstart>
<div style="font-size:0;"><img src="upload/top.jpg" style="width: 100%; height: auto;" /></div>
<div class="swiper-container">
	<div class="swiper-wrapper">
		<!-- Slides -->
		<c:forEach var="item" items="${gallery.items}">
			<div class="swiper-slide">
				<img src="${item.image}" />
			</div>
		</c:forEach>
	</div>
	<div class="swiper-pagination"></div>
</div>
<div>
	
	<img src="upload/td4-1.jpg" style="width:100%;" />
	
	<h2 class="title">2017最流行的设计风格</h2>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<!-- Slides -->
			<div class="swiper-slide">
				<img src="upload/01.jpg" />
			</div>
			<div class="swiper-slide">
				<img src="upload/02.jpg" />
			</div>
			<div class="swiper-slide">
				<img src="upload/03.jpg" />
			</div>
			<div class="swiper-slide">
				<img src="upload/04.jpg" />
			</div>
			<div class="swiper-slide">
				<img src="upload/05.jpg" />
			</div>
			<div class="swiper-slide">
				<img src="upload/06.jpg" />
			</div>
			<div class="swiper-slide">
				<img src="upload/07.jpg" />
			</div>
			<div class="swiper-slide">
				<img src="upload/08.jpg" />
			</div>
			<div class="swiper-slide">
				<img src="upload/09.jpg" />
			</div>
			<div class="swiper-slide">
				<img src="upload/10.jpg" />
			</div>
		</div>
		<div class="swiper-pagination"></div>
	</div>
	<h2 class="title">专业设计团队免费设计</h2>
	<img src="upload/sjs_1.jpg" style="width:100%;" class="open-popup" data-target="#full"/>
	<h2 class="title">汇集国内外优秀设计案例</h2>
	<img src="upload/case.jpg" style="width:100%;" />
	<h2 class="title">全包精选套餐</h2>
	<img src="upload/p1m.jpg" style="width:100%;" class="open-popup" data-target="#full"/>
	<img src="upload/p2m.jpg" style="width:100%;" class="open-popup" data-target="#full"/>
	<img src="upload/p3m.jpg" style="width:100%;" class="open-popup" data-target="#full"/>
	<img src="upload/p4m.jpg" style="width:100%;" class="open-popup" data-target="#full"/>
	<img src="upload/p5m.jpg" style="width:100%;" class="open-popup" data-target="#full"/>
	<img src="upload/p6m.jpg" style="width:100%;" class="open-popup" data-target="#full"/>
	<br />
	
</div>
<br /><br /><br />
<div id="bottombar">
	<div class="weui-flex">
      <div class="weui-flex__item">
      	<a href="javascript:;" class="weui-btn weui-btn_primary open-popup" style="margin: 0 10px 0 0;" data-target="#full">立即报名</a>
      </div>
      <div class="weui-flex__item">
      	<a href="tel:4001089008" class="weui-btn weui-btn_primary" style="margin: 0 0 0 10px;">免费咨询</a>
      </div>
    </div>
	 
</div>
<div id="full" class='weui-popup__container'>
  <div class="weui-popup__overlay"></div>
  <div class="weui-popup__modal">
  <img src="upload/banner1.jpg" style="width:100%; height: auto;" />
    <header id='infoHeader'>
      <h2 class="demos-second-title">请填写报名信息</h2>
    </header>
    <div class="weui-cells weui-cells_form">
      <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">您的姓名</label></div>
        <div class="weui-cell__bd">
          <input class="weui-input" id="username" type="number" placeholder="请输入您的姓名">
        </div>
      </div>
      <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">您的手机</label></div>
        <div class="weui-cell__bd">
          <input class="weui-input" id="mobile" type="number" pattern="[0-9]*" placeholder="请输入您的手机号">
        </div>
      </div>
      <div class="weui-btn-area">
	    <a class="weui-btn weui-btn_primary" href="javascript:" id="btn-apply">提交</a>
	    <a href="javascript:;" class="weui-btn weui-btn_primary close-popup">关闭</a>
	  </div>
     </div>
     <br /><br /><br /><br /><br /><br /><br />
    
  </div>
</div>
<script src="resources/js/jquery-2.1.4.js"></script>
<script src="resources/js/fastclick.js"></script>
<script>
$(function() {
  FastClick.attach(document.body);
});
</script>

<script src="resources/js/jquery-weui.js"></script>
<script src="resources/js/swiper.js"></script>
<script>
$(".swiper-container").swiper({
  loop: true,
  autoplay: 3000
});

$('#btn-apply').click(function(){
	var username = $('#username').val();
	var mobile = $('#mobile').val();
	
	if(username==null || username=='') {
		alert('请输入您的姓名');
		return;
	}
	if(username.length>=30){
		alert('请输入正确的姓名');
		return;
	}
	if(mobile==null || mobile=='') {
		alert('请输入您的手机号');
		return;
	}
	if(!/^\d{11}$/.test(mobile)) {
		alert('请输入正确的手机号');
		return;
	}
	
	$.ajax({
		url: 'userInfo/add',
		type: 'POST', 
		data: {'username': username, 'mobile': mobile},
		success: function(data) {
			document.location.href="success.html";
		},
		error: function() {
			alert('服务器发生错误, 请稍后重试.');
		}
	})
})
</script>
</body>
</html>