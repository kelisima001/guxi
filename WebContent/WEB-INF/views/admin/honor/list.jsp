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
            <div class="content-heading">企业荣誉列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-hover">
							<thead>
								<tr>
									<th width="10%">称号</th>
									<th width="10%">描述</th>
									<th width="10%">图片</th>
									<th width="10%">颁发日期</th>
									<th width="10%">颁发机构</th>
									<th width="10%"></th>
									<th width="10%"></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="obj" items="${page.content}">
								<tr>
									<td title="${obj.id}">${obj.title}</td>
									<td>${obj.description}</td>
									<td><img src="${obj.image}" width="80" height="60" /></td>
									<td><fmt:formatDate value="${obj.issueDate}" pattern="yyyy-MM-dd"/></td>
									<td>${obj.issuer}</td>
									<td><a target="blank" href="admin/honor/edit?id=${obj.id}">编辑</a></td>
									<td>
										<a target="blank" href="javascript:;" class="linkDeleteObj" objId="${obj.id}">删除</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					 </div>
					 <jsp:include page="../include/pagination.jsp" />
			 	</div>
			</div>
			<a href="admin/honor/edit" class="btn btn-primary">添加荣誉</a>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuHonor').addClass('active');

var url = 'admin/honor/list?a=a';
initSimplePagination('.pageBar', url);

$('.linkDeleteObj').click(function(){
	if(!confirm("确定删除？")){
		return;
	}
	var tr = $(this).parent().parent();
	$.ajax({
		url: 'admin/honor/delete?id=' + $(this).attr('objId'),
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