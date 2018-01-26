package com.smart.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.smart.consts.DictModules;
import com.smart.core.SpringContext;
import com.smart.service.DictService;

/**
 * 字典项JSP标签
 * 
 * 使用方法
 * <smt:dict code="company.name" def="" />
 * @author Sunxin
 *
 */
public class DictTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	private String module = DictModules.MOD_SYS;
	
	private String code;
	
	/**
	 * 默认值
	 */
	private String def = "";
	
	@Override
	public int doStartTag() throws JspException {
		DictService dictService = SpringContext.getBean(com.smart.service.DictService.class);
		String value = dictService.getSetDictValue(module, code, def);
		if(value==null) {
			value = "";
		}
		JspWriter out = this.pageContext.getOut();
        try {
			out.print(value);
		} catch (IOException e) {
			
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}
	
}
