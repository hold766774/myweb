package com.myweb.tool;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

public class WebMsg {
	Jedis jedis;
	public List<String> loadMsg(String userName,int page,int pagesize) {//加载用户消息列表
		SortingParams sortingParams=new SortingParams();
		sortingParams.limit((page-1)*pagesize, pagesize);
		sortingParams.desc();
		return jedis.sort("msg_"+userName, sortingParams);
	}
	public Long getMsgLength(String userName) {
		//获取消息总条数
		if(this.hasMsg(userName))
		{
			return jedis.llen("msg_"+userName);
		}
		return (long) 0;
	}
	public WebMsg()
	{
		this.jedis=new Jedis("localhost",6379);
	}
	public void sendMsg(String sendUser,String recUser,String msgContent) {
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time=dateFormat.format(date);//时间日期字符串
		
		//拼接第一个key info_b_from_a
		//String key1="info_"+recUser+"_"+"from_"+sendUser;
		//jedis.hset("webmsg", key1,time);//判断是否有消息
		
		//第二个key msg_b
		String key2="msg_"+recUser;
		String key2_body=time+"_"+sendUser+"_"+msgContent;
		jedis.rpush(key2, key2_body);
		
	}
	public void delMsg(String keyName) {
		jedis.hdel("webmsg", keyName);//删除消息提醒
	}
	public boolean hasMsg(String username) {
		return jedis.exists("msg_"+username);
	}
}
