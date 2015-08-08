<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head />
<body>
<h2>User Manager</h2>
<form:form method="post" commandName="user" action="addUser">

    <table>
    <tr>
        <td><form:label path="login">Login</form:label></td>
        <td><form:input path="login" /></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add User"/>
        </td>
    </tr>
</table>    
    
</form:form>

<h3>Users:</h3>
<c:if  test="${!empty usersList}">
<table class="data">
<tr>
    <th>Login</th>
    <th>Email</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${usersList}" var="user">
    <tr>
        <td>${user.login}</td>
        <td>${user.email}</td>
        <td><a href="delete/${user.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>

