package com.smart.exception;

/**
 * 无需被捕获的App异常
 * 
 * @author Sunxin
 *
 */
public class AppRtException extends RuntimeException{

	private static final long serialVersionUID = -7297179477339444276L;
	private String code;
	
	public AppRtException(String code, String msg){
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
