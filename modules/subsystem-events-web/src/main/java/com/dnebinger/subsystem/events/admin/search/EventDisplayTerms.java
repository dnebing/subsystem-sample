
package com.dnebinger.subsystem.events.admin.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

/**
 * class EventDisplayTerms: The event display terms.
 *
 * @author dnebinger
 */
public class EventDisplayTerms extends DisplayTerms {

	public static final String EVENT_ID = "eventId";

	public static final String NAME = "name";

	public static final String DESCRIPTION = "description";

	public static final String DATE_DISPLAY = "dateDisplay";

	public static final String LOCATION = "location";

	public EventDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);

		name = ParamUtil.getString(portletRequest, NAME);
		description = ParamUtil.getString(portletRequest, DESCRIPTION);
		dateDisplay = ParamUtil.getString(portletRequest, DATE_DISPLAY);
		location = ParamUtil.getString(portletRequest, LOCATION);
		eventId = ParamUtil.getLong(portletRequest, EVENT_ID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateDisplay() {
		return dateDisplay;
	}

	public void setDateDisplay(String dateDisplay) {
		this.dateDisplay = dateDisplay;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	protected String name;
	protected String description;
	protected String dateDisplay;
	protected String location;
	protected long eventId;

}