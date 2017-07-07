<!DOCTYPE html> 
<html>
<head>
  
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/bootstrap.min.css" />
  <script src="/js/jq.js"></script>
  <script src="/js/bootstrap.min.js"></script>
 </head>
 <body>
   

   <div class="container col-md-offset-3 col-md-8">
    <h4 class="col-md-offset-1 "  ><strong>用户注册</strong></h4>
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
		      <input type="submit" class="form-control btn btn-success"  >
		    </div>
     </div>
   </form>
  </div>

  
</body>
</html>