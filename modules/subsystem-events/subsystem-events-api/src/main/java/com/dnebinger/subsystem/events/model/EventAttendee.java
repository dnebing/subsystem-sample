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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the EventAttendee service. Represents a row in the &quot;SUBSYS_EventAttendee&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendeeModel
 * @see com.dnebinger.subsystem.events.model.impl.EventAttendeeImpl
 * @see com.dnebinger.subsystem.events.model.impl.EventAttendeeModelImpl
 * @generated
 */
@ImplementationClassName("com.dnebinger.subsystem.events.model.impl.EventAttendeeImpl")
@ProviderType
public interface EventAttendee extends EventAttendeeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.dnebinger.subsystem.events.model.impl.EventAttendeeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EventAttendee, Long> SURROGATE_ID_ACCESSOR = new Accessor<EventAttendee, Long>() {
			@Override
			public Long get(EventAttendee eventAttendee) {
				return eventAttendee.getSurrogateId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EventAttendee> getTypeClass() {
				return EventAttendee.class;
			}
		};

	/**
	* getEventName: Returns the name of the event.
	*
	* @return String The name of the event.
	*/
	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getEventName();

	/**
	* getUserName; Returns the name of the event attendee.
	*
	* @return String The attendee name.
	*/
	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getUserName();
}