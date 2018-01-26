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
            <div class="content-heading">资讯打标签列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-hover">
							<thead>
								<tr>
									<th width="10%">资讯ID</th>
									<th width="10%">资讯标题</th>
									<th width="10%">标签ID</th>
									<th width="10%">标签名</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="obj" items="${page.content}">
								<tr>
									<td>${obj.info.id}</td>
									<td>${obj.info.title}</td>
									<td>${obj.tag.id}</td>
									<td>${obj.tag.name}</td>
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
         </div>
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuInfoTag').addClass('active');

var url = 'admin/infoTag/list?a=a';
initSimplePagination('.pageBar', url);

$('.linkDeleteObj').click(function(){
	if(!confirm("确定删除？")){
		return;
	}
	var tr = $(this).parent().parent();
	$.ajax({
		url: 'admin/infoTag/delete?id=' + $(this).attr('objId'),
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