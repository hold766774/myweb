hello
<%
String get_hello=request.getAttribute("hello").toString();
response.getWriter().write(get_hello);
%>
${hello}