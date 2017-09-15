package com.example.admin.fragmentsassigment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 9/14/2017.
 */

public class Database extends SQLiteOpenHelper {

    public static final String Database_Name = "DB";
    public static final int Database_Version = 2;
    public static final String Table_Name = "CelebritiesTBL";
    public static final String TAG = "SQLDATABASESQL";
    public static final String Column_Name = "Name";
    public static final String Column_Age = "Age";
    public static final String Column_Description = "Description";
    public static final String Column_ImgID = "ImgID";

    public Database(Context context) {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create = "CREATE TABLE "+Table_Name+" ("+Column_Name+" Text,"+Column_Age+" Integer,"+Column_ImgID+" Integer,"+Column_Description+" Text)";
        db.execSQL(Create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }

    public boolean InsertCelebrities(List<Celebritie> celebritiesList) {
        boolean Status = true;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        for (Celebritie C : celebritiesList) {
            ContentValues cv = new ContentValues();
            cv.put(Column_Name, C.getName());
            cv.put(Column_Age, C.getAge());
            cv.put(Column_ImgID, C.getImageID());
            cv.put(Column_Description, C.getDescription());
            long isSaved = sqLiteDatabase.insert(Table_Name, null, cv);
            if (isSaved < 0) {
                return false;
            }
        }
        return Status;
    }
    public List<Celebritie> getCelebritiesList() {

        List<Celebritie> celebritiesList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String query = "Select * FROM " + Table_Name;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Celebritie C = new Celebritie(cursor.getString(0),cursor.getInt(1),cursor.getInt(2),cursor.getString(3));
                celebritiesList.add(C);
            } while (cursor.moveToNext());
        }
        return celebritiesList;
    }
}
