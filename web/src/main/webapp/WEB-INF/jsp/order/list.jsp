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

<fmt:message var="title" key="order.list.title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">

    <%--order.date, order.id, order.customer.name, order.customer.surname, order.getPrice()--%>
    <table class="table">
        <thead>
            <tr>
                <th><fmt:message key="order.date"/></th>
                <th><fmt:message key="order.id"/></th>
                <th><fmt:message key="order.customer"/></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td><c:out value="${order.date.toString()}"/></td>
                    <td><a href="${pageContext.request.contextPath}/order/${order.id}"><c:out value="Order #${order.id}"/></a></td>
                    <td><c:out value="${order.customer.name} ${order.customer.surname}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>