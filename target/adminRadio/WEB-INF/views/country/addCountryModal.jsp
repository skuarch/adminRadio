<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<form id="addCountryForm" name="addCountryForm" action="return false;">
    <input type="text" id="countryName" name="countryName" autocomplete="off" placeholder="<spring:message code="text41"/>" class="form-control" autofocus/>
    <br/>
    <button class="btn btn-success btn-block" type="button" onclick="javascript:addCountryModalProcess('${modalId}', '<spring:message code="text43"/>')">
        <spring:message code="text72"/>
    </button>
</form>
