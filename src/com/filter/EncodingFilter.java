package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName="EncodingFilter",urlPatterns="/*")//拦截所有请求（大部分情况）
public class EncodingFilter implements Filter{
	public EncodingFilter(){
		System.out.println("过滤器构造");
	}
	public void destroy() {
		System.out.println("过滤器销毁");
	}
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8"); //将编码改为utf-8
		response.setContentType("text/html;charset=utf-8");
		//放行
		chain.doFilter(request, response);
		}
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器初始化");
	}
}