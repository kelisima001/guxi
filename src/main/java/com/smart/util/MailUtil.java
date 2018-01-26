package com.smart.util;

public class MailUtil {

	public static boolean send(String to, String subject, String content){
//		String smtp = "smtp.163.com";
//		String from = "inviteyouSupport@163.com";
//		String username="inviteyouSupport@163.com";
//		String password="Letian20100912";
		String smtp = "smtp.mxhichina.com";
		String from = "service@inviteyou.cn";
		String username = "service@inviteyou.cn";
		String password = "Letian20100912";
		return Mail.send(smtp, from, to, subject, content, username, password);
	}
	
	public static void main(String[] args){
		send("xs06974@163.com", "欢迎您的惠顾", "请点击链接激活您的账号: <a href='http://www.baidu.com'>http://www.baidu.com?adfasdf</a>");
	}
}
