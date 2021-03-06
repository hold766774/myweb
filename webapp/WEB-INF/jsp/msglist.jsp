﻿<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:import url="/loadpage?type=top"/>
<style>

</style>
<script>
var userName='${CurrentUserName}';
	function setMsgState(sender,sendtime,msgcnt,aobj)
	{
		if(userName=="") return;
		$.post("/addmsg",{"sender":sender,"receiver":userName,"sendtime":sendtime,"msgcnt":msgcnt},function(result){
			if(result.toString()=="1"){
				//alert("ok");
				$(aobj).parent().parent().remove();
			}else{
				alert("error");
			}
		})
	}
</script>
<div class="container" style="margin:30px auto;">

    <div class="col-md-8 col-md-offset-2">
    	<table class="table table-hover">
    	<caption>我的未读消息 | <a href="/msglist2">我的已读消息</a></caption>
			<tr>
				<th>消息内容</th>
				<th>发送时间</th>
				<th>发送者</th>
				<th></th>
			</tr>
			<c:forEach items="${msgList }" var="msg">
			<tr>
				<td>${msg.split("_")[2]}</td>
				<td>${msg.split("_")[0]}</td>
				<td>${msg.split("_")[1]}</td>
				<td><a href="#" onclick="setMsgState('${msg.split("_")[1]}','${msg.split("_")[0]}','${msg.split("_")[2]}',this); return false;">设置为已读</a></td>
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