package com.example.homework10

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    private var editTextA: EditText? = null
    private var editTextB: EditText? = null
    private var editTextC: EditText? = null
    private var textViewX1: TextView? = null
    private var textViewX2: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) { // ax + b = c // x = (c-b)/a
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextA = findViewById(R.id.edit_text_a)
        editTextB = findViewById(R.id.edit_text_b)
        editTextC = findViewById(R.id.edit_text_c)
        textViewX1 = findViewById(R.id.text_view_x1)
        textViewX2 = findViewById(R.id.text_view_x2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> finish()
            R.id.x ->{
                Toast.makeText(this, "Equations", Toast.LENGTH_SHORT).show()
            }
            R.id.xx ->Toast.makeText(this, "Quadratic equations", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    private fun getDoubleValue(editText: EditText?): Double {
        if (editText!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Поля не могут быть пустыми", Toast.LENGTH_SHORT).show()
            return 0.0
        }
        return editText.text.toString().toDouble()
    }
    private fun result(editText: EditText?): Double {
        if (editText!!.text.toString().isEmpty()) {
            Toast.makeText(this, "Поля не могут быть пустыми", Toast.LENGTH_SHORT).show()
            return 0.0
        }
        return editText.text.toString().toDouble()
    }

    @SuppressLint("DefaultLocale", "SetTextI18n")
    fun click(view: View?) {
        val a = getDoubleValue(editTextA)
        val b = getDoubleValue(editTextB)
        val c = getDoubleValue(editTextC)
        val d = sqrt(b.pow(2) - 4 * a * b)
        if (d < 0) {
            textViewX1!!.text = "No solutions"
            textViewX2!!.text = "No solutions"
            Toast.makeText(this, "No solutions", Toast.LENGTH_SHORT).show()
        }
        else if (d == 0.0){
            val x = -b / (2 * a)
            textViewX1!!.text = String.format("%.2f", x)
            Toast.makeText(this, "x1 = $x", Toast.LENGTH_SHORT).show()
            textViewX2!!.text = "No solutions"
            Toast.makeText(this, "x2 = no solutions", Toast.LENGTH_SHORT).show()
        }
        else {
            val x = (-b + d) / (2 * a)
            textViewX1!!.text = String.format("%.2f", x)
            Toast.makeText(this, "x1 = $x", Toast.LENGTH_SHORT).show()
            val x2 = (-b - d) / (2 * a)
            textViewX2!!.text = String.format("%.2f", x2)
            Toast.makeText(this, "x2 = $x2", Toast.LENGTH_SHORT).show()
        }
    }
}