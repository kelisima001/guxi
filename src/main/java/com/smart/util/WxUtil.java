package com.smart.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smart.consts.WxPayConfig;

/**
 * 微信工具类
 * 
 * @author Sunxin
 *
 */
public class WxUtil {
	private static final Logger LOG = LoggerFactory.getLogger(WxUtil.class);
	/**
	 * 构建微信授权登陆url
	 * 
	 * @param callbackUrl
	 *            授权结束再次返回我们系统之后，需要跳转的url; null表示跳转到默认的首页
	 * @return
	 */
	public static final String buildWxAuthUrl(String callbackUrl) {
		String url = WxPayConfig.POST_AUTH_URL;
		String stateParam = null;
		try {
			url = URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (!StringUtil.isEmpty(callbackUrl)) {
			try {
				stateParam = "&state=" + URLEncoder.encode(callbackUrl, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				stateParam = null;
			}

		}
		String finalUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WxPayConfig.APP_ID
				+ "&redirect_uri=" + url + "&response_type=code&scope=" + WxPayConfig.API_SCOPE
				+ (stateParam == null ? "" : stateParam) + "#wechat_redirect";
		LOG.info("wx auth url: " + finalUrl);
		return finalUrl;
	}
	
	public static String createNonceStr(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < length; i++) {
			Random rd = new Random();
			res += chars.indexOf(rd.nextInt(chars.length() - 1));
		}
		return res;
	}

	public static String createNonceStr() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < 16; i++) {
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
	}

	public static String createSign(SortedMap<String,String> parameters) {
		StringBuffer sb = new StringBuffer();
		Set<Entry<String,String>> es = parameters.entrySet();
		Iterator<Entry<String,String>> it = es.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String,String>)it.next();
			String k = (String)entry.getKey();
			Object v = entry.getValue();
			if(null != v && !"".equals(v) 
					&& !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		//此处是商户支付密钥，在商户平台设置，而不是公众平台
		sb.append("key=" + WxPayConfig.MCH_KEY);
		LOG.info("all parameters used to create sign:" + sb.toString());
		String sign = MD5.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		return sign;
	}

	public static void main(String[] args) {
		System.out.println(buildWxAuthUrl("order/test/companyRegistry"));
		;
	}
}
