<div>
	<!--零成本联系方式 start-->
    <div class="contactform visible" data-animation="zoomIn" data-timeout="200">
        <div class="container">
            <br />
            <span class="fontbold fontorange fontxxxl">“零成本”</span><span class="fontwhite fontxxl">加盟西式快餐连锁品牌，已有</span>   
            <span class="fontbold  fontorange fontxxxl"><smt:dict code="potential.user.count" /></span> <span class="fontwhite fontxxl">人免费获取开店盈利方案</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <br />
            <br />
            <span class="fontwhite fontl">包括：盈利分析+技术培训+开店设备+选址分析+运营方案</span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" class="inputbox" placeholder="姓名" id="potencialUserName" />
            <input type="text" class="inputbox" placeholder="电话" id="potencialUserTel" />
            <br />
            <button class="btngetfree" id="btnGetZeroFeeAdvice">免费领取</button>
            <br />
        </div>
    </div>
    <!--零成本联系方式 end-->  
    <div class="space_xl"></div>
    <div>
        <div class="container visible" data-animation="zoomIn" data-timeout="200">
            <div class="row text-center">
                <div class="col-xs-12 fontwhite text-center">
                    <img src="images/qrcode2.png" style="width: 120px; height: 120px;" />
                    <p class="fontsize8" style="margin-top:10px;"><span>关注微信公众号</span> </p>
                </div>
            </div>
        </div>
    </div>
    <div class="footer_bottom visible" data-animation="zoomIn" data-timeout="200">
        <div class="container">
            <div class="row text-center fontwhite fontsize7">
                <p>
                    <a href="index">公司首页</a>
                    |<a href="about/intro">关于比克利</a>
                    |<a href="brand/brand">品牌优势</a>
                    |<a href="product/hamburger">产品展示</a>
                    |<a href="join/advantage">加盟服务</a>
                    |<a href="info/company">新闻中心</a>
                    |<a href="contact">联系我们</a>
                </p>
                <p>电话：021-68060630 咨询热线：400-168-6966<br />公司地址：上海市浦东新区周康路28号<br />周浦万达国际商务中心F栋2101</p>
                <p>Copyright ©2005 - 2016 上海鼎然餐饮管理有限公司<br />沪ICP备10007893号</p>
            </div>
        </div>
    </div>
</div>

<script src="js/bootstrap.min.js"></script>
<!--<script src="js/jquery.flexslider.js"></script>-->
<script type="text/javascript" src="js/modernizr-2.7.2.js"></script>
<!-- the scrollbox require script -->
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<!-- the jScrollPane script -->
<script type="text/javascript" src="js/jquery.contentcarousel.js"></script>
<!-- <script type="text/javascript" src="js/slidebars.min.js"></script> -->
<script type="text/javascript" src="js/jquery.simplesidebar.js"></script>
<script type="text/javascript" src="js/roundabout.js"></script>
<script type="text/javascript" src="js/roundabout_shapes.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<script src="resources/js/main.js"></script>
<script>
//****//

 window.initleftslidebar = function () {
  $('.leftslidebar').simpleSidebar({
      settings: {
          opener: '#open-sb',
          wrapper: '.sbwrapper',
          animation: {
              duration: 300,
          }
      },
      sidebar: {
          align: 'left',
          width: 210,
          closingLinks: 'a',
      }
  });
 }
 
 if($("#video").length>0){
		$("#video").click(function(){
			var video = document.getElementById("video");
			if(video.paused){
				$("#play_btn").hide();
				video.play();
			}
			else{
				$("#play_btn").show();
				video.pause();
			}
				
		});
	}


/** 菜单高亮 **/
var menu1 = '${menu1}';
var menu2 = '${menu2}';
if(menu1!=''){
	$('#menu-' + menu1).addClass('current');
}
if(menu2!=''){
	$('#menu-' + menu1 + menu2).addClass('on');
	$('#pageSubTitle').text($('#menu2-' + menu2).text());
}


/** 零成本咨询 **/
$('#btnGetZeroFeeAdvice').click(function(){
	var name = $('#potencialUserName').val();
	var tel = $('#potencialUserTel').val();
	
	if(!/^\d{11}$/.test(tel)){
		alert('请输入正确的手机号');
		return;
	}
	if(name==null || name==''||name.length>50){
		alert('请输入正确的名称');
		return;
	}
	$.ajax({
		url: 'potentialUser/add',
		data: {name: name, tel: tel},
		success: function(){
			alert('提交成功');
			$('#potencialUserName').val('');
			$('#potencialUserTel').val('');
		},
		error: function(){
			alert('提交失败, 请稍后重试');
		}
	});
});

/** animation **/
$(function() {
	var $window = $(window),
		win_height_padded = $window.height() * 1.1,
		isTouch = Modernizr.touch;

	if (isTouch) {
		$('.visible').addClass('animated');
	}
	$window.on('scroll', visible);
	function visible() {
		var scrolled = $window.scrollTop(),
			win_height_padded = $window.height() * 1.1;
		$(".visible:not(.animated)").each(function() {
			var $this = $(this),
				offsetTop = $this.offset().top;

			if (scrolled + win_height_padded > offsetTop) {
				if ($this.data('timeout')) {
					window.setTimeout(function() {
						$this.addClass('animated ' + $this.data('animation'));
					}, parseInt($this.data('timeout'), 10));
				} else {
					$this.addClass('animated ' + $this.data('animation'));
				}
			}
		});
		$(".visible.animated").each(function(index) {
			var $this = $(this),
				offsetTop = $this.offset().top;
			if (scrolled + win_height_padded < offsetTop) {
				$(this).removeClass('animated fadeInUp fadeInLeft fadeInRight swing zoomIn zoomInDown pulse bounceIn');
			}
		});
	}
	visible();
});
</script>