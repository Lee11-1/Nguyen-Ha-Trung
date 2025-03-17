package com.example.ptb2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val text_1 = findViewById<EditText>(R.id.editTextNumber)
        val text_2 = findViewById<EditText>(R.id.editTextNumber2)
        val text_3 = findViewById<EditText>(R.id.editTextNumber3)
        val button = findViewById<Button>(R.id.button)
        val result = findViewById<TextView>(R.id.textView2)

        button.setOnClickListener{
            val a = text_1.text.toString().toDoubleOrNull()
            val b = text_2.text.toString().toDoubleOrNull()
            val c = text_3.text.toString().toDoubleOrNull()
            if (a==null || b==null || c==null ){
                result.text="nhap lai"
            }
            else{
                val s = solve(a,b,c)
                result.text = "$s"
            }
        }


    }
}


    private fun solve(a: Double, b: Double, c: Double): String {
        return if (a == 0.0) {
            if (b == 0.0) {
                if (c == 0.0) "Phương trình có vô số nghiệm" else "Phương trình vô nghiệm"
            } else {
                "Phương trình có một nghiệm: x = ${-c / b}"
            }
        } else {
            val delta = b * b - 4 * a * c
            when {
                delta > 0 -> {
                    val x1 = (-b + sqrt(delta)) / (2 * a)
                    val x2 = (-b - sqrt(delta)) / (2 * a)
                    "Phương trình có hai nghiệm phân biệt:\nx1 = $x1\nx2 = $x2"
                }
                delta == 0.0 -> {
                    val x = -b / (2 * a)
                    "Phương trình có nghiệm kép: x = $x"
                }
                else -> "Phương trình vô nghiệm"
            }
        }
    }
}