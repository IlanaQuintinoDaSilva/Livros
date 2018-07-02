package br.com.ilanadev.livros.activity.login

import android.annotation.SuppressLint
import br.com.ilanadev.livros.R
import br.com.ilanadev.livros.domain.api.login.LoginService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter(val view: LoginView){

    @SuppressLint("CheckResult")
    fun onOnclickLogin(login:String, senha:String){
        if(login.isEmpty()){
            view.setError(R.string.msg_login_is_required)
            return
        }
        view.showProgress()

        LoginService.login(login,senha)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ response ->
                    if (response.isOk()) {
                        view.loginOk()
                    } else {
                        view.alerta(response.msg)
                    }
                }
    }
}