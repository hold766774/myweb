<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:import url="/loadpage?type=top"/>
<link rel="stylesheet"  href="/css/bootstrap.min.css" />
<style>
#logintb td{text-align:center}
</style>
<p style="color:red;text-align:center">${result }</p>


<form method="post" action="login" id="loginfrm">
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>用户登录</h4>
            <input type="text" name="username" id="userName" class="form-control input-sm chat-input" placeholder="用户名" />
            </br>
            <input type="password" name="userpwd" id="userPassword" class="form-control input-sm chat-input" placeholder="密码" />
            </br>
            <div class="wrapper">
            <span class="group-btn">     
                
                <button type="submit" class="btn btn-primary btn-md">登录</button>
            </span>
            </div>
            </div>
        
        </div>
    </div>
</div>
</form>
<c:import url="/loadpage?type=bottom"/>