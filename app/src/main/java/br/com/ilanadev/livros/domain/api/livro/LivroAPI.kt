package br.com.ilanadev.livros.domain.api.livro

import br.com.ilanadev.livros.domain.Livro
import io.reactivex.Observable
import retrofit2.http.GET

interface LivroAPI{
    @GET
    fun listaLivros(): Observable<List<Livro>>
}