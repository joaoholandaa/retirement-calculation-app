package com.holandadev.retirementcalculation

import android.app.Activity
import android.os.Bundle
import android.widget.Spinner
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.ArrayAdapter

class MainActivity() : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val spinnerGender = findViewById<Spinner>(R.id.spinner_gender)
        val editTextAge = findViewById<EditText>(R.id.edit_text_age)
        val buttonCalculate = findViewById<Button>(R.id.button_calculate)
        val textViewResult = findViewById<TextView>(R.id.text_view_result)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("masculine", "feminine")
        )
        spinnerGender.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("masculine", "feminine"))
        spinnerGender.adapter = adapter

        buttonCalculate.setOnClickListener {
            val selectedGender = spinnerGender.selectedItem as String
            val age = editTextAge.text.toString().toInt()

            var result = 0
            if(selectedGender == "masculine") {
                result = 65 - age
            } else {
                result = 62 - age
            }
            textViewResult.text = "You have $result years left until retirement."
        }
    }

}