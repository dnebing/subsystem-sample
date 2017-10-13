
<%@ include file="/init.jsp" %>

<%
EventSearch searchContainer = (EventSearch)request.getAttribute("liferay-ui:search:searchContainer");

String redirect = searchContainer.getIteratorURL().toString();

EventSearchTerms searchTerms = (EventSearchTerms)searchContainer.getSearchTerms();

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Event user2 = (Event)row.getObject();

long eventId = user2.getEventId();
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">

		<portlet:renderURL var="editEventURL">
			<portlet:param name="mvcRenderCommandName" value="/edit_event" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="p_u_i_d" value="<%= String.valueOf(eventId) %>" />
			<portlet:param name="eventId" value="<%= String.valueOf(eventId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editEventURL %>"
		/>

</liferay-ui:icon-menu>