<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select id="genre" name="genre[]" class="form-control" multiple onchange="createGenreModalWindow('modal', '<spring:message code="text40"/>')">
    <option value="0"><spring:message code="text50"/></option>
    <c:forEach begin="0" end="${jsonArrayGenres.length() -1}" var="index">
        <option value="${jsonArrayGenres.getJSONObject(index).get("id")}">
            ${jsonArrayGenres.getJSONObject(index).get("name")}
        </option>                                
    </c:forEach>                                    
</select>                            