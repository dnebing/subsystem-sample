package com.dnebinger.subsystem.events.admin.search;

import com.dnebinger.subsystem.events.model.Event;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class EventSearch: A custom search container for our event records.
 *
 * @author dnebinger
 */
public class EventSearch extends SearchContainer<Event> {
	public static final String EMPTY_RESULTS_MESSAGE = "no-events-were-found";

	public static List<String> headerNames = new ArrayList<>();
	public static Map<String, String> orderableHeaders = new HashMap<>();

	static {
		headerNames.add("event-id");
		headerNames.add("event-name");
		headerNames.add("event-desc");
		headerNames.add("event-date");
		headerNames.add("event-location");

		orderableHeaders.put("event-name", "event-name");
	}

	public EventSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		this(portletRequest, DEFAULT_CUR_PARAM, iteratorURL);
	}

	public EventSearch(
			PortletRequest portletRequest, String curParam,
			PortletURL iteratorURL) {

		super(
				portletRequest, new EventDisplayTerms(portletRequest),
				new EventSearchTerms(portletRequest), curParam, DEFAULT_DELTA,
				iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		PortletConfig portletConfig =
				(PortletConfig)portletRequest.getAttribute(
						JavaConstants.JAVAX_PORTLET_CONFIG);

		EventDisplayTerms displayTerms = (EventDisplayTerms)getDisplayTerms();
		EventSearchTerms searchTerms = (EventSearchTerms)getSearchTerms();

		String portletId = PortletProviderUtil.getPortletId(
				Event.class.getName(), PortletProvider.Action.VIEW);
		String portletName = portletConfig.getPortletName();

		iteratorURL.setParameter(
				EventDisplayTerms.NAME, displayTerms.getName());
		iteratorURL.setParameter(
				EventDisplayTerms.DESCRIPTION, displayTerms.getDescription());
		iteratorURL.setParameter(
				EventDisplayTerms.DATE_DISPLAY, displayTerms.getDateDisplay());
		iteratorURL.setParameter(
				EventDisplayTerms.LOCATION, displayTerms.getLocation());
		iteratorURL.setParameter(
				EventDisplayTerms.EVENT_ID,
				String.valueOf(displayTerms.getEventId()));

		try {
			PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(
							portletRequest);

			String orderByCol = ParamUtil.getString(
					portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
					portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

				preferences.setValue(
						portletId, "event-order-by-col", orderByCol);
				preferences.setValue(
						portletId, "event-order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(
						portletId, "event-order-by-col", "event-name");
				orderByType = preferences.getValue(
						portletId, "event-order-by-type", "asc");
			}

			boolean orderByAsc = false;

			if (orderByType.equals("asc")) {
				orderByAsc = true;
			}

			OrderByComparator<Event> orderByComparator = new EventNameComparator(orderByAsc);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error("Unable to initialize event search", e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(EventSearch.class);
}
