<%@ page import ="java.util.List"%>
<%@ page import ="com.model.dto.CustomerDto"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

<div class="container-fluid">
    <h1 style="text-align:center;">Checker Home Page</h1>
    <br><br>
    <div class="row">
        <div class="col-11">
            <h3>Welcome, ${checkerName}!!!</h3>
        </div>
        <div class="col-1">
            <a href="logout" style="text-align:right;margin-right:20px;"> <button
            class="btn btn-primary btn-sm">Logout</button></a>
        </div>
    </div>
</div>

<br>

<% List<CustomerDto> customers = (List) request.getAttribute("customersList"); %>

<table class="table-striped table-bordered table-hover" style="background-color:#ddd">
    <tr>
        <th>Id</th>
        <th>Code</th>
        <th>Name</th>
        <th>Address1</th>
        <th>Address2</th>
        <th>Pin code</th>
        <th>Contact Number</th>
        <th>Contact Person</th>
        <th>Email</th>
        <th>Status</th>
        <th>Flag</th>
        <th>Create Date</th>
        <th>Created By</th>
        <th>Modified Date</th>
        <th>Modified By</th>
        <th>Authorize Date</th>
        <th>Authorize By</th>
        <th>Update / Delete</th>
    </tr>
    <%for(CustomerDto customerTempDto : customers){

        out.println("<tr><td>" + customerTempDto.getCustomerId() + "</td>" +
                    "<td>" + customerTempDto.getCustomerCode() + "</td>" +
                    "<td>" + customerTempDto.getCustomerName() + "</td>" +
                    "<td>" + customerTempDto.getCustomerAddress1() + "</td>" +
                    "<td>" + customerTempDto.getCustomerAddress2() + "</td>" +
                    "<td>" + customerTempDto.getCustomerPinCode() + "</td>" +
                    "<td>" + customerTempDto.getContactNumber() + "</td>" +
                    "<td>" + customerTempDto.getContactPerson() + "</td>" +
                    "<td>" + customerTempDto.getEmailAddress() + "</td>" +
                    "<td>" + customerTempDto.getRecordStatus() + "</td>" +
                    "<td>" + customerTempDto.getFlag() + "</td>" +
                    "<td>" + customerTempDto.getCreateDate() + "</td>" +
                    "<td>" + customerTempDto.getCreatedBy() + "</td>" +
                    "<td>" + customerTempDto.getModifiedDate() + "</td>" +
                    "<td>" + customerTempDto.getModifiedBy() + "</td>" +
                    "<td>" + customerTempDto.getAuthorizeDate() + "</td>" +
                    "<td>" + customerTempDto.getAuthorizedBy() + "</td>" +
                    "<td>  <a href='approve?customerCode=" + customerTempDto
                    .getCustomerCode() + "&status=" + customerTempDto.getRecordStatus() +
                    "'><button type='button' class='btn btn-primary btn-sm'><i class='fa fa-check' "
                     + "aria-hidden='true'></i></button></a>  <a href='reject?customerCode=" +
                     customerTempDto.getCustomerCode() +  "&status=" + customerTempDto
                     .getRecordStatus() + "'><button type='button' class='btn btn-danger " +
                     "btn-sm'><i class='fa fa-times' aria-hidden='true'></i></button></a></td></tr>"
        );
    } %>
</table>

</body>
</html>