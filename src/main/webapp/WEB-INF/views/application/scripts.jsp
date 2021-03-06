
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:useBean id="cons" class="model.logic.Constants" />
<script type="text/javascript">
	ctxr = '<c:url value="/resources/"/>';
	ctx = '<c:url value="/"/>';
	serverDomain = document.domain;
	serverContext = location.pathname.split('/')[1];
	serverPort = location.port;
	wsUrlNotifications = "ws://" + serverDomain + ":" + serverPort + "/" + serverContext + "/notification";
        maxCounter=${pageContext.session.maxInactiveInterval};
        intervalCheck = ${cons.getIntervalSessionCheck()};
        increaseCounter = ${cons.getIncreaseCounter()};
        maxFileSizeUpload = ${cons.getMaxFileSizeUpload()};
</script>
<script src="<c:url value="/resources/js/scripts.js"/>"	type="text/javascript"></script>
<script>
    (function($) {
        "use strict";
	   if ($('html').is('.ie6, .ie7, .ie8, .ie9')) {
	       window.location.href = "oldBrowser.html";
	   }
    }(jQuery));
</script>