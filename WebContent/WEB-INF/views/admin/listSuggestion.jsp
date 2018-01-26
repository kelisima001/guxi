<!DOCTYPE html>
<html lang="en">
<head>
<title>SMART后台管理 - 用户留言</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<jsp:include page="mainmenu.jsp" />
		</nav>
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-default">
				  <div class="panel-heading">用户留言列表</div>
				  <div class="panel-body">
				 	<table class="table">
						<thead>
							<tr>
								<th width="10%">姓名</th>
								<th width="10%">电话</th>
								<th width="30%">内容</th>
								<th width="10%">添加时间</th>
								<th width="10%">&nbsp;</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="suggestion" items="${page.content}">
							<tr>
								<td>${suggestion.name}</td>
								<td>${suggestion.tel}</td>
								<td><textarea style="width:100%; height: 60px;">${suggestion.content}</textarea></td>   
								<td>${suggestion.timeCreatedStr}</td>
								<td>
									&nbsp;
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<jsp:include page="../include/pagination.jsp" />
				  </div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
$('#mainMenu li').removeClass('active');
$('#menuSuggestion').addClass('active');



</script>
</html>