package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val actionBar = supportActionBar

        actionBar!!.title = "Result"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val message:TextView = findViewById(R.id.result_text)
        val result = intent.getIntExtra("key", 0)
        message.text = result.toString()
    }
}