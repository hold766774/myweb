﻿<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
  
    <title>myweb首页</title>
	<meta name="keywords" content="keywords" />
	<meta name="description" content="description" />
	<script src="/js/jq.js"></script>
</head>
<body>
<div style="width:100%;height:95px;border-bottom:solid 1px gray">
	${top_nav}<a href="/unlog">注销登录</a>
</div>
<div style="min-height:300px">

<div>
<script>
abc();
function getmsg()
{
	setTimeout("abc()",3000);
}
	
	function abc()
	{
		$.post("/getmsg",{},function(result){
			alert(result);
			getmsg();
		});
	}
	
</script> 
</div>
</div>
<div style="width:100%;height:30px;border-top:solid 1px gray">
	${bottom_nav}程序员在囧途
</div>
</body>
</html>