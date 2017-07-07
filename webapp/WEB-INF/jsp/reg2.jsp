<!DOCTYPE html> 
<html>
<head>
 <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/bootstrap.min.css" />
  <script src="/js/jq.js"></script>
  <script src="/js/bootstrap.min.js"></script>
  <script src="/js/validate.js"></script>
  <style>
   label.valid {
  width: 24px;
  height: 24px;
  background: url(/images/valid.png) center center no-repeat;
  display: inline-block;
  text-indent: -9999px;
	}
	label.error {
	  font-weight: bold;
	  color: red;
	  padding: 2px 8px;
	  margin-top: 2px;
	}
  </style>
  <script>
  $(document).ready(function(){
	
	  var cnmsg = {  
			    required: "必选字段",   
			    remote: "请修正该字段",   
			    email: "请输入正确格式的电子邮件",   
			    url: "请输入合法的网址",  
			    date: "请输入合法的日期",   
			    dateISO: "请输入合法的日期 (ISO).",  
			    number: "请输入合法的数字",   
			    digits: "只能输入整数",   
			    creditcard: "请输入合法的信用卡号",   
			    equalTo: "请再次输入相同的值",   
			    accept: "请输入拥有合法后缀名的字符串",   
			    maxlength: jQuery.format("请输入一个长度最多是 {0} 的字符串"),   
			    minlength: jQuery.format("请输入一个长度最少是 {0} 的字符串"),   
			    rangelength: jQuery.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),   
			    range: jQuery.format("请输入一个介于 {0} 和 {1} 之间的值"),   
			    max: jQuery.format("请输入一个最大为 {0} 的值"),  
			    min: jQuery.format("请输入一个最小为 {0} 的值")
			};
			jQuery.extend(jQuery.validator.messages, cnmsg);
	  $('#regForm').validate(
	  {
	   rules: {
	     username: {
	       minlength: 2,
	       required: true
	     },
	     useremail: {
	       required: true,
	       email: true
	     },
	     userpwd: {
	       minlength: 6,
	       required: true
	     } 
	   },
	   highlight: function(element) {
	     $(element).closest('.control-group').removeClass('success').addClass('error');
	   },
	   success: function(element) {
	     element
	     .text('OK!').addClass('valid')
	     .closest('.control-group').removeClass('error').addClass('success');
	   }
	  });
	 });
  
  </script>
 </head>
 <body>
   
   <div class="container col-md-offset-3 col-md-8">
    
    <h4 class="col-md-offset-1 "  ><strong>用户注册(2)</strong><span style="color:red">${result }</span></h4>
    <form method="post" class="form-horizontal" action="reg" id="regForm">
	    <div class="form-group">
	    <label class="col-md-2 control-label">邮箱</label>
	    <div class="col-md-5">
	      <input type="text" class="form-control" id="useremail" name="useremail"
	         placeholder="请输入邮箱">
	    </div>
  		</div>
  		
	   <div class="form-group">
	    <label class="col-md-2 control-label">用户名</label>
	    <div class="col-md-4">
	      <input type="text" class="form-control" id="username" name="username"
	         placeholder="请输入用户名" value="">  
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
		      <input type="submit" class="form-control btn btn-success"    >
		    </div>
     </div>
   </form>
  </div>

  
</body>
</html>