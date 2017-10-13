create index IX_523DF34D on SUBSYS_Event (name[$COLUMN_LENGTH:75$]);
create index IX_89B4F7E6 on SUBSYS_Event (uuid_[$COLUMN_LENGTH:75$]);

create index IX_7A55DFDD on SUBSYS_EventAttendee (eventId);

create index IX_E2C0CBDE on SUBSYS_RelatedEvent (eventId);