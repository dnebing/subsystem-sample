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
 * Provides the local service utility for RelatedEvent. This utility wraps
 * {@link com.dnebinger.subsystem.events.service.impl.RelatedEventLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RelatedEventLocalService
 * @see com.dnebinger.subsystem.events.service.base.RelatedEventLocalServiceBaseImpl
 * @see com.dnebinger.subsystem.events.service.impl.RelatedEventLocalServiceImpl
 * @generated
 */
@ProviderType
public class RelatedEventLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.dnebinger.subsystem.events.service.impl.RelatedEventLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the related event to the database. Also notifies the appropriate model listeners.
	*
	* @param relatedEvent the related event
	* @return the related event that was added
	*/
	public static com.dnebinger.subsystem.events.model.RelatedEvent addRelatedEvent(
		com.dnebinger.subsystem.events.model.RelatedEvent relatedEvent) {
		return getService().addRelatedEvent(relatedEvent);
	}

	/**
	* addRelatedEvent: Utility method to add a related event record.
	*
	* @param eventId
	* @param relatedEventId
	* @return RelatedEvent The related event instance.
	*/
	public static com.dnebinger.subsystem.events.model.RelatedEvent addRelatedEvent(
		long eventId, long relatedEventId) {
		return getService().addRelatedEvent(eventId, relatedEventId);
	}

	/**
	* Creates a new related event with the primary key. Does not add the related event to the database.
	*
	* @param surrogateId the primary key for the new related event
	* @return the new related event
	*/
	public static com.dnebinger.subsystem.events.model.RelatedEvent createRelatedEvent(
		long surrogateId) {
		return getService().createRelatedEvent(surrogateId);
	}

	/**
	* Deletes the related event from the database. Also notifies the appropriate model listeners.
	*
	* @param relatedEvent the related event
	* @return the related event that was removed
	*/
	public static com.dnebinger.subsystem.events.model.RelatedEvent deleteRelatedEvent(
		com.dnebinger.subsystem.events.model.RelatedEvent relatedEvent) {
		return getService().deleteRelatedEvent(relatedEvent);
	}

	/**
	* Deletes the related event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event that was removed
	* @throws PortalException if a related event with the primary key could not be found
	*/
	public static com.dnebinger.subsystem.events.model.RelatedEvent deleteRelatedEvent(
		long surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRelatedEvent(surrogateId);
	}

	public static com.dnebinger.subsystem.events.model.RelatedEvent fetchRelatedEvent(
		long surrogateId) {
		return getService().fetchRelatedEvent(surrogateId);
	}

	/**
	* Returns the related event with the primary key.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event
	* @throws PortalException if a related event with the primary key could not be found
	*/
	public static com.dnebinger.subsystem.events.model.RelatedEvent getRelatedEvent(
		long surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRelatedEvent(surrogateId);
	}

	/**
	* Updates the related event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param relatedEvent the related event
	* @return the related event that was updated
	*/
	public static com.dnebinger.subsystem.events.model.RelatedEvent updateRelatedEvent(
		com.dnebinger.subsystem.events.model.RelatedEvent relatedEvent) {
		return getService().updateRelatedEvent(relatedEvent);
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
	* Returns the number of related events.
	*
	* @return the number of related events
	*/
	public static int getRelatedEventsCount() {
		return getService().getRelatedEventsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dnebinger.subsystem.events.model.impl.RelatedEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dnebinger.subsystem.events.model.impl.RelatedEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the related events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.dnebinger.subsystem.events.model.impl.RelatedEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of related events
	* @param end the upper bound of the range of related events (not inclusive)
	* @return the range of related events
	*/
	public static java.util.List<com.dnebinger.subsystem.events.model.RelatedEvent> getRelatedEvents(
		int start, int end) {
		return getService().getRelatedEvents(start, end);
	}

	public static java.util.List<com.dnebinger.subsystem.events.model.RelatedEvent> getRelatedEvents(
		long eventId) {
		return getService().getRelatedEvents(eventId);
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

	/**
	* saveRelatedEvents: Saves all of the related events.
	*
	* @param eventId
	* @param relatedIds
	*/
	public static void saveRelatedEvents(long eventId,
		java.lang.String[] relatedIds) {
		getService().saveRelatedEvents(eventId, relatedIds);
	}

	public static RelatedEventLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RelatedEventLocalService, RelatedEventLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RelatedEventLocalService.class);
}