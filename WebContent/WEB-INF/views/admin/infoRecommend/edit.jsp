<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - 资讯管理 - 编辑资讯推荐</title>
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
					<div class="panel-heading">编辑资讯推荐</div>
					<div class="panel-body">
						<jsp:include page="../../include/info.jsp" />
						<form role="form" action="admin/infoRecommend/edit" method="post" class="form-horizontal">
							<c:if test="${obj!=null}">
								<input type="hidden" name="id" value="${obj.id}" />
							</c:if>
							<div class="form-group">
								<label for="sort" class="col-sm-2 control-label">资讯标题</label>
								<div class="col-sm-10">
									<span class="form-control">${obj.info.title}</span>
								</div>
							</div>
							<div class="form-group">
								<label for="sort" class="col-sm-2 control-label">排序</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="sort" name="sort" value="${obj.sort}" />
								</div>
							</div>
														
							<div class="form-group" >
								<div class="col-sm-2"></div>
								<div class="col-sm-10"><button type="submit" class="btn btn-primary">提交</button></div>
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
/**
var editor = new UE.ui.Editor();
editor.render("content");
*/
</script>
</html>