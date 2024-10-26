package com.example.calculadoragorjetateste

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoragorjetateste.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
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

            val totalAmountTemp = binding.tietAmount.text
            val peopleTemp = binding.tietPeople.text

            if (totalAmountTemp?.isEmpty() == true ||
                peopleTemp?.isEmpty() == true
            ) {

                Snackbar.make(binding.tietAmount, "Please fill in all fields", Snackbar.LENGTH_LONG)
                    .show()

            } else {

                val totalAmount: Float = totalAmountTemp.toString().toFloat()
                val people: Int = peopleTemp.toString().toInt()

                val totalTemp = totalAmount / people
                val tips = totalTemp * percentage / 100
                val totalTips = totalTemp + tips
                binding.tvResult.text = "Total with tips:$totalTips"
            }
        }
    }
}