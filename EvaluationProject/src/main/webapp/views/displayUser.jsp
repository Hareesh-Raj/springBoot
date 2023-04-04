
<h1>
    <%=request.getAttribute("id") %>
</h1>
<h1>
    <%=request.getAttribute("username") %>
</h1>
<h1>
    <%=request.getAttribute("balance") %>
</h1>
<form:form action="/user/menu" method="GET" >
    <input type="submit" value="menu">
</form:form>