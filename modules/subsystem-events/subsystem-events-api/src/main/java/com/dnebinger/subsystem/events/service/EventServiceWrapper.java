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

package com.dnebinger.subsystem.events.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventService
 * @generated
 */
@ProviderType
public class EventServiceWrapper implements EventService,
	ServiceWrapper<EventService> {
	public EventServiceWrapper(EventService eventService) {
		_eventService = eventService;
	}

	@Override
	public com.dnebinger.subsystem.events.model.Event getEvent(long eventId) {
		return _eventService.getEvent(eventId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _eventService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.dnebinger.subsystem.events.model.EventAttendee> getEventAttendees(
		long eventId) {
		return _eventService.getEventAttendees(eventId);
	}

	@Override
	public java.util.List<com.dnebinger.subsystem.events.model.Event> getEvents() {
		return _eventService.getEvents();
	}

	@Override
	public java.util.List<com.dnebinger.subsystem.events.model.RelatedEvent> getRelatedEvents(
		long eventId) {
		return _eventService.getRelatedEvents(eventId);
	}

	@Override
	public EventService getWrappedService() {
		return _eventService;
	}

	@Override
	public void setWrappedService(EventService eventService) {
		_eventService = eventService;
	}

	private EventService _eventService;
}