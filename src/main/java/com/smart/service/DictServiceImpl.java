package com.smart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BaseDao;
import com.smart.dao.DictDao;
import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Dict;
import com.smart.model.DictCond;

@Service
public class DictServiceImpl extends BaseEntityService<Dict, DictCond, Long> implements DictService{

	@Autowired
	private DictDao dao;
	
	@Override
	protected BaseDao<Dict, DictCond, Long> getDao() {
		return dao;
	}
	
	
	public void save(Dict dict) {
		super.save(dict);
	}
	
	public Map<String, String> findByModule(String moduleName){
		List<Dict> list = dao.findBy("module", moduleName);
		Map<String, String> map = new HashMap<String, String>();
		for(Dict item : list){
			map.put(item.getCode(), item.getValue());
		}
		return map;
	}
	
	public Page<Dict> findPageByModule(PageRequest pageRequest, String moduleName){
		return dao.findPageByModule(pageRequest, moduleName);
		
	}

	@Override
	public Dict getDict(String moduleName, String key) {
		return dao.getDict(moduleName, key);
	}
	
	@Override
	public String getDictValue(String moduleName, String key) {
		String val = dao.getDictValue(moduleName, key);
		return val;
	}
	
	@Override
	public String getSetDictValue(String moduleName, String key, String def) {
		String val = dao.getDictValue(moduleName, key);
		if(val==null) {
			Dict dict = new Dict();
			dict.setModule(moduleName);
			dict.setCode(key);
			dict.setValue(def);
			dao.save(dict);
			return dict.getValue();
		}
		return val;
	}
	@Override
	public Integer getDictIntValue(String moduleName, String key) {
		String val = dao.getDictValue(moduleName, key);
		if(val==null){
			return null;
		}
		Integer result = null;
		try{
			result = Integer.parseInt(val);
		}
		catch(Exception e){
			logger.warn("Failed to convert {} - {} into integer", key, val);
		}
		return result;
	}

	@Override
	public Long getDictLongValue(String moduleName, String key) {
		String val = dao.getDictValue(moduleName, key);
		if(val==null){
			return null;
		}
		Long result = null;
		try{
			result = Long.parseLong(val);
		}
		catch(Exception e){
			logger.warn("Failed to convert {} - {} into integer", key, val);
		}
		return result;
	}

	@Override
	public Double getDictDoubleValue(String moduleName, String key) {
		String val = dao.getDictValue(moduleName, key);
		if(val==null){
			return null;
		}
		Double result = null;
		try{
			result = Double.parseDouble(val);
		}
		catch(Exception e){
			logger.warn("Failed to convert {} - {} into integer", key, val);
		}
		return result;
	}
}
