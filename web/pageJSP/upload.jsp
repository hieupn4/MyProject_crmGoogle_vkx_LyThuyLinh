<%-- 
    Document   : upload
    Created on : Jul 17, 2015, 8:08:37 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>File Upload:</h3>
Select a file to upload: <br />
<form action="../UploadServlet" method="post" enctype="multipart/form-data">
<input type="file" id="myFile" name="file" onchange="myFunction()"/>
<br />
<p id="demo"></p>
</form>
<%-- đoạn mã java script này để xác định chỉ cho phép những file exels mới được phép upload
 còn những file định dạng khác thì không được phép upload --%>
<script>
function getFileExtension(filename)
{
  var ext = /^.+\.([^.]+)$/.exec(filename);
  return ext == null ? "" : ext[1];
}
function myFunction(){
    var x = document.getElementById("myFile");
    var txt = "";
    var file = x.files[0];
    txt =txt + file.name;
    var fllow = getFileExtension(txt);
    if(fllow=="xlsx"||fllow=="xls")
        document.getElementById("demo").innerHTML = '<input type="submit" value="Upload File" /> <br>'+"mời bạn nhấn submit để upload file exel lên CSDL";
    else
        document.getElementById("demo").innerHTML = "định dạng file phải là exel,việc chọn các định dạng file khác là bất hợp pháp";
}
</script>
    </body>
</html>
