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

import com.dnebinger.subsystem.events.model.RelatedEvent;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RelatedEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RelatedEvent
 * @generated
 */
@ProviderType
public class RelatedEventCacheModel implements CacheModel<RelatedEvent>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RelatedEventCacheModel)) {
			return false;
		}

		RelatedEventCacheModel relatedEventCacheModel = (RelatedEventCacheModel)obj;

		if (surrogateId == relatedEventCacheModel.surrogateId) {
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
		sb.append(", relatedEventId=");
		sb.append(relatedEventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RelatedEvent toEntityModel() {
		RelatedEventImpl relatedEventImpl = new RelatedEventImpl();

		relatedEventImpl.setSurrogateId(surrogateId);
		relatedEventImpl.setEventId(eventId);
		relatedEventImpl.setRelatedEventId(relatedEventId);

		relatedEventImpl.resetOriginalValues();

		return relatedEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surrogateId = objectInput.readLong();

		eventId = objectInput.readLong();

		relatedEventId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surrogateId);

		objectOutput.writeLong(eventId);

		objectOutput.writeLong(relatedEventId);
	}

	public long surrogateId;
	public long eventId;
	public long relatedEventId;
}