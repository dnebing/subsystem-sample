package com.dnebinger.subsystem.events.admin.portlet;

import com.dnebinger.subsystem.events.admin.constants.EventsAdminPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author dnebinger
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.display-name=Events Admin Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EventsAdminPortletKeys.EventsAdmin,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EventsAdminPortlet extends MVCPortlet {
}