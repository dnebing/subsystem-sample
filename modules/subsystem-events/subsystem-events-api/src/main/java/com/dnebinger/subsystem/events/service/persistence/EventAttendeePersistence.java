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

package com.dnebinger.subsystem.events.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.dnebinger.subsystem.events.exception.NoSuchEventAttendeeException;
import com.dnebinger.subsystem.events.model.EventAttendee;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the event attendee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dnebinger.subsystem.events.service.persistence.impl.EventAttendeePersistenceImpl
 * @see EventAttendeeUtil
 * @generated
 */
@ProviderType
public interface EventAttendeePersistence extends BasePersistence<EventAttendee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventAttendeeUtil} to access the event attendee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the event attendees where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching event attendees
	*/
	public java.util.List<EventAttendee> findByEventId(long eventId);

	/**
	* Returns a range of all the event attendees where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of event attendees
	* @param end the upper bound of the range of event attendees (not inclusive)
	* @return the range of matching event attendees
	*/
	public java.util.List<EventAttendee> findByEventId(long eventId, int start,
		int end);

	/**
	* Returns an ordered range of all the event attendees where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of event attendees
	* @param end the upper bound of the range of event attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event attendees
	*/
	public java.util.List<EventAttendee> findByEventId(long eventId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventAttendee> orderByComparator);

	/**
	* Returns an ordered range of all the event attendees where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of event attendees
	* @param end the upper bound of the range of event attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching event attendees
	*/
	public java.util.List<EventAttendee> findByEventId(long eventId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventAttendee> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first event attendee in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event attendee
	* @throws NoSuchEventAttendeeException if a matching event attendee could not be found
	*/
	public EventAttendee findByEventId_First(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventAttendee> orderByComparator)
		throws NoSuchEventAttendeeException;

	/**
	* Returns the first event attendee in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event attendee, or <code>null</code> if a matching event attendee could not be found
	*/
	public EventAttendee fetchByEventId_First(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventAttendee> orderByComparator);

	/**
	* Returns the last event attendee in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event attendee
	* @throws NoSuchEventAttendeeException if a matching event attendee could not be found
	*/
	public EventAttendee findByEventId_Last(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventAttendee> orderByComparator)
		throws NoSuchEventAttendeeException;

	/**
	* Returns the last event attendee in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event attendee, or <code>null</code> if a matching event attendee could not be found
	*/
	public EventAttendee fetchByEventId_Last(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventAttendee> orderByComparator);

	/**
	* Returns the event attendees before and after the current event attendee in the ordered set where eventId = &#63;.
	*
	* @param surrogateId the primary key of the current event attendee
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event attendee
	* @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	*/
	public EventAttendee[] findByEventId_PrevAndNext(long surrogateId,
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventAttendee> orderByComparator)
		throws NoSuchEventAttendeeException;

	/**
	* Removes all the event attendees where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	*/
	public void removeByEventId(long eventId);

	/**
	* Returns the number of event attendees where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching event attendees
	*/
	public int countByEventId(long eventId);

	/**
	* Caches the event attendee in the entity cache if it is enabled.
	*
	* @param eventAttendee the event attendee
	*/
	public void cacheResult(EventAttendee eventAttendee);

	/**
	* Caches the event attendees in the entity cache if it is enabled.
	*
	* @param eventAttendees the event attendees
	*/
	public void cacheResult(java.util.List<EventAttendee> eventAttendees);

	/**
	* Creates a new event attendee with the primary key. Does not add the event attendee to the database.
	*
	* @param surrogateId the primary key for the new event attendee
	* @return the new event attendee
	*/
	public EventAttendee create(long surrogateId);

	/**
	* Removes the event attendee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surrogateId the primary key of the event attendee
	* @return the event attendee that was removed
	* @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	*/
	public EventAttendee remove(long surrogateId)
		throws NoSuchEventAttendeeException;

	public EventAttendee updateImpl(EventAttendee eventAttendee);

	/**
	* Returns the event attendee with the primary key or throws a {@link NoSuchEventAttendeeException} if it could not be found.
	*
	* @param surrogateId the primary key of the event attendee
	* @return the event attendee
	* @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	*/
	public EventAttendee findByPrimaryKey(long surrogateId)
		throws NoSuchEventAttendeeException;

	/**
	* Returns the event attendee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surrogateId the primary key of the event attendee
	* @return the event attendee, or <code>null</code> if a event attendee with the primary key could not be found
	*/
	public EventAttendee fetchByPrimaryKey(long surrogateId);

	@Override
	public java.util.Map<java.io.Serializable, EventAttendee> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the event attendees.
	*
	* @return the event attendees
	*/
	public java.util.List<EventAttendee> findAll();

	/**
	* Returns a range of all the event attendees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event attendees
	* @param end the upper bound of the range of event attendees (not inclusive)
	* @return the range of event attendees
	*/
	public java.util.List<EventAttendee> findAll(int start, int end);

	/**
	* Returns an ordered range of all the event attendees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event attendees
	* @param end the upper bound of the range of event attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event attendees
	*/
	public java.util.List<EventAttendee> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventAttendee> orderByComparator);

	/**
	* Returns an ordered range of all the event attendees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event attendees
	* @param end the upper bound of the range of event attendees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of event attendees
	*/
	public java.util.List<EventAttendee> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventAttendee> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the event attendees from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of event attendees.
	*
	* @return the number of event attendees
	*/
	public int countAll();
}