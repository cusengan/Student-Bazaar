package com.example.william.studentbazaar.database.Club;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.william.studentbazaar.ClubDirectory.Club;

import java.util.UUID;

import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.ClubTable.*;

public class ClubCursorWrapper extends CursorWrapper {

    public ClubCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Club getClub() {
        String uuidString = getString(getColumnIndex(Cols.UUID));
        String name = getString(getColumnIndex(Cols.NAME));
        String description = getString(getColumnIndex(Cols.DESCRIPTION));

        Club club = new Club(UUID.fromString(uuidString));
        club.setName(name);
        club.setDescription(description);

        return club;
    }
}
