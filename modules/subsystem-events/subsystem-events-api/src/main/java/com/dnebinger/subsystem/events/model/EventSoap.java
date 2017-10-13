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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.dnebinger.subsystem.events.service.http.EventServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.dnebinger.subsystem.events.service.http.EventServiceSoap
 * @generated
 */
@ProviderType
public class EventSoap implements Serializable {
	public static EventSoap toSoapModel(Event model) {
		EventSoap soapModel = new EventSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEventId(model.getEventId());
		soapModel.setName(model.getName());
		soapModel.setOccursOn(model.getOccursOn());
		soapModel.setEndsOn(model.getEndsOn());
		soapModel.setAdultOnly(model.getAdultOnly());
		soapModel.setMaxOccupants(model.getMaxOccupants());
		soapModel.setDescription(model.getDescription());
		soapModel.setFloor(model.getFloor());
		soapModel.setRoom(model.getRoom());
		soapModel.setOrganizer(model.getOrganizer());

		return soapModel;
	}

	public static EventSoap[] toSoapModels(Event[] models) {
		EventSoap[] soapModels = new EventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[][] toSoapModels(Event[][] models) {
		EventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[] toSoapModels(List<Event> models) {
		List<EventSoap> soapModels = new ArrayList<EventSoap>(models.size());

		for (Event model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventSoap[soapModels.size()]);
	}

	public EventSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getOccursOn() {
		return _occursOn;
	}

	public void setOccursOn(Date occursOn) {
		_occursOn = occursOn;
	}

	public Date getEndsOn() {
		return _endsOn;
	}

	public void setEndsOn(Date endsOn) {
		_endsOn = endsOn;
	}

	public boolean getAdultOnly() {
		return _adultOnly;
	}

	public boolean isAdultOnly() {
		return _adultOnly;
	}

	public void setAdultOnly(boolean adultOnly) {
		_adultOnly = adultOnly;
	}

	public int getMaxOccupants() {
		return _maxOccupants;
	}

	public void setMaxOccupants(int maxOccupants) {
		_maxOccupants = maxOccupants;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getFloor() {
		return _floor;
	}

	public void setFloor(int floor) {
		_floor = floor;
	}

	public String getRoom() {
		return _room;
	}

	public void setRoom(String room) {
		_room = room;
	}

	public long getOrganizer() {
		return _organizer;
	}

	public void setOrganizer(long organizer) {
		_organizer = organizer;
	}

	private String _uuid;
	private long _eventId;
	private String _name;
	private Date _occursOn;
	private Date _endsOn;
	private boolean _adultOnly;
	private int _maxOccupants;
	private String _description;
	private int _floor;
	private String _room;
	private long _organizer;
}