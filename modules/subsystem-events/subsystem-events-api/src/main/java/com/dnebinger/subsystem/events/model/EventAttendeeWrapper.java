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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link EventAttendee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendee
 * @generated
 */
@ProviderType
public class EventAttendeeWrapper implements EventAttendee,
	ModelWrapper<EventAttendee> {
	public EventAttendeeWrapper(EventAttendee eventAttendee) {
		_eventAttendee = eventAttendee;
	}

	@Override
	public Class<?> getModelClass() {
		return EventAttendee.class;
	}

	@Override
	public String getModelClassName() {
		return EventAttendee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surrogateId", getSurrogateId());
		attributes.put("eventId", getEventId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surrogateId = (Long)attributes.get("surrogateId");

		if (surrogateId != null) {
			setSurrogateId(surrogateId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public EventAttendee toEscapedModel() {
		return new EventAttendeeWrapper(_eventAttendee.toEscapedModel());
	}

	@Override
	public EventAttendee toUnescapedModel() {
		return new EventAttendeeWrapper(_eventAttendee.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _eventAttendee.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _eventAttendee.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _eventAttendee.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _eventAttendee.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EventAttendee> toCacheModel() {
		return _eventAttendee.toCacheModel();
	}

	@Override
	public int compareTo(EventAttendee eventAttendee) {
		return _eventAttendee.compareTo(eventAttendee);
	}

	@Override
	public int hashCode() {
		return _eventAttendee.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventAttendee.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EventAttendeeWrapper((EventAttendee)_eventAttendee.clone());
	}

	/**
	* getEventName: Returns the name of the event.
	*
	* @return String The name of the event.
	*/
	@Override
	public java.lang.String getEventName() {
		return _eventAttendee.getEventName();
	}

	/**
	* getUserName; Returns the name of the event attendee.
	*
	* @return String The attendee name.
	*/
	@Override
	public java.lang.String getUserName() {
		return _eventAttendee.getUserName();
	}

	/**
	* Returns the user uuid of this event attendee.
	*
	* @return the user uuid of this event attendee
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _eventAttendee.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _eventAttendee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventAttendee.toXmlString();
	}

	/**
	* Returns the event ID of this event attendee.
	*
	* @return the event ID of this event attendee
	*/
	@Override
	public long getEventId() {
		return _eventAttendee.getEventId();
	}

	/**
	* Returns the primary key of this event attendee.
	*
	* @return the primary key of this event attendee
	*/
	@Override
	public long getPrimaryKey() {
		return _eventAttendee.getPrimaryKey();
	}

	/**
	* Returns the surrogate ID of this event attendee.
	*
	* @return the surrogate ID of this event attendee
	*/
	@Override
	public long getSurrogateId() {
		return _eventAttendee.getSurrogateId();
	}

	/**
	* Returns the user ID of this event attendee.
	*
	* @return the user ID of this event attendee
	*/
	@Override
	public long getUserId() {
		return _eventAttendee.getUserId();
	}

	@Override
	public void persist() {
		_eventAttendee.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventAttendee.setCachedModel(cachedModel);
	}

	/**
	* Sets the event ID of this event attendee.
	*
	* @param eventId the event ID of this event attendee
	*/
	@Override
	public void setEventId(long eventId) {
		_eventAttendee.setEventId(eventId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_eventAttendee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_eventAttendee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_eventAttendee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_eventAttendee.setNew(n);
	}

	/**
	* Sets the primary key of this event attendee.
	*
	* @param primaryKey the primary key of this event attendee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventAttendee.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_eventAttendee.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the surrogate ID of this event attendee.
	*
	* @param surrogateId the surrogate ID of this event attendee
	*/
	@Override
	public void setSurrogateId(long surrogateId) {
		_eventAttendee.setSurrogateId(surrogateId);
	}

	/**
	* Sets the user ID of this event attendee.
	*
	* @param userId the user ID of this event attendee
	*/
	@Override
	public void setUserId(long userId) {
		_eventAttendee.setUserId(userId);
	}

	/**
	* Sets the user uuid of this event attendee.
	*
	* @param userUuid the user uuid of this event attendee
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_eventAttendee.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventAttendeeWrapper)) {
			return false;
		}

		EventAttendeeWrapper eventAttendeeWrapper = (EventAttendeeWrapper)obj;

		if (Objects.equals(_eventAttendee, eventAttendeeWrapper._eventAttendee)) {
			return true;
		}

		return false;
	}

	@Override
	public EventAttendee getWrappedModel() {
		return _eventAttendee;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _eventAttendee.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _eventAttendee.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_eventAttendee.resetOriginalValues();
	}

	private final EventAttendee _eventAttendee;
}