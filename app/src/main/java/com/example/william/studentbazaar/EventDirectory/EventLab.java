package com.example.william.studentbazaar.EventDirectory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.william.studentbazaar.User.User;
import com.example.william.studentbazaar.database.Event.EventCursorWrapper;
import com.example.william.studentbazaar.database.DBHelper;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.EventTable.Cols.DESCRIPTION;
import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.EventTable.Cols.NAME;
import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.EventTable.Cols.ONDISPLAY;
import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.EventTable.Cols.OWNERID;

public class EventLab {

    private static EventLab sEventLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static EventLab get(Context context) {
        if (sEventLab == null) {
            sEventLab = new EventLab(context);
        }

        return sEventLab;
    }

    private EventLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DBHelper(mContext)
                .getWritableDatabase();

    }

    public void addEvent(Event i) {
        ContentValues values = getContentValues(i);
        mDatabase.insert(StudentBazaarDbSchema.EventTable.NAME, null, values);
    }

    public List<Event> getEvents() {
        List<Event> Events = new ArrayList<>();
        EventCursorWrapper cursor = queryEvents(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Events.add(cursor.getEvent());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return Events;
    }

    public List<Event> getEvents(User user) {
        List<Event> Events = new ArrayList<>();
        EventCursorWrapper cursor = queryEvents("OWNERID=?", new String[]{user.getStudentId()});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Events.add(cursor.getEvent());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return Events;
    }

    public List<Event> getEventsOnDisplay() {
        List<Event> events = new ArrayList<>();
        EventCursorWrapper cursor = queryEvents(ONDISPLAY + " = 1", null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                events.add(cursor.getEvent());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return events;
    }

    public List<Event> getEventsOnDisplay(String query) {
        List<Event> events = new ArrayList<>();
        EventCursorWrapper cursor = queryEvents(ONDISPLAY + " = 1 AND NAME LIKE ?", new String[]{query});
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                events.add(cursor.getEvent());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return events;
    }

    public Event getEvent(UUID id) {
        EventCursorWrapper cursor = queryEvents(
                StudentBazaarDbSchema.EventTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getEvent();
        } finally {
            cursor.close();
        }
    }


    public void updateEvent(Event Event) {
        String uuidString = Event.getId().toString();
        ContentValues values = getContentValues(Event);
        mDatabase.update(StudentBazaarDbSchema.EventTable.NAME, values,
                StudentBazaarDbSchema.EventTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    private EventCursorWrapper queryEvents(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                StudentBazaarDbSchema.EventTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new EventCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Event event) {
        ContentValues values = new ContentValues();
        values.put(StudentBazaarDbSchema.EventTable.Cols.UUID, event.getId().toString());
        values.put(OWNERID, event.getOwnerId());
        values.put(NAME, event.getName());
        values.put(DESCRIPTION, event.getDescription());
        values.put(ONDISPLAY, event.onDisplay());

        return values;
    }
}

