<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import ="java.util.List"%>
<%@ page import ="com.model.dto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>


    <script>
        function registerForm() {
            var x = document.getElementById("registration-form");
            if (x.style.display === "none") {
                x.style.display = "block";
            }
            else {
                x.style.display = "none";
            }
        }

        function newUpdateForm() {
                    var x = document.getElementById("new-update-form");
                    if (x.style.display === "none") {
                        x.style.display = "block";
                    }
                    else {
                        x.style.display = "none";
                    }
                }
    </script>

    <style>
        *{
            font: sans-serif;
        }

        .header {
            padding: 30px 0;
        }

        input{
            width:100%;
        }

        select#flag {
            width: 78%;
            height: 68%;
        }

        input[type="submit"] {
            width: 20%;
            padding: 5px 0;
            border-radius: 15px;
            border: 1px solid #333;
            background-color: #079999;
            color: #fff;
        }

        /* show error */
        .error{
            color: #fff;
            background-color: #ff0000;
            padding:6px;
            font-weight: bold;
        }

        #registration-form{
            display:none;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <h1 style="text-align:center;"><spring:message code="lbl.makerHome" text="Maker Home Page"
    /></h1>
    <br><br>
    <div class="row">
        <div class="col-6">
            <h3><spring:message code="lbl.homepageWelcome" text="Welcome" />, ${makerName}!!!</h3>
        </div>
        <div class="col-2">
            <a href="maker-index?language=en_us"><button class="btn btn-primary
            btn-sm">English</button></a>
            <a href="maker-index?language=zh_CN"><button class="btn btn-primary
            btn-sm">Chinese</button></a>
        </div>
        <div class="col-4">
            <a href="upload-file"><button class="btn btn-success btn-sm">Add Customers
            File</button></a>
            <button class="btn btn-success btn-sm" onclick="registerForm()" >Add
            Customer</button>
            <a href="logout" style="text-align:right;"> <button
            class="btn btn-primary btn-sm">Logout</button></a>
        </div>
    </div>
</div>

<section class="calculators" id="registration-form">
    <div class="container">
        <div class="jumbotron">
            <h2>Add Customer</h2>
            <div class="tab-content">
                <div class="tab-pane fade show active" id="homeLoan">
                    <div class="loanDetails">
                        <form:form action="registered" method="POST"
                        modelAttribute="customer">
                            <div class="text-center">
                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="customerCode">Enter Customer Code:
                                        </form:label></h5>
                                    </div>
                                    <div class="col-3">
                                        <form:input path="customerCode" maxlength="10" />
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="customerCode" cssClass="error" />
                                    </div>
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="customerName">Enter Customer Name:
                                        </h5>
                                        </form:label>
                                    </div>
                                    <div class="col-3">
                                        <form:input path="customerName" maxlength="30" />
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="customerName" cssClass="error" />
                                    </div>
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="customerAddress1">Enter Customer
                                        Address line1: </form:label></h5>
                                    </div>
                                    <div class="col-3">
                                        <form:input path="customerAddress1" maxlength="100" />
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="customerAddress1" cssClass="error" />
                                    </div>
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="customerAddress2">Enter Customer
                                        Address line2: </form:label></h5>
                                    </div>
                                    <div class="col-3">
                                        <form:input path="customerAddress2" maxlength="100" />
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="customerAddress2" cssClass="error" />
                                    </div>
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="customerPinCode">Enter Pin Code:
                                        </form:label></h5>
                                    </div>
                                    <div class="col-3">
                                        <form:input type="number" path="customerPinCode"
                                        maxlength="6" minlength="6" />
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="customerPinCode" cssClass="error" />
                                    </div>
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="emailAddress">Enter Email Address: </form:label></h5>
                                    </div>
                                    <div class="col-3">
                                        <form:input type="email" path="emailAddress" maxlength="100" />
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="emailAddress" cssClass="error" />
                                    </div>
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="contactNumber">Enter Contact Number:
                                        </form:label></h5>
                                    </div>
                                    <div class="col-3">
                                        <form:input path="contactNumber" maxlength="20" />
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="contactNumber" cssClass="error" />
                                    </div>
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="contactPerson">Enter Contact Person details: </form:label></h5>
                                    </div>
                                    <div class="col-3">
                                        <form:input path="contactPerson" maxlength="100" />
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="contactPerson" cssClass="error" required="required" />
                                    </div>
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="flag">Select Flag: </form:label></h5>
                                    </div>
                                    <div class="col-3">
                                        <form:select path="flag" required="required">
                                            <form:option value="A">Active</form:option>
                                            <form:option value="I">Inactive</form:option>
                                        </form:select>
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="flag" cssClass="error" />
                                    </div>
                                </div>

                                <br><br>

                                <div class="row">
                                    <div class="col-12" style="padding:5px 0 0 0;">
                                        <h5><input type="submit" value="Register" /></h5>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<br>

<% List<CustomerDto> customers = (List) request.getAttribute("customersList"); %>
<% List<CustomerDto> masterCustomers = (List) request.getAttribute("masterCustomersList"); %>


<table class="table-striped table-bordered table-hover" style="background-color:#ddd">
    <tr>
        <th><spring:message code="lbl.code" text="Code" /></th>
        <th><spring:message code="lbl.name" text="Name" /></th>
        <th><spring:message code="lbl.address1" text="Address1" /></th>
        <th><spring:message code="lbl.address2" text="Address2" /></th>
        <th><spring:message code="lbl.pin" text="Pin code" /></th>
        <th><spring:message code="lbl.contact" text="Contact Number" /></th>
        <th><spring:message code="lbl.contactPerson" text="Contact Person" /></th>
        <th><spring:message code="lbl.email" text="Email" /></th>
        <th><spring:message code="lbl.status" text="Status" /></th>
        <th><spring:message code="lbl.flag" text="Flag" /></th>
        <th><spring:message code="lbl.create" text="Create Date" /></th>
        <th><spring:message code="lbl.createdBy" text="Created By" /></th>
        <th><spring:message code="lbl.modifyDate" text="Modified Date" /></th>
        <th><spring:message code="lbl.modifiedBy" text="Modified By" /></th>
        <th><spring:message code="lbl.authorizeDate" text="Authorize Date" /></th>
        <th><spring:message code="lbl.authorizedBy" text="Authorize By" /></th>
        <th><spring:message code="lbl.update" text="Update" /> / <spring:message code="lbl.delete" text="Delete" /></th>
    </tr>
    <%for(CustomerDto customerTempDto : customers){

        out.println("<tr><td>" + customerTempDto.getCustomerCode() + "</td>" +
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
                    "<td> &nbsp; <a href='update?customerCode=" + customerTempDto.getCustomerCode()
                        + "&status=" + customerTempDto.getRecordStatus() + "'><button type='button' "
                        + "class='btn btn-primary btn-sm'><i class='fa " +
                        "fa-pencil-square-o' aria-hidden='true'></i></button></a> " +
                        " <a href='delete?customerCode=" + customerTempDto.getCustomerCode() +
                         "&status=" + customerTempDto.getRecordStatus() + "'><button type='button' "
                          + "class='btn btn-danger btn-sm'><i class='fa " +
                        "fa-trash-o' aria-hidden='true'></i></button></a></td></tr>"
        );
    }

    for(CustomerDto customerTempDto : masterCustomers){

        out.println("<tr><td>" + customerTempDto.getCustomerCode() + "</td>" +
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
                    "<td> &nbsp; <a href='update?customerCode=" + customerTempDto
                    .getCustomerCode() + "&status=" + customerTempDto.getRecordStatus() +
                    "'><button type='button' class='btn btn-primary btn-sm'><i class='fa " +
                    "fa-pencil-square-o' aria-hidden='true'></i></button></a> <a "
                    + "href='delete?customerCode=" + customerTempDto.getCustomerCode() +
                    "&status=" + customerTempDto.getRecordStatus() + "'><button type='button' " +
                    "class='btn btn-danger btn-sm'><i class='fa fa-trash-o' " +
                    "aria-hidden='true'></i></button></a></td></tr>"
        );
    }%>
</table>

</body>
</html>

<!--"<td><form method='post'>" +
                                   " &nbsp;<button type='submit' formaction='update/" + customerTempDto
                                   .getCustomerCode() + "' style='cursor:pointer;'><i class='fa fa-pencil-square-o' " +
                                   "aria-hidden='true' style='color:blue;font-size:15px;'></i></button> &nbsp;"
                                    + "<button type='submit' formaction='delete/" + customerTempDto
                                   .getCustomerCode() + "' style='cursor:pointer;'><i class='fa fa-trash-o' " +
                                   "aria-hidden='true' style='color:#ff0000;font-size:15px'></i></button>" +
                               "</form></td>"-->