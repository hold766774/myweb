package com.myweb;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.users.User;
@Controller
public class UserAction {
	@RequestMapping("/login")
	public ModelAndView login()
	{
		ModelAndView modelAndView=new ModelAndView("login");
		modelAndView.addObject("info", "请输入用户名和密码");
		return modelAndView;
		
	}
	@RequestMapping("/onlogin")
	public ModelAndView onlogin(@ModelAttribute("loginfrm") User user)
	{
		//loginfrm是form的Id
		//User的属性和login.jsp的name一样
		ModelAndView modelAndView=new ModelAndView("login");
		modelAndView.addObject("info", "您输入的用户名是"+user.getUsername());
		return modelAndView;
		
	}
}
