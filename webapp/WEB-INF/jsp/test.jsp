<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<link rel="stylesheet"  href="/css/bootstrap.min.css" />
<p>当前用户列表：</p>
<div>
<c:forEach items="${getUsers }" var="user">
${user.getUsername()} <br/>
</c:forEach>
${userpwd}
<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">File input</label>
    <input type="file" id="exampleInputFile">
    <p class="help-block">Example block-level help text here.</p>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>