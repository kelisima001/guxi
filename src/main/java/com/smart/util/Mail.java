package com.smart.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class Mail { 

	private MimeMessage mimeMsg;
	private Session session;
	private Properties props;
	private String username; 
	private String password; 
	private Multipart mp;
	 
	public Mail(String smtp){ 
		setSmtpHost(smtp); 
		createMimeMessage(); 
	} 

	public void setSmtpHost(String hostName) { 
		System.out.println("设置系统属性：mail.smtp.host = "+hostName); 
		if(props == null){
			props = System.getProperties();
		}
		props.put("mail.smtp.host",hostName);
	} 

	public boolean createMimeMessage() { 
		try { 
			System.out.println("准备获取邮件会话对象！"); 
			session = Session.getDefaultInstance(props,null);
		} 
		catch(Exception e){ 
			System.err.println("获取邮件会话对象时发生错误！"+e); 
			return false; 
		} 
	
		System.out.println("准备创建MIME邮件对象！"); 
		try { 
			mimeMsg = new MimeMessage(session);
			mp = new MimeMultipart(); 
		
			return true; 
		} catch(Exception e){ 
			System.err.println("创建MIME邮件对象失败！"+e); 
			return false; 
		} 
	} 	
	
	public void setNeedAuth(boolean need) { 
		System.out.println("设置smtp身份认证：mail.smtp.auth = "+need); 
		if(props == null) props = System.getProperties(); 
		if(need){ 
			props.put("mail.smtp.auth","true"); 
		}else{ 
			props.put("mail.smtp.auth","false"); 
		} 
	} 

	public void setNamePass(String name,String pass) { 
		username = name; 
		password = pass; 
	} 

	public boolean setSubject(String mailSubject) { 
		System.out.println("设置邮件主题！"); 
		try{ 
			mimeMsg.setSubject(mailSubject); 
			return true; 
		} 
		catch(Exception e) { 
			System.err.println("设置邮件主题发生错误！"); 
			return false; 
		} 
	}
	
	public boolean setBody(String mailBody) { 
		try{ 
			BodyPart bp = new MimeBodyPart(); 
			bp.setContent(""+mailBody,"text/html;charset=GBK"); 
			mp.addBodyPart(bp); 
		
			return true; 
		} catch(Exception e){ 
		System.err.println("设置邮件正文时发生错误！"+e); 
		return false; 
		} 
	} 

	public boolean addFileAffix(String filename) { 
	
		System.out.println("增加邮件附件："+filename); 
		try{ 
			BodyPart bp = new MimeBodyPart(); 
			FileDataSource fileds = new FileDataSource(filename); 
			bp.setDataHandler(new DataHandler(fileds)); 
			bp.setFileName(fileds.getName()); 
			
			mp.addBodyPart(bp); 
			
			return true; 
		} catch(Exception e){ 
			System.err.println("增加邮件附件："+filename+"发生错误！"+e); 
			return false; 
		} 
	} 
	
	public boolean setFrom(String from) { 
		System.out.println("设置发信人！"); 
		try{ 
			mimeMsg.setFrom(new InternetAddress(from)); //设置发信人 
			return true; 
		} catch(Exception e) { 
			return false; 
		} 
	} 

	public boolean setTo(String to){ 
		if(to == null)return false; 
		try{ 
			mimeMsg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to)); 
			return true; 
		} catch(Exception e) { 
			return false; 
		} 	
	} 
	
	public boolean setCopyTo(String copyto) 
	{ 
		if(copyto == null)return false; 
		try{ 
		mimeMsg.setRecipients(Message.RecipientType.CC,(Address[])InternetAddress.parse(copyto)); 
		return true; 
		} 
		catch(Exception e) 
		{ return false; } 
	} 
	
	public boolean sendOut() 
	{ 
		try{ 
			mimeMsg.setContent(mp); 
			mimeMsg.saveChanges(); 
			System.out.println("正在发送邮件...."); 
			
			Session mailSession = Session.getInstance(props,null); 
			Transport transport = mailSession.getTransport("smtp"); 
			transport.connect((String)props.get("mail.smtp.host"),username,password); 
			transport.sendMessage(mimeMsg,mimeMsg.getRecipients(Message.RecipientType.TO)); 
			Address[] cc = mimeMsg.getRecipients(Message.RecipientType.CC);
			if(cc!=null && cc.length!=0){
				transport.sendMessage(mimeMsg, cc); 
			}
			
			System.out.println("发送邮件成功！"); 
			transport.close(); 
			
			return true; 
		} catch(Exception e) { 
			System.err.println("邮件发送失败！"+e); 
			return false; 
		} 
	} 

	public static boolean send(String smtp,String from,String to,String subject,String content,String username,String password) {
		Mail theMail = new Mail(smtp);
		theMail.setNeedAuth(true);
		
		if(!theMail.setSubject(subject)) return false;
		if(!theMail.setBody(content)) return false;
		if(!theMail.setTo(to)) return false;
		if(!theMail.setFrom(from)) return false;
		theMail.setNamePass(username,password);
		theMail.setCopyTo("service@inviteyou.cn");
		if(!theMail.sendOut()) return false;
		return true;
	}
	
	public static boolean sendAndCc(String smtp,String from,String to,String copyto,String subject,String content,String username,String password) {
		Mail theMail = new Mail(smtp);
		theMail.setNeedAuth(true);
		
		if(!theMail.setSubject(subject)) return false;
		if(!theMail.setBody(content)) return false;
		if(!theMail.setTo(to)) return false;
		if(!theMail.setCopyTo(copyto)) return false;
		if(!theMail.setFrom(from)) return false;
		theMail.setNamePass(username,password);
		
		if(!theMail.sendOut()) return false;
		return true;
	}
	
	public static boolean send(String smtp,String from,String to,String subject,String content,String username,String password,String filename) {
		Mail theMail = new Mail(smtp);
		theMail.setNeedAuth(true);
		
		if(!theMail.setSubject(subject)) return false;
		if(!theMail.setBody(content)) return false;
		if(!theMail.addFileAffix(filename)) return false; 
		if(!theMail.setTo(to)) return false;
		if(!theMail.setFrom(from)) return false;
		theMail.setNamePass(username,password);
		
		if(!theMail.sendOut()) return false;
		return true;
	}
	
	public static boolean sendAndCc(String smtp,String from,String to,String copyto,String subject,String content,String username,String password,String filename) {
		Mail theMail = new Mail(smtp);
		theMail.setNeedAuth(true);
		
		if(!theMail.setSubject(subject)) return false;
		if(!theMail.setBody(content)) return false;
		if(!theMail.addFileAffix(filename)) return false; 
		if(!theMail.setTo(to)) return false;
		if(!theMail.setCopyTo(copyto)) return false;
		if(!theMail.setFrom(from)) return false;
		theMail.setNamePass(username,password);
		
		if(!theMail.sendOut()) return false;
		return true;
	}
	
	public static void main(String[] args){
		String smtp = "smtp.163.com";
		String from = "inviteyouSupport@163.com";
		String to = "xs06974@163.com";
		String subject = "孙兴你好11233";
		String content = "邮1件内1容仅供内部使用111";
		String username="inviteyouSupport@163.com";
		String password="Letian20100912";
		Mail.send(smtp, from, to, subject, content, username, password);
	}
} 

