package com.smart.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public final class JsonUtil {

	public static String string2json(String key, String value) {
		JSONObject object = new JSONObject();
		object.put(key, value);
		return object.toString();
	}

	public static Object json2Array(String json, Class valueClz) {
		JSONArray jsonArray = JSONArray.fromObject(json);
		return JSONArray.toArray(jsonArray, valueClz);
	}

	public static String collection2json(Object object) {
		JSONArray jsonArray = JSONArray.fromObject(object);
		return jsonArray.toString();
	}

	public static Collection json2Collection(String json, Class collectionClz,
			Class valueClz) {
		JSONArray jsonArray = JSONArray.fromObject(json);
		return JSONArray.toCollection(jsonArray, valueClz);
	}

	public static String array2json(Object object) {
		JSONArray jsonArray = JSONArray.fromObject(object);
		return jsonArray.toString();
	}

	public static String map2json(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}

	public static Map json2Map(Object[] keyArray, String json, Class valueClz) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		Map classMap = new HashMap();

		for (int i = 0; i < keyArray.length; i++) {
			classMap.put(keyArray[i], valueClz);
		}
//
		return (Map) JSONObject.toBean(jsonObject, Map.class, classMap);
	}

	public static String bean2json(Object object) {
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}

	public static Object json2Object(String json, Class beanClz) {
		return JSONObject.toBean(JSONObject.fromObject(json), beanClz);
	}

	public static String json2String(String json, String key) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return jsonObject.get(key).toString();
	}

}
