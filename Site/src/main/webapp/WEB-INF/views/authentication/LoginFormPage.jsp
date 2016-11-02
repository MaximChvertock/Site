<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<title><spring:message code="home_page.title" /></title>

<jsp:include page="../common/Header.jsp"></jsp:include>

<body>

	<jsp:include page="../common/Navigation.jsp"></jsp:include>

	<jsp:include page="../common/Modal.jsp"></jsp:include>

	<div class="w3-container w3-padding-64">
		
		<div class="w3-row">
			<div class="w3-container w3-quarter"></div>
		
			<div class="w3-half">
			
				<!-- Title -->
				<div class="w3-theme w3-center">
					<p class="w3-large"><spring:message code="form.title.signin" /></p>
				</div>
				
				<!-- Input fields -->
				<form:form
					class="w3-container w3-card-4 w3-padding-16 w3-white"
					method="post"
					action="action/checkLoginForm"
					modelAttribute="loginForm">
					
					<div class="w3-group">
						<label class="w3-label"><spring:message code="form.label.name" /></label>
						<input class="w3-input" type="text" name="username" />
					</div>
					
					<div class="w3-group">
						<label class="w3-label"><spring:message code="form.label.password" /></label>
						<input class="w3-input" type="password" name="password" />
					</div>
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					
					<input 
						class="w3-btn w3-right w3-theme" 
						type="submit" 
						value="<spring:message code="form.button.signin"/>"/>
				</form:form>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="../common/Footer.jsp"/>

	<jsp:include page="../common/Scripts.jsp"></jsp:include>

</body>
</html>

