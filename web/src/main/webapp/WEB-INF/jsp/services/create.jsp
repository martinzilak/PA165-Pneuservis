<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true"
         session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:setBundle basename="Texts"/>
<my:pagetemplate>
<jsp:attribute name="body">
    <form:form method="post" action="${pageContext.request.contextPath}/services/create"
               modelAttribute="serviceCreate">
        <div class="form-group ${name_error ? 'has-error' : ''}">
            <form:label path="name">Name</form:label>
            
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name"/>
        </div>
        <div class="form-group ${serviceType_error ? 'has-error' : ''}">
            <form:label path="serviceType">Service Type</form:label>
                <form:select path="serviceType" cssClass="form-control">                   
                    <form:option value="TIRECHANGE">Tire change</form:option>
                    <form:option value="BRAKECALIBRATION">Brake calibration</form:option>
                    <form:option value="CLEANING">Cleaning</form:option> 
                    <form:option value="CONVERGANCECHECK">Convergance check</form:option> 
                    <form:option value="OILCHANGE">Oil change</form:option> 
                    <form:option value="MUFFLERREPAIR">Muffler repair</form:option> 
                    <form:option value="EXHAUSTSYSTEMREPAIR">Exhaust system repair</form:option> 
               </form:select>
        </div>
        <div class="form-group ${price_error ? 'has-error' : ''}">
            <form:label path="price">Price</form:label>
                <form:input path="price" cssClass="form-control"/>
                <form:errors path="price"/>
        </div>
        <button class="btn btn-primary" type="submit">Create</button>
    </form:form>
</jsp:attribute>
</my:pagetemplate>
