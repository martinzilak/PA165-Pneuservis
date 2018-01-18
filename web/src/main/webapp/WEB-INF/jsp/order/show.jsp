<%--
  Created by IntelliJ IDEA.
  User: 433372@mail.muni.cz
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:message var="title" key="order.show.title"/>
<my:pagetemplate title="${title} + ${order.id}">
<jsp:attribute name="body">

    <c:forEach items="${order.orderItems}" var="orderItem" varStatus="ic">
        <div class="row">

        </div>
    </c:forEach>

    <table class="table">
        <thead>
        <tr>
            <th><fmt:message key="order.item"/></th>
            <th><fmt:message key="order.quantity"/></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${order.orderItems}" var="orderItem" varStatus="ic">
                <tr>
                    <c:choose>
                        <c:when test="${empty orderItem.tire}">
                            <td><c:out value="${orderItem.service.name}"/></td>
                        </c:when>
                        <c:otherwise>
                            <td><c:out value="${orderItem.tire.name}"/></td>
                        </c:otherwise>
                    </c:choose>
                    <td><c:out value="${orderItem.quantity}"/></td>
                    <%--show quantity * saved price, save it to total price--%>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <%--show total price--%>

</jsp:attribute>
</my:pagetemplate>