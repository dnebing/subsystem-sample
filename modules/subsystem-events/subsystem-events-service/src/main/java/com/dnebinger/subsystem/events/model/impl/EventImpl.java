/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.dnebinger.subsystem.events.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * The extended model implementation for the Event service. Represents a row in the &quot;SUBSYS_Event&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dnebinger.subsystem.events.model.Event} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class EventImpl extends EventBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a event model instance should use the {@link com.dnebinger.subsystem.events.model.Event} interface instead.
	 */
	public EventImpl() {
	}

	/**
	 * getId: Return an integer of the id since the json conversion of our long id is returned as a string.
	 * @return int The integer version of the event id.
	 */
	@JSON
	public int getId() {
		return (int) getEventId();
	}

	/**
	 * getSelected: Doesn't really do much but it will inject a default boolean of false into
	 * the json representation of our object.
	 * @return boolean Always returns <code>false</code>.
	 */
	@JSON
	public boolean getSelected() {
		return false;
	}

	/**
	 * getDateDisplay: Returns the display date string for the event.
	 * @return String The display date string.
	 */
	@JSON
	public String getDateDisplay() {
		// need to get the central time zone
		TimeZone central = TimeZone.getTimeZone("CDT");
		DateFormat df;

		Date starts = getOccursOn();
		Date ends = getEndsOn();

		if (ends == null) {
			// all we have is the start date
			if (starts == null) {
				return "";
			}

			df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			df.setTimeZone(central);

			return df.format(starts);
		}

		if (starts == null) {
			// hmm, odd case that starts is null but ends is given?
			df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			df.setTimeZone(central);

			return df.format(ends);
		}

		// okay, we have two different dates.  Are they the same day?
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();

		startCal.setTime(starts);
		endCal.setTime(ends);

		if ((startCal.get(Calendar.YEAR) == endCal.get(Calendar.YEAR)) && (startCal.get(Calendar.DAY_OF_YEAR) == endCal.get(Calendar.DAY_OF_YEAR))) {
			// same day, so only the time changes...
			StringBuilder sb = new StringBuilder();

			df = new SimpleDateFormat("MM/dd/yyyy");
			df.setTimeZone(central);

			sb.append(df.format(starts)).append(' ');

			df = new SimpleDateFormat("HH:mm");
			df.setTimeZone(central);

			sb.append(df.format(starts)).append(" - ").append(df.format(ends));

			return sb.toString();
		}

		// if we get here then different days
		df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		StringBuilder sb = new StringBuilder(df.format(starts));

		sb.append(" - ").append(df.format(ends));

		return sb.toString();
	}

	/**
	 * getLocation: Returns the location as a simple string.
	 * @return String The location string.
	 */
	@JSON
	public String getLocation() {
		StringBuilder sb = new StringBuilder();

		sb.append(getFloor()).append('-').append(getRoom());

		return sb.toString();
	}

	/**
	 * getOrganizerName: Return the event organizer name.
	 * @return String The organizer name.
	 */
	@JSON
	public String getOrganizerName() {
		if (getOrganizer() <= 0) {
			return "Unknown";
		}

		User user = UserLocalServiceUtil.fetchUser(getOrganizer());

		if (user == null) {
			return "Unknown";
		}

		return user.getFullName();
	}
}