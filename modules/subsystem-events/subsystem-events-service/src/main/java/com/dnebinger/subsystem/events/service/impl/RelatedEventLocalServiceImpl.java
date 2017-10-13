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

package com.dnebinger.subsystem.events.service.impl;

import com.dnebinger.subsystem.events.model.RelatedEvent;
import com.dnebinger.subsystem.events.service.base.RelatedEventLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.List;

/**
 * The implementation of the related event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.dnebinger.subsystem.events.service.RelatedEventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RelatedEventLocalServiceBaseImpl
 * @see com.dnebinger.subsystem.events.service.RelatedEventLocalServiceUtil
 */
public class RelatedEventLocalServiceImpl
	extends RelatedEventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.dnebinger.subsystem.events.service.RelatedEventLocalServiceUtil} to access the related event local service.
	 */

	public List<RelatedEvent> getRelatedEvents(final long eventId) {
		return relatedEventPersistence.findByEventId(eventId);
	}

	/**
	 * addRelatedEvent: Utility method to add a related event record.
	 * @param eventId
	 * @param relatedEventId
	 * @return RelatedEvent The related event instance.
	 */
	public RelatedEvent addRelatedEvent(final long eventId, final long relatedEventId) {
		RelatedEvent evt = createRelatedEvent(counterLocalService.increment(RelatedEvent.class.getName()));

		evt.setEventId(eventId);
		evt.setRelatedEventId(relatedEventId);

		return addRelatedEvent(evt);
	}

	/**
	 * saveRelatedEvents: Saves all of the related events.
	 * @param eventId
	 * @param relatedIds
	 */
	public void saveRelatedEvents(final long eventId, final String[] relatedIds) {
		List<RelatedEvent> relEvents = getRelatedEvents(eventId);

		if ((relEvents != null) && (! relEvents.isEmpty())) {
			for (RelatedEvent relEvent : relEvents) {
				deleteRelatedEvent(relEvent);
			}
		}

		if ((relatedIds != null) && (relatedIds.length > 0)) {
			long id;

			for (String relId : relatedIds) {
				id = GetterUtil.getLong(relId.trim());

				if (id > 0) {
					addRelatedEvent(eventId, id);
				}
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(RelatedEventLocalServiceImpl.class);
}