<%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
 <title>File upload</title>
</head>

<body>
    <form:form action="/FinalBrdPrj/upload?${_csrf.parameterName}=${_csrf.token}"
    enctype="multipart/form-data" method="post" modelAttribute="fileDto">

        <form:input type="file"  path="myFile" />
        <form:input  path="fileName" />
        <br><br>
        <button type="submit">submit</button>
    </form:form>
            <br><br>
        <form action="/FinalBrdPrj/upload?${_csrf.parameterName}=${_csrf.token}"
        enctype="multipart/form-data" method="post" >

            <input type="file"  name="myFile" />
            <input  type="text" name="fileName" />
            <br><br>
            <button type="submit">submit</button>
        </form>

</body>
</html>