<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<p>当前用户列表：</p>
<div>
<c:forEach items="${getUsers }" var="user">
${user.getUsername()} <br/>
</c:forEach>
${userpwd}