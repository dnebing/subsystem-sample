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

package com.dnebinger.subsystem.events.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.dnebinger.subsystem.events.model.EventAttendee;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EventAttendee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendee
 * @generated
 */
@ProviderType
public class EventAttendeeCacheModel implements CacheModel<EventAttendee>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventAttendeeCacheModel)) {
			return false;
		}

		EventAttendeeCacheModel eventAttendeeCacheModel = (EventAttendeeCacheModel)obj;

		if (surrogateId == eventAttendeeCacheModel.surrogateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, surrogateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{surrogateId=");
		sb.append(surrogateId);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventAttendee toEntityModel() {
		EventAttendeeImpl eventAttendeeImpl = new EventAttendeeImpl();

		eventAttendeeImpl.setSurrogateId(surrogateId);
		eventAttendeeImpl.setEventId(eventId);
		eventAttendeeImpl.setUserId(userId);

		eventAttendeeImpl.resetOriginalValues();

		return eventAttendeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surrogateId = objectInput.readLong();

		eventId = objectInput.readLong();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surrogateId);

		objectOutput.writeLong(eventId);

		objectOutput.writeLong(userId);
	}

	public long surrogateId;
	public long eventId;
	public long userId;
}