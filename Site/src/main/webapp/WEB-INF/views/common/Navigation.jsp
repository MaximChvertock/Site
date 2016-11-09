<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Side Navigation on click -->
<nav
	class="w3-sidenav w3-white w3-card-2 w3-animate-left"
	style="display: none; z-index: 2"
	id="mySidenav">
		
	<a
		href="javascript:void(0)"
		onclick="w3_close()"
		class="w3-closenav w3-xxxlarge w3-text-teal">Close <i class="fa fa-remove"></i></a>
		
	<jsp:include page="../common/DropdownLinks.jsp"></jsp:include>
</nav>

<!-- Navbar -->
<div class="w3-top">
	<ul class="w3-navbar w3-theme-d2 w3-large">
			
		<li class="w3-hide-medium w3-hide-large w3-opennav w3-left">
			<a
				class="w3-hover-white w3-large w3-theme-d2"
				href="javascript:void(0);"
				onclick="openNav()"><i class="fa fa-bars"></i></a>
		</li>

<!-- 			
		<li>
			<a href="#" class="w3-teal"><i class="fa fa-home w3-margin-right"></i>Logo</a>
		</li>
-->		
		<li class="w3-hide-small">
			<a 
				href="${pageContext.request.contextPath}/home" 
				class="w3-hover-white"><spring:message code="home"/></a>
		</li>
			
		<li class="w3-hide-small">
			<a 
				href="${pageContext.request.contextPath}/forum" 
				class="w3-hover-white"><spring:message code="forum"/></a>
		</li>
			
		<li class="w3-hide-small w3-dropdown-hover">
			<a href="#" title="Notifications">Dropdown <i class="fa fa-caret-down"></i></a>
				
			<div class="w3-dropdown-content w3-white w3-card-4">
				<a href="${pageContext.request.contextPath}/new-user"><spring:message code="new_user.title"/></a>
			</div>
		</li>
<!--			
		<li class="w3-hide-small w3-right">
			<a href="#" class="w3-hover-teal" title="Search"><i class="fa fa-search"></i></a>
		</li>
-->

		<li class="w3-hover-white  w3-right-align  w3-right">
			<c:choose>
				<c:when test="${not empty pageContext.request.userPrincipal}">
					<a href="${pageContext.request.contextPath}/logout">${pageContext.request.userPrincipal.name} <i class="fa fa-sign-out"></i></a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/login"><i class="fa fa-sign-in"></i></a>
				</c:otherwise>
			</c:choose>
		</li>
		
<%-- 		<c:if test="${not empty pageContext.request.userPrincipal}"> --%>
<!-- 			<li class="w3-hover-white w3-right"> -->
<%-- 				<a href="${pageContext.request.contextPath}/home">${pageContext.request.userPrincipal.name}</a> --%>
<!-- 			</li> -->
<%-- 		</c:if> --%>
			

		<li class="w3-right w3-dropdown-click">
			<a 
				onclick="showLang()" 
				href="javascript:void(0)"><i class="fa fa-language"></i><i class="fa fa-caret-down"></i>
			</a>				
			<div id="language-menu-id" class="w3-dropdown-content w3-white w3-card-4">
				<a href="?language=ru"><spring:message code="russian"/></a>
				<a href="?language=en"><spring:message code="english"/></a>
			</div>
				
		</li>

	</ul>
</div>

<!-- Navbar on small screens -->
<div
	id="navDemo"
	class="w3-hide w3-hide-large w3-hide-medium w3-top"
	style="margin-top: 43px;">
	<ul class="w3-navbar w3-left-align w3-large w3-theme">
		<li>
			<a href="${pageContext.request.contextPath}/home"><spring:message code="home"/></a>
		</li>
			
		<li>
			<a href="${pageContext.request.contextPath}/forum"><spring:message code="forum"/></a>
		</li>
			
		<li class="w3-dropdown-hover">
			<a href="#" title="Notifications">Dropdown <i class="fa fa-caret-down"></i></a>
				
			<div class="w3-dropdown-content w3-light-grey w3-card-4">
				<jsp:include page="../common/DropdownLinks.jsp"></jsp:include>
			</div>
		</li>
	</ul>
</div>