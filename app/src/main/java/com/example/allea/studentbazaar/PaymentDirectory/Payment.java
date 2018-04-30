package com.example.allea.studentbazaar.PaymentDirectory;

import java.util.Date;
import java.util.UUID;

public class Payment {

    private  UUID mId;
    private String mName;
    private String mNumber;
    private String mExpiry;
    private String mSecurity;

    public Payment(){
        this(UUID.randomUUID());
    }

    public Payment(UUID id){
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getName(){
        return mName;
    }

    public void setName(String name){
       mName = name;
    }

    public String getExpiry() {
        return mExpiry;
    }

    public void setExpiry(String expiry) {
        mExpiry = expiry;
    }

    public String getNumber(){
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }

    public String getSecurity(){
        return mSecurity;
    }

    public void setSecurity(String security){
        mSecurity = security;
    }

}
