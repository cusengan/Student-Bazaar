package com.example.william.studentbazaar.TradingDirectory;

import java.util.UUID;

public class Item {

    private UUID mId;
    private String mName;
    private String mDescription;


    public Item() {
        this(UUID.randomUUID());
    }

    public Item(UUID id) {
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
