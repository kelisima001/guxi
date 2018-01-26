<div id="leftad" class="leftad">
    <span class="closeadd"></span>
    <a id="qiao_chat_button" target="_blank" href="http://p.qiao.baidu.com//im/index?siteid=510576&ucid=2085115">
	    <div class="online_chat" id="qiao_chat_div">
	    </div>
    </a>
        <a id="qq_chat_button" target="_blank" href="http://q.url.cn/s/hWpydJm">
	    <div class="qq_chat" id="qq_chat_div">
	    </div>
    </a>
    <div class="wechat">
    </div>
    <div class="consult">
    </div>
    
</div>
<script>
var scrolladflag = null;
function movead(){
    var init_pos = $('#leftad').offset().top;
    var adtop = $(window).scrollTop()+90;
    $("#leftad").css({top:adtop});
}
$(window).scroll(function() {
	if(scrolladflag!=null)
		clearTimeout(scrolladflag);
	setTimeout("movead();",100);
}); 
</script>