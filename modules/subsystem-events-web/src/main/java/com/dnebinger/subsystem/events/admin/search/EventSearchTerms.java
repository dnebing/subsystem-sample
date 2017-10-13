
package com.dnebinger.subsystem.events.admin.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

/**
 * class EventSearchTerms: Container for the event search terms.
 *
 * @author dnebinger
 */
public class EventSearchTerms extends EventDisplayTerms {

	public EventSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		name = DAOParamUtil.getString(portletRequest, NAME);
		description = DAOParamUtil.getString(portletRequest, DESCRIPTION);
		dateDisplay = DAOParamUtil.getString(portletRequest, DATE_DISPLAY);
		location = DAOParamUtil.getString(portletRequest, LOCATION);
		eventId = ParamUtil.getLong(portletRequest, EVENT_ID);
	}
}