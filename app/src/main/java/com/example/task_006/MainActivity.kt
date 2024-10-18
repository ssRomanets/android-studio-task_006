package com.example.task_006

import kotlin.random.Random

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.ContextMenu
import android.view.View

import android.widget.EditText
import android.widget.Toast
import android.widget.Button

import android.text.Editable
import android.text.TextWatcher

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var randomDigitEx = false
    private var beginProgram  = true

    private lateinit var textET: EditText
    private lateinit var randomDigitButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textET = findViewById(R.id.textET)
        randomDigitButton = findViewById(R.id.randomDigitButton)

        registerForContextMenu(textET)

        onButtonClick(randomDigitButton)
    }

    fun onButtonClick(v: View) {
        if (beginProgram  == false) {
            randomDigitEx = true;
            textET.setText(Random.nextInt(1, 50).toString())
        }
        beginProgram = false;
    }

    override fun onCreateContextMenu (menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_color_quality -> {
                var mark = textET.text.toString().toInt();
                if (randomDigitEx == true)
                {
                    mark = mark/10;
                    randomDigitEx = false;
                    textET.setText("")
                };
                when (mark) {
                    1 -> {
                        textET.setBackgroundColor(0xFFFFA000.toInt())
                    }
                    2 -> {
                        textET.setBackgroundColor(0xFFF6F206.toInt())
                    }
                    3 -> {
                        textET.setBackgroundColor(0xFF00FF00.toInt())
                    }
                    4 -> {
                        textET.setBackgroundColor(0xFF0000FF.toInt())
                    }
                    5 -> {
                        textET.setBackgroundColor(0xFFFF0000.toInt())
                    }
                    else -> Toast.makeText(this, "Оценку невозможно определить", Toast.LENGTH_LONG).show()
                }
            }
            R.id.menu_exit_application -> {
                finish()
            }
            else -> return  super.onContextItemSelected(item)
        }
        return  true;
    }
}