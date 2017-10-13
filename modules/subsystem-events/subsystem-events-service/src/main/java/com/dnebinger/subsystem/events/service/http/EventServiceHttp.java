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

package com.dnebinger.subsystem.events.service.http;

import aQute.bnd.annotation.ProviderType;

import com.dnebinger.subsystem.events.service.EventServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link EventServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventServiceSoap
 * @see HttpPrincipal
 * @see EventServiceUtil
 * @generated
 */
@ProviderType
public class EventServiceHttp {
	public static com.dnebinger.subsystem.events.model.Event getEvent(
		HttpPrincipal httpPrincipal, long eventId) {
		try {
			MethodKey methodKey = new MethodKey(EventServiceUtil.class,
					"getEvent", _getEventParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, eventId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.dnebinger.subsystem.events.model.Event)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.dnebinger.subsystem.events.model.Event> getEvents(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(EventServiceUtil.class,
					"getEvents", _getEventsParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.dnebinger.subsystem.events.model.Event>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.dnebinger.subsystem.events.model.RelatedEvent> getRelatedEvents(
		HttpPrincipal httpPrincipal, long eventId) {
		try {
			MethodKey methodKey = new MethodKey(EventServiceUtil.class,
					"getRelatedEvents", _getRelatedEventsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, eventId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.dnebinger.subsystem.events.model.RelatedEvent>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.dnebinger.subsystem.events.model.EventAttendee> getEventAttendees(
		HttpPrincipal httpPrincipal, long eventId) {
		try {
			MethodKey methodKey = new MethodKey(EventServiceUtil.class,
					"getEventAttendees", _getEventAttendeesParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, eventId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.dnebinger.subsystem.events.model.EventAttendee>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EventServiceHttp.class);
	private static final Class<?>[] _getEventParameterTypes0 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getEventsParameterTypes1 = new Class[] {  };
	private static final Class<?>[] _getRelatedEventsParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getEventAttendeesParameterTypes3 = new Class[] {
			long.class
		};
}