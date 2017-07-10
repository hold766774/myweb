<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:import url="/loadpage?type=top"/>
<style>

</style>

<div class="container" style="margin:30px auto;min-height:500px">
    <div class="col-md-8 col-md-offset-3">
    	<div class="col-md-2">
    		请填写接受者
    	</div>
	    <div class="col-md-5">
	    	<input type="text" class="form-control" id="username" placeholder="输入接受者用户名"/>
	    </div>
    </div>
    <div class="col-md-8 col-md-offset-3" style="margin-top:20px;">
    	<div class="col-md-2">
    		输入消息内容
    	</div>
	    <div class="col-md-5">
	    	<textarea id="msgcontent" style="height:200px" class="form-control" placeholder="内容不要超过200字"></textarea>
	    </div>
    </div>
     <div class="col-md-8 col-md-offset-3" style="margin-top:20px;">
    	<div class="col-md-4 col-md-offset-2">
    		<button class="col-md-12  btn btn-info" id="sendBtn">发送</button>
    	</div>
	  <script>
	
	  	$("#sendBtn").click(function(){
	  		var getUserName=$("#username").val();
	  		var getMsgContent=$("#msgcontent").val();
	  		if(getUserName.replace(/(^\s+)|(\s+$)/g,"")==""||getMsgContent.replace(/(^\s+)|(\s+$)/g,"")=="")
	  			{
	  				alert("接收者和消息内容不能为空");
	  			}else{
	  				$.post("/sendmsg",{"UserName":getUserName,"MsgContent":getMsgContent},function(result){
	  					if(result=="0")
	  						{
	  							alert("请登录后发送消息");
	  						}else
	  							{
	  							alert("发送成功");
	  							}
	  				});
	  			}
	  	})
	  </script>
    </div>
</div>

<c:import url="/loadpage?type=bottom"/>