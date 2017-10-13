# README

This is a sample project used to test out the OSGi Subsystems spec in Liferay.

There are 3 modules, two from ServiceBuilder (an API and a service module) along with a Liferay MVC portlet module.

These three modules can be deployed individually to Liferay.

In the modules directory, there's also a subsystem-events-esa project which will build an ESA archive out of
the three modules.  When the OSGi Subsystems components are deployed to Liferay, you can deploy this ESA archive
to get all of the modules deployed in one artifact.

See my blog post at https://web.liferay.com/web/user.26526/blog/-/blogs/osgi-subsystems-and-why-you-want-them
for more details.