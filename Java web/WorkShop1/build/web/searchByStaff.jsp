<%-- 
    Document   : searchByStaff
    Created on : Oct 19, 2017, 4:18:12 PM
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
        <form action="searchByStaff">
            Search Value <input type="text" name="txtSearchValue" value="" /><br>
            Search by: Id <input type="radio" name="typeSearch" value="id" checked="checked" /> 
            Name <input type="radio" name="typeSearch" value="name" /><br>
            <input type="submit" value="Search"/>
        </form>
        <a href="insertNewMobile.html">Insert new mobile</a>

        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:set var="typeSearchValue" value="${param.typeSearch}"/>
        <c:if test="${not empty searchValue}">
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
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="updateMobile">
                            <tr>
                                <td>
                                    ${counter.count}
                                </td>
                                <td>
                                    ${dto.mobileId}
                                    <input type="hidden" name="txtUsername" value="${dto.mobileId}" />
                                </td>
                                <td>
                                    <input type="text" name="txtDescription" value="${dto.description}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPrice" value="${dto.price}" />
                                </td>
                                <td>
                                    ${dto.mobileName}
                                </td>
                                <td>
                                    ${dto.yearOfProduction}
                                </td>
                                <td>
                                    <input type="text" name="txtQuantity" value="${dto.quantity}" />
                                </td>
                                <td>
                                    <input type="checkbox" name="chkNotSale" value="ON" 
                                           <c:if test="${dto.notSale}">
                                               checked="checked"
                                           </c:if>
                                </td>
                                <td>
                                    <c:url var="urlRewriting" value="deleteMobile">
                                        <c:param name="pk" value="${dto.mobileId}"/>
                                        <c:param name="lastSearchValue" value="${searchValue}"/>
                                        <c:param name="lastTypeSearchValue" value="${typeSearchValue}"/>
                                    </c:url>
                                    <a href="${urlRewriting}">Delete</a>
                                </td>
                                <td>
                                    <input type="hidden" name="lastSearchValue" value="${searchValue}" />
                                    <input type="hidden" name="lastTypeSearchValue" value="${typeSearchValue}" />
                                    <input type="submit" value="Update" />
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
