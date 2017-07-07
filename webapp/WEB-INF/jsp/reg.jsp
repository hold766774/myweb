<!DOCTYPE html> 
<html>
<head>
  
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/bootstrap.min.css" />
  <script src="/js/jq.js"></script>
  <script src="/js/bootstrap.min.js"></script>
 </head>
 <body>
   <script>
   function trim(str)
   {
	   return str.replace(/(^\s+)|(\s+$)/g,"");
   }
   function checkFrm()
   {
	   //$("#useremail,#username,#userpwd").css("border","1px solid #ccc");
	   $('.form-control').removeAttr("style");
	   if(trim($("#useremail").val())=="")
		   {
		  
			   $("#useremail").css("border","solid 1px red");
			   return false;
		   }
	   if(trim($("#username").val())=="")
	   {
	  
		   $("#username").css("border","solid 1px red");
		   return false;
	   }
	   if(trim($("#userpwd").val())=="")
	   {
	  
		   $("#userpwd").css("border","solid 1px red");
		   return false;
	   }
	   return false;
	   //return true;
   }
   </script>

   <div class="container col-md-offset-3 col-md-8">
   <p style="color:red;text-align:center" >${result }</p>
    <h4 class="col-md-offset-1 " ><strong>用户注册</strong></h4>
    <form method="post" class="form-horizontal" action="reg"  >
	    <div class="form-group">
	    <label class="col-md-2 control-label">邮箱</label>
	    <div class="col-md-5">
	      <input type="text" class="form-control" id="useremail" name="useremail"
	         placeholder="请输入邮箱">
	    </div>
  		</div>
  		
	   <div class="form-group">
	    <label class="col-md-2 control-label">用户名</label>
	    <div class="col-md-5">
	      <input type="text" class="form-control" id="username" name="username"
	         placeholder="请输入用户名">
	    </div>
  		</div>
  		
		  <div class="form-group">
		    <label for="inputPassword" class="col-md-2 control-label">密码</label>
		    <div class="col-md-5">
		      <input type="password" class="form-control" name="userpwd" id="userpwd" 
		         placeholder="请输入密码">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword" class="col-md-2 control-label">性别</label>
		    
			    <div class="col-md-5">
			  <label class="radio-inline">
			  <input type="radio" name="sex" value="1" checked> 男
			  </label>
			    <label class="radio-inline">
			  <input type="radio" name="sex" value="0"> 女
			  </label>
			 </div>
		  </div>
     <div class="form-group">
      <label for="inputPassword" class="col-md-2 control-label"></label>
		    <div class="col-md-5">
		      <input type="submit" onclick="return checkFrm()" class="form-control btn btn-success"  >
		    </div>
     </div>
   </form>
  </div>

  
</body>
</html>