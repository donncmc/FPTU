<%-- 
    Document   : search
    Created on : Oct 23, 2017, 10:17:50 PM
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
        </font><br>
        <s:a href="try">Log out</s:a>
            <h1>Search Page</h1>
        <s:form action="search">
            <s:textfield name="searchValue" label="Search Value"/>
            <s:radio label="Search by: " name="searchType" list="{'id','name'}" />
            <s:submit value="Search"/>
        </s:form>
        <s:a href="insert">Insert new mobile into DB</s:a>
        <s:if test="%{!searchValue.isEmpty()&& !searchType.isEmpty()}">
            <s:if test="%{listMobile!=null}">
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
                        <s:iterator value="listMobile" status="counter">
                            <s:form action="update" theme="simple">
                                <tr>
                                    <td>
                                        <s:property value="%{#counter.count}"/>
                                    </td>
                                    <td>
                                        <s:property value="mobileId"/>
                                        <s:hidden name="mobileId" value="%{mobileId}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="description" value="%{description}"/>
                                    </td>
                                    <td>
                                        <s:textfield name="price" value="%{price}"/>
                                    </td>
                                    <td>
                                        <s:property value="mobileName"/>
                                    </td>
                                    <td>
                                        <s:property value="yearOfProduction"/>
                                    </td>
                                    <td>
                                        <s:textfield name="quantity" value="%{quantity}"/>
                                    </td>
                                    <td>
                                        <s:checkbox name="isAdmin" value="%{notSale}"/>
                                    </td>
                                    <td>
                                        <s:url id="DelLink" action="delete">
                                            <s:param name="pk" value="mobileId"/>
                                            <s:param name="lastSearchValue" value="searchValue"/>
                                            <s:param name="lastSearchType" value="searchType"/>
                                        </s:url>
                                        <s:a href="%{DelLink}">Delete</s:a>
                                        </td>
                                        <td>
                                        <s:hidden name="lastSearchValue" value="%{searchValue}"/>
                                        <s:hidden name="lastSearchType" value="%{searchType}"/>
                                        <s:submit value="Update"/>
                                    </td>
                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>

            </s:if>
            <s:if test="%{listMobile==null}">
                <h2>No record matched!!!</h2>
            </s:if>
        </s:if>
    </body>
</html>
