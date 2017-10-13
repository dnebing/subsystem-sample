
package com.dnebinger.subsystem.events.admin.portlet;

import com.dnebinger.subsystem.events.admin.constants.EventsAdminPortletKeys;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.EditPortletProvider;
import com.liferay.portal.kernel.portlet.ManagePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;
import org.osgi.service.component.annotations.Component;

/**
 * class EventEditPortletProvider: Defines the edit event portlet provider details for the Event entity.
 *
 * @author dnebinger
 */
@Component(
	immediate = true,
	property = {"model.class.name=com.dnebinger.subsystem.events.model.Event"},
	service = {
		EditPortletProvider.class, ManagePortletProvider.class,
		ViewPortletProvider.class
	}
)
public class EventEditPortletProvider
	extends BasePortletProvider
	implements EditPortletProvider, ManagePortletProvider, ViewPortletProvider {

	@Override
	public String getPortletName() {
		return EventsAdminPortletKeys.EventsAdmin;
	}

}