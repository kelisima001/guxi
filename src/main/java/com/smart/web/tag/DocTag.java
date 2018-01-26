package com.smart.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.smart.core.SpringContext;
import com.smart.model.Doc;
import com.smart.service.DocService;

/**
 * 文档JSP标签 用于向页面插入一个文档的内容
 * 
 * 使用方法
 * <smt:doc code="mini.fee." />
 * <smt:doc docId="10001" />
 * @author Sunxin
 *
 */
public class DocTag extends TagSupport{
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private Long docId;
	
	@Override
	public int doStartTag() throws JspException {
		DocService docService = SpringContext.getBean(com.smart.service.DocService.class);
		
		Doc doc = null; 
		if(docId!=null){
			doc = docService.findOne(docId);
		}
		else{
			doc = docService.findOneBy("code", code);
		}
		String content = (doc!=null&&doc.getContentUnEscaped()!=null)?doc.getContentUnEscaped() : "!!!Empty!!!";
	
		JspWriter out = this.pageContext.getOut();
        try {
			out.print(content);
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

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
