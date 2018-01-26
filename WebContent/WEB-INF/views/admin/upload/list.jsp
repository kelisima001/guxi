<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - 上传目录管理 - 文件列表</title>
<jsp:include page="../header.jsp" />

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<jsp:include page="../mainmenu.jsp" />
		</nav>
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-default">
					<div class="panel-heading">文件列表</div>
					<div class="panel-body">
						<table class="table table-hover" id="resourceTable">
							<thead>
								<tr>
									<th width="10%">&nbsp;</th>
									<th width="10%">文件名</th>
									<th width="10%">是否图片</th>
									<th width="10%">宽度</th>
									<th width="10%">高度</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="file" items="${files}">
								<tr>
									<td>
										<c:if test="${file.image}">
											<img src="${file.path}" width="80" height="40" />
										</c:if>
									</td>
									<td>${file.name}</td>
									<td>${file.image}</td>
									<td><c:if test="${file.image}">${file.width}</c:if></td>
									<td><c:if test="${file.image}">${file.height}</c:if></td>
									<td>
										<a href="admin/upload/download?name=${file.name}">下载</a>
										<a href="javascript:;" fileName="${file.name}" class="btnReplaceUploadResource" bind="0">替换</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<a href="admin/gallery/edit" class="btn btn-primary">添加相册</a>
						<jsp:include page="../../include/pagination.jsp" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
$('#mainMenu li').removeClass('active');
$('#menuUpload').addClass('active');

var url = 'admin/gallery/list?a=a';
initSimplePagination('.pageBar', url);

$('.btnReplaceUploadResource').click(function(){
	if($(this).attr('bind')=='1'){
		return;
	}
	else {
		var fileName = $(this).attr('fileName');
		var tr = $(this).parent().parent();
		tr.after('<tr><td colspan="6">'
				+ '<input type="file" style="display:inline-block;" class="uploadFileInput" />'
				+ '<input type="button" fileName="' + fileName + '" value="上传并替换" class="btnUpload" />'
				+ '</td></tr>');
		$(this).attr('bind', '1');
	}
});

$('#resourceTable').on('click', '.btnUpload', function(){
	var tr = $(this).parent().parent().prev();
	var data = new FormData();
	var name = $("input").val();
	var file = $(this).prev()[0].files[0];
	if(typeof(file)=='undefined') {
		alert('请先选择文件');
		return;
	}
	data.append("file", file);
	data.append("name", $(this).attr('fileName'));
	var cfm = confirm("确定替换？");
	if(!cfm){
		return;
	}
	$.ajax({ 
		url : 'admin/upload/replace', 
		type : 'post', 
		data : data, 
		// 告诉jQuery不要去处理发送的数据
		processData : false, 
		// 告诉jQuery不要去设置Content-Type请求头
		contentType : false,
		beforeSend:function(){
			console.log("正在进行，请稍候");
		},
		success : function(resp) {
			if(resp!='OK') {
				alert('替换失败, 请确保上传文件类型和原始文件类型一致, 且文件大小在合理范围内.');
				return;
			}
			console.log("成功"+resp);
			var src = tr.find('img').attr('src')
			src = src.split('?')[0];
			tr.find('img').attr('src', src + '?t=' + (new Date()).getTime());
		}, 
		error : function(resp) { 
			console.log("error");
		} 
	});
})
</script>
</html>