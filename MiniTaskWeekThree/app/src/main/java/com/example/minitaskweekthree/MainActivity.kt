package com.example.minitaskweekthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.widget.TextView
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val SECOND_ACTIVITY_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    // "Go to Second Activity" button click
    fun buttonClick1(view: View) {

        // Start the SecondActivity
        val intent = Intent(this, SecondActivity::class.java)
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
    }

    // "Kill the process
    fun finishActivityClick(view: View) {
        beybeyMessage.text="Going off in 5 sec"
        Handler(Looper.getMainLooper()).postDelayed({
            this.finish()
        }, 5000)
    }


    // This method is called when the second activity finishes
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                // Get String data from Intent
                val returnString = data!!.getStringExtra("keyName")

                // Set text view with string
                val textView = findViewById(R.id.textView) as TextView
                textView.text = returnString
            }
        }
    }
}