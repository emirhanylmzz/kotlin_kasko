package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given

        val query = ("CREATE TABLE " + TABLE_NAME + " (" + ID_COL + " INTEGER PRIMARY KEY, " + COMPANY_NAME + " TEXT," + WEBSITE + " TEXT," + EMAIL + " TEXT," +
                PHONE + " INTEGER," + STATE + " INTEGER," + COMPANY_TYPE +" TEXT," + DEAL_TYPE + " TEXT," + DEAL_TIME + " TEXT," + LOCATION + " TEXT,"+ LOCATION_INFO +
                " TEXT" + ")")

        // we are calling sqlite
        // method for executing our query
        db.execSQL(query)

        val query2 = ("CREATE TABLE " + TABLE_NAME_2 + " (" + ID_COL + " INTEGER PRIMARY KEY, " + PHONE + " INTEGER," + PLAKA + " TEXT," + ACCIDENT_TYPE +" TEXT,"
                + ACCIDENT_DATE + " TEXT," + ACCIDENT_INFO + " TEXT," + PHOTO + " TEXT,"+ YOL_YARDIMI +
                " INTEGER" + ")")

        db.execSQL(query2)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2)
        onCreate(db)
    }

    // This method is for adding data in our database
    fun addValuesKurum(company_name : String, website : String, email : String, phone : Int, state : Int, company_type: String, location: String , deal_Type: String, deal_time: String ){

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values
        // in the form of key-value pair
        values.put(COMPANY_NAME, company_name)
        values.put(WEBSITE, website)
        values.put(EMAIL, email)
        values.put(PHONE, phone)
        values.put(STATE, state)
        values.put(COMPANY_TYPE, company_type)
        values.put(DEAL_TYPE, deal_Type)
        values.put(DEAL_TIME, deal_time)
        values.put(LOCATION, location)
        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in our database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_NAME, null, values)

        // at last we are
        // closing our database
        db.close()
    }

    fun deleteValueKurum(company_name: String) {

        // on below line we are creating
        // a variable to write our database.
        val db = this.writableDatabase

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "company_name=?", arrayOf(company_name))
        db.close()
    }
    // below method is to get
    // all data from our database
    fun  getValuesKurum(): Cursor? {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null)

    }

    companion object{
        // here we have defined variables for our database

        // below is variable for database name
        private val DATABASE_NAME = "Odev"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

        // below is the variable for table name
        val TABLE_NAME = "Kurum"
        val TABLE_NAME_2 = "ARIZA"
        // below is the variable for id column
        val ID_COL = "id"
        val COMPANY_NAME = "company_name"
        val WEBSITE = "website"
        val EMAIL = "email"
        val PHONE = "phone_number"
        val STATE = "state"
        val COMPANY_TYPE = "company_type"
        val DEAL_TYPE = "deal_type"
        val DEAL_TIME = "deal_time"
        val LOCATION = "location"
        val LOCATION_INFO = "location_info"
        val PLAKA = "plaka"
        val ACCIDENT_TYPE = "accident_type"
        val ACCIDENT_DATE = "accident_date"
        val ACCIDENT_INFO = "accident_info"
        val PHOTO = "photo"
        val YOL_YARDIMI = "yol_yardimi"
    }
}
