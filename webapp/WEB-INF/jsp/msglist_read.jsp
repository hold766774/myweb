<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:import url="/loadpage?type=top"/>
<style>

</style>

<div class="container" style="margin:30px auto;">

    <div class="col-md-8 col-md-offset-2">
    	<table class="table table-hover">
    	<caption><a href="/msglist">我的未读消息</a> | 我的已读消息</caption>
			<tr>
				<th>消息内容</th>
				<th>发送时间</th>
				<th>发送者</th>
				
			</tr>
			<c:forEach items="${msglist }" var="msg">
			<tr>
				<td>${msg.msgcnt}</td>
				<td>${msg.sendtime}</td>
				<td>${msg.sender}</td>
				
			</tr>
			</c:forEach>
		</table>
    </div>
    <div class="col-md-8 col-md-offset-2">
    	 <c:import url="/pagination">
			 <c:param name="sum"  value="${sum }"></c:param>
			 <c:param name="cp"  value="${page}"></c:param>
			 <c:param name="max"  value="10"></c:param>
			 <c:param name="size"  value="10"></c:param>
			  <c:param name="url"  value="/msglist"></c:param>	
		</c:import>
    </div>
</div>

<c:import url="/loadpage?type=bottom"/>