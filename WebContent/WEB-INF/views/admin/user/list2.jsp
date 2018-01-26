<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - 用户管理</title>
<jsp:include page="header.jsp" />

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<jsp:include page="mainmenu.jsp" />
		</nav>
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-default">
					<div class="panel-heading">信贷经理列表</div>
					<div class="panel-body">
						<table class="table table-striped">
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
									<td><a href="admin/editUser?id=${user.id}">编辑</a></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					<jsp:include page="../include/pagination.jsp" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
$('#mainMenu li').removeClass('active');
$('#menuUser').addClass('active');

var url = 'admin/listUser?a=a';
initSimplePagination('.pageBar', url);

</script>
</html>