<%-- 
    Document   : arithmeticcalculatorservlet
    Created on : Jan 20, 2022, 4:40:32 PM
    Author     : Ibrahim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Arithmetic Calculator</h1>
        
        <form method="post">
            
            <label for="user_first_input">First</label>
            <input type="number" id="user_first_input" name="user_first_input"/>
            <br>
            
            <label for="user_second_input">Second</label>
            <input type="number" id="user_second_input" name="user_second_input"/>
            <br>
            
            <input type="submit" name="operator" value="+"/>
            <input type="submit" name="operator" value="-"/>
            <input type="submit" name="operator" value="*"/>
            <input type="submit" name="operator" value="%"/>
            <br>

        </form>

        <p>Result: ${message}</p>
        <a href="age">Age Calculator</a>
        
    </body>
</html>
