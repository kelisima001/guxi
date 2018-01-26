<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - 系统管理 - 验证码列表</title>
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
					<div class="panel-heading">验证码列表</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th width="10%">ID</th>
									<th width="10%">发送时间</th>
									<th width="10%">手机号</th>
									<th width="10%">验证码</th>
									<th width="10%">发送成功</th>
									<th width="10%">已使用</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="code" items="${page.content}">
								<tr>
									<td>${code.id}</td>
									<td>${code.timeCreated}</td>
									<td>${code.mobile}</td>
									<td>${code.code}</td>
									<td>${code.success}</td>
									<td>${code.used}</td>
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
$('#menuVerifyCode').addClass('active');

var url = 'admin/listVerifyCode?a=a';
initSimplePagination('.pageBar', url);

</script>
</html>