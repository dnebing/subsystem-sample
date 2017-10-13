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
import com.dnebinger.subsystem.events.model.Event;
import com.dnebinger.subsystem.events.service.EventLocalServiceUtil;
import com.liferay.portal.kernel.json.JSON;

/**
 * The extended model implementation for the RelatedEvent service. Represents a row in the &quot;SUBSYS_RelatedEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dnebinger.subsystem.events.model.RelatedEvent} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class RelatedEventImpl extends RelatedEventBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a related event model instance should use the {@link com.dnebinger.subsystem.events.model.RelatedEvent} interface instead.
	 */
	public RelatedEventImpl() {
	}

	/**
	 * getId: Returns an integer form of the id since json treats the long as a string.
	 * @return int
	 */
	@JSON
	public int getId() {
		return (int) getEventId();
	}

	/**
	 * getRelatedId: Returns an integer form of the related id since json treats the long as a string.
	 * @return int
	 */
	@JSON
	public int getRelatedId() {
		return (int) getRelatedEventId();
	}

	/**
	 * getEventName: Returns the name of the event.
	 * @return String The name of the event.
	 */
	@JSON
	public String getEventName() {
		Event event = EventLocalServiceUtil.fetchEvent(getEventId());

		if (event == null) {
			return "Unnamed";
		}

		return event.getName();
	}

	/**
	 * getRelatedEventName: Returns the name of the related event.
	 * @return String The name of the related event.
	 */
	@JSON
	public String getRelatedEventName() {
		Event event = EventLocalServiceUtil.fetchEvent(getRelatedEventId());

		if (event == null) {
			return "Unnamed";
		}

		return event.getName();
	}
}