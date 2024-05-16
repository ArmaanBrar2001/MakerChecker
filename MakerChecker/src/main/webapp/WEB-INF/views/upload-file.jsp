<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--meta name="_csrf" content="4bfd1575-3ad1-4d21-76yh-5ygfuyd9f86721"/>
    <meta name="_csrf_header" content="X-CSRF-TOKEN"/-->
    <title>upload File</title>
</head>
<body>

<form method="post" action="/FinalBrdPrj/upload?${_csrf.parameterName}=${_csrf.token}"
enctype="multipart/form-data">
    <input type="file" name="file" id="file-input">
    <button type="submit">Upload</button>
</form>

</body>
</html>