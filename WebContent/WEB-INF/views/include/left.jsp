<ul class="list-group" id="subMenu">
<li class="list-group-item">欢迎你, ${user.name}</li>
<sec:authorize access="hasRole('ROLE_USER')">
	<li class="list-group-item" id=""><a href="listCustomer"><span class="glyphicon glyphicon-list"></span> 客户列表</a></li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
	<!--li class="list-group-item" id=""><a href="listMyCustomer">我的客户</a></li-->
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<!--li class="list-group-item" id=""><a href="listNewCustomer">最新客户</a></li-->
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<!--li class="list-group-item" id=""><a href="listLatestUpdatedCustomer">最近跟进客户</a></li-->
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
	<li class="list-group-item" id=""><a href="editCustomer"><span class="glyphicon glyphicon-plus"></span> 添加客户</a></li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<li class="list-group-item" id=""><a href="listFollow"><span class="glyphicon glyphicon-off"></span> 最近跟进</a></li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<!--li class="list-group-item" id=""><a href="listAllHandoverCustomer">所有待交接客户</a></li-->
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
	<!--li class="list-group-item" id=""><a href="listMyHandoverCustomer">我的待交接客户</a></li-->
</sec:authorize>
	<li class="list-group-item" id="">&nbsp;</li>
<sec:authorize access="hasRole('ROLE_SUPER_ADMIN')">
	<li class="list-group-item" id=""><a href="addUser"><span class="glyphicon glyphicon-plus"></span> 添加用户</a></li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<li class="list-group-item" id=""><a href="listUser"><span class="glyphicon glyphicon-list"></span> 用户列表</a></li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
	<li class="list-group-item" id=""><a href="editUserInfo"><span class="glyphicon glyphicon-edit"></span> 修改我的资料</a></li>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
	<li class="list-group-item" id=""><a href="editUserPassword"><span class="glyphicon glyphicon-lock"></span> 修改登录密码</a></li>
</sec:authorize>
<li class="list-group-item" id=""><a href="logout"><span class="glyphicon glyphicon-off"></span> 退出</a></li>
</ul>