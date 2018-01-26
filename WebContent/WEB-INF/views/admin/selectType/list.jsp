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
            <div class="content-heading">选项类型列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-striped table-hover">
							<thead>
								<tr>
									<th width="10%">名称</th>
									<th width="10%">业务键</th>
									<th width="10%">描述</th>
									<th width="10%">&nbsp;</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="obj" items="${page.content}">
								<tr>
									<td title="${obj.id}">${obj.name}</td>
									<td>${obj.code}</td>
									<td>${obj.description}</td>
									<td><a href="admin/selectType/edit?id=${obj.id}">编辑</a></td>
									<td>
									<c:if test="${user.superAdmin}">
										<!--a target="blank" href="javascript:;" class="linkDeleteObj" objId="${obj.id}">删除</a-->
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
			<a href="admin/selectType/edit" class="btn btn-primary">添加选项类型</a>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuBaseData').addClass('active');
$('#menuSelectTypeList').addClass('active');

var url = 'admin/selectType/list?a=a';
initSimplePagination('.pageBar', url);


</script>