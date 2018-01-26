<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - 资讯推荐管理 - 资讯推荐列表</title>
<jsp:include page="../header.jsp" />

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<jsp:include page="../mainmenu.jsp" />
		</nav>
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-default">
					<div class="panel-heading">资讯推荐列表</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th width="10%">ID</th>
									<th width="10%">推荐类型</th>
									<th width="10%">资讯标题</th>
									<th width="10%">排序</th>
									<th width="10%">添加日期</th>
									<th width="10%">&nbsp;</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="obj" items="${page.content}">
								<tr>
									<td>${obj.id}</td>
									<td>${obj.type.description}</td>
									<td>${obj.info.title}</td>
									<td>${obj.sort}</td>
									<td>${obj.timeCreatedStr}</td>
									<td><a target="blank" href="admin/infoRecommend/edit?id=${obj.id}">编辑</a></td>
									<td>
										<a target="blank" href="javascript:;" class="linkDeleteObj" objId="${obj.id}">删除</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<!--a href="admin/infoRecommend/edit" class="btn btn-primary">添加XX</a-->
						<jsp:include page="../../include/pagination.jsp" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>

var url = 'admin/infoRecommend/list?a=a';
initSimplePagination('.pageBar', url);

$('.linkDeleteObj').click(function(){
	if(!confirm("确定删除？")){
		return;
	}
	var tr = $(this).parent().parent();
	$.ajax({
		url: 'admin/infoRecommend/delete?id=' + $(this).attr('objId'),
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
</html>