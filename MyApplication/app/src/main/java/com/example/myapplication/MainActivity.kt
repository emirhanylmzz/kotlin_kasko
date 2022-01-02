package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // below code is to add on click
        // listener to our add name button
        button_liste.setOnClickListener{

            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DBHelper(this, null)
            val intent = Intent(this, Screen3_Activity::class.java)
            startActivity(intent)
            // creating variables for values
            // in name and age edit texts
            //val name = enterName.text.toString()
            //val age = enterAge.text.toString()

            // calling method to add
            // name to our database
            //db.addName(name, age)

            // Toast to message on the screen
            //Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            //enterName.text.clear()
            //enterAge.text.clear()
        }

        button_ekle.setOnClickListener{
            val intent = Intent(this, Screen2_Activity::class.java)
            startActivity(intent)
        }

        button_remove.setOnClickListener{
            val intent = Intent(this, screen4_activity::class.java)
            startActivity(intent)
        }
        talep_olustur.setOnClickListener{
            val intent = Intent(this, com.example.myapplication.talep_olustur::class.java)
            startActivity(intent)
        }

        // below code is to add on click
        // listener to our print name button
        /*printName.setOnClickListener{
 
            // creating a DBHelper class
            // and passing context to it
            val db = DBHelper(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getName()

            // moving the cursor to first position and
            // appending value in the text view
            cursor!!.moveToFirst()
            Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
            Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")

            // moving our cursor to next
            // position and appending values
            while(cursor.moveToNext()){
                Name.append(cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
                Age.append(cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
            }

            // at last we close our cursor
            //cursor.close()
        }*/
    }
}

