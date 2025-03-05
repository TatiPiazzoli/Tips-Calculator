package com.example.calculadoragorjeta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoragorjeta.databinding.ActivityMainBinding
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

        binding.btnCalculate.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val nPeopleTemp = binding.tieNumPeople.text

            if (totalTableTemp?.isEmpty() == true ||
                nPeopleTemp?.isEmpty() == true
            ) {
                Snackbar.make (binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = nPeopleTemp.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable",totalTable )
                    putExtra("numPeople", nPeopleTemp)
                    putExtra("percentage", percentage)
                    putExtra("totalAmount", totalWithTips)
                }
                    startActivity(intent)
            }
        }

        binding.btnClean.setOnClickListener {
            binding.tieTotal.setText("")
            binding.tieNumPeople.setText("")
            binding.rbTen.isChecked = false
            binding.rbFifteen.isChecked = false
            binding.rbTwenty.isChecked = false

        }
    }
}