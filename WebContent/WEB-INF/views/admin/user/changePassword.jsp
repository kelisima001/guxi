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
      <jsp:include page="../include/menu.jsp" />
      <!-- 右侧边栏 -->
      <jsp:include page="../include/right.jsp" />
      <!-- Main section-->
      <section>
         <!-- Page content-->
         <div class="content-wrapper">
            <div class="content-heading">修改密码</div>
            <div class="panel panel-default">
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
      </section>
      <jsp:include page="../include/footer.jsp" />
   </div>
   <jsp:include page="../include/script.jsp" />
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuAdminTool').addClass('active');
$('#menuChangePassword').addClass('active');

</script>