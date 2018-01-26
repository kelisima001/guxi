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
            <div class="content-heading">编辑选项类别</div>
            <div class="panel panel-default">
            	<div class="panel-body">
            		<jsp:include page="../include/info.jsp" />
					<form role="form" action="admin/selectType/edit" class="form-horizontal" method="post">
						<c:if test="${obj!=null}">
						<input type="hidden" name="id" value="${obj.id}" />
						</c:if>
						
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name" name="name" value="${obj.name}" />
							</div>
						</div>
						<div class="form-group">
							<label for="code" class="col-sm-2 control-label">业务键</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="code" name="code" value="${obj.code}" />
								<span class="red">业务键对某些系统级的选择类别具有特殊含义, 请谨慎修改</span>
							</div>
						</div>
						
						<div class="form-group">
							<label for="description" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="description" name="description" value="${obj.description}" />
							</div>
						</div>
						
						<div class="form-group" >
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">提交</button>
								<c:if test="${obj!=null}">
									<a href="admin/selectType/edit" class="btn btn-primary">新建</a>
								</c:if>
								<a class="btn btn-primary" href="admin/selectType/list">返回</a>
							</div>
						</div>
						<c:if test="${obj!=null}">
						<div class="form-group" >
							<div class="col-sm-12">
								<div class="table-responsive">
									<table class="table table-hover">
										<thead>
											<tr>
												<th width="10%">ID</th>
												<th width="10%">名称</th>
												<th width="10%">业务键</th>
												<th width="10%">状态</th>
												<th width="10%">排序</th>
												<th width="10%">修改</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${obj.items}">
												<tr itemId="${item.id}">
													<td>
														${item.id}
													</td>
													<td>
														<input class="inputName" name="" value="${item.name}" />
													</td>
													<td>
														<input class="inputCode" name="" value="${item.code}" />
													</td>
													<td>
														<smt:enumSelect cssClass="inputStatus" type="com.smart.consts.Status" value="${item.status}" name="itemStatus" />
													</td>
													<td>
														<input class="inputSort" name="" value="${item.sort}" />
													</td>
													<td>
														<a href="javascript:;" class="linkEditSelectItem">保存</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<br /><br />
						<div class="form-group" >
							<div class="col-sm-4">
								<input class="form-control" type="text" id="newSelectItemName" name="newSelectItemName" />
							</div>
							<div class="col-sm-2">
								<a href="javascript:;" id="linkAddNewSelectItem" class="btn btn-primary">添加新选项</a> 
							</div>
						</div>	
						</c:if>
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
$('#menuSelectTypeList').addClass('active');


$('.linkEditSelectItem').click(function(){
	var tr = $(this).parent().parent();
	var id = $(tr).attr('itemId');
	var name = $(tr).find('.inputName').val();
	var code = $(tr).find('.inputCode').val();
	var status = $(tr).find('.inputStatus').val();
	var sort = $(tr).find('.inputSort').val();
	
	$.ajax({
		url: 'admin/selectType/${obj.id}/saveItem',
		type: 'post',
		data: {'id': id, 'name': name, 'code': code, 'status': status, 'sort': sort},
		success: function(data){
			if(data=='EXISTS') {
				alert('添加失败,该选项已经存在');
			}
			else {
				alert("保存成功");
				document.location.reload();
			}
		},
		error: function(){
			alert('保存失败');
		}
	});
});

$('#linkAddNewSelectItem').click(function(){
	var name = $('#newSelectItemName').val();
	if(name!='') {
		$.ajax({
			url: 'admin/selectType/${obj.id}/addItem',
			type: 'post',
			data: {'name': name},
			success: function(data){
				if(data=='EXISTS') {
					alert('添加失败,该选项已经存在');
				}
				else {
					alert("保存成功");
					document.location.reload();
				}
			},
			error: function(){
				alert('保存失败');
			}
		});
	}
	else {
		alert("请输入选项名");
	}
})
</script>