<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form
	class="w3-container w3-card-4 w3-padding-16 w3-white"
	method="post"
	action="sendContactMessage"
	modelAttribute="contactMessageForm">
	
	<div class="w3-group">
		<label class="w3-label"><spring:message code="form.label.name" /></label>
		<input class="w3-input" type="text" name="name">
	</div>
	
	<div class="w3-group">
		<label class="w3-label"><spring:message code="form.label.email" /></label>
		<input class="w3-input" type="email" name="email" required="required">
	</div>
	
	<div class="w3-group">
		<label class="w3-label"><spring:message code="form.label.subject" /></label>
<!-- 		<input class="w3-input" type="text" name="text" required="required"> -->
		<textarea class="w3-input" rows="5" name="text" required="required" maxlength="1000"></textarea>
	</div>
	
	<input class="w3-btn w3-right w3-theme" type="submit" value="<spring:message code="form.button.send"/>"/>
</form:form>