<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>
   ErrorCode <%=request.getAttribute("errorCode") %>
</h1>
<h1>
    ErrorMessage  <%=request.getAttribute("errorMessage") %>
</h1>
<form:form action="/user/menu" method="GET" >
    <input type="submit" value="menu">
</form:form>