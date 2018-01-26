$(function () {
    /* 成绩选项卡 */
    var listbtn = $(".right-achievement .uls-achievement li");
    var lisbox = $(".achievement-box");
    listbtn.click(function () {
        listbtn.css({background: "#e8526f"});
        $(this).css({background: "#cb1c2d"});
        var index = $(this).index();
        lisbox.css({display: "none"}).eq(index).css({display: "block"});
    });

    /*
     * 弹框
     *
     * */
    var pcframe = $(".ex8-appointment"),
        pcinputbox = $(".ex8-inputbox");

    /**
     * 弹框结束
     */

    /* footer动画 */
    var btnST = $(".btn-shiting");/* 按钮 */
    var footer = $(".footer");    /* 底部 */
    var nameFocus = $('input[name=name]');
    btnST.click(function () {
        footer.addClass("footeranimation");
        setTimeout(function () {
            nameFocus.focus();
        }, 1000)
        pcframe.removeClass("ex8-hide");
    });

    /* 点击关闭footer */
    var btnGB = $(".icon-close");
    btnGB.click(function () {
        footer.addClass("footeranimation");
    });



    /* 预约 */
    var btnYY = $(".banner-btn");
    btnYY.click(function () {
        footer.addClass("footeranimation");
        setTimeout(function () {
            nameFocus.focus();
        }, 1000)
        $("#success_").addClass("ex8-hide");
        pcframe.removeClass("ex8-hide");
    });

    /**
     *  关闭弹框
     */
    var ex8button = $(".ex8-colse");
    ex8button.click(function () {
        pcframe.addClass("ex8-hide");
        footer.removeClass("footeranimation");
    });


    $(".ex8-box-success").click(function () {
        pcframe.addClass("ex8-hide");
        footer.removeClass("footeranimation");
    });

    /* 成功的函数 */
    function success() {
        $("#success_").removeClass("ex8-hide");
        setTimeout(function(){
            location.reload();
        },2000);   
    }
    /**
     * 滚动
     */
    /* $(document).scroll(function () {
     
     if ($(window).height() + $(document).scrollTop() == $(document).height()) {
     footer.addClass("footeranimation");
     }
     
     });*/

    /* 图片验证码 */
    $("#code").click(function () {
        var url = $(this).data('url');
        $(this).attr("src", url + "?" + Math.random());
    });

    $(".btn-as").click(function(){
        var url = $("#code").data('url');
        $("#code").attr("src", url + "?" + Math.random());
    });

    /* 底部弹框 */
     $("#btn").click(function(){
        pcframe.removeClass("ex8-hide");
        $("#success_").addClass("ex8-hide");
    });

    /* 获取验证码倒级时 */

    $(document).on("click","#obtain-code",times);
    function times(){
            var img_code = $("input[name=img_code]").val(),
                    mobile = $("input[name=phone]").val();
            $.ajax({
                type: 'POST',
                url: '/index.php/home/public/sendCodes',
                data: {
                    mobile: mobile,
                    img_code: img_code,
                    from:"page1"
                },
                dataType: "json",
                beforeSend: function () {
                    if(!mobile){
                        $(".errorMsg1").text('请输入手机号码').removeClass('fn-hide');
                        timeout();
                        return false;
                    }
                    if(!img_code){
                        $(".errorMsg1").text('请填写图片验证码').removeClass('fn-hide');
                        timeout();
                        return false;
                    }

                    if (!(/^\d{4}$/.test(img_code))) {
                        $(".errorMsg1").text('请输入正确图片验证码').removeClass('fn-hide');
                        timeout();
                        return false;
                    }
                    

                },
                success: function (data) {
                    if(data.code==200){
                    var Times =ystool.countdown();                   
                    new Times(function(){
                    if(this.time <=0){
                            $(".btn-1").removeClass("cccB").html("获取验证码");
                            $(document).on("click","#obtain-code",times);
                        }else{
                           $(".btn-1").addClass("cccB").html("验证码已发送  <span>"+this.time+" </span>s"); 
                           $(document).off("click","#obtain-code");
                        }                      
                    },function(){},120);
                    return false;
                    }
                    $("#code").click();
                    $(".errorMsg1").text(data.desc).removeClass('fn-hide');
                    timeout();

                }
            });
            
    }


    /* ajax 验证请求数据 */
    $("#appointment").click(function () {
        var self = $(this),
                mobile = self.siblings('input[name=phone]').val(),
                name = self.siblings('input[name=name1]').val(),
                verify = $('input[name=verify]').val(),
                errormsg = self.siblings('.errorMsg1');

        if (self.hasClass('disable'))
            return;
        $.ajax({
            type: 'POST',
            url: 'userInfo/add',
            data: {
                mobile: mobile,
                name: name,
                channel: document.location.href,
                verify:verify
            },
            //dataType: "json",
            beforeSend: function () {

                errormsg.text('').addClass('fn-hide');

                if (!mobile) {
                    errormsg.text('请填写手机号码').removeClass('fn-hide');
                    timeout();
                    return false;
                }
                if (!(/^1\d{10}$/.test(mobile))) {
                    errormsg.text('请输入正确手机号码').removeClass('fn-hide');
                    timeout();
                    return false;
                }
                if (!name) {
                    errormsg.text('请输入姓名').removeClass('fn-hide');
                    timeout();
                    return false;
                }
//                if (!verify) {
//                    errormsg.text('请输入短信验证码').removeClass('fn-hide');
//                    timeout();
//                    return false;
//                }

                self.addClass('disable');

            },
            success: function (data) {

                $('input[name=phone]').val('');
                $('input[name=name1]').val('');
                $('input[name=verify]').val('');
                $('input[name=img_code]').val('');
                success();

                self.removeClass('disable');

            },
            error: function (data) {

                data = JSON.parse(data.responseText);

                self.removeClass('disable');
                if (data && data.desc) {
                    errormsg.text(data.desc.message);
                } else {
                    errormsg.text('网络连接失败，请检查网络后再次预约');
                }


            }

        });
    });
    var clear;
    function timeout(){
        clearTimeout(clear);
        clear = setTimeout(function(){
        $(".errorMsg1").text('');
        },2000);
    }
});