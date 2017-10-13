
package com.dnebinger.subsystem.events.admin.search;

import com.dnebinger.subsystem.events.model.Event;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * class EventNameComparator: A comparator for events by name.
 *
 * @author dnebinger
 */
public class EventNameComparator extends OrderByComparator<Event> {

	public static final String ORDER_BY_ASC =
		"name ASC";

	public static final String ORDER_BY_DESC =
		"name DESC";

	public static final String[] ORDER_BY_FIELDS =
		{"name"};

	public EventNameComparator() {
		this(false);
	}

	public EventNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Event event1, Event event2) {
		String name1 = event1.getName();
		String name2 = event2.getName();

		int value = name1.compareTo(name2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}