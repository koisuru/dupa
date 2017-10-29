package pl.koisuru.tududu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.TtsSpan;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-10-21.
 */

public class Baza extends SQLiteOpenHelper {

    private static final String DB_NAME = "pogoda.db";
    private static final int DB_VERSION = 2;
    private static final String pogotable = "pogoda";
    private static final String data = "data";
    private static final String opis = "opis";
    private static final String icon = "icon";
    private static final String temp = "temp";
    private static final String miasto = "miasto";

    public Baza(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Create_Table = "CREATE TABLE "  + pogotable + "(" + data + " TEXT," + opis + " TEXT," + temp + " REAL,"
                + miasto + " TEXT," + icon + " TEXT)";
        sqLiteDatabase.execSQL(Create_Table);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + pogotable);
        onCreate(sqLiteDatabase);
    }

    public void addRepo ( Pogoda pogo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(data, pogo.getData());
        values.put(opis, pogo.getOpis());
        values.put(icon, pogo.getIcon());
        values.put(temp, pogo.getTemp());
        values.put(miasto, pogo.getMiasto());

        db.insert(pogotable, null, values);
        db.close();
    }
    public List<Pogoda>getAllPogodas(){
        List<Pogoda> pogodas = new LinkedList<>();
        String selectQuery = "SELECT * FROM " + pogotable;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {

                Pogoda pogoda = new Pogoda();

                pogoda.setData(cursor.getString(0));
                pogoda.setOpis(cursor.getString(1));
                pogoda.setTemp(cursor.getDouble(2));
                pogoda.setMiasto(cursor.getString(3));
                pogoda.setIcon(cursor.getString(4));

            }
            while (cursor.moveToNext());
        }
        db.close();
        return pogodas;

    }
    public void clearRepos(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + pogotable);
        db.close();
    }
}
