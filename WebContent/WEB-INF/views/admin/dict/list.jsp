<!DOCTYPE html>
<html>
<head>
<title>SMART - Dashboard</title>
<jsp:include page="../include/head.jsp" />
<style>
td input{
	width: 80%;
}
</style>
</head>
<body>
   <div class="wrapper">
      <!-- 导航区 -->
      <jsp:include page="../include/topnav.jsp" />
      <!-- 左侧菜单区 -->
      <jsp:include page="../include/menu.jsp">
      	<jsp:param value="" name="selectedItem" />
      </jsp:include>
      <!-- 右侧边栏 -->
      <jsp:include page="../include/right.jsp" />
      <!-- Main section-->
      <section>
         <!-- Page content-->
         <div class="content-wrapper">
            <div class="content-heading">字典列表</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<div class="table-responsive">
			            <table class="table table-striped table-hover">
							<thead>
								<tr>
									<!--th width="10%">所属模块</th-->
									<th width="10%">名称</th>
									<th width="15%">业务键</th>
									<th width="35%">值</th>
									<th width="10%">编辑</th>
									<th width="10%">删除</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="dict" items="${page.content}">
								<tr dictId="${dict.id}">
									<td><input value="${dict.name}" class="dictName" /></td>
									<td><input value="${dict.code}" class="dictCode" disabled /></td>
									<td class="value"><input value="${dict.value}" class="dictValue" /></td>
									<td>
										<!--a target="blank" href="admin/dict/edit?id=${dict.id}">编辑</a-->
										<a href="javascript:;" class="btnEditObj">保存修改</a> 
									</td>
									<td>
									<c:if test="${user.superAdmin}">
										<a target="blank" href="javascript:;" class="linkDeleteObj" objId="${dict.id}">删除</a>
									</c:if>
									</td>
								</tr>
							</c:forEach>
							</tbody>
					 	</table>
					 </div>
					 <jsp:include page="../include/pagination.jsp" />
			 	</div>
			</div>
			<a href="admin/dict/edit" class="btn btn-primary">添加字典项</a>
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
$('#menuDictList').addClass('active');

var url = 'admin/dict/list?a=a';
initSimplePagination('.pageBar', url);

$('.linkDeleteObj').click(function(){
	if(!confirm("确定删除？")){
		return;
	}
	var tr = $(this).parent().parent();
	$.ajax({
		url: 'admin/dict/delete?id=' + $(this).attr('objId'),
		method: 'get',
		success: function(){
			tr.fadeOut();
			tr.remove();
		},
		error: function(){
			alert('删除失败.');
		}
	})
});

$('.btnEditObj').click(function(){
	var tr = $(this).parent().parent();
	var id = $(tr).attr('dictId');
	var module = $(tr).find('.dictModuleSel').val();
	var name = $(tr).find('.dictName').val();
	var code = $(tr).find('.dictCode').val();
	var value = $(tr).find('.dictValue').val();
	
	/** Ajax范本 若无必要, 无需再写回调, 因为在main.js设置了全局回调, 但是此处写回调则可以覆盖全局的回调 **/
	$.ajax({
		url: 'admin/dict/edit1',
		type: 'post',
		data: {'id': id, 'name': name, 'code': code, 'value': value}
	})
});
</script>