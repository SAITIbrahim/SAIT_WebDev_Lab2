<%-- 
    Document   : agecalculator
    Created on : Jan 20, 2022, 3:40:00 PM
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
        
        <h1>Age Calculator</h1>
        <form method="post">
          <label for="age_inpt">Enter your age:</label>
          <input type="text" id="age_inpt" name="age_inpt"><br><br>
          <input type="submit" value="Age next birthday"></input>
        </form>
        
        <p>${message}</p>
        <a href="arithmetic">Arithmetic Calculator</a>
        
    </body>
</html>
