package com.example.android.pets.data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import java.net.URI;

public final class PetContract {

    private PetContract(){};

    //..
    public static final class PetEntry implements BaseColumns{

        //..content authority
        public static final String CONTENT_AUTHORITY="com.example.android.pets";
        public static final String PETS_PATH="pets";
        public static final String PET_ID_PATH=PetEntry.TABLE_NAME+"/#";


        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PetEntry.PETS_PATH);

        //..random constants
        public final static int GENDER_UNKNOWN =0;
        public final static int GENDER_MALE =1;
        public final static int GENDER_FEMALE =2;


        //..fields
        public final static String _ID =BaseColumns._ID;
        public final static String COLUMN_PET_NAME ="name";
        public final static String COLUMN_PET_BREED ="breed";
        public final static String COLUMN_PET_GENDER ="gender";
        public final static String COLUMN_PET_WEIGHT ="weight";

        //.table name
        public final static String TABLE_NAME="pets";

        //..legit sql statements

        public static final String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL , "
                + PetEntry.COLUMN_PET_BREED + " TEXT , "
                + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL , "
                + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0 ); ";
    }

}
