<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>

<%@ page import="com.dnebinger.subsystem.events.model.Event" %>
<%@ page import="com.dnebinger.subsystem.events.service.EventLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dnebinger.subsystem.events.model.RelatedEvent" %>
<%@ page import="com.dnebinger.subsystem.events.service.RelatedEventLocalServiceUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.dnebinger.subsystem.events.admin.search.EventSearchTerms" %>
<%@ page import="com.dnebinger.subsystem.events.admin.search.EventSearch" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.dnebinger.subsystem.events.model.Event" %>
<%@ page import="com.dnebinger.subsystem.events.exception.NoSuchEventException" %>
<%@ page import="com.dnebinger.subsystem.events.service.EventLocalServiceUtil" %>
<%@ page import="com.dnebinger.subsystem.events.admin.search.EventDisplayTerms" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />


