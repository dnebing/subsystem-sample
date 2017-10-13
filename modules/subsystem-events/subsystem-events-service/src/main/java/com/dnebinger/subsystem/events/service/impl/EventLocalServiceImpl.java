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

import com.dnebinger.subsystem.events.model.Event;
import com.dnebinger.subsystem.events.service.base.EventLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;

/**
 * The implementation of the event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dnebinger.subsystem.events.service.EventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventLocalServiceBaseImpl
 * @see com.dnebinger.subsystem.events.service.EventLocalServiceUtil
 */
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.dnebinger.subsystem.events.service.EventLocalServiceUtil} to access the event local service.
	 */

    public Event addEvent(final String name, final String description, final Date occursOn, final Date endsOn, final int maxOccupants,
                          final boolean adultsOnly, final int floor, final String room, final long organizer) {

        Event event = createEvent(counterLocalService.increment(Event.class.getName()));

        event.setAdultOnly(adultsOnly);
        event.setDescription(description);
        event.setEndsOn(endsOn);
        event.setFloor(floor);
        event.setMaxOccupants(maxOccupants);
        event.setName(name);
        event.setOccursOn(occursOn);
        event.setOrganizer(organizer);
        event.setRoom(room);

        return addEvent(event);
    }

    private static final Log _log = LogFactoryUtil.getLog(EventLocalServiceImpl.class);

}