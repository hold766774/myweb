package com.myweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.tool.BarFactory;
import com.myweb.tool.NavBar;

@Controller
public class NewsAction {

	@RequestMapping("/news")
	public ModelAndView ShowNewsDetail(@RequestParam(value="id",required=false) String id)
	{
		// /news?id=3触发
		ModelAndView modelAndView=new ModelAndView("news");
		if(id==null){
			modelAndView.addObject("content", "这是新闻列表页面");
		}else{
			modelAndView.addObject("content", "这是新闻内容页"+id);
		}
		
		NavBar topNav=BarFactory.CreateBar("top");
		modelAndView.addObject("top_nav", topNav.getBarContent());
		NavBar bottomNav=BarFactory.CreateBar("bottom");
		modelAndView.addObject("bottom_nav", bottomNav.getBarContent());
		return modelAndView;
	}
	@RequestMapping("/news/{id}/")
	public ModelAndView ShowNewsDetail2(@PathVariable String id)
	{
		// /news/3触发
		ModelAndView modelAndView=new ModelAndView("news");
		if(id==null){
			modelAndView.addObject("content", "这是新闻列表页面");
		}else{
			modelAndView.addObject("content", "这是新闻内容页"+id);
		}
		
		NavBar topNav=BarFactory.CreateBar("top");
		modelAndView.addObject("top_nav", topNav.getBarContent());
		NavBar bottomNav=BarFactory.CreateBar("bottom");
		modelAndView.addObject("bottom_nav", bottomNav.getBarContent());
		return modelAndView;
	}

}
