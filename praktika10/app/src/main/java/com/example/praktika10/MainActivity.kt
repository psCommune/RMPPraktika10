package com.example.praktika10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var edtU: EditText
    private lateinit var tw: TextView
    private lateinit var btnDel: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDel = findViewById(R.id.buttonDelete)
        btn = findViewById(R.id.button)
        edtU = findViewById(R.id.editTextTextPersonName)
        tw = findViewById(R.id.textView)
        val preferences = getSharedPreferences("str", MODE_PRIVATE)
        val edit = preferences.edit()
        tw.text = preferences.getString("str","why?").toString()
        if (preferences.contains("str")==true) {
            btn.isClickable = false
            edtU.isFocusable = false
            btnDel.setOnClickListener {
                edit.clear()
                tw.text = "Удалено"
                btn.isClickable = true
                edtU.isFocusable = true
                btn.setOnClickListener {
                    edit.putString("str", edtU.text.toString())
                    edit.apply()
                    tw.text = preferences.getString("str", "why?").toString()
                    btn.isClickable = false
                    edtU.isFocusable = false
                }
            }
        }
        else{
            btn.setOnClickListener {
                edit.putString("str", edtU.text.toString())
                edit.apply()
                tw.text = preferences.getString("str", "why?").toString()
                btn.isClickable = false
                edtU.isFocusable = false
            }
        }
    }
}