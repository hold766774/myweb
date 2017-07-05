package com.myweb;
import org.springframework.web.servlet.mvc.Controller;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class IndexAction implements Controller{

	public String view;
	public String view2;
	public String getView2() {
		return view2;
	}
	public void setView2(String view2) {
		this.view2 = view2;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mView=new ModelAndView(view2);
		mView.addObject("hello", "你好");
		return mView;
	}

}
