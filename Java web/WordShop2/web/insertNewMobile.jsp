<%-- 
    Document   : insertNewMobile
    Created on : Oct 24, 2017, 9:29:32 AM
    Author     : Ngo Nhat Do
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert</title>
        <s:head/>
    </head>
    <body>
        <font color="red">
        Welcome <s:property value="%{#session.USERNAME}"/>
        </font><br>
        <s:a href="try">Log out</s:a>
            <h1>Insert new mobile</h1>
        <s:form action="insertNewMobile">
            <s:textfield name="mobileId" label="Mobile Id*"/>
            <s:textfield name="description" label="Description*"/>
            <s:textfield name="price" label="Price"/>
            <s:textfield name="mobileName" label="Mobile Name*"/>
            <s:textfield name="yearOfProduction" label="Year Of Production"/>
            <s:textfield name="quantity" label="Quantity"/>
            <s:checkbox name="notSale" label="Not Sale"/>
            <s:submit value="Insert"/>
            <s:reset value="Reset"/>
        </s:form>
        <s:if test="%{exception.message.contains('duplicate')}">
            <font color="red">
            <s:property value="mobileId"/> is existed!!!
            </font>
        </s:if>
    </body>
</html>
