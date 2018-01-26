$(function(){
	//nav下拉
	$(".navbar").click(function(){
		if($(".navbar").hasClass("navbar_cs")){
			$(this).removeClass("navbar_cs").siblings("ul.drop_down").animate({"right":"-200"},500,function(){
				$(this).hide();
			});
			$(".wrap").animate({"margin-left":"0"});
			$("#close_nav").hide();
		}else{
			$(this).addClass("navbar_cs").siblings("ul.drop_down").show().animate({"right":"0"});
			$("#close_nav").show();
			$(".wrap").animate({"margin-left":"-200px"});
		}
	});
	//二级下拉
	$(".drop_down .subnav").click(function(){
		if($(this).hasClass("on")){
			$(this).removeClass("on").find("ul").slideUp();
			$(this).find(".caret").removeClass("caret_on");
			setTimeout(function(){
		 		$("#viewportdiv").getNiceScroll().resize();
			},500)
		}else{
			$(this).addClass("on").find("ul").slideDown();
			$(this).find(".caret").addClass("caret_on");
			setTimeout(function(){
		 		$("#viewportdiv").getNiceScroll().resize();
			},500)
		}
	});
	$("#close_nav").click(function(){
		$(".navbar").removeClass("navbar_cs").siblings("ul.drop_down").animate({"right":"-200"},500,function(){
			$(".drop_down").hide();
		});
		$("#close_nav").hide();
		$(".wrap").animate({"margin-left":"0px"});
	})
	scroll();
});
function scroll(){
	$("#viewportdiv").niceScroll({cursorcolor:"#999",cursorwidth:2,cursorborder:0});
}


$(window).load(function(){
	load_fadeout();
});

var widget={
	addressWidth:function(){
		var _w=$(window).width();
		$(".address_list li").css({"width":(_w - 56)/3});
		$(".money_package .btns li,.address_list2 li").css({"width":(_w - 34 )/2 -5});
	}
}
function load_fadein(){
	$("#loadingDom").fadeIn(600);	

}
function load_fadeout(){
	$("#loadingDom").fadeOut(600);	
}



//提示
function tip_T(e){
    $("#tips_t").html(e).fadeIn("fast");
    $("#tips_t").animate({"margin-top":"-45px"})
    setTimeout(function(){
        $("#tips_t").fadeOut("fast");
        $("#tips_t").animate({"margin-top":"-40px"})
        lockstar=true;
    },500)
};
/*产品服务*/
$(window).resize(function(){
    resize_order();
})
function resize_order(){
    var W_box = $(window).width();
    $("#guide_list1 a.small").css({"width":(W_box-30)/2});
}
resize_order();
$(window).bind( 'orientationchange', function(e){
    resize_order();
}); 
