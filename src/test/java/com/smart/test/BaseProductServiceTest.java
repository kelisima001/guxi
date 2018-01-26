//package com.smart.test;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.smart.model.CompanyRegistry;
//import com.smart.model.Role;
//import com.smart.model.User;
//import com.smart.service.CompanyRegistryService;
//import com.smart.service.UserService;
//
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
//public class BaseProductServiceTest {
//
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private CompanyRegistryService companyRegistryService;
//	
//	@Test
//	public void testSayHello(){
//		System.out.println("Hello junit");
//	}
//	
//	@Test
//	public void testCompanyRegistry(){
//		User user = new User();
//		user.setName("sunxin");
//		user.setRole(Role.ROLE_USER);
//		userService.save(user);
//		List list = userService.findBy("name", "sunxin");
//		System.out.println(list.size());
//		
//		CompanyRegistry company = new CompanyRegistry();
//		company.setType("1");
//		company.setSubject("shanghai company registry");
//		company.setPrice(123.5);
//		company.setUser(user);
//		
//		companyRegistryService.save(company);
//		List list1 = companyRegistryService.findBy("type", "1");
//		System.out.println(list1.size());
//		
//		
//	}
//}
