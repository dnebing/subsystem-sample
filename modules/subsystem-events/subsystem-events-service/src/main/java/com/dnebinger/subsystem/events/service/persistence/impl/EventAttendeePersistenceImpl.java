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

import com.dnebinger.subsystem.events.exception.NoSuchEventAttendeeException;
import com.dnebinger.subsystem.events.model.EventAttendee;
import com.dnebinger.subsystem.events.model.impl.EventAttendeeImpl;
import com.dnebinger.subsystem.events.model.impl.EventAttendeeModelImpl;
import com.dnebinger.subsystem.events.service.persistence.EventAttendeePersistence;

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
 * The persistence implementation for the event attendee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendeePersistence
 * @see com.dnebinger.subsystem.events.service.persistence.EventAttendeeUtil
 * @generated
 */
@ProviderType
public class EventAttendeePersistenceImpl extends BasePersistenceImpl<EventAttendee>
	implements EventAttendeePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventAttendeeUtil} to access the event attendee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventAttendeeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			EventAttendeeModelImpl.FINDER_CACHE_ENABLED,
			EventAttendeeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			EventAttendeeModelImpl.FINDER_CACHE_ENABLED,
			EventAttendeeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			EventAttendeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID = new FinderPath(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			EventAttendeeModelImpl.FINDER_CACHE_ENABLED,
			EventAttendeeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID =
		new FinderPath(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			EventAttendeeModelImpl.FINDER_CACHE_ENABLED,
			EventAttendeeImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEventId", new String[] { Long.class.getName() },
			EventAttendeeModelImpl.EVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTID = new FinderPath(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			EventAttendeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the event attendees where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching event attendees
	 */
	@Override
	public List<EventAttendee> findByEventId(long eventId) {
		return findByEventId(eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EventAttendee> findByEventId(long eventId, int start, int end) {
		return findByEventId(eventId, start, end, null);
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
	@Override
	public List<EventAttendee> findByEventId(long eventId, int start, int end,
		OrderByComparator<EventAttendee> orderByComparator) {
		return findByEventId(eventId, start, end, orderByComparator, true);
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
	@Override
	public List<EventAttendee> findByEventId(long eventId, int start, int end,
		OrderByComparator<EventAttendee> orderByComparator,
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

		List<EventAttendee> list = null;

		if (retrieveFromCache) {
			list = (List<EventAttendee>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EventAttendee eventAttendee : list) {
					if ((eventId != eventAttendee.getEventId())) {
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

			query.append(_SQL_SELECT_EVENTATTENDEE_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventAttendeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				if (!pagination) {
					list = (List<EventAttendee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EventAttendee>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first event attendee in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event attendee
	 * @throws NoSuchEventAttendeeException if a matching event attendee could not be found
	 */
	@Override
	public EventAttendee findByEventId_First(long eventId,
		OrderByComparator<EventAttendee> orderByComparator)
		throws NoSuchEventAttendeeException {
		EventAttendee eventAttendee = fetchByEventId_First(eventId,
				orderByComparator);

		if (eventAttendee != null) {
			return eventAttendee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventAttendeeException(msg.toString());
	}

	/**
	 * Returns the first event attendee in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event attendee, or <code>null</code> if a matching event attendee could not be found
	 */
	@Override
	public EventAttendee fetchByEventId_First(long eventId,
		OrderByComparator<EventAttendee> orderByComparator) {
		List<EventAttendee> list = findByEventId(eventId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event attendee in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event attendee
	 * @throws NoSuchEventAttendeeException if a matching event attendee could not be found
	 */
	@Override
	public EventAttendee findByEventId_Last(long eventId,
		OrderByComparator<EventAttendee> orderByComparator)
		throws NoSuchEventAttendeeException {
		EventAttendee eventAttendee = fetchByEventId_Last(eventId,
				orderByComparator);

		if (eventAttendee != null) {
			return eventAttendee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventAttendeeException(msg.toString());
	}

	/**
	 * Returns the last event attendee in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event attendee, or <code>null</code> if a matching event attendee could not be found
	 */
	@Override
	public EventAttendee fetchByEventId_Last(long eventId,
		OrderByComparator<EventAttendee> orderByComparator) {
		int count = countByEventId(eventId);

		if (count == 0) {
			return null;
		}

		List<EventAttendee> list = findByEventId(eventId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EventAttendee[] findByEventId_PrevAndNext(long surrogateId,
		long eventId, OrderByComparator<EventAttendee> orderByComparator)
		throws NoSuchEventAttendeeException {
		EventAttendee eventAttendee = findByPrimaryKey(surrogateId);

		Session session = null;

		try {
			session = openSession();

			EventAttendee[] array = new EventAttendeeImpl[3];

			array[0] = getByEventId_PrevAndNext(session, eventAttendee,
					eventId, orderByComparator, true);

			array[1] = eventAttendee;

			array[2] = getByEventId_PrevAndNext(session, eventAttendee,
					eventId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventAttendee getByEventId_PrevAndNext(Session session,
		EventAttendee eventAttendee, long eventId,
		OrderByComparator<EventAttendee> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTATTENDEE_WHERE);

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
			query.append(EventAttendeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventAttendee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventAttendee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event attendees where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	@Override
	public void removeByEventId(long eventId) {
		for (EventAttendee eventAttendee : findByEventId(eventId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventAttendee);
		}
	}

	/**
	 * Returns the number of event attendees where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching event attendees
	 */
	@Override
	public int countByEventId(long eventId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTID;

		Object[] finderArgs = new Object[] { eventId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTATTENDEE_WHERE);

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

	private static final String _FINDER_COLUMN_EVENTID_EVENTID_2 = "eventAttendee.eventId = ?";

	public EventAttendeePersistenceImpl() {
		setModelClass(EventAttendee.class);
	}

	/**
	 * Caches the event attendee in the entity cache if it is enabled.
	 *
	 * @param eventAttendee the event attendee
	 */
	@Override
	public void cacheResult(EventAttendee eventAttendee) {
		entityCache.putResult(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			EventAttendeeImpl.class, eventAttendee.getPrimaryKey(),
			eventAttendee);

		eventAttendee.resetOriginalValues();
	}

	/**
	 * Caches the event attendees in the entity cache if it is enabled.
	 *
	 * @param eventAttendees the event attendees
	 */
	@Override
	public void cacheResult(List<EventAttendee> eventAttendees) {
		for (EventAttendee eventAttendee : eventAttendees) {
			if (entityCache.getResult(
						EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
						EventAttendeeImpl.class, eventAttendee.getPrimaryKey()) == null) {
				cacheResult(eventAttendee);
			}
			else {
				eventAttendee.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event attendees.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EventAttendeeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event attendee.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventAttendee eventAttendee) {
		entityCache.removeResult(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			EventAttendeeImpl.class, eventAttendee.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EventAttendee> eventAttendees) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventAttendee eventAttendee : eventAttendees) {
			entityCache.removeResult(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
				EventAttendeeImpl.class, eventAttendee.getPrimaryKey());
		}
	}

	/**
	 * Creates a new event attendee with the primary key. Does not add the event attendee to the database.
	 *
	 * @param surrogateId the primary key for the new event attendee
	 * @return the new event attendee
	 */
	@Override
	public EventAttendee create(long surrogateId) {
		EventAttendee eventAttendee = new EventAttendeeImpl();

		eventAttendee.setNew(true);
		eventAttendee.setPrimaryKey(surrogateId);

		return eventAttendee;
	}

	/**
	 * Removes the event attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surrogateId the primary key of the event attendee
	 * @return the event attendee that was removed
	 * @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee remove(long surrogateId)
		throws NoSuchEventAttendeeException {
		return remove((Serializable)surrogateId);
	}

	/**
	 * Removes the event attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event attendee
	 * @return the event attendee that was removed
	 * @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee remove(Serializable primaryKey)
		throws NoSuchEventAttendeeException {
		Session session = null;

		try {
			session = openSession();

			EventAttendee eventAttendee = (EventAttendee)session.get(EventAttendeeImpl.class,
					primaryKey);

			if (eventAttendee == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventAttendeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventAttendee);
		}
		catch (NoSuchEventAttendeeException nsee) {
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
	protected EventAttendee removeImpl(EventAttendee eventAttendee) {
		eventAttendee = toUnwrappedModel(eventAttendee);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventAttendee)) {
				eventAttendee = (EventAttendee)session.get(EventAttendeeImpl.class,
						eventAttendee.getPrimaryKeyObj());
			}

			if (eventAttendee != null) {
				session.delete(eventAttendee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventAttendee != null) {
			clearCache(eventAttendee);
		}

		return eventAttendee;
	}

	@Override
	public EventAttendee updateImpl(EventAttendee eventAttendee) {
		eventAttendee = toUnwrappedModel(eventAttendee);

		boolean isNew = eventAttendee.isNew();

		EventAttendeeModelImpl eventAttendeeModelImpl = (EventAttendeeModelImpl)eventAttendee;

		Session session = null;

		try {
			session = openSession();

			if (eventAttendee.isNew()) {
				session.save(eventAttendee);

				eventAttendee.setNew(false);
			}
			else {
				eventAttendee = (EventAttendee)session.merge(eventAttendee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EventAttendeeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { eventAttendeeModelImpl.getEventId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((eventAttendeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventAttendeeModelImpl.getOriginalEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);

				args = new Object[] { eventAttendeeModelImpl.getEventId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);
			}
		}

		entityCache.putResult(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
			EventAttendeeImpl.class, eventAttendee.getPrimaryKey(),
			eventAttendee, false);

		eventAttendee.resetOriginalValues();

		return eventAttendee;
	}

	protected EventAttendee toUnwrappedModel(EventAttendee eventAttendee) {
		if (eventAttendee instanceof EventAttendeeImpl) {
			return eventAttendee;
		}

		EventAttendeeImpl eventAttendeeImpl = new EventAttendeeImpl();

		eventAttendeeImpl.setNew(eventAttendee.isNew());
		eventAttendeeImpl.setPrimaryKey(eventAttendee.getPrimaryKey());

		eventAttendeeImpl.setSurrogateId(eventAttendee.getSurrogateId());
		eventAttendeeImpl.setEventId(eventAttendee.getEventId());
		eventAttendeeImpl.setUserId(eventAttendee.getUserId());

		return eventAttendeeImpl;
	}

	/**
	 * Returns the event attendee with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event attendee
	 * @return the event attendee
	 * @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventAttendeeException {
		EventAttendee eventAttendee = fetchByPrimaryKey(primaryKey);

		if (eventAttendee == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventAttendeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventAttendee;
	}

	/**
	 * Returns the event attendee with the primary key or throws a {@link NoSuchEventAttendeeException} if it could not be found.
	 *
	 * @param surrogateId the primary key of the event attendee
	 * @return the event attendee
	 * @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee findByPrimaryKey(long surrogateId)
		throws NoSuchEventAttendeeException {
		return findByPrimaryKey((Serializable)surrogateId);
	}

	/**
	 * Returns the event attendee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event attendee
	 * @return the event attendee, or <code>null</code> if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
				EventAttendeeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EventAttendee eventAttendee = (EventAttendee)serializable;

		if (eventAttendee == null) {
			Session session = null;

			try {
				session = openSession();

				eventAttendee = (EventAttendee)session.get(EventAttendeeImpl.class,
						primaryKey);

				if (eventAttendee != null) {
					cacheResult(eventAttendee);
				}
				else {
					entityCache.putResult(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
						EventAttendeeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
					EventAttendeeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventAttendee;
	}

	/**
	 * Returns the event attendee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surrogateId the primary key of the event attendee
	 * @return the event attendee, or <code>null</code> if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee fetchByPrimaryKey(long surrogateId) {
		return fetchByPrimaryKey((Serializable)surrogateId);
	}

	@Override
	public Map<Serializable, EventAttendee> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EventAttendee> map = new HashMap<Serializable, EventAttendee>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EventAttendee eventAttendee = fetchByPrimaryKey(primaryKey);

			if (eventAttendee != null) {
				map.put(primaryKey, eventAttendee);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
					EventAttendeeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EventAttendee)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EVENTATTENDEE_WHERE_PKS_IN);

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

			for (EventAttendee eventAttendee : (List<EventAttendee>)q.list()) {
				map.put(eventAttendee.getPrimaryKeyObj(), eventAttendee);

				cacheResult(eventAttendee);

				uncachedPrimaryKeys.remove(eventAttendee.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EventAttendeeModelImpl.ENTITY_CACHE_ENABLED,
					EventAttendeeImpl.class, primaryKey, nullModel);
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
	 * Returns all the event attendees.
	 *
	 * @return the event attendees
	 */
	@Override
	public List<EventAttendee> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EventAttendee> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<EventAttendee> findAll(int start, int end,
		OrderByComparator<EventAttendee> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<EventAttendee> findAll(int start, int end,
		OrderByComparator<EventAttendee> orderByComparator,
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

		List<EventAttendee> list = null;

		if (retrieveFromCache) {
			list = (List<EventAttendee>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EVENTATTENDEE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTATTENDEE;

				if (pagination) {
					sql = sql.concat(EventAttendeeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventAttendee>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EventAttendee>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the event attendees from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EventAttendee eventAttendee : findAll()) {
			remove(eventAttendee);
		}
	}

	/**
	 * Returns the number of event attendees.
	 *
	 * @return the number of event attendees
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVENTATTENDEE);

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
		return EventAttendeeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the event attendee persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EventAttendeeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EVENTATTENDEE = "SELECT eventAttendee FROM EventAttendee eventAttendee";
	private static final String _SQL_SELECT_EVENTATTENDEE_WHERE_PKS_IN = "SELECT eventAttendee FROM EventAttendee eventAttendee WHERE surrogateId IN (";
	private static final String _SQL_SELECT_EVENTATTENDEE_WHERE = "SELECT eventAttendee FROM EventAttendee eventAttendee WHERE ";
	private static final String _SQL_COUNT_EVENTATTENDEE = "SELECT COUNT(eventAttendee) FROM EventAttendee eventAttendee";
	private static final String _SQL_COUNT_EVENTATTENDEE_WHERE = "SELECT COUNT(eventAttendee) FROM EventAttendee eventAttendee WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventAttendee.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventAttendee exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventAttendee exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EventAttendeePersistenceImpl.class);
}