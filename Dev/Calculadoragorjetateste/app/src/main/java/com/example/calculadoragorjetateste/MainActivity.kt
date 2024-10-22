package com.example.calculadoragorjetateste

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoragorjetateste.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Btnclean: Button = findViewById(R.id.btn_clean)
        val Btncalculate: Button = findViewById(R.id.btn_calculate)
        val Totalamount: TextInputEditText = findViewById(R.id.tiet_amount)
        val Totalpeople: TextInputEditText = findViewById(R.id.tiet_people)
        val Percentageten: RadioButton = findViewById(R.id.rb_ten)
        val Percentagefifteen: RadioButton = findViewById(R.id.rb_fifteen)
        val Percentagetwenty: RadioButton = findViewById(R.id.rb_twenty)

    }
}