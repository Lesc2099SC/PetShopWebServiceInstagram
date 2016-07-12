package com.example.administrador.petshopdatabase.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrador.petshopdatabase.dataset.PetCatalog;
import com.example.administrador.petshopdatabase.dataset.PictureCatalog;

import java.util.ArrayList;

/**
 * Created by Administrador on 08/07/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    Context context;
    public DataBaseHelper(Context context) {
        super(context, DBSettings.DATABASE_NAME, null, DBSettings.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreatePetCatalogTable = "CREATE TABLE "+ DBSettings.TABLE_NAME + "(" +
                DBSettings.TABLE_CATALOG_PET_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT,"  +
                DBSettings.TABLE_CATALOG_PET_NAME     + " TEXT,"  +
                DBSettings.TABLE_CATALOG_PET_LIKES      + " INTEGER,"  +
                DBSettings.TABLE_CATALOG_PET_DISLIKES    + " INTEGER,"  +
                DBSettings.TABLE_CATALOG_PET_PICTURE    + " INTEGER"  +
                ")";
        db.execSQL(queryCreatePetCatalogTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBSettings.TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<PetCatalog> getAllRecords(){
        ArrayList<PetCatalog>petCatalogs = new ArrayList<>();
        String queryAllContacts;
        queryAllContacts = "SELECT * FROM " + DBSettings.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor records = db.rawQuery(queryAllContacts,null);

        while (records.moveToNext()){
            PetCatalog petCatalog = new PetCatalog( records.getInt(4),String.valueOf(records.getInt(3)),String.valueOf(records.getInt(2)), records.getString(1), String.valueOf(records.getString(0)));
                                      //PetCatalog(int intPetPicture, String strPetDisLikes, String strPetLikes, String strPetName, String strPetID)
            petCatalogs.add(petCatalog);
        }
        db.close();
        return petCatalogs;
    }

    public void addContacts(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DBSettings.TABLE_NAME,null,contentValues);
        db.close();
    }

    public boolean updateRecord(PetCatalog petCatalog){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBSettings.TABLE_CATALOG_PET_ID, Integer.parseInt( petCatalog.getStrPetID()));
        values.put(DBSettings.TABLE_CATALOG_PET_NAME, petCatalog.getStrPetName());
        values.put(DBSettings.TABLE_CATALOG_PET_LIKES, Integer.parseInt( petCatalog.getStrPetLikes()));

        //Updating
        db.update(DBSettings.TABLE_NAME, values, DBSettings.TABLE_CATALOG_PET_ID + " = ?",new String[] {  petCatalog.getStrPetID() });
        return true;

    }

    public ArrayList<PictureCatalog> getTopFive(){
        ArrayList<PictureCatalog>pictureCatalogs = new ArrayList<>();
        String queryAllContacts;
        queryAllContacts = "SELECT * FROM " + DBSettings.TABLE_NAME + " ORDER BY " + DBSettings.TABLE_CATALOG_PET_LIKES + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor records = db.rawQuery(queryAllContacts,null);
        int countFive = 0;

        while (records.moveToNext() ){

            countFive = countFive + 1;
            if(countFive <=5 && records.getInt(2) > 0){
                PictureCatalog pictureCatalog = new PictureCatalog(records.getInt(4), String.valueOf( records.getString(2) ), records.getString(1), records.getInt(0));
                //PictureCatalog(int intPetPicture, String strPetLikes, String strPetName, int intPicturePetID)
                pictureCatalogs.add(pictureCatalog);
            }
        }
        db.close();
        return pictureCatalogs;
    }
}
