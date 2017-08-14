package com.msk.core.web.base;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public abstract class BaseTag extends SimpleTagSupport {
	/**
	 * make the tag HTML.
	 * 
	 * @param request
	 *            the current request
	 * @throws javax.servlet.jsp.JspException
	 *             Subclasses can throw JspException to indicate an error
	 *             occurred while processing this tag.
	 * @throws java.io.IOException
	 *             Subclasses can throw IOException if there was an error
	 *             writing to the output stream
	 * 
	 */
	protected abstract void doTag(HttpServletRequest request) throws JspException, IOException;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		this.doTag(this.getRequest());
	}

	protected HttpServletRequest getRequest() {
		PageContext pageContext = (PageContext) this.getJspContext();
		return (HttpServletRequest) pageContext.getRequest();
	}
	protected <T> T getApplicationBean(String name,Class<T> Class) {
		PageContext pageContext = (PageContext) this.getJspContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		T taglogic = ctx.getBean(name, Class);
		return taglogic;
	}
}
