<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<title>HOME PAGE</title>

<jsp:include page="common/Header.jsp"></jsp:include>

<body id="myPage">

	<jsp:include page="common/Navigation.jsp"></jsp:include>
	
	<jsp:include page="common/Modal.jsp"></jsp:include>

	<br>
	<div class="w3-display-container w3-animate-opacity w3-center w3-margin-top">
		<img
			class="testimg"
			src="${pageContext.request.contextPath}/resources/under-construction.png"
			alt="boat"
			style="width: 70%; min-height: 350px; max-height: 600px;">
	</div>
	
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<div class="w3-container">
			${pageContext.request.userPrincipal}
			<br>
			<a href="${pageContext.request.contextPath}/test-add-new-user">[TEST] Add new user</a>
			<br>
			<a href="${pageContext.request.contextPath}/test-add-new-message">[TEST] Add new message</a>
		</div>
	</security:authorize>
	
	<!-- Container -->
	<div class="w3-container w3-padding-64 w3-theme-l5">
		<div class="w3-row">
			<div class="w3-col m5">
				<jsp:include page="common/ContactUsInfo.jsp"/>
			</div>
			<div class="w3-col m7">
				<jsp:include page="common/ContactMessageForm.jsp"/>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="common/Footer.jsp"/>

	<jsp:include page="common/Scripts.jsp"></jsp:include>

</body>
</html>
