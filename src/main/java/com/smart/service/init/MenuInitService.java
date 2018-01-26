package com.smart.service.init;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;
import com.smart.model.Menu;

/**
 * 初始化根菜单
 * 
 * @author Xin.Sun
 *
 */
@Service
public class MenuInitService extends AbstractDataInitializeService{
	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_MENU;
	}

	@Override
	public void initData() throws Exception {
		logger.info("init menu data at {}", new Date());
		Menu obj = menuService.findOneBy("code", Menu.ROOT_MENU_CODE);
		if(obj==null){
			Menu menu = new Menu();
			menu.setCode(Menu.ROOT_MENU_CODE);
			menu.setName("主菜单");
			menuService.save(menu);
			
			Menu menu1 = new Menu();
			menu1.setCode("index");
			menu1.setName("公司首页");
			menu1.setParent(menu);
			menu1.setUrl("index");
			menuService.save(menu1);
			
			Menu menu2 = new Menu();
			menu2.setCode("about");
			menu2.setName("关于比克利");
			menu2.setParent(menu);
			menu2.setUrl("about/intro");
			menuService.save(menu2);
			
			Menu menu22 = new Menu();
			menu22.setParent(menu2);
			menu22.setName("集团简介");
			menu22.setCode("about-intro");
			menu22.setUrl("about/intro");
			menuService.save(menu22);
			
			menu22 = new Menu();
			menu22.setParent(menu2);
			menu22.setName("发展历程");
			menu22.setCode("about-devpath");
			menu22.setUrl("about/devpath");
			menuService.save(menu22);
			
			menu22 = new Menu();
			menu22.setParent(menu2);
			menu22.setName("资质荣誉");
			menu22.setCode("about-honor");
			menu22.setUrl("about/honor");
			menuService.save(menu22);
			
			menu22 = new Menu();
			menu22.setParent(menu2);
			menu22.setName("精英团队");
			menu22.setCode("about-team");
			menu22.setUrl("about/team");
			menuService.save(menu22);
			
			menu22 = new Menu();
			menu22.setParent(menu2);
			menu22.setName("总部形象");
			menu22.setCode("about-hq");
			menu22.setUrl("about/hq");
			menuService.save(menu22);
			
			menu22 = new Menu();
			menu22.setParent(menu2);
			menu22.setName("旗下品牌");
			menu22.setCode("about-other");
			menu22.setUrl("about/other");
			menuService.save(menu22);
			/*********** end about **************/
			
			Menu menu3 = new Menu();
			menu3.setCode("brand");
			menu3.setName("品牌优势");
			menu3.setParent(menu);
			menu3.setUrl("brand/brand");
			menuService.save(menu3);
			
			Menu menu4 = new Menu();
			menu4.setCode("product");
			menu4.setName("产品展示");
			menu4.setParent(menu);
			menu4.setUrl("product/hamburger");
			menuService.save(menu4);
			
			Menu menu5 = new Menu();
			menu5.setCode("join");
			menu5.setName("加盟服务");
			menu5.setParent(menu);
			menu5.setUrl("join/advantage");
			menuService.save(menu5);
			
			Menu menu6 = new Menu();
			menu6.setCode("info");
			menu6.setName("新闻中心");
			menu6.setParent(menu);
			menu6.setUrl("info/company");
			menuService.save(menu6);
			
			Menu menu7 = new Menu();
			menu7.setCode("contact");
			menu7.setName("联系我们");
			menu7.setParent(menu);
			menu7.setUrl("contact");
			menuService.save(menu7);
		}
	}

}
