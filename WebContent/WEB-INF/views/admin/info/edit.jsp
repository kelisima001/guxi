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
            <div class="content-heading">编辑资讯</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<jsp:include page="../include/info.jsp" />
					<form role="form" action="admin/info/edit" method="post" class="form-horizontal">
						<c:if test="${obj ne null}">
						<input type="hidden" name="id" value="${obj.id}" />
						<div class="form-group">
							<label for="title" class="col-sm-3 control-label">标签</label>
							<div class="col-sm-9" id="tags">
								<c:forEach var="tag" items="${tags}">
									<label><input type="checkbox" value="${tag.id}"  <c:if test="${tag.used}">checked</c:if> />${tag.name}</label>
								</c:forEach>
							</div>
						</div>
						</c:if>
						<div class="form-group">
							<label for="title" class="col-sm-3 control-label">类别</label>
							<div class="col-sm-9">
								<smt:select code="info.type" selectedItemId="${obj.type.id}" name="type.id" id="infoTypeSelect" />
							</div>
						</div>
						<div class="form-group">
							<label for="title" class="col-sm-3 control-label">标题 (必填)<br />最佳展示长度为15-25个中文字符</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="title" name="title" value="${obj.title}" />
							</div>
						</div> 
						<div class="form-group">
							<label for="title" class="col-sm-3 control-label">标题图片(必填)</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="image" name="image" value="${obj.image}" />
								<span style="color:red">最佳展示比例: ?</span><br />
								<c:choose>
									<c:when test="${obj==null || obj.image==null || obj.image==''}"><img src="resources/images/blank.png" id="imagePreview" style="width: 1px; height: 1px; font-size: 1px;" /></c:when>
									<c:otherwise><img src="${obj.image}" onerror="this.src='resources/images/blank.png';" style="width:100%; height: auto;" id="imagePreview" /></c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="form-group">
							<label for="abstraction" class="col-sm-3 control-label">摘要 (必填)<br />最佳展示长度为50-75个中文字符</label>
							<div class="col-sm-9">
								<textarea class="form-control" id="abstraction" name="abstraction" rows="2">${obj.abstraction}</textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="author" class="col-sm-3 control-label">作者(可不填)</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="author" name="author" value="${obj.author}" />
							</div>
						</div>
						<div class="form-group" class="col-sm-3 control-label">
							<label for="source" class="col-sm-3 control-label">来源(可不填)</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="source" name="source" value="${obj.source}" />
							</div>
						</div>
						<div class="form-group" class="col-sm-3 control-label">
							<label for="source" class="col-sm-3 control-label">发布日期(可不填)</label>
							<div class="col-sm-9">
								<input type="text" class="form-control date" id="timeCreatedStr2" name="timeCreatedStr2" data-date-format="yyyy-mm-dd" value="${obj.timeCreatedStr2}" />
							</div>
						</div>
						<div class="form-group" class="col-sm-3 control-label">
							<label for="source" class="col-sm-3 control-label">排序</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="sort" name="sort" value="${obj==null?0:obj.sort}" />
							</div>
						</div>
						<div class="form-group">
							<label for="content" class="col-sm-3 control-label">内容 (最大字符数4000)</label>
							<div class="col-sm-9">
								<textarea class="" id="content" name="content" rows="5">${obj.content}</textarea>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">提交</button>  
						<a href="admin/info/list" class="btn btn-primary">返回到列表页</a>
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
$('#menuInfo').addClass('active');

CKEDITOR.replace('content');

$('#image').focus(function(){
	var that = $(this);
	var finder = new CKFinder();
	finder.selectActionFunction = function(path){
		$(that).val(path);
		$('#imagePreview').attr('src', path).css('width', '100%').css('height', 'auto').show();
	};

	finder.popup();
})

<c:if test="${obj ne null}">
$('#tags input').click(function() {
	var checked = $(this).is(':checked');
	var tagId = $(this).val();
	if(checked) {
		$.ajax({
			url: 'infoTag/add',
			data: {'infoId': '${obj.id}', 'tagId': tagId},
			success: function() {
				//alert('操作成功');
			},
			error: function() {
				alert('操作失败');
			}
		});
	}
	else {
		$.ajax({
			url: 'infoTag/delete',
			data: {'infoId': '${obj.id}', 'tagId': tagId},
			success: function() {
				//alert('操作成功');
			},
			error: function() {
				alert('操作失败');
			}
		});
	}
})
</c:if>
</script>