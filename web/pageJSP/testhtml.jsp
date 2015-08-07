<%-- 
    Document   : testhtml
    Created on : Aug 7, 2015, 3:35:11 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <title></title> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script>
        function processString(string)
        {       
            var x = string.split("*");
            alert(x[0]);
            return x;
        }
        var con = processString("minh khai,ha noi*dong da,ha noi*");
        alert(con[1]);
       </script>
    </head>
    <body>
    <input type="button" id="txtHint">
    </body>
    </html>
