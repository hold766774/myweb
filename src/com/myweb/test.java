package com.myweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.database.dao.UserDao;
import com.myweb.database.model.UserModel;

@Controller
public class test {
	@Autowired
	UserDao myUser;
	@RequestMapping("/test")
	public ModelAndView ontest()
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("test");
		List<UserModel> getUsers=myUser.getAllUsers();
		 modelAndView.addObject("getUsers", getUsers);
		return modelAndView;
	}
}
