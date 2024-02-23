package com.kecerdasanbuatan.systempakar

class SistemPakar {
    private var jumlahGejala = 0
    private var gastritis = 0.0
    private var dispepsia = 0.0
    private var nGastritis = 0.0
    private var nDispepsia = 0.0

    fun konversi(gejala: String) {
        jumlahGejala++
        when (gejala) {
            "Perut kembung", "Mual", "Diare", "Muntah", "Nyeri perut",
            "Kembung", "Sering bersendawa", "Sering merasa lapar",
            "Kehilangan nafsu makan", "Sering buang gas" -> {
                gastritis++
                dispepsia++
            }
        }
    }

    fun getNGastritis(): Double {
        val awal = gastritis / 10.0
        val akhir = gastritis / jumlahGejala
        nGastritis = awal * akhir * 100
        return nGastritis
    }

    fun getNDispepsia(): Double {
        val awal = dispepsia / 10.0
        val akhir = dispepsia / jumlahGejala
        nDispepsia = awal * akhir * 100
        return nDispepsia
    }

    fun resetJumlahGejala() {
        jumlahGejala = 0
        gastritis = 0.0
        dispepsia = 0.0
    }
}
