<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
  
    <title>myweb首页</title>
	<meta name="keywords" content="keywords" />
	<meta name="description" content="description" />
	
</head>
<body>
<div style="width:100%;height:95px;border-bottom:solid 1px gray">
	${top_nav}
</div>
<div style="min-height:300px">

${content}
<div>
${userbean.username }
</div>
<div>
<c:forEach items="${newsList }" var="news">
<a href="#">${news.getNewstitle()}--${news.newstitle}</a> <br/>
</c:forEach>
</div>
<div>
<c:forEach items="${the_news }" var="newstitle">
<a href="#">${newstitle}</a> <br/>
</c:forEach>
<hr>
<c:forEach items="${the_news2 }" var="news">
<a href="#">${news["newstitle"]}</a> <br/>
</c:forEach>

<p>当前用户列表：</p>
<div>
<c:forEach items="${userlist }" var="user">
${user["username"]} <br/>
</c:forEach>
</div>
</div>
${pagebar }
</div>
<div style="width:100%;height:30px;border-top:solid 1px gray">
	${bottom_nav}程序员在囧途
</div>
</body>
</html>