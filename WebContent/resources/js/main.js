/**
 * 初始化分页
 */
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
	
	$(selector +' li[page=' + pageNumber + ']').addClass('active');
	
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

	$(selector +' li[page]').click(function(){
		var pageNumber = $(this).attr('page');
		toLocation(url + "pageNumber=" + pageNumber);
	});
}

function toLocation(location) {
	var base = $('base').attr('href');
	document.location.href = (base + location);
};

/**
 * 恢复主题
 */
function setTheme(theme) {
	$.cookie('theme', theme, {'expires': 180});
}

function getSelectedTheme() {
	var theme = $.cookie('theme');
	if(theme==null || theme=='') {
		theme = 'resources/css/theme/theme-e.css';
	}
	return theme;
}

function loadTheme(theme) {
	$('<link rel="stylesheet" href="'+theme+'" />').appendTo('head');
}

var theme = getSelectedTheme();
loadTheme(theme);
$('.setting-color label').each(function(){
	var cssUrl = $(this).data("loadCss");
	if(cssUrl == theme) {
		$(this).find('input[type=radio]').attr('checked', 'checked');
	}
});

/**
 * AJAX全局设置
 */
$.ajaxSetup({
	timeout: 3000,
　　//请求成功后触发
　　success: function (data) {
		new PNotify({
		    title: '操作成功',
		    type: 'info',
		    styling: 'fontawesome'
		});
　　},
　　//请求失败遇到异常触发
　　error: function (xhr, status, e) {
		var json = xhr.responseJSON;
		if(json!=null) {
			new PNotify({
			    title: '操作失败',
			    text: json.message,
			    type: 'info',
			    styling: 'fontawesome'
			});
		}
　　},
　　//完成请求后触发。即在success或error触发后触发
　　complete: function (xhr, status) {
		
　　},
　　//发送请求前触发
　　beforeSend: function (xhr) {
		//
　　}
});
