package com.myweb;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.tool.WebMsg;

@Controller
public class MsgAction {
	@RequestMapping("/msgtest")
	public String msgtest(HttpServletRequest request,HttpServletResponse response) {
		WebMsg webMsg=new WebMsg();
		webMsg.sendMsg("a", "b", "hello");
		return "test";
	}
	@RequestMapping("/getmsg")
	public void getmsg(HttpServletRequest request,HttpServletResponse response) {
		try {
			//if(request.getParameter("username")!=null) //获取参数
				
			response.getWriter().write("hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/send")
	public String send(HttpServletRequest request,HttpServletResponse response) {
		
		return "msg";
	}
}
