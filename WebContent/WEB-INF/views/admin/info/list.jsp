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
            <div class="content-heading">资讯列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div>
            			<c:forEach var="type" items="${infoTypes}">
            				<a class="btn btn-default <c:if test="${cond.typeId eq type.id}">btn-primary</c:if>" href="admin/info/list?typeId=${type.id}">${type.name}</a>
            			</c:forEach>
            			
            		</div>
            		<div class="table-responsive">
			            <table class="table">
							<thead>
								<tr>
									<th width="10%">标题</th>
									<th width="10%">图片</th>
									<th width="10%">分类</th>
									<th width="30%">内容</th>
									<th width="10%">添加时间</th>
									<th width="10%">排序</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="info" items="${page.content}">
								<tr>
									<td>${info.title}</td>
									<td>
										<img src="${info.image}" width="50" height="50" class="img-responsive" />
									</td>
									
									<td>${info.type.name}</td>
									<td><textarea style="width:100%; height: 60px;">${info.content}</textarea></td>   
									<td>${info.timeCreatedStr}</td>
									<td>${info.sort}</td>
									<td>
										<a href="admin/info/edit?id=${info.id}">编辑</a>
										<a href="javascript:;" class="linkDeleteInfo" link="admin/info/delete?id=${info.id}">删除</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					 </div>
					 <jsp:include page="../include/pagination.jsp" />
			 	</div>
			</div>
			<a href="admin/info/edit" class="btn btn-primary">添加资讯</a>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuInfo').addClass('active');

var url = 'admin/info/list?a=a';
<c:if test="${cond.typeId ne null}">
url += '&typeId=${cond.typeId}';
</c:if>

initSimplePagination('.pageBar', url);

$('.linkDeleteInfo').click(function(){
	var link = $(this).attr('link');
	var tr = $(this).parent().parent();
	if(confirm('确认删除吗?')) {
		$.ajax({
			url: link,
			success: function() {
				alert("删除成功");
				tr.remove();
			},
			error: function() {
				alert("删除失败,  请稍后重试");
			}
		})
	}
});
</script>