package com.myweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.database.dao.NewsDao;
import com.myweb.news.NewsEntity;
import com.myweb.tool.BarFactory;
import com.myweb.tool.NavBar;
import com.myweb.users.User;

@Controller
public class NewsAction {

	@Autowired
	JdbcTemplate jb;//自动寻找bean中id为jb的
	@Autowired
	User userbean;//必须跟bean中的id一样
	
	@Autowired
	NewsDao newsDao;
	
	@RequestMapping("/newslist")
	public ModelAndView newslist()
	{
		ModelAndView modelAndView=new ModelAndView("newslist");//视图
		modelAndView.addObject("newslist", newsDao.loadNews());
		return modelAndView;
	}
	
	@RequestMapping("/news")
	public ModelAndView ShowNewsDetail(@RequestParam(value="id",required=false) String id)
	{
		// /news?id=3触发
		
		ModelAndView modelAndView=new ModelAndView("news");//视图
		if(id==null){
			modelAndView.addObject("content", "这是新闻列表页面");
		}else{
			modelAndView.addObject("content", "这是新闻内容页"+id);
		}
		
		NavBar topNav=BarFactory.CreateBar("top");
		modelAndView.addObject("top_nav", topNav.getBarContent());
		NavBar bottomNav=BarFactory.CreateBar("bottom");
		modelAndView.addObject("bottom_nav", bottomNav.getBarContent());
		
		List<String> the_news=new ArrayList();
		the_news.add("第一条新闻");
		the_news.add("第2条新闻");
		the_news.add("第3条新闻");
		modelAndView.addObject("the_news", the_news);
		
		List the_news2=new ArrayList();
		Map f_news=new HashMap();
		f_news.put("newstitle", "第4条新闻");
		Map f_news1=new HashMap();
		f_news1.put("newstitle", "第5条新闻");
		Map f_news2=new HashMap();
		f_news2.put("newstitle", "第6条新闻");
		the_news2.add(f_news);
		the_news2.add(f_news1);
		the_news2.add(f_news2);
		modelAndView.addObject("the_news2", the_news2);
		
		
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("<a href=''>首页</a> | ");
		stringBuffer.append("<a href=''>第一页</a> | ");
		stringBuffer.append("<a href=''>第二页</a> | ");
		stringBuffer.append("<a href=''>第三页</a> | ");
		stringBuffer.append("<a href=''>第四页</a> | ");
		stringBuffer.append("<a href=''>末页</a>");
		//.addObject("pagebar", stringBuffer.toString());
		modelAndView.addObject("pagebar", stringBuffer);
		
		//NewsEntity newsEntity=new NewsEntity();
		//modelAndView.addObject("newsEntity", newsEntity.getNews());
		
		//确定里面存放的都是什么类型
		List<String> strings=new ArrayList<>();
		strings.add("aaa");
		String aString=strings.get(0);
		modelAndView.addObject("aString", aString);
		
		List<NewsEntity> newsList=new ArrayList<>();
		newsList.add(new NewsEntity(1,"新闻标题1"));
		newsList.add(new NewsEntity(2,"新闻标题2"));
		newsList.add(new NewsEntity(3,"新闻标题3"));
		modelAndView.addObject("newsList", newsList);
		
		String[] a=new String[10];
		a[0]="nihao";
		a[1]="java";
		System.out.println(a[0]);
		String[] b={"a","c","e","f","g"};
		for(int i=0;i<b.length;i++)
		{
			System.out.println(b[i]);
		}
		for (String string : b) {
			System.out.println(string);
		}
		//list-->string[]
		String[] newslist=(String[]) strings.toArray(new String[strings.size()]);
		//string[]-->list
		List<String> bList=Arrays.asList(b);
		
		List userlist=jb.queryForList("select * from users");
		modelAndView.addObject("userlist", userlist);
		modelAndView.addObject("userbean", userbean);
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
