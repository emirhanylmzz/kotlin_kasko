package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_screen3.*

class screen4_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen4)

        val db = DBHelper(this, null)

        val arrayAdapter: ArrayAdapter<*>
        var companys = listOf<String>("")
        var numberOfCheckBoxes = 0
        // below is the variable for cursor
        // we have called method to get
        // all names from our database
        // and add to name text view
        val cursor = db.getValuesKurum()

        // moving the cursor to first position and
        // appending value in the text view
        cursor!!.moveToFirst()
        companys += cursor.getString(cursor.getColumnIndex(DBHelper.COMPANY_NAME))
        numberOfCheckBoxes += 1
        // moving our cursor to next
        // position and appending values
        while(cursor.moveToNext()){
            companys += cursor.getString(cursor.getColumnIndex(DBHelper.COMPANY_NAME))
            numberOfCheckBoxes += 1
        }

        var mListView = findViewById<ListView>(R.id.list_item)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, companys)
        mListView.adapter = arrayAdapter

        // at last we close our cursor
        cursor.close()

        list_item.setOnItemClickListener { parent, view, position, id ->
            val element = arrayAdapter.getItem(position) // The item that was clicked
            if (element != null) {
                db.deleteValueKurum(element)
                val intent = Intent(this, screen4_activity::class.java)
                startActivity(intent)
            }
        }

    }
}
