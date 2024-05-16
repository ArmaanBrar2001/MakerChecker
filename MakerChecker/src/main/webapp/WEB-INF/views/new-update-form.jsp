<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page isELIgnored="false"%>
<%@ page import="com.model.dto.CustomerDto" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
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
            width: 100%;
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
    </style>

</head>
<body>

<% CustomerDto customerTemp = (CustomerDto) request.getAttribute("customer12"); %>

<section class="header">
    <div class="container">
        <h2>Add Customer</h2>
    </div>
</section>

<section class="calculators">
    <div class="container">
        <div class="jumbotron">
            <div class="tab-content">
                <div class="tab-pane fade show active" id="homeLoan">
                    <div class="loanDetails">
                        <form:form action="updated" method="POST" modelAttribute="customer12">
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
                                        <form:errors path="contactPerson" cssClass="error" />
                                    </div>
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col-4" style="padding:5px 0 0 0; text-align:right;">
                                        <h5><form:label path="flag">Select Flag: </form:label></h5>
                                    </div>
                                    <div class="col-3">
                                        <form:select path="flag">
                                            <form:option value="A">Active</form:option>
                                            <form:option value="I">Inactive</form:option>
                                        </form:select>
                                    </span>
                                    </div>
                                    <div class="col-5">
                                        <form:errors path="flag" cssClass="error" />
                                    </div>
                                </div>

                                <form:hidden path="createdBy" maxlength="10" />
                                <form:hidden path="createDate" />
                                <form:hidden path="recordStatus" maxlength="10" />

                                <br><br>

                                <div class="row">
                                    <div class="col-12" style="padding:5px 0 0 0;">
                                        <h5><input type="submit" value="Update" /></h5>
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

