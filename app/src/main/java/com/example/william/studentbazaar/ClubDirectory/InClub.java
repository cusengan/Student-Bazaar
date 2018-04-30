package com.example.william.studentbazaar.ClubDirectory;

import java.util.UUID;

public class InClub {

    private UUID mId;
    private UUID mClubId;
    private String mStudentId;


    public InClub() {
        this(UUID.randomUUID());
    }

    public InClub(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public UUID getClubId() {
        return mClubId;
    }

    public void setClubId(UUID clubId) {
        mClubId = clubId;
    }

    public String getStudentId() {
        return mStudentId;
    }

    public void setStudentId(String studentId) {
        this.mStudentId = studentId;
    }
}
