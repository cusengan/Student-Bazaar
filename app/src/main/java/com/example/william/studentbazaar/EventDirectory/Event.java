package com.example.william.studentbazaar.EventDirectory;

import java.util.UUID;

public class Event {

    private UUID mId;
    private String ownerId;
    private String mName;
    private String mDescription;
    private boolean onDisplay;

    public Event() {
        this(UUID.randomUUID());
    }

    public Event(UUID id) {
        mId = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setId(UUID id){
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

    public boolean onDisplay() {
        return onDisplay;
    }

    public void setDisplay(boolean display) {
        this.onDisplay = display;
    }
}
