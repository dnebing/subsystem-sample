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
 * The extended model interface for the Event service. Represents a row in the &quot;SUBSYS_Event&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EventModel
 * @see com.dnebinger.subsystem.events.model.impl.EventImpl
 * @see com.dnebinger.subsystem.events.model.impl.EventModelImpl
 * @generated
 */
@ImplementationClassName("com.dnebinger.subsystem.events.model.impl.EventImpl")
@ProviderType
public interface Event extends EventModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.dnebinger.subsystem.events.model.impl.EventImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Event, Long> EVENT_ID_ACCESSOR = new Accessor<Event, Long>() {
			@Override
			public Long get(Event event) {
				return event.getEventId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Event> getTypeClass() {
				return Event.class;
			}
		};

	/**
	* getId: Return an integer of the id since the json conversion of our long id is returned as a string.
	*
	* @return int The integer version of the event id.
	*/
	@com.liferay.portal.kernel.json.JSON()
	public int getId();

	/**
	* getSelected: Doesn't really do much but it will inject a default boolean of false into
	* the json representation of our object.
	*
	* @return boolean Always returns <code>false</code>.
	*/
	@com.liferay.portal.kernel.json.JSON()
	public boolean getSelected();

	/**
	* getDateDisplay: Returns the display date string for the event.
	*
	* @return String The display date string.
	*/
	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getDateDisplay();

	/**
	* getLocation: Returns the location as a simple string.
	*
	* @return String The location string.
	*/
	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getLocation();

	/**
	* getOrganizerName: Return the event organizer name.
	*
	* @return String The organizer name.
	*/
	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getOrganizerName();
}