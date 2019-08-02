package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class PetDbHelper extends SQLiteOpenHelper {


    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    public static final int DATABASE_VERSION=1;

    //DAIMM IT requires space on both sides of the text
    public static final String DATABASE_NAME =" shelter.db";

    public PetDbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        //this db instance comes from the params
        //cretes a new instance or returns the old database if already made...
        db.execSQL(PetContract.PetEntry.SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //at this instance we dont need this
    }
}
