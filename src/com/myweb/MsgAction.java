package com.myweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.myweb.database.dao.UserDao;
import com.myweb.database.model.MyMsg;
import com.myweb.tool.WebMsg;

@Controller
public class MsgAction {
	@Autowired
	HttpServletRequest request;
	@Autowired
	UserDao userDao;
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
				String getUser=this.getLoginUserName();
				if(getUser=="")
				{
					response.getWriter().write("-1");
					return;
				}
					
				WebMsg webMsg=new WebMsg();
				if(webMsg.hasMsg(getUser))
				{
					response.getWriter().write("1");
				}else{
					response.getWriter().write("0");
				}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/addmsg")
	public void addmsg(HttpServletRequest request,HttpServletResponse response) {
		String sender=request.getParameter("sender");//发送者
		String sendtime=request.getParameter("sendtime");//消息内容
		String msgcnt=request.getParameter("msgcnt");//发送时间
		String reveicer=this.getLoginUserName();//接收者
		
		MyMsg myMsg=new MyMsg();
		myMsg.sender=sender;
		myMsg.msgcnt=msgcnt;
		myMsg.receiver=reveicer;
		myMsg.sendtime=sendtime;
		
		userDao.addMsg(myMsg);
		try {
			response.getWriter().write("1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping("/msglist2")
	public ModelAndView msglist2(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView=new ModelAndView("msglist_read");
		WebMsg webMsg=new WebMsg();
		String userName=this.getLoginUserName();
		int page=1;
		if(request.getParameter("page")!=null)
		{
			page=Integer.parseInt(request.getParameter("page"));
			if(page<=0) page=1;
		}
		int pagesize=10;
		
		/*List<String> msgList=webMsg.loadMsg(userName, page, pagesize);
		if(msgList!=null)
		{
			modelAndView.addObject("msgList",msgList);
		}*/
		modelAndView.addObject("msglist",userDao.getMyMsg(this.getLoginUserName()));
		modelAndView.addObject("page",page);
		modelAndView.addObject("sum", webMsg.getMsgLength(userName));
		return modelAndView;
	}
	@RequestMapping("/msglist")
	public ModelAndView msglist(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView=new ModelAndView("msglist");
		WebMsg webMsg=new WebMsg();
		String userName=this.getLoginUserName();
		int page=1;
		if(request.getParameter("page")!=null)
		{
			page=Integer.parseInt(request.getParameter("page"));
			if(page<=0) page=1;
		}
		int pagesize=10;
		List<String> msgList=webMsg.loadMsg(userName, page, pagesize);
		if(msgList!=null)
		{
			modelAndView.addObject("msgList",msgList);
		}
		modelAndView.addObject("page",page);
		modelAndView.addObject("CurrentUserName",userName);
		modelAndView.addObject("sum", webMsg.getMsgLength(userName));
		return modelAndView;
	}
	@RequestMapping("/send")
	public String send(HttpServletRequest request,HttpServletResponse response) {
		
		return "msg";
	}
	public String getLoginUserName() {
		String username="";
		Cookie[] getCookies=request.getCookies();
		for (Cookie cookie : getCookies) {
			if(cookie.getName().equals("loginUserName"))
			{
				username=cookie.getValue();
			}
		}
		return username;
		
	}
	@RequestMapping("/sendmsg")
	public void sendmsg(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String userName=request.getParameter("UserName");//接收者
		String msgContent=request.getParameter("MsgContent");//消息内容
		String sender="";//发送者
		sender=this.getLoginUserName();
		if(sender=="")
		{
			response.getWriter().write("0");//发送失败
		}
		WebMsg webMsg=new WebMsg();
		webMsg.sendMsg(sender, userName, msgContent);
		response.getWriter().write("1");//发送成功
	}
}
