package com.smart.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.smart.consts.SmsChannel;

/**
 * 短信验证码记录
 * 
 * @author Sunxin
 *
 */

@Entity 
@Table(name = "t_verify_code") 
public class VerifyCode extends BaseEntity<VerifyCode>{
	private static final long serialVersionUID = 1L;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 验证码
	 */
	private String code;
	/**
	 * 短信发送渠道
	 */
	@Enumerated(EnumType.STRING)
	private SmsChannel channel = SmsChannel.ucpaas;
	
	/**
	 * 是否发送成功
	 */
	private boolean success;
	
	/**
	 * 短信通道返回的状态码
	 */
	private String deliveryStatusCode;
	
	/**
	 * 是否已使用
	 */
	private boolean used = false;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public SmsChannel getChannel() {
		return channel;
	}
	public void setChannel(SmsChannel channel) {
		this.channel = channel;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getDeliveryStatusCode() {
		return deliveryStatusCode;
	}
	public void setDeliveryStatusCode(String deliveryStatusCode) {
		this.deliveryStatusCode = deliveryStatusCode;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	
	/**
	 * 是否已过期
	 * @param minutes 过期分钟数
	 * @return
	 */
	public boolean isExpired(int minutes){
		if(minutes<=0){
			minutes = 10;
		}
		long maxAge = 1000 * minutes * 60;
		
		Date now = new Date();
		long age = now.getTime() - this.getTimeCreated().getTime();
		if(age>maxAge){
			return true;
		}
		return false;
		
	}
	
}
