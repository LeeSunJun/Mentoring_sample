package testcom.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by root on 18. 1. 24.
 */

public class DBHandler {
    DBOpenHelper helper;
    SQLiteDatabase db;

    //Create DB
    public DBHandler(Context context) {
        helper = new DBOpenHelper(context, "tut.db",null,1);
    }

    //open DB
    public static DBHandler open(Context context) {
        return new DBHandler(context);
    }

    //close DB
    public void close() {
        db.close();
    }

    //insert data to DB
    public void insert_color(int id, int R, int G, int B) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("id",id);
        values.put("red",R);
        values.put("green",G);
        values.put("blue",B);

        db.insert("color",null,values);

        Log.d("insert","id : "+id);
    }

    //select data from DB
    public Cursor select_all(){
        db = helper.getReadableDatabase();
        Cursor c = db.query("color", null, null, null, null, null, null);

        while(c.moveToNext()) {
            Log.d("DB", "ID : " + c.getInt(c.getColumnIndex("id")) +
                    "   /R : " + c.getInt(c.getColumnIndex("red")) +
                    "   /G : " + c.getInt(c.getColumnIndex("green")) +
                    "   /B : " + c.getInt(c.getColumnIndex("blue")));
        }

        c = db.query("color", null, null, null, null, null, null);

        return c;
    }

    public Cursor select_id(int id) {
        db = helper.getReadableDatabase();
        Cursor c = db.query("color", null, null, null, null, null, null);

        c.moveToNext();

        while(c.getInt(c.getColumnIndex("id")) != id) {
            c.moveToNext();
        }

        return c;
    }

    public int countData() {
        db = helper.getReadableDatabase();

        Cursor c = db.query("color", null, null, null, null, null, null);

        return c.getCount();
    }

    //update data in DB
    public void update_R(int id, int R){
        db = helper.getWritableDatabase();

        db.execSQL("Update color set red = " + R + " where id = " + id);

        Log.d("DB", "update complete");
    }

    public void update_G(int id, int G){
        db = helper.getWritableDatabase();

        db.execSQL("Update color set green = " + G + " where id = " + id);

        Log.d("DB", "update complete");
    }

    public void update_B(int id, int B){
        db = helper.getWritableDatabase();

        db.execSQL("Update color set blue = " + B + " where id = " + id);

        Log.d("DB", "update complete");
    }

    //delete data from DB
    public void delete (int id) {
        db = helper.getWritableDatabase();
        db.delete("color","id=?",new String[]{String.valueOf(id)});

        Log.i("DB","Delete complete");
    }
}
