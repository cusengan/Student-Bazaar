package com.example.william.studentbazaar.User;

import java.util.UUID;

public class User {

    private UUID mId;
    private String mFirstName;
    private String mLastName;
    private String mStudentId;
    private String mPhoneNumber;
    private String mEmail;

    public User() {
        this(UUID.randomUUID());
    }

    public User(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getStudentId() {
        return mStudentId;
    }

    public void setStudentId(String mStudentId) {
        this.mStudentId = mStudentId;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
