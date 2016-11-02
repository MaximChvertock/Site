<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="w3-padding-16">
	<span class="w3-xlarge w3-border-teal w3-bottombar">Contact Us</span>
</div>

<h3><spring:message code="address" /></h3>

<p>Swing by for a cup of coffee, or whatever.</p>

<p>
	<i class="fa fa-map-marker w3-text-teal w3-xlarge"></i>
	<spring:message code="contacts.address" />
</p>

<p>
	<i class="fa fa-phone w3-text-teal w3-xlarge"></i>
	<spring:message code="contacts.phone.mts"/>
</p>

<p>
	<i class="fa fa-envelope-o w3-text-teal w3-xlarge"></i>
	<spring:message code="contacts.gmail" />
</p>