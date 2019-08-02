package com.example.android.pets.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class PetProvider extends ContentProvider {

    //create a global uri object
    //then inside a static block in which we should initialize all the possible values of
    //uri that the provider should recognise

    public static final int PETS=100;
    public static final int PET_ID=101;


    //UriMAtcher.NO_MATCH==-1 just for initialization since code <0 not allowed
    private static final UriMatcher sUriMatcher=new UriMatcher(UriMatcher.NO_MATCH);

    //initialize the static variables
    static {
        sUriMatcher.addURI(PetContract.PetEntry.CONTENT_AUTHORITY, PetContract.PetEntry.PETS_PATH,PETS);
        sUriMatcher.addURI(PetContract.PetEntry.CONTENT_AUTHORITY, PetContract.PetEntry.PETS_PATH + "/#",PETS);
    }

    //creating a global variable as it should cater all your functions
    PetDbHelper mDbHelper;

    @Override
    public boolean onCreate() {

        mDbHelper=new PetDbHelper(getContext());
        return true;
    }


    @Override
    public Cursor query(Uri uri,String[] projection,String selection,String[] selectionArgs,String sortOrder) {

        SQLiteDatabase db=mDbHelper.getReadableDatabase();

        Cursor cursor;

        int match=sUriMatcher.match(uri);

        switch (match) {
            case PETS:
                //TODO
                cursor = db.query(PetContract.PetEntry.TABLE_NAME, projection,selection,selectionArgs, null, null, null);
                break;
            case PET_ID:
                //TODO
                selection = PetContract.PetEntry._ID + "=?";

                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};

                cursor = db.query(PetContract.PetEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
                break;
            default:
                throw new IllegalArgumentException("cannot query unknown uri " + uri);
        }
        return cursor;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }


    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {


        final int match = sUriMatcher.match(uri);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        return ContentUris.withAppendedId(PetContract.PetEntry.CONTENT_URI,db.insert(PetContract.PetEntry.TABLE_NAME, null, values));
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
