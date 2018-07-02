package br.com.ilanadev.livros.domain.api.login

import br.com.ilanadev.livros.domain.Response
import br.com.ilanadev.livros.domain.RetrofitUtil
import io.reactivex.Observable




object LoginService {

    private const val url = "http://livrowebservices.com.br/rest/"

    private var api: LoginAPI
    init{
        api = RetrofitUtil.getRetrofit(url).create(LoginAPI::class.java)
    }

    fun login(login: String, senha: String): Observable<Response> {
        return api.login(login,senha)
//        val response = call.execute().body()
//        return response?: Response.error()
    }

//        val json = HttpHelper.postForm(url, "login" to login, "senha" to senha)
//        return fromJson(json)

}