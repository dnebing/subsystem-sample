
package com.dnebinger.subsystem.events.admin.portlet.action;

import com.dnebinger.subsystem.events.admin.constants.EventsAdminPortletKeys;
import com.dnebinger.subsystem.events.model.Event;
import com.dnebinger.subsystem.events.service.EventLocalServiceUtil;
import com.dnebinger.subsystem.events.service.RelatedEventLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * class EditEventMVCActionCommand: The action command handler for adding/editing an event entity.
 *
 * @author dnebinger
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + EventsAdminPortletKeys.EventsAdmin,
		"mvc.command.name=/edit_event"
	},
	service = MVCActionCommand.class
)
public class EditEventMVCActionCommand extends BaseMVCActionCommand {

	protected Date getDate(ActionRequest request, String prefix) {
		Calendar cal = Calendar.getInstance();
		TimeZone tz = TimeZone.getTimeZone("CDT");
		cal.setTimeZone(tz);

		int minute = ParamUtil.getInteger(request, prefix + "Minute");
		int hour = ParamUtil.getInteger(request, prefix + "HourOfDay");
		int month = ParamUtil.getInteger(request, prefix + "Month");
		int day = ParamUtil.getInteger(request, prefix + "Day");
		int year = ParamUtil.getInteger(request, prefix + "Year");

		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.SECOND, 0);

		return cal.getTime();
	}

	protected Event addEvent(ActionRequest actionRequest) throws Exception {
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String room = ParamUtil.getString(actionRequest, "room");
		int maxOccupants = ParamUtil.getInteger(actionRequest, "maxOccupants");
		boolean adultsOnly = ParamUtil.getBoolean(actionRequest, "adultsOnly");
		int floor = ParamUtil.getInteger(actionRequest, "floor");
		long organizerId = ParamUtil.getLong(actionRequest, "organizer");

		if (organizerId <= 0) {
			organizerId = PortalUtil.getUserId(actionRequest);
		}

		String relatedEventIds = ParamUtil.getString(actionRequest, "relatedEventIds", "");
		String[] relEventIds = StringUtil.split(relatedEventIds);
		Date occursOn = getDate(actionRequest, "occursOn");
		Date endsOn = getDate(actionRequest, "endsOn");

		Event event = EventLocalServiceUtil.addEvent(name, description, occursOn, endsOn, maxOccupants, adultsOnly,
				floor, room, organizerId);

		RelatedEventLocalServiceUtil.saveRelatedEvents(event.getEventId(), relEventIds);

		return event;
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		Event event = null;

		if (cmd.equals(Constants.ADD)) {
			event = addEvent(actionRequest);
		}
		else if (cmd.equals(Constants.UPDATE)) {
			event = updateEvent(actionRequest, actionResponse);
		}

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		sendRedirect(actionRequest, actionResponse, redirect);
	}


	protected Event updateEvent(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long eventId = ParamUtil.getLong(actionRequest, "eventId");
		if (eventId <= 0) {
			return addEvent(actionRequest);
		}

		Event event = EventLocalServiceUtil.fetchEvent(eventId);
		if (event == null) {
			return addEvent(actionRequest);
		}

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String room = ParamUtil.getString(actionRequest, "room");
		int maxOccupants = ParamUtil.getInteger(actionRequest, "maxOccupants");
		boolean adultsOnly = ParamUtil.getBoolean(actionRequest, "adultsOnly");
		int floor = ParamUtil.getInteger(actionRequest, "floor");
		long organizerId = ParamUtil.getLong(actionRequest, "organizer");

		if (organizerId <= 0) {
			organizerId = PortalUtil.getUserId(actionRequest);
		}

		String relatedEventIds = ParamUtil.getString(actionRequest, "relatedEventIds", "");
		String[] relEventIds = StringUtil.split(relatedEventIds);
		Date occursOn = getDate(actionRequest, "occursOn");
		Date endsOn = getDate(actionRequest, "endsOn");

		event.setName(name);
		event.setDescription(description);
		event.setRoom(room);
		event.setMaxOccupants(maxOccupants);
		event.setOrganizer(organizerId);
		event.setOccursOn(occursOn);
		event.setEndsOn(endsOn);
		event.setAdultOnly(adultsOnly);
		event.setFloor(floor);

		event = EventLocalServiceUtil.updateEvent(event);

		RelatedEventLocalServiceUtil.saveRelatedEvents(event.getEventId(), relEventIds);

		return event;
	}

}