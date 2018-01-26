<!DOCTYPE html>
<html>
<head>
<title>SMART - 登录</title>
<jsp:include page="../include/head.jsp" />
</head>
<body>
	<div class="wrapper">
		<div class="block-center mt-xl wd-xl">
         <!-- START panel-->
         <div class="panel panel-dark panel-flat">
            <div class="panel-heading text-center">
               <a href="#">
                  <img src="resources/images/logo.png" alt="Image" class="block-center img-rounded">
               </a>
            </div>
            <div class="panel-body">
               <p class="text-center pv">请登录</p>
               <form method="post" action="admin/login" role="form" data-parsley-validate="" novalidate="" class="mb-lg">
                  <div class="form-group has-feedback">
                     <input id="username" name="username" type="text" placeholder="用户名" autocomplete="off" required class="form-control" />
                     <span class="fa fa-user form-control-feedback text-muted"></span>
                  </div>
                  <div class="form-group has-feedback">
                     <input id="password" name="password" type="password" placeholder="密码" required class="form-control" />
                     <span class="fa fa-lock form-control-feedback text-muted"></span>
                  </div>
                  <div class="clearfix">
                     <div class="checkbox c-checkbox pull-left mt0">
                        <label>
                           <input type="checkbox" value="" name="remember">
                           <span class="fa fa-check"></span>Remember Me</label>
                     </div>
                     <div class="pull-right"><!--a href="recover.html" class="text-muted">Forgot your password?</a-->
                     </div>
                  </div>
                  <button type="submit" class="btn btn-block btn-primary mt-lg">Login</button>
               </form>
            </div>
         </div>
         <div class="p-lg text-center">
            <span>&copy;</span>
            <span>2017</span>
            <span>-</span>
            <span>SMART</span>
         </div>
      </div>
	</div>
</body>
</html>
<script>
	
</script>