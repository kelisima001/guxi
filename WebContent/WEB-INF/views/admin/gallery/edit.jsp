<!DOCTYPE html>
<html>
<head>
<title>SMART - Dashboard</title>
<jsp:include page="../include/head.jsp" />
</head>
<body>
   <div class="wrapper">
      <!-- 导航区 -->
      <jsp:include page="../include/topnav.jsp" />
      <!-- 左侧菜单区 -->
      <jsp:include page="../include/menu.jsp" />
      <!-- 右侧边栏 -->
      <jsp:include page="../include/right.jsp" />
      <!-- Main section-->
      <section>
         <!-- Page content-->
         <div class="content-wrapper">
            <div class="content-heading">编辑轮播相册</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<jsp:include page="../include/info.jsp" />
					<form role="form" action="admin/gallery/edit" method="post" class="form-horizontal">
						<c:if test="${gallery!=null}">
						<input type="hidden" name="id" value="${gallery.id}" />
						</c:if>
						<div class="form-group">
							<label for="code" class="col-sm-2 control-label">业务键</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="code" name="code" value="${gallery.code}" />
							</div>
							<div class="col-sm-6">
								<label class="control-label">系统级的图片轮播code不可以随便改; 否则会导致页面显示不正确</label>
							</div>
						</div>
						
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">名称</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="name" name="name" value="${gallery.name}" />
							</div>
							<div class="col-sm-6">
								<label class="control-label"></label>
							</div>
						</div>
						<div class="form-group">
							<label for="playInterval" class="col-sm-2 control-label">播放间隔</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="playInterval" name="playInterval" value="${gallery.playInterval}" />
							</div>
							<div class="col-sm-6">
								<label class="control-label">整数数字, 单位是秒</label>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-sm-2 control-label"></label>
							<div class="col-sm-10">
								<input type="submit" class="btn btn-primary" value="提交" />
								<a class="btn btn-primary" href="admin/gallery/list">返回</a>
							</div>
						</div>
						<hr />
						<c:if test="${gallery.id ne null}">
						<div class="form-group">
							<div class="col-sm-12">
								<div class="table-responsive">
									<table class="table table-hover">
										<thead>
											<tr>
												<th width="15%">图片</th>
												<th width="25%">标题</th>
												<th width="20%">文字</th>
												<th width="20%">链接</th>
												<th width="10%" title="序号越大越靠前">排序</th>
												<th width="10%">操作</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="item" items="${gallery.items}" varStatus="status">
											<tr>
												<td><img src="${item.image}" width="80" height="40" /></td>
												<td>
													<input type="hidden" name="items[${status.index}].id" value="${item.id}" />
													<input name="items[${status.index}].title" value="${item.title}" />
												</td>
												<td><input name="items[${status.index}].text" value="${item.text}" /></td>
												<td><input name="items[${status.index}].url" value="${item.url}" /></td>
												<td><input name="items[${status.index}].sort" value="${item.sort}" /></td>
												<td><a href="javascript:;" class="linkDeleteGalleryItem" link="admin/gallery/item/delete?id=${item.id}">删除</a></td>
											</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-2">
								<a href="javascript:;" class="btn btn-primary" id="btnSelectImage">浏览并添加图片</a>
							</div>
							<div class="col-sm-10">
								
							</div>
						</div>
						</c:if>
					</form>
			 	</div>
			</div>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
   <script src="ckfinder/ckfinder.js"></script>
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuGallery').addClass('active');

var finder = new CKFinder();
finder.selectActionFunction = function(path){
	$.ajax({
		url: 'admin/gallery/${gallery.id}/addItem',
		type: 'post',
		data: {'path': path},
		success: function(){
			document.location.reload();
		},
		error: function(){
			alert('系统错误, 请稍后重试');
		}
	})
};

$('#btnSelectImage').click(function(){
	finder.popup();
})

$('.linkDeleteGalleryItem').click(function(){
	var link = $(this).attr('link');
	var that = $(this);
	if(confirm('确定删除吗?')) {
		$.ajax({
			url: link,
			success: function() {
				alert('删除成功');
				that.parent().parent().remove();
			},
			error: function() {
				alert('操作失败, 请联系技术');
			}
		})
	}
});

</script>