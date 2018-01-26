package com.smart.service.init;

import org.springframework.stereotype.Service;

import com.smart.core.init.AbstractDataInitializeService;
import com.smart.core.init.InitServiceOrder;
import com.smart.model.Role;
import com.smart.model.User;

@Service
public class UserInitService extends AbstractDataInitializeService{

	@Override
	public int getOrder() {
		return InitServiceOrder.INIT_ORDER_USER;
	}

	@Override
	public void initData() throws Exception {
		User user = userService.findOneBy("username", "admin");
		if(user!=null){
			return;
		}
		
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		user = new User();
		user.setUsername("admin");
		user.setEmail("admin@smart.com");
		user.setName("管理员");
		user.setPassword("111111");
		user.setRole(Role.ROLE_SUPER_ADMIN);
		
		userService.save(user);
		/*
		User user1 = new User();
		user1.setUsername("15555555551");
		user1.setPassword("111111");
		user1.setName("有二级的一级");
		user1.setRole(Role.ROLE_USER); 
		
		userService.save(user1);
		*/
	}

}
