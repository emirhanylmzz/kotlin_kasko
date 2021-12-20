package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_screen2.*

class Screen2_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        val spinnerKurumTuru: Spinner = findViewById(R.id.kurumturu)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.kurum_turleri,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerKurumTuru.adapter = adapter
        }

        val spinnerAnlasmaTuru: Spinner = findViewById(R.id.anlasmaturu)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.anlasma_turleri,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerAnlasmaTuru.adapter = adapter
        }

        val anlasma_turu_value: String = spinnerAnlasmaTuru.getSelectedItem().toString()
        Log.i("tag", anlasma_turu_value);
        if(anlasma_turu_value.equals( "Süresiz" ))
        {
            anlasmasuresi.isEnabled = false

            Log.i("tag", "Süresiz");
        }
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
            db.addValuesKurum(c_name, website, mail_, telefon, tur, adres_, anlasmaturu_, anlasmasuresi_)

            // Toast to message on the screen
            Toast.makeText(this, "Kurum sisteme başarıyla eklendi", Toast.LENGTH_LONG).show()

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