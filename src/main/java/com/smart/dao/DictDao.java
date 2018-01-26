package com.smart.dao;
 

import com.smart.model.Dict;
import com.smart.model.DictCond;


public interface DictDao extends BaseDao<Dict, DictCond, Long>{

	String getDictValue(String module, String key);
	
	Page<Dict> findPageByModule(PageRequest pageRequest, String moduleName);

	Dict getDict(String moduleName, String key);
}
