<aside class="offsidebar hide">
   <nav>
      <div role="tabpanel">
         <!-- Nav tabs-->
         <ul role="tablist" class="nav nav-tabs nav-justified">
            <li role="presentation" class="active">
               <a href="#app-settings" aria-controls="app-settings" role="tab" data-toggle="tab">
                  <em class="icon-equalizer fa-lg"></em>
               </a>
            </li>
            <li role="presentation">
               <a href="#app-chat" aria-controls="app-chat" role="tab" data-toggle="tab">
                  <em class="icon-user fa-lg"></em>
               </a>
            </li>
         </ul>
         
         <div class="tab-content">
            <div id="app-settings" role="tabpanel" class="tab-pane fade in active">
               <h3 class="text-center text-thin">设置</h3>
               <div class="p">
                  <h4 class="text-muted text-thin">主题</h4>
                  <div class="table-grid mb">
                     <div class="col mb">
                        <div class="setting-color">
                           <label data-load-css="resources/css/theme/theme-a.css">
                              <input type="radio" name="setting-theme">
                              <span class="icon-check"></span>
                              <span class="split">
                                 <span class="color bg-info"></span>
                                 <span class="color bg-info-light"></span>
                              </span>
                              <span class="color bg-white"></span>
                           </label>
                        </div>
                     </div>
                     <div class="col mb">
                        <div class="setting-color">
                           <label data-load-css="resources/css/theme/theme-b.css">
                              <input type="radio" name="setting-theme">
                              <span class="icon-check"></span>
                              <span class="split">
                                 <span class="color bg-green"></span>
                                 <span class="color bg-green-light"></span>
                              </span>
                              <span class="color bg-white"></span>
                           </label>
                        </div>
                     </div>
                     <div class="col mb">
                        <div class="setting-color">
                           <label data-load-css="resources/css/theme/theme-c.css">
                              <input type="radio" name="setting-theme">
                              <span class="icon-check"></span>
                              <span class="split">
                                 <span class="color bg-purple"></span>
                                 <span class="color bg-purple-light"></span>
                              </span>
                              <span class="color bg-white"></span>
                           </label>
                        </div>
                     </div>
                     <div class="col mb">
                        <div class="setting-color">
                           <label data-load-css="resources/css/theme/theme-d.css">
                              <input type="radio" name="setting-theme">
                              <span class="icon-check"></span>
                              <span class="split">
                                 <span class="color bg-danger"></span>
                                 <span class="color bg-danger-light"></span>
                              </span>
                              <span class="color bg-white"></span>
                           </label>
                        </div>
                     </div>
                  </div>
                  <div class="table-grid mb">
                     <div class="col mb">
                        <div class="setting-color">
                           <label data-load-css="resources/css/theme/theme-e.css">
                              <input type="radio" name="setting-theme">
                              <span class="icon-check"></span>
                              <span class="split">
                                 <span class="color bg-info-dark"></span>
                                 <span class="color bg-info"></span>
                              </span>
                              <span class="color bg-gray-dark"></span>
                           </label>
                        </div>
                     </div>
                     <div class="col mb">
                        <div class="setting-color">
                           <label data-load-css="resources/css/theme/theme-f.css">
                              <input type="radio" name="setting-theme">
                              <span class="icon-check"></span>
                              <span class="split">
                                 <span class="color bg-green-dark"></span>
                                 <span class="color bg-green"></span>
                              </span>
                              <span class="color bg-gray-dark"></span>
                           </label>
                        </div>
                     </div>
                     <div class="col mb">
                        <div class="setting-color">
                           <label data-load-css="resources/css/theme/theme-g.css">
                              <input type="radio" name="setting-theme">
                              <span class="icon-check"></span>
                              <span class="split">
                                 <span class="color bg-purple-dark"></span>
                                 <span class="color bg-purple"></span>
                              </span>
                              <span class="color bg-gray-dark"></span>
                           </label>
                        </div>
                     </div>
                     <div class="col mb">
                        <div class="setting-color">
                           <label data-load-css="resources/css/theme/theme-h.css">
                              <input type="radio" name="setting-theme">
                              <span class="icon-check"></span>
                              <span class="split">
                                 <span class="color bg-danger-dark"></span>
                                 <span class="color bg-danger"></span>
                              </span>
                              <span class="color bg-gray-dark"></span>
                           </label>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="p">
                  <h4 class="text-muted text-thin">布局</h4>
                  <div class="clearfix">
                     <p class="pull-left">固定头部和导航栏</p>
                     <div class="pull-right">
                        <label class="switch">
                           <input id="chk-fixed" type="checkbox" data-toggle-state="layout-fixed">
                           <span></span>
                        </label>
                     </div>
                  </div>
                  <div class="clearfix">
                     <p class="pull-left">固定宽度</p>
                     <div class="pull-right">
                        <label class="switch">
                           <input id="chk-boxed" type="checkbox" data-toggle-state="layout-boxed">
                           <span></span>
                        </label>
                     </div>
                  </div>
               </div>
               <div class="p">
                  <h4 class="text-muted text-thin">侧边导航栏</h4>
                  <div class="clearfix">
                     <p class="pull-left">收起</p>
                     <div class="pull-right">
                        <label class="switch">
                           <input id="chk-collapsed" type="checkbox" data-toggle-state="aside-collapsed">
                           <span></span>
                        </label>
                     </div>
                  </div>
                  <div class="clearfix">
                     <p class="pull-left">收起时显示文字</p>
                     <div class="pull-right">
                        <label class="switch">
                           <input id="chk-collapsed-text" type="checkbox" data-toggle-state="aside-collapsed-text">
                           <span></span>
                        </label>
                     </div>
                  </div>
                  <div class="clearfix">
                     <p class="pull-left">漂浮</p>
                     <div class="pull-right">
                        <label class="switch">
                           <input id="chk-float" type="checkbox" data-toggle-state="aside-float">
                           <span></span>
                        </label>
                     </div>
                  </div>
               </div>
            </div>
            <div id="app-chat" role="tabpanel" class="tab-pane fade">
               <h3 class="text-center text-thin">其他</h3>
            </div>
         </div>
      </div>
   </nav>
   <!-- END Off Sidebar (right)-->
</aside>