<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head />
    <body>
        <h1>Login page</h1>
        <form action="login" method="post">
            <label>Login:
                <input type="text" name="login" />
            </label>
            <input type="submit" value="Login" />
        </form>

        <p>Don't have an account? <a href="register">Register</a> </p>
    </body>
</html>