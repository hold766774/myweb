<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html> 
<html>
<head>
 <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/bootstrap.min.css" />
  <script src="/js/jq.js"></script>
  <script src="/js/bootstrap.min.js"></script>
 <style>
 .msg{background:url(/images/hd.png) no-repeat -8px center;}
 </style>
 
 </head>
 <body>
   <nav class="navbar navbar-inverse navbar-static-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">程序员在囧途</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
        <li><a href="#">新闻</a></li>
        <li><a href="#">观点</a></li>
         <li><a href="#">科技</a></li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="输入关键词">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${UserName ==null}">
      	 <li><a href="/login" target="black">登录</a></li>
         <li><a href="#">注册</a></li>
      </c:if>
         <c:if test="${UserName !=null}">
      	<li><a href="/msglist" id="msgAlert">欢迎您：${UserName }</a></li>
         <li><a href="/unlog">注销</a></li>
      </c:if>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
   

  
