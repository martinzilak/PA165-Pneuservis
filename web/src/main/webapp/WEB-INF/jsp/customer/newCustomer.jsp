<%--
  Author: Zuzana Žufanová, zufinka@mail.muni.cz
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:message var="title" key="newCustomer.title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <h1>New Customer</h1>
    <form:form method="get" action="${pageContext.request.contextPath}/customer/create">
        <input type="text" name="name" value="name">
        <input type="text" name="surname" value="surname">
        <input type="text" name="city" value="city">
        <input type="text" name="street" value="street">
        <input type="text" name="zipCode" value="zipCode">
        <input type="text" name="country" value="country">
        <input type="text" name="email" value="email">
        <input type="text" name="phoneNumber" value="phone number">
        <input type="submit" name="submit"><fmt:message key="newCustomer.submit"/></input>
    </form:form>

</jsp:attribute>
</my:pagetemplate>
