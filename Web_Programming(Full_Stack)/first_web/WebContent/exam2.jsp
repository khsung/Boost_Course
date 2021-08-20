<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	for(int i=5;i>=1;i--){		
%>
	<h<%=i %>>test</h<%=i %>>
<%
	}
%>

<%
	pageContext.setAttribute("p1", "page scope");
	request.setAttribute("r1", "request scop");
	session.setAttribute("s1","session");
	application.setAttribute("a1", "application");
	
	request.setAttribute("k", 10);
	request.setAttribute("m", true);
%>

<hr>
EL연습<br>
pageContext.getAttribute("p1")=<%=pageContext.getAttribute("p1") %><br>
pageContext.getAttribute("p1")=${pageScope.p1}<br>
request.getAttribute("r1")=<%=request.getAttribute("r1") %><br>
request.getAttribute("r1")=${requestScope.r1}<br>
session.getAttribute("s1")=<%=session.getAttribute("s1") %><br>
session.getAttribute("s1")=${sessionScope.s1}<br>
application.getAttribute("a1")=<%=application.getAttribute("a1") %><br>
application.getAttribute("a1")=${applicationScope.a1}<br>
<br><br><br>
k:${k}<br>
m:${m}<br>
k+5=${k+5}<br>
k*5=${k*5}<br>



</body>
</html>