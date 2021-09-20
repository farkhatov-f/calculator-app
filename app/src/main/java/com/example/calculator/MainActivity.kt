package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener { //LIFE CYCLE - LENGTH OF ONE INTENT
    private var r = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.add_button)
        addButton.setOnClickListener(this)
        val subButton: Button = findViewById(R.id.sub_button)
        subButton.setOnClickListener(this)
        val multiButton: Button = findViewById(R.id.multiply_button)
        multiButton.setOnClickListener(this)
        val divButton: Button = findViewById(R.id.div_button)
        divButton.setOnClickListener(this)

        val calculate: Button = findViewById(R.id.calculate_button)
        calculate.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("key", r)
            startActivity(intent)
        }
    }

    override fun onClick(v: View) {
        val num1 = findViewById<EditText>(R.id.number_first).text.toString().toInt()
        val num2 = findViewById<EditText>(R.id.number_second).text.toString().toInt()
        val operator: TextView = findViewById(R.id.operator_text)
        when (v.id) {
            R.id.add_button -> {
                operator.text = "+"
                r = num1 + num2
            }
            R.id.sub_button -> {
                operator.text = "-"
                r = num1 - num2
            }
            R.id.multiply_button -> {
                operator.text = "*"
                r = num1 * num2
            }
            R.id.div_button -> {
                if (num2 != 0) {
                    operator.text = "/"
                    r = num1 / num2
                } else {
                    Toast.makeText(this, "Don't you dare...", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

//private fun showToastMessage() {
//    Toast.makeText(this, "Please, specify the number", Toast.LENGTH_SHORT).show()
//}

