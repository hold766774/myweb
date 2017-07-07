package com.myweb;


import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.database.dao.UserDao;
import com.myweb.database.model.UserModel;
import com.myweb.users.User;
@Controller
public class UserAction {
	@Autowired
	UserDao userDao;
	@RequestMapping("/unlog")
	public void unlog(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		Cookie logUser=new Cookie("loginUserName",null);
		//logUser.setDomain("");
		logUser.setMaxAge(0);//3600*24*7
		logUser.setPath("/");
		response.addCookie(logUser);
		response.sendRedirect("login");//跳转到Login方法
		//return "login";
	}
	@RequestMapping("/reg")
	public ModelAndView reg(UserModel userModel,HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView modelAndView=new ModelAndView("reg");
		if(userModel.getUsername()!=null){
			int getUserID=userDao.addUser(userModel);
			if(getUserID>0)
			{
				modelAndView.addObject("result", "用户注册成功");
			}else{
				if(getUserID==-1)
				{
					modelAndView.addObject("result", "用户已经存在");
				}else
				modelAndView.addObject("result", "用户注册失败");
			}
		}
		return modelAndView;
	}
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("loginfrm") User user,HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView modelAndView=new ModelAndView("login");
		
		if(user.getUsername()!=null&&user.getUserpsw()!=null){
			//用户提交登录处理
			String getPwd=userDao.getUserPassword(user.getUsername());
			if(getPwd!=null&&getPwd.equals(user.getUserpsw())){//密码比对
				//代表用户的登录成功
				Cookie logUser=new Cookie("loginUserName", user.getUsername());
				//logUser.setDomain("");
				logUser.setMaxAge(3600*24*7);//3600*24*7
				logUser.setPath("/");
				response.addCookie(logUser);
				//modelAndView.addObject("result", "登录成功");
				modelAndView.setViewName("index");//返回首页
			}else{
				modelAndView.addObject("result", "用户名密码错误");
			}
		}
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
	
}
