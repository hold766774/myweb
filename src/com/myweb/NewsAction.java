package com.myweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.database.dao.NewsDao;
import com.myweb.database.dao.ReviewDao;
import com.myweb.database.model.NewsModel;
import com.myweb.database.model.ReviewModel;
import com.myweb.news.NewsEntity;
import com.myweb.tool.BarFactory;
import com.myweb.tool.Common;
import com.myweb.tool.MemcachedUtil;
import com.myweb.tool.NavBar;
import com.myweb.tool.NewsClick;
import com.myweb.users.User;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

@Controller
public class NewsAction {

	@Autowired
	JdbcTemplate jb;//自动寻找bean中id为jb的
	@Autowired
	User userbean;//必须跟bean中的id一样
	
	@Autowired
	NewsDao newsDao;
	@Autowired
	ReviewDao reviewDao;
	@RequestMapping("/addreview")
	public void addreview(HttpServletResponse response,HttpServletRequest request) throws IOException
	{
		String userName=Common.getUserName();
		int newsid=Integer.parseInt(request.getParameter("newsid"));
		String rcnt=request.getParameter("rcnt");
		
		if(userName=="")
		{
			response.getWriter().write("unlogin");
		}else
		{
			String userip=Common.getUserIP();
			ReviewModel reviewModel=new ReviewModel();
			reviewModel.setNewsid(newsid);
			reviewModel.setNewstype(1);
			reviewModel.setRcnt(rcnt);
			reviewModel.setUserip(userip);
			reviewModel.setUsername(userName);
			reviewDao.addReview(reviewModel);
			response.getWriter().write("1");
		}
	}
	 
		@RequestMapping("/newslist")
		public ModelAndView loadNews(HttpServletResponse response,HttpServletRequest request)
		{
			//加载新闻列表
			ModelAndView mv=new ModelAndView("newslist");
			
			int size=2;
			
			
			mv.addObject("size", size);
			int page=1;
			if(request.getParameter("page")!=null)
			{
				page=Integer.parseInt(request.getParameter("page"));
				if(page<=0) page=1;
			}
			mv.addObject("newslist", newsDao.loadNews(page,size));
			mv.addObject("sum", newsDao.getNewsCount());
			mv.addObject("page",page);
		   return mv;
			
		}
		@RequestMapping("/newsdetail")
		public ModelAndView newsdetail(int newsid) throws IOException
		{
			//加载新闻列表
			ModelAndView mv=new ModelAndView("newsdetail");
			MemcachedUtil memcachedUtil=new MemcachedUtil();
			//从缓存中获取数据
			NewsModel newsModel=(NewsModel) memcachedUtil.get("newsdetail_newsmodel"+String.valueOf(newsid));
			if(newsModel==null){
				//缓存中没有数据，需从数据库获取并设置到缓存中
				newsModel=newsDao.loadNewsDetail(newsid);
				memcachedUtil.set("newsdetail_newsmodel", newsModel, 3600*24);
			}else{
				System.out.println("从缓存中获取数据");
			}
			//int newsClickNum=newsDao.getNewsClickNum(newsid);
			int newsClickNum=new NewsClick(newsDao).getNewsClickNum(newsid);
			mv.addObject("news", newsModel);
			mv.addObject("newsid", newsid);
			mv.addObject("newsClickNum", newsClickNum);
			return mv;
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
