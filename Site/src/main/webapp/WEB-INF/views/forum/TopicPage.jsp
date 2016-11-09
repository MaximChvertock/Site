<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<title>TOPIC PAGE</title>

<jsp:include page="../common/Header.jsp"></jsp:include>

<body id="myPage">

	<jsp:include page="../common/Navigation.jsp"></jsp:include>

	<jsp:include page="../common/Modal.jsp"></jsp:include>
	
	<div class="w3-row-padding w3-center w3-padding-64">
	
	
		<security:authorize access="hasRole('ROLE_ANON')">
			<spring:message code="info.log_for_post_new_messages"/>
			<a href=${pageContext.request.contextPath}/login><spring:message code="form.title.signin"/></a>
		</security:authorize>
		
		<div class=" w3-margin-bottom">
			<ul class="w3-ul w3-border">
			
				<li class="w3-theme">
 					<p class="w3-large">${topicTitle}</p>
 				</li>
			
				<c:forEach var="message" items="${messages}">
					<li class="w3-padding-16">
						<div class="w3-row"><br>
						
							<div class="w3-quarter">
								<img
									src="${pageContext.request.contextPath}/resources/avatar.jpg" 
									alt="USER_STATUS" 
									style="width:45%"
									class="w3-circle w3-hover-opacity">
								<h3>${message.author.name}</h3>
								<p class="w3-small">USER_ACCOUNT_STATUS</p>
							</div>
							
							<div class="w3-threequarter">
								<p class="w3-small">${message.timestamp}</p>
								<p>${message.text}</p>
							</div>
							
						</div>

					</li>
 				</c:forEach>
			
			
			<security:authorize access="hasRole('ROLE_USER')">
				<li>
					<jsp:include page="NewMessageForm.jsp"/>
				</li>
			</security:authorize>
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
