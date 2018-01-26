package com.smart.web.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.smart.core.SpringContext;
import com.smart.model.Menu;
import com.smart.service.MenuService;

/**
 * 菜单项JSP标签
 * 
 * 使用方法
 * <smt:menu parentCode="index" />
 * @author Sunxin
 *
 */
public class MenuTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String parentCode;
	
	private String className = "";
	
	private String domId = "";
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		MenuService menuService = SpringContext.getBean(com.smart.service.MenuService.class);
		if(parentCode==null){
			parentCode = Menu.ROOT_MENU_CODE;
		}
        try {
        	Menu parent = menuService.findOneBy("code", parentCode);
        	List<Menu> list = menuService.findBy("parent", parent);
        	String result = "<ul class=\"" + className + "\" id=\"" + domId + "\">\n";
        	for(Menu menu : list){
        		result += "<li id=\"menu-" + menu.getCode() + "\"><a href=\"" 
        				+ menu.getUrl() + "\">" + menu.getName() + "</a></li>\n";
        	}
        	result += "</ul>";
			out.print(result);
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

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDomId() {
		return domId;
	}

	public void setDomId(String domId) {
		this.domId = domId;
	}

}
