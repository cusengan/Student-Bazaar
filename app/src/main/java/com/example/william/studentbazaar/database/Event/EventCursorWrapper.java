package com.example.william.studentbazaar.database.Event;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.william.studentbazaar.EventDirectory.Event;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.EventTable.Cols;

import java.util.UUID;

public class EventCursorWrapper extends CursorWrapper {

    public EventCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Event getEvent() {

        String uuidString = getString(getColumnIndex(Cols.UUID));
        String ownerId = getString(getColumnIndex(Cols.OWNERID));
        String name = getString(getColumnIndex(Cols.NAME));
        String description = getString(getColumnIndex(Cols.DESCRIPTION));
        int onDisplay = getInt(getColumnIndex(Cols.ONDISPLAY));

        Event event = new Event(UUID.fromString(uuidString));
        event.setOwnerId(ownerId);
        event.setName(name);
        event.setDescription(description);
        event.setDisplay(onDisplay != 0);

        return event;
    }
}
