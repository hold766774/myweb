package com.myweb.tool;

public class TopBar implements NavBar{

	@Override
	public String getBarContent() {
		// TODO Auto-generated method stub
		return "<a href=''>首页</a> | <a href='/news'>新闻中心</a> | <a href='/login'>用户注册</a>";
	}

}
