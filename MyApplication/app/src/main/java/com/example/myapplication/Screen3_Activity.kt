package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_screen3.*
import android.content.Intent
import kotlinx.android.synthetic.main.activity_screen5.*

class Screen3_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen3)

        // creating a DBHelper class
        // and passing context to it
        val db = DBHelper(this, null)

        val arrayAdapter: ArrayAdapter<*>
        var companys = listOf<String>("")

        // below is the variable for cursor
        // we have called method to get
        // all names from our database
        // and add to name text view
        val cursor = db.getValues()

        // moving the cursor to first position and
        // appending value in the text view
        cursor!!.moveToFirst()
        companys += cursor.getString(cursor.getColumnIndex(DBHelper.COMPANY_NAME))

        // moving our cursor to next
        // position and appending values
        while(cursor.moveToNext()){
            companys += cursor.getString(cursor.getColumnIndex(DBHelper.COMPANY_NAME))
        }

        var mListView = findViewById<ListView>(R.id.list_item)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, companys)
        mListView.adapter = arrayAdapter

        // at last we close our cursor
        cursor.close()

        list_item.setOnItemClickListener { parent, view, position, id ->
            val element = arrayAdapter.getItem(position) // The item that was clicked
            val intent = Intent(this, Screen5_activity::class.java)
            //intent.putExtra(companyname, "element")
            startActivity(intent)
        }
    }

}