<aside class="aside">
   <div class="aside-inner">
      <nav data-sidebar-anyclick-close="" class="sidebar">
         <ul class="nav" id="mainMenu">
            <li class="has-user-block">
               <div id="user-block" class="collapse">
                  <div class="item user-block">
                     <!-- User picture-->
                     <div class="user-block-picture">
                        <div class="user-block-status">
                           <img src="resources/images/user.jpg" alt="Avatar" width="60" height="60" class="img-thumbnail img-circle">
                           <img src="<%=request.getScheme()%>://i.inviteyou.cn/blank.jpg" style="display:none;" />
                           <div class="circle circle-success circle-lg"></div>
                        </div>
                     </div>
                     <div class="user-block-info">
                        <span class="user-block-name">你好</span>
                        <span class="user-block-role">管理员</span>
                     </div>
                  </div>
               </div>
            </li>
            <li class="nav-heading">
               <span data-localize="sidebar.heading.HEADER">功能菜单</span>
            </li>
            <li id="menuDashboard" class="active">
               <a href="admin/index" title="Dashboard">
                  <em class="icon-speedometer"></em>
                  <span>管理首页</span>
               </a>
            </li>
            <li class="">
               <a href="#menuBaseData" title="Dashboard" data-toggle="collapse">
                  <em class="fa fa-book"></em>
                  <span>基础数据管理</span>
               </a>
               <ul id="menuBaseData" class="nav sidebar-subnav collapse">
                  <li class="sidebar-subnav-header">基础数据管理</li>
                  <li id="menuDictList">
                     <a href="admin/dict/list" title="字典列表">
                        <span>字典列表</span>
                     </a>
                  </li>
                  <li id="menuDictEdit">
                     <a href="admin/dict/edit" title="添加字典">
                        <span>添加字典</span>
                     </a>
                  </li>
                  <li id="menuSelectTypeList">
                     <a href="admin/selectType/list" title="">
                        <span>选项类型列表</span>
                     </a>
                  </li>
                  <!--li id="menuSelectTypeEdit">
                     <a href="admin/selectType/edit" title="">
                        <span>添加选项类型</span>
                     </a>
                  </li-->
                  <li id="menuTagList">
                     <a href="admin/tag/list" title="">
                        <span>标签列表</span>
                     </a>
                  </li>
                  <!--li id="menuTagEdit">
                     <a href="admin/tag/edit" title="">
                        <span>添加新标签</span>
                     </a>
                  </li-->
               </ul>
            </li>
            <!--li id="menuGallery" class="">
               <a href="admin/gallery/list" title="轮播相册">
                  <em class="fa fa-image"></em>
                  <span>轮播相册</span>
               </a>
            </li-->
            <li id="menuDoc" class="">
               <a href="admin/doc/list" title="轮播相册">
                  <em class="fa fa-image"></em>
                  <span>文案管理</span>
               </a>
            </li>
            <li id="menuInfo" class="">
               <a href="admin/info/list" title="资讯管理">
                  <em class="fa fa-image"></em>
                  <span>资讯管理</span>
               </a>
            </li>
            <li id="menuProduct" class="">
               <a href="admin/product/list" title="资讯管理">
                  <em class="fa fa-image"></em>
                  <span>产品管理</span>
               </a>
            </li>
            <li id="menuSoftware" class="">
               <a href="admin/software/list" title="软件下载">
                  <em class="fa fa-image"></em>
                  <span>软件下载管理</span>
               </a>
            </li>
            <li id="menuInfoTag" class="">
               <a href="admin/infoTag/list" title="资讯管理">
                  <em class="fa fa-image"></em>
                  <span>资讯标签列表</span>
               </a>
            </li>
            <!--li id="menuHonor" class="">
               <a href="admin/honor/list" title="荣誉管理">
                  <em class="fa fa-image"></em>
                  <span>荣誉管理</span>
               </a>
            </li>
            <li id="menuHistory" class="">
               <a href="admin/companyHistory/list" title="发展历程">
                  <em class="fa fa-image"></em>
                  <span>发展历程</span>
               </a>
            </li>
            <li class="">
               <a href="#menuProduct" title="Dashboard" data-toggle="collapse">
                  <em class="fa fa-book"></em>
                  <span>产品管理</span>
               </a>
               <ul id="menuProduct" class="nav sidebar-subnav collapse">
                  <li class="sidebar-subnav-header">产品管理</li>
                  <li id="menuProductList">
                     <a href="admin/product/list" title="产品列表">
                        <span>产品列表</span>
                     </a>
                  </li>
                  <li id="menuProductEdit">
                     <a href="admin/product/edit" title="添加产品">
                        <span>添加产品</span>
                     </a>
                  </li>
               </ul>
            </li-->
            
            <li id="menuUserInfo" class="">
               <a href="admin/userInfo/list" title="用户报名信息">
                  <em class="fa fa-image"></em>
                  <span>用户报名信息</span>
               </a>
            </li>
            <li id="menuResource" class="">
               <a href="ckfinder.html" target="blank" title="资源管理">
                  <em class="fa fa-image"></em>
                  <span>图片和文件管理</span>
               </a>
            </li>
            <li class="">
               <a href="#menuAdminTool" title="Dashboard" data-toggle="collapse">
                  <em class="fa fa-book"></em>
                  <span>管理员工具</span>
               </a>
               <ul id="menuAdminTool" class="nav sidebar-subnav collapse">
                  <li class="sidebar-subnav-header">管理员工具</li>
                  <li id="menuChangePassword">
                     <a href="admin/changePassword" title="修改密码">
                        <span>修改密码</span>
                     </a>
                  </li>
                  <li id="menuListAdmin">
                     <a href="admin/listAdmin" title="管理员列表">
                        <span>管理员列表</span>
                     </a>
                  </li>
                  <li id="menuInject">
                     <a href="admin/injectInfo/list" title="收录">
                        <span>收录</span>
                     </a>
                  </li>
               </ul>
            </li>
         </ul>
      </nav>
   </div>
</aside>