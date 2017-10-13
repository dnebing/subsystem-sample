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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RelatedEventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RelatedEventLocalService
 * @generated
 */
@ProviderType
public class RelatedEventLocalServiceWrapper implements RelatedEventLocalService,
	ServiceWrapper<RelatedEventLocalService> {
	public RelatedEventLocalServiceWrapper(
		RelatedEventLocalService relatedEventLocalService) {
		_relatedEventLocalService = relatedEventLocalService;
	}

	/**
	* Adds the related event to the database. Also notifies the appropriate model listeners.
	*
	* @param relatedEvent the related event
	* @return the related event that was added
	*/
	@Override
	public com.dnebinger.subsystem.events.model.RelatedEvent addRelatedEvent(
		com.dnebinger.subsystem.events.model.RelatedEvent relatedEvent) {
		return _relatedEventLocalService.addRelatedEvent(relatedEvent);
	}

	/**
	* addRelatedEvent: Utility method to add a related event record.
	*
	* @param eventId
	* @param relatedEventId
	* @return RelatedEvent The related event instance.
	*/
	@Override
	public com.dnebinger.subsystem.events.model.RelatedEvent addRelatedEvent(
		long eventId, long relatedEventId) {
		return _relatedEventLocalService.addRelatedEvent(eventId, relatedEventId);
	}

	/**
	* Creates a new related event with the primary key. Does not add the related event to the database.
	*
	* @param surrogateId the primary key for the new related event
	* @return the new related event
	*/
	@Override
	public com.dnebinger.subsystem.events.model.RelatedEvent createRelatedEvent(
		long surrogateId) {
		return _relatedEventLocalService.createRelatedEvent(surrogateId);
	}

	/**
	* Deletes the related event from the database. Also notifies the appropriate model listeners.
	*
	* @param relatedEvent the related event
	* @return the related event that was removed
	*/
	@Override
	public com.dnebinger.subsystem.events.model.RelatedEvent deleteRelatedEvent(
		com.dnebinger.subsystem.events.model.RelatedEvent relatedEvent) {
		return _relatedEventLocalService.deleteRelatedEvent(relatedEvent);
	}

	/**
	* Deletes the related event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event that was removed
	* @throws PortalException if a related event with the primary key could not be found
	*/
	@Override
	public com.dnebinger.subsystem.events.model.RelatedEvent deleteRelatedEvent(
		long surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _relatedEventLocalService.deleteRelatedEvent(surrogateId);
	}

	@Override
	public com.dnebinger.subsystem.events.model.RelatedEvent fetchRelatedEvent(
		long surrogateId) {
		return _relatedEventLocalService.fetchRelatedEvent(surrogateId);
	}

	/**
	* Returns the related event with the primary key.
	*
	* @param surrogateId the primary key of the related event
	* @return the related event
	* @throws PortalException if a related event with the primary key could not be found
	*/
	@Override
	public com.dnebinger.subsystem.events.model.RelatedEvent getRelatedEvent(
		long surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _relatedEventLocalService.getRelatedEvent(surrogateId);
	}

	/**
	* Updates the related event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param relatedEvent the related event
	* @return the related event that was updated
	*/
	@Override
	public com.dnebinger.subsystem.events.model.RelatedEvent updateRelatedEvent(
		com.dnebinger.subsystem.events.model.RelatedEvent relatedEvent) {
		return _relatedEventLocalService.updateRelatedEvent(relatedEvent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _relatedEventLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _relatedEventLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _relatedEventLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _relatedEventLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _relatedEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of related events.
	*
	* @return the number of related events
	*/
	@Override
	public int getRelatedEventsCount() {
		return _relatedEventLocalService.getRelatedEventsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _relatedEventLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _relatedEventLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _relatedEventLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _relatedEventLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<com.dnebinger.subsystem.events.model.RelatedEvent> getRelatedEvents(
		int start, int end) {
		return _relatedEventLocalService.getRelatedEvents(start, end);
	}

	@Override
	public java.util.List<com.dnebinger.subsystem.events.model.RelatedEvent> getRelatedEvents(
		long eventId) {
		return _relatedEventLocalService.getRelatedEvents(eventId);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _relatedEventLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _relatedEventLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* saveRelatedEvents: Saves all of the related events.
	*
	* @param eventId
	* @param relatedIds
	*/
	@Override
	public void saveRelatedEvents(long eventId, java.lang.String[] relatedIds) {
		_relatedEventLocalService.saveRelatedEvents(eventId, relatedIds);
	}

	@Override
	public RelatedEventLocalService getWrappedService() {
		return _relatedEventLocalService;
	}

	@Override
	public void setWrappedService(
		RelatedEventLocalService relatedEventLocalService) {
		_relatedEventLocalService = relatedEventLocalService;
	}

	private RelatedEventLocalService _relatedEventLocalService;
}