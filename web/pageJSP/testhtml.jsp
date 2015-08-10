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
        $('#anyDiv').change(function(){
          alert("hello world");
});

       </script>
    </head>
    <body>
    <input type="button" id="txtHint">
    <div id="anyDiv">
        <input type="text" value="hieu">
    </div>
    </body>
    </html>
