package com.myweb.tool;



public class BarFactory {
	//bar工厂
	public static NavBar CreateBar(String type)
	{
		NavBar navBar;
		switch (type) {
		case "top":
			navBar=new TopBar();
			break;
		case "bottom":
			navBar=new BottomBar();
			break;
		default:
			navBar=new TopBar();
			break;
			
		}
		return navBar;
	}

}
