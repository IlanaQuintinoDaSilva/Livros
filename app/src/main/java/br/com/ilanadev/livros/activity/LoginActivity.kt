package br.com.ilanadev.livros.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.ilanadev.livros.R
import br.com.ilanadev.livros.activity.login.LoginPresenter
import br.com.ilanadev.livros.activity.login.LoginView
import br.com.ilanadev.livros.extensions.toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity(){
    private val presenter : LoginPresenter by lazy {
        LoginPresenter(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener { onClickLogin() }
    }

    private val view = object: LoginView{
        override fun alerta(msg: String) {
            toast(msg)
        }

        override fun loginOk() {
            startActivity<LivrosActivity>()
            finish()
        }
    }

    private fun onClickLogin() {
        presenter.onOnclickLogin()
    }
}
