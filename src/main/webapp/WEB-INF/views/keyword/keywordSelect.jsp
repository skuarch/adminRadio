<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select id="keyword" name="keyword"  class="form-control" multiple onchange="createKeywordModalWindow('modal', '<spring:message code="text53"/>')">
    <option value="0"><spring:message code="text52"/></option>
    <c:forEach begin="0" end="${jsonArrayKeywords.length() -1}" var="index">                                        
        <option value="${jsonArrayKeywords.getJSONObject(index).get("id")}">${jsonArrayKeywords.getJSONObject(index).get("name")}</option>                                
    </c:forEach>
</select>