<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>File View!</h2>
fileUpload:
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" value="browse" name="file"><br><br>
    <input type="submit" value="submit">
</form>

<br><br>
fileUploadJersey:
<form action="/fileUploadJersey" method="post" enctype="multipart/form-data">
    <input type="file" value="browse" name="file"><br><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
