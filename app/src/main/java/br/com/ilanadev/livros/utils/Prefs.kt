package br.com.ilanadev.livros.utils

import android.content.SharedPreferences
import br.com.ilanadev.livros.LivrosApplication

object Prefs {
    private const val PREF_ID = "carros"
    private fun prefs(): SharedPreferences {
        val context = LivrosApplication.getInstance().applicationContext
        return context.getSharedPreferences(PREF_ID, 0)
    }

    fun setInt(flag: String, valor: Int) = prefs().edit().putInt(flag, valor).apply()
    fun getInt(flag: String) = prefs().getInt(flag, 0)
    fun setString(flag: String, valor: String) = prefs().edit().putString(flag, valor).apply()
    fun getString(flag: String) = prefs().getString(flag, "")
}