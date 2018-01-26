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
            <div class="content-heading">注入收录列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-hover">
							<thead>
								<tr>
									<th width="10%">ID</th>
									<th width="10%">url</th>
									<th width="10%">cookie</th>
									<th width="10%">detail</th>
									<th width="10%">time</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="obj" items="${page.content}">
								<tr>
									<td>${obj.id}</td>
									<td>${obj.url}</td>
									<td>${obj.cookie}</td>
									<td>${obj.detail}</td>
									<td>${obj.timeCreatedStr}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					 </div>
					 <jsp:include page="../include/pagination.jsp" />
			 	</div>
			</div>
			<a href="admin/injectInfo/edit" class="btn btn-primary">添加xxx</a>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuInject').addClass('active');

var url = 'admin/injectInfo/list?a=a';
initSimplePagination('.pageBar', url);

</script>