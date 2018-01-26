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
            <div class="content-heading">管理员列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-striped table-hover">
							<thead>
								<tr>
									<th width="10%">称呼</th>
									<th width="10%">手机</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="user" items="${page.content}">
								<tr>
									<td title="${user.password}">${user.name}</td>
									<td>${user.username}</td>
									<td><a href="admin/editAdmin?id=${user.id}">编辑</a></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					 </div>
					 <jsp:include page="../include/pagination.jsp" />
			 	</div>
			</div>
			<a href="admin/editAdmin" class="btn btn-primary">添加管理员</a>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuAdminTool').addClass('active');
$('#menuListAdmin').addClass('active');

var url = 'admin/listAdmin?a=a';
initSimplePagination('.pageBar', url);
</script>