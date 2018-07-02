package br.com.ilanadev.livros.activity.login

interface LoginView{
    fun setError(msg: Int)
    fun alerta(msg: String)
    fun showProgress()
    fun loginOk()
}