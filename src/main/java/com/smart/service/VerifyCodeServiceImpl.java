package com.smart.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.smart.dao.BaseDao;
import com.smart.dao.VerifyCodeDao;
import com.smart.model.VerifyCode;
import com.smart.model.VerifyCodeCond;
import com.smart.util.MD5;
import com.smart.util.SimpleHttpClient;

/**
 * 验证码发送服务类
 * 
 * @author Sunxin
 *
 */
 
@Service
public class VerifyCodeServiceImpl extends BaseEntityService<VerifyCode, VerifyCodeCond, Long> implements VerifyCodeService{

	@Autowired
	private VerifyCodeDao dao;
	
	private static SimpleHttpClient client = new SimpleHttpClient();
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@Override
	protected BaseDao<VerifyCode, VerifyCodeCond, Long> getDao() {
		return dao;
	}
	
	public VerifyCode findLatestOneByMobile(String mobile){
		return dao.findLatestOneByMobile(mobile);
	}
	
	@Override
	public boolean sendVerifyCode(String mobile, String code) {
		
		String version = "2014-06-30";
		String accountSid = "0ad8582fac2ff00c003e4cf48750e3d1";
		String authToken = "ac8127cabfd77cabdf3bce7236347f22";
		String appId = "0136bbb3475b4480af49583f5feb511a";
		String tplId = "142282";
		String time = formatter.format(new Date());
		String sig = accountSid + authToken + time;
		sig = MD5.md5Hex32(sig, "utf-8");
		String authorization = accountSid + ":" + time;
		try{
			authorization = Base64Utils.encodeToString(authorization.getBytes("utf-8"));
		}
		catch(Exception e){
			// ignore
		}
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<templateSMS>"
				+ "<appId>" + appId + "</appId>"
				+ "<templateId>" + tplId + "</templateId>"
				+ "<to>" + mobile + "</to>"
				+ "<param>" + code + "</param>"
				+ "</templateSMS>";
		String url = "https://api.ucpaas.com/"+version+"/Accounts/"+accountSid+"/Messages/templateSMS.xml?sig=" + sig;
		logger.info("try to send verify code via {}, mobile={}, code={}", url, mobile, code);
		
		SimpleHttpClient.HttpReq req = new SimpleHttpClient.HttpReq();
		req.setUrl(url);
		req.setContent(xml);
		req.addHeader("Accept", "application/xml");
		req.addHeader("Content-Type", "application/xml;charset=utf-8");
		req.addHeader("Authorization", authorization);
		SimpleHttpClient.HttpResp res = client.doPost(req);
		logger.info("response code: {}", res.getStatusCode());
		logger.info("response content: {}", res.getContent());
		
		if(res.getStatusCode()==200){
			String deliveryStatusCode = res.getContent().split("respCode>")[1].split("<")[0];
			if("000000".equals(deliveryStatusCode)){
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args){
		String version = "2014-06-30";
		String accountSid = "0ad8582fac2ff00c003e4cf48750e3d1";
		String authToken = "ac8127cabfd77cabdf3bce7236347f22";
		String appId = "0136bbb3475b4480af49583f5feb511a";
		String tplId = "142282";
		String time = formatter.format(new Date());
		String mobile = "15800468566";
		String code = "1111";
		String sig = accountSid + authToken + time;
		sig = MD5.md5Hex32(sig, "utf-8");
		String authorization = accountSid + ":" + time;
		try{
			authorization = Base64Utils.encodeToString(authorization.getBytes("utf-8"));
		}
		catch(Exception e){
			// ignore
			e.printStackTrace();
		}
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<templateSMS>"
				+ "<appId>" + appId + "</appId>"
				+ "<templateId>" + tplId + "</templateId>"
				+ "<to>" + mobile + "</to>"
				+ "<param>" + code + "</param>"
				+ "</templateSMS>";
		String url = "https://api.ucpaas.com/"+version+"/Accounts/"+accountSid+"/Messages/templateSMS.xml?sig=" + sig;
		
		SimpleHttpClient.HttpReq req = new SimpleHttpClient.HttpReq();
		req.setUrl(url);
		req.setContent(xml);
		req.addHeader("Accept", "application/xml");
		req.addHeader("Content-Type", "application/xml;charset=utf-8");
		req.addHeader("Authorization", authorization);
		SimpleHttpClient.HttpResp res = client.doPost(req);
		System.out.println(res.getContent());
	}

	@Override
	public boolean verity(String mobile, String code) {
		VerifyCode verifyCode = this.findLatestOneByMobile(mobile);
		if(code==null){
			return false;
		}
		Integer expireMinutes = 15;
		
		boolean expired = verifyCode.isExpired(expireMinutes);
		if(expired){
			return false;
		}
		if(!code.equals(verifyCode.getCode())){
			return false;
		}
		
		verifyCode.setUsed(true);
		dao.save(verifyCode);
		return true;
	}
	
}
