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

package com.dnebinger.subsystem.events.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for EventAttendee. This utility wraps
 * {@link com.dnebinger.subsystem.events.service.impl.EventAttendeeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendeeLocalService
 * @see com.dnebinger.subsystem.events.service.base.EventAttendeeLocalServiceBaseImpl
 * @see com.dnebinger.subsystem.events.service.impl.EventAttendeeLocalServiceImpl
 * @generated
 */
@ProviderType
public class EventAttendeeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.dnebinger.subsystem.events.service.impl.EventAttendeeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the event attendee to the database. Also notifies the appropriate model listeners.
	*
	* @param eventAttendee the event attendee
	* @return the event attendee that was added
	*/
	public static com.dnebinger.subsystem.events.model.EventAttendee addEventAttendee(
		com.dnebinger.subsystem.events.model.EventAttendee eventAttendee) {
		return getService().addEventAttendee(eventAttendee);
	}

	/**
	* Creates a new event attendee with the primary key. Does not add the event attendee to the database.
	*
	* @param surrogateId the primary key for the new event attendee
	* @return the new event attendee
	*/
	public static com.dnebinger.subsystem.events.model.EventAttendee createEventAttendee(
		long surrogateId) {
		return getService().createEventAttendee(surrogateId);
	}

	/**
	* Deletes the event attendee from the database. Also notifies the appropriate model listeners.
	*
	* @param eventAttendee the event attendee
	* @return the event attendee that was removed
	*/
	public static com.dnebinger.subsystem.events.model.EventAttendee deleteEventAttendee(
		com.dnebinger.subsystem.events.model.EventAttendee eventAttendee) {
		return getService().deleteEventAttendee(eventAttendee);
	}

	/**
	* Deletes the event attendee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surrogateId the primary key of the event attendee
	* @return the event attendee that was removed
	* @throws PortalException if a event attendee with the primary key could not be found
	*/
	public static com.dnebinger.subsystem.events.model.EventAttendee deleteEventAttendee(
		long surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEventAttendee(surrogateId);
	}

	public static com.dnebinger.subsystem.events.model.EventAttendee fetchEventAttendee(
		long surrogateId) {
		return getService().fetchEventAttendee(surrogateId);
	}

	/**
	* Returns the event attendee with the primary key.
	*
	* @param surrogateId the primary key of the event attendee
	* @return the event attendee
	* @throws PortalException if a event attendee with the primary key could not be found
	*/
	public static com.dnebinger.subsystem.events.model.EventAttendee getEventAttendee(
		long surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEventAttendee(surrogateId);
	}

	/**
	* Updates the event attendee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventAttendee the event attendee
	* @return the event attendee that was updated
	*/
	public static com.dnebinger.subsystem.events.model.EventAttendee updateEventAttendee(
		com.dnebinger.subsystem.events.model.EventAttendee eventAttendee) {
		return getService().updateEventAttendee(eventAttendee);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of event attendees.
	*
	* @return the number of event attendees
	*/
	public static int getEventAttendeesCount() {
		return getService().getEventAttendeesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dnebinger.subsystem.events.model.impl.EventAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dnebinger.subsystem.events.model.impl.EventAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the event attendees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dnebinger.subsystem.events.model.impl.EventAttendeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event attendees
	* @param end the upper bound of the range of event attendees (not inclusive)
	* @return the range of event attendees
	*/
	public static java.util.List<com.dnebinger.subsystem.events.model.EventAttendee> getEventAttendees(
		int start, int end) {
		return getService().getEventAttendees(start, end);
	}

	public static java.util.List<com.dnebinger.subsystem.events.model.EventAttendee> getEventAttendees(
		long eventId) {
		return getService().getEventAttendees(eventId);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static EventAttendeeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EventAttendeeLocalService, EventAttendeeLocalService> _serviceTracker =
		ServiceTrackerFactory.open(EventAttendeeLocalService.class);
}