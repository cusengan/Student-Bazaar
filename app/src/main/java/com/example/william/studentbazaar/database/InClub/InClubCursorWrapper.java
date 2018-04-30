package com.example.william.studentbazaar.database.InClub;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.william.studentbazaar.ClubDirectory.InClub;
import com.example.william.studentbazaar.TradeDirectory.Item;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema;

import java.util.UUID;

public class InClubCursorWrapper extends CursorWrapper {

    public InClubCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public InClub getInClub() {

        String uuidString = getString(getColumnIndex(StudentBazaarDbSchema.InClubTable.Cols.UUID));
        String clubId = getString(getColumnIndex(StudentBazaarDbSchema.InClubTable.Cols.CLUBID));
        String studentId = getString(getColumnIndex(StudentBazaarDbSchema.InClubTable.Cols.STUDENTID));

        InClub inClub = new InClub(UUID.fromString(uuidString));
        inClub.setClubId(UUID.fromString(clubId));
        inClub.setStudentId(studentId);

        return inClub;
    }
}
