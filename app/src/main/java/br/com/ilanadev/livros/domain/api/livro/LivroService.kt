package br.com.ilanadev.livros.domain.api.livro

import br.com.ilanadev.livros.domain.Livro
import br.com.ilanadev.livros.domain.RetrofitUtil

import io.reactivex.Observable

object LivroService {
    private const val BASE_URL = "http://localhost:51534/api/Livros/ListaLivros"

    private var api: LivroAPI
    init {
        api = RetrofitUtil.getRetrofit(BASE_URL).create(LivroAPI::class.java)
    }

    fun listaLivros(): Observable<List<Livro>> {
        return api.listaLivros()
    }

}