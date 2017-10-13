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

import com.dnebinger.subsystem.events.model.EventAttendee;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the event attendee service. This utility wraps {@link com.dnebinger.subsystem.events.service.persistence.impl.EventAttendeePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendeePersistence
 * @see com.dnebinger.subsystem.events.service.persistence.impl.EventAttendeePersistenceImpl
 * @generated
 */
@ProviderType
public class EventAttendeeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EventAttendee eventAttendee) {
		getPersistence().clearCache(eventAttendee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventAttendee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventAttendee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventAttendee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EventAttendee> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EventAttendee update(EventAttendee eventAttendee) {
		return getPersistence().update(eventAttendee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EventAttendee update(EventAttendee eventAttendee,
		ServiceContext serviceContext) {
		return getPersistence().update(eventAttendee, serviceContext);
	}

	/**
	* Returns all the event attendees where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching event attendees
	*/
	public static List<EventAttendee> findByEventId(long eventId) {
		return getPersistence().findByEventId(eventId);
	}

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
	public static List<EventAttendee> findByEventId(long eventId, int start,
		int end) {
		return getPersistence().findByEventId(eventId, start, end);
	}

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
	public static List<EventAttendee> findByEventId(long eventId, int start,
		int end, OrderByComparator<EventAttendee> orderByComparator) {
		return getPersistence()
				   .findByEventId(eventId, start, end, orderByComparator);
	}

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
	public static List<EventAttendee> findByEventId(long eventId, int start,
		int end, OrderByComparator<EventAttendee> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEventId(eventId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first event attendee in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event attendee
	* @throws NoSuchEventAttendeeException if a matching event attendee could not be found
	*/
	public static EventAttendee findByEventId_First(long eventId,
		OrderByComparator<EventAttendee> orderByComparator)
		throws com.dnebinger.subsystem.events.exception.NoSuchEventAttendeeException {
		return getPersistence().findByEventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the first event attendee in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event attendee, or <code>null</code> if a matching event attendee could not be found
	*/
	public static EventAttendee fetchByEventId_First(long eventId,
		OrderByComparator<EventAttendee> orderByComparator) {
		return getPersistence().fetchByEventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the last event attendee in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event attendee
	* @throws NoSuchEventAttendeeException if a matching event attendee could not be found
	*/
	public static EventAttendee findByEventId_Last(long eventId,
		OrderByComparator<EventAttendee> orderByComparator)
		throws com.dnebinger.subsystem.events.exception.NoSuchEventAttendeeException {
		return getPersistence().findByEventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the last event attendee in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event attendee, or <code>null</code> if a matching event attendee could not be found
	*/
	public static EventAttendee fetchByEventId_Last(long eventId,
		OrderByComparator<EventAttendee> orderByComparator) {
		return getPersistence().fetchByEventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the event attendees before and after the current event attendee in the ordered set where eventId = &#63;.
	*
	* @param surrogateId the primary key of the current event attendee
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event attendee
	* @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	*/
	public static EventAttendee[] findByEventId_PrevAndNext(long surrogateId,
		long eventId, OrderByComparator<EventAttendee> orderByComparator)
		throws com.dnebinger.subsystem.events.exception.NoSuchEventAttendeeException {
		return getPersistence()
				   .findByEventId_PrevAndNext(surrogateId, eventId,
			orderByComparator);
	}

	/**
	* Removes all the event attendees where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	*/
	public static void removeByEventId(long eventId) {
		getPersistence().removeByEventId(eventId);
	}

	/**
	* Returns the number of event attendees where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching event attendees
	*/
	public static int countByEventId(long eventId) {
		return getPersistence().countByEventId(eventId);
	}

	/**
	* Caches the event attendee in the entity cache if it is enabled.
	*
	* @param eventAttendee the event attendee
	*/
	public static void cacheResult(EventAttendee eventAttendee) {
		getPersistence().cacheResult(eventAttendee);
	}

	/**
	* Caches the event attendees in the entity cache if it is enabled.
	*
	* @param eventAttendees the event attendees
	*/
	public static void cacheResult(List<EventAttendee> eventAttendees) {
		getPersistence().cacheResult(eventAttendees);
	}

	/**
	* Creates a new event attendee with the primary key. Does not add the event attendee to the database.
	*
	* @param surrogateId the primary key for the new event attendee
	* @return the new event attendee
	*/
	public static EventAttendee create(long surrogateId) {
		return getPersistence().create(surrogateId);
	}

	/**
	* Removes the event attendee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surrogateId the primary key of the event attendee
	* @return the event attendee that was removed
	* @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	*/
	public static EventAttendee remove(long surrogateId)
		throws com.dnebinger.subsystem.events.exception.NoSuchEventAttendeeException {
		return getPersistence().remove(surrogateId);
	}

	public static EventAttendee updateImpl(EventAttendee eventAttendee) {
		return getPersistence().updateImpl(eventAttendee);
	}

	/**
	* Returns the event attendee with the primary key or throws a {@link NoSuchEventAttendeeException} if it could not be found.
	*
	* @param surrogateId the primary key of the event attendee
	* @return the event attendee
	* @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	*/
	public static EventAttendee findByPrimaryKey(long surrogateId)
		throws com.dnebinger.subsystem.events.exception.NoSuchEventAttendeeException {
		return getPersistence().findByPrimaryKey(surrogateId);
	}

	/**
	* Returns the event attendee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surrogateId the primary key of the event attendee
	* @return the event attendee, or <code>null</code> if a event attendee with the primary key could not be found
	*/
	public static EventAttendee fetchByPrimaryKey(long surrogateId) {
		return getPersistence().fetchByPrimaryKey(surrogateId);
	}

	public static java.util.Map<java.io.Serializable, EventAttendee> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the event attendees.
	*
	* @return the event attendees
	*/
	public static List<EventAttendee> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EventAttendee> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EventAttendee> findAll(int start, int end,
		OrderByComparator<EventAttendee> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EventAttendee> findAll(int start, int end,
		OrderByComparator<EventAttendee> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the event attendees from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of event attendees.
	*
	* @return the number of event attendees
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EventAttendeePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EventAttendeePersistence, EventAttendeePersistence> _serviceTracker =
		ServiceTrackerFactory.open(EventAttendeePersistence.class);
}