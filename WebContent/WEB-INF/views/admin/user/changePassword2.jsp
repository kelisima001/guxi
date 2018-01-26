<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - 用户管理 - 修改管理员密码</title>
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
					<div class="panel-heading">修改管理员密码</div>
					<div class="panel-body">
						<jsp:include page="../include/info.jsp" />
						<form role="form" action="admin/changePassword" method="post" class="form-horizontal">
							<div class="form-group">
								<label for="code" class="col-sm-2">旧密码</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="oldPassword" name="oldPassword" value="" />
								</div>
							</div>
							<div class="form-group">
								<label for="code" class="col-sm-2">新密码</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="password" name="password" value="" />
								</div>
							</div>
							<div class="form-group">
								<label for="code" class="col-sm-2">确认新密码</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="password1" name="password1" value="" />
								</div>
							</div>
							<button type="submit" class="btn btn-primary">提交</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
$('#mainMenu li').removeClass('active');
$('#menuPassword').addClass('active');
</script>
</html>