<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<title>NEW USER PAGE</title>

<jsp:include page="../common/Header.jsp"></jsp:include>

<body id="myPage">

	<jsp:include page="../common/Navigation.jsp"></jsp:include>
	
	<jsp:include page="../common/Modal.jsp"></jsp:include>


	<!-- Container (Contact Section) -->
	<div class="w3-content w3-container w3-padding-64">
	    <div class="w3-row w3-padding-32 w3-section">
	        <div class="w3-col m8 w3-container w3-section">
	
				
	
	            <form:form 
					class="w3-container w3-card-4 w3-padding-16 w3-white"
	            	method="post" 
	            	action="create-new-user" 
	            	modelAttribute="newUserForm">
	            	
	            	<c:if test="${duplicateUserError == true}">
	            		<label class="w3-label w3-text-red"><spring:message code="error.user.duplicate" /></label>
	            	</c:if>
	                
	                <!-- Username -->
	                <div class="w3-group">	
						<label class="w3-label"><spring:message code="form.label.name" /></label>      
	                    <input 
		                    class="w3-input" 
		                    type="text"
		                    name="name"
		                    value="${name}"
		                   	required="required" >
	                </div>
	                
	                <!-- Email -->
	                <div class="w3-group">
						<label class="w3-label"><spring:message code="form.label.email" /></label>
	                    <input 
		                    class="w3-input" 
		                    type="email"
		                    name="email"
		                    value="${email}"
		                   	required="required" >
	                </div>
	                
	                <!-- Password -->
	                <div class="w3-group">
						<label class="w3-label"><spring:message code="form.label.password" /></label>
	                    <input 
		                    class="w3-input" 
		                    type="password"
		                    name="password"
		                    value="${password}"
							required="required" >
	                </div>
	                
					<input class="w3-btn w3-right w3-theme" type="submit" value="<spring:message code="new_user.submit"/>" />
	            </form:form>
	
	        </div>
	    </div>
	</div>
	

	<!-- Footer -->
	<jsp:include page="../common/Footer.jsp"/>

	<jsp:include page="../common/Scripts.jsp"></jsp:include>

</body>
</html>
