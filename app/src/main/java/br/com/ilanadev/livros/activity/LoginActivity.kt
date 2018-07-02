package br.com.ilanadev.livros.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.ilanadev.livros.R
import br.com.ilanadev.livros.activity.login.LoginPresenter
import br.com.ilanadev.livros.login.LoginView
import br.com.ilanadev.livros.domain.api.login.LoginService
import br.com.ilanadev.livros.extensions.setupToolbar

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class LoginActivity : AppCompatActivity() {
    private val presenter : LoginPresenter by lazy {
        LoginPresenter(view)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupToolbar(R.id.toolbar)

        btLogin.setOnClickListener { onClickLogin() }
    }


    private fun onClickLogin() {
        val login = tLogin.text.toString()
        val senha = tSenha.text.toString()

        presenter.onOnclickLogin(login, senha)

    }

    private val view = object:LoginView{
        override fun setError(msg: Int) {
            tLogin.error = getString(msg)
        }

        override fun alerta(msg: String) {
            toast(msg)
        }

        override fun showProgress() {
            progress?.visibility = View.VISIBLE
        }

        override fun loginOk() {
            startActivity<CarrosActivity>()
            finish()
        }
    }
}
