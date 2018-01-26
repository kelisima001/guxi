<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - 用户管理 - 编辑用户</title>
<jsp:include page="header.jsp" />
<style>
.modal-body img{
	width: 110px;
	height: 110px;
	float: left;
	margin: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<jsp:include page="mainmenu.jsp" />
		</nav>
		<div class="row">
			<div class="col-xs-12">
				<jsp:include page="../include/info.jsp" />
				<form role="form" action="admin/editUser" method="post" class="form-horizontal">
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
							<c:choose>
								<c:when test="${user.avatar ne null && user.avatar ne ''}">
									<img id="avatarImage" style="border: dashed #ccc 1px; border-radius: 5px;" class="image-responsive" src="${user.avatar}" />
								</c:when>
								<c:otherwise>
									<img id="avatarImage" style="border: dashed #ccc 1px; border-radius: 5px;" class="image-responsive" src="upload/avatar.jpg" />
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">总收益</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="totalProfit" name="totalProfit" value="${user.totalProfit}" />
						</div>
					</div>
					<!--div class="form-group">
						<label for="description" class="col-sm-2 control-label">余额</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" name="email" value="${user.email}" />
						</div>
					</div-->
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">&nbsp;</label>
						<div class="col-sm-10">
							<button type="submit" class="btn btn-primary">提交</button>
							<a href="admin/listUser" class="btn btn-primary">返回</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../include/imageSelector.jsp" />
</body>
<script>
$('#mainMenu li').removeClass('active');
$('#menuUser').addClass('active');

$('.modal-body img').click(function(){
	var imagePath = $(this).attr('title');
	$('#avatar').val(imagePath);
	if($('#avatarImage').length!=0){
		$('#avatarImage').attr('src', imagePath);
	}
});
</script>
</html>