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
            <div class="content-heading">字典列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-striped table-hover">
							<thead>
								<tr>
									<th width="10%">名称</th>
									<th width="10%">类别</th>
									<th width="10%">图片</th>
									<th width="10%">排序</th>
									<th width="10%">&nbsp;</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="prod" items="${page.content}">
								<tr>
									<td title="${prod.id}">${prod.name}</td>
									<td>${prod.type.name}</td>
									<td><img src="${prod.image}" style="width:80px; height: 80px;" /></td>
									<td>${prod.sort}</td>
									<td>
										<a href="admin/product/edit?id=${prod.id}">编辑</a>
									</td>
									<td>
										<c:if test="${user.superAdmin}">
										<a target="blank" href="javascript:;" class="linkDeleteObj" objId="${prod.id}">删除</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
							</tbody>
					 	</table>
					 </div>
					 <jsp:include page="../include/pagination.jsp" />
			 	</div>
			</div>
			<a href="admin/product/edit" class="btn btn-primary">添加产品</a>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuProduct').addClass('active');

var url = 'admin/product/list?a=a';
initSimplePagination('.pageBar', url);

$('.linkDeleteObj').click(function(){
	if(!confirm("确定删除？")){
		return;
	}
	var tr = $(this).parent().parent();
	$.ajax({
		url: 'admin/product/delete?id=' + $(this).attr('objId'),
		method: 'get',
		success: function(){
			tr.fadeOut();
			tr.remove();
		},
		error: function(){
			alert('删除失败.');
		}
	})
});
</script>