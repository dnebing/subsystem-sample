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
import com.dnebinger.subsystem.events.model.Event;
import com.dnebinger.subsystem.events.service.EventLocalServiceUtil;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

/**
 * The extended model implementation for the EventAttendee service. Represents a row in the &quot;SUBSYS_EventAttendee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dnebinger.subsystem.events.model.EventAttendee} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class EventAttendeeImpl extends EventAttendeeBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a event attendee model instance should use the {@link com.dnebinger.subsystem.events.model.EventAttendee} interface instead.
	 */
	public EventAttendeeImpl() {
	}

	/**
	 * getEventName: Returns the name of the event.
	 * @return String The name of the event.
	 */
	@JSON
	public String getEventName() {
		Event event = EventLocalServiceUtil.fetchEvent(getEventId());

		if (event == null) {
			return "Unnamed";
		}

		return event.getName();
	}

	/**
	 * getUserName; Returns the name of the event attendee.
	 * @return String The attendee name.
	 */
	@JSON
	public String getUserName() {
		User user = UserLocalServiceUtil.fetchUser(getUserId());

		if (user == null) {
			return "Unknown";
		}

		return user.getFullName();
	}
}