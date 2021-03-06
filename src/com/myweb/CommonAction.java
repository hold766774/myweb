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

import com.alibaba.fastjson.JSON;
import com.myweb.database.dao.ReviewDao;
import com.myweb.database.model.ReviewModel;
import com.myweb.tool.Common;


@Controller
public class CommonAction {
	/*@RequestMapping("/top")
	public String top()
	{
		return "top";
	}*/
	@Autowired
	ReviewDao reviewDao;
	@RequestMapping("/loadreview")
	public ModelAndView loadreview(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("review");
		
		int newsid=Integer.parseInt(request.getParameter("newsid"));
		int newstype=Integer.parseInt(request.getParameter("newstype"));
		mv.addObject("newsid", newsid);
		mv.addObject("newstype", newstype);
		if(request.getParameter("isload")!=null)
		{
			int page=Integer.parseInt(request.getParameter("page"));
			int pagesize=Integer.parseInt(request.getParameter("pagesize"));
			List<ReviewModel> getReview=reviewDao.loadReview(newstype, newsid, page, pagesize);
			String result=JSON.toJSONString(getReview);
			System.out.println(result);
			try {
				response.getWriter().write(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
			return null;//不加载模板
		}
		return mv;
	}
	@RequestMapping("/loadpage")
	public ModelAndView loadPage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("page");
		mv.setViewName(request.getParameter("type"));
		String username=Common.getUserName();
		Cookie[] getCookies=request.getCookies();
		if(username!=null)
		{
			mv.addObject("UserName",username );
		}
	
		return mv;
	}

	public String genPageUrl(String url,int page)
	{
		return url+="?page="+page;
	}
	@RequestMapping("/pagination")
	public ModelAndView genPagination(HttpServletResponse response,HttpServletRequest request)
	{

		ModelAndView mv=new ModelAndView("page");
		
		
		//获取参数的过程
		String url=request.getParameter("url");
		
		int dataSum= Integer.parseInt(request.getParameter("sum")); //代表数据的总条数
		
		int currentPage= Integer.parseInt( request.getParameter("cp")); //当前页码
		
		int pageSize= Integer.parseInt( request.getParameter("size")); //一页显示多少条
		
		int maxPage= Integer.parseInt( request.getParameter("max")); //最多显示多少页码
		
		int start=1,end=1;// 起始页码和结束页码
		
		int maxEnd=dataSum%pageSize>0?dataSum/pageSize+1:dataSum/pageSize; //代表实际有多少页
		
		if(dataSum>pageSize) //如果数据总条数都没有pageSize大，那么最后一页就是 maxEnd
		{
			if(currentPage>maxPage && currentPage<=maxEnd)
			{
				start=currentPage-maxPage/2;  
				//把最大页码 除以2 再用 当前页码减去。 如最大页码是10，当前页码是15。那么就要从 15-10 作为起始页
				end=currentPage+maxPage/2;  //原理同上
				
				
				if(end>maxEnd)  end=maxEnd;//如果计算出来的最大页码数 超过了 实际页码，则要做处理
			}
			else
			{
				end=maxEnd;
			}
		}
		
		StringBuffer pageResult=new StringBuffer();  //字符串累加 应该使用 StringBuffer
		String nextPage="";//下一页
		String endPage="";//尾页
		for(int i=start;i<=end;i++)
		{
			if(i==currentPage)
			pageResult.append("<li class='active'><a  href='"+genPageUrl(url,i)+"'>"+i+"</a></li>");
			else
				pageResult.append("<li><a href='"+genPageUrl(url,i)+"'>"+i+"</a></li>");
		}
		
		//是否显示   下一页
		if((currentPage+1)<=maxEnd)
		{
			nextPage="<li><a href='"+genPageUrl(url,currentPage+1)+"'>下一页</a></li>";
		}
		if(maxEnd>1 && currentPage<maxEnd)
		{
			endPage="<li><a href='"+genPageUrl(url,maxEnd)+"'>尾页</a></li>";
		}
		
		 
	  mv.addObject("pageResult",pageResult.toString());
	  mv.addObject("nextPage",nextPage);
	  mv.addObject("endPage",endPage);
		
		return mv;
	}
 
}
