
package com.dnebinger.subsystem.events.admin.portlet.action;

import com.dnebinger.subsystem.events.admin.constants.EventsAdminPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * class EditEventMVCRenderCommand: The MVC render command handler for editing/adding an event.
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + EventsAdminPortletKeys.EventsAdmin,
		"mvc.command.name=/edit_event"
	},
	service = MVCRenderCommand.class
)
public class EditEventMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		return "/edit_event.jsp";
	}

}