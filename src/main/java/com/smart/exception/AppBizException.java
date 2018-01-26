package com.smart.exception;

/**
 * 需被捕获的业务异常
 * 
 * @author Sunxin
 *
 */
public class AppBizException extends Exception{
	private static final long serialVersionUID = -7297179477339444276L;
	private String code;
	
	//540 - 559 为授权登录认证相关的异常
	public static AppRtException EX_540 = new AppRtException("540", "");
	public static AppRtException EX_541 = new AppRtException("541", "");
	
	//560 - 579 为订单相关的异常
	public static AppRtException EX_560 = new AppRtException("560", "下单响应XML报文解析出错");
	public static AppRtException EX_561 = new AppRtException("561", "下单失败,报文中没有prepayId");
	
	public AppBizException(String code, String msg){
		super(msg);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
