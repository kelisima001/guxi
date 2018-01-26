package com.smart.service;

import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.smart.dao.Page;
import com.smart.dao.PageRequest;
import com.smart.model.Dict;
import com.smart.model.DictCond;

/**
 * 字典服务类
 * 
 * @author Sunxin
 *
 */
@Transactional(readOnly = true)
public interface DictService extends BaseService<Dict, DictCond, Long> {

	/**
	 * 重新定义注解 从而可以支持缓存清理
	 * 注意@Transactional也是必须的
	 */
	@Transactional(readOnly = false)
	@CacheEvict(value="dictCache")
	public void save(Dict dict);
	/**
	 * 按模块名和key查找字典项的值
	 * 
	 * @param moduleName
	 * @param key
	 * @return String 字典值
	 */
	@Cacheable(value="dictCache", key="#moduleName.concat(#key)")
	public String getDictValue(String moduleName, String key);
	
	/**
	 * 按模块名和key查找字典项的值, 返回整数
	 * 
	 * @param moduleName
	 * @param key
	 * @return String 字典值
	 */
	@Cacheable(value="dictCache", key="#moduleName.concat(#key)")
	public Integer getDictIntValue(String moduleName, String key);
	
	/**
	 * 按code获取字段项的值, 如果不存在, 则设置默认值
	 * @param moduleName
	 * @param key
	 * @param def
	 * @return
	 */
	@Transactional(readOnly=false)
	public String getSetDictValue(String moduleName, String key, String def);
	
	/**
	 * 按模块名和key查找字典项的值, 返回长整数
	 * 
	 * @param moduleName
	 * @param key
	 * @return String 字典值
	 */
	public Long getDictLongValue(String moduleName, String key);
	
	/**
	 * 按模块名和key查找字典项的值, 返回双精度小数
	 * 
	 * @param moduleName
	 * @param key
	 * @return String 字典值
	 */
	public Double getDictDoubleValue(String moduleName, String key);
	
	/**
	 * 按模块名和key查找字典项的值
	 * @param module
	 * @param key
	 * @return Dict字典
	 */
	public Dict getDict(String module, String key);

	/**
	 * 按模块名查出所有该模块的字典项，然后组装成map方便使用
	 * 
	 * @param moduleName
	 * @return
	 */
	public Map<String, String> findByModule(String moduleName);

	/**
	 * 按模块分页查找字典项以方便后台分页查看
	 * 
	 * @param pageRequest
	 * @param moduleName
	 * @return
	 */
	public Page<Dict> findPageByModule(PageRequest pageRequest, String moduleName);
}
