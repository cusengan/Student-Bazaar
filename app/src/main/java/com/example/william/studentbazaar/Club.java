package com.example.william.studentbazaar;


import java.util.Date;
import java.util.UUID;

public class Club {

    private UUID mId;
    private String mName;


    public Club() {
        this(UUID.randomUUID());
    }

    public Club(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

}
