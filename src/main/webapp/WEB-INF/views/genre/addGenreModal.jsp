<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<form id="addGenreForm" name="addGenreForm" action="" method="post">
    <label><spring:message code="text74"/></label>
    <input type="text" id="genreNameEnglish" name="genreNameEnglish" autocomplete="off" placeholder="<spring:message code="text41"/>" class="form-control" autofocus/>
    <br/>
    <label><spring:message code="text75"/></label>
    <input type="text" id="genreNameSpanish" name="genreNameSpanish" autocomplete="off" placeholder="<spring:message code="text73"/>" class="form-control" autofocus/>
    <br/>
    <button class="btn btn-success btn-block" type="button" onclick="javascript:addGenreModalProcess('${modalId}', '<spring:message code="text43"/>')">
        <spring:message code="text42"/>
    </button>
</form>
