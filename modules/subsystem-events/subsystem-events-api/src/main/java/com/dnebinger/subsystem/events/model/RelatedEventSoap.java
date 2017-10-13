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
 * This class is used by SOAP remote services, specifically {@link com.dnebinger.subsystem.events.service.http.RelatedEventServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.dnebinger.subsystem.events.service.http.RelatedEventServiceSoap
 * @generated
 */
@ProviderType
public class RelatedEventSoap implements Serializable {
	public static RelatedEventSoap toSoapModel(RelatedEvent model) {
		RelatedEventSoap soapModel = new RelatedEventSoap();

		soapModel.setSurrogateId(model.getSurrogateId());
		soapModel.setEventId(model.getEventId());
		soapModel.setRelatedEventId(model.getRelatedEventId());

		return soapModel;
	}

	public static RelatedEventSoap[] toSoapModels(RelatedEvent[] models) {
		RelatedEventSoap[] soapModels = new RelatedEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RelatedEventSoap[][] toSoapModels(RelatedEvent[][] models) {
		RelatedEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RelatedEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RelatedEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RelatedEventSoap[] toSoapModels(List<RelatedEvent> models) {
		List<RelatedEventSoap> soapModels = new ArrayList<RelatedEventSoap>(models.size());

		for (RelatedEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RelatedEventSoap[soapModels.size()]);
	}

	public RelatedEventSoap() {
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

	public long getRelatedEventId() {
		return _relatedEventId;
	}

	public void setRelatedEventId(long relatedEventId) {
		_relatedEventId = relatedEventId;
	}

	private long _surrogateId;
	private long _eventId;
	private long _relatedEventId;
}