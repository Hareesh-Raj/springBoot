<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>
   Account ID <%=request.getAttribute("id") %>
</h1>
<h1>
  UserName  <%=request.getAttribute("username") %>
</h1>
<h1>
   Account Balance <%=request.getAttribute("balance") %>
</h1>
<form:form action="/user/menu" method="GET" >
    <input type="submit" value="menu">
</form:form>