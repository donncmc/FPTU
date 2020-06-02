<%-- 
    Document   : viewCart
    Created on : Oct 25, 2017, 11:31:54 PM
    Author     : Ngo Nhat Do
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <font color="red">
        Welcome <s:property value="%{#session.USERNAME}"/>
        </font><br>
        <s:set var="cart" value="%{#session.LISTMOBILES}"/>
        <s:if test="%{#cart!=null}">
            <s:set var="mobiles" value="%{#cart.mobiles}"/>
            <s:if test="%{#mobiles!=null}">
                <s:form action="removeMobileFromCart" theme="simple">
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
                            <s:iterator value="%{mobiles}" status="counter">
                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"/>
                                    </td>
                                    <td>
                                        <s:property value="%{key}"/>
                                    </td>
                                    <td>
                                        <s:property value="%{value}"/>
                                    </td>
                                    <td>
                                        <s:checkbox name="pk" fieldValue="%{key}"/>
                                    </td>
                                </tr>
                            </s:iterator>
                            <tr>
                                <td>
                                    <s:submit value="Remove"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </s:form>
                <s:form action="buyMoile">
                    <s:submit value="Buy"/>
                </s:form>
            </s:if>
        </s:if>
        <s:if test="%{#mobiles==null}">
            <h2>Cart empty!!!</h2>
        </s:if>
        <s:a href="buyMoreMobiles">Buy more mobiles</s:a>
    </body>
</html>
