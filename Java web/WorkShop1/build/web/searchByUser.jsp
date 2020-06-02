<%-- 
    Document   : searchByUser
    Created on : Oct 19, 2017, 4:17:50 PM
    Author     : Ngo Nhat Do
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USERNAME}
        </font>
        <form action="logout">
            <input type="submit" value="Log out" />
        </form>
        <h1>Search Page</h1>
        <form action="searchByUser">
            Search device with price in range<br>
            Min <input type="text" name="txtMinPrice" value="" />
            Max <input type="text" name="txtMaxPrice" value="" /><br>
            <input type="submit" value="Search" />
        </form>
        <form action="viewCart">
            <input type="submit" value="View Cart" />
        </form>
        <c:set var="min" value="${param.txtMinPrice}"/>
        <c:set var="max" value="${param.txtMaxPrice}"/>
        <c:if test="${not empty min and not empty max}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Mobile Id</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Mobile name</th>
                            <th>Year Of Production</th>
                            <th>Quantity</th>
                            <th>Not Sale</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="addMobileToCart">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.mobileId}
                                </td>
                                <td>
                                    ${dto.description}
                                </td>
                                <td>
                                    ${dto.price}
                                </td>
                                <td>
                                    ${dto.mobileName}
                                </td>
                                <td>
                                    ${dto.yearOfProduction}
                                </td>
                                <td>
                                    ${dto.quantity}
                                </td>
                                <td>
                                    ${dto.notSale}
                                </td>
                                <td>
                                    <input type="hidden" name="txtMinPrice" value="${min}" />
                                    <input type="hidden" name="txtMaxPrice" value="${max}" />
                                    <input type="hidden" name="txtMobileID" value="${dto.mobileId}" />
                                    <input type="hidden" name="txtMobileName" value="${dto.mobileName}" />
                                    <input type="hidden" name="txtPrice" value="${dto.price}" />
                                    <input type="submit" value="Add to cart" />
                                </td>
                            </tr>
                        </form>

                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty result}">
            <h2>No record matched!!!</h2>
        </c:if>
    </c:if>
</body>
</html>
