<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie6"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie7"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class=""><!--<![endif]-->
    <head>
        <title><spring:message code="text1" /></title>
        <jsp:include page="head.jsp" />
    </head>
    <body>
        <spring:htmlEscape defaultHtmlEscape="false" />
        <div class="container" id="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <spring:message code="text2"/>
                            </h3>
                        </div>
                        <div class="panel-body" id="mainForm">
                            <div id="message" class="alert alert-danger display-none"></div>
                            <form role="form" method="post" id="loginForm" action="/login">
                                <fieldset>
                                    <div class="form-group">
                                        <label><spring:message code="text3" /></label>
                                        <input class="form-control"
                                               placeholder="<spring:message code="text3"/>" id="email"
                                               name="email" type="email" autofocus required="required">
                                    </div>
                                    <div class="form-group">
                                        <label><spring:message code="text4" /></label>
                                        <input class="form-control"
                                               placeholder="<spring:message code="text4"/>" id="password"
                                               name="password" type="password" value="" required="required">
                                    </div>								
                                    <button id="loginButton"
                                            class="btn btn-lg btn-success btn-block" type="submit">
                                        <spring:message code="text6" />
                                    </button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                    <div id="languagues" class="panel">
                        <div class="panel-body text-center">
                            <a href="<c:url value="/login?lang=es"/>"> <spring:message code="text7"/>
                            </a> | <a href="<c:url value="/login?lang=en"/>"> <spring:message code="text8" />
                            </a> <br />
                            <div class="small">
                                <spring:message code="text9" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/scriptI18N"/>" type="text/javascript"></script>
        <jsp:include page="scripts.jsp" />
        <script src="<c:url value="/resources/js/md5.js"/>" type="text/javascript"></script>
    </body>
</html>