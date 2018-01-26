package com.smart.consts;

import com.smart.core.SpringContext;
import com.smart.core.init.DataInitializeService;
import com.smart.util.StaticUtil;

/**
 * 微信支付配置
 * 
 * @author Sunxin
 *
 */
public class WxPayConfig {
	// 微信号
	public static String WX_ID = "mingxiguwen";// IDgh_03c5c11cbdaf
	// app id
	public static String APP_ID = "wx1b3006bda0c00664";
	// app secret
	public static String APP_SECRET = "be727c5f4322ea37c1434d289993363a";
	// 商户号
	public static String MCH_ID = "1361966702";
	// 商户密钥
	public static String MCH_KEY = "11111222223333344444555556666678";
	// 商户名称
	public static String MCH_NAME = "上海铭喜商务咨询有限公司";

	public static String API_SCOPE = "snsapi_base";//snsapi_userinfo
	// 微信交易类型 
	public static String TRADE_TYPE = "JSAPI";
	
	//微信支付统一接口(POST)
	public static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	//微信退款接口(POST)
	public static String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	//订单查询接口(POST)
	public static String CHECK_ORDER_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	//关闭订单接口(POST)
	public static String CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com/pay/closeorder";
	//退款查询接口(POST)
	public static String CHECK_REFUND_URL = "https://api.mch.weixin.qq.com/pay/refundquery";
	//对账单接口(POST)
	public static String DOWNLOAD_BILL_URL = "https://api.mch.weixin.qq.com/pay/downloadbill";
	//短链接转换接口(POST)
	public static String SHORT_URL = "https://api.mch.weixin.qq.com/tools/shorturl";
	//接口调用上报接口(POST)
	public static String REPORT_URL = "https://api.mch.weixin.qq.com/payitil/report";
	//支付成功后的通知url
	public static String NOTIFY_URL = "http://xcy.mxgroups.com/wx/postPay";
	//微信授权登陆认证结束后回掉我们系统的url
	public static String POST_AUTH_URL = "http://xcy.mxgroups.com/wx/postAuth";
	
	/**
	 * 重新从字典加载WxPayConfig
	 * @throws Exception
	 */
	public static void reload() throws Exception{
		//
		DataInitializeService service = SpringContext.getBean("wxPayConfigInitService");
		service.initData();
	}
	/**
	 * 获得WxPayConfig调试字符串
	 * @return
	 */
	public static String getWxConfigString() {
		return StaticUtil.toStaticFieldString(WxPayConfig.class);
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{
		System.out.println(getWxConfigString());
	}
	
}
