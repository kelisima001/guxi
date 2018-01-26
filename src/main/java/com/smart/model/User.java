package com.smart.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.consts.UserChannel;
import com.smart.consts.UserStatus;

@Entity 
@Table(name = "t_user") 
public class User extends BaseEntity<User> implements UserDetails{
	private static final long serialVersionUID = 619932477758578266L;
	public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 登陆用户名, 统一放用户手机号
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 重复密码
	 */
	@Transient
	private String password1;
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 头像图片路径
	 */
	private String avatar;
	/**
	 * Email
	 */
	private String email;
	/**
	 * 绑定的微信openid
	 */
	private String wxOpenId;
	/**
	 * 用户来源渠道
	 */
	@Enumerated(EnumType.STRING)
	private UserChannel channel;
	
	/**
	 * 用户角色
	 */
	@Enumerated(EnumType.STRING)
	private Role role;
	
	/**
	 * 性别
	 */
	private String gender;
	
	
	/**
	 * 电话
	 */
	private String telephone;
	
	
	/**
	 * 手机
	 */
	private String mobilePhone; 
	
	/**
	 * 生日
	 */
	@DateTimeFormat(iso=ISO.DATE)
	private Date birthday;
	

	/**
	 * 注册时间
	 */
	@DateTimeFormat(iso=ISO.DATE)
	private Date regTime;
	
	/**
	 * 最后登陆时间
	 */
	@DateTimeFormat(iso=ISO.DATE)
	private Date lastLogin;
	
	/**
	 * 用户状态
	 */
	@Enumerated(EnumType.STRING)
	private UserStatus status = UserStatus.actv;
	
	@Transient
	private boolean admin;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public UserChannel getChannel() {
		return channel;
	}

	public void setChannel(UserChannel channel) {
		this.channel = channel;
	}

	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public String getWxOpenId() {
		return wxOpenId;
	}
	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role.getName());
		list.add(auth);
		if(Role.ROLE_SUPER_ADMIN.equals(role)){
			list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		list.add(new SimpleGrantedAuthority("ROLE_USER"));
		return list;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getGender() {
		return gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isAdmin() {
		return Role.ROLE_ADMIN.equals(this.getRole()) || Role.ROLE_SUPER_ADMIN.equals(role);
	}
	
	public boolean isSuperAdmin(){
		return Role.ROLE_SUPER_ADMIN.equals(role);
	}
	
	public String toString(){
		return "["
				+ "id: " + id
				+ "name: " + name
				+ "username: " + username
				+ "wxOpenId: " + wxOpenId
				+ "role: " + role.getDescription()
				+ "]";
	}
	
}