package com.example.william.studentbazaar;


import java.util.Date;
import java.util.UUID;

public class Club {

    private UUID mId;
    private String mName;
    private String mDescription;


    public Club() {
        this(UUID.randomUUID());
    }

    public Club(UUID id) {
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

}
