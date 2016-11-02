<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<title>FORUM PAGE</title>

<jsp:include page="../common/Header.jsp"></jsp:include>

<body id="myPage">

	<jsp:include page="../common/Navigation.jsp"></jsp:include>

	<jsp:include page="../common/Modal.jsp"></jsp:include>
	

	<!-- Row -->
<!-- 	<div class="w3-row-padding w3-padding-64 w3-theme-l1"> -->

<!-- 		<div class="w3-quarter"> -->
<!-- 			<h2>Our Portfolio</h2> -->
<!-- 			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore -->
<!-- 			magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea -->
<!-- 			commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat -->
<!-- 			nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit -->
<!-- 			anim id est laborum.</p> -->
<!-- 		</div> -->
	
<!-- 		<div class="w3-quarter"> -->
<!-- 			<div class="w3-card-2 w3-white"> -->
<!-- 				<img src="img_fjords.jpg" alt="Vernazza" style="width:100%"> -->
<!-- 				<div class="w3-container"> -->
<!-- 					<h3>Customer 1</h3> -->
<!-- 					<h4>Trade</h4> -->
<!-- 					<p>Blablabla</p> -->
<!-- 					<p>Blablabla</p> -->
<!-- 					<p>Blablabla</p> -->
<!-- 					<p>Blablabla</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
	
<!-- 		<div class="w3-quarter"> -->
<!-- 			<div class="w3-card-2 w3-white"> -->
<!-- 				<img src="img_lights.jpg" alt="Cinque Terre" style="width:100%"> -->
<!-- 				<div class="w3-container"> -->
<!-- 					<h3>Customer 2</h3> -->
<!-- 					<h4>Trade</h4> -->
<!-- 					<p>Blablabla</p> -->
<!-- 					<p>Blablabla</p> -->
<!-- 					<p>Blablabla</p> -->
<!-- 					<p>Blablabla</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
	
<!-- 		<div class="w3-quarter"> -->
<!-- 			<div class="w3-card-2 w3-white"> -->
<!-- 				<img src="img_mountains.jpg" alt="Monterosso" style="width:100%"> -->
<!-- 				<div class="w3-container"> -->
<!-- 					<h3>Customer 3</h3> -->
<!-- 					<h4>Trade</h4> -->
<!-- 					<p>Blablabla</p> -->
<!-- 					<p>Blablabla</p> -->
<!-- 					<p>Blablabla</p> -->
<!-- 					<p>Blablabla</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 	</div> -->

	<!-- Container -->
<!-- 	<div class="w3-container" style="position:relative"> -->
<!-- 		<a  -->
<!-- 			onclick="w3_open()" -->
<!-- 			class="w3-btn-floating-large w3-teal" -->
<!-- 			style="position:absolute;top:-28px;right:24px;z-index:0;"> -->
<!-- 			<i class="fa fa-plus"></i> -->
<!-- 		</a> -->
<!-- 	</div> -->


	<div class="w3-row-padding w3-center w3-padding-64">

		<security:authorize access="hasRole('ROLE_ADMIN')">
			<a href="${pageContext.request.contextPath}/test-add-new-topic">[TEST] Add new topic</a>
		</security:authorize>
		<security:authorize access="hasRole('ROLE_USER')">
			<a href="${pageContext.request.contextPath}/forum/new-topic">Create new topic</a>
		</security:authorize>
		
		<security:authorize access="hasRole('ROLE_ANON')">
			<spring:message code="info.log_for_post_new_topics"/>
		</security:authorize>


		<div class=" w3-margin-bottom">
			<ul class="w3-ul w3-border">
			
				<c:forEach var="topic" items="${topics}">
					<li class="w3-padding-16">

						<div class="w3-container">
							<div class="w3-large">
								<a href="${pageContext.request.contextPath}/forum/topic/${topic.id}">${topic.title}</a>
							</div>
							<div class="w3-small">
								${topic.timestamp} by ${topic.author.name}
							</div>
						</div>
					</li>
 				</c:forEach>
			
			
			
<!-- 				<li class="w3-theme"> -->
<!-- 					<p class="w3-large">TOPIC_NAME$</p> -->
<!-- 				</li> -->
				
<%-- 				<c:forEach var="message" items="${messages}"> --%>
<!-- 					<li class="w3-padding-16"> -->
<!-- 						<div class="w3-row"><br> -->
						
<!-- 							User info -->
<!-- 							<div class="w3-quarter"> -->
<!-- 								<img -->
<%-- 									src="${pageContext.request.contextPath}/resources/avatar.jpg"  --%>
<!-- 									alt="USER_STATUS"  -->
<!-- 									style="width:45%" -->
<!-- 									class="w3-circle w3-hover-opacity"> -->
<!-- 								<h3>USER_NAME</h3> -->
<!-- 								<p class="w3-small">USER_ACCOUNT_STATUS</p> -->
<!-- 							</div> -->
							
<!-- 							Message -->
<!-- 							<div class="w3-threequarter"> -->
<%-- 								<p class="w3-small">${message.timestamp}</p> --%>
<%-- 								<p>${message.text}</p> --%>
<!-- 							</div> -->
							
<!-- 						</div> -->
<!-- 					</li> -->
<%-- 				</c:forEach> --%>
				
				
				
			</ul>
		</div>
	</div>
	
	

<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${messages}"> --%>
<%-- 			<li>${message}</li>	 --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
	<!-- Footer -->
	<jsp:include page="../common/Footer.jsp"/>

	<jsp:include page="../common/Scripts.jsp"/>

</body>
</html>
