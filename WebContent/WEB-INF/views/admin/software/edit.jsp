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
            <div class="content-heading">编辑软件</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<jsp:include page="../include/info.jsp" />
					<form role="form" action="admin/software/edit" method="post" class="form-horizontal">
						<c:if test="${obj!=null}">
						<input type="hidden" name="id" value="${obj.id}" />
						</c:if>
						
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">名称</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="name" name="name" value="${obj.name}" />
							</div>
						</div>

						<div class="form-group">
							<label for="shortDescription" class="col-sm-2 control-label">简述</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="shortDescription" name="shortDescription" value="${obj.shortDescription}" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="sort" class="col-sm-2 control-label">排序</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="sort" name="sort" value="${obj.sort}" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="image" class="col-sm-2 control-label">图片</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="image" name="image" value="${obj.image}" /><br />
								<c:choose>
									<c:when test="${obj==null || obj.image==null || obj.image==''}"><img src="resources/images/blank.png" id="imagePreview" style="width: 1px; height: 1px; font-size: 1px;" /></c:when>
									<c:otherwise><img src="${obj.image}" onerror="this.src='resources/images/blank.png';" style="width:100%; height: auto;" id="imagePreview" /></c:otherwise>
								</c:choose>
							</div>
						</div>
						
						<div class="form-group">
							<label for="url" class="col-sm-2 control-label">下载地址</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="url" name="url" value="${obj.url}" />
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="col-sm-2 control-label">内容 (最大字符数4000)</label>
							<div class="col-sm-10">
								<textarea class="" id="description" name="description" rows="5">${obj.description}</textarea>
							</div>
						</div>
						<div class="form-group" >
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">提交</button>
								<c:if test="${dict!=null}">
									<a href="admin/dict/edit" class="btn btn-primary">新建</a>
								</c:if>
								<a class="btn btn-primary" href="admin/dict/list">返回</a>
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
   <script src="ckfinder/ckfinder.js"></script>
   <script src="ckeditor/ckeditor.js"></script>
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuSoftware').addClass('active');

$('#image').focus(function(){
	var that = $(this);
	var finder = new CKFinder();
	finder.selectActionFunction = function(path){
		$(that).val(path);
		$('#imagePreview').attr('src', path).css('width', '100%').css('height', 'auto').show();
	};

	finder.popup();
})

CKEDITOR.replace('description');
</script>