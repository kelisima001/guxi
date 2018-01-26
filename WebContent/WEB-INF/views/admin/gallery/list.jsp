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
      <jsp:include page="../include/menu.jsp">
      	<jsp:param value="" name="selectedItem" />
      </jsp:include>
      <!-- 右侧边栏 -->
      <jsp:include page="../include/right.jsp" />
      <!-- Main section-->
      <section>
         <!-- Page content-->
         <div class="content-wrapper">
            <div class="content-heading">轮播相册列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-hover">
							<thead>
								<tr>
									<th width="10%">ID</th>
									<th width="10%">CODE</th>
									<th width="10%">名称</th>
									<th width="10%">播放间隔</th>
									<th width="10%">&nbsp;</th>
									<!--th width="10%">&nbsp;</th-->
								</tr>
							</thead>
							<tbody>
							<c:forEach var="gallery" items="${page.content}">
								<tr>
									<td>${gallery.id}</td>
									<td>${gallery.code}</td>
									<td>${gallery.name}</td>
									<td>${gallery.playInterval}</td>
									<td><a href="admin/gallery/edit?id=${gallery.id}">编辑</a></td>
									<!--td><a target="blank" href="javascript:;" class="linkDeleteGallery" objId="${gallery.id}">删除</a></td-->
								</tr>
							</c:forEach>
							</tbody>
						</table>
					 </div>
					 <jsp:include page="../include/pagination.jsp" />
			 	</div>
			</div>
			<a href="admin/gallery/edit" class="btn btn-primary">添加相册</a>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuGallery').addClass('active');

var url = 'admin/gallery/list?a=a';
initSimplePagination('.pageBar', url);
</script>