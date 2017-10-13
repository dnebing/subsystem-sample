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

import com.dnebinger.subsystem.events.model.RelatedEvent;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the related event service. This utility wraps {@link com.dnebinger.subsystem.events.service.persistence.impl.RelatedEventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RelatedEventPersistence
 * @see com.dnebinger.subsystem.events.service.persistence.impl.RelatedEventPersistenceImpl
 * @generated
 */
@ProviderType
public class RelatedEventUtil {
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
	public static void clearCache(RelatedEvent relatedEvent) {
		getPersistence().clearCache(relatedEvent);
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
	public static List<RelatedEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RelatedEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RelatedEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RelatedEvent> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RelatedEvent update(RelatedEvent relatedEvent) {
		return getPersistence().update(relatedEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RelatedEvent update(RelatedEvent relatedEvent,
		ServiceContext serviceContext) {
		return getPersistence().update(relatedEvent, serviceContext);
	}

	/**
	* Returns all the related events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching related events
	*/
	public static List<RelatedEvent> findByEventId(long eventId) {
		return getPersistence().findByEventId(eventId);
	}

	/**
	* Returns a range of all the related events where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RelatedEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of related events
	* @param end the upper bound of the range of related events (not inclusive)
	* @return the range of matching related events
	*/
	public static List<RelatedEvent> findByEventId(long eventId, int start,
		int end) {
		return getPersistence().findByEventId(eventId, start, end);
	}

	/**
	* Returns an ordered range of all the related events where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RelatedEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of related events
	* @param end the upper bound of the range of related events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching related events
	*/
	public static List<RelatedEvent> findByEventId(long eventId, int start,
		int end, OrderByComparator<RelatedEvent> orderByComparator) {
		return getPersistence()
				   .findByEventId(eventId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the related events where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RelatedEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of related events
	* @param end the upper bound of the range of related events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching related events
	*/
	public static List<RelatedEvent> findByEventId(long eventId, int start,
		int end, OrderByComparator<RelatedEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEventId(eventId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first related event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching related event
	* @throws NoSuchRelatedEventException if a matching related event could not be found
	*/
	public static RelatedEvent findByEventId_First(long eventId,
		OrderByComparator<RelatedEvent> orderByComparator)
		throws com.dnebinger.subsystem.events.exception.NoSuchRelatedEventException {
		return getPersistence().findByEventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the first related event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching related event, or <code>null</code> if a matching related event could not be found
	*/
	public static RelatedEvent fetchByEventId_First(long eventId,
		OrderByComparator<RelatedEvent> orderByComparator) {
		return getPersistence().fetchByEventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the last related event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching related event
	* @throws NoSuchRelatedEventException if a matching related event could not be found
	*/
	public static RelatedEvent findByEventId_Last(long eventId,
		OrderByComparator<RelatedEvent> orderByComparator)
		throws com.dnebinger.subsystem.events.exception.NoSuchRelatedEventException {
		return getPersistence().findByEventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the last related event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching related event, or <code>null</code> if a matching related event could not be found
	*/
	public static RelatedEvent fetchByEventId_Last(long eventId,
		OrderByComparator<RelatedEvent> orderByComparator) {
		return getPersistence().fetchByEventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the related events before and after the current related event in the ordered set where eventId = &#63;.
	*
	* @param surrogateId the primary key of the current related event
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next related event
	* @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	*/
	public static RelatedEvent[] findByEventId_PrevAndNext(long surrogateId,
		long eventId, OrderByComparator<RelatedEvent> orderByComparator)
		throws com.dnebinger.subsystem.events.exception.NoSuchRelatedEventException {
		return getPersistence()
				   .findByEventId_PrevAndNext(surrogateId, eventId,
			orderByComparator);
	}

	/**
	* Removes all the related events where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	*/
	public static void removeByEventId(long eventId) {
		getPersistence().removeByEventId(eventId);
	}

	/**
	* Returns the number of related events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching related events
	*/
	public static int countByEventId(long eventId) {
		return getPersistence().countByEventId(eventId);
	}

	/**
	* Caches the related event in the entity cache if it is enabled.
	*
	* @param relatedEvent the related event
	*/
	public static void cacheResult(RelatedEvent relatedEvent) {
		getPersistence().cacheResult(relatedEvent);
	}

	/**
	* Caches the related events in the entity cache if it is enabled.
	*
	* @param relatedEvents the related events
	*/
	public static void cacheResult(List<RelatedEvent> relatedEvents) {
		getPersistence().cacheResult(relatedEvents);
	}

	/**
	* Creates a new related event with the primary key. Does not add the related event to the database.
	*
	* @param surrogateId the primary key for the new related event
	* @return the new related event
	*/
	public static RelatedEvent create(long surrogateId) {
		return getPersistence().create(surrogateId);
	}

	/**
	* Removes the related event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event that was removed
	* @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	*/
	public static RelatedEvent remove(long surrogateId)
		throws com.dnebinger.subsystem.events.exception.NoSuchRelatedEventException {
		return getPersistence().remove(surrogateId);
	}

	public static RelatedEvent updateImpl(RelatedEvent relatedEvent) {
		return getPersistence().updateImpl(relatedEvent);
	}

	/**
	* Returns the related event with the primary key or throws a {@link NoSuchRelatedEventException} if it could not be found.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event
	* @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	*/
	public static RelatedEvent findByPrimaryKey(long surrogateId)
		throws com.dnebinger.subsystem.events.exception.NoSuchRelatedEventException {
		return getPersistence().findByPrimaryKey(surrogateId);
	}

	/**
	* Returns the related event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event, or <code>null</code> if a related event with the primary key could not be found
	*/
	public static RelatedEvent fetchByPrimaryKey(long surrogateId) {
		return getPersistence().fetchByPrimaryKey(surrogateId);
	}

	public static java.util.Map<java.io.Serializable, RelatedEvent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the related events.
	*
	* @return the related events
	*/
	public static List<RelatedEvent> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the related events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RelatedEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of related events
	* @param end the upper bound of the range of related events (not inclusive)
	* @return the range of related events
	*/
	public static List<RelatedEvent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the related events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RelatedEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of related events
	* @param end the upper bound of the range of related events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of related events
	*/
	public static List<RelatedEvent> findAll(int start, int end,
		OrderByComparator<RelatedEvent> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the related events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RelatedEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of related events
	* @param end the upper bound of the range of related events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of related events
	*/
	public static List<RelatedEvent> findAll(int start, int end,
		OrderByComparator<RelatedEvent> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the related events from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of related events.
	*
	* @return the number of related events
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RelatedEventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RelatedEventPersistence, RelatedEventPersistence> _serviceTracker =
		ServiceTrackerFactory.open(RelatedEventPersistence.class);
}