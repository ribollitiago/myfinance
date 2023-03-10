package com.tiagorb.myfinance.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table pessoas(nome TEXT primary key, email TEXT,senha TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists pessoas");
    }

    public void listDados(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT nome FROM pessoas", null);
    }

    public Boolean insertData(String nome, String email, String senha){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", nome);
        contentValues.put("email", email);
        contentValues.put("senha", senha);

        long result = MyDB.insert("pessoas", null, contentValues);

        if(result==-1)
            return false;
        else
            return true;
    }
    public Boolean updateData(String nome, String email, String senha){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", nome);
        contentValues.put("email", email);
        Cursor cursor = MyDB.rawQuery("Select * from pessoas where senha = ?", new String[]{senha});

        if(cursor.getCount()>0) {
            long result = MyDB.update("pessoas", contentValues, "senha=?", new String[]{senha});

            if (result == -1)
                return false;
            else
                return true;
        }else
            return false;
    }

    public Boolean deleteData(String nome){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from pessoas where nome = ?", new String[]{nome});

        if(cursor.getCount()>0) {
            long result = MyDB.delete("pessoas", "senha=?", new String[]{nome});

            if (result == -1)
                return false;
            else
                return true;
        }else
            return false;
    }

    public Cursor getData(){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from pessoas", null);
        return cursor;

    }

    public Boolean checkUserName(String nome){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from pessoas where nome = ?", new String[]{nome});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from pessoas where email = ?", new String[]{email});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkEmailPassword(String email, String senha){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from pessoas where email = ? and senha = ?", new String[]{email,senha});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
