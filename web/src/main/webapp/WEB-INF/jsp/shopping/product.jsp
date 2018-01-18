<%-- From seminars edited by Jakub Palenik --%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:message var="title" key="shopping.product.title"><fmt:param value="${product.name}"/></fmt:message>
<my:pagetemplate title="${title}">
    <jsp:attribute name="body">

        <div class="row">
            <div class="col-xs-8">
                <h3><c:out value="${product.name}"/></h3>
                <p align="justify"><c:out value="${product.description}"/></p>
                Current price: <span style="color: red; font-weight: bold;"><c:out value="${product.price}"/>&nbsp;<c:out value="e"/></span>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-12">
                <%--<div class="panel panel-default">--%>
                <%--<div class="panel-body">--%>
                <img class="img-responsive img-rounded"
                     src="${product.imageUrl}">
                <%--</div>--%>
                <%--</div>--%>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-6">
                <h4><c:out value="shopping.product.properties"/></h4>
                <p align="left"><c:out value="vehicle type: ${product.tireProperties.vehicleType}"/></p>
                <p align="left"><c:out value="width: ${product.tireProperties.width}"/></p>
                <p align="left"><c:out value="aspect ratio: ${product.tireProperties.aspectRatio}"/></p>
                <p align="left"><c:out value="diameter: ${product.tireProperties.diameter}"/></p>
                <p align="left"><c:out value="load index: ${product.tireProperties.loadIndex}"/></p>
                <p align="left"><c:out value="speed class: ${product.tireProperties.speedClass}"/></p>
                <p align="left"><c:out value="season: ${product.tireProperties.season}"/></p>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/shopping/product/${product.id}/buy" method="post">
            <p>
                <input class="btn btn-lg btn-success" role="button" type="submit" value="Buy" />
                quantity: <input type="number" name="quantity" min="1" max="${product.onStock}" width="50px" height="20px">
            </p>
        </form>


    </jsp:attribute>
</my:pagetemplate>