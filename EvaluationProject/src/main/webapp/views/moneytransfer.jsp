<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/user/transfer" method="POST" modelAttribute="data">
	CreditID:<form:input path="crid"/><br>
	DebitID:<form:input path="dbid"/><br>
	AMOUNT:<form:input path="amount"/><br>
	
	<input type="submit" value="click...">
	
</form:form>
