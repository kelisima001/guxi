package com.smart.web.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.consts.DictModules;
import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Role;
import com.smart.model.User;
import com.smart.model.VerifyCode;

/**
 * 用户相关页面控制器
 * 
 * @author Sunxin
 *
 */
@Controller
public class UserController extends BaseController{
	private static int MAX_COOKIE_AGE = 5 * 24 * 60 * 60;

	/**
	 * 注册页面
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String preRegister(Long brokerId, Model model) {
		if(brokerId!=null && brokerId!=0){
			User parent = userService.findOne(brokerId);
			model.addAttribute("parent", parent);
		}
		return "register";
	}
	
	/**
	 * 提交注册
	 */
	@RequestMapping(value = "register", method=RequestMethod.POST)
	public String register(User form, Long pid, String verifyCode, Model model, HttpSession session) {
		String needToCheck = dictService.getDictValue(DictModules.MOD_SYS, "registry.checkVerifyCode");
		if("1".equals(needToCheck)){
			VerifyCode code = verifyCodeService.findLatestOneByMobile(form.getUsername());
			if(code==null){
				super.setErrorMsg(model, "验证码不正确或者已过期");
				model.addAttribute("unsavedUser", form);
				return "register";
			}
			Integer expireMinutes = dictService.getDictIntValue(DictModules.MOD_SYS, "verifyCode.expiration.minutes");
			if(expireMinutes==null){
				expireMinutes = 10;
			}
			boolean expired = code.isExpired(expireMinutes);
			if(expired){
				super.setErrorMsg(model, "验证码不正确或者已过期!");
				model.addAttribute("unsavedUser", form);
				return "register";
			}
			if(!verifyCode.equals(code.getCode())){
				super.setErrorMsg(model, "验证码不正确");
				return "register";
			}
			code.setUsed(true);
			verifyCodeService.save(code);
		}
		
		User theUser = userService.findOneBy("username", form.getUsername());
		if(theUser!=null){
			super.setErrorMsg(model, "该手机号已存在");
			return "register";
		}
		userService.save(form);
		//重定向到注册成功页面, 防止重复注册
		return "redirect:registerSuccess";
	}
	
	/**
	 * 注册成功页面
	 */
	@RequestMapping(value = "registerSuccess", method = RequestMethod.GET)
	public String registerSuccess() {
		return "registerSuccess";
	}
	
	/**
	 * 找回密码页面
	 */
	@RequestMapping(value = "forgetPassword", method = RequestMethod.GET)
	public String preForgetPassword() {
		return "forgetPassword";
	}
	
	/**
	 * 提交重置密码
	 */
	@RequestMapping(value = "forgetPassword", method = RequestMethod.POST)
	public String forgetPassword(User form, String verifyCode, Model model, HttpSession session) {
		String needToCheck = dictService.getDictValue(DictModules.MOD_SYS, "registry.checkVerifyCode");
		if("1".equals(needToCheck)){
			VerifyCode code = verifyCodeService.findLatestOneByMobile(form.getUsername());
			if(code==null){
				super.setErrorMsg(model, "验证码不正确或者已过期");
				model.addAttribute("unsavedUser", form);
				return "forgetPassword";
			}
			Integer expireMinutes = dictService.getDictIntValue(DictModules.MOD_SYS, "verifyCode.expiration.minutes");
			if(expireMinutes==null){
				expireMinutes = 10;
			}
			boolean expired = code.isExpired(expireMinutes);
			if(expired){
				super.setErrorMsg(model, "验证码不正确或者已过期!");
				model.addAttribute("unsavedUser", form);
				return "forgetPassword";
			}
			if(!verifyCode.equals(code.getCode())){
				super.setErrorMsg(model, "验证码不正确");
				return "forgetPassword";
			}
			code.setUsed(true);
			verifyCodeService.save(code);
		}
		User user = userService.findOneBy("username", form.getUsername());
		if(user==null){
			userService.save(form);
		}
		else{
			user.setPassword(form.getPassword());
			userService.save(user);
		}
		//重定向到注册成功页面, 防止重复注册
		return "redirect:resetPasswordSuccess";
	}
	
	/**
	 * 注册成功页面
	 */
	@RequestMapping(value = "resetPasswordSuccess", method = RequestMethod.GET)
	public String resetPasswordSuccess() {
		return "resetPasswordSuccess";
	}
	
	/**
	 * 登录页面
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String preLogin() {
		return "login";
	}
	
	/**
	 * 提交登录
	 */
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String login(Model model, User form, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//form.setPassword(encoder.encode(form.getPassword()));
		User user = userService.findOneBy("username", form.getUsername());
		if(user==null || !user.getPassword().equals(form.getPassword())){
			super.setErrorMsg(model, "用户名不存在, 或密码错误");
			return "login";
		}
		// 更新上次登录
		user.setLastLogin(new Date());
		userService.save(user);
		session.setAttribute("user", user);
		Cookie cookie = new Cookie("loginUserName", user.getUsername());
		cookie.setMaxAge(MAX_COOKIE_AGE);
		response.addCookie(cookie);
		return "redirect:/user/myIndex";
	}
	
	/**
	 * 登录页面
	 */
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String userHome() {
		return "redirect:/user/myIndex";
	}
	
	/**
	 * 退出
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "index";
	}

	/**
	 * 用户修改密码页面
	 */
	@RequestMapping(value = "user/editUserPassword", method=RequestMethod.GET)
	public String preEditUserPassword(String password, HttpSession session){
		return "editUserPassword";
	}
	
	/**
	 * 提交修改密码
	 */
	@RequestMapping(value = "user/editUserPassword", method=RequestMethod.POST)
	public String editUserPassword(Long id, String password, Model model, HttpSession session){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//User user = (User) session.getAttribute("user");
		User form = userService.findOne(user.getId());
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		form.setPassword(password);
		userService.save(form);
		super.setSuccessMsg(model);
		return "editUserPassword";
	}

	/**
	 * 管理员修改用户角色页面
	 */
	@RequestMapping(value = "admin/changeUserRole", method=RequestMethod.GET)
	public String preChangeUserRole(Long id, Model model){
		User oneUser = userService.findOne(id);
		model.addAttribute("oneUser", oneUser);
		return "changeUserRole";
	}

	/**
	 * 管理员提交修改用户角色
	 */
	@RequestMapping(value = "changeUserRole", method=RequestMethod.POST)
	public String changeUserRole(Long id, Role role, Model model){
		User oneUser = userService.findOne(id);
		oneUser.setRole(role);
		userService.save(oneUser);
		model.addAttribute("oneUser", oneUser);
		super.setSuccessMsg(model);
		return "changeUserRole";
	}
	
	/**
	 * 管理员查看所有用户
	 */
	@RequestMapping(value = "admin/listAdmin")
	public String listUser(PageRequest pageRequest, Model model) {
		Page<User> page = userService.findAll(pageRequest);
		model.addAttribute("page", page);
		return "admin/user/list";
	} 
	
	/**
	 * 管理员编辑用户资料页面
	 */
	@RequestMapping(value = "admin/editAdmin", method=RequestMethod.GET)
	public String editUser(Long id, Model model) {
		if(id!=null){
			User user = userService.findOne(id);
			model.addAttribute("user", user);
		}
		else {
			model.addAttribute("user", new User());
		}
		return "admin/user/edit";
	}
	
	/**
	 * 管理员提交编辑用户资料
	 */
	@RequestMapping(value = "admin/editAdmin", method=RequestMethod.POST)
	public String editUser(User form, Model model, RedirectAttributes ra) {
		if(form.getId()!=null){
			User user = userService.findOne(form.getId());
			
			user.setUsername(form.getUsername());
			user.setName(form.getName());
			user.setAvatar(form.getAvatar());
			userService.save(user);
			
			model.addAttribute("user", user); 
			super.setSuccessMsg(ra);
		}
		else {
			form.setPassword("111111");
			form.setRole(Role.ROLE_ADMIN);
			super.setSuccessMsg(ra, "新管理员创建成功, 初始密码111111");
			userService.save(form);
		}
		return "redirect:editAdmin?id=" + form.getId();
	}
	
}
