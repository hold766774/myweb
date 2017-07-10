package com.myweb.tool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Common {
	public static String getUserName()//获取用户名
	{
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String username=null;
		Cookie[] getCookies=request.getCookies();
		for (Cookie cookie : getCookies) {
			if(cookie.getName().equals("loginUserName"))
			{
				username=cookie.getValue();
			}
		}
		return username;
	}
	public static String getUserIP() {
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		 String ip = request.getHeader("x-forwarded-for");
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) 
		    {
		         ip = request.getHeader("Proxy-Client-IP");
		             }
		           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            ip = request.getHeader("WL-Proxy-Client-IP");
		           }
		           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		           ip = request.getRemoteAddr();
	  }
return ip;
	}
}
