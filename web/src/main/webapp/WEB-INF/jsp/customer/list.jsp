
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:setBundle basename="Texts"/>
<fmt:message var="title" key="customer.list.title"/>
<fmt:message var="buttonCreate" key="customer.button.create"/>

<my:pagetemplate title="${title}">
<jsp:attribute name="body">

    <table class="table">
        <thead>
        <tr>
            <th><fmt:message key="customer.name"/></th>
            <th><fmt:message key="customer.address"/></th>
            <th><fmt:message key="customer.email"/></th>
            <th><fmt:message key="customer.phone"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><c:out value="${customer.getName()} ${customer.getSurname()}"/> </td>
                    <td><c:out value="${customer.getStreet()} ${customer.getCity()} ${customer.getZipCode()}
                        ${customer.getCountry()}"/></td>
                    <td><c:out value="${customer.getEmail()}"/></td>
                    <td><c:out value="${customer.getPhoneNumber()}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a class="btn btn-default" href="/pa165/customer/create">
        <span class="glyphicon glyphicon-plus"
              aria-hidden="true"></span>
            ${buttonCreate}
    </a>

</jsp:attribute>
</my:pagetemplate>
