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
            <div class="content-heading">编辑管理员用户</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<jsp:include page="../include/info.jsp" />
					<form role="form" action="admin/editAdmin" method="post" class="form-horizontal">
					<c:if test="${user!=null}">
					<input type="hidden" name="id" value="${user.id}" />
					</c:if>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">手机号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="username" name="username" value="${user.username}" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name" value="${user.name}" />
						</div>
					</div>
					<div class="form-group">
						<label for="image" class="col-sm-2 control-label">头像</label>
						<div class="col-sm-8" id="divSpuImage">
							<input type="text" class="form-control" id="avatar" name="avatar" value="${user.avatar}" /><br />
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#imageSelectorModal">选择图片</button>
						</div>
					</div>
					
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">&nbsp;</label>
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary">提交</button>
							<a href="admin/listAdmin" class="btn btn-primary">返回</a>
						</div>
					</div>
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
$('#menuListAdmin').addClass('active');
</script>