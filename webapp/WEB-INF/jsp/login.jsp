<style>
#logintb td{text-align:center}
</style>
<p style="color:red;text-align:center">${result }</p>
<form method="post" action="login" id="loginfrm">
<table style="width:600px;margin:0 auto;" id="logintb">
	<tr>
		<td colspan="2">用户登录</td>
	</tr>
	<tr>
		<td style="width:30%; text-align:right">用户名：</td>
		<td style="width:70%; text-align:left">
			<input type="text" name="username"/>
		</td>
	</tr>
	<tr>
		<td style="width:30%; text-align:right">密码：</td>
		<td style="width:70%; text-align:left">
			<input type="password" name="userpsw"/>
		</td>
	</tr>
	<tr>
		
		<td colspan="2">
			<input type="submit" value="登录"/>
		</td>
	</tr>
</table>
</form>