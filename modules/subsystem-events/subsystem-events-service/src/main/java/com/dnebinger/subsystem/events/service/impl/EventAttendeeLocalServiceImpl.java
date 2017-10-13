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

package com.dnebinger.subsystem.events.service.impl;

import com.dnebinger.subsystem.events.model.EventAttendee;
import com.dnebinger.subsystem.events.service.base.EventAttendeeLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

/**
 * The implementation of the event attendee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dnebinger.subsystem.events.service.EventAttendeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendeeLocalServiceBaseImpl
 * @see com.dnebinger.subsystem.events.service.EventAttendeeLocalServiceUtil
 */
public class EventAttendeeLocalServiceImpl
	extends EventAttendeeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.dnebinger.subsystem.events.service.EventAttendeeLocalServiceUtil} to access the event attendee local service.
	 */


	public List<EventAttendee> getEventAttendees(final long eventId) {
		return eventAttendeePersistence.findByEventId(eventId);
	}

	private static final Log _log = LogFactoryUtil.getLog(EventAttendeeLocalServiceImpl.class);

}