<%-- 
    Document   : searchByUSer
    Created on : Oct 23, 2017, 10:19:12 PM
    Author     : Ngo Nhat Do
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">
        Welcome <s:property value="%{#session.USERNAME}"/>
        </font>
        <h1>Search Page</h1>
        <s:form action="searchByUser">
            <s:textfield name="min" label="Min"/>
            <s:textfield name="max" label="Max"/>
            <s:submit value="Search"/>
        </s:form>
        <s:a href="viewCart">View Cart</s:a>
        <s:if test="%{!min.isEmpty()&& !max.isEmpty()}">
            <s:if test="%{listMobiles!=null}">
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
                        <s:iterator value="%{listMobiles}" status="counter">
                            <s:form action="addMobileToCart" theme="simple">
                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"/>
                                    </td>
                                    <td>
                                        <s:property value="mobileId"/>
                                    </td>
                                    <td>
                                        <s:property value="description"/>
                                    </td>
                                    <td>
                                        <s:property value="price"/>
                                    </td>
                                    <td>
                                        <s:property value="mobileName"/>
                                    </td>
                                    <td>
                                        <s:property value="yearOfProduction"/>
                                    </td>
                                    <td>
                                        <s:property value="quantity"/>
                                    </td>
                                    <td>
                                        <s:property value="notSale"/>
                                    </td>
                                    <td>
                                        <s:submit value="Add to Cart"/>
                                        <s:hidden name="mobileName" value="%{mobileName}"/>
                                        <s:hidden name="min" value="%{min}"/>
                                        <s:hidden name="max" value="%{max}"/>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:if test="%{listMobiles==null}">
                <h2>No record matched!!!</h2>
            </s:if>
        </s:if>
    </body>
</html>
