package com.beny.radiotunisien;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c= null;


    public DatabaseAccess (Context context){
        this.openHelper = new DatabaseOpenHelper(context);

    }

    public static DatabaseAccess getInstance(Context context) {
        if(instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    public List<Radio> getList(){
        c=db.rawQuery("select * from 'radio_imgs' ;",new String[]{});
        List<Radio> radios = new ArrayList<>();
        while (c.moveToNext()) {
            Radio radioun = new Radio (c.getInt(c.getColumnIndex("id")),c.getString(c.getColumnIndex("name")),c.getString(c.getColumnIndex("img")),c.getString(c.getColumnIndex("COLNew")));
            radios.add(radioun);
        }

        return radios;

    }

}
