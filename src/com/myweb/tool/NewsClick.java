package com.myweb.tool;

import com.myweb.database.dao.NewsDao;

import redis.clients.jedis.Jedis;

public class NewsClick {
	NewsDao newsDao;
	Jedis jedis;
	int max=5;//最大刷新次数
	public NewsClick(NewsDao newsDao)
	{
		this.jedis=new Jedis("localhost",6379);
		this.newsDao=newsDao;
	}
	public int getNewsClickNum(int newsid) {
		if(jedis.exists("news"+newsid))
		{
			//假设存在Key,1 取出 2 split分割 3 判断是否达到最大值，如果达到往数据库更新，同时清零，如果没有达到，则继续刷新redis
			String getValue=jedis.get("news"+newsid);
			int oldCount=Integer.parseInt(getValue.split(",")[0]);//点击量
			int refCount=Integer.parseInt(getValue.split(",")[1]);//刷新次数
			
			if(refCount>=max)//超过最大刷新次数
			{
				newsDao.updateNewsClickNum(newsid, oldCount);
				jedis.set("news"+newsid, String.valueOf(oldCount+refCount)+","+"0");//清零
				
			}else{
				jedis.set("news"+newsid, String.valueOf(oldCount)+","+(refCount+1));//累加
				
			}
			return oldCount+refCount+1;
		}else{
			//不存在Key，从数据库中取出数据
			//值：数据库值,当前刷新次数
			int oldCount=newsDao.getNewsClickNum(newsid);
			jedis.set("news"+newsid, String.valueOf(oldCount)+","+"1");
			return oldCount+1;
		}
		
	}
}
