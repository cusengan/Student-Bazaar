package com.example.william.studentbazaar.database.User;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.william.studentbazaar.ClubDirectory.Club;
import com.example.william.studentbazaar.User.User;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema;

import java.util.UUID;

public class UserCursorWrapper extends CursorWrapper {

    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public User getUser() {
        String uuidString = getString(getColumnIndex(StudentBazaarDbSchema.UserTable.Cols.UUID));
        String firstName = getString(getColumnIndex(StudentBazaarDbSchema.UserTable.Cols.FIRSTNAME));
        String lastName = getString(getColumnIndex(StudentBazaarDbSchema.UserTable.Cols.LASTNAME));
        String studentId = getString(getColumnIndex(StudentBazaarDbSchema.UserTable.Cols.STUDENTID));
        String email = getString(getColumnIndex(StudentBazaarDbSchema.UserTable.Cols.EMAIL));
        String phoneNumber = getString(getColumnIndex(StudentBazaarDbSchema.UserTable.Cols.PHONENUMBER));

        User user = new User(UUID.fromString(uuidString));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setStudentId(studentId);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        
        return user;
    }
}
