package com.mahimer.leania.mahimerleaniape2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBName = "prac2.db";
    final static int ver = 1;
    Cursor rs;
    final static String table = "details";

    public DBHelper(Context context) {
        super(context, DBName, null, ver);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cTable = "CREATE TABLE details (ID INTEGER PRIMARY KEY AUTOINCREMENT, Fname TEXT, Age INTEGER, Gender TEXT)";
        db.execSQL(cTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dTable = "DROP TABLE IF EXISTS details";
        db.execSQL(dTable);
        onCreate(db);
    }

    public boolean insert(String fname, int age, String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Fname", fname);
        cv.put("Age", age);
        cv.put("Gender", gender);
        long inserted = db.insert(table, null, cv);
        if (inserted == -1){
            return false;
        } else return true;
    }

    public Cursor selectRecord(String fname){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM grade WHERE fname = ?", new String[] {fname + ""});
    }
}
