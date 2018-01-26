<!DOCTYPE html>
<html>
<head>
<title>SMART - Dashboard</title>
<jsp:include page="include/head.jsp" />
</head>
<body>
   <div class="wrapper">
      <!-- 导航区 -->
      <jsp:include page="include/topnav.jsp" />
      <!-- 左侧菜单区 -->
      <jsp:include page="include/menu.jsp" />
      <!-- 右侧边栏 -->
      <jsp:include page="include/right.jsp" />
      <!-- Main section-->
      <section>
         <!-- Page content-->
         <div class="content-wrapper">
            <div class="content-heading">
               管理首页<img src="<%=request.getScheme()%>://i.inviteyou.cn/blank.jpg" style="display:none;" />
            </div>
            <div class="row">
            	<div class="col-lg-12 col-sm-12">
                  <div class="panel widget">
                     <div class="row row-table">
                        <div class="col-xs-4 text-center bg-green pv-lg">
                        	<img src="<%=request.getScheme()%>://i.inviteyou.cn/blank.jpg" style="display:none;" />
                           <div data-now="" data-format="MMMM" class="text-sm"></div>
                           <br>
                           <div data-now="" data-format="D" class="h2 mt0"></div>
                        </div>
                        <div class="col-xs-8 pv-lg">
                           <div data-now="" data-format="dddd" class="text-uppercase"></div>
                           <br>
                           <div data-now="" data-format="h:mm" class="h2 mt0"></div>
                           <div data-now="" data-format="a" class="text-muted text-sm"></div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-sm-6">
                  <!-- START widget-->
                  <div class="panel widget bg-primary">
                     <div class="row row-table">
                        <div class="col-xs-4 text-center bg-primary-dark pv-lg">
                           <em class="icon-cloud-upload fa-3x"></em>
                        </div>
                        <div class="col-xs-8 pv-lg">
                        	<div class="nowrap">操作系统</div>
                        	<br />
                           	<div class="h2 mt0 nowrap">版本: ${osData.os.version}</div>
                           	<div class="nowrap">架构: ${osData.os.arch}</div>
                           	<div class="nowrap">名称: ${osData.os.vendorName}</div>
                           	<div class="nowrap">厂商: ${osData.os.vendor}</div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-sm-6">
                  <!-- START widget-->
                  <div class="panel widget bg-purple">
                     <div class="row row-table">
                        <div class="col-xs-4 text-center bg-purple-dark pv-lg">
                           <em class="icon-globe fa-3x"></em>
                        </div>
                        <div class="col-xs-8 pv-lg">
                        	<div class="nowrap">CPU</div>
                        	<br />
                           	<div class="h2 mt0 nowrap">使用率: <fmt:formatNumber value="${cpuData.perc.user}" type="percent" /></div>
                           	<div class="nowrap">个数: ${cpuData.count}</div>
                           	<div class="nowrap">厂商: ${cpuData.info.vendor}</div>
                           	<div class="nowrap">型号: ${cpuData.info.model}</div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col-lg-4 col-sm-6">
                  <!-- START widget-->
                  <div class="panel widget bg-green">
                     <div class="row row-table">
                        <div class="col-xs-4 text-center bg-green-dark pv-lg">
                           <em class="icon-globe fa-3x"></em>
                        </div>
                        <div class="col-xs-8 pv-lg">
                        	<div class="nowrap">内存</div>
                        	<br />
                           	<div class="h2 mt0 nowrap">剩余: <fmt:formatNumber value="${memoryData.memory.free/1000000}" type="number" pattern="0" />M</div>
                           	<div class="nowrap">总量: <fmt:formatNumber value="${memoryData.memory.total/1000000}" type="number" pattern="0" />M</div>
                           	<div class="nowrap">使用: <fmt:formatNumber value="${memoryData.memory.used/1000000}" type="number" pattern="0" />M</div>
                           	<div class="nowrap">交换区: <fmt:formatNumber value="${memoryData.swap.used/1000000}" type="number" pattern="0" />M</div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <jsp:include page="include/footer.jsp" />
   </div>
   <jsp:include page="include/script.jsp" />
</body>

</html>