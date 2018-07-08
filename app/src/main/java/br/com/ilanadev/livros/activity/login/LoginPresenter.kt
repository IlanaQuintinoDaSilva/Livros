package br.com.ilanadev.livros.activity.login

import br.com.ilanadev.livros.R

class LoginPresenter(val view: LoginView){

    fun onOnclickLogin(){
        view.alerta("logado")
    }
}