﻿<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:import url="/loadpage?type=top"/>

<div class="container" style="margin:30px auto">
	<div class="col-md-9">
	<c:forEach items="${newslist }" var="news">
		<div class="panel panel-default">
			  <div class="panel-heading">
			    <h3 class="panel-title"><a href="/newsdetail?newsid=${news.getId() }">${news.getNews_title() }</a></h3>
			  </div>
			  <div class="panel-body">
			  	${news.getNews_content() }
			  </div>
			  <div class="panel-footer">发布 ${news.getPubtime() } 作者 ${news.getPubuser() }  阅读 ${news.getClicknum() }</div>
		</div>
		</c:forEach>
		  <c:import url="/pagination">
			 <c:param name="sum"  value="${sum }"></c:param>
			 <c:param name="cp"  value="${page}"></c:param>
			 <c:param name="max"  value="10"></c:param>
			 <c:param name="size"  value="${size }"></c:param>
			  <c:param name="url"  value="/newslist"></c:param>	
		</c:import>
	</div>
	<div class="col-md-3">
		<div class="list-group">
			  <a href="#" class="list-group-item disabled">
			    	最热新闻
			  </a>
			  <a href="#" class="list-group-item">最热新闻一</a>
			  <a href="#" class="list-group-item">Morbi leo risus</a>
			  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
			  <a href="#" class="list-group-item">Vestibulum at eros</a>
		</div>
	</div>
</div>

<c:import url="/loadpage?type=bottom"/>
