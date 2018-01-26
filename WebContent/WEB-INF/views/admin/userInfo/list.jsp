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
            <div class="content-heading">用户报名资料列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-hover">
							<thead>
								<tr>
									<th width="10%">ID</th>
									<th width="10%">姓名</th>
									<th width="10%">手机号</th>
									<th width="10%">邮箱</th>
									<th width="10%">渠道</th>
									<th width="10%">附加信息</th>
									<th width="10%">日期</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="obj" items="${page.content}">
								<tr>
									<td>${obj.id}</td>
									<td>${obj.name}</td>
									<td>${obj.mobile}</td>
									<td>${obj.email}</td>
									<td>${obj.channel}</td>
									<td>${obj.detail}</td>
									<td>${obj.timeCreatedStr}</td>
									<td>
										<!--a target="blank" href="javascript:;" class="linkDeleteObj" objId="${obj.id}">删除</a-->
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					 </div>
					 <jsp:include page="../include/pagination.jsp" />
			 	</div>
			</div>
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuUserInfo').addClass('active');

var url = 'admin/userInfo/list?a=a';
initSimplePagination('.pageBar', url);

$('.linkDeleteObj').click(function(){
	if(!confirm("确定删除？")){
		return;
	}
	var tr = $(this).parent().parent();
	$.ajax({
		url: 'admin/tag/delete?id=' + $(this).attr('objId'),
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