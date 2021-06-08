<%@ page isELIgnored="false"%>
<%if(request.getAttribute("bookName")!=null) {%>
<h2>${requestScope.bookName}</h2>
<%} else {%>
  <h1 sytle="color:red;text-align:center">Internal Problem -Try Again</h1>
<br>
<%} %>
<a href="form.html">home</a>