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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Event}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Event
 * @generated
 */
@ProviderType
public class EventWrapper implements Event, ModelWrapper<Event> {
	public EventWrapper(Event event) {
		_event = event;
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
		attributes.put("name", getName());
		attributes.put("occursOn", getOccursOn());
		attributes.put("endsOn", getEndsOn());
		attributes.put("adultOnly", getAdultOnly());
		attributes.put("maxOccupants", getMaxOccupants());
		attributes.put("description", getDescription());
		attributes.put("floor", getFloor());
		attributes.put("room", getRoom());
		attributes.put("organizer", getOrganizer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date occursOn = (Date)attributes.get("occursOn");

		if (occursOn != null) {
			setOccursOn(occursOn);
		}

		Date endsOn = (Date)attributes.get("endsOn");

		if (endsOn != null) {
			setEndsOn(endsOn);
		}

		Boolean adultOnly = (Boolean)attributes.get("adultOnly");

		if (adultOnly != null) {
			setAdultOnly(adultOnly);
		}

		Integer maxOccupants = (Integer)attributes.get("maxOccupants");

		if (maxOccupants != null) {
			setMaxOccupants(maxOccupants);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer floor = (Integer)attributes.get("floor");

		if (floor != null) {
			setFloor(floor);
		}

		String room = (String)attributes.get("room");

		if (room != null) {
			setRoom(room);
		}

		Long organizer = (Long)attributes.get("organizer");

		if (organizer != null) {
			setOrganizer(organizer);
		}
	}

	@Override
	public Event toEscapedModel() {
		return new EventWrapper(_event.toEscapedModel());
	}

	@Override
	public Event toUnescapedModel() {
		return new EventWrapper(_event.toUnescapedModel());
	}

	/**
	* Returns the adult only of this event.
	*
	* @return the adult only of this event
	*/
	@Override
	public boolean getAdultOnly() {
		return _event.getAdultOnly();
	}

	/**
	* getSelected: Doesn't really do much but it will inject a default boolean of false into
	* the json representation of our object.
	*
	* @return boolean Always returns <code>false</code>.
	*/
	@Override
	public boolean getSelected() {
		return _event.getSelected();
	}

	/**
	* Returns <code>true</code> if this event is adult only.
	*
	* @return <code>true</code> if this event is adult only; <code>false</code> otherwise
	*/
	@Override
	public boolean isAdultOnly() {
		return _event.isAdultOnly();
	}

	@Override
	public boolean isCachedModel() {
		return _event.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _event.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _event.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _event.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Event> toCacheModel() {
		return _event.toCacheModel();
	}

	@Override
	public int compareTo(Event event) {
		return _event.compareTo(event);
	}

	/**
	* Returns the floor of this event.
	*
	* @return the floor of this event
	*/
	@Override
	public int getFloor() {
		return _event.getFloor();
	}

	/**
	* getId: Return an integer of the id since the json conversion of our long id is returned as a string.
	*
	* @return int The integer version of the event id.
	*/
	@Override
	public int getId() {
		return _event.getId();
	}

	/**
	* Returns the max occupants of this event.
	*
	* @return the max occupants of this event
	*/
	@Override
	public int getMaxOccupants() {
		return _event.getMaxOccupants();
	}

	@Override
	public int hashCode() {
		return _event.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _event.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EventWrapper((Event)_event.clone());
	}

	/**
	* getDateDisplay: Returns the display date string for the event.
	*
	* @return String The display date string.
	*/
	@Override
	public java.lang.String getDateDisplay() {
		return _event.getDateDisplay();
	}

	/**
	* Returns the description of this event.
	*
	* @return the description of this event
	*/
	@Override
	public java.lang.String getDescription() {
		return _event.getDescription();
	}

	/**
	* getLocation: Returns the location as a simple string.
	*
	* @return String The location string.
	*/
	@Override
	public java.lang.String getLocation() {
		return _event.getLocation();
	}

	/**
	* Returns the name of this event.
	*
	* @return the name of this event
	*/
	@Override
	public java.lang.String getName() {
		return _event.getName();
	}

	/**
	* getOrganizerName: Return the event organizer name.
	*
	* @return String The organizer name.
	*/
	@Override
	public java.lang.String getOrganizerName() {
		return _event.getOrganizerName();
	}

	/**
	* Returns the room of this event.
	*
	* @return the room of this event
	*/
	@Override
	public java.lang.String getRoom() {
		return _event.getRoom();
	}

	/**
	* Returns the uuid of this event.
	*
	* @return the uuid of this event
	*/
	@Override
	public java.lang.String getUuid() {
		return _event.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _event.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _event.toXmlString();
	}

	/**
	* Returns the ends on of this event.
	*
	* @return the ends on of this event
	*/
	@Override
	public Date getEndsOn() {
		return _event.getEndsOn();
	}

	/**
	* Returns the occurs on of this event.
	*
	* @return the occurs on of this event
	*/
	@Override
	public Date getOccursOn() {
		return _event.getOccursOn();
	}

	/**
	* Returns the event ID of this event.
	*
	* @return the event ID of this event
	*/
	@Override
	public long getEventId() {
		return _event.getEventId();
	}

	/**
	* Returns the organizer of this event.
	*
	* @return the organizer of this event
	*/
	@Override
	public long getOrganizer() {
		return _event.getOrganizer();
	}

	/**
	* Returns the primary key of this event.
	*
	* @return the primary key of this event
	*/
	@Override
	public long getPrimaryKey() {
		return _event.getPrimaryKey();
	}

	@Override
	public void persist() {
		_event.persist();
	}

	/**
	* Sets whether this event is adult only.
	*
	* @param adultOnly the adult only of this event
	*/
	@Override
	public void setAdultOnly(boolean adultOnly) {
		_event.setAdultOnly(adultOnly);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_event.setCachedModel(cachedModel);
	}

	/**
	* Sets the description of this event.
	*
	* @param description the description of this event
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_event.setDescription(description);
	}

	/**
	* Sets the ends on of this event.
	*
	* @param endsOn the ends on of this event
	*/
	@Override
	public void setEndsOn(Date endsOn) {
		_event.setEndsOn(endsOn);
	}

	/**
	* Sets the event ID of this event.
	*
	* @param eventId the event ID of this event
	*/
	@Override
	public void setEventId(long eventId) {
		_event.setEventId(eventId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_event.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_event.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_event.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the floor of this event.
	*
	* @param floor the floor of this event
	*/
	@Override
	public void setFloor(int floor) {
		_event.setFloor(floor);
	}

	/**
	* Sets the max occupants of this event.
	*
	* @param maxOccupants the max occupants of this event
	*/
	@Override
	public void setMaxOccupants(int maxOccupants) {
		_event.setMaxOccupants(maxOccupants);
	}

	/**
	* Sets the name of this event.
	*
	* @param name the name of this event
	*/
	@Override
	public void setName(java.lang.String name) {
		_event.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_event.setNew(n);
	}

	/**
	* Sets the occurs on of this event.
	*
	* @param occursOn the occurs on of this event
	*/
	@Override
	public void setOccursOn(Date occursOn) {
		_event.setOccursOn(occursOn);
	}

	/**
	* Sets the organizer of this event.
	*
	* @param organizer the organizer of this event
	*/
	@Override
	public void setOrganizer(long organizer) {
		_event.setOrganizer(organizer);
	}

	/**
	* Sets the primary key of this event.
	*
	* @param primaryKey the primary key of this event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_event.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_event.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the room of this event.
	*
	* @param room the room of this event
	*/
	@Override
	public void setRoom(java.lang.String room) {
		_event.setRoom(room);
	}

	/**
	* Sets the uuid of this event.
	*
	* @param uuid the uuid of this event
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_event.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventWrapper)) {
			return false;
		}

		EventWrapper eventWrapper = (EventWrapper)obj;

		if (Objects.equals(_event, eventWrapper._event)) {
			return true;
		}

		return false;
	}

	@Override
	public Event getWrappedModel() {
		return _event;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _event.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _event.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_event.resetOriginalValues();
	}

	private final Event _event;
}