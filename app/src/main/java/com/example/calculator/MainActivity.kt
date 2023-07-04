package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var textEdit1: EditText? = null
    private var textEdit2: EditText? = null
    private var text_equal: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textEdit1 = findViewById(R.id.text_edit1)
        textEdit2 = findViewById(R.id.text_edit2)
        text_equal = findViewById(R.id.text_equal)
        val buttonPlus = findViewById<Button>(R.id.button_plus)
        val buttonMinus = findViewById<Button>(R.id.button_minus)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonDivision = findViewById<Button>(R.id.button_division)
        val buttonClose = findViewById<Button>(R.id.button_close)
        buttonPlus.setOnClickListener { calculate('+') }
        buttonMinus.setOnClickListener { calculate('-') }
        buttonMultiply.setOnClickListener { calculate('*') }
        buttonDivision.setOnClickListener { calculate('/') }
        buttonClose.setOnClickListener {
            finish()
            System.exit(0)
        }
    }

    private fun calculate(operator: Char) {
        val number1 = textEdit1!!.text.toString()
        val number2 = textEdit2!!.text.toString()
        if (!number1.isEmpty() && !number2.isEmpty()) {
            val num1 = number1.toDouble()
            val num2 = number2.toDouble()
            var result = 0.0
            when (operator) {
                '+' -> result = num1 + num2
                '-' -> result = num1 - num2
                '*' -> result = num1 * num2
                '/' -> if (num2 != 0.0) {
                    result = num1 / num2
                } else {
                    Toast.makeText(this@MainActivity, "Cannot divide by zero", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            text_equal!!.text = result.toString()
        }
    }
}