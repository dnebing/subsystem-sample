create table SUBSYS_Event (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	name VARCHAR(75) null,
	occursOn DATE null,
	endsOn DATE null,
	adultOnly BOOLEAN,
	maxOccupants INTEGER,
	description VARCHAR(75) null,
	floor INTEGER,
	room VARCHAR(75) null,
	organizer LONG
);

create table SUBSYS_EventAttendee (
	surrogateId LONG not null primary key,
	eventId LONG,
	userId LONG
);

create table SUBSYS_RelatedEvent (
	surrogateId LONG not null primary key,
	eventId LONG,
	relatedEventId LONG
);