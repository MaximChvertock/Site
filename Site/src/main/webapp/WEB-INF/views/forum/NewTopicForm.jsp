<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form
	class="w3-container w3-card-4 w3-padding-16 w3-white"
	method="post"
	action="${pageContext.request.contextPath}/action/addNewTopic"
	modelAttribute="newTopicForm">
	
	<div class="w3-group">
		<label class="w3-label"><spring:message code="new_topic.title" /></label>
		<input class="w3-input" type="text" name="title" required="required">
	</div>
	
	<div class="w3-group">
		<label class="w3-label"><spring:message code="new_topic.message" /></label>
<!-- 		<input class="w3-input" type="text" name="text" required="required"> -->
		<textarea class="w3-input" rows="5" name="text" required="required" maxlength="1000"></textarea>
	</div>
	
	<input class="w3-btn w3-right w3-theme" type="submit" value="<spring:message code="new_topic.submit"/>"/>
</form:form>