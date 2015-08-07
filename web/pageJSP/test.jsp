<%-- 
    Document   : index
    Created on : Jul 17, 2015, 11:53:42 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title></title>  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>
    $('button').click(function(){
    $("#txtHint").val("hi")
    $("#txtHint").change(); //or $("#address").trigger("change");
  });
  $("#txtHint").change(function(){
    alert("The text has been changed.");
  });
   </script>
   <script>
       function show()
       {
           alert("hello");
       }
       function thaydoi()
       {
           document.getElementById("txtHint").value =" hello world";
       }
       
   </script>
</head>
<body style="height: 437px; width: 663px"  onload="chance()">
    <input type="text" id="txtHint" value="" onchange="show()"  >
<input type="button" value="click here" onclick="thaydoi()">


</body>
</html>

