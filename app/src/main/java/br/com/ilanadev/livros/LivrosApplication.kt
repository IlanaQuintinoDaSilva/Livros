package br.com.ilanadev.livros

import android.support.multidex.MultiDexApplication
import android.util.Log

class LivrosApplication : MultiDexApplication() {

    // Chamado quando o Android criar o processo do aplicativo
    override fun onCreate() {
        super.onCreate()
        // Salva a instância para termos acesso como Singleton
        appInstance = this
    }

    companion object {
        const val TAG = "LivrosApplication"

        // Singleton da classe Application
        private var appInstance: LivrosApplication? = null

        fun getInstance(): LivrosApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configure a classe de Application no AndroidManifest.xml")
            }
            return appInstance!!
        }
    }

    // Chamado quando o Android finalizar o processo do aplicativo
    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "LivrosApplication.onTerminate()")
    }
}
