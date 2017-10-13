<%@ page import="java.util.TimeZone" %>
<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String backURL = ParamUtil.getString(request, "backURL", redirect);

long eventId = ParamUtil.getLong(request, "eventId", 0);

Event selEvent = null;

if (eventId > 0) {
	selEvent = EventLocalServiceUtil.fetchEvent(eventId);
}

String relatedEventIds = "";

if (selEvent != null) {
	List<RelatedEvent> relatedEvents = RelatedEventLocalServiceUtil.getRelatedEvents(eventId);

	if ((relatedEvents != null) && (! relatedEvents.isEmpty())) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;

		for (RelatedEvent re : relatedEvents) {
			if (!first) sb.append(',');
			sb.append(re.getRelatedEventId());
			first = false;
		}

		relatedEventIds = sb.toString();
	}
}

long orgId = PortalUtil.getUserId(request);
TimeZone tz = TimeZone.getTimeZone("CDT");

	Calendar occursOn = Calendar.getInstance();
	Calendar endsOn = Calendar.getInstance();

	occursOn.setTimeZone(tz);
	endsOn.setTimeZone(tz);

if (selEvent != null) {
	orgId = selEvent.getOrganizer();

	if (selEvent.getOccursOn() != null) {
		occursOn.setTime(selEvent.getOccursOn());
	}
	if (selEvent.getEndsOn() != null) {
		endsOn.setTime(selEvent.getEndsOn());
	}
}

%>

<portlet:actionURL name="/edit_event" var="editEventActionURL" />

<portlet:renderURL var="editEventRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/edit_event" />
	<portlet:param name="backURL" value="<%= backURL %>" />
	<portlet:param name="eventId" value="<%= String.valueOf(eventId) %>" />
</portlet:renderURL>
<portlet:renderURL var="viewURL" >
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>


<aui:form action="<%= editEventActionURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= (selEvent == null) ? Constants.ADD : Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= editEventRenderURL %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="eventId" type="hidden" value="<%= String.valueOf(eventId) %>" />
	<aui:input name="p_u_i_d" type="hidden" value="<%= String.valueOf((selEvent != null) ? selEvent.getEventId() : 0) %>" />

	<aui:model-context bean="<%= selEvent %>" model="<%= Event.class %>" />

	<aui:fieldset>
		<aui:input name="eventId" disabled="<%= true %>" />
		<aui:input name="name" />
		<aui:input name="description" />
		<aui:input name="floor" />
		<aui:input name="room" />
		<aui:input name="organizer" />
		<aui:input name="maxOccupants" />
		<aui:input name="adultsOnly" type="toggle-switch" />

		<aui:input bean="<%= selEvent %>" cssClass="modify-link" model="<%= Event.class %>" name="occursOn" value="<%= occursOn %>" />

		<aui:input name="occursOnMonth" type="hidden" value="<%= Calendar.AUGUST %>" />
		<aui:input name="occursOnDay" type="hidden" value="1" />
		<aui:input name="occursOnYear" type="hidden" value="2017" />
		<aui:input name="occursOnHourOfDay" type="hidden" value="12" />
		<aui:input name="occursOnMinute" type="hidden" value="0" />

		<aui:input bean="<%= selEvent %>" cssClass="modify-link" model="<%= Event.class %>" name="endsOn" value="<%= endsOn %>" />

		<aui:input name="endsOnMonth" type="hidden" value="<%= Calendar.AUGUST %>" />
		<aui:input name="endsOnDay" type="hidden" value="1" />
		<aui:input name="endsOnYear" type="hidden" value="2017" />
		<aui:input name="endsOnHourOfDay" type="hidden" value="12" />
		<aui:input name="endsOnMinute" type="hidden" value="0" />

		<aui:input label="related-events" name="relatedEventIds" type="text" value="<%= relatedEventIds %>" />

		<aui:button-row>
			<aui:button type="submit" value="saveEvent" />
			<a href="<%= viewURL %>" class="btn btn-default" role="button"><liferay-ui:message key="cancel" /></a>
		</aui:button-row>
	</aui:fieldset>
</aui:form>

