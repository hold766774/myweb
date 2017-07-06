package com.myweb;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.users.User;
@Controller
public class UserAction {
	@RequestMapping("/unlog")
	public String unlog(HttpServletRequest request,HttpServletResponse response)
	{
		Cookie logUser=new Cookie("loginUserName",null);
		//logUser.setDomain("");
		logUser.setMaxAge(0);//3600*24*7
		logUser.setPath("/");
		response.addCookie(logUser);
		return "login";
	}
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView("login");
		modelAndView.addObject("info", "请输入用户名和密码");
		
		Cookie[] getCookies=request.getCookies();
		for (Cookie cookie : getCookies) {
			if(cookie.getName().equals("loginUserName"))
			{
				//代表用户已经登录了
				modelAndView.setViewName("index");//返回首页
				return modelAndView;
			}
		}
		return modelAndView;
		
	}
	@RequestMapping("/onlogin")
	public ModelAndView onlogin(@ModelAttribute("loginfrm") User user,HttpServletResponse response)
	{
		//loginfrm是form的Id
		//User的属性和login.jsp的name一样
		ModelAndView modelAndView=new ModelAndView("login");
		//modelAndView.addObject("info", "您输入的用户名是"+user.getUsername());
		if(user.getUsername().equals("xiaoping")&&user.getUserpsw().equals("123"))
		{
			//代表用户的登录成功
			Cookie logUser=new Cookie("loginUserName", user.getUsername());
			//logUser.setDomain("");
			logUser.setMaxAge(3600*24*7);//3600*24*7
			logUser.setPath("/");
			response.addCookie(logUser);
			modelAndView.addObject("result", "登录成功");
		}else{
			modelAndView.addObject("result", "用户名密码错误");
		}
		
		return modelAndView;
		
	}
}
