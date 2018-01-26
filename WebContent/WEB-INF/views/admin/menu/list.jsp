<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - 菜单管理 - 菜单列表</title>
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
					<div class="panel-heading">菜单列表 - 当前父菜单: ${parent.name}</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th width="10%">ID</th>
									<th width="10%">名称</th>
									<th width="10%">CODE</th>
									<th width="10%">URL</th>
									<th width="10%">父菜单</th>
									<th width="10%">&nbsp;</th>
									<th width="10%">&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="obj" items="${list}">
								<tr>
									<td>${obj.id}</td>
									<td>${obj.name}</td>
									<td>${obj.code}</td>
									<td>${obj.url}</td>
									<td>${obj.parent.name}</td>
									<td>
										<a target="blank" href="admin/menu/list?parentId=${obj.id}">子菜单</a> 
										<a target="blank" href="admin/menu/edit?id=${obj.id}">编辑</a>
									</td>
									<td>
										<a target="blank" href="javascript:;" class="linkDeleteObj" objId="${obj.id}">删除</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<a href="admin/menu/edit?parentId=${parent.id}" class="btn btn-primary">添加菜单</a>
						<a href="admin/menu/list?parentId=${parent.parent.id}" class="btn btn-primary">返回上级菜单</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
$('#mainMenu li').removeClass('active');
$('#menuSettings').addClass('active');
/**
var url = 'admin/menu/list?a=a';
initSimplePagination('.pageBar', url);
**/
$('.linkDeleteObj').click(function(){
	if(!confirm("确定删除？")){
		return;
	}
	var tr = $(this).parent().parent();
	$.ajax({
		url: 'admin/menu/delete?id=' + $(this).attr('objId'),
		method: 'get',
		success: function(){
			tr.fadeOut();
			tr.remove();
		},
		error: function(){
			alert('删除失败, 请确保下属子菜单已经全部删除.');
		}
	})
});

</script>
</html>