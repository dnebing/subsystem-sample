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
 * This class is a wrapper for {@link RelatedEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RelatedEvent
 * @generated
 */
@ProviderType
public class RelatedEventWrapper implements RelatedEvent,
	ModelWrapper<RelatedEvent> {
	public RelatedEventWrapper(RelatedEvent relatedEvent) {
		_relatedEvent = relatedEvent;
	}

	@Override
	public Class<?> getModelClass() {
		return RelatedEvent.class;
	}

	@Override
	public String getModelClassName() {
		return RelatedEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surrogateId", getSurrogateId());
		attributes.put("eventId", getEventId());
		attributes.put("relatedEventId", getRelatedEventId());

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

		Long relatedEventId = (Long)attributes.get("relatedEventId");

		if (relatedEventId != null) {
			setRelatedEventId(relatedEventId);
		}
	}

	@Override
	public RelatedEvent toEscapedModel() {
		return new RelatedEventWrapper(_relatedEvent.toEscapedModel());
	}

	@Override
	public RelatedEvent toUnescapedModel() {
		return new RelatedEventWrapper(_relatedEvent.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _relatedEvent.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _relatedEvent.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _relatedEvent.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _relatedEvent.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<RelatedEvent> toCacheModel() {
		return _relatedEvent.toCacheModel();
	}

	@Override
	public int compareTo(RelatedEvent relatedEvent) {
		return _relatedEvent.compareTo(relatedEvent);
	}

	/**
	* getId: Returns an integer form of the id since json treats the long as a string.
	*
	* @return int
	*/
	@Override
	public int getId() {
		return _relatedEvent.getId();
	}

	/**
	* getRelatedId: Returns an integer form of the related id since json treats the long as a string.
	*
	* @return int
	*/
	@Override
	public int getRelatedId() {
		return _relatedEvent.getRelatedId();
	}

	@Override
	public int hashCode() {
		return _relatedEvent.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _relatedEvent.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new RelatedEventWrapper((RelatedEvent)_relatedEvent.clone());
	}

	/**
	* getEventName: Returns the name of the event.
	*
	* @return String The name of the event.
	*/
	@Override
	public java.lang.String getEventName() {
		return _relatedEvent.getEventName();
	}

	/**
	* getRelatedEventName: Returns the name of the related event.
	*
	* @return String The name of the related event.
	*/
	@Override
	public java.lang.String getRelatedEventName() {
		return _relatedEvent.getRelatedEventName();
	}

	@Override
	public java.lang.String toString() {
		return _relatedEvent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _relatedEvent.toXmlString();
	}

	/**
	* Returns the event ID of this related event.
	*
	* @return the event ID of this related event
	*/
	@Override
	public long getEventId() {
		return _relatedEvent.getEventId();
	}

	/**
	* Returns the primary key of this related event.
	*
	* @return the primary key of this related event
	*/
	@Override
	public long getPrimaryKey() {
		return _relatedEvent.getPrimaryKey();
	}

	/**
	* Returns the related event ID of this related event.
	*
	* @return the related event ID of this related event
	*/
	@Override
	public long getRelatedEventId() {
		return _relatedEvent.getRelatedEventId();
	}

	/**
	* Returns the surrogate ID of this related event.
	*
	* @return the surrogate ID of this related event
	*/
	@Override
	public long getSurrogateId() {
		return _relatedEvent.getSurrogateId();
	}

	@Override
	public void persist() {
		_relatedEvent.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_relatedEvent.setCachedModel(cachedModel);
	}

	/**
	* Sets the event ID of this related event.
	*
	* @param eventId the event ID of this related event
	*/
	@Override
	public void setEventId(long eventId) {
		_relatedEvent.setEventId(eventId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_relatedEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_relatedEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_relatedEvent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_relatedEvent.setNew(n);
	}

	/**
	* Sets the primary key of this related event.
	*
	* @param primaryKey the primary key of this related event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_relatedEvent.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_relatedEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the related event ID of this related event.
	*
	* @param relatedEventId the related event ID of this related event
	*/
	@Override
	public void setRelatedEventId(long relatedEventId) {
		_relatedEvent.setRelatedEventId(relatedEventId);
	}

	/**
	* Sets the surrogate ID of this related event.
	*
	* @param surrogateId the surrogate ID of this related event
	*/
	@Override
	public void setSurrogateId(long surrogateId) {
		_relatedEvent.setSurrogateId(surrogateId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RelatedEventWrapper)) {
			return false;
		}

		RelatedEventWrapper relatedEventWrapper = (RelatedEventWrapper)obj;

		if (Objects.equals(_relatedEvent, relatedEventWrapper._relatedEvent)) {
			return true;
		}

		return false;
	}

	@Override
	public RelatedEvent getWrappedModel() {
		return _relatedEvent;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _relatedEvent.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _relatedEvent.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_relatedEvent.resetOriginalValues();
	}

	private final RelatedEvent _relatedEvent;
}