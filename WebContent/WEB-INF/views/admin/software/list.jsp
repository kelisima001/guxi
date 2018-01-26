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
            <div class="content-heading">软件列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-hover">
							<thead>
								<tr>
									<th width="10%">名称</th>
									<th width="10%">简介</th>
									<th width="10%">图片</th>
									<th width="10%">&nbsp;</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="obj" items="${page.content}">
								<tr>
									<td title="${obj.id}">${obj.name}</td>
									<td>${obj.shortDescription}</td>
									<td><img src="${obj.image}" style="width:80px; height: 80px;" /></td>
									<td>
										<a href="admin/software/edit?id=${obj.id}">编辑</a>
									</td>
									<td>
										<c:if test="${user.superAdmin}">
										<a target="blank" href="javascript:;" class="linkDeleteObj" objId="${obj.id}">删除</a>
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
			<a href="admin/software/edit" class="btn btn-primary">添加软件</a>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuSoftware').addClass('active');

var url = 'admin/software/list?a=a';
initSimplePagination('.pageBar', url);

$('.linkDeleteObj').click(function(){
	if(!confirm("确定删除？")){
		return;
	}
	var tr = $(this).parent().parent();
	$.ajax({
		url: 'admin/software/delete?id=' + $(this).attr('objId'),
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