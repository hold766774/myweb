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
		return mView;
	}

}
