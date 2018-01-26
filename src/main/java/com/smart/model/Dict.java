package com.smart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.smart.consts.DictModules;
import com.smart.consts.DictValueType;

/**
 * 字典项
 * 
 * @author Sunxin
 *
 */

@Entity
@Table(name = "t_dict_item")
public class Dict extends BaseEntity<Dict>{

	private static final long serialVersionUID = -2579814790698777520L;
	
	/**
	 * 所属模块，默认如果没有指定则属于系统模块
	 */
	private String module = DictModules.MOD_SYS;
	
	/**
	 * 名称, 用以描述该字典项
	 */
	private String name;
	
	/**
	 * 字典项的key, 本来该字段准备命名为key, 但是和数据库保留字冲突了
	 */
	private String code;
	
	/**
	 * 字典项的值
	 */
	@Column(length=2048)
	private String value;
	
	/**
	 * 值类型, 和值编辑器有关
	 */
	private DictValueType vtype;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DictValueType getVtype() {
		return vtype;
	}

	public void setVtype(DictValueType vtype) {
		this.vtype = vtype;
	}

}
