<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()%>/" />
<meta name="author" content='<smt:dict code="site.author" def="孙新-xs06974@163.com" />' />
<meta name="keywords" content='<smt:dict code="site.keywords" def="页面关键字" />' />
<meta name="description" content='<smt:dict code="site.description" def="页面描述" />' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资本平台查询</title> 
<link rel="stylesheet" href="resources/css/tfy2.css" />
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<style type="text/css">
#head a {
	height: 35px;
	line-height: 35px;
	text-decoration: none;
	color: gray;
	font-size: 12px;
}

#head a:hover {
	text-decoration: underline;
	color: darkred;
}
body{
	background-color: #fff;
}

.formItemWrapper input {
	width: 240px;
	border: none;
	outline: none;
}

#code {
	width: 240px;
}

ul, li {
	padding: 0;
}
li{ list-style-type: none; }
</style>
<link rel="stylesheet" type="text/css" href="resources/css/query.css">
</head>

<body
	style="padding: 0; margin: 0; font-family: 微软雅黑; position: relative; height: 100%; overflow: hidden;">
	<div
		style="width: 100%; height: 35px; line-height: 35px; border-bottom: 1px solid #ddd;"
		id="head">
		<a href="javascript:;" target="blank"
			style="float: left; margin-left: 40px;">申诉</a> <a
			href="javascript:;" target="blank"
			style="float: left; margin-left: 20px;">举报</a> <a
			href="javascript:alert(&#39;请按Ctrl+D键进行收藏&#39;)"
			style="float: right; margin-right: 40px;" target="blank">收藏本页</a>
	</div>
	<div style="width: 100%; height: 350px; margin-top: 100px;"
		align="center">
		<img alt="" src="resources/images/query_logo.jpg">
			<div style="width: 100%; height: 60px; line-height: 60px; margin-top: 20px; font-size: 16px;" id="myDiv">
				<span id="p1" style="color: #269bd7; cursor: pointer;">交易所</span> 
				<span id="p2" style="color: #999; margin-left: 50px; cursor: pointer;">大宗商品</span> 
				<span id="p3" style="color: #999; margin-left: 50px; cursor: pointer;">现货</span> 
				<span id="p4" style="color: #999; margin-left: 50px; cursor: pointer;">贵金属</span> 
				<span id="p5" style="color: #999; margin-left: 50px; cursor: pointer;">原油</span>
			</div>
			<div style="height: 50px; margin-top: 10px; width: 100%; padding: 0;">
				<div
					style="width: 618px; height: 50px; display: block; padding: 0; margin: 0;">
					<input id="platform" type="text"
						style="width: 454px; height: 42px; line-height: 42px; font-size: 16px; color: #333; background: url(resources/images/search.png) 0 center no-repeat; padding: 0 10px 0 44px; border: 1px solid #269bd7; float: left;"
						placeholder="请输入查询平台的名称"> <input type="button"
						style="width: 105px; height: 44px; line-height: 44px; font-size: 22px; text-align: center; border: none; background: #269bd7; color: #fff; cursor: pointer; padding: 0; font-family: 微软雅黑; float: left;"
						id="btnQuery" value="查询" />
				</div>
				<div style="width: 100%; height: 60px; line-height: 60px; margin-top: 20px; font-size: 14px;">
					<span style="color: #999;">已有</span> <span id="userCounts"
						style="font-size: 22px; color: red;"><smt:dict code="count.user" /></span> <span
						style="color: #999;">名网友查询了</span> <span id="searchCounts"
						style="font-size: 22px; color: red;"><smt:dict code="count.platform" /></span> <span
						style="color: #999;">个平台</span>
				</div>
				
				<div class="container">
					<br />
					<div class="row">
						<div class="col-xs-4" style="text-align: right;font-size: 14px;"><span>今日查询排行榜：</span></div>
						<div class="col-xs-2" style="text-align: left !important;">
							<div id="demo" style="overflow:hidden;height:22px;line-height:22px; width: 200px;font-size: 14px;">
						      <ul class="mingdan" id="holder">
						      <li><a href="javascript:;" target="_blank">1 大连再生资源交易所</a></li>
						      <li><a href="javascript:;" target="_blank">2 天津贵金属交易所</a></li>
						      <li><a href="javascript:;" target="_blank">3 东南大宗</a></li>
						      <li><a href="javascript:;" target="_blank">4 渤海商品交易所</a></li>
						      <li><a href="javascript:;" target="_blank">5 厦门大宗商品交易所</a></li>
						      </ul>
						    </div>
						</div>
						<div class="col-xs-2" style="text-align: right;font-size: 14px;"><span>实时动态：</span></div>
						<div class="col-xs-4" style="text-align: left !important;">
							<div id="demo1" style="overflow:hidden;height:22px;line-height:22px; width: 200px;font-size: 14px;">
						      <ul class="mingdan" id="holder">
						      	<li><a href="javascript:;" target="_blank">135****6712</a></li>
								<li><a href="javascript:;" target="_blank">131****9986</a></li>
								<li><a href="javascript:;" target="_blank">133****7762</a></li>
								<li><a href="javascript:;" target="_blank">151****1224</a></li>
								<li><a href="javascript:;" target="_blank">181****6337</a></li>
								<li><a href="javascript:;" target="_blank">133****2865</a></li>
								<li><a href="javascript:;" target="_blank">135****1556</a></li>
								<li><a href="javascript:;" target="_blank">133****4436</a></li>
								<li><a href="javascript:;" target="_blank">151****5116</a></li>
								<li><a href="javascript:;" target="_blank">188****2028</a></li>
								<li><a href="javascript:;" target="_blank">188****4269</a></li>
								<li><a href="javascript:;" target="_blank">151****8828</a></li>
								<li><a href="javascript:;" target="_blank">133****7762</a></li>
								<li><a href="javascript:;" target="_blank">159****5051</a></li>
								<li><a href="javascript:;" target="_blank">189****9089</a></li>
								<li><a href="javascript:;" target="_blank">137****6076</a></li>
								<li><a href="javascript:;" target="_blank">189****1556</a></li>
								<li><a href="javascript:;" target="_blank">159****2026</a></li>
								<li><a href="javascript:;" target="_blank">130****5997</a></li>
								<li><a href="javascript:;" target="_blank">136****7073</a></li>
						      </ul>
						    </div>
						</div>
					</div>				  
				</div>
			</div>
	</div>
	<div
		style="width: 100%; height: 94px; position: fixed; bottom: 0px; left: 0px; font-size: 14px;">
		<div
			style="width: 100%; height: 47px; background-image: url(resources/images/bg01.png); line-height: 47px;"
			align="center">
			<span style="color: white;">拥有全国最大数据库，已收入</span> <span
				style="color: yellow;" id="platformCounts"><smt:dict code="count.institution" /></span> <span
				style="color: white;">家平台机构（截止 <span id="date"></span>）
			</span>
		</div>
		<div style="width: 100%; height: 47px; line-height: 47px;"
			align="center">
			<span style="color: #CCC;">版权所有 金创互动科技（深圳）有限公司 投资有风险 入市需谨慎</span>
		</div>
	</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="background-color:#efefef;">
      <div class="modal-header" style="border-bottom: none;">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h2 class="modal-title" id="myModalLabel" style="text-align: center;font-family: SimSun; font-size: 36px;font-weight:900; color: #031f47;padding-top: 20px;">登录查询</h2>
      </div>
      <div class="modal-body" style="padding-top: 0px;">
       <div class="regform" style="padding: 0px 50px 0 50px;">
			<div class="formItemWrapper" style="border-width: 1px;">
				<input  name="name" id="name1" placeholder="您的姓名" />
			</div>
			<div class="formItemWrapper" style="border-width: 1px;">
				<input  name="mobile" id="mobile1" placeholder="您的手机号"  />
			</div>
			<div class="formItemWrapper" style="border-width: 1px;">
				<input name="code" id="code1" style="width: 120px;padding-left:20px;" placeholder="请输入验证码" />
			<button id="btnGetVerifyCode1" class="btn btn-sm btn-primary" style="float: right; vertical-align: middle; margin-top: -2px;">发送验证码</button>
			<!--img id="verifyCodeImage" src="genCaptcha" title="点击刷新验证码" /-->
			</div>
			<div class="formItemWrapper1" id="btnSubmit1" style="padding: 5px 0; font-size: 24px;background-color:#269bd7;">
				立即查询
			</div>
		</div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
<script src="resources/js/jquery-2.0.0.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script>
var d = new Date();
var dateStr = d.getFullYear() + '年' + (d.getMonth() + 1) + '月' + d.getDate() + '日';
$('#date').text(dateStr);

$('#btnQuery').click(function(){
	var p = $('#platform').val();
	if(p=='') {
		alert('请先输入平台名称');
		return;
	}
	$('#myModal').modal({});
});

$('#btnGetVerifyCode1').click(function(){
	var that = $(this);
	var mobile = $('#mobile1').val();
	if(mobile=='' || !/\d{11,11}/.test(mobile)) {
		alert('请输入正确的手机号码');
		return;
	}
	
	$.ajax({
		url: 'sendVerifyCode?mobile=' + mobile,
		success: function() {
			$(that).attr('disabled', true);
			var count = 59;
			var timer = setInterval(function(){
				$(that).text(count);
				count--;
				if(count<=0) {
					$(that).attr('disabled', false);
					$(that).text('发送验证码');
					clearInterval(timer);
				}
			}, 1000)
		},
		error: function(){
			alert('获取验证码失败, 请稍后重试');
		}
	})
});

$('#btnSubmit1').click(function(){
	var name = $('#name1').val();
	var mobile = $('#mobile1').val();
	var code = $('#code1').val();
	
	if(name=='') {
		alert('请输入您的姓名');
		return;
	}
	

	if(mobile=='' || !/\d{11,11}/.test(mobile)) {
		alert('请输入您的手机号码');
		return;
	}
	
	if(code=='') {
		alert('请输入验证码');
		return;
	}
	
	$.ajax({
		url: 'userInfo/add',
		type: 'post',
		data: {'name': name, 'mobile': mobile, 'code': code, 'channel':document.location.href, 'detail':$('#platform').val()},
		success: function(data){
			if(data=='BADCODE') {
				alert('验证码错误, 请重新输入');
				return;
			}
			alert('提交成功, 请保持手机畅通, 工作人员会联系您.');
			$('#name1').val('');
			$('#mobile1').val('');
			$('#code1').val('');
			$('#myModal').modal('hide');
		},
		error: function(){
			alert('操作失败, 请稍后重试');
		}
	})
});

$('.formItemWrapper').click(function(){
	$(this).find('input').focus();
});

$('#myDiv span').click(function(){
	//#269bd7
	//#999
	$('#myDiv span').each(function(){
		$(this).css('color','#999');
	});
	$(this).css('color','#269bd7');
});

function AutoScroll(obj) {
    $(obj).find("ul:first").animate({
        marginTop: "-22px"
    },
    500,
    function() {
        $(this).css({
            marginTop: "0px"
        }).find("li:first").appendTo(this);
    });
}
$(document).ready(function() {
    setInterval('AutoScroll("#demo")', 2000);
    setInterval('AutoScroll("#demo1")', 2000)
});

</script>