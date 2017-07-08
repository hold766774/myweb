package com.myweb.tool;

import java.io.IOException;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

public class MemcachedUtil {
	MemcachedClient memcachedClient;
	String ipAddress="127.0.0.1";
	String port="11211";
	
	public MemcachedUtil() throws IOException
	{
		this.init();
	}
	public MemcachedUtil(String ipAddress,String port ) throws IOException 
	{
		this.ipAddress=ipAddress;
		this.port=port;
		this.init();
	}
	public void init() throws IOException {
		memcachedClient=new MemcachedClient(AddrUtil.getAddresses(this.ipAddress+":"+this.port));
	}
	public boolean isNull(String key) {
		return memcachedClient.get(key)==null;
	}
	public void set(String key,Object o,int exp) {
		memcachedClient.set(key, exp, o);
	}
	public Object get(String key) {
		return memcachedClient.get(key);
	}
	
}
