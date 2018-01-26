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
            <div class="content-heading">编辑发展历程</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<jsp:include page="../include/info.jsp" />
					<form role="form" action="admin/companyHistory/edit" method="post" class="form-horizontal">
						<c:if test="${obj!=null}">
							<input type="hidden" name="id" value="${obj.id}" />
						</c:if>
						<div class="form-group">
							<label for="date" class="col-sm-2 control-label">日期</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="date" name="date" value="${obj.date}" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="event" class="col-sm-2 control-label">事件</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="event" name="event" value="${obj.event}" />
							</div>
						</div>
						<div class="form-group">
							<label for="description" class="col-sm-2 control-label">详情</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="description" name="description" value="${obj.description}" />
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
						<div class="form-group" >
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">提交</button>
								<a href="admin/companyHistory/list" class="btn btn-primary">返回</a>
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
$('#menuHistory').addClass('active');

$('#image').focus(function(){
	var that = $(this);
	var finder = new CKFinder();
	finder.selectActionFunction = function(path){
		$(that).val(path);
		$('#imagePreview').attr('src', path).css('width', '100%').css('height', 'auto').show();
	};

	finder.popup();
})
</script>