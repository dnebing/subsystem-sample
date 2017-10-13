<%@ include file="/init.jsp" %>

<%
    String redirect = ParamUtil.getString(request, "redirect");
    String backURL = ParamUtil.getString(request, "backURL", redirect);

    PortletURL portletURL = renderResponse.createRenderURL();

    SearchContainer searchContainer = new EventSearch(renderRequest, "cur2", currentURLObj);

    List<Event> eventList = EventLocalServiceUtil.getEvents(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    if (eventList == null) {
    	eventList = new ArrayList();
    }

    searchContainer.setTotal(eventList.size());
    searchContainer.setResults(eventList);

    EventSearchTerms searchTerms = (EventSearchTerms)searchContainer.getSearchTerms();

    RowChecker rowChecker = new EmptyOnClickRowChecker(renderResponse);

    rowChecker.setRowIds("rowIdsEvent");

    searchContainer.setRowChecker(rowChecker);

%>

<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " %>'>
    <liferay-portlet:renderURLParams varImpl="portletURL" />
    <aui:input name="<%= Constants.CMD %>" type="hidden" />
    <aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>" />

    <liferay-ui:search-container
            cssClass="events-search-container"
            id="events"
            searchContainer="<%= searchContainer %>"
            var="eventSearchContainer"
    >
        <aui:input disabled="<%= true %>" name="eventsRedirect" type="hidden" value="<%= currentURLObj.toString() %>" />

        <%
            EventDisplayTerms displayTerms = (EventDisplayTerms)eventSearchContainer.getDisplayTerms();

            long eventId = searchTerms.getEventId();

            Event event = null;

            if (eventId > 0) {
                try {
                    event = EventLocalServiceUtil.getEvent(eventId);

                }
                catch (NoSuchEventException nsoe) {
                }
            }
        %>

        <liferay-ui:search-container-results />

        <liferay-ui:search-container-row
                className="com.dnebinger.subsystem.events.model.Event"
                escapedModel="<%= true %>"
                keyProperty="eventId"
                modelVar="event2"
                rowIdProperty="eventId"
        >
            <liferay-portlet:renderURL varImpl="rowURL">
                <portlet:param name="mvcRenderCommandName" value="/edit_event" />
                <portlet:param name="redirect" value="<%= eventSearchContainer.getIteratorURL().toString() %>" />
                <portlet:param name="p_u_i_d" value="<%= String.valueOf(event2.getEventId()) %>" />
                <portlet:param name="eventId" value="<%= String.valueOf(event2.getEventId()) %>" />
            </liferay-portlet:renderURL>

            <%@ include file="/search_columns.jspf" %>

            <liferay-ui:search-container-column-jsp
                    cssClass="entry-action-column"
                    path="/event_action.jsp"
            />
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator markupView="lexicon" />
    </liferay-ui:search-container>
</aui:form>

    <liferay-frontend:add-menu>
        <portlet:renderURL var="viewEventsURL">
        </portlet:renderURL>

        <portlet:renderURL var="addEventURL">
            <portlet:param name="mvcRenderCommandName" value="/edit_event" />
            <portlet:param name="redirect" value="<%= viewEventsURL %>" />
        </portlet:renderURL>

        <liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "event") %>' url="<%= addEventURL.toString() %>" />
    </liferay-frontend:add-menu>
