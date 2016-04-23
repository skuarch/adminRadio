<%-- 
    Document   : index
    Created on : Oct 19, 2014, 6:12:09 PM
    Author     : skuarch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>  
        <title><spring:message code="text1" /></title>
        <jsp:include page="../application/head.jsp"/>        
    </head>
    <body>
        <form id="addStationForm" action="addStationProcess" method="POST">
            <div id="wrapper">
                <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <jsp:include page="../application/topmenu.jsp" />
                    <jsp:include page="../application/sidemenu.jsp" />
                </nav>
                <div id="page-wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header"><spring:message code="text26" /></h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="name"><spring:message code="text27" /></label>
                                <input id="name" name="name" type="text" class="form-control" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="urlStreaming"><spring:message code="text28" /></label>
                                <input id="urlStreaming" name="urlStreaming" type="text" class="form-control" />
                            </div>
                        </div>
                    </div>    
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="description"><spring:message code="text29" /></label>
                                <input id="description" name="description" type="text" class="form-control" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="website"><spring:message code="text30" /></label>
                                <input id="website" name="website" type="text" class="form-control" />
                            </div>
                        </div>
                    </div>    
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="keyword"><spring:message code="text31" /></label>                                 
                                <div id="selectKeyword">
                                    <select id="keyword" name="keyword"  class="form-control" multiple onchange="createKeywordModalWindow('modal', '<spring:message code="text53"/>')">
                                        <option value="0"><spring:message code="text52"/></option>
                                        <c:forEach begin="0" end="${jsonArrayKeywords.length() -1}" var="index">                                        
                                            <option value="${jsonArrayKeywords.getJSONObject(index).get("id")}">${jsonArrayKeywords.getJSONObject(index).get("name")}</option>                                
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="genre"><spring:message code="text35" /></label>
                                <div id="selectGenre">
                                    <select id="genre" name="genre" class="form-control" multiple onchange="createGenreModalWindow('modal', '<spring:message code="text40"/>')">
                                        <option value="0"><spring:message code="text50"/></option>
                                        <c:forEach begin="0" end="${jsonArrayGenres.length() -1}" var="index">
                                            <option value="${jsonArrayGenres.getJSONObject(index).get("id")}">
                                                ${jsonArrayGenres.getJSONObject(index).get("name")}
                                            </option>                                
                                        </c:forEach>                                    
                                    </select>                            
                                </div>
                            </div>
                        </div>
                    </div>    
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="modulating"><spring:message code="text33" /></label>
                                <select id="modulating" name="modulating" class="form-control">
                                    <option value="">no modulating</option>
                                    <option value="fm">FM</option>
                                    <option value="am">AM</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="active"><spring:message code="text34" /></label>
                                <select id="active" name="active" class="form-control">
                                    <option value="1">yes</option>
                                    <option value="0">no</option>
                                </select>
                            </div>
                        </div>
                    </div>    
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="clicks"><spring:message code="text14" /></label>
                                <input id="clicks" name="clicks" type="number" value="0" class="form-control">                                
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="country"><spring:message code="text36" /></label>
                                <select id="country" name="country" class="form-control">
                                    <c:forEach begin="0" end="${jsonArrayCountries.length() -1}" var="index">
                                        <option value="${jsonArrayCountries.getJSONObject(index).get("id")}">
                                            ${jsonArrayCountries.getJSONObject(index).get("name")}
                                        </option>                                
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="frecuency"><spring:message code="text32" /></label>
                                <input type="text" name="frecuency" id="frecuency" class="form-control">                                
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="language"><spring:message code="text37" /></label>
                                <select id="language" name="language" class="form-control" multiple>
                                    <c:forEach begin="0" end="${jsonArrayLanguages.length() -1}" var="index">
                                        <option value="${jsonArrayLanguages.getJSONObject(index).get("id")}">
                                            ${jsonArrayLanguages.getJSONObject(index).get("name")}
                                        </option>                                
                                    </c:forEach>
                                </select>
                            </div>
                        </div>                    
                    </div>  
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="stationType"><spring:message code="text38" /></label>
                                <select id="stationType" name="stationType" class="form-control">
                                    <option value="1">shoutcast</option>
                                    <option value="2">icecast</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="position"><spring:message code="text39" /></label>
                                <input id="position" name="position" type="number" class="form-control" value="0" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-primary btn-block btn-lg" onclick="copyUrl()">test</button>
                        </div>
                        <div class="col-lg-6">
                            <button type="submit" class="btn btn-success btn-block btn-lg">create station</button>
                        </div>
                    </div>
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">Player</h4>
                                </div>
                                <div class="modal-body">
                                    <audio id="player"></audio>
                                    <div class="text-center">
                                        <label>Test Player</label>
                                        <input type="text" name="testUrlStreaming" id="testUrlStreaming" class="form-control">                                
                                        <br/>
                                        <br/>
                                        <button type="button" id="playButton" onclick="startReproduction($('#testUrlStreaming').val())" class="btn btn-lg btn-danger"><i class="fa fa-play"></i></button>
                                        <span style="padding-right: 7px;"></span>                    
                                        <button type="button" id="pauseButton" onclick="clickPauseButton()" class="btn btn-lg btn-primary"><i class="fa fa-pause"></i></button>
                                        <span style="padding-right: 7px;"></span>                    
                                        <button type="button" id="stopButton" onclick="clickStopButton()" class="btn btn-lg btn-primary"><i class="fa fa-stop"></i></button>
                                        <span style="padding-right: 7px;"></span>                    
                                        <button type="button" id="increaseVolumenButton" onclick="increaseVolumen()" class="btn btn-lg btn-primary"><i class="fa fa-plus-square"></i></button>
                                        <span style="padding-right: 7px;"></span>
                                        <button type="button" id="decreaseVolumenButton" onclick="decreaseVolumen()" class="btn btn-lg btn-primary"><i class="fa fa-minus-square"></i></button>   
                                        <span style="padding-right: 7px;"></span>
                                        <button type="button" onclick="addDashSemicolon()" class="btn btn-lg btn-primary"><i class="fa fa-circle"></i></button>                                           
                                        <span style="padding-right: 7px;"></span>
                                        <button type="button" onclick="removeDashSemicolon()" class="btn btn-lg btn-primary"><i class="fa fa-circle-o"></i></button>   
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal -->    
                    <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header" id="modalTitle">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>

                                </div>
                                <div class="modal-body" id="modalBody">
                                </div>
                                <div class="modal-footer" id="modal-footer">
                                    <span id="spanLeftButtonClose"></span>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </div>
                        <!-- /.modal-dialog -->
                    </div>
                    <!-- /.modal -->  
                </div>
            </div>
        </form>
        <!-- /#wrapper -->
        <script src="<c:url value="/scriptI18N"/>" type="text/javascript"></script>
        <jsp:include page="../application/scripts.jsp" />
    </body>
</html>