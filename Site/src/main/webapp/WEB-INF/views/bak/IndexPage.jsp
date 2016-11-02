<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: mad
  Date: 6/20/16
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/w3/w3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/font-awesome-4.6.3/css/font-awesome.min.css">

    <!-- theme -->
    <%--<link rel="stylesheet" href="http://www.w3schools.com/lib/w3-theme-red.css">--%>

    <style>
        @font-face {
            font-family: Dotted Font;
            src: url("${pageContext.request.contextPath}/resources/advanced_dot_digital-7.ttf");
        }

        @font-face {
            font-family: Sci-fi Font;
            src: url("${pageContext.request.contextPath}/resources/Research Remix Normal.otf");
        }

        .w3-dotted-font {
            font-family: "Dotted Font";
            font-size: 10px;
            color: #3a3a3a;
        }

        .w3-scifi-font {
            font-family: "Sci-fi Font";
            font-size: 10px;
            color: #3a3a3a;
        }
    </style>
</head>
<body style="position: relative; min-height: 100%; top: 0px;">

<div class="w3-container w3-theme w3-card-2 w3-topnav w3-right-align w3-xlarge">
    <a class="w3-left" href="javascript:void(0);" onclick="openSidebar()" title="Menu"><i class="fa fa-bars"></i></a>
    <div>
        <a class="fa fa-search w3-right" href="javascript:void(0)" onclick="openSearchbar()" title="Search"></a>
    </div>
</div>

<a href="${pageContext.request.contextPath}/protected">Protected</a>
<a href="${pageContext.request.contextPath}/public">Public</a>
<a href="${pageContext.request.contextPath}/new-user.html">New user</a>

<div class="w3-container">
    <hr>
    <div class="w3-container w3-card-2">
        <c:forEach var="message" items="${messageList}">
            <hr>
            <div class="w3-row">
                <div class="w3-col s3">
                    <div class="w3-group">
                        <img class="w3-circle" src="${pageContext.request.contextPath}/resources/avatar.jpg"
                             style="width: 50%">
                        <div class="w3-small"><fmt:formatDate value="${message.date}"
                                                              dateStyle="medium"></fmt:formatDate></div>
                    </div>
                </div>
                <div class="w3-col s9 w3-container">
                    <div class="w3-text-theme w3-large">${message.username}</div>
                    <div class="w3-container w3-medium">${message.text}</div>
                </div>
            </div>
        </c:forEach>
    </div>

    <hr>

    <div class="w3-container w3-card-2">
        <form:form method="post" action="${pageContext.request.contextPath}/forum/post-new-message"
                   modelAttribute="message">
            <div class="w3-group">
                <label>Username</label>
                <form:input class="w3-input" path="username"/>
            </div>
            <div class="w3-group">
                <label>Text</label>
                <form:textarea class="w3-input" path="text"/>
            </div>
            <input class="w3-theme w3-btn" type="submit" value="Send"/>
        </form:form>
    </div>

</div>

<div class="w3-theme w3-center w3-card-2">
    by Maksim Chvertock 2016
</div>

<!-- Side navigation bar -->
<%--<nav class="w3-sidenav w3-black w3-card-2 w3-xlarge" style="display: none" id="navigation-sidebar">--%>

<%--<a href="javascript:void(0)" onclick="closeSidebar()"--%>
<%--class="w3-closenav w3-right w3-padding-right">&times;</a><br>--%>

<%--<a href="#"><spring:message code="home"/></a>--%>
<%--<a href="#"><spring:message code="contacts"/></a>--%>
<%--<a href="#"><spring:message code="about"/></a>--%>
<%--</nav>--%>
<!-- /Side navigation bar -->


<%--<ul class="w3-navbar w3-card-2 w3-dark-grey">--%>

<%--<li class="w3-opennav" onclick="openSidebar()"><i class="fa fa-bars"></i></li>--%>
<%--<li><a href="#"><spring:message code="home"/></a></li>--%>
<%--<li><a href="#"><spring:message code="contacts"/></a></li>--%>
<%--<li><a href="#"><spring:message code="about"/></a></li>--%>

<%--<li class="w3-right w3-dropdown-click">--%>
<%--<a onclick="showLanguages()" href="javascript:void(0)"><i class="fa fa-sign-language"></i> <i--%>
<%--class="fa fa-caret-down"></i></a>--%>
<%--<div id="language-menu-id" class="w3-dropdown-content w3-white w3-card-4">--%>
<%--<a href="?language=ru"><spring:message code="russian"/></a>--%>
<%--<a href="?language=en"><spring:message code="english"/></a>--%>
<%--</div>--%>
<%--</li>--%>

<%--<li class="w3-right"><a href="#"><i class="fa fa-sign-in"></i></a></li>--%>
<%--</ul>--%>

<%--<div class="w3-container w3-light-grey">--%>
<%--<h1 class="w3-jumbo">It's my web site</h1>--%>
<%--<p class="w3-xlarge">Vestibulum tristique tellus eget efficitur congue. Nunc quis mauris nec orci faucibus--%>
<%--suscipit.--%>
<%--Proin aliquet mi augue, id volutpat arcu imperdiet sed. Nunc faucibus quis ante volutpat aliquam. Nam non--%>
<%--tristique ligula, id interdum nulla. Nulla auctor suscipit tempus. Suspendisse sagittis sapien magna, et--%>
<%--aliquet--%>
<%--felis laoreet vitae. </p>--%>

<%--</div>--%>


<%--<img src="${pageContext.request.contextPath}/resources/night.jpg" alt="picture" style="width:100%">--%>

<%--<div class="w3-container">--%>
<%--<p class="w3-scifi-font">Lorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне. Lorem Ipsum--%>
<%--является стандартной "рыбой" для текстов на латинице с начала XVI века. В то время некий безымянный печатник--%>
<%--создал большую коллекцию размеров и форм шрифтов, используя Lorem Ipsum для распечатки образцов. Lorem Ipsum--%>
<%--не--%>
<%--только успешно пережил без заметных изменений пять веков, но и перешагнул в электронный дизайн. Его--%>
<%--популяризации в новое время послужили публикация листов Letraset с образцами Lorem Ipsum в 60-х годах и, в--%>
<%--более--%>
<%--недавнее время, программы электронной вёрстки типа Aldus PageMaker, в шаблонах которых используется Lorem--%>
<%--Ipsum.</p>--%>
<%--</div>--%>


<%--<footer class="w3-container w3-light-grey">--%>
<%--<p>My Footer</p>--%>
<%--</footer>--%>

<%--<script>--%>
<%--function openSidebar() {--%>
<%--document.getElementById("navigation-sidebar").style.display = "block";--%>
<%--}--%>

<%--function closeSidebar() {--%>
<%--document.getElementById("navigation-sidebar").style.display = "none";--%>
<%--}--%>

<!-- function showLanguages() { -->
<!-- var menu = document.getElementById("language-menu-id"); -->

<!-- if (menu.className.indexOf("w3-show") == -1) { -->
<!-- menu.className += " w3-show"; -->
<!-- } else { -->
<!-- menu.className = menu.className.replace(" w3-show", ""); -->
<!-- } -->
<!-- } -->
<%--</script>--%>

</body>
</html>
