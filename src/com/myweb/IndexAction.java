package com.myweb;
import org.springframework.web.servlet.mvc.Controller;

import com.myweb.tool.BarFactory;
import com.myweb.tool.BottomBar;
import com.myweb.tool.NavBar;
import com.myweb.tool.TopBar;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class IndexAction implements Controller{

	public String view;
	

	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mView=new ModelAndView(view);
		/*NavBar topBar=new TopBar();
		mView.addObject("top_nav", topBar.getBarContent());
		NavBar bottomBar=new BottomBar();
		mView.addObject("bottom_nav", bottomBar.getBarContent());*/
		NavBar topNav=BarFactory.CreateBar("top");
		mView.addObject("top_nav", topNav.getBarContent());
		NavBar bottomNav=BarFactory.CreateBar("bottom");
		mView.addObject("bottom_nav", bottomNav.getBarContent());
		
		//基本类型 封装类
		/*int a=3;
		Integer bInteger=3;
		mView.addObject("result", Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);//tomcat控制台*/	
		
		//== equals
		String aString=new String("a");
		String bString=new String("a");
		//mView.addObject("result", aString==bString);//false
		//mView.addObject("result", aString.equals(bString));//true
		
		int aint=Integer.parseInt("3");//类型转换
		
		//多个字符串相加
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append(aString);
		stringBuffer.append(3);
		mView.addObject("result", stringBuffer.toString());//true
		return mView;
	}

}
