<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<form id="addKeywordForm" name="addKeywordForm" action="return false;">
    <input type="text" id="keywordName" name="keywordName" autocomplete="off" placeholder="<spring:message code="text54"/>" class="form-control" autofocus/>
    <br/>
    <button class="btn btn-success btn-block" type="button" onclick="javascript:addKeywordModalProcess('${modalId}', '<spring:message code="text55"/>')">
        <spring:message code="text56"/>
    </button>
</form>
