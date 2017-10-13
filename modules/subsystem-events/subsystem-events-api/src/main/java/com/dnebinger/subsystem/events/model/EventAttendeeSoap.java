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

package com.dnebinger.subsystem.events.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.dnebinger.subsystem.events.service.http.EventAttendeeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.dnebinger.subsystem.events.service.http.EventAttendeeServiceSoap
 * @generated
 */
@ProviderType
public class EventAttendeeSoap implements Serializable {
	public static EventAttendeeSoap toSoapModel(EventAttendee model) {
		EventAttendeeSoap soapModel = new EventAttendeeSoap();

		soapModel.setSurrogateId(model.getSurrogateId());
		soapModel.setEventId(model.getEventId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static EventAttendeeSoap[] toSoapModels(EventAttendee[] models) {
		EventAttendeeSoap[] soapModels = new EventAttendeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventAttendeeSoap[][] toSoapModels(EventAttendee[][] models) {
		EventAttendeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventAttendeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventAttendeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventAttendeeSoap[] toSoapModels(List<EventAttendee> models) {
		List<EventAttendeeSoap> soapModels = new ArrayList<EventAttendeeSoap>(models.size());

		for (EventAttendee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventAttendeeSoap[soapModels.size()]);
	}

	public EventAttendeeSoap() {
	}

	public long getPrimaryKey() {
		return _surrogateId;
	}

	public void setPrimaryKey(long pk) {
		setSurrogateId(pk);
	}

	public long getSurrogateId() {
		return _surrogateId;
	}

	public void setSurrogateId(long surrogateId) {
		_surrogateId = surrogateId;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _surrogateId;
	private long _eventId;
	private long _userId;
}