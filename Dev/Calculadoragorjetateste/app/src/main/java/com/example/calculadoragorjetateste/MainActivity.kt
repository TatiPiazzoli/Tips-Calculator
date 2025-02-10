package com.example.calculadoragorjetateste

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoragorjetateste.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalculate.setOnClickListener {

            val totalAmountTemp = binding.tietAmount.text
            val numPeopleTemp = binding.tietNumPeople.text
            val percentageTemp = binding.tietPercentage.text

            if (totalAmountTemp?.isEmpty() == true ||
                numPeopleTemp?.isEmpty() == true ||
                percentageTemp?.isEmpty() == true
            ) {

                Snackbar.make(binding.tietAmount, "Please fill in all fields", Snackbar.LENGTH_LONG)
                    .show()

            } else {

                val totalAmount: Float = totalAmountTemp.toString().toFloat()
                val people: Int = numPeopleTemp.toString().toInt()
                val percentage: Int = percentageTemp.toString().toInt()

                val totalTemp = totalAmount / people
                val tips = totalTemp * percentage / 100
                val totalTips = totalTemp + tips

                intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalAmount", totalAmount)
                    putExtra("numPeople", people)
                    putExtra("percentage", percentage)
                    putExtra("total", totalTips )
                }
                clean()
                startActivity(intent)
            }
        }

        binding.btnClean.setOnClickListener {
            clean()
        }
    }

    private fun clean(){
        binding.tietAmount.setText("")
        binding.tietNumPeople.setText("")
        binding.tietPercentage.setText("")
    }
}