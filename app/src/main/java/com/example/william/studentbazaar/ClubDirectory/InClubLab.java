package com.example.william.studentbazaar.ClubDirectory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.william.studentbazaar.ClubDirectory.InClub;
import com.example.william.studentbazaar.database.DBHelper;
import com.example.william.studentbazaar.database.InClub.InClubCursorWrapper;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.InClubTable;
import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.InClubTable.Cols.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class InClubLab {
    private static InClubLab sInClubLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static InClubLab get(Context context) {
        if (sInClubLab == null) {
            sInClubLab = new InClubLab(context);
        }

        return sInClubLab;
    }

    private InClubLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DBHelper(mContext)
                .getWritableDatabase();

    }

    public void addInClub(InClub c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(InClubTable.NAME, null, values);
    }

    public List<InClub> getInClubs() {
        List<InClub> inClubs = new ArrayList<>();
        InClubCursorWrapper cursor = queryInClubs(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                inClubs.add(cursor.getInClub());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return inClubs;
    }

    public List<InClub> getMembersInClub(UUID clubId) {
        List<InClub> inClubs = new ArrayList<>();
        InClubCursorWrapper cursor = queryInClubs(
                InClubTable.Cols.CLUBID + " = ?",
                new String[]{clubId.toString()}
        );
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                inClubs.add(cursor.getInClub());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return inClubs;
    }

    public InClub getInClub(InClub inClub) {
        List<InClub> inClubs = new ArrayList<>();
        InClubCursorWrapper cursor = queryInClubs(InClubTable.Cols.CLUBID + " = ? AND " + InClubTable.Cols.STUDENTID + " = ?",
                new String[]{inClub.getClubId().toString(), inClub.getStudentId()});
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getInClub();
        } finally {
            cursor.close();
        }
    }


    public void updateInClub(InClub club) {
        String uuidString = club.getId().toString();
        ContentValues values = getContentValues(club);
        mDatabase.update(InClubTable.NAME, values,
                InClubTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    public void deleteInClub(InClub inClub) {
        mDatabase.delete(InClubTable.NAME,
                InClubTable.Cols.CLUBID + " = ? AND " + InClubTable.Cols.STUDENTID + " = ?",
                new String[]{inClub.getClubId().toString(), inClub.getStudentId()});
    }



    private InClubCursorWrapper queryInClubs(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                InClubTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new InClubCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(InClub inClub) {
        ContentValues values = new ContentValues();
        values.put(UUID, inClub.getId().toString());
        values.put(CLUBID, inClub.getClubId().toString());
        values.put(STUDENTID, inClub.getStudentId());

        return values;
    }
}
