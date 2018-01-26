package com.smart.web.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.smart.core.SpringContext;
import com.smart.model.SelectItem;
import com.smart.model.SelectType;
import com.smart.service.SelectItemService;
import com.smart.service.SelectTypeService;

/**
 * 由selectType生成选项JSP标签
 * 
 * 使用方法
 * <smt:select code="xxx.xxx" selectedItemId="110" />
 * 
 * @author Sunxin
 *
 */
public class SelectTypeTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * selectType的code
	 */
	private String code = "";
	
	/**
	 * 元素名
	 */
	private String name = "";
	
	/**
	 * 元素id
	 */
	private String id = "";
	
	/**
	 * 当前选中selectItem的id;
	 */
	private String selectedItemId = "";
	
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
		SelectItemService service = SpringContext.getBean(com.smart.service.SelectItemService.class);
		SelectTypeService typeService = SpringContext.getBean(com.smart.service.SelectTypeService.class);
		SelectType type = typeService.findByCode(code);
		List<SelectItem> items = null;
		if(type==null) {
			items = new ArrayList<SelectItem>();
		}
		else {
			items = service.findBySelectTypeId(type.getId());
		}
		JspWriter out = this.pageContext.getOut();
		try {
			out.println("<select class='" + cssClass + "' style='" + style + " ' name='"+name+"' id='"+id+"'>");
			for(SelectItem item : items) {
				String val = item.getId() + "";
				String label = item.getName();
				out.print("<option value='" + val + "'");
				if(selectedItemId!="" && selectedItemId.equals(val)) {
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getSelectedItemId() {
		return selectedItemId;
	}

	public void setSelectedItemId(String selectedItemId) {
		this.selectedItemId = selectedItemId;
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
