package com.project.mediaaluno

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.project.mediaaluno.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val imm:InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        binding.btnCalcular.setOnClickListener() {

            val nota1 = Integer.parseInt(binding.edtNota1.text.toString())
            val nota2 = Integer.parseInt(binding.edtNota2.text.toString())
            val faltas = Integer.parseInt(binding.edtFalta.text.toString())
            val media = (nota1 + nota2) / 2

            val result = binding.txResult

            if (media >= 6 && faltas <= 10) {
                result.setText("Aluno aprovado!"
                        + "\n"
                        + "Media: $media"
                        + "\n"
                        + "Faltas: $faltas")
                result.setTextColor(Color.GREEN)
            } else {
                result.setText("Aluno reprovado!" + "\n" + "Media: $media" + "\n" + "Faltas: $faltas")
                result.setTextColor(Color.RED)
            }
            imm.hideSoftInputFromWindow(binding.btnCalcular.windowToken,0)
        }
    }
}