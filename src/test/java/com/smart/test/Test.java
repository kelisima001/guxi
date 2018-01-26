package com.smart.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.smart.util.IOUtil;
import com.smart.util.SimpleHttpClient;

import jodd.util.StringUtil;

public class Test {

	public static void main(String[] args) throws IOException {
		SimpleHttpClient client = new SimpleHttpClient();
		List<String> lines = IOUtil.readLines(Test.class.getResourceAsStream("home.css"));
		for(String line : lines) {
			if(StringUtil.isEmpty(line)) {
				continue;
			}
			line = line.split("uploads")[1].replace(");}", "");
			line = "http://www.jingyitouzigroup.com/uploads" + line;
			String filename = line.substring(line.lastIndexOf("/") + 1);
			
			System.out.println(line + " --> " + filename);
			client.downloadFile(line, new File("/Users/andpay/Downloads/jspider-0.5.0-dev/output/www.jingyitouzigroup.com/uploads/" + filename));
		}
		
	}

}
