package com.myweb;

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
}
