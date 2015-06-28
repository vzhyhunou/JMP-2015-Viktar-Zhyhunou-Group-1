<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head />
    <body>
        <h1>Registration</h1>
        <form action="register" method="post">
            <label>Login:
                <input type="text" name="login" />
            </label>
            <input type="submit" value="Register" />
        </form>

        <p>Already have an account? <a href="<%=request.getContextPath()%>/">Login here</a></p>
    </body>
</html>