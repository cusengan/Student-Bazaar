package com.example.william.studentbazaar.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.william.studentbazaar.database.DBHelper;
import com.example.william.studentbazaar.database.User.UserCursorWrapper;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema.UserTable;
import static com.example.william.studentbazaar.database.StudentBazaarDbSchema.UserTable.Cols.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserLab {
    private static UserLab sUserLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static UserLab get(Context context) {
        if (sUserLab == null) {
            sUserLab = new UserLab(context);
        }

        return sUserLab;
    }

    private UserLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DBHelper(mContext)
                .getWritableDatabase();
    }

    public void addUser(User u) {
        ContentValues values = getContentValues(u);
        mDatabase.insert(UserTable.NAME, null, values);
    }

    public List<User> getUsers() {
        List<User> Users = new ArrayList<>();
        UserCursorWrapper cursor = queryUsers(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Users.add(cursor.getUser());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return Users;
    }

    public User getUser(String id, String password) {
        String whereClause = String.format("%s = ? AND %s = ?", UserTable.Cols.STUDENTID, UserTable.Cols.PASSWORD);
        UserCursorWrapper cursor = queryUsers(whereClause, new String[]{id, password});
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getUser();
        } finally {
            cursor.close();
        }
    }

    public User getUser(UUID id) {
        UserCursorWrapper cursor = queryUsers(
                UserTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getUser();
        } finally {
            cursor.close();
        }
    }


    public void updateUser(User User) {
        String uuidString = User.getId().toString();
        ContentValues values = getContentValues(User);
        mDatabase.update(UserTable.NAME, values,
                UserTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    private UserCursorWrapper queryUsers(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                UserTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new UserCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(User user) {
        ContentValues values = new ContentValues();
        values.put(UUID, user.getId().toString());
        values.put(FIRSTNAME, user.getFirstName());
        values.put(LASTNAME, user.getLastName());
        values.put(STUDENTID, user.getStudentId());
        values.put(PHONENUMBER, user.getPhoneNumber());
        values.put(EMAIL, user.getEmail());
        values.put(PASSWORD, user.getPassword());

        return values;
    }
}
