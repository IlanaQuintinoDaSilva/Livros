package br.com.ilanadev.livros.activity.livro

import android.annotation.SuppressLint
import br.com.ilanadev.livros.domain.Livro
import br.com.ilanadev.livros.domain.api.livro.LivroService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LivroPresenter(val view: LivroView){
    @SuppressLint("CheckResult")
    fun taskCarros(){
        //view.showProgress()

        LivroService.listaLivros()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ livro ->
                    view.setLivros(livro)
                    //view.hideProgress()
                }

    }

    fun onClickCarro(livro: Livro) {
        view.alerta(livro.titulo)
    }
}