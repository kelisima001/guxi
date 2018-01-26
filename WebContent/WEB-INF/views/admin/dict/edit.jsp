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
            <div class="content-heading">编辑字典</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<jsp:include page="../include/info.jsp" />
					<form role="form" action="admin/dict/edit" class="form-horizontal" method="post">
						<c:if test="${dict!=null}">
						<input type="hidden" name="id" value="${dict.id}" />
						</c:if>
						
						<div class="form-group">
							<label for="module" class="col-sm-2 control-label">所属模块</label>
							<div class="col-sm-4">
								<select name="module" class="form-control">
									<option value="sys" <c:if test="${dict.module eq 'sys'}">selected</c:if>>系统模块</option>
									<option value="pay" <c:if test="${dict.module eq 'pay'}">selected</c:if>>支付模块</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">名称</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="name" name="name" value="${dict.name}" />
							</div>
						</div>
						<div class="form-group">
							<label for="code" class="col-sm-2 control-label">业务键</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="code" name="code" value="${dict.code}" />
							</div>
						</div>
						<div class="form-group" >
							<label for="value" class="col-sm-2 control-label">值</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="value" name="value" value="${dict.value}" />
							</div>
						</div>
						<!--div class="form-group" >
							<label for="value" class="col-sm-2 control-label">值类型</label>
							<div class="col-sm-10">
								<c:set var="vtypes" value="<%=com.smart.consts.DictValueType.values()%>"/>
				        		<c:forEach var="type" items="${vtypes}">
				        		<label class="radio-inline c-radio">
                                	<input id="" type="radio" name="vtype" value="${type}" <c:if test="${type eq dict.vtype}">checked</c:if> />
                                	<span class="fa fa-circle"></span>
                                	${type.description}
                                </label>
				        		</c:forEach>
							</div>
						</div-->
						
						<div class="form-group" >
							<label for="value" class="col-sm-2 control-label">值类型1</label>
							<div class="col-sm-4">
				        		<smt:enumSelect type="com.smart.consts.DictValueType" value="${dict.vtype}" name="vtype" id="vtype" />
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
</body>
</html>
<script>
$('#mainMenu li').removeClass('active');
$('#menuBaseData').addClass('active');
$('#menuDictEdit').addClass('active');

var url = 'admin/dict/list?a=a';
initSimplePagination('.pageBar', url);
</script>