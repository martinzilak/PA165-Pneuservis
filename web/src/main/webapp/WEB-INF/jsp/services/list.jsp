<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:message var="title" key="service.title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <a class="btn btn-default" href="/pa165/services/create">
        <span class="glyphicon glyphicon-plus"
              aria-hidden="true"></span>
        Add New Service
    </a>
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Service Type</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${services}" var="service">
            <tr>
                <td><c:out value="${service.name}"/></td>
                <td><c:out value="${service.serviceType}"/></td>
                <td><c:out value="${service.id}"/></td>
                    <td><a class="btn btn-default" href="/pa165/order/list/${service.id}">
                        <span class="glyphicon glyphicon-plus"
                              aria-hidden="true"></span>
                        Buy
                        </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</jsp:attribute>
</my:pagetemplate>
