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

package com.dnebinger.subsystem.events.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.dnebinger.subsystem.events.exception.NoSuchRelatedEventException;
import com.dnebinger.subsystem.events.model.RelatedEvent;
import com.dnebinger.subsystem.events.model.impl.RelatedEventImpl;
import com.dnebinger.subsystem.events.model.impl.RelatedEventModelImpl;
import com.dnebinger.subsystem.events.service.persistence.RelatedEventPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the related event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RelatedEventPersistence
 * @see com.dnebinger.subsystem.events.service.persistence.RelatedEventUtil
 * @generated
 */
@ProviderType
public class RelatedEventPersistenceImpl extends BasePersistenceImpl<RelatedEvent>
	implements RelatedEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RelatedEventUtil} to access the related event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RelatedEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
			RelatedEventModelImpl.FINDER_CACHE_ENABLED, RelatedEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
			RelatedEventModelImpl.FINDER_CACHE_ENABLED, RelatedEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
			RelatedEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID = new FinderPath(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
			RelatedEventModelImpl.FINDER_CACHE_ENABLED, RelatedEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID =
		new FinderPath(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
			RelatedEventModelImpl.FINDER_CACHE_ENABLED, RelatedEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventId",
			new String[] { Long.class.getName() },
			RelatedEventModelImpl.EVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTID = new FinderPath(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
			RelatedEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the related events where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching related events
	 */
	@Override
	public List<RelatedEvent> findByEventId(long eventId) {
		return findByEventId(eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RelatedEvent> findByEventId(long eventId, int start, int end) {
		return findByEventId(eventId, start, end, null);
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
	@Override
	public List<RelatedEvent> findByEventId(long eventId, int start, int end,
		OrderByComparator<RelatedEvent> orderByComparator) {
		return findByEventId(eventId, start, end, orderByComparator, true);
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
	@Override
	public List<RelatedEvent> findByEventId(long eventId, int start, int end,
		OrderByComparator<RelatedEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID;
			finderArgs = new Object[] { eventId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID;
			finderArgs = new Object[] { eventId, start, end, orderByComparator };
		}

		List<RelatedEvent> list = null;

		if (retrieveFromCache) {
			list = (List<RelatedEvent>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RelatedEvent relatedEvent : list) {
					if ((eventId != relatedEvent.getEventId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RELATEDEVENT_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RelatedEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				if (!pagination) {
					list = (List<RelatedEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RelatedEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first related event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching related event
	 * @throws NoSuchRelatedEventException if a matching related event could not be found
	 */
	@Override
	public RelatedEvent findByEventId_First(long eventId,
		OrderByComparator<RelatedEvent> orderByComparator)
		throws NoSuchRelatedEventException {
		RelatedEvent relatedEvent = fetchByEventId_First(eventId,
				orderByComparator);

		if (relatedEvent != null) {
			return relatedEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRelatedEventException(msg.toString());
	}

	/**
	 * Returns the first related event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching related event, or <code>null</code> if a matching related event could not be found
	 */
	@Override
	public RelatedEvent fetchByEventId_First(long eventId,
		OrderByComparator<RelatedEvent> orderByComparator) {
		List<RelatedEvent> list = findByEventId(eventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last related event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching related event
	 * @throws NoSuchRelatedEventException if a matching related event could not be found
	 */
	@Override
	public RelatedEvent findByEventId_Last(long eventId,
		OrderByComparator<RelatedEvent> orderByComparator)
		throws NoSuchRelatedEventException {
		RelatedEvent relatedEvent = fetchByEventId_Last(eventId,
				orderByComparator);

		if (relatedEvent != null) {
			return relatedEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRelatedEventException(msg.toString());
	}

	/**
	 * Returns the last related event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching related event, or <code>null</code> if a matching related event could not be found
	 */
	@Override
	public RelatedEvent fetchByEventId_Last(long eventId,
		OrderByComparator<RelatedEvent> orderByComparator) {
		int count = countByEventId(eventId);

		if (count == 0) {
			return null;
		}

		List<RelatedEvent> list = findByEventId(eventId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RelatedEvent[] findByEventId_PrevAndNext(long surrogateId,
		long eventId, OrderByComparator<RelatedEvent> orderByComparator)
		throws NoSuchRelatedEventException {
		RelatedEvent relatedEvent = findByPrimaryKey(surrogateId);

		Session session = null;

		try {
			session = openSession();

			RelatedEvent[] array = new RelatedEventImpl[3];

			array[0] = getByEventId_PrevAndNext(session, relatedEvent, eventId,
					orderByComparator, true);

			array[1] = relatedEvent;

			array[2] = getByEventId_PrevAndNext(session, relatedEvent, eventId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RelatedEvent getByEventId_PrevAndNext(Session session,
		RelatedEvent relatedEvent, long eventId,
		OrderByComparator<RelatedEvent> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RELATEDEVENT_WHERE);

		query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(RelatedEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(relatedEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RelatedEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the related events where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	@Override
	public void removeByEventId(long eventId) {
		for (RelatedEvent relatedEvent : findByEventId(eventId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(relatedEvent);
		}
	}

	/**
	 * Returns the number of related events where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching related events
	 */
	@Override
	public int countByEventId(long eventId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTID;

		Object[] finderArgs = new Object[] { eventId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RELATEDEVENT_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EVENTID_EVENTID_2 = "relatedEvent.eventId = ?";

	public RelatedEventPersistenceImpl() {
		setModelClass(RelatedEvent.class);
	}

	/**
	 * Caches the related event in the entity cache if it is enabled.
	 *
	 * @param relatedEvent the related event
	 */
	@Override
	public void cacheResult(RelatedEvent relatedEvent) {
		entityCache.putResult(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
			RelatedEventImpl.class, relatedEvent.getPrimaryKey(), relatedEvent);

		relatedEvent.resetOriginalValues();
	}

	/**
	 * Caches the related events in the entity cache if it is enabled.
	 *
	 * @param relatedEvents the related events
	 */
	@Override
	public void cacheResult(List<RelatedEvent> relatedEvents) {
		for (RelatedEvent relatedEvent : relatedEvents) {
			if (entityCache.getResult(
						RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
						RelatedEventImpl.class, relatedEvent.getPrimaryKey()) == null) {
				cacheResult(relatedEvent);
			}
			else {
				relatedEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all related events.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RelatedEventImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the related event.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RelatedEvent relatedEvent) {
		entityCache.removeResult(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
			RelatedEventImpl.class, relatedEvent.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RelatedEvent> relatedEvents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RelatedEvent relatedEvent : relatedEvents) {
			entityCache.removeResult(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
				RelatedEventImpl.class, relatedEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new related event with the primary key. Does not add the related event to the database.
	 *
	 * @param surrogateId the primary key for the new related event
	 * @return the new related event
	 */
	@Override
	public RelatedEvent create(long surrogateId) {
		RelatedEvent relatedEvent = new RelatedEventImpl();

		relatedEvent.setNew(true);
		relatedEvent.setPrimaryKey(surrogateId);

		return relatedEvent;
	}

	/**
	 * Removes the related event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surrogateId the primary key of the related event
	 * @return the related event that was removed
	 * @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent remove(long surrogateId)
		throws NoSuchRelatedEventException {
		return remove((Serializable)surrogateId);
	}

	/**
	 * Removes the related event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the related event
	 * @return the related event that was removed
	 * @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent remove(Serializable primaryKey)
		throws NoSuchRelatedEventException {
		Session session = null;

		try {
			session = openSession();

			RelatedEvent relatedEvent = (RelatedEvent)session.get(RelatedEventImpl.class,
					primaryKey);

			if (relatedEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRelatedEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(relatedEvent);
		}
		catch (NoSuchRelatedEventException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected RelatedEvent removeImpl(RelatedEvent relatedEvent) {
		relatedEvent = toUnwrappedModel(relatedEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(relatedEvent)) {
				relatedEvent = (RelatedEvent)session.get(RelatedEventImpl.class,
						relatedEvent.getPrimaryKeyObj());
			}

			if (relatedEvent != null) {
				session.delete(relatedEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (relatedEvent != null) {
			clearCache(relatedEvent);
		}

		return relatedEvent;
	}

	@Override
	public RelatedEvent updateImpl(RelatedEvent relatedEvent) {
		relatedEvent = toUnwrappedModel(relatedEvent);

		boolean isNew = relatedEvent.isNew();

		RelatedEventModelImpl relatedEventModelImpl = (RelatedEventModelImpl)relatedEvent;

		Session session = null;

		try {
			session = openSession();

			if (relatedEvent.isNew()) {
				session.save(relatedEvent);

				relatedEvent.setNew(false);
			}
			else {
				relatedEvent = (RelatedEvent)session.merge(relatedEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!RelatedEventModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { relatedEventModelImpl.getEventId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((relatedEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						relatedEventModelImpl.getOriginalEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);

				args = new Object[] { relatedEventModelImpl.getEventId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);
			}
		}

		entityCache.putResult(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
			RelatedEventImpl.class, relatedEvent.getPrimaryKey(), relatedEvent,
			false);

		relatedEvent.resetOriginalValues();

		return relatedEvent;
	}

	protected RelatedEvent toUnwrappedModel(RelatedEvent relatedEvent) {
		if (relatedEvent instanceof RelatedEventImpl) {
			return relatedEvent;
		}

		RelatedEventImpl relatedEventImpl = new RelatedEventImpl();

		relatedEventImpl.setNew(relatedEvent.isNew());
		relatedEventImpl.setPrimaryKey(relatedEvent.getPrimaryKey());

		relatedEventImpl.setSurrogateId(relatedEvent.getSurrogateId());
		relatedEventImpl.setEventId(relatedEvent.getEventId());
		relatedEventImpl.setRelatedEventId(relatedEvent.getRelatedEventId());

		return relatedEventImpl;
	}

	/**
	 * Returns the related event with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the related event
	 * @return the related event
	 * @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRelatedEventException {
		RelatedEvent relatedEvent = fetchByPrimaryKey(primaryKey);

		if (relatedEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRelatedEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return relatedEvent;
	}

	/**
	 * Returns the related event with the primary key or throws a {@link NoSuchRelatedEventException} if it could not be found.
	 *
	 * @param surrogateId the primary key of the related event
	 * @return the related event
	 * @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent findByPrimaryKey(long surrogateId)
		throws NoSuchRelatedEventException {
		return findByPrimaryKey((Serializable)surrogateId);
	}

	/**
	 * Returns the related event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the related event
	 * @return the related event, or <code>null</code> if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
				RelatedEventImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		RelatedEvent relatedEvent = (RelatedEvent)serializable;

		if (relatedEvent == null) {
			Session session = null;

			try {
				session = openSession();

				relatedEvent = (RelatedEvent)session.get(RelatedEventImpl.class,
						primaryKey);

				if (relatedEvent != null) {
					cacheResult(relatedEvent);
				}
				else {
					entityCache.putResult(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
						RelatedEventImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
					RelatedEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return relatedEvent;
	}

	/**
	 * Returns the related event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surrogateId the primary key of the related event
	 * @return the related event, or <code>null</code> if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent fetchByPrimaryKey(long surrogateId) {
		return fetchByPrimaryKey((Serializable)surrogateId);
	}

	@Override
	public Map<Serializable, RelatedEvent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, RelatedEvent> map = new HashMap<Serializable, RelatedEvent>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			RelatedEvent relatedEvent = fetchByPrimaryKey(primaryKey);

			if (relatedEvent != null) {
				map.put(primaryKey, relatedEvent);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
					RelatedEventImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (RelatedEvent)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RELATEDEVENT_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (RelatedEvent relatedEvent : (List<RelatedEvent>)q.list()) {
				map.put(relatedEvent.getPrimaryKeyObj(), relatedEvent);

				cacheResult(relatedEvent);

				uncachedPrimaryKeys.remove(relatedEvent.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RelatedEventModelImpl.ENTITY_CACHE_ENABLED,
					RelatedEventImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the related events.
	 *
	 * @return the related events
	 */
	@Override
	public List<RelatedEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<RelatedEvent> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<RelatedEvent> findAll(int start, int end,
		OrderByComparator<RelatedEvent> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<RelatedEvent> findAll(int start, int end,
		OrderByComparator<RelatedEvent> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<RelatedEvent> list = null;

		if (retrieveFromCache) {
			list = (List<RelatedEvent>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RELATEDEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RELATEDEVENT;

				if (pagination) {
					sql = sql.concat(RelatedEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RelatedEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<RelatedEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the related events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RelatedEvent relatedEvent : findAll()) {
			remove(relatedEvent);
		}
	}

	/**
	 * Returns the number of related events.
	 *
	 * @return the number of related events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RELATEDEVENT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RelatedEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the related event persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RelatedEventImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RELATEDEVENT = "SELECT relatedEvent FROM RelatedEvent relatedEvent";
	private static final String _SQL_SELECT_RELATEDEVENT_WHERE_PKS_IN = "SELECT relatedEvent FROM RelatedEvent relatedEvent WHERE surrogateId IN (";
	private static final String _SQL_SELECT_RELATEDEVENT_WHERE = "SELECT relatedEvent FROM RelatedEvent relatedEvent WHERE ";
	private static final String _SQL_COUNT_RELATEDEVENT = "SELECT COUNT(relatedEvent) FROM RelatedEvent relatedEvent";
	private static final String _SQL_COUNT_RELATEDEVENT_WHERE = "SELECT COUNT(relatedEvent) FROM RelatedEvent relatedEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "relatedEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RelatedEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RelatedEvent exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RelatedEventPersistenceImpl.class);
}