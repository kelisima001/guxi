package com.smart.util;

import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XmlUtils {

	protected static final Log log = LogFactory.getLog(XmlUtils.class);

	private XStream xstream;

	public XmlUtils(String alias) {

		// 初始化序列化工具

		xstream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));

		xstream.alias(alias, TreeMap.class); // for toXML

		xstream.alias(alias, Map.class); // for fromXML/toXML

	}

	@SuppressWarnings("unchecked")

	public Map<String, String> parse(String respXml) {

		try {

			return (Map<String, String>) xstream.fromXML(respXml);

		} catch (Exception e) {

			log.error("XStream Parse to XML Error.", e);

		}

		return null;

	}

	public String format(Map<String, String> params, String charset) {

		StringWriter writer = new StringWriter();

		try {

			xstream.toXML(params, writer);

			return writer.toString();

		} catch (Exception e) {

			log.error("XStream Parse to Obj Error.", e);

		}

		return StringUtils.EMPTY;

	}

}
