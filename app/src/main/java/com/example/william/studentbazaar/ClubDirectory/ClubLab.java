package com.example.william.studentbazaar.ClubDirectory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.william.studentbazaar.database.ClubHelper;
import com.example.william.studentbazaar.database.ClubCursorWrapper;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.ClubTable;
import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.ClubTable.Cols.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ClubLab {
    private static ClubLab sClubLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ClubLab get(Context context) {
        if (sClubLab == null) {
            sClubLab = new ClubLab(context);
        }

        return sClubLab;
    }

    private ClubLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new ClubHelper(mContext)
                .getWritableDatabase();

    }

    public void addCrime(Club c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(ClubTable.NAME, null, values);
    }

    public List<Club> getClubs() {
        List<Club> clubs = new ArrayList<>();
        ClubCursorWrapper cursor = queryCrimes(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                clubs.add(cursor.getClub());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return clubs;
    }

    public Club getClub(UUID id) {
        ClubCursorWrapper cursor = queryCrimes(
                ClubTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getClub();
        } finally {
            cursor.close();
        }
    }


    public void updateCrime(Club club) {
        String uuidString = club.getId().toString();
        ContentValues values = getContentValues(club);
        mDatabase.update(ClubTable.NAME, values,
                ClubTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    private ClubCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ClubTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new ClubCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Club club) {
        ContentValues values = new ContentValues();
        values.put(UUID, club.getId().toString());
        values.put(NAME, club.getName());
        values.put(DESCRIPTION, club.getDescription());

        return values;
    }
}
