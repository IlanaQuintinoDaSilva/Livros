package br.com.ilanadev.livros.domain.api.login

import br.com.ilanadev.livros.domain.Response
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginAPI{

    @POST("login")
    @FormUrlEncoded
    fun login(@Field("login")login: String,
              @Field("senha")senha: String): Observable<Response>
}