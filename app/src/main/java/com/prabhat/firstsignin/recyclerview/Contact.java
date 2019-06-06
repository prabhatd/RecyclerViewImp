package com.prabhat.firstsignin.recyclerview;

import java.util.ArrayList;

public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String mName, boolean mOnline) {
        this.mName = mName;
        this.mOnline = mOnline;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public boolean ismOnline() {
        return mOnline;
    }

    public void setmOnline(boolean mOnline) {
        this.mOnline = mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContact){
        ArrayList<Contact> contacts = new ArrayList<>();

        for (int i=0;i<=numContact;i++){
            contacts.add(new Contact("Person "+ ++lastContactId,i<numContact/2));
        }
        return contacts;
    }
}
