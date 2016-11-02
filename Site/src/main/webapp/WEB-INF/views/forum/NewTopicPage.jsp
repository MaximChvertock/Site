<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<title>TOPIC PAGE</title>

<jsp:include page="../common/Header.jsp"></jsp:include>

<body id="myPage">

	<jsp:include page="../common/Navigation.jsp"></jsp:include>

	<jsp:include page="../common/Modal.jsp"></jsp:include>
	
	<div class="w3-row-padding w3-center w3-padding-64">
		<jsp:include page="NewTopicForm.jsp"/>
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
