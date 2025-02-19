package com.example.calculadoragorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoragorjeta.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0

        binding.rbTen.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 10
            }
        }
        binding.rbFifteen.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 15
            }
        }
        binding.rbTwenty.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                percentage = 20
            }
        }

        binding.btnClean.setOnClickListener {

        }

        binding.btnCalculate.setOnClickListener {
            val totalAmount: Float = binding.tieTotal.text.toString().toFloat()
            val nPeople: Float = binding.tieNumPeople.text.toString().toFloat()
        }
    }
}