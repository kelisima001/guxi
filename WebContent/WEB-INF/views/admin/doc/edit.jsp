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
            <div class="content-heading">编辑文案</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<jsp:include page="../include/info.jsp" />
					<form role="form" action="admin/doc/edit" method="post" class="form-horizontal">
						<c:if test="${doc!=null}">
							<input type="hidden" name="id" value="${doc.id}" />
						</c:if>
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">标题</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="title" name="title" value="${doc.title}" />
							</div>
						</div>
						<div class="form-group">
							<label for="code" class="col-sm-2 control-label">业务键</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="code" name="code" value="${doc.code}" />
								<div style="color:red">业务键有特殊的含义, 该字段在设定之后不要修改</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="" class="col-sm-2 control-label">分类</label>
							<div class="col-sm-10">
								<select name="type" class="form-control">
									<c:set var="types" value="<%=com.smart.consts.DocType.values()%>"/>
					        		<c:forEach var="type" items="${types}">
					        			<option value="${type}" <c:if test="${type eq doc.type}">selected</c:if> >${type.description}</option>
					        		</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group" >
							<label for="content" class="col-sm-2 control-label">内容</label>
							<div class="col-sm-10">
								<textarea id="content" name="content" style="height: 300px;">${doc.content}</textarea>
							</div>
						</div>
						<div class="form-group" >
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">提交</button>
								<a href="admin/doc/list" class="btn btn-primary">返回</a>
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
$('#menuDoc').addClass('active');

var url = 'admin/dict/list?a=a';
initSimplePagination('.pageBar', url);

CKEDITOR.replace('content');
</script>