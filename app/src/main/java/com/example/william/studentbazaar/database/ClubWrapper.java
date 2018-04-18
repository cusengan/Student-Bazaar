package com.example.william.studentbazaar.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.william.studentbazaar.Club;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.ClubTable;

import java.util.Date;
import java.util.UUID;

import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.ClubTable.*;

public class ClubWrapper extends CursorWrapper {

    public ClubWrapper(Cursor cursor) {
        super(cursor);
    }

    public Club getClub() {
        String uuidString = getString(getColumnIndex(Cols.UUID));
        String name = getString(getColumnIndex(Cols.NAME));

        Club club = new Club(UUID.fromString(uuidString));
        club.setName(name);

        return club;
    }
}
