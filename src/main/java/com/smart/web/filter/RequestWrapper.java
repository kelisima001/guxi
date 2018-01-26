package com.smart.web.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public final class RequestWrapper extends HttpServletRequestWrapper {
    public static final String htmlTags = "<(a|abbr|acronym|address|applet|area|article|aside|audio|b|base|basefont|bdo|big|blockquote|body|br|button|canvas|caption|center|cite|code|col|colgroup|command|datagrid|datalist|datatemplate|dd|del|details|dialog|dfn|dir|div|dl|dt|em|embed|fieldset|figure|font|footer|form|frame|frameset|head|header|h1|h2|h3|h4|h5|h6|hr|html|i|iframe|img|input|ins|kbd|label|legend|li|link|m|map|menu|meta|meter|nav|nest|noframes|noscript|object|ol|optgroup|option|output|p|param|pre|progress|q|rule|s|samp|script|section|select|small|source|span|strike|strong|style|sub|sup|table|tbody|td|textarea|tfoot|th|thead|time|title|tr|tt|u|ul|var|video)\\s*.*((\\/>)|(>.*<\\/\\1>))";
    public static final Pattern tagsPattern = Pattern.compile(htmlTags);
    public static final String domEvents = "\\s*(onabort|onbeforeonload|onblur|onchange|onclick|oncontextmenu|ondblclick|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror|onfocus|onkeydown|onkeypress|onkeyup|onload|onmessage|onmousedown|onmousemove|onmouseover|onmouseout|onmouseup|onmousewheel|onreset|onresize|onscroll|onselect|onsubmit|onunload)\\s*=.*";
    public static final Pattern eventsPattern = Pattern.compile(domEvents);
    
    public RequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }
    
    @Override
	public String[] getParameterValues(String parameter) {
      String[] values = super.getParameterValues(parameter);
      if (values==null)  {
                  return null;
          }
      int count = values.length;
      String[] encodedValues = new String[count];
      for (int i = 0; i < count; i++) {
                 encodedValues[i] = cleanXSS(values[i]);
       }
      return encodedValues;
    }
    
    @Override
	public String getParameter(String parameter) {
          String value = super.getParameter(parameter);
          if (value == null) {
                 return null;
                  }
          return cleanXSS(value);
    }
    
    @Override
	public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return cleanXSS(value);
    }
    

    private String cleanXSS(String value) {
        
        Matcher matcher = tagsPattern.matcher(value);
        if(matcher.find()){
            //logger.warn(this, "found suspicious html tags in http request parameter value: " + value);
            value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
            //logger.warn(this, "this parameter value has been escaped to: " + value);
        }
        matcher = eventsPattern.matcher(value);
            
        if(matcher.find()){
            //logger.warn(this, "found suspicious dom event binding in http request parameter value: " + value);
            value = value.replaceAll("'", "&#39;");
            value = value.replaceAll("\"", "&#34;");
            //logger.warn(this, "this parameter value has been escaped to: " + value);
        }
        
        return value;
    }
}