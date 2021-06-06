<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%-- <title><tiles:insertAttribute name="title"/></title> --%>
    <%-- <c:set var = "title" value="${empty title? '뉴렉처 온라인':title}"/> --%>
    <title>${title}</title>
    <link href="../../CSS/style copy mainmenu.css" type="text/css" rel="stylesheet">
	<%-- <script src="<tiles:getAsString name="js"/>"></script> --%>
	<c:set var="js"><tiles:getAsString name="js"/></c:set>
	<script src="${js}"></script>
</head>

<body>
    <div id="root">
        <!-- header 영역 -->
		<tiles:insertAttribute name="header"/>
		
        <div id="visual">
            <div class="float-content">

            </div>
        </div>


        <div id="body">
            <div class="float-content">
                <!-- aside 영역 -->
                <tiles:insertAttribute name="aside"/>

                <!-- main 영역 -->
                <tiles:insertAttribute name="main"/>
                
            </div>
        </div>


        <!-- footer 영역 -->
        <tiles:insertAttribute name="footer"/>
    </div>

</body>


</html>