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
            <div class="content-heading">文案列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table">
							<thead>
								<tr>
									<th width="10%">业务键</th>
									<th width="10%">标题</th>
									<th width="10%">分类</th>
									<th width="30%">内容</th>
									<th width="10%">添加时间</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="doc" items="${page.content}">
								<tr>
									<td>${doc.code}</td>
									<td>${doc.title}</td>
									<td>${doc.type.description}</td>
									<td><textarea style="width:100%; height: 60px;">${doc.content}</textarea></td>   
									<td>${doc.timeCreatedStr}</td>
									<td><a target="blank" href="admin/doc/edit?id=${doc.id}">编辑</a></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					 </div>
					 <jsp:include page="../include/pagination.jsp" />
			 	</div>
			</div>
			<a href="admin/doc/edit" class="btn btn-primary">添加文案</a>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuDoc').addClass('active');

var url = 'admin/doc/list?a=a';
initSimplePagination('.pageBar', url);
</script>