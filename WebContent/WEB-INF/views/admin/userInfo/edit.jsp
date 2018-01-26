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
            <div class="content-heading">编辑xx</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<jsp:include page="../include/info.jsp" />
					<form role="form" action="admin/tag/edit" method="post" class="form-horizontal">
						<c:if test="${obj!=null}">
							<input type="hidden" name="id" value="${obj.id}" />
						</c:if>
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">标签名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name" name="name" value="${obj.name}" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="code" class="col-sm-2 control-label">业务键</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="code" name="code" value="${obj.code}" /><br />
								<span class="red">业务键对某些系统级的标签有重要作用, 不要轻易改动</span>
							</div>
						</div>
						
						<div class="form-group">
							<label for="type" class="col-sm-2 control-label">标签类别</label>
							<div class="col-sm-10">
								<smt:enumSelect cssClass="form-control" type="com.smart.consts.TagType" 
										value="${obj.type}" name="type" id="type" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="status" class="col-sm-2 control-label">可用状态</label>
							<div class="col-sm-10">
								<smt:enumSelect cssClass="form-control" type="com.smart.consts.Status" 
										value="${obj.status}" name="status" id="status" />
							</div>
						</div>
						
						<div class="form-group" >
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">提交</button>
								<a href="admin/tag/list" class="btn btn-primary">返回列表页</a>	
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
$('#menuBaseData').addClass('active');
$('#menuTagEdit').addClass('active');

</script>