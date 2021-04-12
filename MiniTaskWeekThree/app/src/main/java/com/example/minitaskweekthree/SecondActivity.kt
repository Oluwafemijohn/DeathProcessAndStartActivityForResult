package com.example.minitaskweekthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.EditText
import android.view.View


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    // "Send text back" button click
    fun buttonClick2(view: View) {

        // Get the text from the EditText
        val editText = findViewById(R.id.editText) as EditText
        val stringToPassBack = editText.text.toString()

        // Put the String to pass back into an Intent and close this activity
        val intent = Intent()
        intent.putExtra("keyName", stringToPassBack)
        setResult(Activity.RESULT_OK, intent)
        finish()

    }
}