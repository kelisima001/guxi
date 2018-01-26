package com.smart.util;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * JSON工具类（过滤null字段，可指定日期格式）
 * 
 * @Author Sunxin
 */
public class JSON {
	/**
	 * 标准日期格式
	 */
	public static final String DEFAULT_DATE_PATTERN = "yyyyMMddHHmmss";

	/**
	 * 默认实现 (java.util.Date使用标准日期格式的字符串表示)
	 */
	private static JSON DEFAULT = build(DEFAULT_DATE_PATTERN);

	/**
	 * JACKSON转换器
	 */
	private ObjectMapper jacksonMapper;

	/**
	 * 格式化jackson转换器
	 */
	private ObjectMapper prettyJacksonMapper;
	
	/**
	 * 显示类型jackson转换器
	 */
	private ObjectMapper explictTypeJacksonMapper;

	/**
	 * 构造函数
	 */
	private JSON() {
	}

	/**
	 * 获得默认实现
	 * 
	 * @return
	 */
	public static JSON getDefault() {
		return DEFAULT;
	}

	/**
	 * 指定日期格式并构建JSON对象
	 * 
	 * @param datePattern
	 *            日期格式
	 */
	public static JSON newInstance(String datePattern) {
		if (DEFAULT_DATE_PATTERN.equals(datePattern)) {
			return DEFAULT;
		}

		return build(datePattern);
	}


	private static ObjectMapper buildMapper(String datePattern) {
		ObjectMapper jacksonMapper = new ObjectMapper();
		jacksonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		jacksonMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		jacksonMapper.setSerializationInclusion(Include.NON_NULL);

		if (datePattern != null) {
			DateFormat dateFormat = new SimpleDateFormat(datePattern);
			jacksonMapper.setDateFormat(dateFormat);
		}

		return jacksonMapper;
	}

	/**
	 * 构造JSON对象
	 * 
	 * @param datePattern
	 *            日期格式
	 */
	private static JSON build(String datePattern) {
		JSON json = new JSON();

		json.jacksonMapper = buildMapper(datePattern);
		
		json.prettyJacksonMapper = buildMapper(datePattern);
		json.prettyJacksonMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		json.explictTypeJacksonMapper = buildMapper(datePattern);
		json.explictTypeJacksonMapper.enableDefaultTyping(DefaultTyping.NON_FINAL);
		return json;
	}

	/**
	 * 将对象转换为JSON字符串
	 * 
	 * @param obj
	 * @return
	 */
	public String toJSONString(Object obj) {
		try {
			return jacksonMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("To json string error", e);
		}
	}
	
	public byte[] toJSONBytes(Object obj) {
		try {
			return jacksonMapper.writeValueAsBytes(obj);
		} catch (Exception e) {
			throw new RuntimeException("To json bytes error", e);
		}
	}
	
	/**
	 * 将对象转换为格式化可读的JSON字符串
	 * 
	 * @param obj
	 * @return
	 */
	public String toPrettyJSONString(Object obj) {
		try {
			return prettyJacksonMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("To json string error", e);
		}
	}
	
	/**
	 * 转成显示类型的JSON字符串
	 * @param obj
	 * @return
	 */
	public String toExplictJSONString(Object obj) {
		try {
			return explictTypeJacksonMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("to explict json string error", e);
		}
	}

	/**
	 * 将JSON字符串转换为对象
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public <T> T parseToObject(String json, Class<T> clazz) {
		try {
			return jacksonMapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException("Parse json str to object error", e);
		}
	}
	
	/**
	 * 将JSON字节串转换为对象
	 * 
	 * @param jsonData
	 * @param offset
	 * @param length
	 * @param clazz
	 * @return
	 */
	public <T> T parseToObject(byte[] jsonData, int offset, int length, Class<T> clazz) {
		try {
			return jacksonMapper.readValue(jsonData, offset, length, clazz);
		} catch (Exception e) {
			throw new RuntimeException("Parse json str to object error", e);
		}
	}
	
	/**
	 * 将JSON显示类型字符串转换为对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public <T> T parseToExplictObject(String json, Class<T> clazz) {
		try {
			return explictTypeJacksonMapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException("Parse explict json str to object error", e);
		}
	}

	/**
	 * 将JSON字符串转换为对象
	 * 
	 * @param json
	 * @param type
	 * @return
	 */
	public <T> T parseToObject(String json, final Type type) {
		try {
			return jacksonMapper.readValue(json, new TypeReference<T>() {
				public Type getType() {
					return type;
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("Parse json str to object error", e);
		}
	}
	
	/**
	 * 将JSON显示类型字符串转换为对象
	 * @param json
	 * @param type
	 * @return
	 */
	public <T> T parseToExplictObject(String json, final Type type) {
		try {
			return explictTypeJacksonMapper.readValue(json, new TypeReference<T>() {
				public Type getType() {
					return type;
				}
			});
		} catch (Exception e) {
			throw new RuntimeException("Parse explict json str to object error", e);
		}
	}
}
