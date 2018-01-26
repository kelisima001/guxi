<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - XX管理 - 编辑XX</title>
<jsp:include page="../header.jsp" />
<!--link rel =stylesheet href="ueditor/themes/default/css/ueditor.css" /-->
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<jsp:include page="../mainmenu.jsp" />
		</nav>
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-default">
					<div class="panel-heading">编辑菜单</div>
					<div class="panel-body">
						<jsp:include page="../../include/info.jsp" />
						<form role="form" action="admin/menu/edit" method="post" class="form-horizontal">
							<c:if test="${obj!=null && obj.id ne null}">
								<input type="hidden" name="id" value="${obj.id}" />
							</c:if>
							<c:if test="${obj!=null && obj.parent ne null}">
								<div class="form-group">
									<label for="title" class="col-sm-2 control-label">父菜单</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" disabled value="${obj.parent.name}" />
										<input type="hidden" name="parent.id" value="${obj.parent.id}" />
									</div>
								</div>
							</c:if>
							<div class="form-group">
								<label for="title" class="col-sm-2 control-label">名称(即菜单文字)</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name" name="name" value="${obj.name}" />
								</div>
							</div>
							<div class="form-group">
								<label for="title" class="col-sm-2 control-label">CODE</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="code" name="code" value="${obj.code}" />
								</div>
							</div>
							<div class="form-group">
								<label for="title" class="col-sm-2 control-label">URL</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="url" name="url" value="${obj.url}" />
								</div>
							</div>
							<div class="form-group" >
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">提交</button>
									<a href="admin/menu/list?parentId=${obj.parent.id}" class="btn btn-primary">返回列表</a>	
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<!--script src="ueditor/ueditor.config.js"></script-->
<!--script src="ueditor/ueditor.all.js"></script-->
<script>
$('#mainMenu li').removeClass('active');
$('#menuSettings').addClass('active');
/**
var editor = new UE.ui.Editor();
editor.render("content");
*/
</script>
</html>