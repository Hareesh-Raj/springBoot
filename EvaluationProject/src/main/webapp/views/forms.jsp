<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/user/create" method="POST" modelAttribute="user">
	UserID:<form:input path="id"/><br>
	UserName:<form:input path="name"/><br>
	UserBalance:<form:input path="balance"/><br>
	
	<input type="submit" value="click...">
	
</form:form>
