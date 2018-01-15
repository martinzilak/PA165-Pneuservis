
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"
         session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:setBundle basename="Texts"/>
<fmt:message var="title" key="newCustomer.title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/customer/create"
               modelAttribute="customerCreate">
        <div class="form-group ${name_error ? 'has-error' : ''}">
            <form:label path="name"><fmt:message key="customer.name" /></form:label>
            <div class="col-sm-10">
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name"/>
            </div>
        </div>
        <div class="form-group ${surname_error ? 'has-error' : ''}">
            <form:label path="surname"><fmt:message key="customer.surname" /></form:label>
            <div class="col-sm-10">
                <form:input path="surname" cssClass="form-control"/>
                <form:errors path="surname"/>
            </div>
        </div>
        <div class="form-group ${street_error ? 'has-error' : ''}">
            <form:label path="street"><fmt:message key="customer.street" /></form:label>
            <div class="col-sm-10">
                <form:input path="street" cssClass="form-control"/>
                <form:errors path="street"/>
            </div>
        </div>
        <div class="form-group ${city_error ? 'has-error' : ''}">
            <form:label path="city"><fmt:message key="customer.city" /></form:label>
            <div class="col-sm-10">
                <form:input path="city" cssClass="form-control"/>
                <form:errors path="city"/>
            </div>
        </div>
        <div class="form-group ${zipCode_error ? 'has-error' : ''}">
            <form:label path="zipCode"><fmt:message key="customer.zipCode" /></form:label>
            <div class="col-sm-10">
                <form:input path="zipCode" cssClass="form-control"/>
                <form:errors path="zipCode"/>
            </div>
        </div>
        <div class="form-group ${country_error ? 'has-error' : ''}">
            <form:label path="country"><fmt:message key="customer.country" /></form:label>
            <div class="col-sm-10">
                <form:input path="country" cssClass="form-control"/>
                <form:errors path="country"/>
            </div>
        </div>
        <div class="form-group ${email_error ? 'has-error' : ''}">
            <form:label path="email"><fmt:message key="customer.email" /></form:label>
            <div class="col-sm-10">
                <form:input path="email" cssClass="form-control"/>
                <form:errors path="email"/>
            </div>
        </div>
        <div class="form-group ${phoneNumber_error ? 'has-error' : ''}">
            <form:label path="phoneNumber"><fmt:message key="customer.phone" /></form:label>
            <div class="col-sm-10">
                <form:input path="phoneNumber" cssClass="form-control"/>
                <form:errors path="phoneNumber"/>
            </div>
        </div>
        <button class="btn btn-primary" type="submit"><fmt:message key="newCustomer.submit" /></button>
    </form:form>
</jsp:attribute>
</my:pagetemplate>