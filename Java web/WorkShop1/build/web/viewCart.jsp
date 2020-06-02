<%-- 
    Document   : viewCart
    Created on : Oct 21, 2017, 11:15:18 PM
    Author     : Ngo Nhat Do
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <font color="red">${sessionScope.USERNAME}'s cart include</font><br>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${not empty cart}">
            <c:set var="mobiles" value="${cart.mobiles}"/>
            <c:if test="${not empty mobiles}">
                <form action="removeMobileFromCart">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Mobile Name</th>
                                <th>Quantity</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="mobile" items="${mobiles}" varStatus="counter">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${mobile.key}
                                    </td>
                                    <td>
                                        ${mobile.value}
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkRemove" value="${mobile.key}" />
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td>
                                    <input type="submit" value="Remove" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <form action="buyMobile">
                    <input type="submit" value="Add more Items to your cart" name="btAction"/>
                    <input type="submit" value="Buy Mobile" name="btAction"/>
                </form>
            </c:if>
        </c:if>
        <c:if test="${empty cart}">
            <h2>No cart is exited</h2>
        </c:if>
    </body>
</html>
