package com.kecerdasanbuatan.systempakar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kecerdasanbuatan.systempakar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val sistemPakar = SistemPakar()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDiagnosa.setOnClickListener {
            diagnosaPenyakit()
        }
    }

    private fun diagnosaPenyakit() {
        val checkBoxes = arrayOf(
            binding.perutKembungCheckBox,
            binding.mualCheckBox,
            binding.diareCheckBox,
            binding.muntahCheckBox,
            binding.nyeriPerutCheckBox,
            binding.kembungCheckBox,
            binding.bersendawaCheckBox,
            binding.merasaLaparCheckBox,
            binding.nafsuMakanCheckBox,
            binding.buangGasCheckBox
        )

        // Reset jumlah gejala pada setiap diagnosa
        sistemPakar.resetJumlahGejala()

        for (checkBox in checkBoxes) {
            if (checkBox.isChecked) {
                val gejala = checkBox.text.toString()
                sistemPakar.konversi(gejala)
            }
        }

        val angkaGastritis = sistemPakar.getNGastritis()
        val angkaDispepsia = sistemPakar.getNDispepsia()

        val hasilDiagnosaTextView = binding.txtHasil
        hasilDiagnosaTextView.text = "Probabilitas penyakit\nGastritis: %.2f%%\nDispepsia: %.2f%%".format(angkaGastritis, angkaDispepsia)

        val penyakit = if (angkaGastritis > angkaDispepsia) "Gastritis" else "Dispepsia"
        hasilDiagnosaTextView.append("\n\nPenyakit yang memungkinkan: $penyakit")
    }




}
