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
import com.dnebinger.subsystem.events.model.EventAttendee;
import com.dnebinger.subsystem.events.model.RelatedEvent;
import com.dnebinger.subsystem.events.service.base.EventServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

/**
 * The implementation of the event remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dnebinger.subsystem.events.service.EventService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventServiceBaseImpl
 * @see com.dnebinger.subsystem.events.service.EventServiceUtil
 */
public class EventServiceImpl extends EventServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.dnebinger.subsystem.events.service.EventServiceUtil} to access the event remote service.
	 */

    public Event getEvent(final long eventId) {
        return eventLocalService.fetchEvent(eventId);
    }

    public List<Event> getEvents() {
        return eventLocalService.getEvents(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<RelatedEvent> getRelatedEvents(final long eventId) {
        return relatedEventLocalService.getRelatedEvents(eventId);
    }

    public List<EventAttendee> getEventAttendees(final long eventId) {
        return eventAttendeeLocalService.getEventAttendees(eventId);
    }

    private static final Log _log = LogFactoryUtil.getLog(EventServiceImpl.class);

}