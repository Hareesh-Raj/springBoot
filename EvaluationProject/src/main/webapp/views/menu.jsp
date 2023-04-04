<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/user/createForm" method="GET" >
    <input type="submit" value="createUser">
</form:form>
<form:form action="/user/get" method="GET" >
    <input type="submit" value="CheckBalance">
</form:form>
<form:form action="/user/moneytransfer" method="GET" >
    <input type="submit" value="Money Transfer">
</form:form>