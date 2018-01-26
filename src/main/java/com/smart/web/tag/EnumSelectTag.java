package com.smart.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.smart.util.ReflectionUtils;

/**
 * 枚举选项JSP标签
 * 
 * 使用方法
 * <smt:enumSelect type="com.smart.consts.DictValueType" value="string" />
 * @author Sunxin
 *
 */
public class EnumSelectTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 元素名
	 */
	private String name = "";
	
	/**
	 * 元素id
	 */
	private String id = "";
	/**
	 * 枚举类全限定名, required;
	 */
	private String type;
	
	/**
	 * 当前选中值, optional;
	 */
	private String value;
	
	/**
	 * css class
	 */
	private String cssClass = "form-control";
	
	/**
	 * css 样式
	 */
	private String style = "";
	
	@Override
	public int doStartTag() throws JspException {
		Class<?> clz;
		try {
			clz = Class.forName(type);
		} catch (ClassNotFoundException e1) {
			throw new JspException("can't find class " + type, e1);
		}
		Object[] objs = clz.getEnumConstants();
		if(objs==null) {
			throw new JspException("class " + type + " is not an enum class");
		}
		
		JspWriter out = this.pageContext.getOut();
		try {
			out.println("<select class='" + cssClass + "' style='" + style + " ' name='"+name+"' id='"+id+"'>");
			for(Object o : objs) {
				String val = o.toString();
				String label = (String) ReflectionUtils.invokeGetterMethod(o, "description");
				out.print("<option value='" + val + "'");
				if(value!=null && value.equals(val)) {
					out.print(" selected ");
				}
				out.print(">");
				out.print(label);
				out.println("</option>");
				
			}
			out.println("</select>");
		} catch (IOException e) {
			e.printStackTrace();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
}
