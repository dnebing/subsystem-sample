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

import com.dnebinger.subsystem.events.exception.NoSuchRelatedEventException;
import com.dnebinger.subsystem.events.model.RelatedEvent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the related event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dnebinger.subsystem.events.service.persistence.impl.RelatedEventPersistenceImpl
 * @see RelatedEventUtil
 * @generated
 */
@ProviderType
public interface RelatedEventPersistence extends BasePersistence<RelatedEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RelatedEventUtil} to access the related event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the related events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching related events
	*/
	public java.util.List<RelatedEvent> findByEventId(long eventId);

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
	public java.util.List<RelatedEvent> findByEventId(long eventId, int start,
		int end);

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
	public java.util.List<RelatedEvent> findByEventId(long eventId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RelatedEvent> orderByComparator);

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
	public java.util.List<RelatedEvent> findByEventId(long eventId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<RelatedEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first related event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching related event
	* @throws NoSuchRelatedEventException if a matching related event could not be found
	*/
	public RelatedEvent findByEventId_First(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<RelatedEvent> orderByComparator)
		throws NoSuchRelatedEventException;

	/**
	* Returns the first related event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching related event, or <code>null</code> if a matching related event could not be found
	*/
	public RelatedEvent fetchByEventId_First(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<RelatedEvent> orderByComparator);

	/**
	* Returns the last related event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching related event
	* @throws NoSuchRelatedEventException if a matching related event could not be found
	*/
	public RelatedEvent findByEventId_Last(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<RelatedEvent> orderByComparator)
		throws NoSuchRelatedEventException;

	/**
	* Returns the last related event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching related event, or <code>null</code> if a matching related event could not be found
	*/
	public RelatedEvent fetchByEventId_Last(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<RelatedEvent> orderByComparator);

	/**
	* Returns the related events before and after the current related event in the ordered set where eventId = &#63;.
	*
	* @param surrogateId the primary key of the current related event
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next related event
	* @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	*/
	public RelatedEvent[] findByEventId_PrevAndNext(long surrogateId,
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<RelatedEvent> orderByComparator)
		throws NoSuchRelatedEventException;

	/**
	* Removes all the related events where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	*/
	public void removeByEventId(long eventId);

	/**
	* Returns the number of related events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching related events
	*/
	public int countByEventId(long eventId);

	/**
	* Caches the related event in the entity cache if it is enabled.
	*
	* @param relatedEvent the related event
	*/
	public void cacheResult(RelatedEvent relatedEvent);

	/**
	* Caches the related events in the entity cache if it is enabled.
	*
	* @param relatedEvents the related events
	*/
	public void cacheResult(java.util.List<RelatedEvent> relatedEvents);

	/**
	* Creates a new related event with the primary key. Does not add the related event to the database.
	*
	* @param surrogateId the primary key for the new related event
	* @return the new related event
	*/
	public RelatedEvent create(long surrogateId);

	/**
	* Removes the related event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event that was removed
	* @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	*/
	public RelatedEvent remove(long surrogateId)
		throws NoSuchRelatedEventException;

	public RelatedEvent updateImpl(RelatedEvent relatedEvent);

	/**
	* Returns the related event with the primary key or throws a {@link NoSuchRelatedEventException} if it could not be found.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event
	* @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	*/
	public RelatedEvent findByPrimaryKey(long surrogateId)
		throws NoSuchRelatedEventException;

	/**
	* Returns the related event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event, or <code>null</code> if a related event with the primary key could not be found
	*/
	public RelatedEvent fetchByPrimaryKey(long surrogateId);

	@Override
	public java.util.Map<java.io.Serializable, RelatedEvent> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the related events.
	*
	* @return the related events
	*/
	public java.util.List<RelatedEvent> findAll();

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
	public java.util.List<RelatedEvent> findAll(int start, int end);

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
	public java.util.List<RelatedEvent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RelatedEvent> orderByComparator);

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
	public java.util.List<RelatedEvent> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RelatedEvent> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the related events from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of related events.
	*
	* @return the number of related events
	*/
	public int countAll();
}