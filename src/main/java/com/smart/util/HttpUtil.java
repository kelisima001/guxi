package com.smart.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParser;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.LineParser;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	private static final boolean NEED_PROXY = false;
	private static final HttpHost PROXY = new HttpHost("webproxy.wlb.nsroot.net", 8080);
	// Use custom cookie store if necessary.
	private static CookieStore DEFAULT_COOKIE_STORE = new BasicCookieStore();
    // Use custom credentials provider if necessary.
	private static CredentialsProvider DEFAULT_CREDENTIAL_PROVIDER = new BasicCredentialsProvider();
	// Default HttpClientContext.
	private static HttpClientContext DEFAULT_CONTEXT = HttpClientContext.create();
	
	public static String COOKIE = "MatrixMachineID=-3936030812; AWSELB=5DF591DAC8D77ABA6EDA6D92B6D8C839FA295E2E2ED0E46ACBF1DFE8387D79E1FDB35B341F92F20E0EF494941F6B3B1A41E5B3630AB33606728FD43BD1B455CD20405B42; ASP.NET_SessionId=y521qo0wrzfjxu1mtisxomsb; LoginSig=88617 - y521qo0wrzfjxu1mtisxomsb - CL-CIGM-WEB08 - 05:35:09.970; MLSAuth=AB5D60809C6CB93413CC897FE08E72719BA45C395D893B85B94D03A95BC5034D5A6775DA7A4652B943D57FEB156050835C0FFF7CF081336FB3E9DF49A0FD1DBAEF4B7E389877D1AA7AD3B21ED8864814EB59DF232EFC34F1717E6F65; MatrixLoginName=; __utmt=1; __utma=6790574.727462245.1445604530.1445782088.1446460518.6; __utmb=6790574.7.10.1446460518; __utmc=6790574; __utmz=6790574.1445604530.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)";
	public static Date LAST_COOKIE_TIME = null;
	
	static 
	{
		DEFAULT_CONTEXT.setCookieStore(DEFAULT_COOKIE_STORE);
		DEFAULT_CONTEXT.setCredentialsProvider(DEFAULT_CREDENTIAL_PROVIDER);
		reconstructCookies();
	}
	
	/**
	 * Reconstruct all the cookies from the static variable COOKIE, and set cookies into DEFAULT_COOKIE_STORE;
	 * All the domain of such cookies should be "mlslink.mlxchange.com";
	 * Then all subsequent request to "mlslink.mlxchange.com" will carry such cookies;
	 */
	private static void reconstructCookies(){
		DEFAULT_COOKIE_STORE.clear();
		String[] keyValuePairs = COOKIE.split("; ");
		for(String kv : keyValuePairs){
			String[] pair = kv.split("=");
			String key = pair[0];
			String val = null;
			if(pair.length<2){
				val = "";
			}
			else{
				val = pair[1];
			}
			BasicClientCookie cookie = new BasicClientCookie(key, val);
			cookie.setDomain("mlslink.mlxchange.com");
			DEFAULT_COOKIE_STORE.addCookie(cookie);
		}
		
	}
    // Create global request configuration
	private static RequestConfig DEFAULT_REQUEST_CONFIG = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY)
            .setExpectContinueEnabled(true)
            .setStaleConnectionCheckEnabled(true)
            .build();
	
	private static PoolingHttpClientConnectionManager createConnectionManager(){
        HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory() {
            @Override
            public HttpMessageParser<HttpResponse> create(
                SessionInputBuffer buffer, MessageConstraints constraints) {
                LineParser lineParser = new BasicLineParser() {
                    @Override
                    public Header parseHeader(final CharArrayBuffer buffer) {
                        try {
                            return super.parseHeader(buffer);
                        } catch (ParseException ex) {
                            return new BasicHeader(buffer.toString(), null);
                        }
                    }
                };
                return new DefaultHttpResponseParser(
                    buffer, lineParser, DefaultHttpResponseFactory.INSTANCE, constraints) {
                    @Override
                    protected boolean reject(final CharArrayBuffer line, int count) {
                        return false;
                    }
                };
            }

        };
        HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();

        HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
                requestWriterFactory, responseParserFactory);

        SSLContext sslcontext = SSLContexts.createSystemDefault();
        X509HostnameVerifier hostnameVerifier = new BrowserCompatHostnameVerifier();

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
            .register("http", PlainConnectionSocketFactory.INSTANCE)
            .register("https", new SSLConnectionSocketFactory(sslcontext, hostnameVerifier))
            .build();

        DnsResolver dnsResolver = new SystemDefaultDnsResolver() {
            @Override
            public InetAddress[] resolve(final String host) throws UnknownHostException {
                if (host.equalsIgnoreCase("localhost")) {
                    return new InetAddress[] { InetAddress.getByAddress(new byte[] {127, 0, 0, 1}) };
                } else {
                    return super.resolve(host);
                }
            }
        };
        
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(
                socketFactoryRegistry, connFactory, dnsResolver);

        SocketConfig socketConfig = SocketConfig.custom()
            .setTcpNoDelay(true)
            .build();
        connManager.setDefaultSocketConfig(socketConfig);

        MessageConstraints messageConstraints = MessageConstraints.custom()
            .setMaxHeaderCount(200)
            .setMaxLineLength(2000)
            .build();

        ConnectionConfig connectionConfig = ConnectionConfig.custom()
            .setMalformedInputAction(CodingErrorAction.IGNORE)
            .setUnmappableInputAction(CodingErrorAction.IGNORE)
            .setCharset(Consts.UTF_8)
            .setMessageConstraints(messageConstraints)
            .build();

        connManager.setDefaultConnectionConfig(connectionConfig);
        connManager.setMaxTotal(100);
        connManager.setDefaultMaxPerRoute(10);
        return connManager;
	}
	
	public static CloseableHttpClient createHttpClient(){
        // Create an HttpClient with the given custom dependencies and configuration.
        HttpClientBuilder builder = HttpClients.custom()
        		.setConnectionManager(createConnectionManager())
        		.setDefaultCookieStore(DEFAULT_COOKIE_STORE)
        		.setDefaultCredentialsProvider(DEFAULT_CREDENTIAL_PROVIDER)
        		.setDefaultRequestConfig(DEFAULT_REQUEST_CONFIG);
        		
            if(NEED_PROXY){
            	builder.setProxy(PROXY);
            }
        return builder.build();
	}
	
	public static void main(String args[]) throws Exception{
		//test2(0);
		String s = test();
		//extractAllLinks("");
	}
	
	public static void test2(int number) throws Exception{
		CloseableHttpClient httpClient = createHttpClient();
		HttpPost method = new HttpPost(
				"http://matrix.centris.ca/Matrix/Results.aspx?c=AAEAAAD*****AQAAAAAAAAARAQAAAFAAAAAGAgAAAAQ4MTU2BgMAAAABMgYEAAAAATEKBgUAAAAFMTU4NDQGBgAAAAUxNTg3Mg0CBgcAAAACNDMNDQYIAAAAAjUwBgkAAAABMAoGCgAAAAExDQIGCwAAAAbDicKjS3wNLAYMAAAAATENBgs)");

		setCommonHeaders(method, true);
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Map<String, String> params = new HashMap<>();
		params.put("ScriptManager", "ScriptManager|m_DisplayCore");
		params.put("ctl03$m_ucSpeedBar$m_tbSpeedBar", "");
		params.put("ctl03$m_ucSpeedBar$m_cbXtraCriteria", "on");
		params.put("m_ucResultsPageTabs$m_hfState", "Results");
		params.put("m_ucDisplayPicker$m_ddlDisplayFormats", "15844");
		params.put("m_ucDisplayPicker$m_ddlPageSize", "1");
		params.put("m_tbJumpToLocation", "Jump to Address");
		params.put("m_ucGridSaveLinks$m_tbNewDisplayName", "Detailed");
		params.put("m_ucDragDropTable$m_hfGridState", "");
		params.put("m_hfMenuState", "Actions");
		params.put("m_ucContacts$m_ddlContacts", "-1");
		params.put("m_ucCartControl$m_ddlCarts", "G1");
		params.put("__LASTFOCUS", "");
		params.put("__VIEWSTATE", "0ppzn0HcpXtyhhalmN6nAJX/MsVM4Qm4FrPMxvRomo3a4KBGhcWwrRn+UJB7mbpTG8fXCaKay5PThQEKOnI+v4Ws9fkRxuB9czccopRZbkIGglYrHHSACF4hmB7GiWFOT3kDxQbHGrl7P3gfvbtUUABvD8Mc6HEJ0BX6HtV9vqBmz3kPrkvT1DCAjrrAvSvWP/wNDuE7S6AJZk8CF9Q0FF8fiSlXVldY6Z+x+UaDCQmakUz2ddp/RlpttMI1TIxPx0qCT/knVsepeY+Yn/NDA0cVcb3rr0DLmQyvU+FH60rmKWZzn7QM4enuQelNq99+1U/vzLkDDYZUv9W9Hi/JVH3a2fRLhwCYFRdN97jRBgn0HTvHgpYabKcdzL/T2W72QKA4FyMYvCy7cvevNp06EQ3xGWf81AxukWOHNSsLntf678/ci12ofBk5KQFpKPDxn16kWf/6MqI1bA8q2ShnCHJjShQDE9poaXy02G6MY8iQ2HakHHAyXUXpN7wUZMSnW12C5HrL5GqiIdxJT46tMoP1bBOObuKa/i1h4OZSx9q9WJJ3n7Y/LVD/7JgceKA6VO/Hbt74sXlNrgaSEQafcLgwKu0SOva2MtN4S9Iqj6b1rU9pQ/97WBsstN7dL7iw5R4MVpyjYvLAHav4Z/C20P6RjSpa5/X2+eVEXkLk8JLbhB/H7CO78o+15yRBurs3a9TtEoNkWlDC7Na5veedw/sCHbJz+4p4kTJrHnLJldfGGKRMR/aJc7f7/MnkJZMbJ6VadTUx3d9Qqg63bdyMoJpcR+727o7wnnTm8HZvZkPVOUCoQMYAP8vJutG6r/ehBXHiOuPSKcvMHhSKvOhQVShmcXxcnBVoZD8ZpjILNNcKzM0zCIiYoNVNv40JmdVZgJ9weF01/IlfWOepe6QHjLma2aUDFvNufsSkPQKeUHEasbBDm0EgFyHcdIWHSs+e+lD30vfuj+uWR7cTrhBNHDc2ESQdPItNpQCAQzu/jIAlWgd2fn861QTiL5q0tkbbEPGEBroWArnrl3msp1wDjAf0INT4aylXMGGcAy2XA/9du8Cu1al5902yfrnsYEJa0yMU/f8/vwjz0JF1fBAwj+lq9N/9m/wVQO2rZu0wQTHcoPWuad3vbCdujEeY9HG4uWEADk5M6jNMG/p1s5DEr138mG+k299tkfTnJxxvQcUm/kxdbqOVVK1FAY2H5khogr7WcHjlqm+XErZrozQweTGylEKmBk2dh5qtXjSdFSkFlhkVYlE9K1gpFdbY9Hh67MVBObEhUSBlLRQdjLHIa7jXQTF0wm70oSiOrMXTVVukWqIQqNGvG1ikwhF5GM1Upmyjdi2My6km2b+Zbz+k9jCs7x4YXVvpL1Hq50sXfTC0zfIT+AIFfTce8j3fD8mcsPRImjin5Sy/Jtx5k6wytTeQILv/jPicRc+NqUUgpwurJkaD5nL1t/TCxAXggWbgbxsodxUwgnu5JJHZmF2d5fTGVoh3X/90QkwTef09FIHQHkmJWIzK1QO9bS6iq4jyiO4qIKAXfeZW6PhzsUGVnvSis8MrnwU9iGE0PiiV9U8uXEdVZxk/dsBluLKTpxCvyn5IRgks0euu2OiE5xDePKYeF4+Id84lfcYd+chOIgieX5mAd7gbLGzguac9XwCh1IjAKgGmzy9PLcDbpwd9StqarcnFmwzX8TKmepiYGq0Mws8AxoCv0gl8H/42MJxD6nRkvpbD9I/TfVcEcQM9O6DfZ2oYNy0lSTAQ3yhdzyHwIFHT7OcFKnO7wLccBsLLkKknNR47UsCRBVNTaBnGNNVdZtF/CprGXCB4606wwWZQZDA9j462MOCyMZzpfiXBmIyJyH+9aKqSXatZM0WutW3b177YTNGwJGhSC7393srLWVrA1tj372TVIUFD8I5JA+exj1EZ11tgdrXanYrzkKEsu1nLR0p5vQX+htOVkPbtl9dZVh8TAy9zwZA=");
		params.put("__VIEWSTATEGENERATOR", "FC82AFCD");
		
		params.put("__EVENTTARGET", "m_DisplayCore");
		params.put("__EVENTARGUMENT", "Redisplay|," + number);
		params.put("__QA", "");
		params.put("hfCheckAllChangedTo", "");
		params.put("hfChangedCheckboxes", "");
		params.put("hfCheckedListingsNotOnDisplay", "");
		params.put("__VIEWSTATEENCRYPTED", "");
		params.put("__ASYNCPOST", "true");
		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				list.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}
		}
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
		method.setEntity(entity);
		
		HttpResponse httpResponse = httpClient.execute(method);
		HttpEntity res = httpResponse.getEntity();
        System.out.println(EntityUtils.toString(res));
        System.out.println("count OK!");

	}
	
	private static void setCommonHeaders(HttpRequestBase httpMethod, boolean isAjax){
		httpMethod.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36");
		httpMethod.setHeader("Referer", "http://matrix.centris.ca/Matrix/Results.aspx?c=AAEAAAD*****AQAAAAAAAAARAQAAAFAAAAAGAgAAAAQ4MTU2BgMAAAABMgYEAAAAATEKBgUAAAAFMTU4NDQGBgAAAAUxNTg3Mg0CBgcAAAACNDMNDQYIAAAAAjUwBgkAAAABMAoGCgAAAAExDQIGCwAAAAbDicKjS3wNLAYMAAAAATENBgs)");
		httpMethod.setHeader("Host", "matrix.centris.ca");
		httpMethod.setHeader("Upgrade-Insecure-Requests", "1");
		httpMethod.setHeader("Connection", "keep-alive");
		httpMethod.setHeader("Cache-Control", "no-cache");
		httpMethod.setHeader("Accept", "*/*");
		httpMethod.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		httpMethod.setHeader("Accept-Encoding", "gzip, deflate");
		httpMethod.setHeader("X-MicrosoftAjax", "Delta=true");
		httpMethod.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		httpMethod.setHeader("Origin", "http://matrix.centris.ca");
		httpMethod.setHeader("Cookie", "MatrixMachineID=-3936030812; ASP.NET_SessionId=y5duj35zpotyxackzyuilmxp; LoginSig=88617 - y5duj35zpotyxackzyuilmxp - CL-CIGM-WEB01 - 08:03:33.413; MLSAuth=4C117B13339AC19EB2FCA328AA0B6CE3D1BC0593B9B8B7FCBD8868FF623BC36C64C2E2D4F7502FC55CD9B17628D0519BF862874E6AB0E23F298BBE47E2EED7E63E6F409F4C0CD84F883FB8D09A71634ADFFBF355F77223139FB849DA; MatrixLoginName=; __utma=6790574.727462245.1445604530.1445693334.1445774622.3; __utmc=6790574; __utmz=6790574.1445604530.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)");
		if(isAjax){
			httpMethod.setHeader("X-Requested-With", "XMLHttpRequest");
		}
	}
	
	public static String test() throws IOException{
		CloseableHttpClient httpClient = createHttpClient();
		HttpGet get = new HttpGet("http://matrix.centris.ca/Matrix/Results.aspx?c=AAEAAAD*****AQAAAAAAAAARAQAAAFAAAAAGAgAAAAQ4MTU2CgYDAAAAATENBQYEAAAAAjQzDRMGBQAAAAUVwqcj");
		setCommonHeaders(get, false);
		
		//String body = "O363=1&F363=A&O2283=1&F2283=VBE&O3907=1&F3907=DETD&SubTypeID=1&TableID=1&ClientID=&StatReqFieldID=3928&StatReqFieldID=153&StatReqFieldID=226&StatReqFieldID=353&StatReqFieldID=3922&mediareqfieldid=26&mediareqfieldid=2811&mediareqfieldid=2815&mediareqfieldid=2817&DoCount=1";
		//System.out.println(body);
		//post.setEntity(new StringEntity(body));
        
        CloseableHttpResponse response = httpClient.execute(get, DEFAULT_CONTEXT);
        handleResponseCookie(response);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println(result);
        System.out.println("count OK!");
        return result;
	}
	
	/**
	 * Grab the response cookie and set into the DEFAULT_COOKIE_STORE;
	 * The cookie returned looks like this: "Set-Cookie: InactivityServer=P8hDuJKUe%2bL%2fM6WDK7PQVg%3d%3d; path=/";
	 * The cookie returned was binded to the root path "/"; 
	 * we should reconstruct such cookies and set the path=null, so such cookies can be sent out in the subsequent requests;
	 * @param response
	 */
	private static void handleResponseCookie(CloseableHttpResponse response) {
		// Multiple "Set-Cookie" may return; so we iterate each one;
		Header[] cookies = response.getHeaders("Set-Cookie");
		for(Header header : cookies){
			String setCookie = header.getValue();
			setCookie = setCookie.split("; ")[0];
			String[] pair = setCookie.split("=");
			BasicClientCookie cookie = new BasicClientCookie(pair[0], pair[1]);
			cookie.setDomain("mlslink.mlxchange.com");
			DEFAULT_COOKIE_STORE.addCookie(cookie);
		}
	}

	public static void setCookie(String cookie){
		COOKIE = cookie;
		LAST_COOKIE_TIME = new Date();
		reconstructCookies();
	}
	
	public static Date getLastCookieTime(){
		return LAST_COOKIE_TIME;
	}
}
