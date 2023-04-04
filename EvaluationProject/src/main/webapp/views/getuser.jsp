<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/user/get" method="POST" modelAttribute="data">
    UserID:<form:input path="crid"/><br>
	<input type="submit" value="click...">
	
</form:form>