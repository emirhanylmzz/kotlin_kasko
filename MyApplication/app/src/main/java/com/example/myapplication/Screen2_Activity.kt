package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_screen2.*
import android.widget.Toast
class Screen2_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        button_ekle.setOnClickListener{
            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DBHelper(this, null)
            // creating variables for values
            // in name and age edit texts
            val c_name = kurumadi.text.toString()
            val website = websitesi.text.toString()
            val mail_ = mail.text.toString()
            val telefon = phone.text.toString().toInt()
            val tur = 2//kurumturu.getSelectedItem().toString().toInt();
            val adres_ = adres.text.toString()

            val anlasmaturu_ = "aa"//anlasmaturu.getSelectedItem().toString()
            val anlasmasuresi_ = anlasmasuresi.text.toString()

            // calling method to add
            // name to our database
            db.addValues(c_name, website, mail_, telefon, tur, adres_, anlasmaturu_, anlasmasuresi_)

            // Toast to message on the screen
            Toast.makeText(this, c_name + " added to database", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            kurumadi.text.clear()
            websitesi.text.clear()
            mail.text.clear()
            phone.text.clear()
            //kurumturu.text.clear()
            adres.text.clear()
            //anlasmaturu.text.clear()
            anlasmasuresi.text.clear()


        }



    }

}