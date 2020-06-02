<%-- 
    Document   : insertNewMobile
    Created on : Oct 20, 2017, 10:09:26 PM
    Author     : Ngo Nhat Do
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert new mobile</title>
    </head>
    <body>
        <h1>Insert new mobile</h1>
        <form action="insertNewMobile" method="POST">
            <c:set var="error" value="${requestScope.INSERTERR}"/>
            Mobile Id* <input type="text" name="txtMobileId" value="${param.txtMobileId}" /> 2 - 10 chars<br>
            <c:if test="${not empty error.mobileIdLengthErr}">
                <font color="red">
                ${error.mobileIdLengthErr}
                </font><br>
            </c:if>
            Description* <input type="text" name="txtDescription" value="${param.txtDescription}" /><br>
            <c:if test="${not empty error.descriptionEmptyErr}">
                <font color="red">
                ${error.descriptionEmptyErr}
                </font><br>
            </c:if>
            Price <input type="text" name="txtPrice" value="${param.txtPrice}" /><br>
            <c:if test="${not empty error.priceFormatErr}">
                <font color="red">
                ${error.priceFormatErr}
                </font><br>
            </c:if>
            Mobile Name <input type="text" name="txtMobileName" value="${param.txtMobileName}" /> 2 - 20 chars<br>
            <c:if test="${not empty error.mobileNameLengthErr}">
                <font color="red">
                ${error.mobileNameLengthErr}
                </font><br>
            </c:if>
            Year Of Production <input type="text" name="txtYearOfProduction" value="${param.txtYearOfProduction}" /><br>
            <c:if test="${not empty error.yearOfProductionFormatErr}">
                <font color="red">
                ${error.yearOfProductionFormatErr}
                </font><br>
            </c:if>
            Quantity <input type="text" name="txtQuantity" value="${param.txtQuantity}" /><br>
            <c:if test="${not empty error.quantityFormatErr}">
                <font color="red">
                ${error.quantityFormatErr}
                </font><br>
            </c:if>
            Not Sale <input type="checkbox" name="chkNotSale" value="ON" /><br>
            <c:if test="${not empty error.mobileIdIsExited}">
                <font color="red">
                ${error.mobileIdIsExited}
                </font><br>
            </c:if>
            <input type="submit" value="Insert" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
